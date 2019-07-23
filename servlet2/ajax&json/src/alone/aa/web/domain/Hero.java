package alone.aa.web.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Hero {
    private String name;
    private String skill;
    private String ranking;
    //@JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    public Hero() {
    }

    public Hero(String name, String skill, String ranking, Date birthday) {
        this.name = name;
        this.skill = skill;
        this.ranking = ranking;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", ranking='" + ranking + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
