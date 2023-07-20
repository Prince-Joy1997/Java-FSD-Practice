import { Component, DoCheck, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, DoCheck {
  displaymenu = false;
  displayemployer = false;
  displayjobseeker = false;
  displayadmin = false;
  displaylogout = false;
  displaylogin = false;
  currentrole: any;

  constructor(private service : UserService, private router : Router) { }
  ngDoCheck(): void {
    // if (this.router.url == "/login" || this.router.url == "/signup" ) {
    //   this.displaylogout = false;
    // }
    // else {
    //   this.displaylogout = true;
    // }
  }

  ngOnInit(): void {
    this.MenuDisplay();
  }
  MenuDisplay() {
  
    if(this.service.getToken()!=null) {
    this.currentrole = this.service.getRole();
    this.displayadmin = this.currentrole == 'admin';
    this.displayemployer = this.currentrole == 'employer';
    this.displayjobseeker = this.currentrole == 'jobSeeker';
    this.displaylogout = true;
    this.displaylogin = false;
    } else {
      this.displaylogout = false;
      this.displaylogin = true;

    }
  }

  onLogOut() {
    this.service.logOut();
  }
  onLogIn() {
    this.router.navigate(['login']);
  }
}
