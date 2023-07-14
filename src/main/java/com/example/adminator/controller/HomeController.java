package com.example.adminator.controller;

import com.example.adminator.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
