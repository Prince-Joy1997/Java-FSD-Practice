import { Pipe, PipeTransform } from '@angular/core';
import { jobSeeker } from '../models/jobSeeker';

@Pipe({
  name: 'jobapplicantpipe',
  pure: false
})

export class jobapplicantpipe implements PipeTransform {
  transform(jobSeekers: jobSeeker[], searchText: any): jobSeeker[] {

    if(searchText == null){
      return jobSeekers;

    }else if (Array.isArray(jobSeekers)) {

      return jobSeekers.filter((jobItem:jobSeeker)=> {

        return (jobItem.firstName.toLowerCase().includes(searchText.toLowerCase()) ||
                jobItem.lastName.toLowerCase().includes(searchText.toLowerCase()) ||
                jobItem.email.toLowerCase().includes(searchText.toLowerCase()) ||
                jobItem.address.toLowerCase().includes(searchText.toLowerCase()) )
    });

    }else{
        return jobSeekers;
    }
  }
}