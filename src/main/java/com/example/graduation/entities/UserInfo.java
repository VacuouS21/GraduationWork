package com.example.graduation.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document
public class UserInfo {
    @Id
    private String id;

    private String userName;
    private Integer infoEasy;
    private Integer infoMedium;
    private Integer infoHard;

    private boolean bossLevel;
    private Integer bossMax;

    private String idTeacher;

    public UserInfo(String userName, Integer infoEasy, Integer infoMedium, Integer infoHard, boolean bossLevel, Integer bossMax, String idTeacher) {
        this.userName = userName;
        this.infoEasy = infoEasy;
        this.infoMedium = infoMedium;
        this.infoHard = infoHard;
        this.bossLevel = bossLevel;
        this.bossMax = bossMax;
        this.idTeacher = idTeacher;
    }
}
