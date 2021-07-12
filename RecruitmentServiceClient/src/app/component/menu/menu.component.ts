import { Component, OnInit } from '@angular/core';
import {Skill} from '../../../models/skill';
import {SkillService} from '../../service/skill.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  skills: Skill[];

  constructor(private skillService: SkillService, private router: Router) { }

  display = false;

  ngOnInit(){ this.skillService.getSkills().subscribe(s => this.skills = s); }

  getRouter(): Router{return this.router; }

  onPress() {
    this.display = !this.display;
  }
}
