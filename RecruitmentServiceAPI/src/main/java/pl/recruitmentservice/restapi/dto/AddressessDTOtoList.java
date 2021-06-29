package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.Address;
import java.util.ArrayList;
import java.util.List;

public class AddressessDTOtoList {

    private List<AddressDTO> dtoList;

    public AddressessDTOtoList(List<Address> addresses) {
        this.dtoList = new ArrayList<>();
        for (Address a : addresses) {
            this.dtoList.add(new AddressDTO(a));
        }
    }

    public List<AddressDTO> getList() {
        return dtoList;
    }
}
