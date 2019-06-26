package com.xcn.springcloud.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
public class HystrixUtils {

    public static String sayHiError(String name) {
        Map<String, String> result = new HashMap<>();
        result.put("status", "4000");
        result.put("msg", "say hi error " + name);
        return result.toString();
    }
}
