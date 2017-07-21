package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  查询列表-发出的任务
 */
public class Data_chaxunliebiao_faburenwu {


    /**
     * total : 17
     * list : [{"taskid":"f4ae09cb22b9416d8e2e2f2682494641","execount":3,"cuserid":"d35558c810fd4b9ea3b7482af39ad51d","cusername":"战乃国","taskname":"令箭/18包/19包项目周报","yendtime":"2017-05-12","sendtime":null,"createtime":"2017-05-06 00:05:00.0","publishTime":"05-06","taskcontent":null,"taskstatus":3,"tasklevel":4,"taskcycle":"星期五","cycletype":2,"tasktype":1,"childcount":0,"progress":33,"score":0,"assessed":0,"accepted":1,"executors":"李蕾,王爱亭,秦自勉","from":1,"imageUrl":"http://123.56.97.229/upload/1468552674136.jpg","timeInfo":"-12","updateTime":null,"updatetime":null,"zi":null,"readed":0,"stick":0},{"taskid":"cd2d3b594ce64009ab5af5e575a39bca","execount":1,"cuserid":"d35558c810fd4b9ea3b7482af39ad51d","cusername":"战乃国","taskname":"令箭开发","yendtime":"2017-05-03","sendtime":null,"createtime":"2017-05-03 11:37:45.0","publishTime":"05-03","taskcontent":null,"taskstatus":3,"tasklevel":4,"taskcycle":null,"cycletype":0,"tasktype":1,"childcount":0,"progress":46,"score":0,"assessed":0,"accepted":1,"executors":"战乃国","from":1,"imageUrl":"http://123.56.97.229/upload/1468552674136.jpg","timeInfo":"-21","updateTime":null,"updatetime":null,"zi":null,"readed":0,"stick":0},{"taskid":"e4a384b874304d57b1d6faafa7e3fa5d","execount":1,"cuserid":"d35558c810fd4b9ea3b7482af39ad51d","cusername":"战乃国","taskname":"日常事务周报","yendtime":"2017-05-05","sendtime":null,"createtime":"2017-04-29 00:05:00.0","publishTime":"04-29","taskcontent":null,"taskstatus":3,"tasklevel":6,"taskcycle":null,"cycletype":2,"tasktype":1,"childcount":0,"progress":0,"score":0,"assessed":0,"accepted":1,"executors":"游平华","from":1,"imageUrl":"http://123.56.97.229/upload/1468552674136.jpg","timeInfo":"-19","updateTime":null,"updatetime":null,"zi":null,"readed":0,"stick":0},{"taskid":"0155b1e7121f42958641236091fcd82a","execount":3,"cuserid":"d35558c810fd4b9ea3b7482af39ad51d","cusername":"战乃国","taskname":"令箭/18包/19包项目周报","yendtime":"2017-05-05","sendtime":null,"createtime":"2017-04-29 00:05:00.0","publishTime":"04-29","taskcontent":null,"taskstatus":3,"tasklevel":4,"taskcycle":null,"cycletype":2,"tasktype":1,"childcount":0,"progress":33,"score":0,"assessed":0,"accepted":1,"executors":"李蕾,王爱亭,秦自勉","from":1,"imageUrl":"http://123.56.97.229/upload/1468552674136.jpg","timeInfo":"-19","updateTime":null,"updatetime":null,"zi":null,"readed":0,"stick":0},{"taskid":"7005d3b461b94b5f9b461ff3beab354c","execount":1,"cuserid":"d35558c810fd4b9ea3b7482af39ad51d","cusername":"战乃国","taskname":"日常事务周报","yendtime":"2017-04-28","sendtime":null,"createtime":"2017-04-27 10:03:09.0","publishTime":"04-27","taskcontent":null,"taskstatus":3,"tasklevel":6,"taskcycle":null,"cycletype":2,"tasktype":1,"childcount":0,"progress":0,"score":0,"assessed":0,"accepted":1,"executors":"游平华","from":1,"imageUrl":"http://123.56.97.229/upload/1468552674136.jpg","timeInfo":"-26","updateTime":null,"updatetime":null,"zi":null,"readed":0,"stick":0},{"taskid":"48b90322df654362bf4da8c69d3c1a45","execount":1,"cuserid":"d35558c810fd4b9ea3b7482af39ad51d","cusername":"战乃国","taskname":"测试－子任务","yendtime":"2017-04-28","sendtime":null,"createtime":"2017-04-26 10:56:26.0","publishTime":"04-26","taskcontent":null,"taskstatus":3,"tasklevel":4,"taskcycle":null,"cycletype":0,"tasktype":1,"childcount":0,"progress":100,"score":0,"assessed":0,"accepted":1,"executors":"秦自勉","from":1,"imageUrl":"http://123.56.97.229/upload/1468552674136.jpg","timeInfo":"-26","updateTime":null,"updatetime":null,"zi":null,"readed":0,"stick":0},{"taskid":"4436745e5c194fc6b2ae8dc1007f5d09","execount":3,"cuserid":"d35558c810fd4b9ea3b7482af39ad51d","cusername":"战乃国","taskname":"令箭/18包/19包项目周报","yendtime":"2017-04-28","sendtime":null,"createtime":"2017-04-25 11:28:59.0","publishTime":"04-25","taskcontent":null,"taskstatus":3,"tasklevel":4,"taskcycle":null,"cycletype":2,"tasktype":1,"childcount":0,"progress":60,"score":0,"assessed":0,"accepted":1,"executors":"李蕾,王爱亭,秦自勉","from":1,"imageUrl":"http://123.56.97.229/upload/1468552674136.jpg","timeInfo":"-26","updateTime":null,"updatetime":null,"zi":null,"readed":1,"stick":0}]
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
         * taskid : f4ae09cb22b9416d8e2e2f2682494641
         * execount : 3
         * cuserid : d35558c810fd4b9ea3b7482af39ad51d
         * cusername : 战乃国
         * taskname : 令箭/18包/19包项目周报
         * yendtime : 2017-05-12
         * sendtime : null
         * createtime : 2017-05-06 00:05:00.0
         * publishTime : 05-06
         * taskcontent : null
         * taskstatus : 3
         * tasklevel : 4
         * taskcycle : 星期五
         * cycletype : 2
         * tasktype : 1
         * childcount : 0
         * progress : 33
         * score : 0
         * assessed : 0
         * accepted : 1
         * executors : 李蕾,王爱亭,秦自勉
         * from : 1
         * imageUrl : http://123.56.97.229/upload/1468552674136.jpg
         * timeInfo : -12
         * updateTime : null
         * updatetime : null
         * zi : null
         * readed : 0
         * stick : 0
         */

        private String taskid;
        private int execount;
        private String cuserid;
        private String cusername;
        private String taskname;
        private String yendtime;
        private Object sendtime;
        private String createtime;
        private String publishTime;
        private Object taskcontent;
        private int taskstatus;
        private int tasklevel;
        private String taskcycle;
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
        private Object zi;
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

        public String getTaskcycle() {
            return taskcycle;
        }

        public void setTaskcycle(String taskcycle) {
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

        public Object getZi() {
            return zi;
        }

        public void setZi(Object zi) {
            this.zi = zi;
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
