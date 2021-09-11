package pl.recruitmentservice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.recruitmentservice.restapi.model.Person;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Integer> {
}
