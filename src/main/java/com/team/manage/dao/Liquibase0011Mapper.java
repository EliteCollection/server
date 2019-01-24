package com.team.manage.dao;

import com.team.manage.entity.Liquibase0011;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * Create By tcyu
 * Create time 2019/1/23 下午8:57
 * Description 测试mapper
 */
@Component
public interface Liquibase0011Mapper {
    /**
     * 获取测试对象
     * @return
     */
   List<Liquibase0011> getLiquibase0011();
}
