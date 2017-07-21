package com.hxzh.uniwill.lingjian.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.hxzh.uniwill.lingjian.base.MyApplication;

/**
 * Created by pang on 2016/7/31.
 *
 */
public class CommonUtil {

    public static void runOnUIThread(Runnable r){
        MyApplication.mainHandler.post(r);
    }

    //移除子view
    public static void removeSelfFromParent(View child){
        if (child != null) {
            ViewParent parent = child.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(child);//移除子view
            }
        }
    }
    public static Drawable getDrawable(int id){
        return MyApplication.mcontext.getResources().getDrawable(id);
    }
    public static String getString(int id){
        return MyApplication.mcontext.getResources().getString(id);
    }
    public static String[] getStringArray(int id){
        return MyApplication.mcontext.getResources().getStringArray(id);
    }
    public static int getColor(int id){
        return MyApplication.mcontext.getResources().getColor(id);
    }

    // 获取dp资源，并且会自动将dp值转为px值
    public static int getDptoPx(int id){
        return MyApplication.mcontext.getResources().getDimensionPixelSize(id);
    }
}
