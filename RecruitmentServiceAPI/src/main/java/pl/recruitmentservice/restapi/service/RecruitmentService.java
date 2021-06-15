package pl.recruitmentservice.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.recruitmentservice.restapi.dto.PersonDto;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.repository.PersonsRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RecruitmentService implements IRecruitmentService{

    private final PersonsRepository personsRepository;

    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public List<Person> getPersons() {
        return personsRepository.findAll();
    }

    @Override
    public List<Person> getPersonByFirstName(String name) {
        return personsRepository.findAllByFirstName(name);
    }
}
