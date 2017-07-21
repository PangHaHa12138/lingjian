package com.hxzh.uniwill.lingjian.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pang on 2017/4/1.
 *  消息
 */
public class Data_xiaoxi {


    /**
     * result : 1
     * ”failcode” : ””
     */

    private String result;
    @SerializedName("”failcode”")
    private String _$Failcode203; // FIXME check this code

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String get_$Failcode203() {
        return _$Failcode203;
    }

    public void set_$Failcode203(String _$Failcode203) {
        this._$Failcode203 = _$Failcode203;
    }
}
