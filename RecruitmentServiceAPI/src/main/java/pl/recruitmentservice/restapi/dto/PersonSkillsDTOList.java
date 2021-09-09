package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.PersonsSkill;
import java.util.ArrayList;
import java.util.List;

public class PersonSkillsDTOList {
    private List<PersonsSkillDTO> dtoList;

    public PersonSkillsDTOList(List<PersonsSkill> skills) {
        this.dtoList = new ArrayList<>();
        for (PersonsSkill p : skills) {
            this.dtoList.add(new PersonsSkillDTO(p));
        }
    }

    public List<PersonsSkillDTO> getList() {
        return dtoList;
    }
}
