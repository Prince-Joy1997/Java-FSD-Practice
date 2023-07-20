import { UserService } from './../services/user.service';
import { EmployerService } from './../services/employer.service';
import { employer } from './../models/employer';
import { Component, OnInit } from '@angular/core';
import { RoutingService } from '../services/routing.service';


@Component({
  selector: 'app-employer-admin',
  templateUrl: './employer-admin.component.html',
  styleUrls: ['./employer-admin.component.css']
})
export class EmployerAdminComponent implements OnInit {

  employerExample: employer[] = [];
  displayedColumns:string[] = ['companyName', 'firstname','lastname', 'email', 'phoneNumber', 'address', 'accountStatus', 'changeStatus'];


  emplist : Array<employer> = [];

  constructor(private empservice : EmployerService, private routeservice : RoutingService, private userservice : UserService) { }

  ngOnInit(): void {
    
    if (sessionStorage.getItem('shouldReloadHeader') == 'true'){
      sessionStorage.setItem('shouldReloadHeader', 'false');
      window.location.reload();
    }

    this.empservice.viewAllEmployer().subscribe(
      (res:any)=>
      {
        this.employerExample = res;
        console.log("List selected", this.employerExample);
      }
    )
  }

  changeStatus(empstatus : employer){
    if(empstatus.accountStatus == true)
    empstatus.accountStatus = false;
    else if(empstatus.accountStatus == false)
     empstatus.accountStatus = true;

  this.empservice.updateAccountStatus(empstatus.username,empstatus.accountStatus).subscribe(
    (res:any)=>{
      console.log("Employer Status changed")
      //this.emplist.push(res);
      this.ngOnInit();
    },
    (err:any)=>{
      console.log("Error while changing the status"+ err);

    }
  )
}

}
