import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {  FormControl, Validators } from '@angular/forms';
import { jobSeeker } from '../models/jobSeeker';
import { JobSeekerService } from '../services/job-seeker.service';
import { RoutingService } from '../services/routing.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  // signupForm!:FormGroup
  hide = true;

  token:string="";
  username : FormControl;
  firstname: FormControl;
  lastname : FormControl;
  email : FormControl;
  phonenumber : FormControl;
  address : FormControl;
  password : FormControl;
  resume : FormControl;
 
  constructor( private _http:HttpClient, private router: RoutingService, private authenticatorService: UserService, private jSService: JobSeekerService) {
    this.username = new FormControl('',Validators.required);
    this.firstname = new FormControl('',Validators.required);
    this.lastname = new FormControl('',Validators.required);
    this.email = new FormControl('',[Validators.required, Validators.email]);
    this.phonenumber = new FormControl('',
    [
      Validators.required,
      Validators.pattern('^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$')
    ]);
    this.address = new FormControl('',Validators.required);
    this.password = new FormControl('',Validators.required);
    this.resume = new FormControl('',Validators.required);
   }

  ngOnInit(): void {
    const width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;

  }

  Space(event:any) {
    if(event.target.selectionStart === 0 && event.code === "Space") {
      event.preventDefault();
    }
  }

  // Method to create an user
  signUp(){
 
  let mydata = {
    "username" : this.username.value,
    "password": this.password.value,
    "role" : "jobSeeker"
  }

  if (/^\s*$/.test(mydata.username)){
    alert("Please enter a username.")
  }else if (/^\s*$/.test(mydata.password)) {
    alert("Please enter a password.")
  }else{
    // var usernameexists = this.
    this.authenticatorService.addnewUser(mydata).subscribe(
      (res:any) => {
        console.log("Sign Up Successful");
        let jsObj : jobSeeker = {
          "username" : this.username.value,
          "firstName" : this.firstname.value,
          "lastName" : this.lastname.value,
          "email" : this.email.value,
          "address" : this.address.value,
          "resume" : this.resume.value,
          "phoneNumber" : this.phonenumber.value,
        "applicationList" : []

        };
        this.jSService.registerJobSeeker(jsObj).subscribe (
          (res:any) => {
            console.log("registration successful");
            alert("Registration successful, please login now!");
          }
        )

        this.router.signIn();

      },
      (err:any) => {
        
        console.log(err);
        if(err.status == 409) {
          alert("Username already exists, please try a different username!")
        } else {
          alert("Signup unsuccessful")
        }

      }

    )
    }
  }

}
