package com.spring.cloud.eureka.client.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.cloud.eureka.client.feign.EkaFeignService;
import com.spring.cloud.eureka.client.service.EurekaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "global_fallback_method") //全局降级方法
public class EurekaClientServiceImpl implements EurekaClientService {

    @Autowired
    EkaFeignService ekaFeignService;

    @Override
    @RequestMapping("/test")
//    @HystrixCommand(fallbackMethod = "timeOutHandler",commandKey="userGetKey")
    public String test(String name) {
        System.out.println("eureka-client");
        return ekaFeignService.test(name);
    }

    //timeout超时
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")  //5秒钟以内就执行正常的业务逻辑,反之执行降级方法
//    })
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandKey="userGetKey")
    @Override
    public String hystrixTest(Integer id) {
        int timeNumber = 6;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // int age = 10/0; 异常情况下,会直接进入服务降级方法
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id：  " + id + "\t" + "O(∩_∩)O哈哈~" + " 耗时(秒)";
    }

    // 服务降级方法
    // 方法签名(参数+返回值)需要跟原方法一致,方法名不同即可
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   系统繁忙, 请稍候再试  ,id：  "+id+"\t"+"哭了哇呜";
    }

    //2.定义全局服务降级方法(不能有参数)
    public String global_fallback_method(Integer id){
        return "~~~~我是,全局服务降级方法+id: "+id;
    }

    // 服务降级方法
    // 方法签名(参数+返回值)需要跟原方法一致,方法名不同即可
    public String timeOutHandler(String name){
        return "线程池："+Thread.currentThread().getName()+"   系统繁忙, 请稍候再试  ,name：  "+name+"\t"+"哭了哇呜";
    }
}
