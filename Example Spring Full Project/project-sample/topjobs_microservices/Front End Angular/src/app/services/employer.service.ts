import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from './user.service';
import { environment } from 'src/environments/environment';
import { employer } from '../models/employer';


@Injectable({
  providedIn: 'root'
})
export class EmployerService {
  constructor(private httpcli : HttpClient, private userService : UserService) { }
  registerEmployer(emp : employer): Observable<employer>{
    return this.httpcli.post<employer>("http://localhost:8082/employer/registerEmployer", emp, {
      headers: new HttpHeaders().set("Content-Type","application/json")
});
  }

  viewAllEmployer(): Observable<employer>{
    return this.httpcli.get<employer>("http://localhost:8082/employer/viewAllEmployer", {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  viewEmployerById(username : any): Observable<employer>{
    return this.httpcli.get<employer>("http://localhost:8082/employer/viewEmployer/"+username, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  updateEmployer(username : any, emp :employer) : Observable<employer>{
    return this.httpcli.put<employer>("http://localhost:8082/employer/updateEmployer/"+username, emp, {
      headers: new HttpHeaders().set("Content-Type","application/json")
                                .set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  updateAccountStatus(username : any, accountStatus : any) : Observable<employer>{
    return this.httpcli.put<employer>("http://localhost:8082/employer/updateAccountStatus/"+username+"/"+accountStatus, {
      headers: new HttpHeaders().set("Content-Type","application/json")
                                .set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  deleteEmployer(username: any) : Observable<employer>{
    return this.httpcli.delete<employer>("http://localhost:8082/employer/deleteEmployer/"+username, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  viewEmployerBystatus(accountStatus:any) : Observable<employer>{
    return this.httpcli.get<employer>("http://localhost:8082/employer/viewEmployerBystatus/"+accountStatus, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }
}
