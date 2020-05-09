package com.xiaoqiang.spi;

/**
 * @author George on 2020-05-08
 **/
public class UserServiceImpl implements UserService{

    @Override
    public String getName(int id) {
        return "I am xiaoqiang";
    }
}
