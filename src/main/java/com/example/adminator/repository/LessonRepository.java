package com.example.adminator.repository;

import com.example.adminator.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {
    @Query(value = "select distinct c.CourseID, l.LessonID, l.Title, l.Content,l.Video,l.Resource\n" +
            "from ols.lesson l \n" +
            "inner join ols.course c on l.CourseID = c.CourseID\n" +
            "where c.CourseID = :id\n" +
            "order by l.LessonID asc;",nativeQuery = true)
    List<Lesson> getLessonByCourseId(Integer id);
}
