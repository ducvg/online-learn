package com.example.adminator.service;

import com.example.adminator.join.CourseRegistrationJoin;
import com.example.adminator.join.CourseUserCategoryJoin;
import com.example.adminator.model.Course;
import com.example.adminator.model.CourseExpert;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.CourseExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouServiceImp implements CouService{
    @Autowired
    private CouRepository couRepository;
    @Autowired private CourseExpertRepository courseExpertRepository;

    @Override
    public Course findCou(Integer id) {
        Optional<Course> c = couRepository.findById(id);
        if(c.isPresent()) return c.get();
        else return null;
    }

    @Override
    public int addCourse(Course course){
        couRepository.save(course);
        return couRepository.getInsertedCourseID();
    }

    @Override
    public List<Object[]> getListCou() {
        return couRepository.getListCou();
    }

    @Override
    public List<String> findCouExpertByCouID(int id) {return  couRepository.findCouExpertByCouID(id);}

    @Override
    public Course save(Course course) {
        return couRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return couRepository.save(course);
    }

    @Override
    public void delete(Course course) {
        List<CourseExpert> experts = courseExpertRepository.getExpertByCourse(course.getCourseID());
        for(CourseExpert ce : experts){
            courseExpertRepository.delete(ce);
        }
        couRepository.delete(course);
    }

    @Override
    public int countCourse(){return couRepository.countCourse();}

    @Override
    public List<Object[]> topRegisterdCourse(){return couRepository.topRegisteredCourse();};

    @Override
    public List<Object[]> leastRegisterdCourse(){return couRepository.leastRegisteredCourse();};
}
