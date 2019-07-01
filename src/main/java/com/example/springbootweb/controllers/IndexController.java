package com.example.springbootweb.controllers;

import com.example.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {

    /**
     * @RequestMapping(value = "/index", method = RequestMethod.GET)
     *
     * Model is an interface with some abstract methods (it goes throught argument aa implementation of this interface)
     * @param model
     * @return
     */
    @GetMapping({"/index", "/"})
    public String index(Model model) {
        model.addAttribute("title", "Spring Index Model");
        return "index";
    }

    /**
     * Implement ModelMap
     * @param mv
     * @return
     */
    @GetMapping("/home")
    public ModelAndView home(ModelAndView mv) {
        mv.setViewName("index");
        mv.addObject("title", "Spring Home ModelAndView");
        return mv;
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User user = new User();
        user.setName("Carlos");
        user.setLastName("Jaramillo");

        model.addAttribute("user", user);
        model.addAttribute("title", "User Profile");
        return "profile";
    }
}
