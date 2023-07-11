package com.example.adminator.repository;

import com.example.adminator.model.CouExpert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouExpRepo extends JpaRepository<CouExpert,Integer> {

}
