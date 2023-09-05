"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.EmpService = void 0;
var http_1 = require("@angular/common/http");
var core_1 = require("@angular/core");
var EmpService = /** @class */ (function () {
    function EmpService(_http) {
        this._http = _http;
    }
    EmpService.prototype.loginEmp = function (req) {
        return this._http.post("http://localhost:8080/emp-management/login", req);
    };
    EmpService.prototype.getAllEmployee = function (emp) {
        var params = new http_1.HttpParams();
        if (emp.itemPerPage != undefined) {
            params = params.set('itemsPerPage', emp.itemPerPage);
        }
        else {
            params = params.set('itemsPerPage', 6);
        }
        if (emp.pageNumber != undefined) {
            params = params.set('pageNumber', emp.pageNumber);
        }
        else {
            params = params.set('pageNumber', 1);
        }
        // if(startDate!=undefined && endDate!=undefined){
        //   params=params .set('startDate', startDate)
        //   params=params .set('endDate', endDate)
        // }
        if (emp.search != undefined) {
            params = params.set('search', emp.search);
        }
        else {
            params = params.set('search', "");
        }
        if (emp.searchBy != undefined) {
            params = params.set('searchBy', emp.searchBy);
        }
        else {
            params = params.set('searchBy', "name");
        }
        if (emp.sortBy != undefined) {
            params = params.set('sortBy', emp.sortBy);
        }
        else {
            params = params.set('sortBy', "name");
        }
        if (emp.sortOrder != undefined) {
            params = params.set('sortOrder', emp.sortOrder);
        }
        else {
            params = params.set('sortOrder', "asc");
        }
        if (emp.status != undefined) {
            params = params.set('status', emp.status);
        }
        else {
            params = params.set('status', "");
        }
        return this._http.get("http://localhost:8080/emp-management/fetch", { params: params });
    };
    EmpService.prototype.getEmployee = function (id) {
        return this._http.get("http://localhost:8080/emp-management/single/" + id);
    };
    EmpService.prototype.getAddressList = function (id) {
        return this._http.get("http://localhost:8080/emp-management/address-list/" + id);
    };
    EmpService.prototype.getAcademicDetailsList = function (id) {
        return this._http.get("http://localhost:8080/emp-management/academic-list/" + id);
    };
    EmpService.prototype.getExperienceList = function (id) {
        return this._http.get("http://localhost:8080/emp-management/experience-list/" + id);
    };
    EmpService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], EmpService);
    return EmpService;
}());
exports.EmpService = EmpService;
