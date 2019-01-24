package com.team.manage.service.test.impl;

import com.team.manage.dao.Liquibase0011Mapper;
import com.team.manage.entity.Liquibase0011;
import com.team.manage.service.test.LiquibaseService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By tcyu
 * Create time 2019/1/23 下午9:11
 * Description 测试Service实现类
 */
@Service
public class LiquibaseServiceImpl implements LiquibaseService {

    @Autowired
    private Liquibase0011Mapper liquibase0011Mapper;

    @Override
    public List<Liquibase0011> getLiquibase() {
        System.out.println("走到了实现类");
        return liquibase0011Mapper.getLiquibase0011();
    }
}
