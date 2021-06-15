package pl.recruitmentservice.restapi.service;

import pl.recruitmentservice.restapi.model.Person;
import java.util.List;

public interface IRecruitmentService {
    public List<Person> getPersons();
}
