import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { HttpService } from '../services/http.service';
import { Department } from '../models/department';
import { DepartmentCardComponent } from '../department-card/department-card.component';

@Component({
  selector: 'app-departments',
  standalone: true,
  imports: [CommonModule, DepartmentCardComponent],
  templateUrl: './departments.component.html',
  styleUrl: './departments.component.css'
})
export class DepartmentsComponent {

  // within the class itself, we can declare variables
  // we can set up methods
  // we can have a constructor
  // we can inject dependencies

  // we should give our variables a type
  // any not good in prod, should replace with specific type
  departments: Department[] = [];

  // this injects HttpClient for us to use
  // dependency injection
  // the client is a singleton, like when we inject services in Spring
  constructor(private httpService: HttpService) {
    
    this.getAllDepartments();
  }

  getAllDepartments() {
    // running a GET call, subscribing to and processing the response
    this.httpService.getAllDepartments()
        .subscribe(response => {
          
            this.departments = [];

            for (let item of response.body) {
              this.departments.push(
                new Department(item.departmentId, item.departmentName, item.employees)
              )
            }

            console.log(this.departments);
          
        });
  }

  // local methods for calling our service methods
  getDepartmentById() {
    this.httpService.getDepartmentById();
  }

  createDepartment() {
    this.httpService.createDepartment().subscribe(data => {
      // doing this inside the subscription to guarantee it happens in sequence
      this.getAllDepartments();
    });
  }

  updateDepartment() {
    this.httpService.updateDepartment().subscribe(data => {
      this.getAllDepartments();
    });
  }

  deleteDepartment() {
    this.httpService.deleteDepartment().subscribe(data => {
      this.getAllDepartments();
    });
  }

}
