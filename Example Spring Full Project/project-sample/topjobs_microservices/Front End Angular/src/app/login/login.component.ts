import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { RoutingService } from '../services/routing.service';
import { UserService } from '../services/user.service';

interface User {
  value: string;
  viewValue: string;
}



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  // signinform!:FormGroup;
  hide = true;
  errmessage: string = "";
  token: String = "";


   username : FormControl;
   password : FormControl;
   role : String="jobSeeker";

  users: User[] = [
    {value: 'admin', viewValue: 'Admin'},
    {value: 'employer', viewValue: 'Employer'},
    {value: 'jobSeeker', viewValue: 'Job Seeker'},
  ];

  selectedUser = this.users[2].value;

  constructor(private authenticatorService: UserService, private _http: HttpClient, private router: RoutingService, private routers : Router ) {
    this.username = new FormControl('', Validators.required);
    this.password = new FormControl('', Validators.required);
  }

  ngOnInit(): void {
    const width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    
    if (sessionStorage.getItem('shouldReloadHeader') == 'true'){
      sessionStorage.setItem('shouldReloadHeader', 'false');
      window.location.reload();
    }
  }

  // Method to login the user
  signIn() {
    let mydata = {
      "username": this.username.value,
      "password": this.password.value,
      "role": this.role

    }

    console.log(mydata);
    this.authenticatorService.GenerateTokenfromServer(mydata).subscribe(
      (result: any) => {
        this.token = result['token'];
        this.authenticatorService.storeToken(this.token);
        this.authenticatorService.storeUsername(this.username.value);
        this.authenticatorService.storeRole(this.role);
        // window.location.reload();

        if(this.role == "jobSeeker") {
          sessionStorage.setItem('shouldReloadHeader', 'true');
          this.router.jobSeeker();
        }else if(this.role == "admin") {
          sessionStorage.setItem('shouldReloadHeader', 'true');
          this.router.admin();
        }else if(this.role == "employer") {
          sessionStorage.setItem('shouldReloadHeader', 'true');
          this.router.employer();
        }
      },
     
      (err:any) => {
      
        console.log(err);
        if(err.status == 409) {
          alert("Username or Password is wrong, please try again")
        } else {
          alert("Login unsuccessful")
        }
  
      }
    );

  }
  roleSelect(userRole: any) {
    this.role = userRole;
  }

}
