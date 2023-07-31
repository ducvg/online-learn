package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "test")
@Getter
@Setter
public class Test implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TestID")
    private int testID;

    @Column(name = "CourseID")
    private int courseID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Duration")
    private int duration;

    @Column(name = "Type")
    private String type;

    public Test(int testID, int courseID, String title, int duration, String type) {
        this.testID = testID;
        this.courseID = courseID;
        this.title = title;
        this.duration = duration;
        this.type = type;
    }
}
