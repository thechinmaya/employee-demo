import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from '@angular/router';
import {ApiService} from "../core/api.service";
import {Employee} from "../model/emp.model";
import {Department} from "../model/dept.model";


@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  departments: Department[];
  genders: string[];

  constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }

  addForm: FormGroup;
  submitted = false;

  ngOnInit() {

      this.addForm = this.formBuilder.group({
      id: [],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: ['', Validators.required],
      dob: ['', Validators.required],
      department: ['', Validators.required]   
    });

    this.apiService.getDepartments()
      .subscribe( (data) => {
          console.log(data.result);
          console.log(data.message);
          this.departments = data;
      }
      );

    this.apiService.getGenders()
      .subscribe( (data) => {
          console.log(data.result);
          console.log(data.message);
          this.genders = data;
      }
      );

  }

  onSubmit() {
        this.submitted = true;
        // stop here if form is invalid
        if (this.addForm.invalid) {
            return;
        }

        console.log(this.addForm.value);
        console.log(this.addForm.value.department.deptName)

        let emp = <Employee>{};
        emp.firstName = this.addForm.value.firstName;
        emp.lastName = this.addForm.value.lastName;
        emp.dob = this.addForm.value.dob;
        emp.gender = this.addForm.value.gender;
        emp.department = new Department(this.addForm.value.department,null);

        console.log(JSON.stringify(emp));

       
        this.apiService.createemployee(emp)
            .subscribe( data => {
                    this.router.navigate(['view-emp']);
         });
  }

  goBack(){
        this.router.navigate(['view-emp']);
  }

}
