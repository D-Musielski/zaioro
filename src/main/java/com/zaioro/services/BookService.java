package com.zaioro.services;

import com.zaioro.models.Book;

/**
 * Created by Val on 2017-04-09.
 */
public interface BookService {
    Iterable<Book> listAllBooks();
    Book getBookById(Integer id);
    Book saveBook(Book book);
    void deleteBook(Integer id);
}
