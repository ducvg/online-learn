package com.example.adminator.controller;

import com.example.adminator.model.User;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/expert")
public class ExpertAuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/expertregister")
    public String registerExpertPage(Model model) {
        model.addAttribute("userForm", new User());
        return "SignupExperts";
    }

    @PostMapping("/expertregister")
    public String registerExpert(@ModelAttribute("userForm") User userForm, Model model){
        userForm.setRole("Expert");
        User userCreate = userService.add(userForm);

        return "redirect:/auth/expert/expertlogin";
    }
    @GetMapping("/expertlogin")
    public String loginExpertPage(Model model, String error, String logout){
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "expertlogin";
    }

//    @PostMapping("/expertlogin")
//    public String loginExpert(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request){
//        User u = userService.findEmail(email);
//        if(u != null || u.getPassword().equals(password)){
//            HttpSession session = request.getSession();
//            System.out.println("YOYOYOYOYOYOYYYOYO*****"+u.getName());
//            session.setAttribute("user", u);
//            return "expertdashboard";
//        } else {
//            // Đăng nhập thất bại
//            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
//            return "expertlogin";
//        }
//    }

}
