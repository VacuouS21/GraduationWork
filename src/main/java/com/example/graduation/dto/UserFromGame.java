package com.example.graduation.dto;

import lombok.Data;

@Data
public class UserFromGame {
    private String id;

    private Long gameId;
    private String userName;
    private Integer infoEasy;
    private Integer infoMedium;
    private Integer infoHard;

    private boolean bossLevel;
    private Integer bossMax;

    private String nameOfTeacher;
}
