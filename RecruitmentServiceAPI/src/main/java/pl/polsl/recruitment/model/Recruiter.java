package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RECRUITERS", schema = "dbo", catalog = "RECRUITMENT")
public class Recruiter {
    private int id;
    private String lastName;
    private String firstName;
    private Integer companyId;

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
    @Column(name = "COMPANY_ID")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruiter recruiter = (Recruiter) o;
        return id == recruiter.id && Objects.equals(lastName, recruiter.lastName) && Objects.equals(firstName, recruiter.firstName) && Objects.equals(companyId, recruiter.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, companyId);
    }
}
