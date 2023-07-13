package com.example.adminator.controller;
import com.example.adminator.model.User;
import com.example.adminator.repository.UserRepository;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/managerUser")
public class UserController {
    @Autowired
    private UserService UserService;
    @Autowired
    private UserRepository UserRepository;
    @GetMapping
    public String getAllUser(Model model){
        List<User> listUser= UserService.getListUser();
        model.addAttribute("Users",listUser);
        return "managerUser";
    }

    // Còn thiếu cái role set như phần reg là nó phải theo UserID rồi mới đến web edit

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @ModelAttribute User User, Model model) {
        User existingUser = UserService.findUser(id);
        existingUser.setName(User.getName());
        existingUser.setEmail(User.getEmail());
        existingUser.setPassword(User.getPassword());
        UserService.save(existingUser);
        return "redirect:/editprofile";
    }

    //Có thật sự là càn delete user ko ?
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        User User = UserService.findUser(id);
        UserService.delete(User);
        return "redirect:/editprofile";
    }

    //    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") Integer id, Model model) {
//        User User = UserService.findUser(id);
//        model.addAttribute("User", User);
//        return "editprofile";
//    }

}
