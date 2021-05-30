package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LEVELS", schema = "dbo", catalog = "RECRUITMENT")
public class Level {
    private int id;
    private String name;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level = (Level) o;
        return id == level.id && Objects.equals(name, level.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
