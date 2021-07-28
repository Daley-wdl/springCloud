package com.dylan.order.feign;

import com.dylan.order.entity.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "RemoteOrderService", value = "order-service")
public interface RemoteOrderService {

    @PostMapping("order/create")
    boolean create(@RequestBody Orders orders);
}
