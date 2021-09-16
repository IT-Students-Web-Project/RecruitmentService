import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Skill } from 'src/models/skill';
import { LoginService } from './login.service';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  private skills: BehaviorSubject<Skill[]> = new BehaviorSubject<Skill[]>([]);

  constructor(private http: HttpClient, private loginService: LoginService) { }
  subscribeToChanges(): Observable<Skill[]> { return this.skills.asObservable(); }
  getSkills(): Observable<Skill[]>{ return this.http.get<Skill[]>('http://localhost:8080/skills', {
    headers: this.loginService.authorizationHeader()}); }
  getSkill(id: number): Observable<Skill> { return this.http.get<Skill>('http://localhost:8080/skill/' + id, {
    headers: this.loginService.authorizationHeader()}); }
  removeSkill(id: number): Observable<Skill[]> { return this.http.delete<Skill[]>('http://localhost:8080/skill/' + id, {
    headers: this.loginService.authorizationHeader()}).pipe(tap(result => this.skills.next(result))); }
  addSkill(skill: Skill): Observable<Skill[]> { return  this.http.post<Skill[]>('http://localhost:8080/addSkill', skill, {
    headers: this.loginService.authorizationHeader()}).pipe(tap(result => this.skills.next(result))); }
  editSkill(id: number, skill: Skill): Observable<Skill[]> { return  this.http.put<Skill[]>('http://localhost:8080/skill/' + id, skill, {
  headers: this.loginService.authorizationHeader()}).pipe(tap(result => this.skills.next(result))); }
}
