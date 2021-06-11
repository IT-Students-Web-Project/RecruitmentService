package pl.recruitmentservice.restapi.service;


import pl.recruitmentservice.restapi.model.Person;

public interface IRecruitmentService {

    public String sayHello();
    public Iterable<Person> getPersons();
}
