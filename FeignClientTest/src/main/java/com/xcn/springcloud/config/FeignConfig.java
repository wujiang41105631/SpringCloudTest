package com.xcn.springcloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 此类由于作为FeignClient的 configuration 配置,不需要加入@Configuration。如果非要用的话,请注意将在整体@SpringBootApplication中将之排除。
 * 否则他将覆盖FeignClientsConfiguration
 * @author: xupeng.guo
 * @date: 2019/6/20
 * @description
 */
public class FeignConfig {

    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(10L,10L,3);
    }
}
