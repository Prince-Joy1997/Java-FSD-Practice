import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { RoutingService } from '../services/routing.service';
import { UserService } from '../services/user.service';

@Injectable({
  providedIn: 'root'
})
export class TopJobsGuard implements CanActivate {

  constructor(private router: RoutingService, private authenticatorService: UserService) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let path = route.url.toString();
    let jwtToken = this.authenticatorService.getToken();
    let role = this.authenticatorService.getRole();

    if (jwtToken == null ) {
      this.router.signIn();
      return false;
    }else{    
      if (path == "jobseeker" || path == "jobseekerappliedjobs") {
        if (role == "jobSeeker"){
          return true;
        }else{
          this.router.accessdenied();
          return false;
        }
      }else if (path == "employer" || path == "employerjobapplicants" || path == "ViewAllJobApplicants" || 
                path == "ViewSelctedJobApplicants" || path == "ViewRejectedJobApplicants"){
        if (role == "employer"){
          return true;
        }else{
          this.router.accessdenied();
          return false;
        }
      }else if (path == "employerAdmin" || path == "jobSeekerAdmin"){
        if (role == "admin"){
          return true;
        }else{
          this.router.accessdenied();
          return false;
        }
      }else{
        this.router.home();
        return false;
      }
    }
  }
}


