package com.spring.cloud.eureka.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * fallbackFactory和fallback的不同
 */
@Component
//@FeignClient(name = "EUREKA-CLIENT-TEST2",path = "/client",fallback = FeignClientFallback.class)
//@FeignClient(name = "EUREKA-CLIENT-TEST2",fallbackFactory = FeignClientFallbackFacFactory.class)
@FeignClient(name = "EUREKA-CLIENT-TEST2",url = "http://localhost:8763",fallbackFactory = FeignClientFallbackFacFactory.class)
public interface EkaFeignService {
    @RequestMapping("/client/ek")
    String test(@RequestParam(value = "name") String name);
}
