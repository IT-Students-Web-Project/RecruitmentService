package pl.recruitmentservice.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.PersonsSkill;
import pl.recruitmentservice.restapi.model.Skill;
import pl.recruitmentservice.restapi.repository.PersonSkillsRepository;
import pl.recruitmentservice.restapi.repository.PersonsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruitmentService implements IRecruitmentService{
    @Autowired
    private final PersonsRepository personsRepository;

    @Autowired
    private final PersonSkillsRepository personSkillsRepository;

    @Override
    public List<Person> getPersons() {
        return personsRepository.findAll();
    }
    @Override
    public List<PersonsSkill> getPersonSkills(){return personSkillsRepository.findAll();}

    @Override
    public List<Person> getPersonsBySkills(List<Integer> idSkills) {
        List<Person> people = new ArrayList<>();
        List<PersonsSkill> requiredSkills = personSkillsRepository.findAll().stream()
                .filter(ps -> idSkills.contains(ps.getSkill().getId()))
                .collect(Collectors.toList());
        for(PersonsSkill s : requiredSkills) {
            people.add(s.getPerson());
        }
        return people;
    }
}