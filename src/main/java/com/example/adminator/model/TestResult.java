package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "testresult")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResultID")
    private Integer ResultID;

    @Column(name = "TestID")
    private Integer TestID;

    @Column(name = "UserID")
    private String userID;

    @Column(name = "Score")
    private String registrationDate;

    @Column(name = "TestDate")
    private Date endDate;

}
