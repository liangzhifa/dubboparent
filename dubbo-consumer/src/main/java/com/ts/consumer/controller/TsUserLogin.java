package com.ts.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ts.ipackage.ITsUserService;
import com.ts.model.User;
import com.ts.resultEntity.LoginResult;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TsUserLogin {


    @Reference
    private ITsUserService userService;

    @PostMapping(value = "/ts/userlogin",produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResult userlogin(@RequestParam(value = "identification",defaultValue = "") String identification ,
                                 @RequestParam(value = "password",defaultValue = "")String password, HttpSession httpSession){

        Map<Object,Object> map=new HashMap<>();
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
        password=md5DigestAsHex;
        System.out.println("登录========》"+md5DigestAsHex);
        User user = userService.findUserByIdentificationAndPassword(identification, password);
        if (user!=null){
            httpSession.setAttribute("user",user);
            System.out.println("设置session======>"+user);
            map.put("url","./main.html");
            return LoginResult.SUCCESS(map);
        }
        map.put("msg","账号或者密码不正确");
        return LoginResult.ERROR(map);
    }

}
