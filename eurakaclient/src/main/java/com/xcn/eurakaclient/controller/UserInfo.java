package com.xcn.eurakaclient.controller;

import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.Data;

/**
 * @author: xupeng.guo
 * @date: 2019/6/21
 * @description
 */

@Data
public class UserInfo {

    private String userName;
    private Integer age;

    @Override
    public String toString(){
        return  String.format("{userName: %s,age: %d}",userName,age);
    }

    public static void main(String[] args) {
        System.out.println( String.format("{userName: %s,age: %d}","fa",123));
    }
}
