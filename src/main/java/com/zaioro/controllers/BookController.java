package com.zaioro.controllers;

import com.zaioro.models.Book;
import com.zaioro.models.User;
import com.zaioro.services.BookService;
import com.zaioro.services.UserDetailsImpl;
import com.zaioro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Val on 2017-04-09.
 */

@Controller
public class BookController {

    private BookService bookService;
    private UserService userService;
    private Integer userId;
    private User u;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping (value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl user;
        try {
            user = (UserDetailsImpl) authentication.getPrincipal();
        } catch (Exception e) {
            return "redirect:/login";
        }
        u = userService.findByUsername(user.getUsername());
        userId = u.getId();
        List<Book> books = new ArrayList<>();
        List<Book> userBooks = new ArrayList<>();
        books.addAll((Collection<? extends Book>) bookService.listAllBooks());
        for (Book book : books) {
            if (book.getUser().getId() == userId) {
                userBooks.add(book);
            }
        }
        model.addAttribute("books", userBooks);
        return "books";
    }

    @RequestMapping (value = "/book/show/{id}")
    public String showBook(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "bookshow";
    }

    @RequestMapping (value = "/book/new")
    public String newBook1(Model model, HttpSession session) {
        session.setAttribute("userId", userId);
        model.addAttribute("book", new Book());
        return "booknew";
    }

    @RequestMapping (value = "/book/edit/{id}")
    public String editBook(@PathVariable Integer id, Model model, HttpSession session) {
        session.setAttribute("userId", userId);
        model.addAttribute("book", bookService.getBookById(id));
        return "bookedit";
    }

    @RequestMapping (value = "book", method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @RequestMapping (value = "/book/delete/{id}")
    public String deleteBook(@PathVariable Integer id, HttpSession session) {
        session.removeAttribute("userId");
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
