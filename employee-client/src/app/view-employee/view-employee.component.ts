import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Employee} from "../model/emp.model";
import {ApiService} from "../core/api.service";

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {

  employees: Employee[];

  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    console.log("onNgInit getEmployees");
    this.apiService.getEmployees()
      .subscribe( (data) => {
          console.log(data.result);
          console.log(data.message);
          this.employees = data;
      }
      );
  }

  addEmployee(): void {
    this.router.navigate(['add-emp']);
  };
}
