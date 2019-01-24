package com.team.manage.service.test;

import com.team.manage.entity.Liquibase0011;

import java.util.List;

/**
 * Create By tcyu
 * Create time 2019/1/23 下午9:10
 * Description 测试service
 */
public interface LiquibaseService {

    List<Liquibase0011> getLiquibase();

    int saveHello(Liquibase0011 liquibase0011);

}
