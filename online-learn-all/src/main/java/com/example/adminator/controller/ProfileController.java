package com.example.adminator.controller;

import com.example.adminator.model.User;
import com.example.adminator.repository.UserRepository;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class ProfileController {

    @Autowired private UserService userService;

    @GetMapping
    public String profile(Model model, Authentication authentication){
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            User u = userService.findEmail(authentication.getName());
            model.addAttribute("user",u);
        }
        return "user";
    }

    @GetMapping("/edit")
    public String editProfile(Model model, Authentication authentication) {
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            User u = userService.findEmail(authentication.getName());
            model.addAttribute("user", u);
        }
        return "editprofile";
    }

    @PostMapping("/edit")
    public String updateProfile(@RequestParam("name") String name, @RequestParam(value = "phone", required = false) String phone, @RequestParam("email") String email,
                                @RequestParam(value = "dob",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob, @RequestParam(value = "gender",required = false) String gender, @RequestParam(value = "country",required = false) String nationality){
        User setUser = userService.findEmail(email);
        setUser.setName(name);
        setUser.setDob(dob);
        setUser.setPhone(phone);
        setUser.setGender(gender);
        setUser.setNationality(nationality);
        userService.update(setUser);
        return "redirect:/user/edit";
    }

    @GetMapping("/changepassword")
    public String repass(){return "changepassword";}

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/pass")
    public String changePass(Model model, Authentication authentication,@RequestParam("nowpass") String pass,@RequestParam("newpass") String newpass,
                             @RequestParam("renewpass") String renewpass) {
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            User u = userService.findEmail(authentication.getName());
            if (passwordEncoder.matches(pass, u.getPassword())) {
                if(newpass.isBlank() || newpass.length()<=7) model.addAttribute("repass","Password too simple !");
                else if(newpass.equals(renewpass)){
                   u.setPassword(newpass);
                    userService.changePassword(u);
                    return "redirect:edit";
                }
                else model.addAttribute("renewpass","Passwords not matching !");
            }
            else model.addAttribute("thisPass", "Invalid password !");
        }
        return "changepassword";
    }
}
