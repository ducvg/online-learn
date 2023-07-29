package com.example.adminator.controller;
import com.example.adminator.repository.RegistrationRepository;
import com.example.adminator.service.CouService;
import com.example.adminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/registration")
public class RegistrationController {
    @Autowired
    private com.example.adminator.service.RegistrationService RegistrationService;
    @Autowired
    private RegistrationRepository repo;
    @Autowired
    private UserService userService;
    @Autowired
    private CouService couService;


    //Đang chưa làm đc cái đến đc web, show cái registration theo userID
    //SQL Query làm r đấy nhưng chưa bt triển khai nnao
    //cái hàm dưới này đang chua bt làm nnao cho chuẩn


}
