package com.dylan.zuulexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
//@EnableZuulServer
public class ZuulExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulExampleApplication.class, args);
    }

}
