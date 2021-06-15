package pl.recruitmentservice.restapi.dto;

import lombok.Getter;
import pl.recruitmentservice.restapi.model.Level;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.PersonsSkill;
import pl.recruitmentservice.restapi.model.Skill;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PersonsSkillDTO {

    private final Integer id;
    private final Skill skill;
    private final Level skillLevel;
    private final Person person;

    public PersonsSkillDTO(PersonsSkill personSkill){
        this.id = personSkill.getId();
        this.skill = personSkill.getSkill();
        this.skillLevel = personSkill.getLevel();
        this.person = personSkill.getPerson();
    }

    public List<String> getPerson(){
        List<String> lista = new ArrayList<>();
        lista.add(person.getId().toString());
        lista.add(person.getFirstName());
        lista.add(person.getLastName());
        return lista;
    }

}
