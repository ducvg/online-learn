package com.example.adminator.service;

import com.example.adminator.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User findUser(Integer id);
    public List<User> getListUser();
    public User save(User user);
    public User add(User user);
    public User update(User user);
    public void delete(User user);
}
