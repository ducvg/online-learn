package com.example.adminator.controller;

import com.example.adminator.join.LessonCourseJoin;

import com.example.adminator.join.TestCourseJoin;
import com.example.adminator.model.Lesson;
import com.example.adminator.model.Test;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.TestRepository;
import com.example.adminator.service.CouService;
import com.example.adminator.service.LessonService;
import com.example.adminator.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private CouService couService;


    @GetMapping("/list")
    public String getAllLesson(Model model,@RequestParam("testid") int testid) {
        List<Object[]> listLesson = testService.getTestByCourseID(testid);
        List<TestCourseJoin> list = new ArrayList<>();
        for (Object[] row : listLesson) {
            list.add(new TestCourseJoin((int) row[0],(int) row[1], (String) row[2], (int) row[3],(String) row[4]));
        }
        model.addAttribute("tests", list);
        return "testList";
    }
}
