package com.example.adminator.controller;

import com.example.adminator.model.CourseExpert;
import com.example.adminator.service.CouExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courseexpert")
public class CourseExpertController {
    @Autowired
    private CouExpertService couService;

    @GetMapping("/courseexpertlist")
    public String showCourseExpertList(Model model) {
        List<CourseExpert> listCourseExpert = couService.getListCourseExpert();
        model.addAttribute("listCourseExpert", listCourseExpert);
        return "assignedcourse";
    }
}
