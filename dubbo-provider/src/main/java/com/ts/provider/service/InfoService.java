package com.ts.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ts.ipackage.ITsInfoService;
import com.ts.model.Info;
import com.ts.provider.mapper.InfoMapper;
import com.ts.resultEntity.LayUIDataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Service
public class InfoService implements ITsInfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public LayUIDataGrid findInfoByYear(Integer page, Integer limit, String insured_year,String identification) {
        PageHelper.startPage(page,limit);
        List<Info> infoByYear = infoMapper.findInfoByYear(insured_year,identification);
        PageInfo<Info>pageInfo=new PageInfo<>(infoByYear);
        long total = pageInfo.getTotal();
        List<Info> list = pageInfo.getList();
        return LayUIDataGrid.ReturnDataGrid(total,list);
    }

    @Override
    public int insertInfo(Info info) {

        int i=0;
        try {
            i=infoMapper.insert(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
