package com.jk.portfolio.EnggAid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/home")
    public String home() {
        return "home"; // Returns the home.html template
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // Returns the about.html template
    }

    @GetMapping("/service")
    public String service() {
        return "services"; // Returns the service.html template
    }

    @GetMapping("/work")
    public String work() {
        return "work"; // Returns the work.html template
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact"; // Returns the contact.html template
    }

    @GetMapping("/product")
    public String product() {
        return "product";  // Maps to product.html
    }

    @GetMapping("/team")
    public String team() {
        return "team";  // Maps to team.html
    }

}