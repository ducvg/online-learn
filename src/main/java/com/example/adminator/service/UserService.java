package com.example.adminator.service;

import com.example.adminator.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllExpert();
    public List<User> getAllCustomer();
    public User findUser(Integer id);

    public List<User> getListUser();

    public User add(User user);

    public User update(User user);

    public void delete(User user);

    public void banUser(User user);

    public void unbanUser(User user);


}
