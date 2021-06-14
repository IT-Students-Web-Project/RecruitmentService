package pl.recruitmentservice.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.Objects;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PERSONS", schema = "dbo", catalog = "RECRUITMENT")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;

    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<PersonsSkill> personSkills;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName);
    }
}
