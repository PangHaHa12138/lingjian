package com.hxzh.uniwill.lingjian.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by pang on 2017/4/14.
 *  解决ScrollView.setOnScrollChangeListener() API23以上可用问题;
 *
 *  系统自带的ScrollView功能相当粗糙：连个最基本的setOnScrollListener()的方法都没有，
 *  仅有个onScrollChanged()方法，而且还是protected的
 *
 *  继承ScrollView，然后把最原始的onScrollChanged()方法暴露给外部
 */
public class MyScrollView extends ScrollView{

    private ScrollViewListener scrollViewListener = null;



    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }
    public interface ScrollViewListener {
        void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy);

    }


    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }
}
