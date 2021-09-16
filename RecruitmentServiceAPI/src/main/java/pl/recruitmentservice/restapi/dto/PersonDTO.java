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

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public List<PersonsSkillDTO> getPersonSkills() {
        return personSkills;
    }
}
