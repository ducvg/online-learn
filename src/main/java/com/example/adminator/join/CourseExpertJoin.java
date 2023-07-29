package com.example.adminator.Join;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CourseExpertJoin {
    private String Name;
    private String Email;
    private String Title;
    private String Status;
    private int nigga;

    public CourseExpertJoin(String name, String email, String title, String status) {
        Name = name;
        Email = email;
        Title = title;
        Status = status;
    }
}
