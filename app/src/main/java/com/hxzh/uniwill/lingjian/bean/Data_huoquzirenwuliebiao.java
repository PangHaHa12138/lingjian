package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  获取子任务列表
 */
public class Data_huoquzirenwuliebiao {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * taskid : 6825de489bbd417e80d787c9ccab65c5
         * cuserid : e4d3d16ca8334894a71a48cdc4297c7c
         * cusername : 李蕾
         * taskname : erer
         * yendtime : 2016-05-11
         * sendtime : null
         * createtime : 2016-05-06 13:18:02.0
         * taskstatus : 3
         * childcount : 0
         * progress : 0
         * score : 0
         * assessed : 0
         * accepted : 0
         * executors : [李艳]
         */

        private String taskid;
        private String cuserid;
        private String cusername;
        private String taskname;
        private String yendtime;
        private Object sendtime;
        private String createtime;
        private int taskstatus;
        private int childcount;
        private int progress;
        private int score;
        private int assessed;
        private int accepted;
        private String executors;

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public String getCuserid() {
            return cuserid;
        }

        public void setCuserid(String cuserid) {
            this.cuserid = cuserid;
        }

        public String getCusername() {
            return cusername;
        }

        public void setCusername(String cusername) {
            this.cusername = cusername;
        }

        public String getTaskname() {
            return taskname;
        }

        public void setTaskname(String taskname) {
            this.taskname = taskname;
        }

        public String getYendtime() {
            return yendtime;
        }

        public void setYendtime(String yendtime) {
            this.yendtime = yendtime;
        }

        public Object getSendtime() {
            return sendtime;
        }

        public void setSendtime(Object sendtime) {
            this.sendtime = sendtime;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getTaskstatus() {
            return taskstatus;
        }

        public void setTaskstatus(int taskstatus) {
            this.taskstatus = taskstatus;
        }

        public int getChildcount() {
            return childcount;
        }

        public void setChildcount(int childcount) {
            this.childcount = childcount;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getAssessed() {
            return assessed;
        }

        public void setAssessed(int assessed) {
            this.assessed = assessed;
        }

        public int getAccepted() {
            return accepted;
        }

        public void setAccepted(int accepted) {
            this.accepted = accepted;
        }

        public String getExecutors() {
            return executors;
        }

        public void setExecutors(String executors) {
            this.executors = executors;
        }
    }
}
