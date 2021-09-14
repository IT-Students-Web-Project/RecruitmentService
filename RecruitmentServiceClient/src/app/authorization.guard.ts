import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './service/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationGuard implements CanActivate {


  constructor(private loginService: LoginService, private router: Router) {

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
      const user = this.loginService.getAuthorizedUser();
      if (user == null) {
        this.router.navigateByUrl('login');
      }
      return user != null;
  }
  
}
