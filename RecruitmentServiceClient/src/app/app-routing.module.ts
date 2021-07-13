import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './component/app.component';
import {PersonListComponent} from './component/person-list/person-list.component';

const routes: Routes = [
  {path: '', component: AppComponent},
  {path: 'personsBySkills', children: [
    {path: ':id', component: PersonListComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
