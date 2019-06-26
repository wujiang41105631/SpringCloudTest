package com.xcn.springcloud.controller;

import com.xcn.springcloud.service.SayHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
@RestController
public class SayHiController {

    @Autowired
    private SayHiService sayHiService;

    @GetMapping("/sayhello")
    public Map<String, String> sayHello(@RequestParam String name) {
        Map<String, String> result = new HashMap<>();
        result.put("name", sayHiService.sayHi(name));
        result.put("home", sayHiService.sayHiHome(name));
        result.put("project", "FeignClient");
        return result;
    }

    @GetMapping("/sayhi")
    public String sayHi(@RequestParam String name) {
        return sayHiService.sayHi(name) + "project : feign client";
    }

    @GetMapping(value = "/home")
    String sayHiHome(@RequestParam(value = "name") String name,@RequestParam(value="age") int age){
        return sayHiService.timeOut(name,age) + "project : feign client";
    }

}
