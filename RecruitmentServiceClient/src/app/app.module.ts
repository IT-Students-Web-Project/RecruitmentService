import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './component/app.component';
import { PersonComponent } from './component/person/person.component';
import { SkillComponent } from './component/skill/skill.component';
import { HttpClientModule } from '@angular/common/http';
import { MainComponent } from './component/main/main.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { AddCandidateComponent } from './component/add-candidate/add-candidate.component';
import { AddProjectComponent } from './component/add-project/add-project.component';
import { AddClientComponent } from './component/add-client/add-client.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProjektComponent } from './projekt/projekt.component';
import { EditSkillComponent } from './component/edit-skill/edit-skill.component';
import { AddSkillComponent} from './component/add-skill/add-skill.component';
import {SkillListComponent} from './component/skill-list/skill-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonComponent,
    SkillComponent,
    MainComponent,
    HomeComponent,
    LoginComponent,
    AddCandidateComponent,
    AddProjectComponent,
    AddClientComponent,
    ProjektComponent,
    EditSkillComponent,
    AddSkillComponent,
    SkillListComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        BrowserAnimationsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
