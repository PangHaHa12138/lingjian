package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/3/31.
 *  用户权限
 */
public class Data_yonghuquanxian {

    /**
     * total : 6
     * list : [{"id":"00ba58bf87954f3394dae51463367f96","sendid":"a84958a279a0463e8997f53a4d703558","sendname":"","receiveid":"d84958a279a0463e8997f53a4d703558","reveivename":""}]
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
         * id : 00ba58bf87954f3394dae51463367f96
         * sendid : a84958a279a0463e8997f53a4d703558
         * sendname :
         * receiveid : d84958a279a0463e8997f53a4d703558
         * reveivename :
         */

        private String id;
        private String sendid;
        private String sendname;
        private String receiveid;
        private String reveivename;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSendid() {
            return sendid;
        }

        public void setSendid(String sendid) {
            this.sendid = sendid;
        }

        public String getSendname() {
            return sendname;
        }

        public void setSendname(String sendname) {
            this.sendname = sendname;
        }

        public String getReceiveid() {
            return receiveid;
        }

        public void setReceiveid(String receiveid) {
            this.receiveid = receiveid;
        }

        public String getReveivename() {
            return reveivename;
        }

        public void setReveivename(String reveivename) {
            this.reveivename = reveivename;
        }
    }
}
