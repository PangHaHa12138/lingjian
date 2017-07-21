package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/7.
 *  添加责任人
 */
public class Data_tianjiazerenren {


    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * deptname : 软件开发部
         * list : [{"userid":"","username":"","avatar":"http: //192.168.6.138: 8080/image/1469087130352.jpg","pinyin":"liuzhe"},{"userid":"","username":""}]
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
             * userid :
             * username :
             * avatar : http: //192.168.6.138: 8080/image/1469087130352.jpg
             * pinyin : liuzhe
             */

            private String userid;
            private String username;
            private String avatar;
            private String pinyin;

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getPinyin() {
                return pinyin;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }
        }
    }
}
