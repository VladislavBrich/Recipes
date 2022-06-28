package com.example.blog.Controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main page");
        return "index";
    }

    @GetMapping("contacts")
    public String contacts(Model model) {
        model.addAttribute("title", "Contacts page");
        return "contacts";
    }

    @GetMapping("faq")
    public String faq(Model model) {
        model.addAttribute("title", "faq page");
        return "faq";
    }

}
