package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  收到未完成任务
 */
public class Data_shoudaoweiwanchengrenwu {


    /**
     * total : 4
     * list : [{"taskname":"测试001","endtime":"2016-04-30","status":1},{"taskname":"测试002","endtime":"2016-04-08","status":3},{"taskname":"贾001","endtime":"2016-04-13","status":1},{"taskname":"分支任务","endtime":"2016-04-29","status":1}]
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
         * taskname : 测试001
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
