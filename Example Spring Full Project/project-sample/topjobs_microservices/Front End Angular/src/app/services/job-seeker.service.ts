import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { application } from '../models/application';
import { jobSeeker } from '../models/jobSeeker';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class JobSeekerService {
  constructor(private httpClient : HttpClient, private userService : UserService) { }

  registerJobSeeker(jobSeekerToRegister : jobSeeker) : Observable<jobSeeker> {
    return this.httpClient.post<jobSeeker>(environment.jobSeekerAPI + "/registerJobSeeker", jobSeekerToRegister, {
      headers: new HttpHeaders().set("Content-Type","application/json")
    });
  }

  viewAllJobSeekers() : Observable<jobSeeker[]> {
    return this.httpClient.get<jobSeeker[]>(environment.jobSeekerAPI + "/viewAllJobSeekers", {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  viewJobSeeker(jobSeekerID : String) : Observable<jobSeeker> {
    return this.httpClient.get<jobSeeker>(environment.jobSeekerAPI + `/viewJobSeeker/${jobSeekerID}`, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  updateJobSeeker(updatedJobSeeker : jobSeeker) : Observable<jobSeeker> {
    return this.httpClient.put<jobSeeker>(environment.jobSeekerAPI + "/updateJobSeeker", updatedJobSeeker, {
      headers: new HttpHeaders().set("Content-Type","application/json")
                                .set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  updateJobSeekerResume(jobSeekerID : String, updatedResume : String) : Observable<jobSeeker> {
    return this.httpClient.put<jobSeeker>(environment.jobSeekerAPI + `/updateJobSeekerResume/${jobSeekerID}`, updatedResume, {
      headers: new HttpHeaders().set("Content-Type","text/plain")
                                .set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  deleteJobSeeker(jobSeekerID : String) : Observable<String> {
    return this.httpClient.delete<String>(environment.jobSeekerAPI + `/deleteJobSeeker/${jobSeekerID}`, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  addJobSeekerApplication(jobSeekerID : String, applicationToAdd : application) : Observable<application> {
    return this.httpClient.post<application>(environment.jobSeekerAPI + `/addJobSeekerApplication/${jobSeekerID}`, applicationToAdd, {
      headers: new HttpHeaders().set("Content-Type","application/json")
                                .set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  viewAllApplicationsByJobSeekerId(jobSeekerID : String) : Observable<application[]> {
    return this.httpClient.get<application[]>(environment.jobSeekerAPI + `/viewAllApplicationsByJobSeekerId/${jobSeekerID}`, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  viewAllJobSeekersByJobId(jobID : String) : Observable<jobSeeker[]> {
    return this.httpClient.get<jobSeeker[]>(environment.jobSeekerAPI + `/viewAllJobSeekersByJobId/${jobID}`, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  viewAllSelectedJobSeekersByJobId(jobID : String) : Observable<jobSeeker[]> {
    return this.httpClient.get<jobSeeker[]>(environment.jobSeekerAPI + `/viewAllSelectedJobSeekersByJobId/${jobID}`, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  viewAllRejectedJobSeekersByJobId(jobID : String) : Observable<jobSeeker[]> {
    return this.httpClient.get<jobSeeker[]>(environment.jobSeekerAPI + `/viewAllRejectedJobSeekersByJobId/${jobID}`, {
     headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  updateApplicationStatus (jobSeekerID : String, jobID : String, status : String) : Observable<String> {
    return this.httpClient.put<String>(environment.jobSeekerAPI + `/updateApplicationStatus/${jobSeekerID}/${jobID}/${status}`, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }
}
