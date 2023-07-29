package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.Serializable;

@Entity
@Table(name = "lesson")
@Getter
@Setter
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LessonID")
    private int lessonID;

    @Column(name = "CourseID")
    private int courseID;

    @Column(name = "Title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "video")
    private String video;

    @Column(name = "resource")
    private String resource;

    public Lesson(int courseID, String title, String content, String video, String resource) {
        this.courseID = courseID;
        this.title = title;
        this.content = content;
        this.video = video;
        this.resource = resource;
    }
    public Lesson() {

    }
}
