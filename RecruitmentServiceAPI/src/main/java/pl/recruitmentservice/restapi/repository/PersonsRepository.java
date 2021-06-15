package pl.recruitmentservice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.recruitmentservice.restapi.model.*;

import java.util.List;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT * FROM PERSON_SKILLS WHERE PERSON_ID = 10")
    String getPrzyklad(){

    }
}
