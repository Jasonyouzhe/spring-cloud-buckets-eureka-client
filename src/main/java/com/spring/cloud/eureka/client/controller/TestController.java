package com.spring.cloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author：JCccc
 * @Description：
 * @Date： created in 14:19 2018/3/5
 */
@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/haveatry")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) throws InterruptedException {

        return "微服务 eureka-client-test被调用， " + "name为:"+name + " ,被调用的服务端口 port:" + port;
    }


}
