package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EPERIENCES", schema = "dbo", catalog = "RECRUITMENT")
public class Eperience {
    private int id;
    private int personId;
    private String description;
    private Integer projectId;
    private Integer companyId;
    private Integer roleId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PERSON_ID")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PROJECT_ID")
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "COMPANY_ID")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "ROLE_ID")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eperience eperience = (Eperience) o;
        return id == eperience.id && personId == eperience.personId && Objects.equals(description, eperience.description) && Objects.equals(projectId, eperience.projectId) && Objects.equals(companyId, eperience.companyId) && Objects.equals(roleId, eperience.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personId, description, projectId, companyId, roleId);
    }
}
