package com.xcn.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
@FeignClient(value = "RiskService-SayHello",fallback = ErrorService.class)
public interface SayHiService {

    @GetMapping(value = "/hi")
    String sayHi(@RequestParam(value = "name") String name);

    @GetMapping(value = "/home")
    String sayHiHome(@RequestParam(value = "name") String name);
}
