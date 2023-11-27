package mk.finki.ukim.wp.lab.service.Interface;

import mk.finki.ukim.wp.lab.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> listAuthors();
    Author findById(Long id);
}
