package ua.oleg.romanyuta.domain;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 12.11.2017.
 */
public class AuthorShortInfo {

    private String firstName;

    private String lastName;

    private Integer age;

    private List<String> bookNames;

    public static AuthorShortInfo fromAuthor(Author author) {
        AuthorShortInfo result = new AuthorShortInfo();
        result.setFirstName(author.getFirstName());
        result.setLastName(author.getLastName());

        List<String> bookTitles = getBookTitles(author.getBooks());
        result.setBookNames(bookTitles);

        Integer age = calculateAge(author.getBirthDate());
        result.setAge(age);

        return result;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getBookNames() {
        return bookNames;
    }

    public void setBookNames(List<String> bookNames) {
        this.bookNames = bookNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorShortInfo that = (AuthorShortInfo) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        return bookNames != null ? bookNames.equals(that.bookNames) : that.bookNames == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (bookNames != null ? bookNames.hashCode() : 0);
        return result;
    }

    private static List<String> getBookTitles(List<Book> books) {
        List<String> result = new ArrayList<>();
        if (books != null) {
            for (Book book : books) {
                if (book != null && book.getTitle() != null) {
                    result.add(book.getTitle());
                }
            }
        }

        return result;
    }

    private static Integer calculateAge(Date birth) {
        if (birth == null) {
            return null;
        }

        DateTime birthDate = new DateTime(birth);
        DateTime currentDate = new DateTime();

        return currentDate.minusYears(birthDate.getYear()).getYear();
    }
}
