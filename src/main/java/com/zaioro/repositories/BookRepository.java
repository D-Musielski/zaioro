package com.zaioro.repositories;

import com.zaioro.models.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Val on 2017-04-09.
 */
public interface BookRepository extends CrudRepository<Book, Integer>{
}
