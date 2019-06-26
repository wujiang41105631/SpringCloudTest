package com.xcn.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author: xupeng.guo
 * @date: 2019/6/20
 * @description
 */
@Component
public class SayHiFallBackFactory implements FallbackFactory<SayHiService>{
    @Override
    public SayHiService create(Throwable throwable) {
         return new SayHiService() {
             @Override
             public String sayHi(String name) {
                 return "sayHi in FallbackFacotry";
             }

             @Override
             public String sayHiHome(String name) {
                 return "sayHiHome in FallbackFacotry";
             }

             @Override
             public String timeOut(String name, Integer age) {
                 return "sayHi11111Home in FallbackFacotry";
             }
         };
    }
}
