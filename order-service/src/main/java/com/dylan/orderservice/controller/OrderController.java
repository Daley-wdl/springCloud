package com.dylan.orderservice.controller;

import com.dylan.orderservice.VO.User;
import com.dylan.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author wudelong
 * @Date 2021/3/29 15:12
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("list")
    public User list(String id) {
        return orderService.getUser(id);
    }

    @GetMapping("testTomcat")
    public String testTomcat(String name) {
        return "hello " + name;
    }
}
