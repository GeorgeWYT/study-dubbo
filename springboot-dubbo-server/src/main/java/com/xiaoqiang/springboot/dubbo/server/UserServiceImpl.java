package com.xiaoqiang.springboot.dubbo.server;

import com.xiaoqiang.entity.User;
import com.xiaoqiang.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author George on 2020-05-08
 **/
//注意：引入dubbo的serivce
@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(Integer id) {

        User user =  new User();
        user.setId(id);
        user.setName("xiaoqiang" + ManagementFactory.getRuntimeMXBean().getName());
        user.setSex("male");
        return user;
    }

    @Override
    public List<User> findUser(String city, String sex) {
        return null;
    }
}
