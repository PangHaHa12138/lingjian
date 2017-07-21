package com.hxzh.uniwill.lingjian.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pang on 2017/4/1.
 *  职务更新
 */
public class Data_bumen_gengxin {

    /**
     * result : 1
     * ”failcode” : ””
     */

    private String result;
    @SerializedName("”failcode”")
    private String _$Failcode58; // FIXME check this code

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String get_$Failcode58() {
        return _$Failcode58;
    }

    public void set_$Failcode58(String _$Failcode58) {
        this._$Failcode58 = _$Failcode58;
    }
}
