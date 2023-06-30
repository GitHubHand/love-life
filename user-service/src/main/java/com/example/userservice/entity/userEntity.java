package com.example.userservice.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

@Data
public class userEntity {
    private String id;
    private String username;
    private String address;
    private String email;
}
