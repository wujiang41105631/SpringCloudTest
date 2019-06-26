package com.xcn.springcloud.config;

import com.xcn.springcloud.web.RealTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xupeng.guo
 * @date: 2019/6/20
 * @description
 */
//@Configuration
public class Config {

    // tag::route-locator[]
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        String httpUri = "http://httpbin.org:80";
//        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri(httpUri))
//                .route(p -> p
//                        .host("*.hystrix.com")
//                        .filters(f -> f
//                                .hystrix(config -> config
//                                        .setName("mycmd")
//                                        .setFallbackUri("forward:/fallback")))
//                        .uri(httpUri))
//                .build();
//    }



//    @Bean
//    public RealTokenFilter tokenFilter(){
//        return new RealTokenFilter();
//    }
}
