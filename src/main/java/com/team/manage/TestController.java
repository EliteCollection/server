package com.team.manage;

import com.team.manage.entity.Liquibase0011;
import com.team.manage.service.test.LiquibaseService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create By tcyu
 * Create time 2019/1/23 下午9:09
 * Description 测试控制器
 */
@RestController
public class TestController {


    @Autowired
    private LiquibaseService liquibaseService;
    /**
     * 获取数据库对象
     * @return
     */
    @RequestMapping("/getLiquibase0011")
    public List<Liquibase0011> getLiquibase0011(){
        System.out.println(1111111111+"------------");
        return liquibaseService.getLiquibase();
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("save")
    public String save(){
        Liquibase0011 liquibase0011 = new Liquibase0011();
        liquibase0011.setId(23);
        liquibase0011.setFirstname("zhang");
        liquibase0011.setLastname("san");
        int i = liquibaseService.saveHello(liquibase0011);
        System.out.println(i);
        throw new  RuntimeException("111");
    }
}
