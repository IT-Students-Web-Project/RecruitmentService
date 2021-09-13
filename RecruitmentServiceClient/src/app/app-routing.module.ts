import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './component/app.component';
import { PersonComponent } from './component/person/person.component';
import { SkillComponent } from './component/skill/skill.component';

const routes: Routes = [
  {path: '', component: SkillComponent},
  {path: 'person', children: [
    {path: ':id', component: PersonComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
