package com.zaioro.loader;

import com.zaioro.models.Role;
import com.zaioro.models.User;
import com.zaioro.repositories.BookRepository;
import com.zaioro.services.RoleService;
import com.zaioro.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

//import com.zaioro.services.RoleService;
//import com.zaioro.services.UserService;

/**
 * Created by Val on 2017-04-09.
 */

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private UserService userService;
    private RoleService roleService;

    private Logger logger = Logger.getLogger(Loader.class);

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Book dexter = new Book();
//        dexter.setAuthor("Jeff Lindsay");
//        dexter.setTitle("Darkly Dreaming Dexter");
//        bookRepository.save(dexter);
//
//        logger.info("dex " + dexter.getId());
//
//        Book shining = new Book();
//        shining.setAuthor("Stephen King");
//        shining.setTitle("Shining");
//        bookRepository.save(shining);
//
//        logger.info("sh " + shining.getId());

//        loadUsers();
//        loadRoles();
//        assignUsersToUserRole();
//        assignUsersToAdminRole();
    }

    private void loadUsers() {
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("user");
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        userService.saveOrUpdate(user2);

        User user3 = new User();
        user3.setUsername("user3");
        user3.setPassword("user");
        userService.saveOrUpdate(user3);

    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        logger.info("Saved role" + role.getRole());
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        logger.info("Saved role" + adminRole.getRole());
    }
    private void assignUsersToUserRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
                users.forEach(user -> {
                    if (!user.getUsername().equals("admin")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
    private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("admin")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
}

