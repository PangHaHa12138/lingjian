package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  任务统计
 */
public class Data_renwutongji {


    /**
     * total : 100
     * count1 : 1
     * count2 : 1
     * count3 : 1
     * count4 : 1
     * list : [{"count":"","deptname":"部门1","deptid":"","normal":"1","finish":"2","again":"3","delay":"4"}]
     */

    private String total;
    private String count1;
    private String count2;
    private String count3;
    private String count4;
    private List<ListBean> list;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCount1() {
        return count1;
    }

    public void setCount1(String count1) {
        this.count1 = count1;
    }

    public String getCount2() {
        return count2;
    }

    public void setCount2(String count2) {
        this.count2 = count2;
    }

    public String getCount3() {
        return count3;
    }

    public void setCount3(String count3) {
        this.count3 = count3;
    }

    public String getCount4() {
        return count4;
    }

    public void setCount4(String count4) {
        this.count4 = count4;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * count :
         * deptname : 部门1
         * deptid :
         * normal : 1
         * finish : 2
         * again : 3
         * delay : 4
         */

        private String count;
        private String deptname;
        private String deptid;
        private String normal;
        private String finish;
        private String again;
        private String delay;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getDeptname() {
            return deptname;
        }

        public void setDeptname(String deptname) {
            this.deptname = deptname;
        }

        public String getDeptid() {
            return deptid;
        }

        public void setDeptid(String deptid) {
            this.deptid = deptid;
        }

        public String getNormal() {
            return normal;
        }

        public void setNormal(String normal) {
            this.normal = normal;
        }

        public String getFinish() {
            return finish;
        }

        public void setFinish(String finish) {
            this.finish = finish;
        }

        public String getAgain() {
            return again;
        }

        public void setAgain(String again) {
            this.again = again;
        }

        public String getDelay() {
            return delay;
        }

        public void setDelay(String delay) {
            this.delay = delay;
        }
    }
}
