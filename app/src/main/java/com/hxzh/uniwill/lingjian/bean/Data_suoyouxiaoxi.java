package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  所有消息
 */
public class Data_suoyouxiaoxi {


    /**
     * total : 3
     * list : [{"id":"b43f3d81159242a395636e7db580dc73","title":"","content":"","type":1,"taskName":"","askContent":"","readed":0,"creator":"","receiver":"","createtime":"2016-03-15","progress":0}]
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
         * id : b43f3d81159242a395636e7db580dc73
         * title :
         * content :
         * type : 1
         * taskName :
         * askContent :
         * readed : 0
         * creator :
         * receiver :
         * createtime : 2016-03-15
         * progress : 0
         */

        private String id;
        private String title;
        private String content;
        private int type;
        private String taskName;
        private String askContent;
        private int readed;
        private String creator;
        private String receiver;
        private String createtime;
        private int progress;

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

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getAskContent() {
            return askContent;
        }

        public void setAskContent(String askContent) {
            this.askContent = askContent;
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
    }
}
