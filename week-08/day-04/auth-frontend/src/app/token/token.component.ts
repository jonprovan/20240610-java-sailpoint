import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TokenService } from '../services/token.service';

@Component({
  selector: 'app-token',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './token.component.html',
  styleUrl: './token.component.css'
})
export class TokenComponent {

  constructor(private http: HttpClient, private tokenService: TokenService) {}

  baseUrl: string = 'http://localhost:8675/';

  signupEmail: string = '';
  signupPassword: string = '';
  signupFullName: string = '';

  loginEmail: string = '';
  loginPassword: string = '';

  signup() {
    this.http.post(this.baseUrl + 'auth/signup',
                   { email: this.signupEmail, password: this.signupPassword, fullName: this.signupFullName },
                   { observe: 'response' }).subscribe(data => {
            console.log(data);
                   });
  }

  // this method stores the valid token in the service
  login() {
    this.http.post<any>(this.baseUrl + 'auth/login',
                   { email: this.loginEmail, password: this.loginPassword },
                   { observe: 'response' }).subscribe(data => {
            console.log(data.body.token);
            this.tokenService.setToken(data.body.token);
      });
  }

  // this requires token auth, but that's being added via interceptor
  getUsers() {
    this.http.get(this.baseUrl + 'users', { observe: 'response' }).subscribe(data => {
      console.log(data);
    })
  }

}
