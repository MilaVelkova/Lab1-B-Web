package mk.finki.ukim.wp.lab.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.finki.ukim.wp.lab.service.implementation.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet (urlPatterns = "/bookDetails")
@AllArgsConstructor
public class bookDetails extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookService bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context =  new WebContext(webExchange);
        String isbn = req.getQueryString();
        context.setVariable("details", bookService.findBookByIsbn(isbn));
        springTemplateEngine.process(
                "bookDetails.html",
                context,
                resp.getWriter()
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context =  new WebContext(webExchange);
        String isbn = req.getParameter("isbn");
        bookService.findBookByIsbn(isbn).setAuthors(new ArrayList<>());
        resp.sendRedirect("/bookDetails?" + isbn);
    }
}
