package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  获取指定公司/部门下的人员
 */
public class Data_huoquzhidingbumenrenyuan {

    /**
     * total : 6
     * list : [{"userid":"00ba58bf87954f3394dae51463367f96","deptid":"a84958a279a0463e8997f53a4d703558","deptname":"","roleid":"d84958a279a0463e8997f53a4d703558","rolename":"","username":"","companyid":"","companyname":"","leaderid":"","leadername":"","type":"","sex":"1","usertel":"6502","usermobile":"15810765915","useremail":"yuwy@126.com","createtime":null,"updatetime":null}]
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
         * userid : 00ba58bf87954f3394dae51463367f96
         * deptid : a84958a279a0463e8997f53a4d703558
         * deptname :
         * roleid : d84958a279a0463e8997f53a4d703558
         * rolename :
         * username :
         * companyid :
         * companyname :
         * leaderid :
         * leadername :
         * type :
         * sex : 1
         * usertel : 6502
         * usermobile : 15810765915
         * useremail : yuwy@126.com
         * createtime : null
         * updatetime : null
         */

        private String userid;
        private String deptid;
        private String deptname;
        private String roleid;
        private String rolename;
        private String username;
        private String companyid;
        private String companyname;
        private String leaderid;
        private String leadername;
        private String type;
        private String sex;
        private String usertel;
        private String usermobile;
        private String useremail;
        private Object createtime;
        private Object updatetime;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getDeptid() {
            return deptid;
        }

        public void setDeptid(String deptid) {
            this.deptid = deptid;
        }

        public String getDeptname() {
            return deptname;
        }

        public void setDeptname(String deptname) {
            this.deptname = deptname;
        }

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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCompanyid() {
            return companyid;
        }

        public void setCompanyid(String companyid) {
            this.companyid = companyid;
        }

        public String getCompanyname() {
            return companyname;
        }

        public void setCompanyname(String companyname) {
            this.companyname = companyname;
        }

        public String getLeaderid() {
            return leaderid;
        }

        public void setLeaderid(String leaderid) {
            this.leaderid = leaderid;
        }

        public String getLeadername() {
            return leadername;
        }

        public void setLeadername(String leadername) {
            this.leadername = leadername;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUsertel() {
            return usertel;
        }

        public void setUsertel(String usertel) {
            this.usertel = usertel;
        }

        public String getUsermobile() {
            return usermobile;
        }

        public void setUsermobile(String usermobile) {
            this.usermobile = usermobile;
        }

        public String getUseremail() {
            return useremail;
        }

        public void setUseremail(String useremail) {
            this.useremail = useremail;
        }

        public Object getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Object createtime) {
            this.createtime = createtime;
        }

        public Object getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Object updatetime) {
            this.updatetime = updatetime;
        }
    }
}
