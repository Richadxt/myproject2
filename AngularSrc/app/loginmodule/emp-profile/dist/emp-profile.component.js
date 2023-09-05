"use strict";
// import { Component, OnInit } from '@angular/core';
// import { ActivatedRoute } from '@angular/router';
// import { Employee } from 'src/app/model/employee';
// import { EmpService } from 'src/app/service/emp.service';
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.EmpProfileComponent = void 0;
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
var core_1 = require("@angular/core");
var employee_1 = require("src/app/model/employee");
var EmpProfileComponent = /** @class */ (function () {
    function EmpProfileComponent(activatedRoute, empService) {
        this.activatedRoute = activatedRoute;
        this.empService = empService;
        this.employee = new employee_1.Employee();
        this.addressList = new Array();
        this.academicDetailsList = new Array();
        this.experienceList = new Array();
    }
    EmpProfileComponent.prototype.ngOnInit = function () {
        this.empId = this.activatedRoute.snapshot.queryParamMap.get('id');
        console.log('EMPID======' + this.empId);
        this.fetchSingleEmp();
        this.getExperienceList(); // Call this function to fetch experience data
        this.getAcademicDetailsList(); // Call this function to fetch academic data
    };
    EmpProfileComponent.prototype.fetchSingleEmp = function () {
        var _this = this;
        this.empService.getEmployee(this.empId).subscribe(function (response) {
            _this.employee = response;
        }, function (error) { });
    };
    EmpProfileComponent.prototype.getAddressList = function () {
        var _this = this;
        this.empService.getAddressList(this.empId).subscribe(function (response) {
            _this.addressList = response;
        }, function (error) { });
    };
    EmpProfileComponent.prototype.getAcademicDetailsList = function () {
        var _this = this;
        this.empService.getAcademicDetailsList(this.empId).subscribe(function (response) {
            _this.academicDetailsList = response;
        }, function (error) { });
    };
    EmpProfileComponent.prototype.getExperienceList = function () {
        var _this = this;
        this.empService.getExperienceList(this.empId).subscribe(function (response) {
            _this.experienceList = response;
        }, function (error) { });
    };
    EmpProfileComponent = __decorate([
        core_1.Component({
            selector: 'app-emp-profile',
            templateUrl: './emp-profile.component.html',
            styleUrls: ['./emp-profile.component.css']
        })
    ], EmpProfileComponent);
    return EmpProfileComponent;
}());
exports.EmpProfileComponent = EmpProfileComponent;
