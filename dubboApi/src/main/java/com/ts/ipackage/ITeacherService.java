package com.ts.ipackage;

import com.ts.model.Teacher;
import com.ts.resultEntity.LayUIDataGrid;

import java.util.List;

public interface ITeacherService {
    public LayUIDataGrid findAllTeachers(Integer page,Integer limit,String teacherName);
    public int deleteById(Integer id);
}
