// import { UserService } from './user.service';
// import { HttpClientModule } from '@angular/common/http';
// import { TestBed } from '@angular/core/testing';
// import { RouterTestingModule } from '@angular/router/testing';
// import { Job } from '../models/job';
// import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

// import { JobService } from './job.service';


// describe('JobService', () => {
//   let service: JobService;
//   let httpMock: HttpTestingController;


//   beforeEach(() => {
//     TestBed.configureTestingModule({
//       imports : [HttpClientTestingModule, RouterTestingModule],
//       providers: [JobService, UserService]
//     });
//     service = TestBed.inject(JobService);
//     httpMock = TestBed.get(HttpTestingController);
//   });

//   afterEach( () => {
//     httpMock.verify();
//   });

//   it('should be created', () => {
//     expect(service).toBeTruthy();
//   });

//   // testing service for addJob method
//   it('addJob method should add job', () => {
//     const jobs: Job = {
//     jobId : '12',
//     employerId : '22',
//     title : 'developer',
//     location : 'Toronto',
//     description : 'full stack developer',
//     postedDate :  '',
//     status :  'open',
//     };
//     // We call the service
//     service.addJob(jobs).subscribe(data => {
//       expect(data.jobId).toEqual('12');
//       expect(data.employerId).toEqual('22');
//       expect(data.title).toEqual('developer');
//       expect(data.location).toEqual('Toronto');
//       expect(data.description).toEqual('full stack developer');
//       expect(data.status).toEqual('open');
//     });

//     // We set the expectations for the HttpClient mock
//     const req = httpMock.expectOne('http://localhost:9096/job/addJob');
//     expect(req.request.method).toEqual('POST');
//     expect(req.request.headers.get('Content-Type')).toEqual('application/json');
//     // Then we set the fake data to be returned by the mock
//     req.flush(jobs);
//   });


//      // testing service for viewJobs method
//   it('viewJobs method should get all jobs', () => {
//     const jobList: Job[] = [
//   {
//     jobId : '12',
//     employerId : '22',
//     title : 'developer',
//     location : 'Toronto',
//     description : 'full stack developer',
//     postedDate :  '',
//     status :  'open',
//   },
//   {
//     jobId : '13',
//     employerId : '23',
//     title : 'developer2',
//     location : 'Montreal',
//     description : 'front end developer',
//     postedDate :  '',
//     status :  'open',
//   }
// ];

// // We call the service
//  service.viewJobs().subscribe(data => {
//   expect(data).toEqual(jobList);
// });
// // We set the expectations for the HttpClient mock
// const req = httpMock.expectOne('http://localhost:9096/job/viewJobs');
// expect(req.request.method).toEqual('GET');
// // Then we set the fake data to be returned by the mock
// req.flush(jobList);
// });


// //testing service for view one Job
// it('viewJob method should get one specific job', () => {
//   const jobList: Job[] = [
// {
//   jobId : '12',
//   employerId : '22',
//   title : 'developer',
//   location : 'Toronto',
//   description : 'full stack developer',
//   postedDate :  '',
//   status :  'open',
// },
// {
//   jobId : '13',
//   employerId : '23',
//   title : 'developer2',
//   location : 'Montreal',
//   description : 'front end developer',
//   postedDate :  '',
//   status :  'open',
// }
// ];

// // We call the service
// service.viewJob('12').subscribe(data => {
// expect(data).toEqual(jobList[0]);
// });
// // We set the expectations for the HttpClient mock
// const req = httpMock.expectOne('http://localhost:9096/job/viewJob/12');
// expect(req.request.method).toEqual('GET');
// // Then we set the fake data to be returned by the mock
// req.flush(jobList[0]);
// });

//     // testing service for removeJob method
//   it('removeJob method should delete one specific job', () => {
//     const jobList: Job[] = [
//       {
//         jobId : '12',
//         employerId : '22',
//         title : 'developer',
//         location : 'Toronto',
//         description : 'full stack developer',
//         postedDate :  '',
//         status :  'open',
//       },
//       {
//         jobId : '13',
//         employerId : '23',
//         title : 'developer2',
//         location : 'Montreal',
//         description : 'front end developer',
//         postedDate :  '',
//         status :  'open',
//       }
//       ];

//       // We call the service
//       service.removeJob('12').subscribe(data => {
//       expect(data).toEqual(jobList[0]);
//       });
//       // We set the expectations for the HttpClient mock
//       const req = httpMock.expectOne('http://localhost:9096/job/removeJob/12');
//       expect(req.request.method).toEqual('DELETE');
//       // Then we set the fake data to be returned by the mock
//       req.flush(jobList[0]);
//       });
//   });

