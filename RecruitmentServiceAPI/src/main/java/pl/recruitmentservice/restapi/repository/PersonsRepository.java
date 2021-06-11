package pl.recruitmentservice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.recruitmentservice.restapi.model.Person;

import java.util.List;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Integer> {
    List<Person> findAllByFirstName(String name);
}
