package com.spring.cloud.eureka.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "service1",url = "http://localhost:8763/client")
public interface EkaFeignService {
    @RequestMapping("/ek")
    String test(@RequestParam(value = "name") String name);
}
