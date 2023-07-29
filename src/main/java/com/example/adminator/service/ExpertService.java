package com.example.adminator.service;

import com.example.adminator.model.CourseExpert;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ExpertService {
    public List<Object[]> getListExpert();
    public CourseExpert save(CourseExpert courseExpert);
    public CourseExpert getCourseExpertBy2ID(int courseID, int userID);
    public void delete(CourseExpert courseExpert);
    public void ClearCourseExpertByCourseID(int id);
    public List<CourseExpert> getExpertByCourse(int id);
}
