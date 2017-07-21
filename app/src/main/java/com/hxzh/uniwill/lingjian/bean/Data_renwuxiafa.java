package com.hxzh.uniwill.lingjian.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pang on 2017/4/1.
 *  任务下发
 */
public class Data_renwuxiafa {

    /**
     * result : 1
     * ”failcode” : ””
     */

    private String result;
    @SerializedName("”failcode”")
    private String _$Failcode207; // FIXME check this code

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String get_$Failcode207() {
        return _$Failcode207;
    }

    public void set_$Failcode207(String _$Failcode207) {
        this._$Failcode207 = _$Failcode207;
    }
}
