package com.example.graduation.model;

import lombok.Data;

@Data
public class UserUpdate {
    private String username;
    private Integer infoEasy;
    private Integer infoMedium;
    private Integer infoHard;
    private boolean bossLevel;
    private Integer bossMax;
    private String teacher;
}
