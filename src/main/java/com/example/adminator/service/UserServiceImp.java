package com.example.adminator.service;

import com.example.adminator.model.User;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.UserRepository;
import org.hibernate.sql.results.internal.domain.CircularFetchImpl;
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
    public List<User> getAllExpert() {
        return userRepo.getAllExpert();
    }
    @Override
    public List<User> getAllCustomer() {
        return userRepo.findAll();
    }
    @Override
    public List<User> getListUser() {
        return userRepo.findAll();
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

    @Override
    public void banUser(User user) {
        if (user.isStatus()==true){
            user.setStatus(false);
        }
        userRepo.save(user);
    }

    @Override
    public void unbanUser(User user) {
        if (user.isStatus()==false){
            user.setStatus(true);
        }
        userRepo.save(user);
    }
}
