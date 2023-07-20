import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatDialogModule } from '@angular/material/dialog';
import { By } from '@angular/platform-browser';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { jobapplicantpipe } from '../pipe/jobapplicantpipe';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';

import { ViewSelctedJobApplicantsComponent } from './view-selcted-job-applicants.component';

fdescribe('ViewSelctedJobApplicantsComponent', () => {
  let component: ViewSelctedJobApplicantsComponent;
  let fixture: ComponentFixture<ViewSelctedJobApplicantsComponent>;

  let jobService : JobService;
  let jobseekerservice : JobSeekerService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[HttpClientModule, MatDialogModule, RouterTestingModule],
      declarations: [ ViewSelctedJobApplicantsComponent,jobapplicantpipe ],
      providers : [JobSeekerService, JobService, HttpClient]

    })
    .compileComponents();
    jobService = TestBed.get(JobService);
    jobseekerservice = TestBed.get(JobSeekerService);
    spyOn(jobseekerservice,'viewAllSelectedJobSeekersByJobId').and.returnValue(of());

  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewSelctedJobApplicantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should check existance of a clsSearchBarDiv', ()=>{
    let butobj =  fixture.debugElement.query(By.css('.clsSearchBarDiv'));
    expect(butobj).toBeTruthy();
    });

  it('should check existance of a clsSearchBarDiv', ()=>{
    let butobj =  fixture.debugElement.query(By.css('.clsSearchBarDiv'));
    expect(butobj).toBeTruthy();
    });

  it('should check existance of a cardsection', ()=>{
    let butobj =  fixture.debugElement.query(By.css('.cardsection'));
    expect(butobj).toBeTruthy();
    });

    it('should check existance of a clsSearchBar', ()=>{
      let obj =  fixture.debugElement.query(By.css('.clsSearchBar'));
      expect(obj).toBeTruthy();
      });

  it('onViewResumeDialog method should exist',()=>{
    expect(component.onViewResumeDialog).toBeTruthy();
  });

  it('OnSelect method should exist',()=>{
    expect(component.OnReject).toBeTruthy();
  });

  it('ngOnInit method should exist',()=>{
    expect(component.ngOnInit).toBeTruthy();
  });

  it('ngOnInit() should call jobservice ', () => {
    component.ngOnInit();
    expect(jobseekerservice.viewAllSelectedJobSeekersByJobId).toHaveBeenCalled();
  });

});
