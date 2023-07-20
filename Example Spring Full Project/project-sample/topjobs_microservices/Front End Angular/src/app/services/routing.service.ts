import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RoutingService {
  constructor(private router: Router) { }

  // isSignedIn = false;

  signIn() {
    // this.isSignedIn = true;
    this.router.navigate(['login']);
  }

  jobSeeker() {
    this.router.navigate(['jobseeker']);
  }

  admin() {
    this.router.navigate(['employerAdmin']);
  }
  
  employer() {
    this.router.navigate(['employer'])
  }
  employerViewJobApplicants(){
    this.router.navigate(['employerjobapplicants']);
  }

  openViewAllJobApplicants(){
    this.router.navigate(['employerjobapplicants/ViewAllJobApplicants']);
  }

  openViewSelctedJobApplicants(){
    this.router.navigate(['employerjobapplicants/ViewSelctedJobApplicants']);
  }

  openViewRejectedJobApplicants(){
    this.router.navigate(['employerjobapplicants/ViewRejectedJobApplicants']);
  }

  home() {
    this.router.navigate(['home']);
  }

  accessdenied () {
    this.router.navigate(['accessdenied']);
  }
  
}
