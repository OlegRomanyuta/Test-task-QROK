package ua.oleg.romanyuta.domain;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends DomainObject {

    @Column
    private String title;

    @Column
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "authorsToBooks", joinColumns = {
            @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") })
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "lastName")
    private List<Author> authors = new ArrayList();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
