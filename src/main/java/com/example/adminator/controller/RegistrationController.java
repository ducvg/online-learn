package com.example.adminator.controller;
import com.example.adminator.model.Category;
import com.example.adminator.model.Course;
import com.example.adminator.model.Registration;
import com.example.adminator.model.User;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.RegistrationRepository;
import com.example.adminator.service.CouService;
import com.example.adminator.service.RegService;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/managerReg")
public class RegistrationController {
    @Autowired
    private RegService RegistrationService;
    @Autowired
    private RegistrationRepository repo;
    @Autowired
    private UserService userService;
    @Autowired
    private CouService couService;


    //Đang chưa làm đc cái đến đc web, show cái registration theo userID
    //SQL Query làm r đấy nhưng chưa bt triển khai nnao
    //cái hàm dưới này đang chua bt làm nnao cho chuẩn

//    @GetMapping
//    public String getAll(Model model){
//        List<Registration> list= repo.findByRegistrationByUserID(UserID);
//        model.addAttribute("regs",list);
//        return "viewregistration";
//    }
//    @GetMapping
//    public String deletereg(@PathVariable("id") Integer id) {
//        Registration Registration = regs.findReg(id);
//        regs.delete(Registration);
//        return "redirect:/viewregistration";
//    }


    @GetMapping("/update/{id}")
    public String editReg(@PathVariable("id") Integer id, Model model) {
        List<User> customerList = userService.getAllCustomer();
        model.addAttribute("customers", customerList);
        Course course = couService.findCou(id);
        List<Registration> regList = RegService.getRegByUserID(id);
        model.addAttribute("reglist", regList);
        model.addAttribute("course", course);
        return "viewregistration";
    }

    @PostMapping("/update/{id}")
    public String updateReg(@PathVariable("id") Integer id, @RequestParam("CourseID") int courseID, @RequestParam("UserID") int userID,
                            @RequestParam("RegistrationDate") String regdate,@RequestParam("EndDate") String enddate, Model model) {
        Registration existingReg = RegService.findReg(id);
        existingReg.setCourseID(courseID);
        existingReg.setUserID(userID);
        existingReg.setRegistrationDate(regdate);
        existingReg.setEndDate(enddate);
        RegService.save(existingReg);
        return "redirect:/viewregistration";
    }
}
