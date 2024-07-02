import { Component } from '@angular/core';
import { DepartmentCardComponent } from '../department-card/department-card.component';
import { Department } from '../models/department';
import { DataPassService } from '../services/data-pass.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [DepartmentCardComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor (private dataPassService: DataPassService) {
    this.dataPassService.faveDeptObservable.subscribe(data => {
      this.favoriteDepartment = data;
    })
  }

  favoriteDepartment: Department = new Department(1000, 'Default', []);

}
