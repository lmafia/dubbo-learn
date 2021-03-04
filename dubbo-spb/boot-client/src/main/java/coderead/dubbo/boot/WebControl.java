package coderead.dubbo.boot;
/**
 * @Copyright 源码阅读网 http://coderead.cn
 */

import coderead.dubbo.api.User;
import coderead.dubbo.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 鲁班大叔
 * @date 2021
 */
@Controller
public class WebControl {
//    @DubboReference
//    private UserService userService;

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public User getUser(Integer id){
        return userService.getUser(id);
    }
}
