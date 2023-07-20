import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { jobSeeker } from '../models/jobSeeker';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';
import { ViewResumeDialogComponent } from '../view-resume-dialog/view-resume-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';

export interface DialogData {
  idata : jobSeeker;
}

@Component({
  selector: 'app-view-all-job-applicants',
  templateUrl: './view-all-job-applicants.component.html',
  styleUrls: ['./view-all-job-applicants.component.css']
})
export class ViewAllJobApplicantsComponent implements OnInit {

  AllseekerList : Array<jobSeeker> = [];

  ApplicantStatus = "";
  searchText = "";
  constructor(private jobseekerservice : JobSeekerService, private snackobj:MatSnackBar,private jobservice : JobService,public dialog: MatDialog) { }

  ngOnInit(): void {
    this.jobseekerservice.viewAllJobSeekersByJobId(this.jobservice.getJobId()).subscribe(
      (res:any)=>
      {
        this.AllseekerList = res;
        console.log("SelectedList", this.AllseekerList);
      }
    )
  }
  onViewResumeDialog(seekerdata : jobSeeker) : void {
    const dialogRef = this.dialog.open(ViewResumeDialogComponent, {
      width: 'auto',
      height:'auto',
      data: {idata : seekerdata}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
     // this.animal = result;
    });
  }
  

  OnStatusChange(username: String,jobstatus : String) {
    //this.jobseekerservice.updateApplicationStatus(username, this.jobservice.getJobId(),status);
    if(jobstatus == "pending" || jobstatus =="rejected")
    jobstatus = "selected";
    else if(jobstatus == "selected")
    jobstatus = "rejected";

    let jID : String = this.jobservice.getJobId();

   this.jobseekerservice.updateApplicationStatus(username, jID, jobstatus).subscribe(
    
    (res:any)=>{
     // this.AllseekerList = res;
      this.ngOnInit();
    },
    (err:any)=>{
      console.log("Error while changing the Jobstatus OnviewAllApplicant"+ err);
    }
    
   )
   window.location.reload();
   this.snackobj.open("Job Status", "Updated", {
    duration: 4000,
});
  }

  OnStatusChangeReject(username: String,jobstatus : String) {
    //this.jobseekerservice.updateApplicationStatus(username, this.jobservice.getJobId(),status);
    if(jobstatus == "pending" || jobstatus =="selected")
    jobstatus = "rejected";
    else if(jobstatus == "selected")
    jobstatus = "rejected";

    let jID : String = this.jobservice.getJobId();

   this.jobseekerservice.updateApplicationStatus(username, jID, jobstatus).subscribe(
    
    (res:any)=>{
     // this.AllseekerList = res;
      this.ngOnInit();
    },
    (err:any)=>{
      console.log("Error while changing the Jobstatus OnviewAllApplicant"+ err);
    }
    
   )
   window.location.reload();
   this.snackobj.open("Job Status", "Updated", {
    duration: 4000,
});
  }

  getApplicantStatus(uname : any) : any{

    let tempusername =  this.AllseekerList.filter(element => element.username == uname)[0];

    let app =  tempusername.applicationList?.filter(st => st.jobID == this.jobservice.getJobId())[0];

  return app.status;
    
      // this.jobseekerservice.viewJobSeeker(username).subscribe(
      //   (res: any)=>{
          
      //     this.ApplicantStatus = res.filter(ele => ele.username == username).applicationList.status
      //   },
      //   (err:any)=>{
      //     console.log("Error while getting the status"+ err);
      //   }
      // )
  }

}
