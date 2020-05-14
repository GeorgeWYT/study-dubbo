package com.xiaoqiang;

import com.xiaoqiang.entity.User;
import com.xiaoqiang.service.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * 代码方式写DubboClient
 * Application
 * Reference
 * Registry
 * @author George on 2020-05-09
 **/
public class DubboClient {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ApplicationConfig applicationConfig = new ApplicationConfig("Dubbo-Client");
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
        ReferenceConfig referenceConfig = new ReferenceConfig();
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setInterface(UserService.class);
        UserService userService = (UserService) referenceConfig.get();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = bufferedReader.readLine();
            if (line.equals("quit")) {
                break;
            }
            if (line.startsWith("findUser")) {
                List<User> byCity = userService.findUser(line.split(" ")[1], line.split(" ")[2]);
                String s = Arrays.toString(byCity.toArray());
                System.out.println(s);
            } else if (line.startsWith("getUser")) {
                System.out.println(userService.getUser(1));
            }else {
                userService.getUser(1);
                Future<User> future = RpcContext.getContext().getFuture(); //Threadlocal

                userService.getUser(1);
                Future<User> future1 = RpcContext.getContext().getFuture(); //Threadlocal
                User user = future.get();//get是阻塞方法

                User user1 = future1.get();
                System.out.println(user);
                System.out.println(user1);
            }
        }
    }
}
