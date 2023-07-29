package com.example.adminator.controller;

import com.example.adminator.Join.CourseExpertJoin;
import com.example.adminator.model.CourseExpert;
import com.example.adminator.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/expert")
public class ExpertController {
    @Autowired
    private ExpertService couService;

    @GetMapping("/list")
    public String showCourseExpertList(Model model) {
        List<Object[]> expertlist = couService.getListExpert();
        List<CourseExpertJoin> list = new ArrayList<>();
        for (Object[] row : expertlist){
            list.add(new CourseExpertJoin((String) row[0], (String) row[1], (String) row[2], (boolean) row[3] ? "Active" : "Disabled"));
        }
        model.addAttribute("listCourseExpert", list);
        return "assignedcourse";
    }
}
