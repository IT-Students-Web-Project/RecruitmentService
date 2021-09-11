import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Person } from 'src/models/person';
import { Skill } from 'src/models/skill';
@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private persons: BehaviorSubject<Person[]> = new BehaviorSubject<Person[]>([]);

  constructor(private http :HttpClient) { }
  getAllPersons(): Observable<Person[]>{
    return this.http.get<Person[]>("http://localhost:8080/persons");
  }
  getPersonsWithSkill(id: number): Observable<Person[]>{
    if(id>=0)
      return this.http.get<Person[]>("http://localhost:8080/persons?id="+id);
  }
  observe(): Observable<Person[]>{
    return this.persons.asObservable();
  }
  
  getPersonsBySkills(selectedSkills: Skill[]) { 
    let idSkills= "";
    selectedSkills.forEach(s => {
      idSkills += s.id + ",";
    });
    idSkills = idSkills.substr(0, idSkills.length - 1)

    const params: HttpParams = new HttpParams().set("idSkills", idSkills);
    return this.http.get<Person[]>("http://localhost:8080/personsBySkills", {params});
  }
}
