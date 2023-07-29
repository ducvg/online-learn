package com.example.adminator.controller;

import com.example.adminator.join.CourseExpertUserJoin;
import com.example.adminator.join.CourseUserCategoryJoin;
import com.example.adminator.join.LessonCourseJoin;

import com.example.adminator.model.Lesson;
import com.example.adminator.model.*;
import com.example.adminator.service.CouService;
import com.example.adminator.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public String getAllLesson(Model model,@RequestParam("courseid") int courseID) {
        List<Object[]> listLesson = lessonService.getLessonByCourseID(courseID);
        List<LessonCourseJoin> list = new ArrayList<>();
        for (Object[] row : listLesson) {
            list.add(new LessonCourseJoin((int) row[0],(int) row[1], (String) row[2], (String) row[3],(String) row[4],(String) row[5]));
        }
        model.addAttribute("lessons", list);
        return "lessonList";
    }

    @GetMapping("/add")
    public String addLessonForm(Model model) {
        List<Integer> courseID= couService.getAllCourseID();
        model.addAttribute("courses", courseID);
        return "addlesson";
    }

    @PostMapping("/add")
    public String addLessonSubmit(@RequestParam("CourseID") int CourseID, @RequestParam("Title") String Title,
                                  @RequestParam("Content") String Content, @RequestParam("Video") String Video, @RequestParam("Resource") String Resource) {
        Lesson newLesson = new Lesson(CourseID,Title,Content,Video,Resource);
        lessonService.addLesson(newLesson);
        return "redirect:/lesson/list?courseid=" + CourseID;
    }

    @GetMapping("/update/{id}")
    public String editLessonForm(@PathVariable("id") Integer id, Model model) {
        Lesson lesson = lessonService.findLesson(id);
        List<Integer> courseid = couService.getAllCourseID();
        model.addAttribute("courseid",courseid);
        model.addAttribute("lessons", lesson);
        return "editlesson";
    }
    @PostMapping("/update/{id}")
    public String updateLesson(@PathVariable("id") Integer id,@RequestParam("Title") String title, @RequestParam("Content") String content,
                               @RequestParam("Video") String video,@RequestParam("Resource") String resource,@RequestParam("CourseID") int courseid) {
        Lesson existingLesson = lessonService.findLesson(id);
        existingLesson.setTitle(title);
        existingLesson.setContent(content);
        existingLesson.setVideo(video);
        existingLesson.setResource(resource);
        lessonService.update(existingLesson);
        return "redirect:/lesson/list?courseid=" + courseid;
    }
    @GetMapping("/delete/{id}")
    public String deleteCou(@PathVariable("id") Integer id, @RequestParam("courseid") int courseid) {
        Lesson lesson = lessonService.findLesson(id);
        lessonService.delete(lesson);
        // Sử dụng giá trị courseid trong phương thức return
        return "redirect:/lesson/list?courseid=" + courseid;
    }


}
