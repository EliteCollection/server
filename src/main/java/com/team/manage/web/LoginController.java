package com.team.manage.web;

import com.team.manage.common.SimpleResult;
import com.team.manage.common.util.StringUtil;
import com.team.manage.entity.User;
import com.team.manage.entity.UserDTO;
import com.team.manage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create By tcyu
 * Create time 2019/1/26 下午6:41
 * Description 登录控制器
 */
@RestController
public class LoginController {

    SimpleResult result;
    @Autowired
    private UserService userService;

    /**
     * 登录验证
     * @param account
     * @param password
     * @return
     */
    @PostMapping("/login")
    public SimpleResult login(String account, String password){
        result = new SimpleResult(false);
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount(account);
        userDTO.setPassword(StringUtil.getMd5(password));
        User user = userService.getUser(userDTO);
        if (user != null){
            result.setSuccess(true);
            result.addModel("user",user);
            return result;
        }
        result.setMessage("账号或密码错误");
        return result;
    }

    /**
     * 注册用户
     * @param userDTO
     * @return
     */
    @PostMapping("/register")
    public SimpleResult register(UserDTO userDTO){
        result = new SimpleResult(false);
        int re = userService.saveUser(userDTO);
        if (re != 0){
            result.setSuccess(true);
        }
        result.setMessage("注册失败");
        return result;
    }

    /**
     * 修改用户信息
     * @param userDTO
     * @return
     */
    @PostMapping("/editUser")
    public SimpleResult editUser(UserDTO userDTO){
        result = new SimpleResult();

        return result;
    }

}
