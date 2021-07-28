package com.dylan.accountservicenacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountServiceNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceNacosApplication.class, args);
    }

}
