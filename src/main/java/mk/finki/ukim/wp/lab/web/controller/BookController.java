package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.service.Interface.BookService;
import mk.finki.ukim.wp.lab.service.Interface.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class BookController {
    private final BookService bookService;

    private final BookStoreService bookStoreService;

    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }

    @GetMapping("/books")
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        List<Book> books = this.bookService.listBooks();
        model.addAttribute("books", books);
        model.addAttribute("bodyContent", "listBooks");
        return "master-template";
    }
    @PostMapping("/books/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam int IdBookStore){
        this.bookService.save(title, isbn, genre, year, IdBookStore);
        return "redirect:/books";

    }
    @GetMapping ("/books/edit/{bookId}")
    public String editBook(@PathVariable Long bookId, Model model){
        if (this.bookService.findBookbyId(bookId).isPresent()){
            Book book = this.bookService.findBookbyId(bookId).get();
            List<BookStore> bookStores = this.bookStoreService.findAll();
            model.addAttribute("bookStores", bookStores);
            model.addAttribute("book", book);
            model.addAttribute("bodyContent", "addBook");
            return "redirect:/addBook.html";
        }
        //TODO: IMPLEMENTS ERROR
        return "redirect:/books";
    }

    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        this.bookService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/books/edit-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model){
        if (this.bookService.findBookbyId(id).isPresent()){
            Book book = this.bookService.findBookbyId(id).get();
            List<BookStore> bookStores = this.bookStoreService.findAll();
            model.addAttribute("bookStores", bookStores);
            model.addAttribute("book", book);
            model.addAttribute("bodyContent", "addBook");
            return "master-template";
        }
        //TODO: IMPLEMENTS ERROR
        return "redirect:/books";
    }

    @GetMapping("/books/add-form")
    public String getAddBookPage(Model model){
        List<BookStore> bookStores = this.bookStoreService.findAll();
        model.addAttribute("bookStores", bookStores);
        model.addAttribute("bodyContent", "addBook");
        return "master-template";
    }
}
