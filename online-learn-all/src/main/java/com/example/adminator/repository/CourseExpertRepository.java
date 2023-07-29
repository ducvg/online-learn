package com.example.adminator.repository;

import com.example.adminator.model.CourseExpert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseExpertRepository extends JpaRepository<CourseExpert,Integer> {
    @Query(value = "INSERT INTO CourseExpert (CourseID, UserID)\n" +
            "VALUES ( :courseid , :userid )", nativeQuery = true)
    void AssignExpert(int courseid, int userid);

    @Query(value = "SELECT * FROM courseexpert where CourseID = :courseID and UserID = :userID ", nativeQuery = true)
    CourseExpert getCourseExpertBy2ID(int courseID, int userID);

    @Query(value = "SELECT u.Name, u.Email, c.Title, u.Status " +
            "FROM courseexpert ce " +
            "JOIN course c ON c.CourseID = ce.CourseID " +
            "JOIN user u ON u.UserID = ce.UserID", nativeQuery = true)
    List<Object[]> getListExpert();

    @Query(value = "SELECT c.CourseID, c.Title, c.Description FROM course c\n" +
            "JOIN courseexpert ce ON c.CourseID = ce.CourseID \n" +
            "JOIN user u ON u.UserID = ce.UserID\n" +
            "where u.UserID =:id", nativeQuery = true)
    List<Object[]> getCourseExpertbyUserID(int id);


    @Query(value = "SELECT * FROM courseexpert where CourseID = :id ", nativeQuery = true)
    List<CourseExpert> getExpertByCourse(int id);
}
