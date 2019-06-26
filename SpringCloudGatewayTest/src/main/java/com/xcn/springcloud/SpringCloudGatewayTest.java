package com.xcn.springcloud;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.xcn.springcloud.web.RealTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xupeng.guo
 * @date: 2019/6/19
 * @description
 */
@SpringBootApplication
@RestController
public class SpringCloudGatewayTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayTest.class, args);
    }

    @Bean
    public RealTokenFilter tokenFilter(){
        return new RealTokenFilter();
    }
}
