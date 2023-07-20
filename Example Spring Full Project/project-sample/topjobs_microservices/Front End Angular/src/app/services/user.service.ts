import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RoutingService } from './routing.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private httpcli: HttpClient, private router : Router) { }

  GenerateTokenfromServer(data1: any): Observable<any> {
    return this.httpcli.post(environment.UserAuthenticationAPI + '/authenticate', data1)
      ;
  }

  storeToken(token: any) {
    sessionStorage.setItem("topjobspringtoken", token);
  }

  getToken(): any {
    return sessionStorage.getItem("topjobspringtoken");
  }

  addnewUser(data: any) {
    return this.httpcli.post(environment.UserAuthenticationAPI + '/registerUser', data);
  }

  storeUsername(username: any) {
    sessionStorage.setItem("username", username);
  }

  getUsername(): any {
    return sessionStorage.getItem("username");
  }

  storePassword(password: any) {
    sessionStorage.setItem("password", password);
  }
  getPassword(): any {
    return sessionStorage.getItem("password");
  }

  storeRole(role: any) {
    sessionStorage.setItem("role", role);
  }
  getRole(): any {
    return sessionStorage.getItem("role");
  }
  logOut () {
    sessionStorage.clear();
    sessionStorage.setItem('shouldReloadHeader', 'true');
    this.router.navigateByUrl('/login');
  }

}
