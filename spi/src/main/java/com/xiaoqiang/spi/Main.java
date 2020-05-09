package com.xiaoqiang.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author George on 2020-05-08
 **/
public class Main {
    public static void main(String[] args) {
        Iterator<UserService> iterator = ServiceLoader.load(UserService.class).iterator();
        UserService userService= iterator.next();
        System.out.println(userService.getName(1));
    }
}
