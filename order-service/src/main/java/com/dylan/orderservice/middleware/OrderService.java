package com.dylan.orderservice.middleware;

import cn.hutool.json.JSONUtil;
import com.dylan.order.entity.Orders;
import com.dylan.orderservice.service.IOrderService;
import com.dylan.user.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author wudelong
 * @Date 2021/3/31 11:08
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrderService {
//    private DiscoveryClient discoveryClient;
//    private RestTemplate restTemplate;
//    private LoadBalancerClient loadBalancerClient;
    private static final String userService = "userService";

    private final IOrderService orderService;


    /*@HystrixCommand
    public User getUser(String id) {
        discoveryClient.getServices().forEach(service -> System.out.println(service));
        List<ServiceInstance> instances = discoveryClient.getInstances(userService);

        ServiceInstance serviceInstance = loadBalancerClient.choose(userService);
//        serviceInstance.getHost() + ":" + serviceInstance.getPort()

        // 因为 restTemplate 已经集成了负载均衡的功能，所以这里需要用服务名，否则用ip+端口调用
        User response = restTemplate.getForObject("http://" + serviceInstance.getServiceId() + "/user/get/" + id, User.class);
        System.out.println(JSONUtil.toJsonStr(response));


        String userserviceUri = String.format("%s/user/%s", "http://userService"
                .toString(), "get/" + id);
        ResponseEntity<User> responseEntity = restTemplate.exchange(userserviceUri, HttpMethod.GET, null, User.class, id);
        return responseEntity.getBody();
    }*/

    /**
     * 创建订单
     *
     * @param orders
     * @return
     */
    public boolean create(Orders orders) {
        return orderService.save(orders);
    }
}
