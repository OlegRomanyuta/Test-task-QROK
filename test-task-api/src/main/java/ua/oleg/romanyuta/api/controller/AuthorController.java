package ua.oleg.romanyuta.api.controller;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.oleg.romanyuta.api.service.AuthorService;
import ua.oleg.romanyuta.dao.AuthorRepository;
import ua.oleg.romanyuta.domain.Author;
import ua.oleg.romanyuta.domain.exception.BadRequestException;
import ua.oleg.romanyuta.domain.exception.NotFoundException;


import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthor(@PathVariable("id") Long id) {
        Author author = authorService.getAuthor(id);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
