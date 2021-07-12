import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonBySkillListComponent } from './person-by-skill-list.component';

describe('PersonBySkillListComponent', () => {
  let component: PersonBySkillListComponent;
  let fixture: ComponentFixture<PersonBySkillListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonBySkillListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonBySkillListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
