import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonService } from 'src/app/service/person.service';
import { Person } from 'src/models/person';

@Component({
  selector: 'app-add-candidate',
  templateUrl: './add-candidate.component.html',
  styleUrls: ['./add-candidate.component.css']
})
export class AddCandidateComponent implements OnInit {

  person: Person = {
    id: null,
    address: {
      id: null,
      buildingNumber: null,
      city: null,
      flatNumber: null,
      street: null
    },
    firstName: null,
    lastName: null,
    personSkills: null
  }

  constructor(private personService: PersonService, private router: Router) { }

  ngOnInit(): void { }

  addPerson():void {
    this.personService.addPerson(this.person).subscribe(p => console.log("added person: " + this.person));
    this.router.navigateByUrl('/candidates');
  }
}
