package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.PersonsSkill;
import java.util.ArrayList;
import java.util.List;

public class PersonSkillsDTOtoList {
    private List<PersonsSkillDTO> dtoList;

    public PersonSkillsDTOtoList(List<PersonsSkill> skills) {
        this.dtoList = new ArrayList<>();
        for (PersonsSkill p : skills) {
            this.dtoList.add(new PersonsSkillDTO(p));
        }
    }

    public List<PersonsSkillDTO> getList() {
        return dtoList;
    }
    public List<PersonsSkillDTO> getListOfPersons(List<PersonsSkill> skills, int id) {
        List<PersonsSkillDTO> dtoListOfPersons = new ArrayList<>();
        for (PersonsSkill p : skills) {
            if(p.getSkill().getId() == id){
                this.dtoList.add(new PersonsSkillDTO(p));
            }
        }
        return dtoListOfPersons;
    }
}
