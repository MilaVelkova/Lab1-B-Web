package mk.finki.ukim.wp.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import mk.finki.ukim.wp.lab.repository.BookStoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookService implements mk.finki.ukim.wp.lab.service.Interface.BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookStoreRepository bookStoreRepository;
    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        Author author = authorRepository.findById(authorId);
        Book book = bookRepository.findByIsbn(isbn);
        return bookRepository.addAuthorToBook(author, book);
    }
    @Override
    public Author addAuthorToBook(Long authorId, long id) {
        Author author = authorRepository.findById(authorId);
        Book book = bookRepository.findById(id).get();
        return bookRepository.addAuthorToBook(author, book);
    }
    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public void save(String title, String isbn, String genre, int year, int IdBookStore) {
        BookStore bookStore = bookStoreRepository.findById(IdBookStore);
        bookRepository.save(title, isbn, genre, year, bookStore);
    }

    @Override
    public Optional<Book> findBookbyId(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        bookRepository.delete(id);
    }

}
