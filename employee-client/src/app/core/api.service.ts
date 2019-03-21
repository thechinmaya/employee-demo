import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Employee} from "../model/emp.model";
import {Observable} from "rxjs/index";

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/api';
  
  getEmployees() : Observable<any> {
    console.log("calling getemployees");
    return this.http.get<any>(this.baseUrl + "/getAllEmployees");
  }

 
  createemployee(emp: Employee): Observable<any> {
    return this.http.post<any>(this.baseUrl + "/createEmployee", emp);
  }

 
}
