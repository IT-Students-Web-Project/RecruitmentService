package pl.polsl.recruitment.repo;

import org.springframework.data.repository.CrudRepository;
import pl.polsl.recruitment.model.Person;

public interface PersonsRepository extends CrudRepository<Person, Long> {
}
