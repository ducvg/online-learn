package com.example.adminator.service;

import com.example.adminator.model.Course;
import com.example.adminator.model.Registration;
import com.example.adminator.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegServiceImp implements RegService{
    @Autowired
    private RegistrationRepository RegRepository;

    @Override
    public Registration findReg(Integer id) {
        Optional<Registration> r = RegRepository.findById(id);
        if(r.isPresent()) return r.get();
        else return null;
    }

    @Override
    public List<Registration> getListReg() {
        return RegRepository.findAll();
    }
    @Override
    public Registration save(Registration Registration) {
        return RegRepository.save(Registration);
    }
    @Override
    public Registration update(Registration Registration) {
        return RegRepository.save(Registration);
    }
    @Override
    public void delete(Registration Registration) {
        RegRepository.delete(Registration);
    }
    @Override
    public List<Registration> getRegByUserID(int id){
        return RegRepository.getRegByUserID(id);
    }
    public void ClearRegistrationByUserID(int id){
        List<Registration> rlist = getRegByUserID(id);
        for(Registration r : rlist){
            delete(r);
        }
    }
}
