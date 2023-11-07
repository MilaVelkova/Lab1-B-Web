package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private String genre;
    private Integer year;
    List<Author> authors;

}
