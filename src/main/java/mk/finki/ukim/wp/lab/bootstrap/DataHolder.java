package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors = null;
    public static List<Book> books = null;

    public static List<BookStore> bookStores = null;

    @PostConstruct
    public void init(){
        authors=new ArrayList<>();
        books=new ArrayList<>();
        bookStores=new ArrayList<>();

        authors.add(new Author(1, "Kolin", "Huver", "biography1"));
        authors.add(new Author(2, "Sebastian", "Ficek", "biography2"));
        authors.add(new Author(3, "Agata", "Kristi", "biography3"));
        authors.add(new Author(4, "Ana", "Tod", "biography4"));
        authors.add(new Author(5, "Kris", "Karter", "biography5"));

        bookStores.add(new BookStore("store1", "Kochani", "address1"));
        bookStores.add(new BookStore("store2", "Skopje", "address2"));
        bookStores.add(new BookStore("store3", "Veles", "address3"));
        bookStores.add(new BookStore("store4", "Shtip", "address4"));
        bookStores.add(new BookStore("store5", "Vinica", "address5"));

        books.add(new Book("1", "Veriti", "triler", 2015, new ArrayList<>(),bookStores.get(2)));
        books.add(new Book("2", "Dushokrshachot", "triler", 2008, new ArrayList<>(), bookStores.get(3)));
        books.add(new Book("3", "Ubistvo vo Orient Ekspres", "triler", 1980, new ArrayList<>(), bookStores.get(0)));
        books.add(new Book("4", "After", "Romansa", 2018, new ArrayList<>(), bookStores.get(4)));
        books.add(new Book("5", "Zlotvor", "triler", 2020, new ArrayList<>(), bookStores.get(1)));
    }
}
