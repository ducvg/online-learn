package com.example.adminator.controller;

import com.example.adminator.Join.CourseUserCategoryJoin;
import com.example.adminator.model.Lesson;
import com.example.adminator.model.User;
import com.example.adminator.service.CouService;
import com.example.adminator.service.LessonService;
import com.example.adminator.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CoursesController {
    @Autowired private CouService service;
    @Autowired private UserService userService;
    @Autowired
    private LessonService lessonService;

    @GetMapping("")
    public String getCourses(Model model, Authentication authentication){
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            User u = userService.findEmail(authentication.getName());
            model.addAttribute("user",u);
        }
        List<Object[]> listCou = service.getListCou();
        List<CourseUserCategoryJoin> list = new ArrayList<>();
        List<String> experts = new ArrayList<>();
        String[] expert;
        for (Object[] row : listCou) {
            experts = service.findCouExpertByCouID((int) row[0]);
            expert = new String[experts.size()];
            for (int i = 0; i < experts.size(); i++) {
                expert[i] = experts.get(i);
            }
            list.add(new CourseUserCategoryJoin((int) row[0], (String) row[1], (String) row[2], (String) row[3], expert, (String) row[4]));
        }
        model.addAttribute("courses", list);
        return "course";
    }

    @PostMapping("/material")
    public String getLessonByCourseID(Model model, @RequestParam("CourseID") Integer CourseID){
        List<Lesson> lessons = lessonService.getLessonByCourseID(CourseID);
        List<Lesson> randomLessons = getRandomLessons(lessons, 3);
        model.addAttribute("lessons",lessons);
        model.addAttribute("random",randomLessons);
        return "materi";
    }

    private List<Lesson> getRandomLessons(List<Lesson> lessons, int count) {
        // Nếu số lượng phần tử cần random lớn hơn hoặc bằng tổng số phần tử trong danh sách,
        // thì chỉ cần trả về danh sách ban đầu
        if (count >= lessons.size()) {
            return lessons;
        }

        // Xáo trộn danh sách lessons
        Collections.shuffle(lessons);

        // Trả về 3 phần tử đầu tiên trong danh sách đã xáo trộn
        return lessons.subList(0, count);
    }

}
