package com.zaioro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Val on 2017-04-08.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    String index() {
        return "redirect:books";
    }

}
