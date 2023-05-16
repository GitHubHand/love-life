package com.example.sharedservices.openfegin.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service")
public interface UserOpenfeginApi {
    @GetMapping("/test/getDate")
    String getDate();
}
