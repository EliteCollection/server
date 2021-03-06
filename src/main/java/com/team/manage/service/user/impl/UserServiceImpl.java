package com.team.manage.service.user.impl;

import com.team.manage.dao.UserMapper;
import com.team.manage.entity.User;
import com.team.manage.entity.UserDTO;
import com.team.manage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Create By tcyu
 * Create time 2019/1/26 下午9:10
 * Description 用户管理实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 获取用户对象信息
     *
     * @param userDTO
     * @return
     */
    @Override
    public User getUser(UserDTO userDTO) {
        List<User> user = userMapper.getUser(userDTO);
        if (CollectionUtils.isEmpty(user)){
            return null;
        }
        return userMapper.getUser(userDTO).get(0);
    }

    /**
     * 保存用户信息
     *
     * @param userDTO
     * @return
     */
    @Override
    public int saveUser(UserDTO userDTO) {
        return userMapper.insert(userDTO);
    }

    /**
     * 修改用户的基本信息
     *
     * @param userDTO
     * @return
     */
    @Override
    public int editUser(UserDTO userDTO) {
        return userMapper.updateByPrimaryKeySelective(userDTO);
    }

    /**
     * 根据账号获取用户
     *
     * @param account
     * @return
     */
    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }
}
