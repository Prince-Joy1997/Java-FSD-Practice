// import { OverlayModule } from '@angular/cdk/overlay';
// import { HttpClientModule } from '@angular/common/http';
// import { ComponentFixture, TestBed } from '@angular/core/testing';
// import { MatSnackBar } from '@angular/material/snack-bar';
// import { RouterTestingModule } from '@angular/router/testing';
// import { JobSeekerService } from '../services/job-seeker.service';
// import { JobService } from '../services/job.service';
// import { UserService } from '../services/user.service';
// import { jobSeekerAppliedJobsPipe } from '../pipe/jobSeekerAppliedJobsPipe';

// import { JobSeekerAppliedJobsComponent } from './job-seeker-applied-jobs.component';
// import { of } from 'rxjs';
// import { By } from '@angular/platform-browser';

// fdescribe('JobSeekerAppliedJobsComponent', () => {
//   let component: JobSeekerAppliedJobsComponent;
//   let fixture: ComponentFixture<JobSeekerAppliedJobsComponent>;
//   let jobSeekerService: JobSeekerService;
//   let userService: UserService;
//   let jobService: JobService;

//   beforeEach(async () => {
//     await TestBed.configureTestingModule({
//       imports: [ HttpClientModule, RouterTestingModule, OverlayModule],
//       declarations: [ JobSeekerAppliedJobsComponent, jobSeekerAppliedJobsPipe],
//       providers: [JobSeekerService, JobService, UserService, MatSnackBar]
//     })
//     .compileComponents();
//     jobSeekerService = TestBed.get(JobSeekerService);
//     userService = TestBed.get(UserService);
//     jobService = TestBed.get(JobService);
//     spyOn(jobSeekerService, 'viewAllApplicationsByJobSeekerId').and.returnValue(of());
//     spyOn(userService, 'getUsername').and.returnValue(of(''));
//     spyOn(jobService, 'viewJob').and.returnValue(of());
//   });

//   beforeEach(() => {
//     fixture = TestBed.createComponent(JobSeekerAppliedJobsComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });

//   // test to check ngOnInit method existence
//   it('ngOnInit method should exist', () => {
//     expect(component.ngOnInit).toBeTruthy();
//   });

//   // test to check ngOnInit is calling jobSeekerService or not
//   it('ngOnInit should call JobSeekerService', () => {
//     component.ngOnInit();
//     expect(jobSeekerService.viewAllApplicationsByJobSeekerId).toHaveBeenCalled();
//   });

//   // test to check ngOnInit is calling userService or not
//   it('ngOnInit should call userService', () => {
//     component.ngOnInit();
//     expect(userService.getUsername).toHaveBeenCalled();
//   });

//   // test to see if search bar exists
//   it('search bar should exist', () => {
//     let searchbarObj = fixture.debugElement.query(By.css('.clsSearchBar'));
//     expect(searchbarObj).toBeTruthy();
//   });
// });
