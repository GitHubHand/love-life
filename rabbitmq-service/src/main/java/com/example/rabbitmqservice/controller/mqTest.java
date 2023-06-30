package com.example.rabbitmqservice.controller;

import com.rabbitmq.client.*;
import net.minidev.json.writer.ArraysMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Controller
@ResponseBody
@RequestMapping("/mq")
public class mqTest {
    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String send() {
        for (int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("test001_queue1", "hello world"+i);
        }
        return "success";
    }
    public String send2() {
        rabbitTemplate.convertAndSend("test001_queue1", "hello world");
        return "success";
    }

    @RequestMapping("/send3")
    public String send3() {
        for (int i=0;i<10;i++) {
            rabbitTemplate.convertAndSend("test001.topic", "chain.news", "hello world");
        }
        return "success";
    }
    @RequestMapping("/send4")
    public String send4() {
        Map<Object, Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        rabbitTemplate.convertAndSend("test001_queue5", map);
        return "success";
    }
}
