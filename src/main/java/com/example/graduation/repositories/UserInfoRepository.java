package com.example.graduation.repositories;

import com.example.graduation.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
 List<UserInfo> findAllByTeacherName(String name);
}
