import { Component, OnInit } from '@angular/core';
import {Skill} from '../../../models/skill';
import { Router } from '@angular/router';
import {SkillService} from '../../service/skill.service';

@Component({
  selector: 'app-skill-list',
  templateUrl: './skill-list.component.html',
  styleUrls: ['./skill-list.component.css']
})
export class SkillListComponent implements OnInit {

  skills: Skill[] = [];

  constructor(private skillService: SkillService, private router: Router) { }

  ngOnInit(): void {
    this.skillService.getSkills().subscribe(s => this.skills = s);
  }

  editSkill(id: number): void {
    this.router.navigateByUrl('skills/' + id);
  }

  deleteSkill(id: number): void {
    this.skillService.removeSkill(id);
  }
}
