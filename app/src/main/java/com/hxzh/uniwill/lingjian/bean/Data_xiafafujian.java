package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/***
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
 * <p/>
 * Created by PangHaHa12138 on 2017/5/27.
 */
public class Data_xiafafujian {


    /**
     * result : 1
     * file : [{"accid":59,"taskid":"afdab44c5b634466b85d336448572bee","userid":"b4d41be2c70144eca7001e95b6078114","fileName":"IMG_0184.JPG","fileadress":null,"fileaddressdown":"http://123.56.97.229/upload/2017051371719556/IMG_0184.JPG","assid":null,"creatime":"2017-05-17 17:19:55.0","username":"刘哲"},{"accid":58,"taskid":"afdab44c5b634466b85d336448572bee","userid":"b4d41be2c70144eca7001e95b6078114","fileName":"biao.sql","fileadress":null,"fileaddressdown":"http://123.56.97.229/upload/2017051371615442/biao.sql","assid":null,"creatime":"2017-05-17 16:15:32.0","username":"刘哲"},{"accid":57,"taskid":"afdab44c5b634466b85d336448572bee","userid":"b4d41be2c70144eca7001e95b6078114","fileName":"server.xml","fileadress":null,"fileaddressdown":"http://123.56.97.229/upload/2017051371611356/server.xml","assid":null,"creatime":"2017-05-17 16:11:17.0","username":"刘哲"}]
     */

    private String result;
    private List<FileBean> file;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<FileBean> getFile() {
        return file;
    }

    public void setFile(List<FileBean> file) {
        this.file = file;
    }

    public static class FileBean {
        /**
         * accid : 59
         * taskid : afdab44c5b634466b85d336448572bee
         * userid : b4d41be2c70144eca7001e95b6078114
         * fileName : IMG_0184.JPG
         * fileadress : null
         * fileaddressdown : http://123.56.97.229/upload/2017051371719556/IMG_0184.JPG
         * assid : null
         * creatime : 2017-05-17 17:19:55.0
         * username : 刘哲
         */

        private int accid;
        private String taskid;
        private String userid;
        private String fileName;
        private Object fileadress;
        private String fileaddressdown;
        private Object assid;
        private String creatime;
        private String username;

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

        public Object getAssid() {
            return assid;
        }

        public void setAssid(Object assid) {
            this.assid = assid;
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
    }
}
