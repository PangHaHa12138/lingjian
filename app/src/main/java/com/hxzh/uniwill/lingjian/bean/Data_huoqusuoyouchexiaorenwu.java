package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  获取所有撤销任务
 */
public class Data_huoqusuoyouchexiaorenwu {


    /**
     * total : 5
     * list : [{"taskid":"b391b41ebfd14592bd284c97b28cff63","cuserid":"45fcbf917a8948ea9f40e27027031f34","cusername":"战乃国","taskname":"ff","yendtime":"2016-05-13","sendtime":null,"createtime":"2016-05-06 09:10:04.0","taskstatus":3,"childcount":1,"progress":0,"from":1,"publishTime":"\u201d\u201d","score":0,"assessed":0,"accepted":1,"executors":"[李蕾]"}]
     */

    private int total;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * taskid : b391b41ebfd14592bd284c97b28cff63
         * cuserid : 45fcbf917a8948ea9f40e27027031f34
         * cusername : 战乃国
         * taskname : ff
         * yendtime : 2016-05-13
         * sendtime : null
         * createtime : 2016-05-06 09:10:04.0
         * taskstatus : 3
         * childcount : 1
         * progress : 0
         * from : 1
         * publishTime : ””
         * score : 0
         * assessed : 0
         * accepted : 1
         * executors : [李蕾]
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
        private int from;
        private String publishTime;
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

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
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
