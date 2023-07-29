package com.example.adminator.service;
import com.example.adminator.model.Lesson;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImp implements LessonService{
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private CouRepository couRepository;

    @Override
    public List<Object[]> getLessonByCourseID(Integer id) {
        return lessonRepository.getLessonByCourseId(id);
    }


    @Override
    public Lesson findLesson(Integer id) {
        Optional<Lesson> c = lessonRepository.findById(id);
        if(c.isPresent()) return c.get();
        else return null;
    }
    @Override
    public int addLesson(Lesson lesson){
        lessonRepository.save(lesson);
        return lessonRepository.getInsertedLessonID();
    }
    @Override
    public List<Object[]> getListLesson() {
        return lessonRepository.getListLesson();
    }

    @Override
    public List<String> findCourseByCourseID(int id) {return lessonRepository.findCourseByCourseID(id);}



    @Override
    public Lesson save(Lesson course) {
        return lessonRepository.save(course);
    }

    @Override
    public Lesson update(Lesson course) {
        return lessonRepository.save(course);
    }

    @Override
    public void delete(Lesson course) {
        lessonRepository.delete(course);
    }
}
