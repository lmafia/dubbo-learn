package com.lmafia.dubbolearn;

import com.lmafia.dubbolearn.service.UserService;
import com.lmafia.dubbolearn.service.impl.UserServiceImpl;
import org.apache.dubbo.config.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author L_MaFia
 * @classname DubboSingletonRemote.java
 * @description TODO
 * @date 2021/3/3
 */
public class DubboSingletonRemote {


    //    客户端
    @Test
    public void invokeRemote() {
//
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
//        应用
        ApplicationConfig applicationConfig = new ApplicationConfig("lmafia-client");
        referenceConfig.setApplication(applicationConfig);
//        设置服务url  + 接口
        referenceConfig.setUrl("dubbo://127.0.0.1:1225/com.lmafia.dubbolearn.service.UserService");
//        设置获取服务接口
        referenceConfig.setInterface(UserService.class);
//        获取服务接口 (动态代理)
        UserService userService = referenceConfig.get();
//        进行调用
        System.out.println(userService.getUser(1001));
    }


    @Test
//    服务端
    public void openService() throws IOException {
//        服务配置
        ServiceConfig serviceConfig = new ServiceConfig();
//        应用
        ApplicationConfig app = new ApplicationConfig("lmafia-server");
        serviceConfig.setApplication(app);
        //        协议    dubbo：应用协议 二进制 全双工
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", 1225);
//       设置协议
        serviceConfig.setProtocol(protocolConfig);
//        服务接口
        serviceConfig.setInterface(UserService.class);
//        服务接口实现
        serviceConfig.setRef(new UserServiceImpl(1225));
//        注册中心 搞个空的
        RegistryConfig registryConfig = new RegistryConfig(RegistryConfig.NO_AVAILABLE);
        serviceConfig.setRegistry(registryConfig);
//        开启服务
        serviceConfig.export();
//        防止结束任务
        int read = System.in.read();
    }
}
