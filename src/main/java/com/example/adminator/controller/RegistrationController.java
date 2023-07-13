package com.example.adminator.controller;

import com.example.adminator.model.Registration;
import com.example.adminator.repository.RegistrationRepository;
import com.example.adminator.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RegistrationController {
    private RegistrationRepository repo;
    @Autowired
    private RegService regs;
    //Hàm de chạy postman
    public




    //cái hàm dưới này đang chua bt làm nnao cho chuẩn
    @GetMapping
    public String getAll(Model model){
        List<Registration> list= repo.findByRegistrationByUserID(UserID);
        model.addAttribute("regs",list);
        return "viewregistration";
    }
    @GetMapping
    public String deletereg(@PathVariable("id") Integer id) {
        Registration Registration = regs.findReg(id);
        regs.delete(Registration);
        return "redirect:/viewregistration";
    }
}