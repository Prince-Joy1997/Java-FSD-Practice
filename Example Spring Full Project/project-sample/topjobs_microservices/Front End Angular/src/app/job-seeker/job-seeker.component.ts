import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { application } from '../models/application';
import { Job } from '../models/job';
import { jobSeeker } from '../models/jobSeeker';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-job-seeker',
  templateUrl: './job-seeker.component.html',
  styleUrls: ['./job-seeker.component.css']
})
export class JobSeekerComponent implements OnInit {

  jobs : Job[] = [];
  applications : application[] = [];
  hideAppliedJobs = false;
  searchText = "";
  constructor(private jobSeekerService : JobSeekerService, private jobService : JobService, 
    private snackBar: MatSnackBar, private userService : UserService) { }

  ngOnInit(): void {
    if (sessionStorage.getItem('shouldReloadHeader') == 'true'){
      sessionStorage.setItem('shouldReloadHeader', 'false');
      window.location.reload();
    }

    this.jobService.viewJobs().subscribe(
      (result : Job[]) => {
        this.jobs = result.filter(element => element.status == 'open').sort(
          (a:Job, b: Job) => {
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

    this.jobSeekerService.viewAllApplicationsByJobSeekerId(this.userService.getUsername()).subscribe(
      (result : application[]) => {
        this.applications = result;
      },
      (error : any) => {
        console.log(error);
        this.snackBar.open(error.error, "OK");
      }
     );
  }

  apply(jobID : String){
    let applicationToAdd : application = {
      jobID: jobID,
      status: 'pending'
    }
    this.jobSeekerService.addJobSeekerApplication(this.userService.getUsername(), applicationToAdd).subscribe(
      (result : application) => {
        this.snackBar.open("Applied", "OK", {
          duration: 3000
        });
        this.ngOnInit();
      },
      (error : any) => {
        console.log(error);
        this.snackBar.open(error.error, "OK" , {
          duration: 3000
        });
      }
    );
  }

  hasAppliedJob(jobID : String){
    if (this.applications.filter(element => element.jobID == jobID).length > 0) {
      return true;
    }else{
      return false;
    }
  }

  onClickhideAppliedJobs(){
    if (this.hideAppliedJobs == false){
      this.jobs = this.jobs.filter(jobItem => !this.hasAppliedJob(jobItem.jobId));
    }else{
      this.ngOnInit();
    }
  }
}
