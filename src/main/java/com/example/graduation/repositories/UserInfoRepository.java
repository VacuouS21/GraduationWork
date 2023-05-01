package com.example.graduation.repositories;

import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
 List<UserInfo> findAllByTeacherName(String name);
 UserInfo findByName(String name);



}
