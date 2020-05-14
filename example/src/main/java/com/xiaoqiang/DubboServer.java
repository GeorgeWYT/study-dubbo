package com.xiaoqiang;

import org.apache.dubbo.config.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        setLoadBalance(serviceConfig);
        serviceConfig.export();
        System.out.println("服务已暴露");
        System.in.read();
    }

    public  static void setLoadBalance(ServiceConfig serviceConfig){
//        serviceConfig.setLoadbalance("random");
//        serviceConfig.setWeight(200);

        serviceConfig.setLoadbalance("consistenthash");
        MethodConfig methodConfig =new MethodConfig();
        methodConfig.setName("findUser");
        Map<String, String> map = new HashMap<>();
        map.put("hash.arguments", "0,1");
        map.put("hash.nodes", "320");
        methodConfig.setParameters(map);
        serviceConfig.setMethods(Arrays.asList(methodConfig));
    }
}
