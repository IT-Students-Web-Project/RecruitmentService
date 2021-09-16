import { Component, OnInit } from '@angular/core';
import {Person} from '../../../models/person';
import {Address} from '../../../models/address';
import {ActivatedRoute, Router} from '@angular/router';
import {PersonService} from '../../service/person.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  address: Address = {id:null, city: null, buildingNumber: null, flatNumber: null, street: null}
  person: Person = {id: null, firstName: null, lastName: null, personSkills: null, address: this.address};
  id: number;
  constructor(private router: Router, private route: ActivatedRoute, private personService: PersonService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.id = Number.parseInt(this.route.snapshot.paramMap.get('id'), 10);
      this.personService.getPersonById(this.id).subscribe(p => this.person = p); } ); }

    confirmEdit(firstName: string, lastName: string, city: string): void {
      this.person.firstName = firstName;
      this.person.lastName = lastName;
      this.person.address.city = city;
      this.personService.editPerson(this.id, this.person).subscribe(s => console.log(s));
      this.router.navigateByUrl('candidates');
    }

}
