package com.example.adminator.service;

import com.example.adminator.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public interface CouService {
    Course findCou(Integer id);

    public List<Course> getListCou();

    public Course save(Course course);
    public Course update(Course course);
    public void delete(Course course);


}
