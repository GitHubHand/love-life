package com.example.sharedservices.openfegin.order;

import com.example.sharedservices.openfegin.order.entity.orderEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderOpenfigApi {
    @GetMapping("/order/listOrderInfoByUserId/{userId}")
    List<orderEntity> listOrderInfoByUserId(@PathVariable("userId") String userId);
}
