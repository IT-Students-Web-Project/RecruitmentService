import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

export interface Login {
  username: string;
  password: string;
}

export interface LoginRes {
  token: string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userStateChangeEvent: EventEmitter<void> = new EventEmitter<void>();

  constructor(private http: HttpClient) { }

  getAuthorizedUser(): LoginRes | null {
    let loginRes = JSON.parse(sessionStorage.getItem('user')) as LoginRes;
    if(loginRes != null && this.isTokenExpired(loginRes.token)) {
      this.logout();
      loginRes = null;
    }
    return loginRes;
  }
  

  addAuthorizationHeader(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.getAuthorizedUser()?.token);
  }

  private isTokenExpired(token: string): boolean {
    token.split('.').forEach(c => {
      try {
        console.log(atob(c));
      } catch {
        console.log("Oryginał: " + c);
      }
    });

    let expireDate = (JSON.parse(atob(token.split('.')[1]))).exp;
    let now = (Math.floor((new Date).getTime() / 1000));
    return now >= expireDate;
  }

  authorize(login: Login): Observable<boolean> {
    return this.http.post<string>("http://localhost:8080/login", login).pipe(map(res => {
      sessionStorage.setItem('user', JSON.stringify(res));
      this.userStateChangeEvent.emit();
      return true;
    }), catchError(error=> {
      return of(false);
    }));
  }

  logout() {
    sessionStorage.removeItem('user');
    this.userStateChangeEvent.emit();
  }

}
