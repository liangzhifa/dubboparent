package com.ts.ipackage;

import com.ts.model.Info;
import com.ts.resultEntity.LayUIDataGrid;

import java.io.Serializable;

public interface ITsInfoService extends Serializable {

    public LayUIDataGrid findInfoByYear(Integer page, Integer limit,String insured_year,String identification );

    public int insertInfo(Info info);
}
