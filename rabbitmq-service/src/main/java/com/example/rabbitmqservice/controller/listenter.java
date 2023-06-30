package com.example.rabbitmqservice.controller;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class listenter {

     @RabbitListener(queues = "test001_queue1")
     public void process1(String msg) {
         System.out.println("Spring中process1接收到的消息：" + msg);
    }
    @RabbitListener(queues = "test001_queue1")
    public void process2(String msg) throws InterruptedException {
         Thread.sleep(1000);
        System.err.println("Spring中process2接收到的消息：" + msg);
    }
    @RabbitListener(queues = "test001_queue1")
    public void process3(String msg) throws InterruptedException {
        Thread.sleep(1000);
        System.err.println("Spring中process3接收到的消息：" + msg);
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue("test001.queue1"),exchange = @Exchange(name="test001.dircet",type = ExchangeTypes.DIRECT),key = {"key1","key2"}) )
    public void process4(String msg) {
        System.err.println("Spring中process4接收到的消息：" + msg);
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue("test001_queue2"),exchange = @Exchange(name="test001.dircet",type = ExchangeTypes.DIRECT),key = {"key2"}) )
    public void process5(String msg) {
        System.out.println("Spring中process5接收到的消息：" + msg);
    }
    @RabbitListener(queues=("test001_queue5"))
    public void process6(Map<Object, Object> msg) {
        System.out.println("Spring中process6接收到的消息：" + msg);
    }
}
