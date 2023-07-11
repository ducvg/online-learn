package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "courseexpert")
@Getter
@Setter
public class CourseExpert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseExpertID")
    private int couExpertID;

    @Column(name = "CourseID")
    private int courseID;

    @Column(name = "UserID")
    private int userID;
}
