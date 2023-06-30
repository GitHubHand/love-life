package com.example.orderservice.service.imp;

import com.example.orderservice.dao.orderDao;
import com.example.orderservice.entity.orderEntity;
import com.example.orderservice.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderServiceImp implements orderService {

    @Autowired
    private orderDao orderDao;

    @Override
    public List<orderEntity> listOrderAllInfo(){
        return orderDao.listOrderAllInfo();
    }

    @Override
    public List<orderEntity> listOrderInfoByUserId(String userId) {
        return orderDao.listOrderInfoByUserId(userId);
    }
}
