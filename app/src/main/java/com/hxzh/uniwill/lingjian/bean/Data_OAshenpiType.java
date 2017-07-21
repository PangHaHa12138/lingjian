package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
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
 *
 * @ClassName: Data_OAshenpiType
 * @PackageName: com.hxzh.uniwill.lingjian.bean
 * @Create On 2017/7/14 15:54
 * @Author: PangHaHa12138
 * @CSDN: http://blog.csdn.net/panghaha12138
 * @GitHub: https://github.com/PangHaHa12138
 * @jianshu: http://www.jianshu.com/u/4e577623e3f8
 * @Copyrights 2017/7/14 PangHaHa12138 All rights reserved.
 */
public class Data_OAshenpiType {


    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * list : [{"workid":"11979ca681f14c659d6b1bb6b522a15a","wokername":"11的","wokertype":"报销11","creatime":"2017-07-14 10:20:30.0","deptid":"-1","content":"地方的负担","delete":"1","septcount":1}]
         * deptname : 公司
         */

        private String deptname;
        private List<ListBean> list;

        public String getDeptname() {
            return deptname;
        }

        public void setDeptname(String deptname) {
            this.deptname = deptname;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * workid : 11979ca681f14c659d6b1bb6b522a15a
             * wokername : 11的
             * wokertype : 报销11
             * creatime : 2017-07-14 10:20:30.0
             * deptid : -1
             * content : 地方的负担
             * delete : 1
             * septcount : 1
             */

            private String workid;
            private String wokername;
            private String wokertype;
            private String creatime;
            private String deptid;
            private String content;
            private String delete;
            private int septcount;

            private int isSelect = 1;//1不选，2选中

            public int getIsSelect() {
                return isSelect;
            }

            public void setIsSelect(int isSelect) {
                this.isSelect = isSelect;
            }

            public String getWorkid() {
                return workid;
            }

            public void setWorkid(String workid) {
                this.workid = workid;
            }

            public String getWokername() {
                return wokername;
            }

            public void setWokername(String wokername) {
                this.wokername = wokername;
            }

            public String getWokertype() {
                return wokertype;
            }

            public void setWokertype(String wokertype) {
                this.wokertype = wokertype;
            }

            public String getCreatime() {
                return creatime;
            }

            public void setCreatime(String creatime) {
                this.creatime = creatime;
            }

            public String getDeptid() {
                return deptid;
            }

            public void setDeptid(String deptid) {
                this.deptid = deptid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDelete() {
                return delete;
            }

            public void setDelete(String delete) {
                this.delete = delete;
            }

            public int getSeptcount() {
                return septcount;
            }

            public void setSeptcount(int septcount) {
                this.septcount = septcount;
            }
        }
    }
}
