package com.maxith.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SPRING-CLOUD-EUREKA-CLIENT")
public interface HelloClient {

    @RequestMapping(method = RequestMethod.POST,value = "say",consumes = "application/json")
    String say();
}
