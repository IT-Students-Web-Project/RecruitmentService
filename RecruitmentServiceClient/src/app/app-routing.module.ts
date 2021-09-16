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
import { ProjektComponent } from './projekt/projekt.component';
import {EditSkillComponent} from './component/edit-skill/edit-skill.component';
import {AddSkillComponent} from './component/add-skill/add-skill.component';
import {SkillListComponent} from './component/skill-list/skill-list.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'candidates', component: SkillComponent, canActivate: [AuthorizationGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'addCandidate', component: AddCandidateComponent, canActivate: [AuthorizationGuard] },
  { path: 'addProject', component: AddProjectComponent, canActivate: [AuthorizationGuard] },
  { path: 'addClient', component: AddClientComponent, canActivate: [AuthorizationGuard] },
  {
    path: 'person', canActivate: [AuthorizationGuard], children: [
      { path: ':id', component: PersonComponent, canActivate: [AuthorizationGuard] }
    ]
  },
  {
    path: 'skills', canActivate: [AuthorizationGuard], children: [
      { path: 'list', component: SkillListComponent },
      { path: ':id', component: EditSkillComponent },
      { path: 'add', component: AddSkillComponent }
    ]
  },
  { path: 'projekt', component: ProjektComponent, canActivate: [AuthorizationGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
