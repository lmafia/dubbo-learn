package com.lmafia.dubbolearn.service.impl;

import com.lmafia.dubbolearn.bean.User;
import com.lmafia.dubbolearn.service.UserService;

/**
 * @author L_MaFia
 * @classname UserServiceImpl.java
 * @description TODO
 * @date 2021/3/3
 */
public class UserServiceImpl implements UserService {
    Integer port;

    public UserServiceImpl(Integer port) {
        this.port = port;
    }

    @Override
    public User getUser(Integer id) {
        User user = mockUser(id);
        user.setDesc("服务端口：" + port);
        return user;
    }

    static User mockUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("luban uncle");
        user.setBirthday("1998");
        user.setAge(18);

        return user;
    }

}
