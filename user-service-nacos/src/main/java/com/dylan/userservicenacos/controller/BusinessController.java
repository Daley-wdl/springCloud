package com.dylan.userservicenacos.controller;

import com.dylan.userservicenacos.middleware.BusinessService;
import com.dylan.userservicenacos.middleware.LocalBusinessService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wudelong
 * @Date 2021/6/8 20:24
 */
@RestController
@RequestMapping("business")
@AllArgsConstructor
public class BusinessController {

    private final BusinessService businessService;

    private final LocalBusinessService localBusinessService;

    @GetMapping("purchase")
    public boolean purchase(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "productId") Integer productId) {

        return businessService.purchase(userId, productId);
    }

    @GetMapping("tccTransaction")
    public boolean tccTransaction(@RequestParam(value = "id") Integer id) {
        return businessService.tccTransaction(id);
    }

    @GetMapping("localPurchase")
    public boolean localPurchase(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "productId") Integer productId) {

        return localBusinessService.localPurchase(userId, productId);
    }

    @GetMapping("healthGet")
    public int healthGet() {
        return businessService.healthGet();
    }
}
