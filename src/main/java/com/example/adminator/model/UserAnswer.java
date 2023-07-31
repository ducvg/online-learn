package com.example.adminator.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "useranswer")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserAnswer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserAnswerID")
    private Integer useranswerID;

    @Column(name = "ResultID")
    private Integer resultID;

    @Column(name = "QuestionID")
    private String questionID;

    @Column(name = "SelectedAnswer")
    private String selectedanswer;

    public UserAnswer(Integer useranswerID, Integer resultID, String questionID, String selectedanswer) {
        this.useranswerID = useranswerID;
        this.resultID = resultID;
        this.questionID = questionID;
        this.selectedanswer = selectedanswer;
    }
}
