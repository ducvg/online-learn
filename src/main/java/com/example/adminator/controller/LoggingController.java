package com.example.adminator.controller;

import com.example.adminator.model.User;
import com.example.adminator.service.EmailSenderService;
import com.example.adminator.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class LoggingController {
    @Autowired private UserService userService;
    @Autowired private EmailSenderService senderService;

    @GetMapping("/forgot")
    public String forgotPass(){
        return "forgot";
    }

    @PostMapping("/alert")
    public String doforgot(@RequestParam("email") String email, RedirectAttributes ra){
        User u = userService.findEmail(email);
        if(u == null){
            ra.addFlashAttribute("mailErr","Invalid Email!");
            return "redirect:/forgot";
        } else {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            String newPass = RandomStringUtils.random(12,characters);
            u.setPassword(newPass);
            userService.changePassword(u);
            senderService.sendEmail(email,
                    "Forgot Password request",
                    "Your password has been set to: "+newPass+"\n" +
                            "Do not share this with anyone else!");
            System.out.println(u.getPassword());
            return "alert";
        }
    }

    @GetMapping("/signin")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "signup";
    }

    @PostMapping("/register")
    public String doregister(@RequestParam("name") String name, @RequestParam("email") String email,
                             @RequestParam("password") String password, @RequestParam("repass") String repass,
                             @RequestParam("Role") String role, RedirectAttributes model){
        User user = userService.findEmail(email);
        if(user == null){
            if(!password.equals(repass)){
                model.addFlashAttribute("passErr", "Re-enter your password");
            } else {
                user = new User(name,email,password,role,true);
                userService.add(user);
                model.addFlashAttribute("success",email+" successfully registered.");
                return "redirect:/signin";
            }
        } else {
            model.addFlashAttribute("mailErr","Email existed!");
        }
        return "redirect:/register";
    }

//    @PostMapping("/login")
//    public String postLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
//        User u = userService.findEmail(email);
//        if (u != null && u.getPassword().equals(password)) {
//            session.setAttribute("user", u);
//            return "redirect:/";
//        } else {
//            model.addAttribute("error", "Check your email and password again!");
//            return "redirect:/signin";
//        }
//    }
}
