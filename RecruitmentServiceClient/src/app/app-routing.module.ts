import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonComponent } from './component/person/person.component';
import { SkillComponent } from './component/skill/skill.component';
import {HomeComponent} from './component/home/home.component';
import {LoginComponent} from './component/login/login.component';
import {AddCandidateComponent} from './component/add-candidate/add-candidate.component';
import {AddProjectComponent} from './component/add-project/add-project.component';
import {AddClientComponent} from './component/add-client/add-client.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'kandydaci', component: SkillComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'addCandidate', component: AddCandidateComponent
  },
  {
    path: 'addProject', component: AddProjectComponent
  },
  {
    path: 'addClient', component: AddClientComponent
  },
  {
    path: 'person', children: [
    {
      path: ':id', component: PersonComponent
    }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
