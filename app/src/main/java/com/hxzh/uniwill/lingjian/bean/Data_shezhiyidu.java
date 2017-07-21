package com.hxzh.uniwill.lingjian.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pang on 2017/4/1.
 *  设置已读
 */
public class Data_shezhiyidu {


    /**
     * result : 1
     * ”failcode” : ””
     */

    private String result;
    @SerializedName("”failcode”")
    private String _$Failcode106; // FIXME check this code

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String get_$Failcode106() {
        return _$Failcode106;
    }

    public void set_$Failcode106(String _$Failcode106) {
        this._$Failcode106 = _$Failcode106;
    }
}
