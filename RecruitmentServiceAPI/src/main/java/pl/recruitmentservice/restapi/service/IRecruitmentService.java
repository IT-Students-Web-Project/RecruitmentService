package pl.recruitmentservice.restapi.service;

import pl.recruitmentservice.restapi.model.*;

import java.util.List;

public interface IRecruitmentService {

    public String sayHello();
    public List<Person> getPersons();
    public List<Person> getPersonByFirstName(String name);
}
