package com.example.adminator.service;
import com.example.adminator.model.Lesson;
import com.example.adminator.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImp implements LessonService{
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> getLessonByCourseID(Integer id) {
        return lessonRepository.getLessonByCourseId(id);
    }
}
