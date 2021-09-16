import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Person } from 'src/models/person';
import { Skill } from 'src/models/skill';
import { LoginService } from './login.service';
@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient, private loginService: LoginService) { }
  getAllPersons(): Observable<Person[]> {
    const headers: HttpHeaders = this.loginService.authorizationHeader();
    console.log(headers);
    return this.http.get<Person[]>("http://localhost:8080/persons", { headers: headers });
  }
  getPersonsWithSkill(id: number): Observable<Person[]> {
    if (id >= 0)
      return this.http.get<Person[]>("http://localhost:8080/persons?id=" + id, { headers: this.loginService.authorizationHeader() });
  }

  getPersonsBySkills(selectedSkills: Skill[], city: string) {
    let idSkills = "";
    selectedSkills.forEach(s => {
      idSkills += s.id + ",";
    });
    idSkills = idSkills.substr(0, idSkills.length - 1)

    const headers: HttpHeaders = this.loginService.authorizationHeader();
    console.log(headers);
    let params: HttpParams = new HttpParams()
      .set("idSkills", idSkills)
      .set("city", city);
    return this.http.get<Person[]>("http://localhost:8080/personsBySkills", { params: params, headers: headers });
  }

  getPersonsCities() {
    return this.http.get<string[]>("http://localhost:8080/personsCities", { headers: this.loginService.authorizationHeader() });
  }

  addPerson(person: Person): Observable<Person> {
    return this.http.post<Person>('http://localhost:8080/addPerson', person, {
      headers: this.loginService.authorizationHeader()
    });
  }

  getPerson(id: number): Observable<Person> {
    return this.http.get<Person>('http://localhost:8080/person/' + id, {
      headers: this.loginService.authorizationHeader()
    });
  }

  editPerson(person: Person) : Observable<Person> {    
    return  this.http.put<Person>('http://localhost:8080/person/', person, {
      headers: this.loginService.authorizationHeader()
    });
  }

  deletePerson(id: number) : Observable<Person[]> {
    return  this.http.delete<Person[]>('http://localhost:8080/person/'+ id, {
      headers: this.loginService.authorizationHeader()
    });
  }
}
