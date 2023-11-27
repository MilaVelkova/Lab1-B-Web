package mk.finki.ukim.wp.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.repository.BookStoreRepository;
import mk.finki.ukim.wp.lab.service.Interface.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BookStoreService implements mk.finki.ukim.wp.lab.service.Interface.BookStoreService {

    private final BookStoreRepository bookStoreRepository;
    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }
}
