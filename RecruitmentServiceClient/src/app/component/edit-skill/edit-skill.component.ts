import { Component, OnInit } from '@angular/core';
import {Skill} from '../../../models/skill';
import {ActivatedRoute, Router} from '@angular/router';
import {SkillService} from '../../service/skill.service';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit {

  skill: Skill = {id: null, name: null};
  id: number;

  constructor(private router: Router, private route: ActivatedRoute, private skillService: SkillService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.id = Number.parseInt(this.route.snapshot.paramMap.get('id'), 10);
      this.skillService.getSkill(this.id).subscribe(s => this.skill = s);
    });
  }

  confirmEdit(name: string): void {
    this.skill.name = name;
    this.skillService.editSkill(this.id, this.skill).subscribe(s => console.log(s));
    this.router.navigateByUrl('skills/list');
  }

}
