package pl.recruitmentservice.restapi.dto;

import pl.recruitmentservice.restapi.model.Address;

public class AddressesDTO {
    private final Integer id;
    private final String street;
    private final Integer buildingNumber;
    private final Integer flatNumber;
    private final String city;

    public AddressesDTO(Address addres) {
        this.id = addres.getId();
        this.street = addres.getStreet();
        this.buildingNumber = addres.getBuildingNumber();
        this.flatNumber = addres.getFlatNumber();
        this.city = addres.getCity();
    }
}
