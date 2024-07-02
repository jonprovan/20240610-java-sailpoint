import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { HttpService } from '../services/http.service';
import { Department } from '../models/department';
import { DepartmentCardComponent } from '../department-card/department-card.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-departments',
  standalone: true,
  imports: [CommonModule, DepartmentCardComponent, FormsModule],
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
  departmentIds: number[] = [];
  departmentNames: string[] = [];

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
            this.departmentIds = [];
            this.departmentNames = [];

            for (let item of response.body) {
              this.departments.push(
                new Department(item.departmentId, item.departmentName, item.employees)
              );

              this.departmentIds.push(item.departmentId);
              this.departmentNames.push(item.departmentName);
            }
          
        });
  }

  // form value for the ID in our getDepartmentById form
  formDepartmentId: number = 0;

  // local methods for calling our service methods
  getDepartmentById() {
    this.httpService.getDepartmentById(this.formDepartmentId).subscribe(data => {
      this.departments = [];
      this.departments.push(data.body);
    });
  }

  formDepartment: Department = new Department(0,'',[]);

  createDepartment() {
    this.httpService.createDepartment(this.formDepartment).subscribe(data => {
      // doing this inside the subscription to guarantee it happens in sequence
      console.log(data);
      
      this.getAllDepartments();
    });
  }

  updateDepartment() {
    this.httpService.updateDepartment().subscribe(data => {
      this.getAllDepartments();
    });
  }

  deleteDepartment(departmentId: number) {
    this.httpService.deleteDepartment(departmentId).subscribe(data => {
      this.getAllDepartments();
    });
  }

  // this method runs when the deleteDepartmentEvent is heard from a child
  processDeleteEvent(departmentId: number) {
    this.deleteDepartment(departmentId);
  }

}
