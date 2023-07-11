package com.example.adminator.controller;

import com.example.adminator.model.Course;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.service.CouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/managercourse")
public class CourseController {
    @Autowired
    private CourseService couService;
    @Autowired
    private CourseRepository couRepo;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String getAllCou(Model model){
        List<Course> listCou= couService.getListCou();

        model.addAttribute("courses",listCou);
        return "managercou";
    }

    @GetMapping("/add")
    public String addCouForm(Model model) {
        model.addAttribute("course", new Course());
        return "addcourse";
    }

    @PostMapping("/add")
    public String addCouSubmit(@ModelAttribute Course course) {
        couService.save(course);
        return "redirect:/managercourse";
    }


    @GetMapping("/edit/{id}")
    public String editCouForm(@PathVariable("id") Integer id, Model model) {
        Course course = couService.findCou(id);
        model.addAttribute("course", course);
        return "editcourse";
    }

    @PostMapping("/update/{id}")
    public String updateCou(@PathVariable("id") Integer id, @ModelAttribute Course course, Model model) {
        Course existingCou = couService.findCou(id);
        existingCou.setTitle(course.getTitle());
        existingCou.setThumbnail(course.getThumbnail());
        existingCou.setCategoryID(course.getCategoryID());
        couService.save(existingCou);
        return "redirect:/managercourse";
    }

    @GetMapping("/delete/{id}")
    public String deleteCou(@PathVariable("id") Integer id) {
        Course course = couService.findCou(id);
        couService.delete(course);
        return "redirect:/managercourse";
    }

}
