import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';

import { AdminComponent } from './admin/admin.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployerAdminComponent } from './employer-admin/employer-admin.component';
import { EmployerJobapplicantsComponent } from './employer-jobapplicants/employer-jobapplicants.component';
import { EmployerRegisterComponent } from './employer-register/employer-register.component';
import { EmployerComponent } from './employer/employer.component';
import { FooterComponent } from './footer/footer.component';
import { TopJobsGuard } from './guards/top-jobs.guard';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { JobSeekerAppliedJobsComponent } from './job-seeker-applied-jobs/job-seeker-applied-jobs.component';
import { JobSeekerComponent } from './job-seeker/job-seeker.component';

import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { RegisterComponent } from './register/register.component';
import { UserService } from './services/user.service';

import { ViewAllJobApplicantsComponent } from './view-all-job-applicants/view-all-job-applicants.component';
import { ViewRejectedJobApplicantsComponent } from './view-rejected-job-applicants/view-rejected-job-applicants.component';
import { ViewSelctedJobApplicantsComponent } from './view-selcted-job-applicants/view-selcted-job-applicants.component';
import { employerjobpipe } from './pipe/employerjobpipe';
import { jobapplicantpipe } from './pipe/jobapplicantpipe';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { jobSeekerSearchPipe } from './pipe/jobSeekerPipe';
import { jobSeekerAppliedJobsPipe } from './pipe/jobSeekerAppliedJobsPipe';
import { EditJobdialogComponent } from './edit-jobdialog/edit-jobdialog.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ViewResumeDialogComponent } from './view-resume-dialog/view-resume-dialog.component';


const routes : Routes = [
  {
    path: 'employerAdmin',
    component: EmployerAdminComponent,
    canActivate : [TopJobsGuard]
  },
  {
    path:'jobSeekerAdmin',
    component: AdminComponent,
    canActivate : [TopJobsGuard]
  },
  {
    path: 'login',
    component:LoginComponent
  },
  {
    path: 'signup',
    component:RegisterComponent
  },
  {
    path:'home',
    component: HomeComponent,
  },
  {
    path:'employer',
    component: EmployerComponent,
    canActivate : [TopJobsGuard]
  },
  {
    path:'jobseeker',
    component: JobSeekerComponent,
    canActivate : [TopJobsGuard]
  },
  {
    path:'jobseekerappliedjobs',
    component: JobSeekerAppliedJobsComponent,
    canActivate : [TopJobsGuard]
  },
  {
  path:'employerjobapplicants',
  component: EmployerJobapplicantsComponent,
  canActivate : [TopJobsGuard],
  children :[
    {
      path : 'ViewAllJobApplicants',
      component: ViewAllJobApplicantsComponent,
      canActivate : [TopJobsGuard]
    },
    {
      path : 'ViewSelctedJobApplicants',
      component: ViewSelctedJobApplicantsComponent,
      canActivate : [TopJobsGuard]
    },
    {
      path : 'ViewRejectedJobApplicants',
      component: ViewRejectedJobApplicantsComponent,
      canActivate : [TopJobsGuard]
    },
    {
      path:'',
      redirectTo:'ViewAllJobApplicants',
      pathMatch:'full'
    }
    ]
  },
  {
    path:'employerregister',
    component:EmployerRegisterComponent
  },
  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },
  {
    path:'**',
    component:PagenotfoundComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    FooterComponent,
    AdminComponent,
    EmployerComponent,
    JobSeekerComponent,
    JobSeekerAppliedJobsComponent,
    EmployerJobapplicantsComponent,
    EmployerRegisterComponent,
    ViewAllJobApplicantsComponent,
    ViewSelctedJobApplicantsComponent,
    ViewRejectedJobApplicantsComponent,
    EmployerAdminComponent,
    PagenotfoundComponent,
    employerjobpipe,
    jobapplicantpipe,
    jobSeekerSearchPipe,
    jobSeekerAppliedJobsPipe,
    EditJobdialogComponent,
    ViewResumeDialogComponent,

  ],
  imports: [
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
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    MatSelectModule,
    MatListModule,
    MatDividerModule,
    MatSidenavModule,
    MatCheckboxModule,
    MatDialogModule
  ],
  providers: [UserService, TopJobsGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
