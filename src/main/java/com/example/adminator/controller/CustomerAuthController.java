package com.example.adminator.controller;
import com.example.adminator.model.User;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/auth")
public class CustomerAuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/customerregister")
    public String registerCustomerPage(){
        return "home";
    }

//    @PostMapping("/customerregister")
//    public String registerCustomer(){
//
//        return
//    }
}
