
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/model/LoginRequest';
import { EmpService } from 'src/app/service/emp.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
 
  constructor(
    private empService:EmpService,
    private _router:Router
  ) { }

  ngOnInit(): void{

  }

  error:any;
  loginRequest:LoginRequest=new LoginRequest()

  
  login(){
   
    this.empService.loginEmp(this.loginRequest).subscribe((response:any) => {

      if(response.status){
        this._router.navigate(['/dashboard']);
        //login success
        this.error = "";
      }else{
        //
        this.error = response.message;
      }
   }, (error) => {
     
   })

  }

}
