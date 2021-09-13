import { Component, Input, OnInit } from '@angular/core';
import { Skill } from 'src/models/skill';
import { SkillService } from '../../service/skill.service';
import { Router } from '@angular/router';
import { Person } from 'src/models/person';
import { PersonService } from 'src/app/service/person.service';


@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {

  skills: Skill[] = [];
  selectedSkills: Skill[] = [];
  persons: Person[] = [];
  cities: string[] = [];
  selectedCity: string = "";

  constructor(private skillService: SkillService, private personService: PersonService, private router: Router) { }

  ngOnInit() {
    this.skillService.getSkills().subscribe(s => this.skills = s);
    this.personService.getPersonsCities().subscribe(c => this.cities = c);
  }

  getRouter(): Router { return this.router; }

  selectSkill(skill: Skill) {
    console.log("select skill");

    if (this.selectedSkills.includes(skill))
      this.selectedSkills.splice(this.selectedSkills.indexOf(skill), 1);
    else
      this.selectedSkills.push(skill);
  }

  wyszukajKandydata() {
    this.personService.getPersonsBySkills(this.selectedSkills, this.selectedCity).subscribe(p => this.persons = p);
  }

  choosePerson(id: number) {
    this.router.navigateByUrl('person/' + id);
  }
}
