package com.example.adminator.service;

import com.example.adminator.model.CourseExpert;
import com.example.adminator.model.Registration;
import com.example.adminator.model.TestResult;
import com.example.adminator.model.User;
import com.example.adminator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepo;
    @Autowired private RegistrationRepository registrationRepo;
    @Autowired private CourseExpertRepository courseExpertRepository;
    @Autowired private TestResultRepository testResultRepository;


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
        List<Registration> registrations = registrationRepo.getRegByUserID(user.getUserID());
        List<TestResult> results = testResultRepository.getUserTestResult(user.getUserID());
        List<CourseExpert> experts = courseExpertRepository.getCourseExpertByUser(user.getUserID());
        for (Registration r : registrations){registrationRepo.delete(r);}
        for (TestResult tr : results) {testResultRepository.delete(tr);}
        for (CourseExpert ce : experts) {courseExpertRepository.delete(ce);}
        userRepo.delete(user);
    }

    @Override
    public int countUser(){return userRepo.countUser();}

    @Override
    public int countActiveUser(){return userRepo.countActiveUser();}

    @Override
    public int countExpert(){return userRepo.countExpert();}
}
