package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/***
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 * <p/>
 * Created by PangHaHa12138 on 2017/5/9.
 */
public class Data_Tubiaotongji {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * starttime : 2017-04-09
         * count : 2017-04-09
         * username : null
         * endtime : 2017-04-30
         * deptid : null
         * allCount : 5
         * sendCount : 0
         * chexiao : 0
         * zanting : 0
         * wan : 2
         * dai : 3
         * yan : 1
         * wanlv : 40%
         * yanlv : 20%
         */

        private String starttime;
        private String count;
        private Object username;
        private String endtime;
        private Object deptid;
        private int allCount;
        private int sendCount;
        private int chexiao;
        private int zanting;
        private int wan;
        private int dai;
        private int yan;
        private String wanlv;
        private String yanlv;

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public Object getDeptid() {
            return deptid;
        }

        public void setDeptid(Object deptid) {
            this.deptid = deptid;
        }

        public int getAllCount() {
            return allCount;
        }

        public void setAllCount(int allCount) {
            this.allCount = allCount;
        }

        public int getSendCount() {
            return sendCount;
        }

        public void setSendCount(int sendCount) {
            this.sendCount = sendCount;
        }

        public int getChexiao() {
            return chexiao;
        }

        public void setChexiao(int chexiao) {
            this.chexiao = chexiao;
        }

        public int getZanting() {
            return zanting;
        }

        public void setZanting(int zanting) {
            this.zanting = zanting;
        }

        public int getWan() {
            return wan;
        }

        public void setWan(int wan) {
            this.wan = wan;
        }

        public int getDai() {
            return dai;
        }

        public void setDai(int dai) {
            this.dai = dai;
        }

        public int getYan() {
            return yan;
        }

        public void setYan(int yan) {
            this.yan = yan;
        }

        public String getWanlv() {
            return wanlv;
        }

        public void setWanlv(String wanlv) {
            this.wanlv = wanlv;
        }

        public String getYanlv() {
            return yanlv;
        }

        public void setYanlv(String yanlv) {
            this.yanlv = yanlv;
        }
    }
}
