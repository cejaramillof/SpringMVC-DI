package com.example.springbootweb.controllers;

import com.example.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/", ""})
    public String index(Model model) {
        model.addAttribute("title", "User list");

        return "user/index";
    }

    @GetMapping("/{userId}")
    public String show(@PathVariable Integer userId, Model model) {
        // RequestParam don't change path
        // @PathVariable - @RequestParam (name="userId", required = false, defaultValue = "0") Integer userId
        // HttpServletRequest request - from javax.servlet / request.getParameter("paramName") return only string

        User userAdmin = new User();
        userAdmin.setName("Carlos");
        userAdmin.setLastName("Jaramillo");
        model.addAttribute("userAdmin", userAdmin);

        model.addAttribute("userId", userId);
        model.addAttribute("title", "User Profile");

        return "user/show";
    }

    /**
     * @return List of all users to all Methods of this controller
     */
    @ModelAttribute("users")
    public List<User> usersList() {
        List<User> users = Arrays.asList(
                new User(0, "Carlos", "Jaramillo", "c@xd.com"),
                new User(1, "Eduardo", "Franco", "e@xd.com"),
                new User(2, "Tyrone", "Jaramillo", "t@xd.com")
        );
        return users;
    }
}
