import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobSeekerComponent } from './job-seeker.component';
import { HttpClientModule } from '@angular/common/http';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';
import { UserService } from '../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RouterTestingModule } from '@angular/router/testing';
import { OverlayModule } from '@angular/cdk/overlay';
import { jobSeekerSearchPipe } from '../pipe/jobSeekerPipe';
import { of } from 'rxjs';
import { By } from '@angular/platform-browser';

fdescribe('JobSeekerComponent', () => {
  let component: JobSeekerComponent;
  let fixture: ComponentFixture<JobSeekerComponent>;
  let jobSeekerService: JobSeekerService;
  let jobService: JobService;
  let userService: UserService;
  let matSnackBar: MatSnackBar;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ HttpClientModule, RouterTestingModule, OverlayModule],
      declarations: [ JobSeekerComponent , jobSeekerSearchPipe],
      providers: [JobSeekerService, JobService, UserService, MatSnackBar]
    })
    .compileComponents();
    jobSeekerService = TestBed.get(JobSeekerService);
    jobService = TestBed.get(JobService);
    userService = TestBed.get(UserService);
    matSnackBar = TestBed.get(MatSnackBar);
    spyOn(jobSeekerService, 'viewAllApplicationsByJobSeekerId').and.returnValue(of());
    spyOn(jobSeekerService, 'addJobSeekerApplication').and.returnValue(of());
    spyOn(jobService, 'viewJobs').and.returnValue(of());
    spyOn(userService, 'getUsername').and.returnValue(of(''));
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobSeekerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // test to check ngOnInit method existence
  it('ngOnInit method should exist', () => {
    expect(component.ngOnInit).toBeTruthy();
  });

  // test to check apply method existence
  it('apply method should exist', () => {
    expect(component.apply).toBeTruthy();
  });

  // test to check hasAppliedJob method existence
  it('hasAppliedJob method should exist', () => {
    expect(component.hasAppliedJob).toBeTruthy();
  });

  // test to check onClickhideAppliedJobs method existence
  it('onClickhideAppliedJobs method should exist', () => {
    expect(component.onClickhideAppliedJobs).toBeTruthy();
  });

  // test to check ngOnInit is calling JobSeekerService or not
  it('ngOnInit should call JobSeekerService', () => {
    component.ngOnInit();
    expect(jobSeekerService.viewAllApplicationsByJobSeekerId).toHaveBeenCalled();
  });

  // test to check ngOnInit is calling jobService or not
  it('ngOnInit should call jobService', () => {
    component.ngOnInit();
    expect(jobService.viewJobs).toHaveBeenCalled();
  });

  // test to check apply is calling jobSeekerService or not
  it('apply should call jobSeekerService', () => {
    component.apply('');
    expect(jobSeekerService.addJobSeekerApplication).toHaveBeenCalled();
  });

  // test to see if job list exists
  it('job list accordian should exist', () => {
    let accordianObj = fixture.debugElement.query(By.css('.clsAccordian'));
    expect(accordianObj).toBeTruthy();
  });

  // test to see if search bar exists
  it('search bar should exist', () => {
    let searchbarObj = fixture.debugElement.query(By.css('.clsSearchBar'));
    expect(searchbarObj).toBeTruthy();
  });

  // test to see if hide jobs already applied button exists
  it('hide jobs already applied button should exist', () => {
    let hideJobsAlreadyAppliedButtonObj = fixture.debugElement.query(By.css('.clsShowJobsApplied'));
    expect(hideJobsAlreadyAppliedButtonObj).toBeTruthy();
  });
});
