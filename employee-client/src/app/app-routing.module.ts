import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'add-emp', component: AddEmployeeComponent },
  { path: 'view-emp', component: ViewEmployeeComponent },
  {path : '', component : LoginComponent}
];

export const routing = RouterModule.forRoot(routes);
