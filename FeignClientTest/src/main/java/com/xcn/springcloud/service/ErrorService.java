package com.xcn.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
@Component
public class ErrorService implements SayHiService {
    @Override
    public String sayHi(String name) {
        return "{\"code\":4000,\"msg\":\"sayHi error msg\"}";
    }

    @Override
    public String sayHiHome(String name) {
        return "{\"code\":4000,\"msg\":\"sayHiHome error msg\"}";
    }

    @Override
    public String timeOut(String name, Integer age) {
        return "{\"code\":4000,\"msg\":\"timeOut error msg\"}";
    }
}
