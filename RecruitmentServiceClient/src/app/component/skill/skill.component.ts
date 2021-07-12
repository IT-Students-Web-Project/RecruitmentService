import { Component, Input, OnInit } from '@angular/core';
import { Skill } from 'src/models/skill';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {

  constructor() { }
  @Input() skill: Skill;
  ngOnInit(): void {
  }

}
