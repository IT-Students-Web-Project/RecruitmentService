package pl.recruitmentservice.restapi.dto;

import lombok.Getter;
import pl.recruitmentservice.restapi.model.Person;

import java.util.List;

@Getter
public class PersonDTO {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final AddressDTO address;
    private final List<PersonsSkillDTO> personSkills;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = new AddressDTO(person.getAddress());
        this.personSkills = new PersonSkillsDTOList(person.getPersonsSkills()).getList();
    }
}
