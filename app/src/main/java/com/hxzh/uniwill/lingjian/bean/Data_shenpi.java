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
 * @ClassName: Data_shenpi
 * @PackageName: com.hxzh.uniwill.lingjian.bean
 * @Create On 2017/7/18 11:55
 * @Author: PangHaHa12138
 * @CSDN: http://blog.csdn.net/panghaha12138
 * @GitHub: https://github.com/PangHaHa12138
 * @jianshu: http://www.jianshu.com/u/4e577623e3f8
 * @Copyrights 2017/7/18 PangHaHa12138 All rights reserved.
 */
public class Data_shenpi {


    /**
     * total : 1
     * list : [{"wokertype":"凤飞飞","title":"测试","username":"战乃国","creatime":"2017-07-17 09:57:07.0","statustype":"2","billid":"2ca1f731513c4ffa9b83df5b6d61692a","cusername":null,"cont":null,"step":null,"stick":null}]
     */

    private String total;
    private List<ListBean> list;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
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
         * wokertype : 凤飞飞
         * title : 测试
         * username : 战乃国
         * creatime : 2017-07-17 09:57:07.0
         * statustype : 2
         * billid : 2ca1f731513c4ffa9b83df5b6d61692a
         * cusername : null
         * cont : null
         * step : null
         * stick : null
         */

        private String wokertype;
        private String title;
        private String username;
        private String creatime;
        private String statustype;
        private String billid;
        private Object cusername;
        private Object cont;
        private Object step;
        private String stick;

        public String getWokertype() {
            return wokertype;
        }

        public void setWokertype(String wokertype) {
            this.wokertype = wokertype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCreatime() {
            return creatime;
        }

        public void setCreatime(String creatime) {
            this.creatime = creatime;
        }

        public String getStatustype() {
            return statustype;
        }

        public void setStatustype(String statustype) {
            this.statustype = statustype;
        }

        public String getBillid() {
            return billid;
        }

        public void setBillid(String billid) {
            this.billid = billid;
        }

        public Object getCusername() {
            return cusername;
        }

        public void setCusername(Object cusername) {
            this.cusername = cusername;
        }

        public Object getCont() {
            return cont;
        }

        public void setCont(Object cont) {
            this.cont = cont;
        }

        public Object getStep() {
            return step;
        }

        public void setStep(Object step) {
            this.step = step;
        }

        public String getStick() {
            return stick;
        }

        public void setStick(String stick) {
            this.stick = stick;
        }
    }
}
