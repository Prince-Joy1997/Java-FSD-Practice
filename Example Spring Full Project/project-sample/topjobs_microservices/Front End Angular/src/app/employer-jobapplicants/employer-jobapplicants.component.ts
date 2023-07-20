import { Component, OnInit } from '@angular/core';
import { JobService } from '../services/job.service';
import { Job } from '../models/job';
import { RoutingService } from '../services/routing.service';
@Component({
  selector: 'app-employer-jobapplicants',
  templateUrl: './employer-jobapplicants.component.html',
  styleUrls: ['./employer-jobapplicants.component.css']
})
export class EmployerJobapplicantsComponent implements OnInit {

  joblist : Array<Job> = [];
  constructor(private jobservice : JobService, private routeservice : RoutingService) { }

  displayedColumns: string[] = ['jobId', 'title', 'location','postedDate','status',];
  ngOnInit(): void {
  }

  ViewAllJobApplicants(){
    this.routeservice.openViewAllJobApplicants();
  }

  ViewSelctedJobApplicants(){
    this.routeservice.openViewSelctedJobApplicants();
  }

  ViewRejectedJobApplicants(){
    this.routeservice.openViewRejectedJobApplicants();
  }
}
