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

    public PersonsSkillDTO(PersonsSkill personSkill){
        this.id = personSkill.getId();
        this.skill = personSkill.getSkill();
        this.skillLevel = personSkill.getLevel();
    }

    public int getId() {return id;}
}
