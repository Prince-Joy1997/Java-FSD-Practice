import { Pipe, PipeTransform } from '@angular/core';
import { Job } from '../models/job';

@Pipe({
  name: 'jobSeekerSearchPipe',
  pure: false
})

export class jobSeekerSearchPipe implements PipeTransform {

  transform(jobs: Job[], searchText: any): Job[] {
    if(searchText == null){
      return jobs;
    }else if (Array.isArray(jobs)) {
      return jobs.filter((jobItem:Job)=> {
        return (jobItem.title.toLowerCase().includes(searchText.toLowerCase()) || 
                jobItem.location.toLowerCase().includes(searchText.toLowerCase()) ||
                jobItem.employerId.toLowerCase().includes(searchText.toLowerCase()) ||
                jobItem.status.toLowerCase().includes(searchText.toLowerCase()))
    });
    }else{
        return jobs;
    }
  }
}
