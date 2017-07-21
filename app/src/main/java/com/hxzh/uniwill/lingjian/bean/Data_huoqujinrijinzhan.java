package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  获取今日进展
 */
public class Data_huoqujinrijinzhan {


    /**
     * count : 1
     * today : 2016-07-07
     * list : [{"taskid":"0dfa6ac8c1b846ffbc98110656e42791","taskname":"Zrw aaa","progress":100,"reporttime":"2016-07-07"},{"taskid":"c2b8334785f7427daff5768af8a1ed92","taskname":"Fsdjldskfjlskdj","progress":57,"reporttime":"2016-07-06"},{"taskid":"0b9a1ab00553401db7d9ba0cfa86492c","taskname":"CEO","progress":100,"reporttime":"2016-07-06"}]
     */

    private int count;
    private String today;
    private List<ListBean> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * taskid : 0dfa6ac8c1b846ffbc98110656e42791
         * taskname : Zrw aaa
         * progress : 100
         * reporttime : 2016-07-07
         */

        private String taskid;
        private String taskname;
        private int progress;
        private String reporttime;

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public String getTaskname() {
            return taskname;
        }

        public void setTaskname(String taskname) {
            this.taskname = taskname;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public String getReporttime() {
            return reporttime;
        }

        public void setReporttime(String reporttime) {
            this.reporttime = reporttime;
        }
    }
}
