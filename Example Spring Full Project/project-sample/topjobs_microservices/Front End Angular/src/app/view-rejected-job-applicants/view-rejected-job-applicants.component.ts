import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { jobSeeker } from '../models/jobSeeker';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';
import { ViewResumeDialogComponent } from '../view-resume-dialog/view-resume-dialog.component';

@Component({
  selector: 'app-view-rejected-job-applicants',
  templateUrl: './view-rejected-job-applicants.component.html',
  styleUrls: ['./view-rejected-job-applicants.component.css']
})
export class ViewRejectedJobApplicantsComponent implements OnInit {

  constructor(public dialog: MatDialog,private jobseekerservice : JobSeekerService,private jobservice : JobService) { }
//-----------------------------------------------------------


//-----------------------------------------------------------
RejectedList : jobSeeker[] = [];
searchText = "";

  ngOnInit(): void {
    this.jobseekerservice.viewAllRejectedJobSeekersByJobId(this.jobservice.getJobId()).subscribe(
      (res:any)=>
      {
        this.RejectedList = res; 
        console.log("RelectedList", this.RejectedList);
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

  OnSelect(username: any) {
    this.jobseekerservice.updateApplicationStatus(username, this.jobservice.getJobId(), "selected").subscribe(
      (res:any)=>{
        this.RejectedList = res;
        // this.ngOnInit();
        
      },
      (err:any)=>{
        console.log("Error while changing the Jobstatus"+ err);
      }
    )
    window.location.reload();
  }
}
