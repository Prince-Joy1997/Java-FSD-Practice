import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogData } from '../employer/employer.component';
import { Job } from '../models/job';
import { JobService } from '../services/job.service';

@Component({
  selector: 'app-edit-jobdialog',
  templateUrl: './edit-jobdialog.component.html',
  styleUrls: ['./edit-jobdialog.component.css']
})
export class EditJobdialogComponent implements OnInit {

  constructor( public dialogRef: MatDialogRef<EditJobdialogComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: DialogData, private jobservice : JobService) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onOk(jobId : any,data : Job){
    // this.jobservice.updateJob(jobId, data).subscribe(
    //   (res:any)=>{
    //     console.log("Job Edited")
        
    //   },
    //   (err:any)=>{
    //     console.log("Error while editing the Job-----"+ err);
    //   })
  }
}
