package pl.recruitmentservice.restapi.dto;
import lombok.Getter;
import pl.recruitmentservice.restapi.model.Level;

@Getter
public class LevelDTO {
    private Integer id;
    private String name;
    private Integer value;
    public LevelDTO(Level level){
        this.id = level.getId();
        this.name = level.getName();
        this.value = level.getValue();
    }
}
