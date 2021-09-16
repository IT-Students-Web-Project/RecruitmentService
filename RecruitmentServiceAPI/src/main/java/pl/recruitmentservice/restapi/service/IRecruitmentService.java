package pl.recruitmentservice.restapi.service;

import pl.recruitmentservice.restapi.dto.PersonDTO;
import pl.recruitmentservice.restapi.model.*;


import java.util.List;
import java.util.Optional;

 public interface IRecruitmentService {
     List<Person> getPersons();
     Optional<Person> getPerson(int id);
     void removePerson(int id);
     PersonDTO addPerson(Person person);
     List<PersonsSkill> getPersonSkills();
     PersonsSkill getPersonSkill(int id);
     List<Person> getPersonsBySkills(List<Integer> idSkills);
     List<Skill> getSkills();
     Skill getSkill(int id);
     void removeSkill(int id);
     void addSkill (Skill skill);
     List<Level> getLevels();
     List<String> getPersonsCities();
     List<Project> getProjects();
     void editSkill(int id, Skill skill);
     void editPerson(int id, PersonDTO personDTO);
}
