package com.hxzh.uniwill.lingjian.View;

/**
 * Created by pang on 2017/4/4.
 *  自定义 popupwindow 弹窗  //图表统计
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;

public class TimePickerPopupWindows extends PopupWindow {
    private View mMenuView; // PopupWindow 菜单布局
    private Context context; // 上下文参数
    private OnClickListener myOnClick; // PopupWindow 菜单 空间单击事件

    private LinearLayout tubiaotongji;
    private RelativeLayout chaxun;

    private TextView starttime;


    public TimePickerPopupWindows(Activity context, OnClickListener myOnClick) {
        super(context);
        this.context = context;
        this.myOnClick = myOnClick;

        Init();
    }


    private void Init() {
        // TODO Auto-generated method stub
        // PopupWindow 导入
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.popuwindow_timepick, null);
        tubiaotongji = (LinearLayout) mMenuView.findViewById(R.id.starttime1);
        chaxun = (RelativeLayout) mMenuView.findViewById(R.id.chaxun1);

        starttime = (TextView) mMenuView.findViewById(R.id.chosestarttime1);

        //开始时间
        tubiaotongji.setOnClickListener(myOnClick);
        //查询
        chaxun.setOnClickListener(myOnClick);


        // 导入布局
        this.setContentView(mMenuView);
        // 设置动画效果
        this.setAnimationStyle(R.style.popwindow_anim_style);
        //防止虚拟键挡住
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //设置弹出窗体的 宽，高
        this.setWidth(LayoutParams.WRAP_CONTENT);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置可触
        this.setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x0000000);
        this.setBackgroundDrawable(dw);
        // 单击弹出窗以外处 关闭弹出窗
        mMenuView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    public TextView getStartview(){

        return starttime;
    }

}
