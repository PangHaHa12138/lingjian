package com.hxzh.uniwill.lingjian.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pang on 2017/4/1.
 *  任务更新状态
 */
public class Data_renwugengxinzhuangtai {

    /**
     * result : 1
     * ”failcode” : ””
     */

    private String result;
    @SerializedName("”failcode”")
    private String _$Failcode13; // FIXME check this code

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String get_$Failcode13() {
        return _$Failcode13;
    }

    public void set_$Failcode13(String _$Failcode13) {
        this._$Failcode13 = _$Failcode13;
    }
}
