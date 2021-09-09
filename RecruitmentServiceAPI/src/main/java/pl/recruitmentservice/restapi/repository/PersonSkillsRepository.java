package pl.recruitmentservice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.recruitmentservice.restapi.model.PersonsSkill;

public interface PersonSkillsRepository extends JpaRepository<PersonsSkill, Integer> {
}
