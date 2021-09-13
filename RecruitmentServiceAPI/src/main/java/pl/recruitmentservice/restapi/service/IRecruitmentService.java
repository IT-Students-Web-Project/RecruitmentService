package pl.recruitmentservice.restapi.service;

import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.PersonsSkill;
import pl.recruitmentservice.restapi.model.Skill;
import pl.recruitmentservice.restapi.model.Level;


import java.util.List;

public interface IRecruitmentService {
    public List<Person> getPersons();
    public List<PersonsSkill> getPersonSkills();
    public List<Person> getPersonsBySkills(List<Integer> idSkills);
    public List<Skill> getSkills();
    public List<Level> getLevels();
    public List<String> getPersonsCities();
}
