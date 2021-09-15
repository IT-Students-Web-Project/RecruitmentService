import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { LoginService } from './service/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationGuard implements CanActivate {


  constructor(private loginService: LoginService, private router: Router) {

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
      const user = this.loginService.getAuthorizedUser();
      console.log("User: " + user)
      if (user == null) {
        this.loginService.setRedirection(state.url);
        this.router.navigateByUrl('login');
      }
      let value : boolean = (user != null);
      console.log("canAccess: " + value);
      return value;
  }  
}
