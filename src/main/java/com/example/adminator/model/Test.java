package com.example.adminator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TestID;
    private int CourseID;
    private String Title;
    private String Duration;
    private String NumOfQuestion;
    private String Type;

    public Test() {
    }

    public Test(Integer testID, int courseID, String title, String duration, String numOfQuestion, String type) {
        TestID = testID;
        CourseID = courseID;
        Title = title;
        Duration = duration;
        NumOfQuestion = numOfQuestion;
        Type = type;
    }

    public Integer getTestID() {
        return TestID;
    }

    public void setTestID(Integer testID) {
        TestID = testID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getNumOfQuestion() {
        return NumOfQuestion;
    }

    public void setNumOfQuestion(String numOfQuestion) {
        NumOfQuestion = numOfQuestion;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Test{" +
                "TestID=" + TestID +
                ", CourseID=" + CourseID +
                ", Title='" + Title + '\'' +
                ", Duration='" + Duration + '\'' +
                ", NumOfQuestion='" + NumOfQuestion + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
