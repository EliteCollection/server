package com.team.manage.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {
    private String id;

    private String deptCode;  //部门编码

    private String deptName;  //部门名称

    private String pinyinCode;  //拼音码

    private String parentDeptCode;  //上级部门编码

    private String parentDeptName;  //上级部门名称

    private Integer invalidFlag;  //作废表示 0作废 1有效

    private String deptMobileNo;  //部门联系电话

    private Integer sortNo;  //排序号

    private String createTime;  //创建时间

    private Integer updateTime;  //更新时间

    private static final long serialVersionUID = 1L;

}