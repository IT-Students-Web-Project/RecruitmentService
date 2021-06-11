package pl.recruitmentservice.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.recruitmentservice.restapi.model.Person;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Integer> {
}
