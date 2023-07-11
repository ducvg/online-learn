package com.example.adminator.repository;

import com.example.adminator.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CouRepository extends JpaRepository<Course,Integer> {

    @Query(value ="select course.CourseID, course.Title, course.thumbnail, categories.Name\n" +
            " from ols.course\n" +
            " inner join ols.categories\n" +
            " on course.CategoryID = categories.CategoryID\n" +
            " where course.CourseID = :id;",nativeQuery = true )
    Course findCouByID(int id);

    @Query(value ="SELECT c.CourseID,c.Title,c.thumbnail, ct.CategoryID\n" +
            "FROM course c\n" +
            "JOIN categories ct ON c.CategoryID = ct.CategoryID",nativeQuery = true )
    List<Course> getListCou();

}
