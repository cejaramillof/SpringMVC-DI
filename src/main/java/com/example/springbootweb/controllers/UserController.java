package com.example.springbootweb.controllers;

import com.example.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/", ""})
    public String index(Model model) {
        List<User> users = Arrays.asList(
                new User("Carlos", "Jaramillo", "c@xd.com"),
                new User("Eduardo", "Franco", "e@xd.com"),
                new User("Tyrone", "Jaramillo", "t@xd.com")
        );

        model.addAttribute("users", users);
        model.addAttribute("title", "User list");

        return "user/index";
    }

    @GetMapping("/show")
    public String show(Model model) {

        User user = new User();

        user.setName("Carlos");
        user.setLastName("Jaramillo");

        model.addAttribute("user", user);
        model.addAttribute("title", "User Profile");

        return "user/show";
    }
}
