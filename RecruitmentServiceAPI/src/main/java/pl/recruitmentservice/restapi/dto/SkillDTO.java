package pl.recruitmentservice.restapi.dto;
import lombok.Getter;
import pl.recruitmentservice.restapi.model.Skill;

@Getter
public class SkillDTO {
    private Integer id;
    private String name;

    public SkillDTO(Skill skill){
        this.id = skill.getId();
        this.name = skill.getName();
    }

    public SkillDTO(){
        
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
