package com.example.adminator.service;
import com.example.adminator.model.CourseExpert;
import com.example.adminator.model.User;
import com.example.adminator.repository.CouExpertRepository;
import com.example.adminator.repository.CouRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouExpertServiceImp implements CouExpertService{
    @Autowired
    private CouExpertRepository couExpertRepository;

    public List<CourseExpert> getListCourseExpert() {
        return couExpertRepository.getListCourseExpert();
    }
}
