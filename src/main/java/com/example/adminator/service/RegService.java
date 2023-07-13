package com.example.adminator.service;

import com.example.adminator.model.Course;
import com.example.adminator.model.Registration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegService {
    public Registration findReg(Integer id);
    public List<Registration> getListReg();
    public Registration add(Registration Registration);
    public Registration save(Registration Registration);
    public Registration update(Registration Registration);
    public void delete(Registration Registration);

}
