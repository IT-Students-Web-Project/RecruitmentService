import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonBySkillListComponent } from './person-by-skill-list/person-by-skill-list.component';
import { PersonComponent } from './person/person.component';
import { SkillComponent } from './skill/skill.component';
import { LevelComponent } from './level/level.component';
import { PersonSkillComponent } from './person-skill/person-skill.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PersonListComponent,
    PersonBySkillListComponent,
    PersonComponent,
    SkillComponent,
    LevelComponent,
    PersonSkillComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
