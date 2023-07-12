package com.example.adminator.repository;

import com.example.adminator.model.Course;
import com.example.adminator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
 public interface UserRepository extends JpaRepository<User,Integer > {
    @Query(value ="select course.CourseID, course.Title, course.thumbnail, categories.Name\n" +
            " from ols.course\n" +
            " inner join ols.categories\n" +
            " on course.CategoryID = categories.CategoryID\n" +
            " where course.CourseID = :id;",nativeQuery = true )
    Course findUserByID(int id);
}
