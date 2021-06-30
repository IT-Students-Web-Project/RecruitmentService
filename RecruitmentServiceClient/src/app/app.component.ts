import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/models/skill';
import { SkillService } from './skill.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  skills: Skill[];
  constructor(private skillService: SkillService, private router: Router) {}
  ngOnInit(){
    this.skillService.getSkills().subscribe(s => this.skills = s);
  }
  title = 'RecruitmentServiceClient';
  getRouter(): Router{
    return this.router
  };
}
