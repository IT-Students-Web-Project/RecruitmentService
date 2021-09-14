import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/models/skill';
import { ProjektService } from '../projekt.service';

@Component({
  selector: 'app-projekt',
  templateUrl: './projekt.component.html',
  styleUrls: ['./projekt.component.css']
})
export class ProjektComponent implements OnInit {

  skills: Skill[] = [];
  selectedSkills: Skill[] = [];


  constructor(private skillService: ProjektService) { }

  ngOnInit(): void {

  }

  wyszukajProjekt() {
    this.skillService()
  }

}
