import { Component } from '@angular/core';
import { TokenService } from '../services/token.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-oauth',
  standalone: true,
  imports: [],
  templateUrl: './oauth.component.html',
  styleUrl: './oauth.component.css'
})
export class OauthComponent {

  constructor(private tokenService: TokenService, private http: HttpClient) {}

  tokenRequestBody: any = {
    client_id:"rfgpTrs1GAcZMXY0P3V8fkTmCDcqpwqm",
    client_secret:"xKReZzKiWIeaFhff9RD1RVKNEdyb5tk9jkdaCZvkxQ5X7vHtU_DsDoAKi6YIsMcB",
    audience:"https://oauth-demo-server",
    grant_type:"client_credentials"
  }

  getToken() {
    // bypassing Auth provider's possible CORS filter by going through backend
    this.http.get<any>("http://localhost:9001/message/token", { observe: 'response' })
            .subscribe(data => {
              console.log(data);
              this.tokenService.setToken(data.body.access_token);
            })
  }

  getPublicMessage() {
    this.http.get<any>("http://localhost:9001/message/public", { observe: 'response' })
            .subscribe(data => {
              console.log(data);
            })
  }

  getPrivateMessage() {
    this.http.get<any>("http://localhost:9001/message/private", { observe: 'response' })
    .subscribe(data => {
      console.log(data);
    })
  }

}
