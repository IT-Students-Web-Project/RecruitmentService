package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RECRUITERS", schema = "dbo", catalog = "RECRUITMENT")
public class Recruiter {
    private Integer id;
    private String lastName;
    private String firstName;
    private Company company;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruiter recruiter = (Recruiter) o;
        return Objects.equals(id, recruiter.id) && Objects.equals(lastName, recruiter.lastName) && Objects.equals(firstName, recruiter.firstName);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName);
    }
}
