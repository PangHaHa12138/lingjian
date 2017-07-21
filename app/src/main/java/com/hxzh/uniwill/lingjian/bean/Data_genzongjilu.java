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
 * @ClassName: Data_genzongjilu
 * @PackageName: com.hxzh.uniwill.lingjian.bean
 * @Create On 2017/7/19 11:14
 * @Author: PangHaHa12138
 * @CSDN: http://blog.csdn.net/panghaha12138
 * @GitHub: https://github.com/PangHaHa12138
 * @jianshu: http://www.jianshu.com/u/4e577623e3f8
 * @Copyrights 2017/7/19 PangHaHa12138 All rights reserved.
 */
public class Data_genzongjilu {


    /**
     * examine : [{"billid":"842205965e3c440bbc438a173a5ed76e","userid":"d35558c810fd4b9ea3b7482af39ad51d","creatime":"2017-07-18 15:38:50.0","username":"战乃国","advise":"工单创建","step":0,"type":"2"}]
     * reuslt : 1
     */

    private int reuslt;
    private List<ExamineBean> examine;

    public int getReuslt() {
        return reuslt;
    }

    public void setReuslt(int reuslt) {
        this.reuslt = reuslt;
    }

    public List<ExamineBean> getExamine() {
        return examine;
    }

    public void setExamine(List<ExamineBean> examine) {
        this.examine = examine;
    }

    public static class ExamineBean {
        /**
         * billid : 842205965e3c440bbc438a173a5ed76e
         * userid : d35558c810fd4b9ea3b7482af39ad51d
         * creatime : 2017-07-18 15:38:50.0
         * username : 战乃国
         * advise : 工单创建
         * step : 0
         * type : 2
         */

        private String billid;
        private String userid;
        private String creatime;
        private String username;
        private String advise;
        private int step;
        private String type;

        public String getBillid() {
            return billid;
        }

        public void setBillid(String billid) {
            this.billid = billid;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getCreatime() {
            return creatime;
        }

        public void setCreatime(String creatime) {
            this.creatime = creatime;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAdvise() {
            return advise;
        }

        public void setAdvise(String advise) {
            this.advise = advise;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
