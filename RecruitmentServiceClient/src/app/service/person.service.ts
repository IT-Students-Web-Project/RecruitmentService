import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Person } from 'src/models/person';
import { Skill } from 'src/models/skill';
import { LoginService } from './login.service';
@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private persons: BehaviorSubject<Person[]> = new BehaviorSubject<Person[]>([]);

  constructor(private http: HttpClient, private loginService: LoginService) { }
  getAllPersons(): Observable<Person[]> {
    return this.http.get<Person[]>("http://localhost:8080/persons", {headers: this.loginService.addAuthorizationHeader()});
  }
  getPersonsWithSkill(id: number): Observable<Person[]> {
    if (id >= 0)
      return this.http.get<Person[]>("http://localhost:8080/persons?id=" + id, {headers: this.loginService.addAuthorizationHeader()});
  }
  observe(): Observable<Person[]> {
    return this.persons.asObservable();
  }

  getPersonsBySkills(selectedSkills: Skill[], city: string) {
    let idSkills = "";
    selectedSkills.forEach(s => {
      idSkills += s.id + ",";
    });
    idSkills = idSkills.substr(0, idSkills.length - 1)

    let params: HttpParams = new HttpParams()
      .set("idSkills", idSkills)
      .set("city", city);
    return this.http.get<Person[]>("http://localhost:8080/personsBySkills",{ params:params , headers: this.loginService.addAuthorizationHeader()});
  }

  getPersonsCities() {
    return this.http.get<string[]>("http://localhost:8080/personsCities", {headers: this.loginService.addAuthorizationHeader()});
  }
}
