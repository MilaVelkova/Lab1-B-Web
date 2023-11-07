package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.exception.InvalidBookExcep;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    public List<Book> findAll(){
        return DataHolder.books;
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
}
