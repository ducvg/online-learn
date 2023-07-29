package com.example.adminator.repository;

import com.example.adminator.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouRepository extends JpaRepository<Course,Integer> {

    @Query(value ="SELECT LAST_INSERT_ID()",nativeQuery = true )
    int getInsertedCourseID();

    @Query(value ="select course.CourseID, course.Title, course.thumbnail, categories.Name\n" +
            " from ols.course\n" +
            " inner join ols.categories\n" +
            " on course.CategoryID = categories.CategoryID\n" +
            " where course.CourseID = :id",nativeQuery = true )
    Course findCouByID(int id);
    @Query(value ="SELECT distinct c.CourseID From ols.course c",nativeQuery = true )
    List<Integer> getAllCourseID();

    @Query(value ="SELECT\n" +
            "  u.Name\n" +
            "FROM\n" +
            "  CourseExpert ce\n" +
            "  JOIN User u ON ce.UserID = u.UserID\n" +
            "WHERE\n" +
            "  ce.CourseID = :id\n;",nativeQuery = true )
    List<String> findCouExpertByCouID(int id);

    @Query(value ="SELECT distinct\n" +
            "c.CourseID,\n" +
            " c.Title,\n" +
            "c.Thumbnail,\n" +
            " c.Description,\n" +
            "ca.Name\n" +
            "FROM\n" +
            "Course c\n" +
            "left JOIN CourseExpert ce ON c.CourseID = ce.CourseID\n" +
            "left JOIN Categories ca ON c.CategoryID = ca.CategoryID\n" +
            "ORDER BY\n" +
            "  c.CourseID ASC;",nativeQuery = true )
    List<Object[]> getListCou();


}
