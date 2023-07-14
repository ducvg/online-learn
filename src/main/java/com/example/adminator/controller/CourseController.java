package com.example.adminator.controller;

import com.example.adminator.Join.CourseUserCategoryJoin;
import com.example.adminator.model.Category;
import com.example.adminator.model.Course;
import com.example.adminator.model.CourseExpert;
import com.example.adminator.model.User;
import com.example.adminator.repository.CategoryRepository;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.service.CategoryService;
import com.example.adminator.service.CouService;
import com.example.adminator.service.ExpertService;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CouService couService;
    @Autowired
    private ExpertService expertService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getAllCou(Model model) {
        List<Object[]> listCou = couService.getListCou();
        List<CourseUserCategoryJoin> list = new ArrayList<>();
        List<String> experts = new ArrayList<>();
        String[] expert;
        for (Object[] row : listCou) {
            experts = couService.findCouExpertByCouID((int) row[0]);
            expert = new String[experts.size()];
            for (int i = 0; i < experts.size(); i++) {
                expert[i] = experts.get(i);
            }
            list.add(new CourseUserCategoryJoin((int) row[0], (String) row[1], (String) row[2], (String) row[3], expert, (String) row[4]));
        }
        model.addAttribute("courses", list);
        return "courseList";
    }

    @GetMapping("/add")
    public String addCouForm(Model model) {
        List<User> expertList = userService.getAllExpert();
        List<Category> categoryList = categoryService.getCategories();
        model.addAttribute("experts", expertList);
        model.addAttribute("cates", categoryList);
        return "addcourse";
    }

    @PostMapping("/add")
    public String addCouSubmit(@RequestParam("Title") String title, @RequestParam("Thumbnail") String thumbnail,
                               @RequestParam("Description") String desc, @RequestParam(value = "expert") int[] expID, @RequestParam("category") int cateID) {
//        System.out.println("hehhhhho: "+expID[0]+"..."+expID[1]+", "+cateID);
        Course newCourse = new Course(title, desc, thumbnail, cateID);
        int courseid = couService.addCourse(newCourse);
        for (int id : expID) {
            expertService.save(new CourseExpert(courseid, id));
        }
        return "redirect:/course/list";
    }

    @GetMapping("/update/{id}")
    public String editCouForm(@PathVariable("id") Integer id, Model model) {
        List<User> expertList = userService.getAllExpert();
        List<Category> categoryList = categoryService.getCategories();
        model.addAttribute("experts", expertList);
        model.addAttribute("cates", categoryList);
        Course course = couService.findCou(id);
        List<CourseExpert> ceList = expertService.getExpertByCourse(id);
        model.addAttribute("cexpert", ceList);
        model.addAttribute("course", course);
        return "editcourse";
    }

    @PostMapping("/update/{id}")
    public String updateCou(@PathVariable("id") Integer id, @RequestParam("Title") String title, @RequestParam("Thumbnail") String thumbnail,
                            @RequestParam("Description") String desc, @RequestParam(value = "expert", required = false, defaultValue="") int[] expID, @RequestParam("category") int cateID, Model model) {
        Course existingCou = couService.findCou(id);
        existingCou.setTitle(title);
        existingCou.setThumbnail(thumbnail);
        existingCou.setDescription(desc);

        expertService.ClearCourseExpertByCourseID(id);
        for (int uid : expID) {
            expertService.save(new CourseExpert(id, uid));
        }

        existingCou.setCategoryID(cateID);
        couService.save(existingCou);
        return "redirect:/course/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCou(@PathVariable("id") Integer id) {
        Course course = couService.findCou(id);
        couService.delete(course);
        return "redirect:/course/list";
    }

}
