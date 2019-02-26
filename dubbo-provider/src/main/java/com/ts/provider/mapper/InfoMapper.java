package com.ts.provider.mapper;

import com.ts.model.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

    List<Info> findInfoByYear(@Param(value = "insured_year") String insured_year , @Param("identification") String identification);
}