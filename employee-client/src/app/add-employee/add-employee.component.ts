import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from '@angular/router';
import {ApiService} from "../core/api.service";

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

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
  }

  onSubmit() {
        this.submitted = true;
        // stop here if form is invalid
        if (this.addForm.invalid) {
            return;
        }

        this.apiService.createemployee(this.addForm.value)
            .subscribe( data => {
                    this.router.navigate(['view-emp']);
         });
  }

  goBack(){
        this.router.navigate(['view-emp']);
  }

}
