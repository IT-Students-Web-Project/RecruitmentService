package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.Person;

public class PersonDto {

    private final Integer id;
    private final String firstName;
    private final String lastName;

    public PersonDto(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
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
}
