package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.service.implementation.AuthorService;
import mk.finki.ukim.wp.lab.service.implementation.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.ArrayList;

@Controller
@RequestMapping("/bookDetailsCon")
public class BookDetailsController {
    private final SpringTemplateEngine springTemplateEngine;
    private final BookService bookService;

    private final AuthorService authorService;

    public BookDetailsController(SpringTemplateEngine springTemplateEngine, BookService bookService, AuthorService authorService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping()
    public String doGet(@RequestParam long authorId, @RequestParam long id, Model model){
        Book book = bookService.findBookbyId(id).get();
//        if (book != null){
//            Book b = new Book(book.)
//        }
        Author author = authorService.findById(authorId);
        this.bookService.addAuthorToBook(authorId,id);
        model.addAttribute("details", book);
        model.addAttribute("bodyContent", "bookDetails");
        return "master-template";
    }
    @PostMapping("/delete/{id}")
    public String  deleteauthor(@PathVariable Long id, Model model){
        Book book = bookService.findBookbyId(id).get();
        book.setAuthors(new ArrayList<>());
        model.addAttribute("details", book);
        model.addAttribute("bodyContent", "bookDetails");
        return "master-template";
    }

}
