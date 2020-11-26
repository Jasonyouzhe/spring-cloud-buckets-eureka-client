package com.spring.cloud.eureka.client.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallbackFacFactory implements FallbackFactory<EkaFeignService> {

    @Override
    public EkaFeignService create(Throwable throwable) {
        return name -> {
            System.out.println("FallbackFactory");
            System.out.println(throwable.toString());
            return null;
        };
    }
}
