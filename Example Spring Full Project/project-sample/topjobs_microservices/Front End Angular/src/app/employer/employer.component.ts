import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Job } from '../models/job';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';
import { RoutingService } from '../services/routing.service';
import { EditJobdialogComponent } from '../edit-jobdialog/edit-jobdialog.component';
import { jobSeeker } from '../models/jobSeeker';
import { UserService } from '../services/user.service';
import { EmployerService } from '../services/employer.service';
import { empty } from 'rxjs';
import { employer } from '../models/employer';


export interface DialogData {
  idata : Job;
}

@Component({
  selector: 'app-employer',
  templateUrl: './employer.component.html',
  styleUrls: ['./employer.component.css']
})
export class EmployerComponent implements OnInit {


  dialogdata : any;
  jobpost : FormGroup;
  joblist : any;
  joblist1 : Array<Job> = [];
  templist : Array<any> = [];
  job : Job[] = [];

  EmployerStatus : boolean = true;

    searchText = "";

  displayedColumns: string[] = ['jobId', 'title', 'location','postedDate','status','Edit','ViewApplicants','Delete'];

  constructor(private jobservice : JobService, private snackobj:MatSnackBar,
              private routeservice : RoutingService, private userservice : UserService,
             private jobseekerservice : JobSeekerService, public dialog: MatDialog, public employerservice : EmployerService) {

      this.jobpost = new FormGroup({

      jobId : new FormControl('', Validators.required),
    //  employerId  :  new FormControl('', Validators.required),
      title : new FormControl('', Validators.required),
      location : new FormControl('', Validators.required),
      description : new FormControl('', Validators.required),
      status : new FormControl('', Validators.required)
    })
  }

  

  openDialog(jobdata : Job) : void {
    
    const dialogRef = this.dialog.open(EditJobdialogComponent, {
      width: "500px",
      height: "auto",
      data : {idata : jobdata}
    });

    dialogRef.afterClosed().subscribe(result => {
      
      console.log(result);
      let updatedjob : Job = result;
      console.log(updatedjob.jobId);
      this.jobservice.updateJob(updatedjob.jobId, updatedjob).subscribe(
        (res:any)=>{
          this.joblist1 = res;
          this.ngOnInit();
        },
        (err:any)=>{
          console.log("Error in pop up dialog"+err);
        }
      )

    });

}

  ngOnInit(): void {
        
    if (sessionStorage.getItem('shouldReloadHeader') == 'true'){
      sessionStorage.setItem('shouldReloadHeader', 'false');
      window.location.reload();
    }

      //check employer status 
      this.employerservice.viewEmployerById(this.userservice.getUsername()).subscribe(
      (res:any)=>{


          // let emplist : employer[] = res;
          // console.log(emplist)
            let empobj : employer = res;
            this.EmployerStatus = empobj.accountStatus; 

              //need to change the method ///viewAllJobsByEmployerId/{employerId} after getting the username from session
              this.jobservice.viewJobs().subscribe(
                (res:any)=>
                {
                  let tjoblist : Job[] = res;
                  this.joblist1 =  tjoblist.filter(ele=> ele.employerId == this.userservice.getUsername());

                },
                (err:any)=>{
                  console.log("Error getting Job data"+err);
                }
              )
      },
      (err:any)=>{

      }
    )

  
  }

  add(){

    this.jobservice.viewJobs().subscribe(

      (res:any)=>{
          let allJobs : Job[] = res;
          let newJobId = 100;
          console.log("---",allJobs.length);
          if(allJobs.length == 0)
          {
             newJobId = 1;
          }
          else{
            let jobIDs = allJobs.map(e => e.jobId);
            let jobIDsInt : number[] = [];
            
            jobIDs.forEach(e => {
              jobIDsInt.push(Number(e));
            });
        
             newJobId = Math.max(...jobIDsInt) + 1;
          }

          this.jobpost.value.employerId = this.userservice.getUsername();
          this.jobpost.value.jobId = newJobId;
         //creating jobId is remaining
     
         this.jobservice.addJob(this.jobpost.value).subscribe(
         
           (res:any)=> {
     
             console.log("job added")
             this.joblist1.push(res);
             this.ngOnInit();
             this.snackobj.open("Job","Added", {
               duration: 2000,
           });
           this.clearform();
     
         },
         (err:any)=>{
           console.log("Error whil adding Job"+ err);
         }
         )
      },
      (err : any)=>{

      }
    )
  
  }

  onJobStatus(jobstatus : Job){
    
      if(jobstatus.status == "open")
        jobstatus.status = "closed";
      else if(jobstatus.status == "closed")
       jobstatus.status = "open";

    this.snackobj.open("Job Status", "Updated", {
        duration: 2000,
    });

    this.jobservice.updateJobStatus(jobstatus.jobId,jobstatus.status).subscribe(
      (res:any)=>{
        console.log("Job Status changed")
        this.joblist1.push(res);
        this.ngOnInit();
  
      },
      (err:any)=>{
        console.log("Error while changing the Jobstatus"+ err);

      }
    )
  }

  OnJobEdit(jobstatus :Job){
    this.jobservice.updateJob(jobstatus.jobId, jobstatus).subscribe(
      (res:any)=>{
        console.log("Job Edited")
        this.joblist1.push(res);

      },
      (err:any)=>{
        console.log("Error while editing the Job"+ err);
      })
  }

 
  OnViewApplicants(id : any){
    this.jobservice.storeJobId(id);  //Passing the Id to session storage for further use in employerViewJobApplicants

      this.jobseekerservice.viewAllJobSeekersByJobId(id).subscribe(
        
        (res:any)=>{
        
            console.log(res);
            this.templist = res;
      
            this.ngOnInit();
            if(this.templist.length == 0){
              
              this.snackobj.open("No Applicant are there For this Job","Add Applicants", {
                duration: 2000,
            });

            }else{
    
              this.routeservice.employerViewJobApplicants();
        
            }
        },
        (err:any)=>{
          console.log("Error there is no applicant"+ err);
        }
      )

  }

  onDeleteJob(id: any){
    this.jobservice.removeJob(id).subscribe(
      (res:any)=>{
        this.joblist1=res;

        this.snackobj.open("Job ","Deleted", {
          duration: 2000,
      });
      
      },
      (err:any)=>{
        console.log("Error while deleting the Job"+ err);
      } )
      window.location.reload();
  }

  clearform()
  { 

    this.jobpost.reset({
      jobID:"",
      title:"",
      location:"",
      description:"",
      status:"",
    })
  }
}
