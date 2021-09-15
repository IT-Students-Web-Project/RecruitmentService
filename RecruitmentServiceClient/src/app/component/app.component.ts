import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Login, LoginService } from '../service/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  displayLogout: Boolean = false;

  constructor(private loginService: LoginService) {}

  ngOnInit(){     
    this.loginService.getStatus().subscribe(s => this.displayLogout = s);
  }

  logout() {
    this.loginService.logout();
  }

  title = 'RecruitmentServiceClient';
}
