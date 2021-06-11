package pl.recruitmentservice.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.service.IRecruitmentService;

@RestController
@RequiredArgsConstructor
public class RecruitmentController {

    @Autowired
    private final IRecruitmentService recruitmentService;

    @GetMapping("/hello")
    public String hello(){
        return recruitmentService.sayHello();
    }

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return recruitmentService.getPersons();
    }
}
