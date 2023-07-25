package com.example.adminator.repository;

import com.example.adminator.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value ="Select * from Categories",nativeQuery = true )
    List<Category> getCategories();
}
