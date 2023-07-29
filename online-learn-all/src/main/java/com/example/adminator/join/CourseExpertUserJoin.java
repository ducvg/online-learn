package com.example.adminator.join;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CourseExpertUserJoin {
    private int CourseID;
    private String Title;
    private String Description;

    public CourseExpertUserJoin(int courseID, String title, String description) {
        CourseID = courseID;
        Title = title;
        Description = description;
    }
}
