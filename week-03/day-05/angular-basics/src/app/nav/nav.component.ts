import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { DataPassService } from '../services/data-pass.service';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {

  departmentName: string = '';

  constructor(private dataPassService: DataPassService) {
    this.dataPassService.faveDeptObservable.subscribe(data => {
      this.departmentName = data.departmentName;
    })
  }

}
