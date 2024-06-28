import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
// importing the header component for use in this component
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

// this annotation sets up this as a component
// we can import and display this component wherever we need to
// it is NOT a dependency that gets injected
// selector = what you use to call it in another component's HTML
// standalone = gotta do all relevant imports here directly
// templateUrl = the HTML file for this component
// styleeUrl = the CSS file for this component
@Component({
  selector: 'app-root',
  standalone: true,
  // also must include it here
  imports: [RouterOutlet, HeaderComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-basics';
}
