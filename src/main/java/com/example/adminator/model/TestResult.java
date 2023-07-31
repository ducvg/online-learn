package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "testresult")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestResult implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResultID")
    private Integer resultID;

    @Column(name = "TestID")
    private Integer testID;

    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "Score")
    private Integer score;

    @Column(name = "TestDate")
    private String testdate;

}
