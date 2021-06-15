package pl.recruitmentservice.restapi.service;


import org.springframework.stereotype.Service;
import pl.recruitmentservice.restapi.dto.PersonDto;
import pl.recruitmentservice.restapi.model.Person;

import java.util.List;

public interface IRecruitmentService {

    public String sayHello();
    public List<Person> getPersons();
    public List<Person> getPersonByFirstName(String name);
}
