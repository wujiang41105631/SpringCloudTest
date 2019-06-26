package com.xcn.springcloud.controller;

import com.xcn.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/sayhi")
    public String sayHi(@RequestParam String name) {
        return helloService.helloService(name);
    }

    @GetMapping(value = "/home")
    String sayHiHome(@RequestParam(value = "name") String name){
        return helloService.helloService(name);
    }
}
