package com.spring.cloud.eureka.client.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements EkaFeignService{

    @Override
    public String test(String name) {
        return name+"服务异常";
    }
}
