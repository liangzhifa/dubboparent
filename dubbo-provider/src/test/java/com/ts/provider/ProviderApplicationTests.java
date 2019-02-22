package com.ts.provider;

import com.ts.model.Manager;
import com.ts.model.Teacher;
import com.ts.provider.mapper.ManagerMapper;
import com.ts.provider.mapper.TeacherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderApplicationTests {

	@Autowired
	TeacherMapper teacherMapper;

	@Autowired
	ManagerMapper managerMapper;



	@Test
	public void contextLoads() {
		for (int i = 10; i < 60; i++) {
			Teacher t=new Teacher("2018221"+i,"2018221"+i);
			teacherMapper.insert(t);
			//
		}
		List<Teacher> all = teacherMapper.findAll("");
		List<Manager> managerMapperAll = managerMapper.findAll();
		System.out.println();
	}

}
