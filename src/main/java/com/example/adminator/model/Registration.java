package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "course")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Registration implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RegistrationID")
    private Integer registrationID;

    @Column(name = "CourseID")
    private Integer courseID;

    @Column(name = "UserID")
    private String userID;

    @Column(name = "RegistrationDate")
    private String registrationDate;

    @Column(name = "EndDate")
    private String endDate;

    @Column(name = "Status")
    private Integer status;

}
