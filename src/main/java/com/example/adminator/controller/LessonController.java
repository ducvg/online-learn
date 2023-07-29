package com.example.adminator.controller;

import com.example.adminator.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

}
