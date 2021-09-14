package pl.recruitmentservice.restapi.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.recruitmentservice.restapi.model.Address;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.Skill;
import pl.recruitmentservice.restapi.repository.PersonsRepository;
import pl.recruitmentservice.restapi.repository.SkillRepository;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
class RecruitmentServiceTest {

    @Autowired
    private PersonsRepository personsRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Test
    void foundAddedPerson_thenOk(){
        Address testAddress = new Address("testStreet",1,1,"testCity","testPC","testCountry");
        Person addedPerson = new Person("John","Doe", testAddress);
        personsRepository.save(addedPerson);
        Person foundPerson = personsRepository.getById(0);
        assertEquals("John", foundPerson.getFirstName());
    }

    @Test
    void foundAddedSkill_thenOk(){
        Skill addedSkill = new Skill("testSkill");
        skillRepository.save(addedSkill);
        Skill foundSkill = skillRepository.getById(0);
        assertEquals("testSkill", foundSkill.getName());
    }
}