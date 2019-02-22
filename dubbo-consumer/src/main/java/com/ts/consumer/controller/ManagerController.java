package com.ts.consumer.controller;

import com.ts.model.Manager;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ManagerController {

    @RequestMapping("/getManagerName")
    public String getManagerName(HttpSession httpSession){
        Manager manager= (Manager) httpSession.getAttribute("manager");
        String managerName="";
        if (ObjectUtils.isEmpty(manager)){
            managerName="游客";

        }else {
            managerName= manager.getManagerName();
        }
        return  managerName;
    }
}
