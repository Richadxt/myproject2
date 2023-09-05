import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './loginmodule/login/login.component';
import { DashboardComponent } from './loginmodule/dashboard/dashboard.component';
import { EmpProfileComponent } from './loginmodule/emp-profile/emp-profile.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {path:'dashboard', component:DashboardComponent},
  { path: 'login', component: LoginComponent },
  { path: 'emp-profile', component: EmpProfileComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

