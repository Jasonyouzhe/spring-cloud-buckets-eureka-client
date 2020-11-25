package com.spring.cloud.eureka.client.service.impl;

import com.spring.cloud.eureka.client.feign.EkaFeignService;
import com.spring.cloud.eureka.client.service.EurekaClientService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EurekaClientServiceImpl implements EurekaClientService {

    @Autowired
    EkaFeignService ekaFeignService;

    @Override
    @RequestMapping("/test")
    public String test(String name) {
        System.out.println("eureka-client");
        return ekaFeignService.test(name);
    }

}
