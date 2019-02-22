package com.ts.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ts.ipackage.ITeacherService;
import com.ts.model.Teacher;
import com.ts.provider.mapper.TeacherMapper;
import com.ts.resultEntity.LayUIDataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class TeacherService implements ITeacherService  {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public LayUIDataGrid findAllTeachers(Integer page,Integer limit,String teacherName) {

        PageHelper.startPage(page,limit);//分页插件
        teacherName="%"+teacherName+"%";
        List<Teacher> teachers = teacherMapper.findAll(teacherName);
        PageInfo<Teacher> info=new PageInfo<>(teachers);
        long total = info.getTotal();
        List<Teacher> list = info.getList();
        return LayUIDataGrid.ReturnDataGrid(total,list);
    }

    @Override
    public int deleteById(Integer id) {
        return  teacherMapper.deleteByPrimaryKey(id);
    }
}
