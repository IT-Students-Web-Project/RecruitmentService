package pl.recruitmentservice.restapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.recruitmentservice.restapi.model.Project;

@Setter
@Getter
@NoArgsConstructor
public class ProjectDto {
    private Integer id;
    private String name;
    private String description;

    public ProjectDto(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
    }
}
