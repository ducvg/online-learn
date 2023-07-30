package com.example.adminator.repository;

import com.example.adminator.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult,Integer > {
    @Query(value = "SELECT * FROM testresult where UserID = :id ", nativeQuery = true)
    List<TestResult> getUserTestResult(@Param("id") int id);
}
