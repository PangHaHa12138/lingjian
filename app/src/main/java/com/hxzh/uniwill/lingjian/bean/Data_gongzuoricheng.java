package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  工作日程
 */
public class Data_gongzuoricheng {


    /**
     * total : 1
     * list : [{"taskid":"7086a9a35c6241a6a816cbb85b853284","cuserid":"b6826d968100491daca06d89bfd95004","cusername":"薄晓军","taskname":"总任务","yendtime":"2016-04-30","sendtime":null,"createtime":"2016-04-08 13:51:52.0","taskstatus":1}]
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
         * taskid : 7086a9a35c6241a6a816cbb85b853284
         * cuserid : b6826d968100491daca06d89bfd95004
         * cusername : 薄晓军
         * taskname : 总任务
         * yendtime : 2016-04-30
         * sendtime : null
         * createtime : 2016-04-08 13:51:52.0
         * taskstatus : 1
         */

        private String taskid;
        private String cuserid;
        private String cusername;
        private String taskname;
        private String yendtime;
        private Object sendtime;
        private String createtime;
        private int taskstatus;

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
    }
}
