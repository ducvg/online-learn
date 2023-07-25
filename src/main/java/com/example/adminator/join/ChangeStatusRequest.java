package com.example.adminator.join;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 public class ChangeStatusRequest {
    private int userID;
    private boolean status;

}
