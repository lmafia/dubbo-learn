package coderead.dubbo.boot;
/**
 * @Copyright 源码阅读网 http://coderead.cn
 */

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 鲁班大叔
 * @date 2021
 */
@EnableDubbo
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
    }
}
