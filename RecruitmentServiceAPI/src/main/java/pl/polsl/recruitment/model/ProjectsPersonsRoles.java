package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROJECTS_PERSONS_ROLES", schema = "dbo", catalog = "RECRUITMENT")
public class ProjectsPersonsRoles {
    private String id;
    private int projectId;
    private int personId;
    private int roleId;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PROJECT_ID")
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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
    @Column(name = "ROLE_ID")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectsPersonsRoles that = (ProjectsPersonsRoles) o;
        return projectId == that.projectId && personId == that.personId && roleId == that.roleId && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, personId, roleId);
    }
}
