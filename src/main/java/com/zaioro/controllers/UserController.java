package com.zaioro.controllers;

import com.zaioro.models.User;
import com.zaioro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}

    @RequestMapping(value = "/adduser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "usernew";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String allUsers(Model model) {
        model.addAttribute("users", userService.listAll());
        return "users";
    }

    @RequestMapping (value = "user", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveOrUpdate(user);
        return "redirect:/login?logout";
    }

    @RequestMapping (value = "/deleteuser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
