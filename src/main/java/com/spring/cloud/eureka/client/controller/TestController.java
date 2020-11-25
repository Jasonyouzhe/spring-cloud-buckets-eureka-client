package com.spring.cloud.eureka.client.controller;

import com.spring.cloud.eureka.client.service.EurekaClientService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author：Jason zhang
 * @Description：
 * @Date： created in 14:19 2020/11/25
 */
@RestController
@RequestMapping("/client")
public class TestController {

    @Autowired
    EurekaClientService eurekaClientService;

    @RequestMapping("/test")
    public String home(@RequestParam(value = "name",required = false) String name) {
        String str = eurekaClientService.test(name);
        System.out.println(str);
        return str;
    }

    @RequestMapping("/ek")
    public String ek(@RequestParam(value = "name",required = false) String name) {
        if(StringUtils.isNotEmpty(name)){
            return "eureka-client-test:8672 success";
        }
        return "eureka-client-test:8672 exception";
    }
}
