package pl.recruitmentservice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.recruitmentservice.restapi.model.Level;

public interface LevelRepository extends JpaRepository<Level, Integer> {
}
