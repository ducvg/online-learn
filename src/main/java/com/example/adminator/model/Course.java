package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "course")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private Integer courseID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "CategoryID")
    private Integer categoryID;

    public Course(String title, String description, String thumbnail, Integer categoryID) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.categoryID = categoryID;
    }

}
