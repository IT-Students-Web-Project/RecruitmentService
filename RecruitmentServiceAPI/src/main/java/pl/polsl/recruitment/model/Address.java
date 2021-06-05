package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ADDRESSES", schema = "dbo", catalog = "RECRUITMENT")
public class Address {
    private Integer id;
    private String street;
    private Integer buildingNumber;
    private Integer flatNumber;
    private String city;
    private String postalCode;
    private String country;

    public Address() {

    }

    public Address(String street, Integer buildingNumber, Integer flatNumber, String city, String postalCode, String country) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "BUILDING_NUMBER")
    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Basic
    @Column(name = "FLAT_NUMBER")
    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "POSTAL_CODE")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(buildingNumber, address.buildingNumber) && Objects.equals(flatNumber, address.flatNumber) && Objects.equals(city, address.city) && Objects.equals(postalCode, address.postalCode) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, buildingNumber, flatNumber, city, postalCode, country);
    }
}
