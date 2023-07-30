package com.example.adminator.controller;

import com.example.adminator.model.User;
import com.example.adminator.repository.UserRepository;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@Autowired private UserService service;

    @GetMapping("/")
    public String homepage(Model model, Authentication authentication){
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            User u = service.findEmail(authentication.getName());
            model.addAttribute("user",u);
        }
        return "index";
    }

    @GetMapping("/About")
    public String aboutpage(Model model, Authentication authentication){
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            User u = service.findEmail(authentication.getName());
            model.addAttribute("user",u);
        }
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model, Authentication authentication){
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            User u = service.findEmail(authentication.getName());
            model.addAttribute("user",u);
        }
        return "contact";
    }
}
