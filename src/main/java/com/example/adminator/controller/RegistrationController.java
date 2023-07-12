package com.example.adminator.controller;

import com.example.adminator.model.Course;
import com.example.adminator.model.Registration;
import com.example.adminator.model.User;
import com.example.adminator.repository.RegistrationRepository;
import com.example.adminator.service.CouService;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RegistrationController {
    private RegistrationRepository repo;
    @Autowired
    private UserService userService;
    @GetMapping
    public String getAll(Model model){
        List<Registration> list= repo.findByRegistrationByUserID();
        model.addAttribute("courses",listCou);
        return "viewregistration";
    }

    @GetMapping
    public String deletereg(@PathVariable("id") Integer id) {
        User user = userService.findUser(id);
        userService.delete(user);
        return "redirect:/viewregistration";
    }
}