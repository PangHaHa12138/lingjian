package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  任务检索
 */
public class Data_renwujiansuo {


    /**
     * total : 20
     * list : [{"taskid":"0677e1c4655a4637a79b50392dab7fcd","cuserid":"8272165c97234ee2ae7ccaa2037de862","cusername":"贾胜须","taskname":"贾001","yendtime":"20160413","sendtime":null,"createtime":"20160408","excutor":null,"taskstatus":1,"score":10,"childcount":0,"tasks":[]}]
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
         * taskid : 0677e1c4655a4637a79b50392dab7fcd
         * cuserid : 8272165c97234ee2ae7ccaa2037de862
         * cusername : 贾胜须
         * taskname : 贾001
         * yendtime : 20160413
         * sendtime : null
         * createtime : 20160408
         * excutor : null
         * taskstatus : 1
         * score : 10
         * childcount : 0
         * tasks : []
         */

        private String taskid;
        private String cuserid;
        private String cusername;
        private String taskname;
        private String yendtime;
        private Object sendtime;
        private String createtime;
        private Object excutor;
        private int taskstatus;
        private int score;
        private int childcount;
        private List<?> tasks;

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

        public Object getExcutor() {
            return excutor;
        }

        public void setExcutor(Object excutor) {
            this.excutor = excutor;
        }

        public int getTaskstatus() {
            return taskstatus;
        }

        public void setTaskstatus(int taskstatus) {
            this.taskstatus = taskstatus;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getChildcount() {
            return childcount;
        }

        public void setChildcount(int childcount) {
            this.childcount = childcount;
        }

        public List<?> getTasks() {
            return tasks;
        }

        public void setTasks(List<?> tasks) {
            this.tasks = tasks;
        }
    }
}
