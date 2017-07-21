package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  查询任务消息列表
 */
public class Data_chaxunrenwu_xiaoxiliebiao {


    /**
     * total : 13
     * list : [{"id":"b1ca83f27bb943cf85e0ad3b75625f59","title":"测试附件1319，任务上报！","content":"测试附件二","type":5,"askContent":"测试附件二","askTime":"2017-05-23 14:12:32","taskName":"测试附件1319","readed":0,"creator":"庞世宇","receiver":"","receiverid":"","createtime":"2017-05-23 14:12:32","progress":0,"fileaddress":null,"fuJian":[{"accid":109,"taskid":"43074a7a1bd54bf0a228395fb8ec1eee","userid":"02774bc536964386a68bd2b64145c910","fileName":"附件_20170523141231.png","fileadress":null,"fileaddressdown":"http://123.56.97.229/upload/2017051431412860/附件_20170523141231.png","assid":"cb4b8475d1b249d49046f7b69d8093c3","creatime":"2017-05-23 14:12:33.0","username":null},{"accid":110,"taskid":"43074a7a1bd54bf0a228395fb8ec1eee","userid":"02774bc536964386a68bd2b64145c910","fileName":"附件_20170523141224.png","fileadress":null,"fileaddressdown":"http://123.56.97.229/upload/2017051431412900/附件_20170523141224.png","assid":"cb4b8475d1b249d49046f7b69d8093c3","creatime":"2017-05-23 14:12:33.0","username":null}],"taskid":"43074a7a1bd54bf0a228395fb8ec1eee","taskcontent":"测试附件","executor":"庞世宇;","endtime":"2017-05-23","askerid":"02774bc536964386a68bd2b64145c910","askername":"庞世宇","location":""}]
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
         * id : b1ca83f27bb943cf85e0ad3b75625f59
         * title : 测试附件1319，任务上报！
         * content : 测试附件二
         * type : 5
         * askContent : 测试附件二
         * askTime : 2017-05-23 14:12:32
         * taskName : 测试附件1319
         * readed : 0
         * creator : 庞世宇
         * receiver :
         * receiverid :
         * createtime : 2017-05-23 14:12:32
         * progress : 0
         * fileaddress : null
         * fuJian : [{"accid":109,"taskid":"43074a7a1bd54bf0a228395fb8ec1eee","userid":"02774bc536964386a68bd2b64145c910","fileName":"附件_20170523141231.png","fileadress":null,"fileaddressdown":"http://123.56.97.229/upload/2017051431412860/附件_20170523141231.png","assid":"cb4b8475d1b249d49046f7b69d8093c3","creatime":"2017-05-23 14:12:33.0","username":null},{"accid":110,"taskid":"43074a7a1bd54bf0a228395fb8ec1eee","userid":"02774bc536964386a68bd2b64145c910","fileName":"附件_20170523141224.png","fileadress":null,"fileaddressdown":"http://123.56.97.229/upload/2017051431412900/附件_20170523141224.png","assid":"cb4b8475d1b249d49046f7b69d8093c3","creatime":"2017-05-23 14:12:33.0","username":null}]
         * taskid : 43074a7a1bd54bf0a228395fb8ec1eee
         * taskcontent : 测试附件
         * executor : 庞世宇;
         * endtime : 2017-05-23
         * askerid : 02774bc536964386a68bd2b64145c910
         * askername : 庞世宇
         * location :
         */

        private String id;
        private String title;
        private String content;
        private int type;
        private String askContent;
        private String askTime;
        private String taskName;
        private int readed;
        private String creator;
        private String receiver;
        private String receiverid;
        private String createtime;
        private int progress;
        private Object fileaddress;
        private String taskid;
        private String taskcontent;
        private String executor;
        private String endtime;
        private String askerid;
        private String askername;
        private String location;
        private List<FuJianBean> fuJian;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getAskContent() {
            return askContent;
        }

        public void setAskContent(String askContent) {
            this.askContent = askContent;
        }

        public String getAskTime() {
            return askTime;
        }

        public void setAskTime(String askTime) {
            this.askTime = askTime;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public int getReaded() {
            return readed;
        }

        public void setReaded(int readed) {
            this.readed = readed;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getReceiverid() {
            return receiverid;
        }

        public void setReceiverid(String receiverid) {
            this.receiverid = receiverid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public Object getFileaddress() {
            return fileaddress;
        }

        public void setFileaddress(Object fileaddress) {
            this.fileaddress = fileaddress;
        }

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public String getTaskcontent() {
            return taskcontent;
        }

        public void setTaskcontent(String taskcontent) {
            this.taskcontent = taskcontent;
        }

        public String getExecutor() {
            return executor;
        }

        public void setExecutor(String executor) {
            this.executor = executor;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getAskerid() {
            return askerid;
        }

        public void setAskerid(String askerid) {
            this.askerid = askerid;
        }

        public String getAskername() {
            return askername;
        }

        public void setAskername(String askername) {
            this.askername = askername;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public List<FuJianBean> getFuJian() {
            return fuJian;
        }

        public void setFuJian(List<FuJianBean> fuJian) {
            this.fuJian = fuJian;
        }

        public static class FuJianBean {
            /**
             * accid : 109
             * taskid : 43074a7a1bd54bf0a228395fb8ec1eee
             * userid : 02774bc536964386a68bd2b64145c910
             * fileName : 附件_20170523141231.png
             * fileadress : null
             * fileaddressdown : http://123.56.97.229/upload/2017051431412860/附件_20170523141231.png
             * assid : cb4b8475d1b249d49046f7b69d8093c3
             * creatime : 2017-05-23 14:12:33.0
             * username : null
             */

            private int accid;
            private String taskid;
            private String userid;
            private String fileName;
            private Object fileadress;
            private String fileaddressdown;
            private String assid;
            private String creatime;
            private Object username;

            public int getAccid() {
                return accid;
            }

            public void setAccid(int accid) {
                this.accid = accid;
            }

            public String getTaskid() {
                return taskid;
            }

            public void setTaskid(String taskid) {
                this.taskid = taskid;
            }

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public Object getFileadress() {
                return fileadress;
            }

            public void setFileadress(Object fileadress) {
                this.fileadress = fileadress;
            }

            public String getFileaddressdown() {
                return fileaddressdown;
            }

            public void setFileaddressdown(String fileaddressdown) {
                this.fileaddressdown = fileaddressdown;
            }

            public String getAssid() {
                return assid;
            }

            public void setAssid(String assid) {
                this.assid = assid;
            }

            public String getCreatime() {
                return creatime;
            }

            public void setCreatime(String creatime) {
                this.creatime = creatime;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }
        }
    }
}
