package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.Level;
import java.util.ArrayList;
import java.util.List;

public class LevelDTOtoList {
    private List<LevelDTO> dtoList;

    public LevelDTOtoList(List<Level> levels){
        this.dtoList = new ArrayList<>();
        for (Level l : levels){
            this.dtoList.add(new LevelDTO(l));
        }
    }

    public  List<LevelDTO> getList() {return dtoList;}
}
