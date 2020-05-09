package com.xiaoqiang;

import com.xiaoqiang.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * spring ioc方式写dubboclient
 * @author George on 2020-05-09
 **/
public class SpringClient {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        UserService userService = context.getBean(UserService.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            if(bufferedReader.readLine().equals("quit")){
                break;
            }
            System.out.println(userService.getUser(1));
        }

    }
}
