package com.example.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eregistrar/home")
public class HomeController {
    @GetMapping()
    public String getHomePage(Model model){
        model.addAttribute("pageTitle", "Home");
        return "home";
    }
}
