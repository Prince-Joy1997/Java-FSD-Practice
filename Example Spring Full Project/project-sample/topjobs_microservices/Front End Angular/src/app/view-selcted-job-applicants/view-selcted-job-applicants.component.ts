import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { jobSeeker } from '../models/jobSeeker';

import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';
import { ViewResumeDialogComponent } from '../view-resume-dialog/view-resume-dialog.component';

@Component({
  selector: 'app-view-selcted-job-applicants',
  templateUrl: './view-selcted-job-applicants.component.html',
  styleUrls: ['./view-selcted-job-applicants.component.css']
})
export class ViewSelctedJobApplicantsComponent implements OnInit {
//-----------------------------------------------------------
  
  //-----------------------------------------------------------

  constructor(public dialog: MatDialog,private jobseekerservice : JobSeekerService,private jobservice : JobService) { }
  
  selectedList : jobSeeker[] = [];
  searchText="";

  ngOnInit(): void {
    this.jobseekerservice.viewAllSelectedJobSeekersByJobId(this.jobservice.getJobId()).subscribe(
      (res:any)=>
      {
        this.selectedList = res;
        console.log("SelectedList", this.selectedList);
      }
    )
  }
  onViewResumeDialog(seekerdata : jobSeeker) : void {
    const dialogRef = this.dialog.open(ViewResumeDialogComponent, {
      width: 'auto',
      height:'auto',
      data: {idata : seekerdata}
    });

    dialogRef.afterClosed();
  }

 
  OnReject(username: any) {
    this.jobseekerservice.updateApplicationStatus(username, this.jobservice.getJobId(), "rejected").subscribe(
      (res:any)=>{
        this.selectedList = res;
       // this.ngOnInit();
        
      },
      (err:any)=>{
        console.log("Error while changing the Jobstatus"+ err);
      }
    )
    window.location.reload();
  }

//   onJobStatus(jobstatus : Job){
//     if(jobstatus.status == "open")
//       jobstatus.status = "closed";
//     else if(jobstatus.status == "closed")
//      jobstatus.status = "open";

//   this.jobservice.updateJobStatus(jobstatus.jobId,jobstatus.status).subscribe(
//     (res:any)=>{
//       console.log("Job Status changed")
//       this.joblist1.push(res);
//     },
//     (err:any)=>{
//       console.log("Error while changing the Jobstatus"+ err);

//     }
//   )

// }
}
