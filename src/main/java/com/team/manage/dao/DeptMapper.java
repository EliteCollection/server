package com.team.manage.dao;

import com.team.manage.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DeptMapper {


    int deleteByPrimaryKey(String id);

    int insert(Dept record);

    int insertSelective(Dept record);


    Dept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}