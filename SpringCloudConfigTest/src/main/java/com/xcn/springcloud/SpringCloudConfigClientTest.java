package com.xcn.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xupeng.guo
 * @date: 2019/6/19
 * @description
 */
@SpringBootApplication
@RestController
public class SpringCloudConfigClientTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientTest.class, args);
    }

    @Value("${foo}")
    private String foo;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }
}
