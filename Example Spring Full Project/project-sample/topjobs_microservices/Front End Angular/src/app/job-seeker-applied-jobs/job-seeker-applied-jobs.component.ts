import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { application } from '../models/application';
import { Job } from '../models/job';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-job-seeker-applied-jobs',
  templateUrl: './job-seeker-applied-jobs.component.html',
  styleUrls: ['./job-seeker-applied-jobs.component.css']
})
export class JobSeekerAppliedJobsComponent implements OnInit {
  applications : application[] = [];
  jobs : Job[] = [];
  joinedArray : any[] = [];
  searchText = "";
  displayedColumns: string[] = ['title', 'employerId', 'location', 'postedDate', 'status'];

  constructor(private jobSeekerService : JobSeekerService, private jobService : JobService, private snackBar: MatSnackBar, private userService : UserService) { }

  ngOnInit(): void {
    this.jobSeekerService.viewAllApplicationsByJobSeekerId(this.userService.getUsername()).subscribe(
      (result : application[]) => {
        this.applications = result;

        this.applications.forEach(element => {
          this.jobService.viewJob(element.jobID).subscribe(
            (result : Job) => {
              this.jobs.push(result);
              this.joinedArray = this.jobs.map(x => Object.assign(x, this.applications.find(y => y.jobID == x.jobId)));
              this.joinedArray.sort(
                (a:any, b: any) => {
                  if (a.postedDate < b.postedDate){
                    return 1;
                  }else{
                    return -1;
                  }
                }
              );
            },
            (error : any) => {
              console.log(error);
            }
          );
        });
      },
      (error : any) => {
        console.log(error);
      }
    );
   }
}
