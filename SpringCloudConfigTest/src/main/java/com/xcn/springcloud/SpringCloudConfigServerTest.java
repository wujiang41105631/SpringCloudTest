package com.xcn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerTest.class, args);
    }
}
