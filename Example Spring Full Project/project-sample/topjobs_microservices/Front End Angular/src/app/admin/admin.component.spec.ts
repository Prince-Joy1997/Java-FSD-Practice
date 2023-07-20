import { jobSeekerSearchPipe } from './../pipe/jobSeekerPipe';
import { JobService } from './../services/job.service';
import { OverlayModule } from '@angular/cdk/overlay';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { JobSeekerService } from './../services/job-seeker.service';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AdminComponent } from './admin.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../services/user.service';
import { of } from 'rxjs';

describe('AdminComponent', () => {
  let component: AdminComponent;
  let fixture: ComponentFixture<AdminComponent>;
  let seekerService : JobSeekerService;
  let jobService : JobService;
  let userService : UserService;
  let matSnackBar: MatSnackBar;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminComponent, jobSeekerSearchPipe ],
      imports : [HttpClientModule, RouterTestingModule, OverlayModule],
      providers : [JobSeekerService, MatSnackBar, JobService, UserService]
    })
    .compileComponents();
    seekerService = TestBed.get(JobSeekerService);
    matSnackBar = TestBed.get(MatSnackBar);
    jobService = TestBed.get(JobService);
    userService = TestBed.get(UserService);
    spyOn(seekerService, 'viewAllJobSeekers').and.returnValue(of());;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // Check onInit method existence
it('ngOnInit method should exist', ()=>{
  expect(component.ngOnInit).toBeTruthy();
})

// Check if Employer Service has been called
it('seekerService should be called', ()=>{
  component.ngOnInit();
  expect(seekerService.viewAllJobSeekers).toHaveBeenCalled();
})
});
