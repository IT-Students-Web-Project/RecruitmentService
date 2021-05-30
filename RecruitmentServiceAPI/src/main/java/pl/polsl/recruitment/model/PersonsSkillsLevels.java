package pl.polsl.recruitment.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSONS_SKILLS_LEVELS", schema = "dbo", catalog = "RECRUITMENT")
public class PersonsSkillsLevels {
    private int id;
    private int personId;
    private int skillId;
    private int levelId;

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
    @Column(name = "SKILL_ID")
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Basic
    @Column(name = "LEVEL_ID")
    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonsSkillsLevels that = (PersonsSkillsLevels) o;
        return id == that.id && personId == that.personId && skillId == that.skillId && levelId == that.levelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personId, skillId, levelId);
    }
}
