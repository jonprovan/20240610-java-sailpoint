import { Component } from '@angular/core';
import { Detail } from '../models/detail';
import { HttpService } from '../services/http.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-details',
  standalone: true,
  // import this if using a Reactive Form, as opposed to
  // FormsModule for the ngModel version
  imports: [ReactiveFormsModule],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent {

  details: Detail[] = [];

  constructor(private httpService: HttpService,
              private formBuilder: FormBuilder) {
    this.getAllDetails();
  }

  // this FormGroup controls our creation form
  // each control is tied to a specific field
  createDetailForm: FormGroup = this.formBuilder.group(
    // this object, the single parameter, contains all the controls
    {
      // this is a single FormControl for a single form field
      // first element in the array is the starting/default value
      // second element is a single Validator or a composition of them
      // Validators are what criteria the field needs to meet
      // in order to be considered "valid"
      detailText: ['', Validators.compose([Validators.required, 
                                           Validators.minLength(10),
                                           Validators.maxLength(20)])],
      detailFun: ['', Validators.required]
    }
  );

  get detailText() {
    return this.createDetailForm.get('detailText');
  }

  get detailFun() {
    return this.createDetailForm.get('detailFun');
  }




  getAllDetails() {
    this.httpService.getAllDetails().subscribe(data => {

      this.details = [];
      
      for(let detail of data.body) {
        this.details.push(new Detail(detail.detailId, detail.detailText));
      }
    });
  }

  createNewDetail() {

  }

}
