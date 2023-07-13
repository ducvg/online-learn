package com.example.adminator.controller;

import com.example.adminator.model.Course;
import com.example.adminator.model.User;
import com.example.adminator.repository.CouRepository;
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
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){
        User u = userService.findUser(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
        return ResponseEntity.ok(u);
    }

    @GetMapping
    public List<User> getListCUser(){
        return userService.getListUser();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        System.out.println();
        User userCreate = userService.add(user);
        if(userCreate != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tạo mới User không thành công!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUSer(@PathVariable Integer id ,@RequestBody User user){
        User u = userService.findUser(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        u.setStatus(user.isStatus());

        return ResponseEntity.ok(userService.update(u));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(userService.findUser(id));
    }

}
