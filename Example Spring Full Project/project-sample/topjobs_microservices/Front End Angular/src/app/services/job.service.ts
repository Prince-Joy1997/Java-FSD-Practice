import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { Job } from '../models/job';
import { UserService } from './user.service';
@Injectable({
  providedIn: 'root'
})
export class JobService {
  constructor(private httpcli : HttpClient, private userService : UserService ) { }

  
  addJob(jobb : Job) : Observable<Job>{
    return this.httpcli.post<Job>(environment.JOBAPI+"/addJob", jobb,  {
      headers: new HttpHeaders().set("Content-Type","application/json")
                                .set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  viewJobs() : Observable<Job[]> {
    return this.httpcli.get<Job[]>(environment.JOBAPI +"/viewJobs", {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }

  updateJob(jobId : String, jobb :Job) : Observable<Job>
  {
    return this.httpcli.put<Job>(environment.JOBAPI+"/updateJobById/"+jobId.toString(), jobb, {
      headers: new HttpHeaders().set("Content-Type","application/json")
                                .set("Authorization","Bearer " + this.userService.getToken())
    });
  }
  removeJob(id: any) : Observable<any> {
    return this.httpcli.delete<Job>(environment.JOBAPI+"/deleteJob/"+id,{ headers: new HttpHeaders().set("Content-Type","application/json")
    .set("Authorization","Bearer " + this.userService.getToken())
});
  }

    //update a specific job /updateJobById
  updateJobById(jobId : any) : Observable<Job> {
    return this.httpcli.put<Job>(environment.JOBAPI + "/updateJobById/"+jobId, {
      headers: new HttpHeaders().set("Content-Type","application/json")
                                .set("Authorization","Bearer " + this.userService.getToken())
});
  }

  //update a job status /updateJobStatus/{jobId}/{status}
  updateJobStatus(jobId : any, status : any) : Observable<Job>{
    return this.httpcli.put<Job>(environment.JOBAPI + "/updateJobStatus/"+jobId+"/"+status, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
                                .set("Content-Type","application/json")
    });
  }

  storeJobId(jobId : any){
    sessionStorage.setItem("JobIdofEmployer",jobId)
  }
  
  getJobId() : any
  {
    return sessionStorage.getItem("JobIdofEmployer")
  }
  

  // get job by job id
  viewJob(jobId : String) : Observable<Job> {
    return this.httpcli.get<Job>(environment.JOBAPI + "/viewJobById/" + jobId, {
      headers: new HttpHeaders().set("Authorization","Bearer " + this.userService.getToken())
    });
  }
}
