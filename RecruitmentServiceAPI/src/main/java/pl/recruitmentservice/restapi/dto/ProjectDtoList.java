package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.PersonsSkill;
import pl.recruitmentservice.restapi.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectDtoList {

    private List<ProjectDto> dtoList;

    public ProjectDtoList(List<Project> projects) {
        this.dtoList = new ArrayList<>();
        for (Project p : projects) {
            this.dtoList.add(new ProjectDto(p));
        }
    }

    public List<ProjectDto> getList() {
        return dtoList;
    }
}
