package com.xcn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
public class ZuulTest {
    /**
     * 本项目中 使用http://localhost:8003/api-a/sayhi?name=test 即可映射到ribbon-client上
     * 本项目中 使用http://localhost:8003/api-b/sayhi?name=test 即可映射到feign-client上
     * 使用Zuul 简单实现的路由功能
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(ZuulTest.class, args);
    }
}
