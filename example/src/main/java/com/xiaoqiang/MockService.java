package com.xiaoqiang;

import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.HashMap;

/**
 * @author George on 2020-05-13
 **/
public class MockService implements GenericService {
    private String target;

    public MockService(String target) {
        this.target = target;
    }

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        String key = target + method;
        if(target.equals("com.xiaoqiang.service.UserService") && method.equals("getUser")){
            HashMap<Object, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("name", "小强");
            return map;
        }
        return null;
    }
}
