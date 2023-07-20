import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'jobSeekerAppliedJobsPipe',
  pure: false
})

export class jobSeekerAppliedJobsPipe implements PipeTransform {

  transform(applications: any[], searchText: any): any[] {
    if(searchText == null){
      return applications;
    }else if (Array.isArray(applications)) {
      return applications.filter((applicationItem:any)=> {
        return (applicationItem.title.toLowerCase().includes(searchText.toLowerCase()) ||
                applicationItem.employerId.toLowerCase().includes(searchText.toLowerCase()) ||
                applicationItem.location.toLowerCase().includes(searchText.toLowerCase()) ||
                applicationItem.status.toLowerCase().includes(searchText.toLowerCase()))
    });
    }else{
        return applications;
    }
  }
}
