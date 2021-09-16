package pl.recruitmentservice.restapi.dto;

import lombok.Getter;
import pl.recruitmentservice.restapi.model.Address;

@Getter
public class AddressDTO {
    private final Integer id;
    private final String street;
    private final Integer buildingNumber;
    private final Integer flatNumber;
    private final String city;

    public AddressDTO(Address addres) {
        this.id = addres.getId();
        this.street = addres.getStreet();
        this.buildingNumber = addres.getBuildingNumber();
        this.flatNumber = addres.getFlatNumber();
        this.city = addres.getCity();
    }

    public AddressDTO() {
        id = null;
        street = null;
        buildingNumber = null;
        flatNumber = null;
        city = null;
    }

    public Address createAddress(){
        Address address = new Address(street,buildingNumber,flatNumber,city,"","");
        address.setId(id);
        return address;
    }
}
