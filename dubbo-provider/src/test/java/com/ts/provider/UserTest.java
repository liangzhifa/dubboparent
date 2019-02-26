package com.ts.provider;

import com.ts.model.User;
import com.ts.provider.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
   private UserMapper userMapper;

    @Test
    public void select(){
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println();
    }
    @Test
    public void insert(){
        User u = new User("zhang","440981199509143937","zhang", (short) 0);

        int insert=0;
        try {
            insert = userMapper.insert(u);
        } catch (Exception e) {
        }

        System.out.println();
    }

    @Test
    public void selectu(){
        User user = userMapper.findUserByIdentificationAndPassword("440981199509143937","zhang");
        System.out.println();
    }
}
