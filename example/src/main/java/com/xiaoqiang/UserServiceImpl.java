package com.xiaoqiang;

import com.xiaoqiang.entity.User;
import com.xiaoqiang.service.UserService;

import java.lang.management.ManagementFactory;

/**
 * 接口的实现类
 *
 * @author George on 2020-05-09
 **/
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(Integer id) {
        User user =  new User();
        user.setId(id);
        user.setName("xiaoqiang" + ManagementFactory.getRuntimeMXBean().getName());
        user.setSex("male");
        return user;
    }
}
