package com.example.adminator.controller;

import com.example.adminator.model.Course;
import com.example.adminator.repository.CouRepository;
import com.example.adminator.service.CouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CouService couService;
    @Autowired
    private CouRepository couRepo;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCou(@PathVariable Integer id){
        Course c = couService.findCou(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found with id: " + id);
        }
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public List<Course> getListCou(){
        return couService.getListCou();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCou(@RequestBody Course course){
        System.out.println();
        Course courseCreated = couRepo.save(course);
        if(courseCreated != null) {
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tạo mới Course không thành công!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCou(@PathVariable Integer id ,@RequestBody Course course){
        Course c = couRepo.findById(id).orElse(null);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found with id: " + id);
        }
        c.setTitle(course.getTitle());
        c.setThumbnail(course.getThumbnail());
        c.setCategoryID(course.getCategoryID());
        return ResponseEntity.ok(couService.update(c));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCou(@PathVariable Integer id){
        couService.delete(couService.findCou(id));
    }
}
