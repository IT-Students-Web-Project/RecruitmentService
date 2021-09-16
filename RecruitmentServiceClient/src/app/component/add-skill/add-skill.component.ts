import { Component, OnInit } from '@angular/core';
import {SkillService} from '../../service/skill.service';
import {Skill} from '../../../models/skill';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-skill',
  templateUrl: './add-skill.component.html',
  styleUrls: ['./add-skill.component.css']
})
export class AddSkillComponent implements OnInit {

  skill: Skill;

  constructor(private router: Router, private skillService: SkillService) { }

  ngOnInit(): void {
  }

  confirmAdd(name: string): void {
    this.skill.name = name;
    this.skill.id = 0;
    this.skillService.addSkill(this.skill);
    this.router.navigateByUrl('skills/list');
  }
}
