package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.model.exception.InvalidBookExcep;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    public List<Book> findAll(){
        return DataHolder.books;
    }

    public void save(String title, String isbn, String genre, int year, BookStore IdBookStore){
        DataHolder.books.removeIf(book -> book.getIsbn().equals(isbn));
        Book book = new Book(isbn, title, genre, year, new ArrayList<>(), IdBookStore);
        DataHolder.books.add(book);
    }
    public Book findByIsbn(String isbn){
        return DataHolder.books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElseThrow(InvalidBookExcep::new);
    }
    public Author addAuthorToBook(Author author, Book book){
        Book b = findByIsbn(book.getIsbn());
            if (b == null) throw new InvalidBookExcep();
            else{
                book.getAuthors().add(author);
            }
            return author;

    }
    public Optional<Book> findById(long id){
        return DataHolder.books.stream().filter(book -> book.getId()==id).findFirst();
    }

    public void delete(long id){
        DataHolder.books.removeIf(book -> book.getId()==id);
    }
}
