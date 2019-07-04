package com.example.springbootweb.controllers;

import com.example.springbootweb.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {

    // Dependency injection values
    @Value("${application.lolVar}")
    private String lolVar;

    @Value("${application.xdVar}")
    private String xdVar;

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

        model.addAttribute("lolTitle", lolVar);
        model.addAttribute("xdTitle", xdVar);

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

    @GetMapping("/redirect")
    public String redirect() {

        // reset request params
        //return "redirect:/app/home";

        // dont reset request params - RequestDispatcher.fordward() from Api servlet
        //return "forward:/app/home";

        return "redirect:https://google.com";
    }

}
