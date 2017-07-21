package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  根据id 获取部门任务
 */
public class Data_genju_Id_huoqubumenrenwu {


    /**
     * total : 17
     * result : 1
     * list : [{"taskid":null,"cuserid":null,"cusername":null,"taskname":null,"yendtime":"2016-06-13","sendtime":null,"createtime":null,"publishTime":"06-13","taskcontent":null,"taskstatus":null,"tasklevel":0,"taskcycle":null,"cycletype":0,"tasktype":0,"childcount":0,"progress":0,"score":0,"assessed":0,"accepted":1,"executors":"[战乃国]","from":1,"imageUrl":"http://123.56.97.229/upload/default1.jpg","timeInfo":"","updateTime":null}]
     */

    private int total;
    private String result;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * taskid : null
         * cuserid : null
         * cusername : null
         * taskname : null
         * yendtime : 2016-06-13
         * sendtime : null
         * createtime : null
         * publishTime : 06-13
         * taskcontent : null
         * taskstatus : null
         * tasklevel : 0
         * taskcycle : null
         * cycletype : 0
         * tasktype : 0
         * childcount : 0
         * progress : 0
         * score : 0
         * assessed : 0
         * accepted : 1
         * executors : [战乃国]
         * from : 1
         * imageUrl : http://123.56.97.229/upload/default1.jpg
         * timeInfo :
         * updateTime : null
         */

        private Object taskid;
        private Object cuserid;
        private Object cusername;
        private Object taskname;
        private String yendtime;
        private Object sendtime;
        private Object createtime;
        private String publishTime;
        private Object taskcontent;
        private Object taskstatus;
        private int tasklevel;
        private Object taskcycle;
        private int cycletype;
        private int tasktype;
        private int childcount;
        private int progress;
        private int score;
        private int assessed;
        private int accepted;
        private String executors;
        private int from;
        private String imageUrl;
        private String timeInfo;
        private Object updateTime;

        public Object getTaskid() {
            return taskid;
        }

        public void setTaskid(Object taskid) {
            this.taskid = taskid;
        }

        public Object getCuserid() {
            return cuserid;
        }

        public void setCuserid(Object cuserid) {
            this.cuserid = cuserid;
        }

        public Object getCusername() {
            return cusername;
        }

        public void setCusername(Object cusername) {
            this.cusername = cusername;
        }

        public Object getTaskname() {
            return taskname;
        }

        public void setTaskname(Object taskname) {
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

        public Object getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Object createtime) {
            this.createtime = createtime;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public Object getTaskcontent() {
            return taskcontent;
        }

        public void setTaskcontent(Object taskcontent) {
            this.taskcontent = taskcontent;
        }

        public Object getTaskstatus() {
            return taskstatus;
        }

        public void setTaskstatus(Object taskstatus) {
            this.taskstatus = taskstatus;
        }

        public int getTasklevel() {
            return tasklevel;
        }

        public void setTasklevel(int tasklevel) {
            this.tasklevel = tasklevel;
        }

        public Object getTaskcycle() {
            return taskcycle;
        }

        public void setTaskcycle(Object taskcycle) {
            this.taskcycle = taskcycle;
        }

        public int getCycletype() {
            return cycletype;
        }

        public void setCycletype(int cycletype) {
            this.cycletype = cycletype;
        }

        public int getTasktype() {
            return tasktype;
        }

        public void setTasktype(int tasktype) {
            this.tasktype = tasktype;
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

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTimeInfo() {
            return timeInfo;
        }

        public void setTimeInfo(String timeInfo) {
            this.timeInfo = timeInfo;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }
    }
}
