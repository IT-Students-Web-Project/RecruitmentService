import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from 'src/models/person';
import { Skill } from 'src/models/skill';
import { Project, ProjektService } from '../projekt.service';

@Component({
  selector: 'app-projekt',
  templateUrl: './projekt.component.html',
  styleUrls: ['./projekt.component.css']
})
export class ProjektComponent implements OnInit {

  projects: Project[] = [];
 

  constructor(private projectService: ProjektService) { }


  ngOnInit(): void {
    this.projectService.getProjects().subscribe(p => this.projects = p);
  }
}
