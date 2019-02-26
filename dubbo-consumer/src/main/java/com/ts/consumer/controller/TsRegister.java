package com.ts.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ts.ipackage.ITsUserService;
import com.ts.model.User;
import com.ts.resultEntity.LoginResult;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.math.BigInteger;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TsRegister {

    @Reference
    ITsUserService userService;

    @PostMapping(value = "/ts/userRegister",produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResult userRegister(User user){
        Map<Object,Object> map=new HashMap<>();
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        System.out.println(md5DigestAsHex);
        user.setPassword(md5DigestAsHex);
        int insert=0;
        //todo 数据库添加操作,
        insert=userService.insertUser(user);
        if(insert>0){
            //成功
            map.put("msg","注册成功");
            map.put("url", "./login.html");
            return LoginResult.SUCCESS(map);
        }
            map.put("msg","注册失败,该账号也有可能注册过了");
            return  LoginResult.ERROR(map);
    }

}
