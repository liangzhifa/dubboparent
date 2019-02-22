package com.ts.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ts.ipackage.ITeacherService;
import com.ts.resultEntity.LayUIDataGrid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Reference
    ITeacherService teacherService;

    @RequestMapping(value = "/findAllTeachers")
    public LayUIDataGrid findAllTeachers(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                         @RequestParam(value = "limit",defaultValue = "80")Integer limit,
                                         @RequestParam(value = "teacherName",defaultValue = "",required = false) String teacherName){
        return teacherService.findAllTeachers(page, limit, teacherName);
    }

    @RequestMapping("/deleteById")
    public Object deleteById(Integer id){
        int n=teacherService.deleteById(id);
        Map<String,Object> map=new HashMap<>();
        if (n>0){
            map.put("status",true);
            return map;
        }
        map.put("status",false);
        map.put("msg","删除失败，请重试！");
        return map;
    }

}
