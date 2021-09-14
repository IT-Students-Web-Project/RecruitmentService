import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Skill } from 'src/models/skill';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  constructor(private http: HttpClient, private loginService: LoginService) { }

  getSkills(): Observable<Skill[]>{ return this.http.get<Skill[]>('http://localhost:8080/skills',{headers: this.loginService.authorizationHeader()}); }
}
