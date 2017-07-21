package com.hxzh.uniwill.lingjian.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pang on 2017/4/1.
 *  更新工作日程状态
 */
public class Data_gengxingongzuorichengzhuangtai {


    /**
     * result : 1
     * ”failcode” : ””
     */

    private String result;
    @SerializedName("”failcode”")
    private String _$Failcode319; // FIXME check this code

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String get_$Failcode319() {
        return _$Failcode319;
    }

    public void set_$Failcode319(String _$Failcode319) {
        this._$Failcode319 = _$Failcode319;
    }
}
