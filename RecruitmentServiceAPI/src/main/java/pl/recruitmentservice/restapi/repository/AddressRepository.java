package pl.recruitmentservice.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.recruitmentservice.restapi.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
