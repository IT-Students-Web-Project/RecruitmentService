package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonsDTOtoList {

    private List<PersonDTO> dtoList;

    public PersonsDTOtoList(List<Person> persons) {
        this.dtoList = new ArrayList<>();
        for (Person p : persons) {
            this.dtoList.add(new PersonDTO(p));
        }
    }

    public List<PersonDTO> getList() {
        return dtoList;
    }
}
