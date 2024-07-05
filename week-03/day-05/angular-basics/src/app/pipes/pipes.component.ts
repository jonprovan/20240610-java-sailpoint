import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-pipes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pipes.component.html',
  styleUrl: './pipes.component.css'
})
export class PipesComponent {

  // dates we want to unify visually using a Pipe Transform
  dates: string[] = [
    '8-5-24',
    '07-11-2023',
    '12/5/1924',
    '1.6.20',
    'May 15, 1977'
  ]

  addDate() {
    this.dates.push(this.dateToAdd);
  }

  dateToAdd: string = '';

}
