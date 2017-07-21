package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  根据部门id 查询列表
 */
public class Data_bumen_id_chaxunliebiao {


    /**
     * total : 6
     * list : [{"roleid":"a84958a279a0463e8997f53a4d703558","rolename":""}]
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
         * roleid : a84958a279a0463e8997f53a4d703558
         * rolename :
         */

        private String roleid;
        private String rolename;

        public String getRoleid() {
            return roleid;
        }

        public void setRoleid(String roleid) {
            this.roleid = roleid;
        }

        public String getRolename() {
            return rolename;
        }

        public void setRolename(String rolename) {
            this.rolename = rolename;
        }
    }
}
