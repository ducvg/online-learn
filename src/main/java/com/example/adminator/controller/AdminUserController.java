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
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private UserService userService;


    @GetMapping("")
    public String getAllCou(Model model){
        List<User> list= userService.getListUser();
        model.addAttribute("users",list);
        return "userList";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        List<String> roles = userService.listRole();
        model.addAttribute("roles",roles);
        return "adduser";
    }

    @PostMapping("/add")
    public String addCouSubmit(@RequestParam("username") String name, @RequestParam("email") String email,
                               @RequestParam("password") String password, @RequestParam("selectedRole") String selectedRole,
                               @RequestParam("status") boolean status) {
        User newUser = new User(name,email,password,selectedRole,status);
        userService.add(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping("/update/{id}")
    public String editUserForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.findUser(id);
        List<String> roles = userService.listRole();
        model.addAttribute("roles",roles);
        model.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Integer id,@RequestParam("username") String name, @RequestParam("email") String email,
                            @RequestParam("password") String password, @RequestParam("selectedRole") String selectedRole,
                            @RequestParam("status") boolean status) {
        User existingUser = userService.findUser(id);

        existingUser.setName(name);
        existingUser.setEmail(email);
        existingUser.setPassword(password);
        existingUser.setRole(selectedRole);
        existingUser.setStatus(status);
        userService.update(existingUser);
        return "redirect:/admin/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        User user = userService.findUser(id);
        userService.delete(user);
        return "redirect:/admin/user";
    }

    @PostMapping("/ban")
    public String changeStatus(@RequestParam("userID") Integer userID,@RequestParam("status") boolean status) {
        User newUser = userService.findUser(userID);
        newUser.setStatus(status);
        userService.update(newUser);
        return "redirect:/admin/user";
    }

}
