package com.xcn.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
@Service
public class HelloService {
    private final static String SERVICE_NAME = "http://RiskService-SayHello/";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHiError")
    public String helloService(String name) {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(SERVICE_NAME + "hi?name=" + name, String.class);
        if (forEntity.getStatusCode() == HttpStatus.OK) {
            return forEntity.getBody() + ",project = RibbonClient";
        }
        return null;
    }

    public String sayHiError(String name) {
        Map<String, String> result = new HashMap<>();
        result.put("status", "4000");
        result.put("msg", "say hi error " + name);
        return result.toString();
    }
}
