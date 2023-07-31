package com.example.adminator.service;
import com.example.adminator.model.Test;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TestService {

    public List<Object[]> getTestByCourseID(Integer id);
    public Test save(Test test);
    public Test update(Test test);
    public void delete(Test test);

}
