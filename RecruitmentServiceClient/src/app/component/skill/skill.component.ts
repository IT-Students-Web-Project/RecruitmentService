import { Component, Input, OnInit } from '@angular/core';
import { Skill } from 'src/models/skill';
import {SkillService} from '../../service/skill.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {

  skills: Skill[];

  constructor(private skillService: SkillService, private router: Router) { }

  display = false;

  ngOnInit(){ this.skillService.getSkills().subscribe(s => this.skills = s); }

  getRouter(): Router{ return this.router; }

  onPress() { this.display = !this.display; }

  wyszukajKandydata(id) { this.router.navigateByUrl('personsBySkills/' + this.skills[id].id); }
}
