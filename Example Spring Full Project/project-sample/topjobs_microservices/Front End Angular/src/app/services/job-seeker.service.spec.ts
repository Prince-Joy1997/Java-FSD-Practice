// import { HttpClientModule } from '@angular/common/http';
// import { TestBed } from '@angular/core/testing';
// import { RouterTestingModule } from '@angular/router/testing';
// import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

// import { JobSeekerService } from './job-seeker.service';
// import { UserService } from './user.service';
// import { jobSeeker } from '../models/jobSeeker';
// import { application } from '../models/application';

// fdescribe('JobSeekerService', () => {
//   let service: JobSeekerService;
//   let httpMock: HttpTestingController;

//   beforeEach(() => {
//     TestBed.configureTestingModule({
//       imports: [ HttpClientTestingModule, RouterTestingModule],
//       providers: [JobSeekerService, UserService]
//     });
//     service = TestBed.inject(JobSeekerService);
//     httpMock = TestBed.get(HttpTestingController);
//   });

//   afterEach( () => {
//     httpMock.verify();
//   });

//   it('should be created', () => {
//     expect(service).toBeTruthy();
//   });

//   it('registerJobSeeker() method should add JobSeeker', () => {
//     const jS: jobSeeker = {
//       'username' : 'username1',
//       'firstName' : 'firstname1',
//       'lastName' : 'lastname1',
//       'email' : 'test@email.ca',
//       'address' : '123 test st.',
//       'resume' : 'this is my resume',
//       'phoneNumber' : 6473920394,
//       'applicationList' : []
//     };

//     // We call the service
//     service.registerJobSeeker(jS).subscribe(data => {
//       expect(data).toEqual(jS);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/registerJobSeeker');
//     expect(req.request.method).toEqual('POST');
//     expect(req.request.headers.get('Content-Type')).toEqual('application/json');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jS);
//   });

//   it('viewAllJobSeekers() method should return all JobSeekers', () => {
//     const jSList: jobSeeker [] = [
//       {
//         'username' : 'username1',
//         'firstName' : 'firstname1',
//         'lastName' : 'lastname1',
//         'email' : 'test@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume',
//         'phoneNumber' : 6473920394,
//         'applicationList' : []
//       },
//       {
//         'username' : 'username2',
//         'firstName' : 'firstname2',
//         'lastName' : 'lastname2',
//         'email' : 'test2@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume2',
//         'phoneNumber' : 64739203942,
//         'applicationList' : []
//       }
//     ];

//     // We call the service
//     service.viewAllJobSeekers().subscribe(data => {
//       expect(data).toEqual(jSList);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/viewAllJobSeekers');
//     expect(req.request.method).toEqual('GET');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jSList);
//   });

//   it('viewJobSeeker() method should return JobSeeker', () => {
//     const jSList: jobSeeker [] = [
//       {
//         'username' : 'username1',
//         'firstName' : 'firstname1',
//         'lastName' : 'lastname1',
//         'email' : 'test@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume',
//         'phoneNumber' : 6473920394,
//         'applicationList' : []
//       },
//       {
//         'username' : 'username2',
//         'firstName' : 'firstname2',
//         'lastName' : 'lastname2',
//         'email' : 'test2@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume2',
//         'phoneNumber' : 64739203942,
//         'applicationList' : []
//       }
//     ];

//     // We call the service
//     service.viewJobSeeker('username1').subscribe(data => {
//       expect(data).toEqual(jSList[0]);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/viewJobSeeker/username1');
//     expect(req.request.method).toEqual('GET');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jSList[0]);
//   });

//   it('updateJobSeeker() method should update JobSeeker', () => {
//     const jS: jobSeeker = {
//       'username' : 'username1',
//       'firstName' : 'firstname1',
//       'lastName' : 'lastname1',
//       'email' : 'test@email.ca',
//       'address' : '123 test st.',
//       'resume' : 'this is my resume',
//       'phoneNumber' : 6473920394,
//       'applicationList' : []
//     };

//     // We call the service
//     service.updateJobSeeker(jS).subscribe(data => {
//       expect(data).toEqual(jS);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/updateJobSeeker');
//     expect(req.request.method).toEqual('PUT');
//     expect(req.request.headers.get('Content-Type')).toEqual('application/json');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jS);
//   });

//   it('addJobSeekerApplication() method should add JobSeeker application', () => {
//     const app : application = {
//       'jobID' : '1',
//       'status' : 'pending'
//     };

//     const jS: jobSeeker = {
//       'username' : 'username1',
//       'firstName' : 'firstname1',
//       'lastName' : 'lastname1',
//       'email' : 'test@email.ca',
//       'address' : '123 test st.',
//       'resume' : 'this is my resume',
//       'phoneNumber' : 6473920394,
//       'applicationList' : [app]
//     };

//     // We call the service
//     service.addJobSeekerApplication('username1', app).subscribe(data => {
//       expect(data).toEqual(app);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/addJobSeekerApplication/username1');
//     expect(req.request.method).toEqual('POST');
//     expect(req.request.headers.get('Content-Type')).toEqual('application/json');
//     // Then we set the fake data to be returned by the mock
//     req.flush(app);
//   });

//   it('viewAllApplicationsByJobSeekerId() method should get all JobSeeker applications', () => {
//     const app : application = {
//       'jobID' : '1',
//       'status' : 'pending'
//     };

//     const app2 : application = {
//       'jobID' : '2',
//       'status' : 'selected'
//     };

//     const app3 : application = {
//       'jobID' : '3',
//       'status' : 'rejected'
//     };

