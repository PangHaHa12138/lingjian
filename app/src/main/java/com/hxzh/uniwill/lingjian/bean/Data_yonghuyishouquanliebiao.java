package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  用户已授权列表
 */
public class Data_yonghuyishouquanliebiao {


    /**
     * total : 1
     * list : [{"receiveid":"2","reveivename":"test"}]
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
         * receiveid : 2
         * reveivename : test
         */

        private String receiveid;
        private String reveivename;

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
