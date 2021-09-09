package pl.recruitmentservice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.recruitmentservice.restapi.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{
}
