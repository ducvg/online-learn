package com.example.adminator.controller;

import com.example.adminator.model.User;
import com.example.adminator.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth/customer")
public class CustomerAuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/customerregister")
    public String registercustomerPage(Model model) {
        model.addAttribute("userForm", new User());
        return "login";
    }

    @PostMapping("/customerregister")
    public String registercustomer(@ModelAttribute("userForm") User userForm, Model model){
        userForm.setRole("customer");
        User userCreate = userService.add(userForm);
        return "redirect:/auth/customer/login";
    }

    @GetMapping("/customerlogin")
    public String logincustomerPage(Model model, String error, String logout){
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @PostMapping("/customerlogin")
    public String logincustomer(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request, Model model){
        if (email.equals("admin@gmail.com") && password.equals("password")) {
            // Đăng nhập thành công
            HttpSession session = request.getSession();
            session.setAttribute("username", email);
            return "redirect:/auth/customer/customerregister";
        } else {
            // Đăng nhập thất bại
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
            return "login";
        }
    }

}
