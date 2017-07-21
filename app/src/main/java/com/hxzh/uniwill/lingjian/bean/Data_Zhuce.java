package com.hxzh.uniwill.lingjian.bean;

/**
 * Created by pang on 2017/3/31.
 *  注册
 */
public class Data_Zhuce {


    /**
     * result : 1
     * data : {"userid":"00ba58bf87954f3394dae51463367f96","type":"","usermobile":"15810765915"}
     * failcode :
     */

    private String result;
    private DataBean data;
    private String failcode;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getFailcode() {
        return failcode;
    }

    public void setFailcode(String failcode) {
        this.failcode = failcode;
    }

    public static class DataBean {
        /**
         * userid : 00ba58bf87954f3394dae51463367f96
         * type :
         * usermobile : 15810765915
         */

        private String userid;
        private String type;
        private String usermobile;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUsermobile() {
            return usermobile;
        }

        public void setUsermobile(String usermobile) {
            this.usermobile = usermobile;
        }
    }
}
