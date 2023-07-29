package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courseexpert")
@Getter
@Setter
public class CourseExpert{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseExpertID")
    private int couExpertID;

    @Column(name = "CourseID")
    private int courseID;

    @Column(name = "UserID")
    private int userID;

    public CourseExpert(int courseID, int userID) {
        this.courseID = courseID;
        this.userID = userID;
    }

    public CourseExpert() {
    }
}
