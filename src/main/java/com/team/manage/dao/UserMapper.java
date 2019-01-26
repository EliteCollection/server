package com.team.manage.dao;

import com.team.manage.entity.User;
import com.team.manage.entity.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    int deleteByPrimaryKey(String id);

    int insert(UserDTO userDTO);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 获取用户对象信息
     * @param userDTO
     * @return
     */
    List<User> getUser(UserDTO userDTO);
}