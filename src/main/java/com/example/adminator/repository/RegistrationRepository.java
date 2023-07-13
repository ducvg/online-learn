package com.example.adminator.repository;

import com.example.adminator.model.Course;
import com.example.adminator.model.Registration;
import com.example.adminator.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    @Query(value = "SELECT c.Title, r.StartDate,r.EndDate,r.Status\n" +
            "FROM ols.registration r\n" +
            "inner join ols.course c on c.CourseID = r.CourseID\n" +
            "inner join ols.user u ON u.UserID = r.userID\n" +
            "WHERE u.userID = ?;",nativeQuery = true )
    List<Registration> findByRegistrationByUserID(@Param("userID") Integer UserID);

    @Query(value ="SELECT *\n" +
            "FROM ols.registration r",nativeQuery = true )
    List<Registration> getListReg();
//    @Modifying
//    @Query("DELETE FROM Registration r WHERE r.RegistrationID = :RegistrationID")
//    void cancelByRegistrationID(@Param("RegistrationID") Integer RegistrationID);
//
//    @Modifying
//    @Query("")
//    void renewByRegistrationID(@Param("RegistrationID") Integer RegistrationID);
//
//    @Modifying
//    @Query("SELECT * FROM Course r")
//    List<Course> viewAllCourse();
//
//    @Modifying
//    @Query("SELECT * FROM Registration r WHERE r.UserID = :UserID")
//    List<Registration> viewAllRegistrationByUserID(@Param("UserID") Integer UserID);
//
//    @Modifying
//    @Query("SELECT * FROM Test t WHERE r.UserID = :UserID")
//    List<Test> userTakeTest(@Param("UserID") Integer UserID);
//
//    @Modifying
//    @Query("SELECT * FROM TestResult tr WHERE tr.UserID = :UserID")
//    List<Test> userViewResult(@Param("UserID") Integer UserID);


}
