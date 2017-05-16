package com.zaioro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Val on 2017-05-07.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }
}
