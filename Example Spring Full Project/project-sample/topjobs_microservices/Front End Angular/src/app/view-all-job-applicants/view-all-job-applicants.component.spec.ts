// import { HttpClient, HttpClientModule } from '@angular/common/http';
// import { ComponentFixture, TestBed } from '@angular/core/testing';
// import { MatDialogModule } from '@angular/material/dialog';
// import { By } from '@angular/platform-browser';
// import { RouterTestingModule } from '@angular/router/testing';
// import { of } from 'rxjs';
// import { jobapplicantpipe } from '../pipe/jobapplicantpipe';
// import { JobSeekerService } from '../services/job-seeker.service';
// import { JobService } from '../services/job.service';

// import { ViewAllJobApplicantsComponent } from './view-all-job-applicants.component';

// fdescribe('ViewAllJobApplicantsComponent', () => {
//   let component: ViewAllJobApplicantsComponent;
//   let fixture: ComponentFixture<ViewAllJobApplicantsComponent>;

//   let jobService : JobService;
//   let jobseekerservice : JobSeekerService;

//   beforeEach(async () => {
//     await TestBed.configureTestingModule({
//       imports:[HttpClientModule, MatDialogModule, RouterTestingModule],
//       declarations: [ ViewAllJobApplicantsComponent , jobapplicantpipe],
//       providers : [JobSeekerService, JobService, HttpClient]
//     })
//     .compileComponents();
//     jobService = TestBed.get(JobService);
//     jobseekerservice = TestBed.get(JobSeekerService);
//     spyOn(jobService,'viewJobs').and.returnValue(of());
//     spyOn(jobseekerservice,'viewAllJobSeekersByJobId').and.returnValue(of());

//   });

//   beforeEach(() => {
//     fixture = TestBed.createComponent(ViewAllJobApplicantsComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should check existance of a clsSearchBarDiv', ()=>{
//     let butobj =  fixture.debugElement.query(By.css('.clsSearchBarDiv'));
//     expect(butobj).toBeTruthy();
//     });

//   it('should check existance of a cardsection', ()=>{
//     let butobj =  fixture.debugElement.query(By.css('.cardsection'));
//     expect(butobj).toBeTruthy();
//     });

//   it('should check existance of a clsSearchBar', ()=>{
//     let obj =  fixture.debugElement.query(By.css('.clsSearchBar'));
//     expect(obj).toBeTruthy();
//     });


//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });

//   it('ngOnit() should exist', ()=> {
//     expect(component.ngOnInit).toBeTruthy();
//   });

//   it('onViewResumeDialog() method should exist', ()=> {
//     expect(component.onViewResumeDialog).toBeTruthy();
//   });

//   it('OnStatusChange() method should exist', ()=> {
//     expect(component.OnStatusChange).toBeTruthy();
//   });

//   it('getApplicantStatus() method should exist', ()=> {
//     expect(component.getApplicantStatus).toBeTruthy();
//   });

//   it('ngOnInit() should call jobservice viewAllJobSeekersByJobId', () => {
//     component.ngOnInit();
//     expect(jobseekerservice.viewAllJobSeekersByJobId).toHaveBeenCalled();
//   });

//   // it('ngOnInit() should call jobservice viewAllJobSeekersByJobId', () => {
//   //   component.ngOnInit();
//   //   expect(jobseekerservice.viewAllJobSeekersByJobId).toHaveBeenCalled();
//   // });

// });
