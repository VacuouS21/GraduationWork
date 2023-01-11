package com.example.graduation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Integer infoEasy;
    private Integer infoMedium;
    private Integer infoHard;
    private boolean bossLevel;
    private Integer bossMax;
    private Long teacher;
}
