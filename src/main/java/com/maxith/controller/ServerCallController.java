package com.maxith.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RefreshScope
public class ServerCallController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloClient helloClient;

    @Value("${hello.world}")
    private String hello;

    @Value("${password}")
    private String password;

    @RequestMapping("/call/{serverName}")
    public String callServer(@PathVariable("serverName") String serverName) throws InterruptedException {
        System.out.println(password);
        return hello + " --- " +restTemplate.getForObject("http://" + serverName + "/say",String.class);
    }

    @RequestMapping("/callServer")
    public String callServer(){
        return helloClient.say();
    }
}
