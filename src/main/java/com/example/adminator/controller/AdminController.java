package com.example.adminator.controller;

import com.example.adminator.join.CourseRegistrationJoin;
import com.example.adminator.join.CourseUserCategoryJoin;
import com.example.adminator.service.CouService;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired private UserService userService;
    @Autowired private CouService couService;

    @GetMapping
    public String adminHome(Model model){
        int courseCount = couService.countCourse();
        int userCount = userService.countUser();
        int activeCount = userService.countActiveUser();
        int expertCount = userService.countExpert();
        model.addAttribute("userCount",userCount);
        model.addAttribute("courseCount",courseCount);
        model.addAttribute("expertCount",expertCount);model.addAttribute("expertPercent",((double)expertCount*100/userCount));
        model.addAttribute("activeCount",activeCount);model.addAttribute("activePercent",((double)activeCount*100/userCount));

        List<Object[]> objs = couService.topRegisterdCourse();
        List<CourseRegistrationJoin> least = new ArrayList<>();
        List<CourseRegistrationJoin> top = new ArrayList<>();
        for (Object[] row : objs) {
            top.add(new CourseRegistrationJoin( (String) row[0], (String) row[1], (Long) row[2]));
            System.out.println("top: "+row[2]);
        }
        model.addAttribute("topCourses",top);
        objs = couService.leastRegisterdCourse();
        for (Object[] row: objs){
            least.add(new CourseRegistrationJoin( (String) row[0], (String) row[1], (Long) row[2]));
            System.out.println("least: "+row[2]);
        }
        model.addAttribute("botCourses",least);
        return "admindashboard";
    }

}
