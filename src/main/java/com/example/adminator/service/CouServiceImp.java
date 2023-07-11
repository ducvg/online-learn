package com.example.adminator.service;

import com.example.adminator.model.Course;
import com.example.adminator.repository.CouRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouServiceImp implements CouService{
    @Autowired
    private CouRepository couRepository;

    @Override
    public Course findCou(Integer id) {
        Optional<Course> c = couRepository.findById(id);
        if(c.isPresent()) return c.get();
        else return null;
    }

    @Override
    public List<Course> getListCou() {
        return couRepository.findAll();
    }

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
        couRepository.delete(course);
    }
}
