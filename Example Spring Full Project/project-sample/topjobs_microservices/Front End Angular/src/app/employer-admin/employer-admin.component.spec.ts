// import { OverlayModule } from '@angular/cdk/overlay';

// import { JobService } from './../services/job.service';
// import { RouterTestingModule } from '@angular/router/testing';
// import { HttpClientModule } from '@angular/common/http';
// import { RoutingService } from './../services/routing.service';
// import { EmployerService } from './../services/employer.service';
// import { UserService } from './../services/user.service';
// import { ComponentFixture, TestBed } from '@angular/core/testing';
// import { EmployerAdminComponent } from './employer-admin.component';
// import { By } from '@angular/platform-browser';
// import { JobSeekerService } from '../services/job-seeker.service';
// import { MatSnackBar } from '@angular/material/snack-bar';


// describe('EmployerAdminComponent', () => {
//   let component: EmployerAdminComponent;
//   let fixture: ComponentFixture<EmployerAdminComponent>;
//   let empService : EmployerService;
//   let jobService : JobService;
//   let jobSeekerService: JobSeekerService;
//   let userService: UserService;
//   let matSnackBar: MatSnackBar;

//   beforeEach(async () => {
//     await TestBed.configureTestingModule({
//       declarations: [ EmployerAdminComponent ],
//       imports : [HttpClientModule, RouterTestingModule, OverlayModule],
//       providers: [EmployerService, JobService, MatSnackBar, UserService, JobSeekerService]
//     })
//     .compileComponents();

//     empService = TestBed.get(EmployerService);
//     jobSeekerService = TestBed.get(JobSeekerService);
//     jobService = TestBed.get(JobService);
//     userService = TestBed.get(UserService);
//     matSnackBar = TestBed.get(MatSnackBar);

//     spyOn(empService, 'viewAllEmployer');
//     spyOn(empService, 'updateAccountStatus');

//   });

//   beforeEach(() => {
//     fixture = TestBed.createComponent(EmployerAdminComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });

//   // Check existence of Css objects
//   it('should check existence of button', ()=>{
//     let buttonObj = fixture.debugElement.query(By.css('.btn'));
//     expect(buttonObj).toBeTruthy();
//   })

// // Check onInit method existence
// it('ngOnInit method should exist', ()=>{
//   expect(component.ngOnInit).toBeTruthy();
// })

// // Check changeStatus method existence
// it('changeStatus method should exist', ()=>{
//   expect(component.changeStatus).toBeTruthy();
// })

// // Check if Employer Service has been called
// it('empService should be called', ()=>{
//   component.ngOnInit();
//   expect(empService.viewAllEmployer).toHaveBeenCalled();
// })

// // Check if Employer Service has been called
// it('empService has been called', ()=>{
//   component.ngOnInit();
//   expect(empService.updateAccountStatus).toHaveBeenCalled();
// })

// });


