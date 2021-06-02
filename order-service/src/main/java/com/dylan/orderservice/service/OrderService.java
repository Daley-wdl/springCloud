package com.dylan.orderservice.service;

import com.dylan.orderservice.VO.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
public class OrderService {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    private static final String userService = "userService";


    @HystrixCommand
    public User getUser(String id) {
        discoveryClient.getServices().forEach(service -> System.out.println(service));
        List<ServiceInstance> instances = discoveryClient.getInstances(userService);

        String userserviceUri = String.format("%s/user/%s", "http://userService"
                .toString(), "get/" + id);
        ResponseEntity<User> responseEntity = restTemplate.exchange(userserviceUri, HttpMethod.POST, null, User.class, id);
        return responseEntity.getBody();
    }
}
