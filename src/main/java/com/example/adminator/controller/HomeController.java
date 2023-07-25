package com.example.adminator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/Home")
    public String homepage(){
        return "index";
    }

    @GetMapping("/About")
    public String aboutpage(){
        return "about";
    }
}
