package com.example.orderservice.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="userService")
public interface OpenFeginService {
    @GetMapping("/test/getDate")
    String getDate();
}
