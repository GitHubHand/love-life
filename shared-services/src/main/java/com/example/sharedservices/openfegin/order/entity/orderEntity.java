package com.example.sharedservices.openfegin.order.entity;

import lombok.Data;

@Data
public class orderEntity {
    private String id;
    private String userId;
    private String orderName;
    private String orderPrice;
    private String orderNum;
}
