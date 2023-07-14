package com.example.adminator.service;

import com.example.adminator.model.Category;
import com.example.adminator.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories(){
        return categoryRepository.getCategories();
    }
}
