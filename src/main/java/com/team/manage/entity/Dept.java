package com.team.manage.entity;

import java.io.Serializable;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public String getParentDeptCode() {
        return parentDeptCode;
    }

    public void setParentDeptCode(String parentDeptCode) {
        this.parentDeptCode = parentDeptCode;
    }

    public String getParentDeptName() {
        return parentDeptName;
    }

    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    public Integer getInvalidFlag() {
        return invalidFlag;
    }

    public void setInvalidFlag(Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }

    public String getDeptMobileNo() {
        return deptMobileNo;
    }

    public void setDeptMobileNo(String deptMobileNo) {
        this.deptMobileNo = deptMobileNo;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}