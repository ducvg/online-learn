package com.example.adminator.join;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestCourseJoin {

    private int TestID;
    private int CourseID;
    private String Title;
    private int Duration;
    private String Type;

    public TestCourseJoin(int testID, int courseID, String title, int duration, String type) {
        TestID = testID;
        CourseID = courseID;
        Title = title;
        Duration = duration;
        Type = type;
    }
}
