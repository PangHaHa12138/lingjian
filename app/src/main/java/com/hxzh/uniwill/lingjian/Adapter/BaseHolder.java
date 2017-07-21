package com.hxzh.uniwill.lingjian.Adapter;

import android.view.View;

/**
 * Created by pang on 2017/3/28.
 *  基类BaseHolder，把与ConvertView相关的数据操作全部在这个类里实现
 */
public abstract class BaseHolder<T> {
    protected View contentView;
    protected T data;
    public BaseHolder(){
        contentView=initView();
        contentView.setTag(this);  // 在这个位置设置的标签
    }

    public void setData(T data) {
        this.data=data;
        refreshView(data);
    }
    /**
     * 当Holder中的view对象显示到界面上的时候调用
     * @return
     */
    public View getContentView() {
        return contentView;
    }
    /**
     * 当setData调用的时候 会调用该方法  根据数据 显示界面
     */
    protected abstract void refreshView(T data);

    /**
     * 初始化View对象 及其控件
     * @return
     */
    protected abstract View initView();
}
