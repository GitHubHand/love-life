package com.example.orderservice.service;

import com.example.orderservice.entity.orderEntity;

import java.util.List;

public interface orderService {

    List<orderEntity> listOrderAllInfo();

    List<orderEntity> listOrderInfoByUserId(String userId);
}
