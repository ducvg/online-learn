package com.example.adminator.controller;
import com.example.adminator.repository.RegistrationRepository;
import com.example.adminator.service.CouService;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/registration")
public class RegistrationController {

    @Autowired
    private RegistrationRepository repo;

    @GetMapping
    public String viewRegistration(){
        return "";
    }

}
