import { ComponentFixture, TestBed } from '@angular/core/testing';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { By } from '@angular/platform-browser';

import { EmployerComponent } from './employer.component';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';

import { EmployerService } from '../services/employer.service';
import { RoutingService } from '../services/routing.service';
import { OverlayModule } from '@angular/cdk/overlay';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../services/user.service';
import { employerjobpipe } from '../pipe/employerjobpipe';
import { RouterTestingModule } from '@angular/router/testing';
import { EditJobdialogComponent } from '../edit-jobdialog/edit-jobdialog.component';
import { MatDialog } from '@angular/material/dialog';
import { MatDialogModule } from '@angular/material/dialog';
import { of } from 'rxjs';
import { Job } from '../models/job';

fdescribe('EmployerComponent', () => {
  let component: EmployerComponent;
  let fixture: ComponentFixture<EmployerComponent>;

  let jobService : JobService;



  beforeEach(async () => {
    await TestBed.configureTestingModule({

      imports: [ HttpClientModule, MatDialogModule,RouterTestingModule],

      declarations: [EmployerComponent, employerjobpipe, EditJobdialogComponent ],

      providers:[JobSeekerService, JobService, EmployerService , RoutingService, MatSnackBar, UserService, HttpClient ],

    })
    .compileComponents();
    jobService = TestBed.get(JobService);
    spyOn(jobService,'viewJobs').and.returnValue(of());
    spyOn(jobService,'updateJob').and.returnValue(of());

  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should check existance of a button', ()=>{
  let butobj =  fixture.debugElement.query(By.css('.btncolor'));
  expect(butobj).toBeTruthy();
  });

  //tests to check is methods are there or not
  it('ngOnit() should exist', ()=> {
    expect(component.ngOnInit).toBeTruthy();
  });

  it('OpenDialog method should exist',()=>{
    expect(component.openDialog).toBeTruthy();
  });

  it('add() method should exist',()=>{
    expect(component.add).toBeTruthy();
  });

  it('OnJobStatus() method should exist',()=>{
    expect(component.onJobStatus).toBeTruthy();
  });

  it('OnJobEdit() method should exist',()=>{
    expect(component.OnJobEdit).toBeTruthy();
  });

  it('OnViewApplicants() method should exist',()=>{
    expect(component.OnViewApplicants).toBeTruthy();
  });

  it('onDeleteJob() method should exist',()=>{
    expect(component.onDeleteJob).toBeTruthy();
  });

  it('clearform() method should exist',()=>{
    expect(component.clearform).toBeTruthy();
  });

  //tests to check is Calling the services or not

  // it('ngOnInit() should call jobservice', () => {
  //   component.ngOnInit();
  //   expect(jobService.viewJobs).toHaveBeenCalled();
  // });

  it('add() should call jobservice viewJobs', () => {
    component.add();
    expect(jobService.viewJobs).toHaveBeenCalled();
  });


});
