package pl.recruitmentservice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.recruitmentservice.restapi.model.Level;
import pl.recruitmentservice.restapi.model.Project;

public interface ProjectsRepository extends JpaRepository<Project, Integer>{
}

