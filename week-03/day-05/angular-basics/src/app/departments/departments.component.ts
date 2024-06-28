import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-departments',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
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
  data: any = [];

  // this injects HttpClient for us to use
  // dependency injection
  // the client is a singleton, like when we inject services in Spring
  constructor(private http: HttpClient) {
    
    // running a GET call, subscribing to and processing the response
    this.http.get('http://localhost:8080/department', { observe : 'response' })
        .subscribe(response => {
          this.data = response.body;  // storing the data locally
        });
  }

}
