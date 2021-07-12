import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Level } from 'src/models/level';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LevelService {

  private levels: BehaviorSubject<Level[]> = new BehaviorSubject<Level[]>([]);

  constructor(private http :HttpClient) { }
  getLevels(): Observable<Level[]>{
    return this.http.get<Level[]>("https://localhost:8080/levels");
  }
  observe(): Observable<Level[]>{
    return this.levels.asObservable();
  }
}
