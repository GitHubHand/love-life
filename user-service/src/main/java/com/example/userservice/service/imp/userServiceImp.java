package com.example.userservice.service.imp;

import com.example.sharedservices.openfegin.order.OrderOpenfigApi;
import com.example.sharedservices.openfegin.order.entity.orderEntity;
import com.example.userservice.dao.userDao;
import com.example.userservice.entity.userEntity;
import com.example.userservice.entity.userOrderEntity;
import com.example.userservice.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImp implements userService {
    @Autowired
    private userDao userDao;
    @Autowired
    private OrderOpenfigApi orderOpenfigApi;

    @Value("${spring.application.name}")
    private String serviceName;

    @Override
    public List<userEntity> listUserAllInfo() {
        return userDao.listUserAllInfo();
    }

    @Override
    public List<userOrderEntity> listUserAndOrederInfo(String uid) {
        List<userOrderEntity> userOrderList = userDao.listUserAndOrederInfo(uid);
        userOrderList.stream().forEach(user -> {
            List<orderEntity> orderEntities = orderOpenfigApi.listOrderInfoByUserId(user.getId());
            user.setListOrderInfo(orderEntities);
        });
        return userOrderList;
    }
}
