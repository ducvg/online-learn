package com.example.adminator.controller;

import com.example.adminator.Join.CourseUserCategoryJoin;
import com.example.adminator.model.User;
import com.example.adminator.service.CouService;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CoursesController {
    @Autowired private CouService service;
    @Autowired private UserService userService;

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



}
