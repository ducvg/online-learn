package com.example.adminator.service;
import com.example.adminator.model.Test;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.LessonRepository;
import com.example.adminator.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImp implements TestService{
    @Autowired
    private TestRepository testRepository;

    @Override
    public List<Object[]> getTestByCourseID(Integer id) {
        return testRepository.getTestByCourseId(id);
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }
    @Override
    public Test update(Test test) {
        return testRepository.save(test);
    }
    @Override
    public void delete(Test test) {
        testRepository.delete(test);
    }
}
