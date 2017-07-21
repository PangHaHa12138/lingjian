package com.hxzh.uniwill.lingjian.bean;

/**
 * Created by pang on 2017/4/1.
 * 获取登录者管理的部门/公司
 */

public class Data_huoqudengluzhe_guanlidebumen {


    /**
     * total : 6
     * list : [{"deptid":"00ba58bf87954f3394dae51463367f96"," deptname ":"","depttype":""}]
     */

    private int total;
    private java.util.List<ListBean> list;

    public static class ListBean {
        /**
         * deptid : 00ba58bf87954f3394dae51463367f96
         *  deptname  :
         * depttype :
         */

        private String deptid;
        private String deptname;
        private String depttype;

        public String getDeptid() {
            return deptid;
        }

        public void setDeptid(String deptid) {
            this.deptid = deptid;
        }
    }
}
