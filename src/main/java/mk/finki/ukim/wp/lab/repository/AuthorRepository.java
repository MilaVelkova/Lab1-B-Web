package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.exception.InvalidAuthorIdExcep;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {
    public List<Author> findAll() {
        return DataHolder.authors;
    }
    public Author findById(Long id){
        return DataHolder.authors.stream().filter(author -> author.getId() == id).findFirst().orElseThrow(InvalidAuthorIdExcep::new);

    }
}
