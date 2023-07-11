package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "course")
@Getter
@Setter

public class Course implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private Integer courseID;

    @Column(name = "Title")
    private String title;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "CategoryID")
    private Integer categoryID;
}
