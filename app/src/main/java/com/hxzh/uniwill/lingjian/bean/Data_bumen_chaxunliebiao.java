package com.hxzh.uniwill.lingjian.bean;

/**
 * Created by pang on 2017/4/1.
 *  部门查询列表
 */
public class Data_bumen_chaxunliebiao  {

    /**
     * deptid : 2
     * deptname : 部门1
     * parentid : 0
     * depttype :
     * createtime :
     * updatetime :
     * descinfo :
     */

    private String deptid;
    private String deptname;
    private int parentid;
    private String depttype;
    private String createtime;
    private String updatetime;
    private String descinfo;

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getDepttype() {
        return depttype;
    }

    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getDescinfo() {
        return descinfo;
    }

    public void setDescinfo(String descinfo) {
        this.descinfo = descinfo;
    }
}
