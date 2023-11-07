package mk.finki.ukim.wp.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookService implements mk.finki.ukim.wp.lab.service.BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
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
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
