package com.example.adminator.service;

import com.example.adminator.model.User;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.repository.UserRepository;
import org.hibernate.sql.results.internal.domain.CircularFetchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findUser(Integer id) {
        Optional<User> u = userRepo.findById(id);
        if (u.isPresent()) return u.get();
        else return null;
    }

    @Override
    public User findEmail(String email) {
        return userRepo.findEmail(email);
    }

    @Override
    public List<User> getAllExpert() {
        return userRepo.getAllExpert();
    }

    @Override
    public List<User> getListUser() {
        return userRepo.getListUser();
    }

    @Override
    public List<String> listRole() {
        return userRepo.roleOfUser();
    }

    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_"+user.getRole());
        return userRepo.save(user);
    }

    @Override
    public User changePassword(User u){
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return userRepo.save(u);
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
