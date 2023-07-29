package com.example.adminator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String adminHome(){
        return "admindashboard";
    }

}
