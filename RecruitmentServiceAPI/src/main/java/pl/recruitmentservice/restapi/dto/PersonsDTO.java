package pl.recruitmentservice.restapi.dto;

import lombok.Getter;
import pl.recruitmentservice.restapi.model.Address;
import pl.recruitmentservice.restapi.model.Person;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PersonsDTO {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Address address;

    public PersonsDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();
    }

    public List<String> getAddress() {
        List<String> list = new ArrayList<>();
        list.add(address.getCity());
        list.add(address.getCountry());
        list.add(String.valueOf(address.getBuildingNumber()));
        list.add(String.valueOf(address.getFlatNumber()));
        return list;
    }

}
