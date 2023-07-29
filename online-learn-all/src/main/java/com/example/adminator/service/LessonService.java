package com.example.adminator.service;
import com.example.adminator.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LessonService {
    Lesson findLesson(Integer id);

    public List<Lesson> getListLesson();

    public Lesson save(Lesson lesson);
    public Lesson update(Lesson lesson);
    public void delete(Lesson lesson);


}
