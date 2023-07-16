package com.example.adminator.controller;

import com.example.adminator.model.Lesson;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.LessonRepository;
import com.example.adminator.service.CouService;
import com.example.adminator.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/managerlesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CouRepository couRepository;

    @GetMapping
    public String getAllLesson(Model model){
        List<Lesson> listLesson= lessonService.getListLesson();
        model.addAttribute("lessons",listLesson);
        return "managerlesson";
    }

    @GetMapping("/add")
    public String addLessonForm(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "addlesson";
    }

    @PostMapping("/add")
    public String addLessonSubmit(@ModelAttribute Lesson lesson, @RequestParam("courseID") String courseId ) {
        lesson.setCourseID(Integer.parseInt(courseId));
        lessonService.save(lesson);
        return "redirect:/managerlesson";
    }


    @GetMapping("/edit/{id}")
    public String editLessonForm(@PathVariable("id") Integer id, Model model) {
        Lesson lesson = lessonService.findLesson(id);
        model.addAttribute("lesson", lesson);
        return "editlesson";
    }

    @PostMapping("/update/{id}")
    public String updateLesson(@PathVariable("id") Integer id, @ModelAttribute Lesson lesson, Model model) {
        Lesson existingLesson = lessonService.findLesson(id);
        existingLesson.setCourseID(lesson.getCourseID());
        existingLesson.setTitle(lesson.getTitle());
        existingLesson.setContent(lesson.getContent());
        existingLesson.setVideo(lesson.getVideo());
        existingLesson.setResource(lesson.getResource());
        lessonService.save(existingLesson);
        return "redirect:/managerlesson";
    }

    @GetMapping("/delete/{id}")
    public String deleteLesson(@PathVariable("id") Integer id) {
        Lesson lesson = lessonService.findLesson(id);
        lessonService.delete(lesson);
        return "redirect:/managerlesson";
    }

}
