"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.DashboardComponent = void 0;
var core_1 = require("@angular/core");
var employee_1 = require("src/app/model/employee");
var DashboardComponent = /** @class */ (function () {
    function DashboardComponent(empService) {
        this.empService = empService;
        //Properties for sorting
        this.sortAscendingName = true;
        this.sortAscendingAge = true;
        this.rowNumber = 1;
        this.employee = new employee_1.Employee();
        this.empList = [];
    }
    DashboardComponent.prototype.ngOnInit = function () {
        this.fetchEmp('TOTAL');
    };
    // Sort by Name
    DashboardComponent.prototype.sortByName = function () {
        var _this = this;
        this.empList.sort(function (a, b) {
            if (_this.sortAscendingName) {
                return a.name.localeCompare(b.name);
            }
            else {
                return b.name.localeCompare(a.name);
            }
        });
        this.sortAscendingName = !this.sortAscendingName;
    };
    // Sort by Age
    DashboardComponent.prototype.sortByAge = function () {
        var _this = this;
        this.empList.sort(function (a, b) {
            if (_this.sortAscendingAge) {
                return a.age - b.age;
            }
            else {
                return b.age - a.age;
            }
        });
        this.sortAscendingAge = !this.sortAscendingAge;
    };
    DashboardComponent.prototype.fetchEmp = function (status) {
        var _this = this;
        if (status == 'INVITED') {
            this.employee.status = "PENDING";
        }
        else if (status == 'APPROVED') {
            this.employee.status = "APPROVED";
        }
        else {
            this.employee.status = '';
        }
        this.empService.getAllEmployee(this.employee).subscribe(function (response) {
            _this.empList = response;
        }, function (error) {
        });
    };
    DashboardComponent.prototype.search = function () {
        this.fetchEmp();
    };
    DashboardComponent = __decorate([
        core_1.Component({
            selector: 'app-dashboard',
            templateUrl: './dashboard.component.html',
            styleUrls: ['./dashboard.component.css']
        })
    ], DashboardComponent);
    return DashboardComponent;
}());
exports.DashboardComponent = DashboardComponent;
