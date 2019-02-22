package com.ts.provider.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ts.ipackage.TestService;
import com.ts.model.Teacher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Service
public class DubboTestService implements TestService{


    @Value("${server.port}")
    private Integer servicePort;

    @Value("${dubbo.protocol.port}")
    private Integer dubboProtocolPort;


    @Override
    public String say() {

        return "hello==>" +servicePort+"==>"+dubboProtocolPort;
    }
}
