package pl.polsl.recruitment.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.recruitment.model.Person;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Integer> {
}
