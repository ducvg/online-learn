package com.example.adminator.repository;

import com.example.adminator.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {
    @Query(value = "select l.LessonID, l.Title, l.Content from ols.lesson l where l.CourseID = :CourseID \n" +
            "order by l.LessonID asc;",nativeQuery = true)
    List<Lesson> getLessonByCourseId(Integer CourseID);
}
