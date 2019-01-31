package com.team.manage.service.user;

import com.team.manage.entity.User;
import com.team.manage.entity.UserDTO;

/**
 * Create By tcyu
 * Create time 2019/1/26 下午9:05
 * Description 用户管理service
 */
public interface UserService {

    /**
     * 获取用户对象信息
     * @param userDTO
     * @return
     */
    User getUser(UserDTO userDTO);

    /**
     * 保存用户信息
     * @param userDTO
     * @return
     */
    int saveUser(UserDTO userDTO);

    /**
     * 修改用户的基本信息
     * @param userDTO
     * @return
     */
    int editUser(UserDTO userDTO);

}
