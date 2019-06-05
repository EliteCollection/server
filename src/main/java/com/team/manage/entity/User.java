package com.team.manage.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String id;

    private String workNumber;  //工号

    private String userName;  //姓名

    private String account;  //账号

    private String password;  //密码

    private String mobileNo;  //手机号码

    private String email;  //邮箱

    private String idcard;  //身份证号

    private Integer sex;  //性别 1男 2女 3其他

    private String birthday;  //出生日期

    private String deptCode;  //部门编码

    private String deptName;  //部门名称

    private String postCode;  //职位编码

    private String postName;  //职位名称

    private Integer userFlag;  //用户类型 1普通用户 2管理员

    private Integer invalidFlag;  //有效表示 1有效 0无效

    private String loginTime;  //最近一次登录时间

    private String personalResume;  //个人简介

    private String userAuth;  //用户权限

    private String createTime;  //创建时间

    private String updateTime;  //更新时间

    private static final long serialVersionUID = 1L;
}