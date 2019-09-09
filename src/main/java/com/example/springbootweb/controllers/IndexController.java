package com.example.springbootweb.controllers;

import com.example.springbootweb.models.service.FirstService;
import com.example.springbootweb.models.service.IFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
Stereotypes
@Component - Generic for any component management by spring
@Repository - Data Access Component DAOs, Persist
@Service - Business logic, Services, multiples daos
@Controller - MVC Controllers
 */
@Controller
@RequestMapping("/app")
public class IndexController {

    public static final String CONSTANT_EXAMPLE = "Constant example string";

    // Dependency injection values
    @Value("${application.lolVar}")
    private String lolVar;

    @Value("${application.xdVar}")
    private String xdVar;

    // Without dependency injection
    private FirstService service = new FirstService();

    // dependency injection (singleton)
    // Hollywood principle
    // Dependency injection is to assign an obj da reference of another like a attribute of this
    // low coupling
    // All beans injected need have empty constructor
    @Autowired
    private FirstService diService;


    // dependency injection in attribute with interface
    @Autowired
    @Qualifier("basicService") // indicate what class inject
    private IFirstService diIService;

    /**
     * @RequestMapping(value = "/index", method = RequestMethod.GET)
     *
     * Model is an interface with some abstract methods (it goes throught argument aa implementation of this interface)
     * ModelMap (class) implement is equals to this.
     * @param model
     * @return
     */
    @GetMapping({"/index", "/"})
    public String index(Model model) {
        model.addAttribute("title", "Spring Index Model");
        model.addAttribute("service", service.operation());
        model.addAttribute("diService", diService.operation());
        model.addAttribute("diIService", diIService.operation());

        model.addAttribute("lolTitle", lolVar);
        model.addAttribute("xdTitle", xdVar);

        return "index";
    }

    /**
     * Implement ModelMap (class) and view to unifique return
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

    // dependency injection in set
    //@Autowired
    public void setDiIService(IFirstService diIService) {
        this.diIService = diIService;
    }

    // dependency injection in constructor, when is used by constructor can be skip @autowired
    // because when you send any attribute for construct managements by spring he auto inject this.
    /*
    @Autowired
    public IndexController(IFirstService diIService) {
        this.diIService = diIService;
    }
    */
}
