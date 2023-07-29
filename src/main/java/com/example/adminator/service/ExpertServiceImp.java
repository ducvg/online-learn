package com.example.adminator.service;
import com.example.adminator.model.CourseExpert;
import com.example.adminator.repository.CourseExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImp implements ExpertService {
    @Autowired
    private CourseExpertRepository courseExpertRepository;

    @Override
    public List<Object[]> getListExpert() {
        return courseExpertRepository.getListExpert();
    }

    @Override
    public CourseExpert save(CourseExpert courseExpert){return courseExpertRepository.save(courseExpert);}

    @Override
    public CourseExpert getCourseExpertBy2ID(int courseID, int userID){return courseExpertRepository.getCourseExpertBy2ID(courseID,userID);}

    @Override
    public void delete(CourseExpert courseExpert){courseExpertRepository.delete(courseExpert);}

    @Override
    public void ClearCourseExpertByCourseID(int id){
        List<CourseExpert> elist = getExpertByCourse(id);
        for(CourseExpert ce : elist){
            delete(ce);
        }
    }

    @Override
    public List<CourseExpert> getExpertByCourse(int id){
        return courseExpertRepository.getExpertByCourse(id);
    }
}
