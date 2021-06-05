package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSONS_SKILLS", schema = "dbo", catalog = "RECRUITMENT")
public class PersonsSkill {
    private Integer id;
    private Person person;
    private Skill skill;
    private Level level;

    public PersonsSkill(Skill skill, Level level) {
        this.skill = skill;
        this.level = level;
    }

    public PersonsSkill() {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SKILL_ID")
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LEVEL_ID")
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonsSkill that = (PersonsSkill) o;
        return Objects.equals(id, that.id) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person);
    }
}
