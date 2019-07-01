package com.example.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    //@RequestMapping(value = "/index", method = RequestMethod.GET)
    //@GetMapping("/index")
    @GetMapping({"/index", "/"})
    public String index() {
        return "index";
    }
}
