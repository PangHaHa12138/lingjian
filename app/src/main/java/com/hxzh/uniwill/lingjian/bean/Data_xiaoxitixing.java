package com.hxzh.uniwill.lingjian.bean;

/**
 * Created by pang on 2017/4/1.
 *  消息提醒
 */
public class Data_xiaoxitixing {

    /**
     * result : 1
     * count : 8
     * rmsg : {"id":"147982ace3954fa0a1b5c0c77ffe07d9","title":"测试001，任务创建！","taskid":"6238370f071e4dd48371368372ce2821","taskname":"测试001","creator":"7b38d675b7d3413295faf8b97768109b","receiver":"4f10a663a8714abe8ecbbefac3823466","receivername":"张岩"}
     */

    private int result;
    private int count;
    private RmsgBean rmsg;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RmsgBean getRmsg() {
        return rmsg;
    }

    public void setRmsg(RmsgBean rmsg) {
        this.rmsg = rmsg;
    }

    public static class RmsgBean {
        /**
         * id : 147982ace3954fa0a1b5c0c77ffe07d9
         * title : 测试001，任务创建！
         * taskid : 6238370f071e4dd48371368372ce2821
         * taskname : 测试001
         * creator : 7b38d675b7d3413295faf8b97768109b
         * receiver : 4f10a663a8714abe8ecbbefac3823466
         * receivername : 张岩
         */

        private String id;
        private String title;
        private String taskid;
        private String taskname;
        private String creator;
        private String receiver;
        private String receivername;

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

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public String getTaskname() {
            return taskname;
        }

        public void setTaskname(String taskname) {
            this.taskname = taskname;
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

        public String getReceivername() {
            return receivername;
        }

        public void setReceivername(String receivername) {
            this.receivername = receivername;
        }
    }
}
