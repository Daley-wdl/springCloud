package com.dylan.orderservice.controller;

import com.dylan.order.entity.Orders;
import com.dylan.orderservice.middleware.OrderService;
import com.dylan.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wudelong
 * @Date 2021/3/29 15:12
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public boolean create(@RequestBody Orders orders) {
        return orderService.create(orders);
    }


//    @PostMapping("list")
//    public User list(String id) {
//        return orderService.getUser(id);
//    }

    @GetMapping("testTomcat")
    public String testTomcat(String name) {
        return "hello " + name;
    }
}
