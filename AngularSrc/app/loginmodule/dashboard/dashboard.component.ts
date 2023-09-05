import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { EmpService } from 'src/app/service/emp.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(
    private empService: EmpService
  ) { }

  ngOnInit(): void {
   this.fetchEmp('TOTAL');
   
  }


  //Properties for sorting
  sortAscendingName: boolean = true;
  sortAscendingAge: boolean = true;

 // Sort by Name
  sortByName() {
    this.empList.sort((a, b) => {
      if (this.sortAscendingName) {
        return a.name.localeCompare(b.name);
      } else {
        return b.name.localeCompare(a.name);
      }
    });
    this.sortAscendingName = !this.sortAscendingName;
  }
 // Sort by Age
  sortByAge() {
    this.empList.sort((a, b) => {
      if (this.sortAscendingAge) {
        return a.age - b.age;
      } else {
        return b.age - a.age;
      }
    });
    this.sortAscendingAge = !this.sortAscendingAge;
  }

  rowNumber = 1;

  employee:Employee=new Employee();
  empList:Employee[]=[];

  fetchEmp(status?:any) {
     
     if(status=='INVITED'){
       this.employee.status="PENDING";
     }else if(status=='APPROVED'){
      this.employee.status="APPROVED";
     }else{
      this.employee.status='';
     }


     
    this.empService.getAllEmployee(this.employee).subscribe((response:any) => {
       this.empList=response;
    }, (error) => {
      
    })
  }

  search(){
    this.fetchEmp();
  }
}