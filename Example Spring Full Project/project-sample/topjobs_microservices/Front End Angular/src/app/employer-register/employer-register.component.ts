import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { employer } from '../models/employer';
import { EmployerService } from '../services/employer.service';
import { RoutingService } from '../services/routing.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-employer-register',
  templateUrl: './employer-register.component.html',
  styleUrls: ['./employer-register.component.css']
})
export class EmployerRegisterComponent implements OnInit {
  // signupForm!:FormGroup
  token: string = "";
  username: FormControl;
  firstname: FormControl;
  lastname: FormControl;
  companyName: FormControl;
  email: FormControl;
  phoneNumber: FormControl;
  address: FormControl;
  password: FormControl;
  hide = true;

  constructor(private _http: HttpClient, private router: RoutingService, private authenticatorService: UserService, private employerService: EmployerService) {
    this.username = new FormControl('', 
    [
      Validators.required
    ])
    this.firstname = new FormControl('', Validators.required);
    this.lastname = new FormControl('', Validators.required);
    this.companyName = new FormControl('', Validators.required);
    this.email = new FormControl('',[Validators.required, Validators.email]);
    this.phoneNumber = new FormControl('', 
    [
      Validators.required,
      Validators.pattern('^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$')
    ])
    // 'message' : new FormControl(null, [Validators.required, Validators.minLength(10)]);
    this.address = new FormControl('', Validators.required);
    this.password = new FormControl('', Validators.required);

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
  signUp() {
    console.log("inside signup");
    let mydata = {
      "username": this.username.value,
      "password": this.password.value,
      "role": "employer"
    }

    if (/^\s*$/.test(mydata.username)){
      alert("Please enter a username.")
    }else if (/^\s*$/.test(mydata.password)) {
      alert("Please enter a password.")
    }else{
      this.authenticatorService.addnewUser(mydata).subscribe(
        (res: any) => {
          console.log("New user added");
          let empObj: employer = {
            "username": this.username.value,
            "firstname": this.firstname.value,
            "lastname": this.lastname.value,
            "email": this.email.value,
            "companyName": this.companyName.value,
            "phoneNumber": this.phoneNumber.value,
            "address": this.address.value,
            "accountStatus": false
          };

          this.employerService.registerEmployer(empObj).subscribe(
            (res: any) => {
              console.log("registration successful")
              alert("Registration successful, please login now!");
            }
          )
          this.router.signIn();
        },

        (err:any) => {
        
          console.log(err);
          if(err.status == 409) {
            alert("Username already exists")
          } else {
            alert("Signup unsuccessful")
          }
    
        }
    
      )
    }


  }

}
