package pl.recruitmentservice.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.PersonsSkill;
import pl.recruitmentservice.restapi.model.Skill;
import pl.recruitmentservice.restapi.model.Level;
import pl.recruitmentservice.restapi.repository.LevelRepository;
import pl.recruitmentservice.restapi.repository.PersonSkillsRepository;
import pl.recruitmentservice.restapi.repository.PersonsRepository;
import pl.recruitmentservice.restapi.repository.SkillRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruitmentService implements IRecruitmentService {
    @Autowired
    private final PersonsRepository personsRepository;

    @Autowired
    private final PersonSkillsRepository personSkillsRepository;

    @Autowired
    private final SkillRepository skillRepository;

    @Autowired
    private final LevelRepository levelRepository;

    @Override
    public List<Person> getPersons() {
        return personsRepository.findAll();
    }

    @Override
    public Optional<Person> getPerson(int id) {
        return personsRepository.findById(id);
    }

    @Override
    public void removePerson(int id) {
        Optional<Person> person = personsRepository.findById(id);
        if (!person.isEmpty())
            personsRepository.delete(person.get());
    }

    @Override
    public void addPerson(Person person) {
        personsRepository.save(person);
    }

    @Override
    public List<PersonsSkill> getPersonSkills() {
        return personSkillsRepository.findAll();
    }

    @Override
    public PersonsSkill getPersonSkill(int id){
        Optional<PersonsSkill> personsSkill = personSkillsRepository.findById(id);
        return personsSkill.get();
    }

    @Override
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkill(int id) {
        return skillRepository.findById(id).get();
    }

    @Override
    public void removeSkill(int id) {
        skillRepository.delete(skillRepository.findById(id).get());
    }

    @Override
    public void addSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public List<Level> getLevels() {
        return levelRepository.findAll();
    }

    @Override
    public List<Person> getPersonsBySkills(List<Integer> idSkills) {
        List<Person> people = personsRepository.findAll().stream().collect(Collectors.toList());
        for (Integer id : idSkills) {
            people = people.stream()
                    .filter(p -> p.getPersonsSkills().stream().anyMatch(ps -> ps.getSkill().getId().equals(id)))
                    .collect(Collectors.toList());
        }
        return people;
    }

    @Override
    public List<String> getPersonsCities() {
        return personsRepository.findAll().stream()
                .map(p -> p.getAddress().getCity())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    @Override
    public void editSkill(int id, Skill skill) {
        Skill editedSkill = skillRepository.findById(id).get();
        editedSkill.setName(skill.getName());
        skillRepository.save(editedSkill);
    }
}