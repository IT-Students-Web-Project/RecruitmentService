import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Skill } from 'src/models/skill';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  private levels: BehaviorSubject<Skill[]> = new BehaviorSubject<Skill[]>([]);

  constructor(private http :HttpClient) { }
  getSkills(): Observable<Skill[]>{
    return this.http.get<Skill[]>("https://localhost:8080/skills");
  }
  observe(): Observable<Skill[]>{
    return this.levels.asObservable();
  }
}
