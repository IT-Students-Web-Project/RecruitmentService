package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillDTOtoList {
    private List<SkillDTO> dtoList;
    public  SkillDTOtoList(List<Skill> skills){
        this.dtoList = new ArrayList<>();
        for (Skill s: skills) {
            this.dtoList.add(new SkillDTO(s));
        }
    }
    public List<SkillDTO> getList() {return dtoList;}
}
