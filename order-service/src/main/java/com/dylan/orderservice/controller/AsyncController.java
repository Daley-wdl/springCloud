package com.dylan.orderservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * spring mvc 异步实现
 *
 * @author wudelong
 * @Date 2021/5/31 09:58
 */
@RestController
@RequestMapping("async")
@Slf4j
public class AsyncController {


    /**
     * 1 返回 callable 方式
     * @return
     */
    @GetMapping("/process")
    public Callable<String> asyncProcess(){

        log.info("tomcat thread: {}, timestamp: {}", Thread.currentThread().getName(), System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("async thread: {}, timestamp: {}", Thread.currentThread().getName(), System.currentTimeMillis());
                Thread.sleep(3000l);
                log.info("async thread: {}, timestamp: {}", Thread.currentThread().getName(), System.currentTimeMillis());
                return "hello world";
            }
        };

        log.info("tomcat thread: {}, timestamp: {}", Thread.currentThread().getName(), System.currentTimeMillis());
        return callable;
    }
}
