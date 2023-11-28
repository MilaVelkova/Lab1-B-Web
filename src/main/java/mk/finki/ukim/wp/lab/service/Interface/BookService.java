package mk.finki.ukim.wp.lab.service.Interface;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);

    Author addAuthorToBook(Long authorId, long id);

    Book findBookByIsbn(String isbn);

    void save(String title, String isbn, String genre, int year, int IdBookStore);
    Optional<Book> findBookbyId(long id);

    void delete(long id);
}
