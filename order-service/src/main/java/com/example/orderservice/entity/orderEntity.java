package com.example.orderservice.entity;

import lombok.Data;

@Data
public class orderEntity {
    private String id;
    private String userId;
    private String orderName;
    private String orderPrice;
    private String orderNum;
}
