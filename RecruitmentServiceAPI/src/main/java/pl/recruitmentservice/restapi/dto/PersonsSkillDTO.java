package pl.recruitmentservice.restapi.dto;

import lombok.Getter;
import lombok.Setter;
import pl.recruitmentservice.restapi.model.Level;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.PersonsSkill;
import pl.recruitmentservice.restapi.model.Skill;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonsSkillDTO {

    private Integer id;
    private Skill skill;
    private Level skillLevel;

    public PersonsSkillDTO() {

    }

    public PersonsSkillDTO(PersonsSkill personSkill){
        this.id = personSkill.getId();
        this.skill = personSkill.getSkill();
        this.skillLevel = personSkill.getLevel();
    }

    public int getId() {return id;}
}
