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
            this.departmentNotThere = false;

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
  // we're changing this to true if we don't find the get-by id in our database
  // this triggers the error text block to appear on the page
  departmentNotThere: boolean = false;

  // local methods for calling our service methods
  // handling error responses to this method with Observer arguments
  getDepartmentById() {
    this.httpService.getDepartmentById(this.formDepartmentId).subscribe(
      // this object contains our observer arguments
      // next for success, error for failure, complete for all
      {
        next: data => {                     // some lambda for a successful response

          this.departments = [];
          this.departments.push(data.body);
          this.departmentNotThere = false;
          console.log('Success!');
        },
        error: err => {                     // some lambda for an error response
          console.log(err);
          this.departmentNotThere = true
        },     
        // a lambda for something to do AFTER a successful response
        // useful for void return HTTP methods like DELETE
        complete: () => console.log('Observer arguments complete.') 
      }
    );
  }

  formDepartment: Department = new Department(0,'',[]);

  createDepartment() {
    this.httpService.createDepartment(this.formDepartment).subscribe(data => {
      // doing this inside the subscription to guarantee it happens in sequence
      console.log(data);
      
      this.getAllDepartments();
    });
  }

  // updateDepartment() {
  //   this.httpService.updateDepartment().subscribe(data => {
  //     this.getAllDepartments();
  //   });
  // }

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
