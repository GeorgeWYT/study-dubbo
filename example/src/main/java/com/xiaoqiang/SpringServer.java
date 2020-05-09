package com.xiaoqiang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * spring ioc方式写dubboserver
 * @author George on 2020-05-09
 **/
public class SpringServer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        System.out.println("服务已暴露");
        System.in.read();
    }
}
