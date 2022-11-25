package com.example.graduation.repositories;

import com.example.graduation.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    Optional<UserInfo> findByGameId(Long gameID);
    List<UserInfo> findAllByIdTeacher(String teacherId);
}
