package com.xiaoqiang;

import com.xiaoqiang.service.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;


/**
 * 代码方式写DubboClient
 * Application
 * Reference
 * Registry
 * @author George on 2020-05-09
 **/
public class DubboClient {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig("Dubbo-Client");
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
        ReferenceConfig referenceConfig = new ReferenceConfig();
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setInterface(UserService.class);
        UserService userService = (UserService) referenceConfig.get();
        System.out.println(userService.getUser(1));
    }
}
