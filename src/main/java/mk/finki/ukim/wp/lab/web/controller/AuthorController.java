package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.service.Interface.AuthorService;
import mk.finki.ukim.wp.lab.service.implementation.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Controller
@RequestMapping("/authorCon")
public class AuthorController {
    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(SpringTemplateEngine springTemplateEngine, AuthorService authorService, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @PostMapping()
    public String doGet(@RequestParam String bookIsbn, Model model){
        model.addAttribute("authors", authorService.listAuthors());
        model.addAttribute("isbn", bookIsbn);
        model.addAttribute("id", bookService.findBookByIsbn(bookIsbn).getId());
        model.addAttribute("bodyContent", "authorList");
        return "master-template";
    }
}
