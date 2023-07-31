package com.example.adminator.repository;

import com.example.adminator.model.Test;
import com.example.adminator.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    @Query(value = "select * from ols.test t\n" +
            "inner join ols.course c on t.CourseID = c.CourseID \n" +
            "where c.CourseID = :id",nativeQuery = true)
    List<Object[]> getTestByCourseId(Integer id);
}
