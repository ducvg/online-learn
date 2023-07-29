package com.example.adminator.controller;

import com.example.adminator.join.CourseExpertUserJoin;
import com.example.adminator.repository.CourseExpertRepository;

import com.example.adminator.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/expert")
public class ExpertCourseController {
    @Autowired
    private ExpertService couService;
    @Autowired
    private CourseExpertRepository courseExpertRepository;


    @GetMapping()
    public String showCourseExpertList(Model model, @RequestParam(name = "userID") int userId) {
        List<Object[]> courseexpertlist = courseExpertRepository.getCourseExpertbyUserID(userId);
        List<CourseExpertUserJoin> list = new ArrayList<>();
        for (Object[] row : courseexpertlist) {
            list.add(new CourseExpertUserJoin((int) row[0], (String) row[1], (String) row[2]));
        }
        model.addAttribute("expertcourselist", list);
        return "expertdashboard";
    }
}
