package com.team.manage.service.test.impl;

import com.team.manage.dao.Liquibase0011Mapper;
import com.team.manage.entity.Liquibase0011;
import com.team.manage.service.test.LiquibaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Create By tcyu
 * Create time 2019/1/23 下午9:11
 * Description 测试Service实现类
 */
@Service
@EnableTransactionManagement
public class LiquibaseServiceImpl implements LiquibaseService {

    @Autowired
    private Liquibase0011Mapper liquibase0011Mapper;

    @Override
    public List<Liquibase0011> getLiquibase() {
        return liquibase0011Mapper.getLiquibase0011();
    }

    /**
     * 测试事务回滚
     * @param liquibase0011
     * @return
     */
    @Override
    public int saveHello(Liquibase0011 liquibase0011) {
        int i =  liquibase0011Mapper.insertValues(liquibase0011);
        throw  new RuntimeException("rew");
    }
}
