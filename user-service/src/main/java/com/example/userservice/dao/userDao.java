package com.example.userservice.dao;

import com.example.userservice.entity.userEntity;
import com.example.userservice.entity.userOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface userDao {
    List<userEntity> listUserAllInfo();

    List<userOrderEntity> listUserAndOrederInfo(@Param("uid") String uid);
}
