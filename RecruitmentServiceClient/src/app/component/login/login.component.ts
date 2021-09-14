import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login, LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: Login = {
    username: null,
    password: null
  }
  error: string;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  logIn(): void {
    this.loginService.authorize(this.login).subscribe(res => {
      if (res)
        this.router.navigateByUrl('');
      else
        this.error = "Niepoprawny login lub hasło!";
    })
  }

}
