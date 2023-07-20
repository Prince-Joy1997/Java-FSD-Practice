import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDialogModule } from '@angular/material/dialog';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserModule, By } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { AppRoutingModule } from '../app-routing.module';
import { EmployerService } from '../services/employer.service';
import { JobSeekerService } from '../services/job-seeker.service';
import { JobService } from '../services/job.service';
import { RoutingService } from '../services/routing.service';
import { UserService } from '../services/user.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let router: RoutingService;
  let authenticatorService: UserService;
  let jobSeekerService: JobSeekerService;
  let matSnackBar: MatSnackBar;
  let jobService: JobService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports : [
       BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        ReactiveFormsModule,
        MatToolbarModule,
        MatIconModule,
        MatButtonModule,
        MatFormFieldModule,
        MatInputModule,
        MatCardModule,
        MatSnackBarModule,
        MatButtonToggleModule,
        MatGridListModule,
        MatTableModule,
        MatExpansionModule,
        HttpClientModule,
        FormsModule,
        MatSelectModule,
        MatListModule,
        MatDividerModule,
        MatSidenavModule,
        MatCheckboxModule,
        MatDialogModule],
        providers: [JobSeekerService, JobService, EmployerService , RoutingService, MatSnackBar, UserService, HttpClient ]

    })
    .compileComponents();
    authenticatorService = TestBed.get(UserService);
    spyOn(authenticatorService,'GenerateTokenfromServer').and.returnValue(of(''));
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  })
  it('should check existence of ngOnInit', () => {
    expect(component.ngOnInit).toBeTruthy();
  })
  it('should check existence of signIn method', () => {
    expect(component.signIn).toBeTruthy();
  })
  it('should check existence of signIn button', ()=>{
    let signInBtn=fixture.debugElement.query(By.css('.btn'));
   expect(signInBtn).toBeTruthy();
  })
  // it('Should check if signUp method calls authenticator', ()=>{
  //   component.signIn();
  //   expect(authenticatorService.GenerateTokenfromServer).toHaveBeenCalled();
  //    })


});
