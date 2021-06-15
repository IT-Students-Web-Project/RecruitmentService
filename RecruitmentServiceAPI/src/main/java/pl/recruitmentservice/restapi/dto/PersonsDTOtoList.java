package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonsDTOtoList {

    private List<PersonsDTO> dtoList;

    public PersonsDTOtoList(List<Person> persons) {
        this.dtoList = new ArrayList<>();
        for (Person p : persons) {
            this.dtoList.add(new PersonsDTO(p));
        }
    }

    public List<PersonsDTO> getList() {
        return dtoList;
    }
}
