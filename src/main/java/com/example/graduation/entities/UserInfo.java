package com.example.graduation.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="users", schema="public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserInfo {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private Long id;
    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="easy_level")
    private Integer infoEasy;

    @Column(name="medium_level")
    private Integer infoMedium;

    @Column(name="hard_level")
    private Integer infoHard;

    @Column(name="boss_level")
    private boolean bossLevel;

    @Column(name="record_boss")
    private Integer bossMax;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher")
    private Teacher teacher;

}
