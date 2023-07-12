package com.example.adminator.controller;

import com.example.adminator.model.Course;
import com.example.adminator.repository.CategoryRepository;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.service.CouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/managercourse")
public class CourseController {
    @Autowired
    private CouService couService;
    @Autowired
    private CouRepository couRepo;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String getAllCou(Model model){
        List<Course> listCou= couService.getListCou();

        model.addAttribute("courses",listCou);
        return "managercou";
    }
}
