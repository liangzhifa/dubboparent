package com.ts.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ts.ipackage.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class TestController {

    @Value("${server.port}")
    private Integer servicePort;

    @Reference
    private TestService testService;

    @RequestMapping("/say")
    public String say() throws UnknownHostException {
        InetAddress address = Inet4Address.getLocalHost();

        System.out.println( servicePort);
        System.out.println(testService.toString());
        return testService.say()+testService.toString();
    }

}
