package ua.oleg.romanyuta.domain;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Author extends DomainObject {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Temporal(value=TemporalType.DATE)
    private Date birthDate;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "title")
    private List<Book> books = new ArrayList();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Reward> rewards = new ArrayList();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
}
