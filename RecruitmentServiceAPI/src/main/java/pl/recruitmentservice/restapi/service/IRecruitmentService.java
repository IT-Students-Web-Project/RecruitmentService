package pl.recruitmentservice.restapi.service;

import pl.recruitmentservice.restapi.dto.PersonDTO;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.PersonsSkill;
import pl.recruitmentservice.restapi.model.Skill;
import pl.recruitmentservice.restapi.model.Level;


import java.util.List;
import java.util.Optional;

public interface IRecruitmentService {
    public List<Person> getPersons();
    public Optional<Person> getPerson(int id);
    public void removePerson(int id);
    public void addPerson(Person person);
    public List<PersonsSkill> getPersonSkills();
    public PersonsSkill getPersonSkill(int id);
    public List<Person> getPersonsBySkills(List<Integer> idSkills);
    public List<Skill> getSkills();
    public Skill getSkill(int id);
    public void removeSkill(int id);
    public void editSkill(int id, Skill skill);
    public void addSkill (Skill skill);
    public List<Level> getLevels();
    public List<String> getPersonsCities();
    public void editPerson(int id, PersonDTO personDTO);
}
