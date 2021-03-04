package com.lmafia.dubbolearn;

import com.lmafia.dubbolearn.service.UserService;
import com.lmafia.dubbolearn.service.impl.UserServiceImpl;
import org.apache.dubbo.config.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author L_MaFia
 * @classname DubboClusterRemote.java
 * @description TODO
 * @date 2021/3/4
 */
public class DubboClusterRemote {


    public void openService(int port) throws IOException {
//        服务配置
        ServiceConfig serviceConfig = new ServiceConfig();
//        应用
        ApplicationConfig app = new ApplicationConfig("lmafia-server");
        serviceConfig.setApplication(app);
        //        协议    dubbo：应用协议 二进制 全双工
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", port);
//       设置协议
        serviceConfig.setProtocol(protocolConfig);
//        服务接口
        serviceConfig.setInterface(UserService.class);
//        服务接口实现
        serviceConfig.setRef(new UserServiceImpl(port));
//        注册中心 集群用到
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
        serviceConfig.setRegistry(registryConfig);
//        开启服务
        serviceConfig.export();
        System.out.println("server is started");
//        防止结束任务
        System.in.read();
    }

    //    服务1
    @Test
    public void openServiceOne() throws IOException {
        openService(1227);
    }

    //    服务2
    @Test
    public void openServiceTwo() throws IOException {
        openService(1226);
    }
    

    //    服务3
    @Test
    public void openServiceThree() throws IOException {
        openService(1225);
    }

    public static void main(String[] args) throws IOException {
        UserService userService = getUser();
        while (System.in.read() != 'q') {
            System.out.println(userService.getUser(111));
        }
    }

    //    客户端


    public static UserService getUser() {
//
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
//        应用
        ApplicationConfig applicationConfig = new ApplicationConfig("lmafia-client");
        referenceConfig.setApplication(applicationConfig);
//        设置服务url  + 接口
//        referenceConfig.setUrl("dubbo://127.0.0.1:1225/com.lmafia.dubbolearn.service.UserService");
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
        referenceConfig.setRegistry(registryConfig);
//        设置获取服务接口
        referenceConfig.setInterface(UserService.class);
//        获取服务接口 (动态代理)
        UserService userService = referenceConfig.get();
        return userService;
    }

}
