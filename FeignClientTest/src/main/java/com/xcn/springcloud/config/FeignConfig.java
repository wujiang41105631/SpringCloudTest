package com.xcn.springcloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xupeng.guo
 * @date: 2019/6/20
 * @description
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(10L,10L,3);
    }
}
