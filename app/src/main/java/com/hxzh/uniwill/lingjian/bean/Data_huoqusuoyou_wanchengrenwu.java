package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  获取所有完成任务
 */
public class Data_huoqusuoyou_wanchengrenwu {


    /**
     * total : 108
     * list : [{"taskid":"27fcdea6f0f544ac96cd190a64b3d0eb","execount":1,"cuserid":"d35558c810fd4b9ea3b7482af39ad51d","cusername":"战乃国","taskname":"令箭发布版","yendtime":"2016-06-30","sendtime":"2016-07-06","createtime":"2016-06-12 12:03:28.0","publishTime":"06-12","taskcontent":null,"taskstatus":4,"tasklevel":1,"taskcycle":null,"cycletype":0,"tasktype":1,"childcount":5,"progress":100,"score":0,"assessed":1,"accepted":1,"executors":"[余万一]","from":2,"imageUrl":"http://123.56.97.229/upload/1470106442538.jpg","timeInfo":"","updateTime":null,"updatetime":null,"readed":0,"stick":0}]
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
         * taskid : 27fcdea6f0f544ac96cd190a64b3d0eb
         * execount : 1
         * cuserid : d35558c810fd4b9ea3b7482af39ad51d
         * cusername : 战乃国
         * taskname : 令箭发布版
         * yendtime : 2016-06-30
         * sendtime : 2016-07-06
         * createtime : 2016-06-12 12:03:28.0
         * publishTime : 06-12
         * taskcontent : null
         * taskstatus : 4
         * tasklevel : 1
         * taskcycle : null
         * cycletype : 0
         * tasktype : 1
         * childcount : 5
         * progress : 100
         * score : 0
         * assessed : 1
         * accepted : 1
         * executors : [余万一]
         * from : 2
         * imageUrl : http://123.56.97.229/upload/1470106442538.jpg
         * timeInfo :
         * updateTime : null
         * updatetime : null
         * readed : 0
         * stick : 0
         */

        private String taskid;
        private int execount;
        private String cuserid;
        private String cusername;
        private String taskname;
        private String yendtime;
        private String sendtime;
        private String createtime;
        private String publishTime;
        private Object taskcontent;
        private int taskstatus;
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
        private Object updatetime;
        private int readed;
        private int stick;

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public int getExecount() {
            return execount;
        }

        public void setExecount(int execount) {
            this.execount = execount;
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

        public String getSendtime() {
            return sendtime;
        }

        public void setSendtime(String sendtime) {
            this.sendtime = sendtime;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
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

        public int getTaskstatus() {
            return taskstatus;
        }

        public void setTaskstatus(int taskstatus) {
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

        public Object getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Object updatetime) {
            this.updatetime = updatetime;
        }

        public int getReaded() {
            return readed;
        }

        public void setReaded(int readed) {
            this.readed = readed;
        }

        public int getStick() {
            return stick;
        }

        public void setStick(int stick) {
            this.stick = stick;
        }
    }
}
