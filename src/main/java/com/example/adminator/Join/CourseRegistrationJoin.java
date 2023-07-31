package com.example.adminator.join;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CourseRegistrationJoin {
    private int courseID;
    private String thumbnail;
    private String title;
    private String description;
    private int categoryID;

    private int registrationID;
    private int userID;
    private Date registrationDate;
    private Date endDate;
    private boolean status;

    private Long registeredCount;

    public CourseRegistrationJoin(String thumbnail, String title, Long registeredCount) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.registeredCount = registeredCount;
    }
}
