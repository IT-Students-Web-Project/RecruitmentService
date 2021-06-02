package pl.polsl.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.recruitment.model.Person;
import pl.polsl.recruitment.repo.PersonsRepository;

@RestController
@RequestMapping("recruitment")
public class RecruitmentController {

    PersonsRepository personRepository;

    public RecruitmentController(@Autowired PersonsRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/persons2")
    public Iterable<Person> getPersons2() {
        return personRepository.findAll();
    }

}
