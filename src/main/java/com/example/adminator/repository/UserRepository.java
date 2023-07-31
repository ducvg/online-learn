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

    @Query(value = "SELECT *\n" +
            " FROM ols.user u\n" +
            "order by u.Role", nativeQuery = true)
    List<User> getListUser();

    @Query(value = "Select * from user where email = :email ", nativeQuery = true)
    User findEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.status = :status WHERE u.userID = :userID")
    void updateUserStatus( @Param("status") boolean status, @Param("userID") int userID);

    @Query(value = "SELECT COUNT(*) FROM User;",nativeQuery = true)
    int countUser();

    @Query(value = "SELECT COUNT(*) AS ActiveUsers FROM User WHERE Status = 1;",nativeQuery = true)
    int countActiveUser();

    @Query(value = "SELECT COUNT(*) AS TotalExperts FROM User WHERE Role = 'ROLE_Expert' and Status = 1;",nativeQuery = true)
    int countExpert();
}
