package com.example.adminator.controller;

import com.example.adminator.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/home")
public class HomeController {


    @GetMapping
    public String homePage(){
        return "home";
    }

}
