package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  查询列表部门接收的任务
 */
public class Data_chaxunliebiao_bumenjieshourenwu {

    /**
     * total : 1
     * list : [{"taskid":"7086a9a35c6241a6a816cbb85b853284","cuserid":"b6826d968100491daca06d89bfd95004","cusername":"薄晓军","taskname":"总任务","yendtime":"2016-04-30","sendtime":null,"createtime":"2016-04-08 13:51:52.0","taskstatus":1,"childcount":3,"score":0,"childlist":[{"taskid":"07453b5683714051933e31172c056302","cuserid":"e4c7dbc93a24454aa16e9382f1e69195","cusername":"战乃国","taskname":"分支任务","yendtime":"2016-04-29","sendtime":null,"createtime":"2016-04-08 13:54:01.0","taskstatus":1,"childcount":0,"score":0,"childlist":null}]}]
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
         * taskid : 7086a9a35c6241a6a816cbb85b853284
         * cuserid : b6826d968100491daca06d89bfd95004
         * cusername : 薄晓军
         * taskname : 总任务
         * yendtime : 2016-04-30
         * sendtime : null
         * createtime : 2016-04-08 13:51:52.0
         * taskstatus : 1
         * childcount : 3
         * score : 0
         * childlist : [{"taskid":"07453b5683714051933e31172c056302","cuserid":"e4c7dbc93a24454aa16e9382f1e69195","cusername":"战乃国","taskname":"分支任务","yendtime":"2016-04-29","sendtime":null,"createtime":"2016-04-08 13:54:01.0","taskstatus":1,"childcount":0,"score":0,"childlist":null}]
         */

        private String taskid;
        private String cuserid;
        private String cusername;
        private String taskname;
        private String yendtime;
        private Object sendtime;
        private String createtime;
        private int taskstatus;
        private int childcount;
        private int score;
        private List<ChildlistBean> childlist;

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public String getCuserid() {
            return cuserid;
        }

        public void setCuserid(String cuserid) {
            this.cuserid = cuserid;
        }

        public String getCusername() {
            return cusername;
        }

        public void setCusername(String cusername) {
            this.cusername = cusername;
        }

        public String getTaskname() {
            return taskname;
        }

        public void setTaskname(String taskname) {
            this.taskname = taskname;
        }

        public String getYendtime() {
            return yendtime;
        }

        public void setYendtime(String yendtime) {
            this.yendtime = yendtime;
        }

        public Object getSendtime() {
            return sendtime;
        }

        public void setSendtime(Object sendtime) {
            this.sendtime = sendtime;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getTaskstatus() {
            return taskstatus;
        }

        public void setTaskstatus(int taskstatus) {
            this.taskstatus = taskstatus;
        }

        public int getChildcount() {
            return childcount;
        }

        public void setChildcount(int childcount) {
            this.childcount = childcount;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public List<ChildlistBean> getChildlist() {
            return childlist;
        }

        public void setChildlist(List<ChildlistBean> childlist) {
            this.childlist = childlist;
        }

        public static class ChildlistBean {
            /**
             * taskid : 07453b5683714051933e31172c056302
             * cuserid : e4c7dbc93a24454aa16e9382f1e69195
             * cusername : 战乃国
             * taskname : 分支任务
             * yendtime : 2016-04-29
             * sendtime : null
             * createtime : 2016-04-08 13:54:01.0
             * taskstatus : 1
             * childcount : 0
             * score : 0
             * childlist : null
             */

            private String taskid;
            private String cuserid;
            private String cusername;
            private String taskname;
            private String yendtime;
            private Object sendtime;
            private String createtime;
            private int taskstatus;
            private int childcount;
            private int score;
            private Object childlist;

            public String getTaskid() {
                return taskid;
            }

            public void setTaskid(String taskid) {
                this.taskid = taskid;
            }

            public String getCuserid() {
                return cuserid;
            }

            public void setCuserid(String cuserid) {
                this.cuserid = cuserid;
            }

            public String getCusername() {
                return cusername;
            }

            public void setCusername(String cusername) {
                this.cusername = cusername;
            }

            public String getTaskname() {
                return taskname;
            }

            public void setTaskname(String taskname) {
                this.taskname = taskname;
            }

            public String getYendtime() {
                return yendtime;
            }

            public void setYendtime(String yendtime) {
                this.yendtime = yendtime;
            }

            public Object getSendtime() {
                return sendtime;
            }

            public void setSendtime(Object sendtime) {
                this.sendtime = sendtime;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public int getTaskstatus() {
                return taskstatus;
            }

            public void setTaskstatus(int taskstatus) {
                this.taskstatus = taskstatus;
            }

            public int getChildcount() {
                return childcount;
            }

            public void setChildcount(int childcount) {
                this.childcount = childcount;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public Object getChildlist() {
                return childlist;
            }

            public void setChildlist(Object childlist) {
                this.childlist = childlist;
            }
        }
    }
}
