package ua.oleg.romanyuta.api.service;

import ua.oleg.romanyuta.domain.Author;

import java.util.List;

public interface AuthorService {

    Author getAuthor(Long id);

    List<Author> getAllAuthors();

    Author createAuthor(Author author);

    Author updateAuthor(Author author);
}
