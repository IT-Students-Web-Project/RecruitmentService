package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSONS", schema = "dbo", catalog = "RECRUITMENT")
public class Person {
    private int id;
    private String lastName;
    private String firstName;
    private Integer roleId;
    private Integer personsSkillsLevelId;

    @JoinColumn(name = "ID")
    @OneToOne(targetEntity = Address.class)
    private Address address;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "ROLE_ID")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "PERSONS_SKILLS_LEVEL_ID")
    public Integer getPersonsSkillsLevelId() {
        return personsSkillsLevelId;
    }

    public void setPersonsSkillsLevelId(Integer personsSkillsLevelId) {
        this.personsSkillsLevelId = personsSkillsLevelId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(roleId, person.roleId) && Objects.equals(personsSkillsLevelId, person.personsSkillsLevelId) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, roleId, personsSkillsLevelId, address);
    }
}
