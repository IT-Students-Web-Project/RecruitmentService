package pl.recruitmentservice.restapi.service;


import pl.recruitmentservice.restapi.model.Person;

import java.util.List;

public interface IRecruitmentService {

    public String sayHello();
    public Iterable<Person> getPersons();
    public List<Person> getPersonByFirstName(String name);
}
