package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDtoList {

    private List<PersonDto> dtoList;

    public PersonDtoList(List<Person> persons) {
        this.dtoList  = new ArrayList<>();
        for(Person p : persons) {
            this.dtoList .add(new PersonDto(p));
        }
    }

    public List<PersonDto> getList() {
        return dtoList;
    }
}
