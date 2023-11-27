package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
public class Book {
    private long id;
    private String isbn;
    private String title;
    private String genre;
    private Integer year;
    List<Author> authors;

    private BookStore bookStore;

    public Book(String isbn, String title, String genre, Integer year, List<Author> authors, BookStore bookStore) {
        this.id = (long) (Math.random()*1000);
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore =bookStore;
    }
}
