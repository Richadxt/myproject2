// import { Component, OnInit } from '@angular/core';
// import { ActivatedRoute } from '@angular/router';
// import { Employee } from 'src/app/model/employee';
// import { EmpService } from 'src/app/service/emp.service';

// @Component({
//   selector: 'app-emp-profile',
//   templateUrl: './emp-profile.component.html',
//   styleUrls: ['./emp-profile.component.css']
// })
// export class EmpProfileComponent implements OnInit {

//   constructor(
//     private activatedRoute: ActivatedRoute,
//     private empService:EmpService
//   ) { }

//   empId:any;
//   ngOnInit(): void {
//     this.empId = this.activatedRoute.snapshot.queryParamMap.get('id');

//     console.log("EMPID======"+this.empId);

//     this.fetchSingleEmp();
//   }


//   employee:Employee=new Employee();
//   fetchSingleEmp() {
//    this.empService.getEmployee(this.empId ).subscribe((response:any) => {
//       this.employee=response;
//    }, (error) => {
     
//    })
//  }


//  addressList:any[]=new Array();
//  getAddressList() {
//    this.empService.getAddressList(this.empId ).subscribe((response:any) => {
//       this.addressList=response;
//    }, (error) => {
     
//    })
//  }

//  academicDetailsList:any[]=new Array();
//  getAcademicDetailsList() {
//    this.empService.getAcademicDetailsList(this.empId ).subscribe((response:any) => {
//       this.academicDetailsList=response;
//    }, (error) => {
     
//    })
//  }

//  experienceList:any[]=new Array();
//  getExperienceList() {
//    this.empService.getExperienceList(this.empId ).subscribe((response:any) => {
//       this.experienceList=response;
//    }, (error) => {
     
//    })
//  }

// }

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { EmpService } from 'src/app/service/emp.service';

@Component({
  selector: 'app-emp-profile',
  templateUrl: './emp-profile.component.html',
  styleUrls: ['./emp-profile.component.css']
})
export class EmpProfileComponent implements OnInit {
  constructor(
    private activatedRoute: ActivatedRoute,
    private empService: EmpService
  ) {}

  empId: any;
  ngOnInit(): void {
    this.empId = this.activatedRoute.snapshot.queryParamMap.get('id');

    console.log('EMPID======' + this.empId);

    this.fetchSingleEmp();
    this.getExperienceList(); // Call this function to fetch experience data
    this.getAcademicDetailsList(); // Call this function to fetch academic data
  }

  employee: Employee = new Employee();
  fetchSingleEmp() {
    this.empService.getEmployee(this.empId).subscribe(
      (response: any) => {
        this.employee = response;
      },
      (error) => {}
    );
  }

  addressList: any[] = new Array();
  getAddressList() {
    this.empService.getAddressList(this.empId).subscribe(
      (response: any) => {
        this.addressList = response;
      },
      (error) => {}
    );
  }

  academicDetailsList: any[] = new Array();
  getAcademicDetailsList() {
    this.empService.getAcademicDetailsList(this.empId).subscribe(
      (response: any) => {
        this.academicDetailsList = response;
      },
      (error) => {}
    );
  }

  experienceList: any[] = new Array();
  getExperienceList() {
    this.empService.getExperienceList(this.empId).subscribe(
      (response: any) => {
        this.experienceList = response;
      },
      (error) => {}
    );
  }
}
