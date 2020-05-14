package com.xiaoqiang.service;

import com.xiaoqiang.entity.User;

import java.util.List;

/**
 * @author George on 2020-05-08
 **/
public interface UserService {
    User getUser(Integer id);

    List<User> findUser(String city, String sex);
}
