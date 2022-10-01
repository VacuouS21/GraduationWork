package com.example.graduation.model;

import lombok.Data;

@Data
public class UserUpdateRequesModel {
    /////
    private Long gameId;
    private String userName;
    private Integer infoEasy;
    private Integer infoMedium;
    private Integer infoHard;

    private boolean bossLevel;
    private Integer bossMax;

    private String idTeacher;
}
