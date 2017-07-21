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
 * @ClassName: Data_oashenqingdell
 * @PackageName: com.hxzh.uniwill.lingjian.bean
 * @Create On 2017/7/18 14:50
 * @Author: PangHaHa12138
 * @CSDN: http://blog.csdn.net/panghaha12138
 * @GitHub: https://github.com/PangHaHa12138
 * @jianshu: http://www.jianshu.com/u/4e577623e3f8
 * @Copyrights 2017/7/18 PangHaHa12138 All rights reserved.
 */
public class Data_oashenqingdell {


    /**
     * listAcc : [{"id":null,"userid":null,"creatime":"2017-07-18 15:51:12.0","address":"http://123.56.97.229/upload/2017071991551829/1500092626602.jpg","type":null,"name":"1500092626602.jpg","suffix":null,"dizi":null,"wenid":0,"picture":null,"username":null}]
     * bill : [{"wokertype":"报销11","title":"红鲤鱼与绿鲤鱼与鱼","username":"战乃国","creatime":"2017-07-18 15:51:11.0","statustype":"1","billid":"5a115b0286ab4d40a13b5aa9bdfc7db0","cusername":"林纯","cont":"和嘿嘿嘿嘿嘿嘿","step":"1","stick":null}]
     * reuslt : 1
     */

    private int reuslt;
    private List<ListAccBean> listAcc;
    private List<BillBean> bill;

    public int getReuslt() {
        return reuslt;
    }

    public void setReuslt(int reuslt) {
        this.reuslt = reuslt;
    }

    public List<ListAccBean> getListAcc() {
        return listAcc;
    }

    public void setListAcc(List<ListAccBean> listAcc) {
        this.listAcc = listAcc;
    }

    public List<BillBean> getBill() {
        return bill;
    }

    public void setBill(List<BillBean> bill) {
        this.bill = bill;
    }

    public static class ListAccBean {
        /**
         * id : null
         * userid : null
         * creatime : 2017-07-18 15:51:12.0
         * address : http://123.56.97.229/upload/2017071991551829/1500092626602.jpg
         * type : null
         * name : 1500092626602.jpg
         * suffix : null
         * dizi : null
         * wenid : 0
         * picture : null
         * username : null
         */

        private Object id;
        private Object userid;
        private String creatime;
        private String address;
        private Object type;
        private String name;
        private Object suffix;
        private Object dizi;
        private int wenid;
        private Object picture;
        private Object username;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getUserid() {
            return userid;
        }

        public void setUserid(Object userid) {
            this.userid = userid;
        }

        public String getCreatime() {
            return creatime;
        }

        public void setCreatime(String creatime) {
            this.creatime = creatime;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getSuffix() {
            return suffix;
        }

        public void setSuffix(Object suffix) {
            this.suffix = suffix;
        }

        public Object getDizi() {
            return dizi;
        }

        public void setDizi(Object dizi) {
            this.dizi = dizi;
        }

        public int getWenid() {
            return wenid;
        }

        public void setWenid(int wenid) {
            this.wenid = wenid;
        }

        public Object getPicture() {
            return picture;
        }

        public void setPicture(Object picture) {
            this.picture = picture;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }
    }

    public static class BillBean {
        /**
         * wokertype : 报销11
         * title : 红鲤鱼与绿鲤鱼与鱼
         * username : 战乃国
         * creatime : 2017-07-18 15:51:11.0
         * statustype : 1
         * billid : 5a115b0286ab4d40a13b5aa9bdfc7db0
         * cusername : 林纯
         * cont : 和嘿嘿嘿嘿嘿嘿
         * step : 1
         * stick : null
         */

        private String wokertype;
        private String title;
        private String username;
        private String creatime;
        private String statustype;
        private String billid;
        private String cusername;
        private String cont;
        private String step;
        private Object stick;

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

        public String getCusername() {
            return cusername;
        }

        public void setCusername(String cusername) {
            this.cusername = cusername;
        }

        public String getCont() {
            return cont;
        }

        public void setCont(String cont) {
            this.cont = cont;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }

        public Object getStick() {
            return stick;
        }

        public void setStick(Object stick) {
            this.stick = stick;
        }
    }
}
