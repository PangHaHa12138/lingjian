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
 * @ClassName: Data_OAshenqinglist
 * @PackageName: com.hxzh.uniwill.lingjian.bean
 * @Create On 2017/7/17 16:10
 * @Author: PangHaHa12138
 * @CSDN: http://blog.csdn.net/panghaha12138
 * @GitHub: https://github.com/PangHaHa12138
 * @jianshu: http://www.jianshu.com/u/4e577623e3f8
 * @Copyrights 2017/7/17 PangHaHa12138 All rights reserved.
 */
public class Data_OAshenqinglist {


    /**
     * total : 16
     * list : [{"wokertype":"报销11","title":"Weeweew","username":"林纯","creatime":"2017-07-17 15:13:21.0","statustype":"1","billid":"eea549730c0f40f6afd888a6c3d82ee3","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"报销11","title":"Eeee","username":"林纯","creatime":"2017-07-17 15:11:47.0","statustype":"1","billid":"eebddcfce56f46af8d4606a46e510d04","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"报销11","title":"愣头青，石乐志","username":"林纯","creatime":"2017-07-17 15:09:15.0","statustype":"1","billid":"cd751111b8274d648b29554abdfc2c05","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"报销11","title":"石乐志","username":"林纯","creatime":"2017-07-17 15:06:30.0","statustype":"1","billid":"cc782fb3505e4168b6ecc89160d16142","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"啊啊啊啊啊","title":"愣头青啊这个人","username":"林纯","creatime":"2017-07-17 15:05:02.0","statustype":"1","billid":"42d06da03e1c432baab18cb0ccd934e0","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"报销11","title":"呵呵哒","username":"林纯","creatime":"2017-07-17 15:02:38.0","statustype":"1","billid":"f931c5fbcb5c4c189848adbf47308b19","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"报销11","title":"测试之呵呵哒","username":"林纯","creatime":"2017-07-17 15:00:56.0","statustype":"1","billid":"d89ca06e591141f790c8a4e837d24cbb","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"报销11","title":"Eeeee","username":"林纯","creatime":"2017-07-17 14:49:02.0","statustype":"1","billid":"140de2eeafc24fa7bab5fe545a1b3ff8","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"报销11","title":"Rrrrrrrr","username":"林纯","creatime":"2017-07-17 14:31:20.0","statustype":"1","billid":"ab0886503ef74d728bc365c5c9c6040f","cusername":null,"cont":null,"step":null,"stick":"0"},{"wokertype":"报销11","title":"Www","username":"林纯","creatime":"2017-07-17 14:28:49.0","statustype":"1","billid":"5502700f98a44fa1ba67dc580e7627b2","cusername":null,"cont":null,"step":null,"stick":"0"}]
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
         * wokertype : 报销11
         * title : Weeweew
         * username : 林纯
         * creatime : 2017-07-17 15:13:21.0
         * statustype : 1
         * billid : eea549730c0f40f6afd888a6c3d82ee3
         * cusername : null
         * cont : null
         * step : null
         * stick : 0
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
