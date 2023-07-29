package com.example.adminator.controller;

import com.example.adminator.Join.LessonCourseJoin;
import com.example.adminator.model.Course;
import com.example.adminator.model.Lesson;
import com.example.adminator.service.CouService;
import com.example.adminator.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private CouService couService;

    @GetMapping("/list")
    public String getAllLesson(Model model) {
        List<Object[]> listLesson = lessonService.getListLesson();
        List<LessonCourseJoin> list = new ArrayList<>();
        List<String> courses = new ArrayList<>();
        String[] course;
        for (Object[] row : listLesson) {
            courses = lessonService.findCourseByCourseID((int) row[0]);
            course = new String[courses.size()];
            for (int i = 0; i < courses.size(); i++) {
                course[i] = courses.get(i);
            }
            list.add(new LessonCourseJoin((int) row[0], course, (String) row[2], (String) row[3], (String) row[4], (String) row[5]));
        }
        model.addAttribute("lessons", list);
        return "lessonList";
    }

    @GetMapping("/add")
    public String addLessonForm(Model model) {
        List<Integer> courseID = couService.getAllCourseID();
        model.addAttribute("courses", courseID);
        return "addlesson";
    }

    @PostMapping("/add")
    public String addLessonSubmit(@RequestParam("selectedCourseID") int selectedCourseID, @RequestParam("Title") String Title,
                                  @RequestParam("Content") String Content, @RequestParam("Video") String Video, @RequestParam("Resource") String Resource) {
        Lesson newLesson = new Lesson(selectedCourseID, Title, Content, Video, Resource);
        lessonService.addLesson(newLesson);
        return "redirect:/lesson/list";
    }

//    @GetMapping("/update/{id}")
//    public String editLessonForm(@PathVariable("id") Integer id, Model model) {
//        Lesson lesson = lessonService.findLesson(id);
//        List<Integer> courseid = couService.getAllCourseID();
//        model.addAttribute("courseid", courseid);
//        model.addAttribute("lessons", lesson);
//        return "editlesson";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateLesson(@PathVariable("id") Integer id, @RequestParam("Title") String title, @RequestParam("Content") String content,
//                               @RequestParam("Video") String video, @RequestParam("Resource") String resource, @RequestParam("courseidSelect") int courseidSelect) {
//        Lesson existingLesson = lessonService.findLesson(id);
//        existingLesson.setCourseID(courseidSelect);
//        existingLesson.setTitle(title);
//        existingLesson.setContent(content);
//        existingLesson.setVideo(video);
//        existingLesson.setResource(resource);
//        lessonService.update(existingLesson);
//        return "redirect:/lesson/list";
//    }

    @GetMapping("/delete/{id}")
    public String deleteLesson(@PathVariable("id") Integer id) {
        Lesson lesson = lessonService.findLesson(id);
        lessonService.delete(lesson);
        return "redirect:/lesson/list";
    }
}

