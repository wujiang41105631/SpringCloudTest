package com.xcn.eurakaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: xupeng.guo
 * @date: 2019/6/17
 * @description
 */
@RestController
@Slf4j
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }

    @GetMapping("/home")
    public String home(@RequestParam String name) {
        log.info("requestParam:" + name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "home --> " + name + ",i am from port:" + port;
    }

    @RequestMapping("/timeOut")
    public String timeOut(UserInfo userInfo) {
        log.info("requestParam:" + userInfo);
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "home --> " + userInfo + ",i am from port:" + port;
    }
}
