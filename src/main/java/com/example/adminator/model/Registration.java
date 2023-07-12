package com.example.adminator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RegistrationID;
    private int CourseID;
    private int UserID;
    private String RegistrationDate;
    private String StartDate;
    private String EndDate;
    private String Status;

    public Registration(Integer registrationID, int courseID, int userID, String registrationDate, String startDate, String endDate, String status) {
        RegistrationID = registrationID;
        CourseID = courseID;
        UserID = userID;
        RegistrationDate = registrationDate;
        StartDate = startDate;
        EndDate = endDate;
        Status = status;
    }

    public Registration() {

    }

    public Integer getRegistrationID() {
        return RegistrationID;
    }

    public void setRegistrationID(Integer registrationID) {
        RegistrationID = registrationID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "RegistrationID=" + RegistrationID +
                ", CourseID=" + CourseID +
                ", UserID=" + UserID +
                ", RegistrationDate='" + RegistrationDate + '\'' +
                ", StartDate='" + StartDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
