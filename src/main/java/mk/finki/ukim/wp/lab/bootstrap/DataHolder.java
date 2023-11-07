package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors = null;
    public static List<Book> books = null;

    @PostConstruct
    public void init(){
        authors=new ArrayList<>();
        books=new ArrayList<>();

        authors.add(new Author(1, "Kolin", "Huver", "biography1"));
        authors.add(new Author(2, "Sebastian", "Ficek", "biography2"));
        authors.add(new Author(3, "Agata", "Kristi", "biography3"));
        authors.add(new Author(4, "Ana", "Tod", "biography4"));
        authors.add(new Author(5, "Kris", "Karter", "biography5"));

        books.add(new Book("1", "Veriti", "triler", 2015, new ArrayList<>()));
        books.add(new Book("2", "Dushokrshachot", "triler", 2008, new ArrayList<>()));
        books.add(new Book("3", "Ubistvo vo Orient Ekspres", "triler", 1980, new ArrayList<>()));
        books.add(new Book("4", "After", "Romansa", 2018, new ArrayList<>()));
        books.add(new Book("5", "Zlotvor", "triler", 2020, new ArrayList<>()));
    }
}
