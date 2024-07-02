import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Department } from '../models/department';
import { DataPassService } from '../services/data-pass.service';

@Component({
  selector: 'app-department-card',
  standalone: true,
  imports: [],
  templateUrl: './department-card.component.html',
  styleUrl: './department-card.component.css'
})
export class DepartmentCardComponent {

  // injecting our DataPassService so we can send a fave dept to it
  constructor(private dataPassService: DataPassService) {}

  // this decorator allows us to take input in from the parent component
  // and assign it a variable for this component

  // @Input() localVariableName: type = default value
  // the actual value will come down from the parent
  @Input() department: Department = new Department(0,'asdf',[ { employeeFirstname: 'Joe'} ]);
  
  // @Output() eventName = new EventEmitter<type of value to pass up>();
  // this allows us to have the parent "listen" for this type of event
  // and do something with the value
  @Output() deleteDepartmentEvent = new EventEmitter<number>();

  // when we click the DELETE button
  deleteThisDepartment() {
    // .emit makes the EventEmitter emit an event with the included value
    this.deleteDepartmentEvent.emit(this.department.departmentId);
  }

  sendFavoriteDepartment() {
    this.dataPassService.updateFavoriteDepartment(this.department);
  }

}
