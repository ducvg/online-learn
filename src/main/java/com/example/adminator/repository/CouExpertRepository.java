package com.example.adminator.repository;

import com.example.adminator.model.CourseExpert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouExpertRepository extends JpaRepository<CourseExpert,Integer> {
    @Query(value ="SELECT * FROM courseexpert\n" +
            "JOIN course ON course.CourseID = courseexpert.CourseID",nativeQuery = true )
    List<CourseExpert> getListCourseExpert();

//    @Query(value = "SELECT courseexpert.CourseExpertID, course.CourseID, user.UserID FROM courseexpert ce" +
//            " JOIN course c ON c.CourseID = ce.CourseID" +
//            " JOIN user u ON u.UserID = ce.UserID", nativeQuery = true)
//    List<CourseExpert> getListCourseExpert();
//    phần này không hiểu sao bị lỗi
}
