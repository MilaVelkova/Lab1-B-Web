package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.model.exception.InvalidBookExcep;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookStoreRepository {
    public List<BookStore> findAll(){
        return DataHolder.bookStores;
    }
    public BookStore findById(long id){
        return DataHolder.bookStores.stream().filter(book -> book.getId() == id).findFirst().orElseThrow(InvalidBookExcep::new);
    }

}
