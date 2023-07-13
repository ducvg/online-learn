package com.example.adminator.controller;

import com.example.adminator.model.Registration;
import com.example.adminator.repository.RegistrationRepository;
import com.example.adminator.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/{id}")
    public ResponseEntity<?> getReg(@PathVariable Integer id){
        Registration c = regs.findReg(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registration not found with id: " + id);
        }
        return ResponseEntity.ok(c);
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createReg(@RequestBody Registration registration){
        Registration u = regs.save(registration);
        if(u.getRegistrationDate()==""){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RegistrationDate not be empty!");
        }if(u.getStartDate()==""){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Start Date not be empty!");
        }if(u.getEndDate()==""){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("End Date not be empty!");
        }
        return ResponseEntity.ok(registration);
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateReg(@PathVariable Integer id, @RequestBody Registration registration) {
        Registration c = repo.findById(id).orElse(null);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registration  not found with id: " + id);
        }
        c.setCourseID(registration.getCourseID());
        c.setUserID(registration.getUserID());
        c.setRegistrationDate(registration.getRegistrationDate());
        c.setStartDate(registration.getStartDate());
        c.setEndDate(registration.getEndDate());
        if(c.getRegistrationDate()==""){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RegistrationDate not be empty!");
        }if(c.getStartDate()==""){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Start Date not be empty!");
        }if(c.getEndDate()==""){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("End Date not be empty!");
        }
        return ResponseEntity.ok(regs.update(c));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteReg(@PathVariable Integer id) {
        Registration registration = regs.findReg(id);
        if(registration==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("registration not found with id: " + id);
        }else {
            regs.delete(registration);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delete successfully");
        }
    }




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
}