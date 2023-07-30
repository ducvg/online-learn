package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "registration")
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
    private Date registrationDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "Status")
    private Integer status;

}
