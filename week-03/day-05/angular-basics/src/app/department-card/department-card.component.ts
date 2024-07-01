import { Component, Input } from '@angular/core';
import { Department } from '../models/department';

@Component({
  selector: 'app-department-card',
  standalone: true,
  imports: [],
  templateUrl: './department-card.component.html',
  styleUrl: './department-card.component.css'
})
export class DepartmentCardComponent {

  // this decorator allows us to take input in from the parent component
  // and assign it a variable for this component

  // @Input() localVariableName: type = default value
  // the actual value will come down from the parent
  @Input() department: Department = new Department(0,'asdf',[ { employeeFirstname: 'Joe'} ]);

}
