package com.example.adminator.service;

import com.example.adminator.model.User;
import com.example.adminator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public User findUser(Integer id) {
        Optional<User> u = userRepo.findById(id);
        if (u.isPresent()) return u.get();
        else return null;
    }

    @Override
    public List<User> getAllCustomer() {
        return userRepo.findAll();
    }
    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
    @Override
    public User add(User user) {
        return userRepo.save(user);
    }
    @Override
    public User update(User user) {
        return userRepo.save(user);
    }
    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }
}
