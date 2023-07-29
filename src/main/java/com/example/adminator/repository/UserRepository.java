package com.example.adminator.repository;

import com.example.adminator.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer > {
    @Query(value ="select * from user where role = 'ROLE_Expert'",nativeQuery = true )
    List<User> getAllExpert();

    @Query(value = "SELECT u.UserID, u.Name, u.Email, u.Password, u.Role,u.Status\n" +
            " FROM ols.user u\n" +
            "order by u.Role", nativeQuery = true)
    List<User> getListUser();

    @Query(value = "SELECT distinct u.Role From ols.user u",nativeQuery = true)
    List<String> roleOfUser();

    @Query(value = "Select * from user where email = :email ", nativeQuery = true)
    User findEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.status = :status WHERE u.userID = :userID")
    void updateUserStatus( @Param("status") boolean status, @Param("userID") int userID);


}
