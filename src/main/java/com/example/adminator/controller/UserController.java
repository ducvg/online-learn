package com.example.adminator.controller;

import com.example.adminator.model.Course;
import com.example.adminator.model.User;
import com.example.adminator.repository.UserRepository;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getAllCou(Model model){
        List<User> list= userService.getListUser();

        model.addAttribute("users",list);
        return "edituser";
    }

    @GetMapping("/add")
    public String addCouForm(Model model) {
        model.addAttribute("user", new Course());
        return "addcourse";
    }

//    @PostMapping("/add")
//    public String addCouSubmit(@ModelAttribute User user, @RequestParam("category") String categoryId ) {
//        user.setCategoryID(Integer.parseInt(categoryId));
//        userService.save(course);
//        return "redirect:/managercourse";
//    }
//
//
//    @GetMapping("/edit/{id}")
//    public String editCouForm(@PathVariable("id") Integer id, Model model) {
//        User user = userService.findCou(id);
//        model.addAttribute("user", course);
//        return "editcourse";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateCou(@PathVariable("id") Integer id, @ModelAttribute User user, Model model) {
//        Course existingCou = userService.findCou(id);
//        existingCou.setTitle(user.getTitle());
//        existingCou.setThumbnail(user.getThumbnail());
//        existingCou.setCategoryID(user.getCategoryID());
//        userService.save(existingCou);
//        return "redirect:/managercourse";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteCou(@PathVariable("id") Integer id) {
//        User user = userService.findCou(id);
//        userService.delete(course);
//        return "redirect:/managercourse";
//    }
}
