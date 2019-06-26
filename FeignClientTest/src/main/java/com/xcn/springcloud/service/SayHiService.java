package com.xcn.springcloud.service;

import com.xcn.springcloud.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
// fallback = ErrorService.class
@FeignClient(value = "RiskService-SayHello",fallbackFactory = SayHiFallBackFactory.class,configuration = FeignConfig.class)
public interface SayHiService {

    @GetMapping(value = "/hi")
    String sayHi(@RequestParam(value = "name") String name);

    @GetMapping(value = "/home")
    String sayHiHome(@RequestParam(value = "name") String name);

    @GetMapping(value = "/timeOut")
    String timeOut(@RequestParam(value = "userName") String name,@RequestParam(value="age")Integer age);
}
