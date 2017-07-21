package com.hxzh.uniwill.lingjian.bean;

import java.util.List;

/**
 * Created by pang on 2017/4/1.
 *  任务树组织结构图
 */
public class Data_renwushu_zuzhijiegoutu {


    /**
     * name : 战乃国
     * id : 45fcbf917a8948ea9f40e27027031f34
     * progress : 0
     * avatar : http:/192.168.6.138:8080/image/20160511090145.jpg
     * status : 3
     * dtos : [{"name":"李蕾","id":"e4d3d16ca8334894a71a48cdc4297c7c","progress":0,"avatar":"http:/192.168.6.138:8080/image/default0.png","status":0,"dtos":[]},{"name":"余万一","id":"9e6fde08078e466dad49c358af9ad0c8","progress":0,"avatar":"http:/192.168.6.138:8080/image/进度2.png","status":1,"dtos":[{"name":"李岩明","id":"3c9ed086df6444a6b189227afa610c06","progress":0,"avatar":"http:/192.168.6.138:8080/image/default1.png","status":0,"dtos":[]},{"name":"李艳","id":"b8876e00407d40989365bad68f271529","progress":0,"avatar":"http:/192.168.6.138:8080/image/default0.png","status":0,"dtos":[]},{"name":"张岩","id":"473e3c3d17c74203a515a0e9f4e01836","progress":0,"avatar":"http:/192.168.6.138:8080/image/default0.png","status":0,"dtos":[]}]}]
     */

    private String name;
    private String id;
    private int progress;
    private String avatar;
    private int status;
    private List<DtosBean> dtos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DtosBean> getDtos() {
        return dtos;
    }

    public void setDtos(List<DtosBean> dtos) {
        this.dtos = dtos;
    }

    public static class DtosBean {
        /**
         * name : 李蕾
         * id : e4d3d16ca8334894a71a48cdc4297c7c
         * progress : 0
         * avatar : http:/192.168.6.138:8080/image/default0.png
         * status : 0
         * dtos : []
         */

        private String name;
        private String id;
        private int progress;
        private String avatar;
        private int status;
        private List<?> dtos;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<?> getDtos() {
            return dtos;
        }

        public void setDtos(List<?> dtos) {
            this.dtos = dtos;
        }
    }
}
