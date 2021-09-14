import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonComponent } from './component/person/person.component';
import { SkillComponent } from './component/skill/skill.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { AddCandidateComponent } from './component/add-candidate/add-candidate.component';
import { AddProjectComponent } from './component/add-project/add-project.component';
import { AddClientComponent } from './component/add-client/add-client.component';
import { AuthorizationGuard } from './authorization.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'kandydaci', component: SkillComponent, canActivate: [AuthorizationGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'addCandidate', component: AddCandidateComponent, canActivate: [AuthorizationGuard] },
  { path: 'addProject', component: AddProjectComponent, canActivate: [AuthorizationGuard] },
  { path: 'addClient', component: AddClientComponent, canActivate: [AuthorizationGuard] },
  {
    path: 'person', canActivate: [AuthorizationGuard], children: [
      { path: ':id', component: PersonComponent, canActivate: [AuthorizationGuard] }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
