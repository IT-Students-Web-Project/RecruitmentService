import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from 'src/models/person';
import { PersonService } from '../service/person.service';

@Component({
  selector: 'app-edit-candidate',
  templateUrl: './edit-candidate.component.html',
  styleUrls: ['./edit-candidate.component.css']
})
export class EditCandidateComponent implements OnInit {

  id : number;
  person: Person;
  constructor(private personService: PersonService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    // this.route.queryParams.subscribe(params => {
      
    // });
    this.id = Number.parseInt(this.route.snapshot.paramMap.get('id'), 10);
    this.personService.getPerson(this.id).subscribe(p => this.person = p);
  }

  confirmEdit(): void {
    this.personService.editPerson(this.person).subscribe(s => console.log(s));
    this.router.navigateByUrl('candidates');
  }

}
