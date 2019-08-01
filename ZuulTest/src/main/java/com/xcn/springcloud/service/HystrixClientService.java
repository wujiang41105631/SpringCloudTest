package com.xcn.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @author: xupeng.guo
 * @date: 2019/8/1
 * @description
 */
@Service
public class HystrixClientService {

    @HystrixCommand(fallbackMethod = "myFallback")
    public String simpleHystrixClientCall(long time) {
        // TODO query somethind
        return null;
    }

    /**
     * 方法simpleHystrixClientCall的回退方法，可以指定将hystrix执行失败异常传入到方法中
     *
     * @param p ystrix执行失败的传入方法的请求
     * @param e hystrix执行失败的异常对象
     * @return
     */
    String myFallback(long p, Throwable e) {
        return "Execute raw fallback: access service fail , req= " + p + " reason = " + e;
    }
}
