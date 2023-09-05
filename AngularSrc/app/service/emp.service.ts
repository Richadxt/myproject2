import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
import { LoginRequest } from '../model/LoginRequest';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  constructor(private _http: HttpClient) { }

  loginEmp(req:LoginRequest): Observable<any>{
    return this._http.post<any>("http://localhost:8080/emp-management/login",req)
  }

  
  getAllEmployee(emp:Employee){
    var params = new HttpParams();


    if(emp.itemPerPage!=undefined){
     params=params.set('itemsPerPage',emp.itemPerPage)
    }else{
      params=params.set('itemsPerPage',6)
    }
    if(emp.pageNumber!=undefined){
     params=params.set('pageNumber',emp.pageNumber)
    }else{
      params=params.set('pageNumber',1) 
    }

    // if(startDate!=undefined && endDate!=undefined){
    //   params=params .set('startDate', startDate)
    //   params=params .set('endDate', endDate)
    // }
    if(emp.search!=undefined){
     params=params.set('search',emp.search)
    }else{
      params=params.set('search',"")
    }

    if(emp.searchBy!=undefined){
     params=params.set('searchBy',emp.searchBy)
    }else{
      params=params.set('searchBy',"name") 
    }
    
    if(emp.sortBy!=undefined){
      params=params .set('sortBy',emp.sortBy);
    }else{
      params=params .set('sortBy',"name");
    }
    
    if(emp.sortOrder!=undefined){
      params=params .set('sortOrder',emp.sortOrder)
    }else{
      params=params .set('sortOrder',"asc")
    }   
    
    if(emp.status!=undefined){
      params=params .set('status',emp.status)
    }else{
      params=params .set('status',"")
    } 

    return this._http.get<any>("http://localhost:8080/emp-management/fetch", {params});
  }
  

  getEmployee(id:any){
    return this._http.get<any>("http://localhost:8080/emp-management/single/"+id);
  }
  
  getAddressList(id:any){
    return this._http.get<any>("http://localhost:8080/emp-management/address-list/"+id);
  }
  
  getAcademicDetailsList(id:any){
    return this._http.get<any>("http://localhost:8080/emp-management/academic-list/"+id);
  }
  
  getExperienceList(id:any){
    return this._http.get<any>("http://localhost:8080/emp-management/experience-list/"+id);
  }
  
  
}
