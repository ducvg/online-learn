package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "courseexpert")
@Getter
@Setter
public class CouExpert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseExpertID")
    private int couExId;

    @Column(name = "CourseID")
    private int courseId;

    @Column(name = "UserID")
    private int userId;
}
