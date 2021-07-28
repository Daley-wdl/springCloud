package com.dylan.userservice.Controller;

import com.dylan.userservice.middleware.LocalBusinessService;
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


    private final LocalBusinessService localBusinessService;

    @GetMapping("localPurchase")
    public boolean localPurchase(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "productId") Integer productId) {

        return localBusinessService.localPurchase(userId, productId);
    }

    @GetMapping("localPropagation")
    public boolean localPropagation(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "productId") Integer productId) {

        return localBusinessService.localPropagation(userId, productId);
    }
}
