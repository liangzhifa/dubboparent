package com.ts.ipackage;



import com.ts.resultEntity.LayUIDataGrid;

import java.io.Serializable;
import java.util.List;

public interface ITeacherService extends Serializable {
    public LayUIDataGrid findAllTeachers(Integer page, Integer limit, String teacherName);
    public int deleteById(Integer id);
}
