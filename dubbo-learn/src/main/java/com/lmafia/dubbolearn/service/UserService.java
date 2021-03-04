package com.lmafia.dubbolearn.service;

import com.lmafia.dubbolearn.bean.User;

/**
 * @author L_MaFia
 * @classname UserService.java
 * @description TODO
 * @date 2021/3/3
 */
public interface UserService {
    User getUser(Integer id);
}
