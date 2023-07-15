package com.example.adminator.repository;

import com.example.adminator.model.Course;
import com.example.adminator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface UserRepository extends JpaRepository<User,Integer > {
    @Query(value ="select * from user where role = 'Customer'",nativeQuery = true )
    List<User> getAllCustomer();
}
