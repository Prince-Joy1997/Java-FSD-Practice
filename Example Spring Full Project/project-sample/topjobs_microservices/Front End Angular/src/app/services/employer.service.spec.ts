// import { TestBed } from '@angular/core/testing';
// import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

// import { EmployerService } from './employer.service';
// import { RouterTestingModule } from '@angular/router/testing';
// import { provideRoutes } from '@angular/router';
// import { JobSeekerService } from './job-seeker.service';
// import { UserService } from './user.service';
// import { employer } from '../models/employer';
// import { jobSeeker } from '../models/jobSeeker';

// fdescribe('EmployerService', () => {
//   let service: EmployerService;
//   let httpMock: HttpTestingController;


//   beforeEach(() => {
//     TestBed.configureTestingModule({

//       imports : [HttpClientTestingModule, RouterTestingModule],
//       providers : [JobSeekerService, UserService],
//     });

//     service = TestBed.inject(EmployerService);
//     httpMock = TestBed.get(HttpTestingController);
//   });

//   afterEach( () => {
//     httpMock.verify();
//   });

//   it('should be created', () => {
//     expect(service).toBeTruthy();
//   });

//   it('registerEmployer() method should add Employer', () => {
//     const jS: employer = {
//       'username' : 'username1',
//       'firstname' : 'firstname1',
//       'lastname' : 'lastname1',
//       'email' : 'test@email.ca',
//       'companyName' : 'cgi',
//       'phoneNumber' : 6473920394,
//       'address' : '123 test st.',
//       'accountStatus' : true,
//     };
//     // We call the service
//     service.registerEmployer(jS).subscribe(data => {
//       expect(data).toEqual(jS);
//     });
//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8082/employer/registerEmployer');
//     expect(req.request.method).toEqual('POST');
//     expect(req.request.headers.get('Content-Type')).toEqual('application/json');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jS);
//   });

//   it('viewAllEmployer() method should return all JobSeekers', () => {

//     const jSList : employer[] =[
//       {
//         'username' : 'username1',
//         'firstname' : 'firstname1',
//         'lastname' : 'lastname1',
//         'email' : 'test@email.ca',
//         'companyName' : 'cgi',
//         'phoneNumber' : 6473920394,
//         'address' : '123 test st.',
//         'accountStatus' : true,
//       },
//       {
//         'username' : 'username2',
//         'firstname' : 'firstname2',
//         'lastname' : 'lastname2',
//         'email' : 'test@email2.ca',
//         'companyName' : 'cgicanada',
//         'phoneNumber' : 6473920324,
//         'address' : '1234 test st.',
//         'accountStatus' : false,
//       }
//     ];
//      // We call the service
//      service.viewAllEmployer().subscribe(data => {
//       expect(data).toEqual(jSList);
//     });
//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8082/employer/viewAllEmployer');
//     expect(req.request.method).toEqual('GET');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jSList);
//   });

//   it('viewEmployerById() method should return Employer', () => {
//     const jSList: employer [] = [
//       {
//         'username' : 'username1',
//         'firstname' : 'firstname1',
//         'lastname' : 'lastname1',
//         'email' : 'test@email.ca',
//         'companyName' : 'cgi',
//         'phoneNumber' : 6473920394,
//         'address' : '123 test st.',
//         'accountStatus' : true,
//       },
//       {
//         'username' : 'username2',
//         'firstname' : 'firstname2',
//         'lastname' : 'lastname2',
//         'email' : 'test@email2.ca',
//         'companyName' : 'cgicanada',
//         'phoneNumber' : 6473920324,
//         'address' : '1234 test st.',
//         'accountStatus' : false,
//       }
//     ];
//     // We call the service
//     service.viewEmployerById('username1').subscribe(data => {
//       expect(data).toEqual(jSList[0]);
//     });
//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8082/employer/viewEmployer/username1');
//     expect(req.request.method).toEqual('GET');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jSList[0]);
//   });

//   it('updateEmployer() method should update Employer', () => {
//     const jS : employer = {
//       'username' : 'username1',
//         'firstname' : 'firstname1',
//         'lastname' : 'lastname1',
//         'email' : 'test@email.ca',
//         'companyName' : 'cgi',
//         'phoneNumber' : 6473920394,
//         'address' : '123 test st.',
//         'accountStatus' : true,
//     };

//     service.updateEmployer('username1', jS).subscribe(data => {
//       expect(data).toEqual(jS);
//   });
//     const req = httpMock.expectOne('http://localhost:8082/employer/updateEmployer/username1');
//     expect(req.request.method).toEqual('PUT');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jS);
// });

// it('updateAccountStatus() method should update Employer status', () => {
//   const jS : employer = {
//       'username' : 'username1',
//       'firstname' : 'firstname1',
//       'lastname' : 'lastname1',
//       'email' : 'test@email.ca',
//       'companyName' : 'cgi',
//       'phoneNumber' : 6473920394,
//       'address' : '123 test st.',
//       'accountStatus' : true,
//   };

//   service.updateAccountStatus('username1', 'accountStatus').subscribe(data => {
//     expect(data).toEqual(jS);
// });
//   const req = httpMock.expectOne('http://localhost:8082/employer/updateAccountStatus/username1/accountStatus');
//   expect(req.request.method).toEqual('PUT');
//   // Then we set the fake data to be returned by the mock
//   req.flush(jS);
// });

// it('deleteEmployer() method should update Employer status', () => {
//   const jS : employer = {
//       'username' : 'username1',
//       'firstname' : 'firstname1',
//       'lastname' : 'lastname1',
//       'email' : 'test@email.ca',
//       'companyName' : 'cgi',
//       'phoneNumber' : 6473920394,
//       'address' : '123 test st.',
//       'accountStatus' : true,
//   };

//   service.deleteEmployer('username1').subscribe(data => {
//     expect(data).toEqual(jS);
// });
//   const req = httpMock.expectOne('http://localhost:8082/employer/deleteEmployer/username1');
//   expect(req.request.method).toEqual('DELETE');
//   // Then we set the fake data to be returned by the mock
//   req.flush(jS);
// });


// it('viewEmployerBystatus() method should update Employer status', () => {
//   const jS : employer = {
//       'username' : 'username1',
//       'firstname' : 'firstname1',
//       'lastname' : 'lastname1',
//       'email' : 'test@email.ca',
//       'companyName' : 'cgi',
//       'phoneNumber' : 6473920394,
//       'address' : '123 test st.',
//       'accountStatus' : true,
//   };

//   service.viewEmployerBystatus('accountStatus').subscribe(data => {
//     expect(data).toEqual(jS);
// });
//   const req = httpMock.expectOne('http://localhost:8082/employer/viewEmployerBystatus/accountStatus');
//   expect(req.request.method).toEqual('GET');
//   // Then we set the fake data to be returned by the mock
//   req.flush(jS);
// });


// });
