import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

// in Angular @something is called a Decorator
// basically just like a Spring annotation
// indicates the function/type of a file

// @Injectable means this is a service that can be injected
// as a dependency in another compoonent
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  url: String = 'http://localhost:8080/';

  // a GET request for all Departments
  getAllDepartments() {
    return this.http.get(this.url + 'department', { observe : 'response' });
  }

  // a GET request for a single Department (by id as a path variable)
  getDepartmentById() {

  }

  // a POST request to create a Department (Department object in the body)
  createDepartment() {
    return this.http.post(this.url + 'department', 
                          { "departmentId": 30,
                            "departmentName": "Test Post Department X",
                            "employees": [] }, 
                          { observe : 'response' });
  }

  // a PUT request to update a Department
  // request parameters for name and id, List of employees in the body
  updateDepartment() {

    // assembling an HttpParams object for our request parameters and setting values
    let parameters = new HttpParams()
                         .set('id', '25')
                         .set('name', 'Fully Updated Department');

    // the params object gets inserted into the options object as the params property
    return this.http.put(this.url + 'department', 
                         [], 
                         { observe: 'response', 
                           params: parameters });
  }

  // a DELETE request to delete a Department (by id as a path variable)
  deleteDepartment() {
    return this.http.delete(this.url + 'department/' + 28, { observe: 'response'});
  }
}
