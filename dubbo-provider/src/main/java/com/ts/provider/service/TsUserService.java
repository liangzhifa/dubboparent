package com.ts.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ts.ipackage.ITsUserService;
import com.ts.model.User;
import com.ts.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;

@Component
@Service
public class TsUserService implements ITsUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        int i=0;
        try{
           i = userMapper.insert(user);
        }catch (Exception e){
        }
        return i;
    }

    @Override
    public User findUserByIdentificationAndPassword(String identification, String password) {
        return userMapper.findUserByIdentificationAndPassword(identification, password);
    }
}
