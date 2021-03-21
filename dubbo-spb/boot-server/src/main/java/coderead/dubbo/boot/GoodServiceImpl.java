package coderead.dubbo.boot;
/**
 * @Copyright 源码阅读网 http://coderead.cn
 */


import coderead.dubbo.api.GoodsService;
import coderead.dubbo.api.User;
import coderead.dubbo.api.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author lmafia
 * @date 2021
 */
@DubboService
public class GoodServiceImpl implements GoodsService {

    private Integer port;

    @Override
    public User getUser(Integer id) {
        User user = mockUser(id);
        user.setDesc("服务端口："+port);
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
