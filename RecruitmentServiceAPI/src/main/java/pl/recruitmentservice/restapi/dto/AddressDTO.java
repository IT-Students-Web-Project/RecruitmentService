package pl.recruitmentservice.restapi.dto;

import lombok.Getter;
import lombok.Setter;
import pl.recruitmentservice.restapi.model.Address;

@Getter
@Setter
public class AddressDTO {
    private Integer id;
    private String street;
    private Integer buildingNumber;
    private Integer flatNumber;
    private String city;

    public AddressDTO() {

    }

    public AddressDTO(Address addres) {
        this.id = addres.getId();
        this.street = addres.getStreet();
        this.buildingNumber = addres.getBuildingNumber();
        this.flatNumber = addres.getFlatNumber();
        this.city = addres.getCity();
    }

    public Address createAddress(){
        Address address = new Address(street,buildingNumber,flatNumber,city,"","");
        address.setId(id);
        return address;
    }
}
