import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogData } from '../view-all-job-applicants/view-all-job-applicants.component';


@Component({
  selector: 'app-view-resume-dialog',
  templateUrl: './view-resume-dialog.component.html',
  styleUrls: ['./view-resume-dialog.component.css']
})
export class ViewResumeDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ViewResumeDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
