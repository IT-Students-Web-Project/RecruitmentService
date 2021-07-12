import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Person } from 'src/models/person';
@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private persons: BehaviorSubject<Person[]> = new BehaviorSubject<Person[]>([]);

  constructor(private http :HttpClient) { }
  getAllPersons(): Observable<Person[]>{
    return this.http.get<Person[]>("https://localhost:8080/persons");
  }
  getPersonsWithSkill(id: number): Observable<Person[]>{
    if(id>=0)
      return this.http.get<Person[]>("https://localhost:8080/persons?id="+id);
  }
  observe(): Observable<Person[]>{
    return this.persons.asObservable();
  }
}
