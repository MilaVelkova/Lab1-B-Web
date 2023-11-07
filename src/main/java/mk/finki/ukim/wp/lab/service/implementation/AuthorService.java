package mk.finki.ukim.wp.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.exception.InvalidAuthorIdExcep;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AuthorService implements mk.finki.ukim.wp.lab.service.AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id);
    }
}
