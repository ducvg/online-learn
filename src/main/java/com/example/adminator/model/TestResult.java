package com.example.adminator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "testresult")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ResultID;
    private int TestID;
    private int UserID;
    private int Score;
    private String TestDate;

    public TestResult() {
    }

    public TestResult(Integer resultID, int testID, int userID, int score, String testDate) {
        ResultID = resultID;
        TestID = testID;
        UserID = userID;
        Score = score;
        TestDate = testDate;
    }

    public Integer getResultID() {
        return ResultID;
    }

    public void setResultID(Integer resultID) {
        ResultID = resultID;
    }

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int testID) {
        TestID = testID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getTestDate() {
        return TestDate;
    }

    public void setTestDate(String testDate) {
        TestDate = testDate;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "ResultID=" + ResultID +
                ", TestID=" + TestID +
                ", UserID=" + UserID +
                ", Score=" + Score +
                ", TestDate='" + TestDate + '\'' +
                '}';
    }
}
