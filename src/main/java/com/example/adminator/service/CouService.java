package com.example.adminator.service;

import com.example.adminator.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouService {
    Course findCou(Integer id);

    public List<Object[]> getListCou();
    public List<String> findCouExpertByCouID(int id);
    public int addCourse(Course course);

    public Course save(Course course);
    public Course update(Course course);
    public void delete(Course course);

}
