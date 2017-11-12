package ua.oleg.romanyuta.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.oleg.romanyuta.api.exception.BadRequestException;
import ua.oleg.romanyuta.api.exception.NotFoundException;
import ua.oleg.romanyuta.dao.AuthorRepository;
import ua.oleg.romanyuta.domain.Author;
import ua.oleg.romanyuta.domain.Sex;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class JpaAuthorServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    AuthorService testee = new JpaAuthorService();

    @Test
    public void getAuthor_GetsAuthorFromRepositoryById() throws Exception {
        Long id = 1l;
        Author expectedResult = createAuthorWithSomeId();
        when(authorRepository.findOne(id)).thenReturn(expectedResult);

        Author actualResult = testee.getAuthor(id);

        verify(authorRepository).findOne(1l);
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NotFoundException.class)
    public void getAuthor_ThrowsNotFoundException_IfNoAuthorInRepository() throws Exception {
        Long id = 1l;
        when(authorRepository.findOne(id)).thenReturn(null);

        testee.getAuthor(id);
    }

    @Test
    public void getAllAuthors_ReturnsAllAuthorsFromRepository() throws Exception {
        List<Author> expectedResult = Arrays.asList(createAuthorWithSomeId());
        when(authorRepository.findAll()).thenReturn(expectedResult);

        List<Author> actualResult = testee.getAllAuthors();

        verify(authorRepository).findAll();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void createAuthor_SavesAuthorToRepository() throws Exception {
        Author authorToCreate = createAuthorWithoutId();
        when(authorRepository.save(authorToCreate)).thenReturn(authorToCreate);

        Author actualResult = testee.createAuthor(authorToCreate);

        verify(authorRepository).save(authorToCreate);
        assertEquals(authorToCreate, actualResult);
    }

    @Test(expected = BadRequestException.class)
    public void createAuthor_ThrowsBadRequestException_IfAuthorIdIsNOTNull() throws Exception {
        Author authorToCreate = createAuthorWithSomeId();
        when(authorRepository.save(authorToCreate)).thenReturn(authorToCreate);

        testee.createAuthor(authorToCreate);
    }

    @Test
    public void updateAuthor_UpdatesAuthorInRepository() throws Exception {
        Long id = 1l;
        Author authorToBeUpdated = createAuthorWithId(id);
        when(authorRepository.findOne(id)).thenReturn(authorToBeUpdated);
        when(authorRepository.save(authorToBeUpdated)).thenReturn(authorToBeUpdated);

        Author updatingAuthor = createAuthorWithId(id);
        updatingAuthor.setFirstName("OtherName");
        Author actualResult = testee.updateAuthor(updatingAuthor);

        verify(authorRepository).findOne(id);
        verify(authorRepository).save(updatingAuthor);
        assertEquals(updatingAuthor, actualResult);
    }

    @Test(expected = BadRequestException.class)
    public void updateAuthor_ThrowsBadRequestException_IfAuthorIdIsNull() throws Exception {
        Author updatingAuthor = createAuthorWithoutId();

        testee.updateAuthor(updatingAuthor);
    }

    @Test(expected = NotFoundException.class)
    public void updateAuthor_ThrowsNotFoundException_IfNoAuthorInRepository() throws Exception {
        Long id = 1l;
        when(authorRepository.findOne(id)).thenReturn(null);

        Author updatingAuthor = createAuthorWithId(id);
        testee.updateAuthor(updatingAuthor);
    }

    private Author createAuthorWithSomeId() {
        return createAuthorWithId(42l);
    }

    private Author createAuthorWithoutId() {
        return createAuthorWithId(null);
    }

    private Author createAuthorWithId(Long id) {
        Author result = new Author();
        result.setId(id);
        result.setFirstName("John");
        result.setLastName("Doe");
        result.setSex(Sex.male);

        return result;
    }
}