//     const jS: jobSeeker = {
//       'username' : 'username1',
//       'firstName' : 'firstname1',
//       'lastName' : 'lastname1',
//       'email' : 'test@email.ca',
//       'address' : '123 test st.',
//       'resume' : 'this is my resume',
//       'phoneNumber' : 6473920394,
//       'applicationList' : [app, app2, app3]
//     };

//     // We call the service
//     service.viewAllApplicationsByJobSeekerId('username1').subscribe(data => {
//       expect(data).toEqual(jS.applicationList);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/viewAllApplicationsByJobSeekerId/username1');
//     expect(req.request.method).toEqual('GET');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jS.applicationList);
//   });

//   it('viewAllJobSeekersByJobId() method should get all JobSeekers by job ID', () => {
//     const app : application = {
//       'jobID' : '1',
//       'status' : 'pending'
//     };

//     const app2 : application = {
//       'jobID' : '2',
//       'status' : 'selected'
//     };

//     const app3 : application = {
//       'jobID' : '3',
//       'status' : 'rejected'
//     };

//     const jSList: jobSeeker [] = [
//       {
//         'username' : 'username1',
//         'firstName' : 'firstname1',
//         'lastName' : 'lastname1',
//         'email' : 'test@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume',
//         'phoneNumber' : 6473920394,
//         'applicationList' : [app]
//       },
//       {
//         'username' : 'username2',
//         'firstName' : 'firstname2',
//         'lastName' : 'lastname2',
//         'email' : 'test2@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume2',
//         'phoneNumber' : 64739203942,
//         'applicationList' : [app2, app3]
//       }
//     ];

//     // We call the service
//     service.viewAllJobSeekersByJobId('1').subscribe(data => {
//       expect(data).toEqual([jSList[0]]);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/viewAllJobSeekersByJobId/1');
//     expect(req.request.method).toEqual('GET');
//     // Then we set the fake data to be returned by the mock
//     req.flush([jSList[0]]);
//   });

//   it('viewAllSelectedJobSeekersByJobId() method should get all selected JobSeekers by job ID', () => {
//     const app : application = {
//       'jobID' : '1',
//       'status' : 'pending'
//     };

//     const app2 : application = {
//       'jobID' : '2',
//       'status' : 'selected'
//     };

//     const app3 : application = {
//       'jobID' : '3',
//       'status' : 'rejected'
//     };

//     const jSList: jobSeeker [] = [
//       {
//         'username' : 'username1',
//         'firstName' : 'firstname1',
//         'lastName' : 'lastname1',
//         'email' : 'test@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume',
//         'phoneNumber' : 6473920394,
//         'applicationList' : [app]
//       },
//       {
//         'username' : 'username2',
//         'firstName' : 'firstname2',
//         'lastName' : 'lastname2',
//         'email' : 'test2@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume2',
//         'phoneNumber' : 64739203942,
//         'applicationList' : [app2, app3]
//       }
//     ];

//     // We call the service
//     service.viewAllSelectedJobSeekersByJobId('2').subscribe(data => {
//       expect(data).toEqual([jSList[1]]);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/viewAllSelectedJobSeekersByJobId/2');
//     expect(req.request.method).toEqual('GET');
//     // Then we set the fake data to be returned by the mock
//     req.flush([jSList[1]]);
//   });

//   it('viewAllRejectedJobSeekersByJobId() method should get all rejected JobSeekers by job ID', () => {
//     const app : application = {
//       'jobID' : '1',
//       'status' : 'pending'
//     };

//     const app2 : application = {
//       'jobID' : '2',
//       'status' : 'selected'
//     };

//     const app3 : application = {
//       'jobID' : '3',
//       'status' : 'rejected'
//     };

//     const jSList: jobSeeker [] = [
//       {
//         'username' : 'username1',
//         'firstName' : 'firstname1',
//         'lastName' : 'lastname1',
//         'email' : 'test@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume',
//         'phoneNumber' : 6473920394,
//         'applicationList' : [app]
//       },
//       {
//         'username' : 'username2',
//         'firstName' : 'firstname2',
//         'lastName' : 'lastname2',
//         'email' : 'test2@email.ca',
//         'address' : '123 test st.',
//         'resume' : 'this is my resume2',
//         'phoneNumber' : 64739203942,
//         'applicationList' : [app2, app3]
//       }
//     ];

//     // We call the service
//     service.viewAllRejectedJobSeekersByJobId('3').subscribe(data => {
//       expect(data).toEqual([jSList[1]]);
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/viewAllRejectedJobSeekersByJobId/3');
//     expect(req.request.method).toEqual('GET');
//     // Then we set the fake data to be returned by the mock
//     req.flush([jSList[1]]);
//   });

//   it('updateApplicationStatus() method should update JobSeeker application status', () => {
//     const app : application = {
//       'jobID' : '1',
//       'status' : 'selected'
//     };
//     const jS: jobSeeker = {
//       'username' : 'username1',
//       'firstName' : 'firstname1',
//       'lastName' : 'lastname1',
//       'email' : 'test@email.ca',
//       'address' : '123 test st.',
//       'resume' : 'this is my resume',
//       'phoneNumber' : 6473920394,
//       'applicationList' : [app]
//     };

//     // We call the service
//     service.updateApplicationStatus('username1', '1', 'selected').subscribe(data => {
//       expect(data).toEqual('Status updated.');
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:8083/jobSeeker/updateApplicationStatus/username1/1/selected');
//     expect(req.request.method).toEqual('PUT');
//     // Then we set the fake data to be returned by the mock
//     req.flush('Status updated.');
//   });
// });
