package com.example.orderservice.dao;

import com.example.orderservice.entity.orderEntity;

import java.util.List;

public interface orderDao {
    public List<orderEntity> listOrderAllInfo();

    List<orderEntity> listOrderInfoByUserId(String userId);
}
