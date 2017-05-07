package com.zaioro.controllers;

import com.zaioro.models.Book;
import com.zaioro.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Val on 2017-04-09.
 */

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping (value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.listAllBooks());
        return "books";
    }

    @RequestMapping (value = "/book/show/{id}")
    public String showBook(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "bookshow";
    }

    @RequestMapping (value = "/book/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "booknew";
    }

    @RequestMapping (value = "/book/edit/{id}")
    public String editBook(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "bookedit";
    }

    @RequestMapping (value = "book", method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @RequestMapping (value = "/book/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
