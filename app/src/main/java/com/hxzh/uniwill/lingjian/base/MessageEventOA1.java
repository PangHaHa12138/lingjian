package com.hxzh.uniwill.lingjian.base;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pang on 2017/4/9.
 *  事件类
 */
public class MessageEventOA1 {

    public String msg;

    public List<String> list;

    public Set<String> set;

    public Map<Integer,String> map;


    public MessageEventOA1(Map<Integer,String> map1){
        this.map = map1;
    }

    public MessageEventOA1(Set<String> set1){
        this.set = set1;
    }

    public MessageEventOA1(List<String> list){
        this.list = list;
    }

    public MessageEventOA1(String msg){
        this.msg = msg;
    }

    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public Set<String> getSet() {
        return set;
    }
    public void setSet(Set<String> set) {
        this.set = set;
    }
    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }
    public String getMessage() {
        return msg;
    }


    public void setMessage(String message) {
        this.msg = message;
    }

}
