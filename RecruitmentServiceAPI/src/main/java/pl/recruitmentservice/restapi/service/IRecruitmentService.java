package pl.recruitmentservice.restapi.service;

import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.PersonsSkill;

import java.util.List;

public interface IRecruitmentService {
    public List<Person> getPersons();
    public List<PersonsSkill> getPersonSkills();
}
