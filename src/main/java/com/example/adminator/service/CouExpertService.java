package com.example.adminator.service;
import com.example.adminator.model.CourseExpert;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CouExpertService {
    public List<CourseExpert> getListCourseExpert();
}
