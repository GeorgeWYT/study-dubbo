package com.xiaoqiang;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;

/**
 * 代码方式写DubboServer
 *  application
 *  protocol
 *  register
 *  service
 * @author George on 2020-05-09
 **/
public class DubboServer {
    public static void main(String[] args) throws IOException {

        ApplicationConfig applicationConfig = new ApplicationConfig("Dubbo-Server");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(-1);
        protocolConfig.setSerialization("fastjson");

        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");

        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setInterface("com.xiaoqiang.service.UserService");
        serviceConfig.setRef(new UserServiceImpl());
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setApplication(applicationConfig);

        serviceConfig.export();
        System.out.println("服务已暴露");
        System.in.read();
    }
}
