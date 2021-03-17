package coderead.dubbo.boot;
/**
 * @Copyright 源码阅读网 http://coderead.cn
 */

import coderead.dubbo.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 鲁班大叔
 * @date 2021
 */
@Configuration
public class DubboConfig {

    @DubboReference(interfaceClass = UserService.class,
            url = "dubbo://127.0.0.1:20081",
            group = "${server.member.group}"
    )
    private UserService userService;

    @Bean(name = "userService")
    public UserService getUserService(){
        return userService;
    }

}
