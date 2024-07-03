import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Department } from '../models/department';
import { HttpService } from '../services/http.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-department-detail',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './department-detail.component.html',
  styleUrl: './department-detail.component.css'
})
export class DepartmentDetailComponent {

  // a local object for storing our department
  dept: Department = new Department(0,'',[]);

  // ActivatedRoute allows us to have access to values included in the route/URL
  constructor(private route: ActivatedRoute, private httpService: HttpService) {
    this.getDepartmentById();
  }

  getDepartmentById() {
    // this syntax allows us to access specific parameter values
    this.httpService.getDepartmentById(this.route.snapshot.params['id'])
                    .subscribe(data => {
                      this.dept = data.body;

                      this.updatedDepartment.departmentId = data.body.departmentId;
                      this.updatedDepartment.departmentName = data.body.departmentName;
                    });
  }

  // for holding and modeling our department updates
  updatedDepartment: Department = new Department(0,'',[]);

  // a method for updating our current Department
  updateDepartment() {
    this.httpService.updateDepartment(this.updatedDepartment)
        .subscribe(data => {
          this.getDepartmentById();
        });
  }

}
