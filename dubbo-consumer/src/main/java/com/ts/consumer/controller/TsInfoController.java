package com.ts.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ts.ipackage.ITsInfoService;
import com.ts.model.Info;
import com.ts.model.User;
import com.ts.resultEntity.LayUIDataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TsInfoController {

    @Reference
    private ITsInfoService iTsInfoService;

    @RequestMapping(value = "/ts/findInfoByYear")
    public LayUIDataGrid findInfoByYear(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                        @RequestParam(value = "limit",defaultValue = "80")Integer limit,
                                        @RequestParam(value = "insured_year",defaultValue = "",required = false) String insured_year, HttpSession session){


        User user = (User) session.getAttribute("user");

        //String identification="440981199509141234";
        String identification = "";

        System.out.println("获取session======》"+user);
        if (user!=null) {
             identification=user.getIdentification();
            return iTsInfoService.findInfoByYear(page, limit, insured_year,identification);
        } else {
            return LayUIDataGrid.ReturnERRODataGrid();
        }
    }

    @PostMapping(value ="/ts/insertInfo",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Object,Object> insertInfo(Info info,HttpSession session){

        Map<Object, Object> map = new HashMap<>();
        User  user = (User) session.getAttribute("user");
        if (user==null){
            System.out.println("添加记录====》session 获取不到");
        }
       if (user==null){
            map.put("code",1);
            map.put("msg","新增失败！，请登录");
            return map;
        }
       /**
         * 从session中获取身份号
         *//*
        info.setIdentification(user.getIdentification());*/
       // String identification="440981199509141234";
        String identification=user.getIdentification();
        info.setIdentification(identification);
        int i = iTsInfoService.insertInfo(info);
        if (i>0){
            map.put("code",0);
            map.put("msg","新增成功！");
        }else {
            map.put("code",1);
            map.put("msg","新增失败！");
        }
        return map;
    }
}
