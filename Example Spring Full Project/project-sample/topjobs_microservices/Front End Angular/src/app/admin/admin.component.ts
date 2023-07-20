import { jobSeeker } from './../models/jobSeeker';
import { Component, OnInit } from '@angular/core';
import { JobSeekerService } from '../services/job-seeker.service';
import { RoutingService } from '../services/routing.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  seekerList : jobSeeker[] = [];
  displayedColumns: string[] = ['firstName', 'lastName','email','address','phoneNumber']

  constructor(private jobseekerservice : JobSeekerService, private routeservice : RoutingService) { }

  ngOnInit(): void {
    this.jobseekerservice.viewAllJobSeekers().subscribe(
      (res:jobSeeker[])=>
      {
        this.seekerList = res;
        console.log("SelectedList", this.seekerList);
      }
    )
  }
}
