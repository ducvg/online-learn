package com.example.adminator.repository;

import com.example.adminator.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {
    @Query(value = "select l.LessonID, c.CourseID, l.Title, l.Content,l.Video,l.Resource\n" +
            "from ols.lesson l \n" +
            "inner join ols.course c on l.CourseID = c.CourseID\n" +
            "where c.CourseID = :id\n" +
            "order by l.LessonID asc;",nativeQuery = true)
    List<Object[]> getLessonByCourseId(Integer id);
    @Query(value ="SELECT LAST_INSERT_ID()",nativeQuery = true )
    int getInsertedLessonID();

    @Query(value ="select course.CourseID\n" +
            " from ols.lesson\n" +
            " inner join ols.course\n" +
            " on course.CourseID = lesson.CourseID\n" +
            " where lesson.LessonID = :id",nativeQuery = true )
    List<String> findCourseByCourseID(int id);
    @Query(value ="select l.LessonID from Lesson ",nativeQuery = true )
    List<String> findLesson(int id);



    @Query(value ="SELECT distinct\n" +
            " l.LessonID,\n" +
            "c.CourseID,\n" +
            " l.Title,\n" +
            "l.Content,\n" +
            " l.Video,\n" +
            "l.Resource\n" +
            "FROM\n" +
            "ols.lesson l\n" +
            "left JOIN Course c ON l.LessonID = c.CourseID\n" +
            "ORDER BY\n" +
            " l.LessonID ASC;",nativeQuery = true )
    List<Object[]> getListLesson();
}

