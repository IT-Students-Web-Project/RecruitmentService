package pl.recruitmentservice.restapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.recruitmentservice.restapi.model.Person;

import java.util.List;

@Getter
@Setter
public class PersonDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private List<PersonsSkillDTO> personSkills;

    public PersonDTO() {

    }

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = new AddressDTO(person.getAddress());
        this.personSkills = new PersonSkillsDTOList(person.getPersonsSkills()).getList();
    }

    public Person createPerson() {
        Person person = new Person();
        person.setAddress(address.createAddress());
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }
}
