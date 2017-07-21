package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  消息查询列表
 */
public class Data_xiaoxi_chaxunliebiao {


    /**
     * total : 3
     * list : [{"id":"0f5fd8b3afb140babd74291c23665903","title":"确认操作","content":"Wwewewewewewewewewewewew","type":1,"askContent":null,"askTime":null,"taskName":"Qqqqqqqqqqqqqq","readed":0,"creator":"李岩明","receiver":"李岩明","createtime":"2016-03-22","progress":0,"taskid":"2bd6c427b9ff4746a2f966441a89e996","taskcontent":"","executor":"","endtime":"2017-02-22","askerid":"","askername":""}]
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
         * id : 0f5fd8b3afb140babd74291c23665903
         * title : 确认操作
         * content : Wwewewewewewewewewewewew
         * type : 1
         * askContent : null
         * askTime : null
         * taskName : Qqqqqqqqqqqqqq
         * readed : 0
         * creator : 李岩明
         * receiver : 李岩明
         * createtime : 2016-03-22
         * progress : 0
         * taskid : 2bd6c427b9ff4746a2f966441a89e996
         * taskcontent :
         * executor :
         * endtime : 2017-02-22
         * askerid :
         * askername :
         */

        private String id;
        private String title;
        private String content;
        private int type;
        private Object askContent;
        private Object askTime;
        private String taskName;
        private int readed;
        private String creator;
        private String receiver;
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

        public Object getAskContent() {
            return askContent;
        }

        public void setAskContent(Object askContent) {
            this.askContent = askContent;
        }

        public Object getAskTime() {
            return askTime;
        }

        public void setAskTime(Object askTime) {
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
