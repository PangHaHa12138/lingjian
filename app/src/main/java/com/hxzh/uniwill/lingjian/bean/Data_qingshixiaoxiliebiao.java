package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  请示消息列表
 */
public class Data_qingshixiaoxiliebiao {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 3df6c724bac04efeb2268b6e4cab66b2
         * title : 请示操作
         * content : 请示，测试批复
         * type : 3
         * askContent : 请示，测试批复
         * askTime : 2016-04-13
         * taskName : 贾001
         * readed : 1
         * creator : 李蕾
         * receiver : 贾胜须
         * receiverid : 8272165c97234ee2ae7ccaa2037de862
         * createtime : 2016-04-13
         * progress : -1
         * taskid : 0677e1c4655a4637a79b50392dab7fcd
         * taskcontent : ff
         * executor : 余万一;李岩明;李蕾;
         * endtime : 2016-04-28
         * askerid : 7b38d675b7d3413295faf8b97768109b
         * askername : 李蕾
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
        private String taskid;
        private String taskcontent;
        private String executor;
        private String endtime;
        private String askerid;
        private String askername;

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
    }
}
