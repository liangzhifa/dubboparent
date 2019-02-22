package com.ts.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ts.ipackage.ImanagerService;
import com.ts.model.Manager;
import com.ts.provider.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service
public class ManagerService implements ImanagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Manager manager_login(String managerName, String managerPassword) {
        Manager manager = managerMapper.findByNameAndPassword(managerName, managerPassword);
        return  manager;
    }
}
