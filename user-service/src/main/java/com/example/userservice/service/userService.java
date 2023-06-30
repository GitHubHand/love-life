package com.example.userservice.service;

import com.example.userservice.entity.userEntity;
import com.example.userservice.entity.userOrderEntity;

import java.util.List;

public interface userService {
    List<userEntity> listUserAllInfo();

    List<userOrderEntity> listUserAndOrederInfo(String uid);
}
