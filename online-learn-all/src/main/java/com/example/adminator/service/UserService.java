package com.example.adminator.service;

import com.example.adminator.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllExpert();

    public User findUser(Integer id);
    public User findEmail(String email);

    public List<User> getListUser();

    public List<String> listRole();

    public User add(User user);

    public User update(User user);
    public User changePassword(User user);
    public void delete(User user);


}
