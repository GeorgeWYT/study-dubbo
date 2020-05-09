package com.xiaoqiang.springboot.dubbo.client;

import com.xiaoqiang.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDubbo
public class SpringbootDubboClientApplication {

    @Reference
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboClientApplication.class, args).close();
    }

    @Bean
    public ApplicationRunner getBean() {
        return args -> {
            System.out.println(userService.getUser(1));
        };
    }
}
