package com.zaioro.loader;

import com.zaioro.models.Book;
import com.zaioro.repositories.BookRepository;
//import com.zaioro.services.RoleService;
//import com.zaioro.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Val on 2017-04-09.
 */

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
//    private UserService userService;
//    private RoleService roleService;

    private Logger logger = Logger.getLogger(Loader.class);

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Autowired
//    public void setRoleService(RoleService roleService) {
//        this.roleService = roleService;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Book dexter = new Book();
        dexter.setAuthor("Jeff Lindsay");
        dexter.setTitle("Darkly Dreaming Dexter");
        bookRepository.save(dexter);

        logger.info("dex " + dexter.getId());

        Book shining = new Book();
        shining.setAuthor("Stephen King");
        shining.setTitle("Shining");
        bookRepository.save(shining);

        logger.info("sh " + shining.getId());
    }
}
