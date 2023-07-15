package com.example.adminator.controller;
import com.example.adminator.model.Registration;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.RegistrationRepository;
import com.example.adminator.service.RegService;
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
    private RegistrationRepository RegistrationRepository;

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


    @GetMapping("/edit/{id}")
    public String editRegistration(@PathVariable("id") Integer id, Model model) {
        Registration Registration = RegistrationService.findReg(id);
        model.addAttribute("Registration", Registration);
        return "viewregistration";
    }

    @PostMapping("/update/{id}")
    public String updateRegistration(@PathVariable("id") Integer id, @ModelAttribute Registration Registration, Model model) {
        Registration existingRegistration = RegistrationService.findReg(id);
        existingRegistration.setCourseID(Registration.getCourseID());
        existingRegistration.setUserID(Registration.getUserID());
        existingRegistration.setRegistrationDate(Registration.getRegistrationDate());
        existingRegistration.setEndDate(Registration.getEndDate());
        //Status co can thiet ko ?
        existingRegistration.setStatus(Registration.getStatus());
        RegistrationService.save(existingRegistration);
        return "redirect:/viewregistration";
    }

    @GetMapping("/delete/{id}")
    public String deleteRegistration(@PathVariable("id") Integer id) {
        Registration Registration = RegistrationService.findReg(id);
        RegistrationService.delete(Registration);
        return "redirect:/viewregistration";
    }

}
