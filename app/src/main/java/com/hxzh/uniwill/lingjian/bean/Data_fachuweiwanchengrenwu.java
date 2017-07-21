package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  发出的未完成任务
 */
public class Data_fachuweiwanchengrenwu {


    /**
     * total : 3
     * list : [{"taskname":"余002","endtime":"2016-04-30","status":1},{"taskname":"余001","endtime":"2016-04-17","status":1},{"taskname":"分支3","endtime":"2016-04-28","status":3}]
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
         * taskname : 余002
         * endtime : 2016-04-30
         * status : 1
         */

        private String taskname;
        private String endtime;
        private int status;

        public String getTaskname() {
            return taskname;
        }

        public void setTaskname(String taskname) {
            this.taskname = taskname;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
