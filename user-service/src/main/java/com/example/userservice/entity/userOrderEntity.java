package com.example.userservice.entity;


import com.example.sharedservices.openfegin.order.entity.orderEntity;
import lombok.Data;

import java.util.List;

@Data
public class userOrderEntity {
    private String id;
    private String username;
    private String address;
    private String email;
    private List<orderEntity> listOrderInfo;
}
