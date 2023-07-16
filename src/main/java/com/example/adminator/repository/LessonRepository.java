package com.example.adminator.repository;

import com.example.adminator.model.Course;
import com.example.adminator.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {


    @Query(value ="SELECT l.LessonID,c.CourseID,l.Title,l.content,l.video, l.resource\n" +
            "FROM lesson l\n" +
            "JOIN course c ON c.CourseID = l.CourseID",nativeQuery = true )
    List<Lesson> getListLesson();
}
