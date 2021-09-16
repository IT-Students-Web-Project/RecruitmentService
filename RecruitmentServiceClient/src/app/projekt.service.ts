import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Skill } from 'src/models/skill';
import { LoginService } from './service/login.service';

export interface Project {
  id: number;
  name: string;
  description: string;
}

@Injectable({
  providedIn: 'root'
})
export class ProjektService {

  private levels: BehaviorSubject<Skill[]> = new BehaviorSubject<Skill[]>([]);

  constructor(private http: HttpClient, private loginService: LoginService) { }

  getProjects(): Observable<Project[]> { 
    return this.http.get<Project[]>('http://localhost:8080/projects', { headers: this.loginService.authorizationHeader()}); 
  }

  observe(): Observable<Skill[]> { return this.levels.asObservable(); }
}
