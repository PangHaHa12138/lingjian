package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  组织结构图
 */
public class Data_zuzhijiegoutu {


    /**
     * userid : 01a675847feb420b9d1576dc49f92c48
     * deptname : null
     * rolename : null
     * username : 薄晓军
     * usermobile : null
     * sex : 0
     * tasks : [{"task":"name","progress":"","taskstatus":"","endtime":""}]
     * hasChild : false
     * orgs : ["Org1","Org2","Org3"]
     * childcount : 0
     */

    private String userid;
    private Object deptname;
    private Object rolename;
    private String username;
    private Object usermobile;
    private String sex;
    private String hasChild;
    private String childcount;
    private List<TasksBean> tasks;
    private List<String> orgs;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Object getDeptname() {
        return deptname;
    }

    public void setDeptname(Object deptname) {
        this.deptname = deptname;
    }

    public Object getRolename() {
        return rolename;
    }

    public void setRolename(Object rolename) {
        this.rolename = rolename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(Object usermobile) {
        this.usermobile = usermobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }

    public String getChildcount() {
        return childcount;
    }

    public void setChildcount(String childcount) {
        this.childcount = childcount;
    }

    public List<TasksBean> getTasks() {
        return tasks;
    }

    public void setTasks(List<TasksBean> tasks) {
        this.tasks = tasks;
    }

    public List<String> getOrgs() {
        return orgs;
    }

    public void setOrgs(List<String> orgs) {
        this.orgs = orgs;
    }

    public static class TasksBean {
        /**
         * task : name
         * progress :
         * taskstatus :
         * endtime :
         */

        private String task;
        private String progress;
        private String taskstatus;
        private String endtime;

        public String getTask() {
            return task;
        }

        public void setTask(String task) {
            this.task = task;
        }

        public String getProgress() {
            return progress;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }

        public String getTaskstatus() {
            return taskstatus;
        }

        public void setTaskstatus(String taskstatus) {
            this.taskstatus = taskstatus;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }
    }
}
