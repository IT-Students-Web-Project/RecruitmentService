package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LEVELS", schema = "dbo", catalog = "RECRUITMENT")
public class Level {
    private Integer id;
    private String name;

    public Level() {
    }

    public Level(String name) {
        this.name = name;
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
        return Objects.equals(id, level.id) && Objects.equals(name, level.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
