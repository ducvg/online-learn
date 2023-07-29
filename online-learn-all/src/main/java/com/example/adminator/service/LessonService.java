package com.example.adminator.service;
import com.example.adminator.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LessonService {
    public List<Object[]> getLessonByCourseID(Integer id);
    Lesson findLesson(Integer id);

    public List<Object[]> getListLesson();


    List<String> findCourseByCourseID(int id);

    public int addLesson(Lesson lesson);

    public Lesson save(Lesson lesson);
    public Lesson update(Lesson lesson);
    public void delete(Lesson lesson);

}
