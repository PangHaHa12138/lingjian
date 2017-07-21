package com.hxzh.uniwill.lingjian.View;

/**
 * Created by pang on 2017/4/4.
 *  自定义 dialog对话框
 */
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.hxzh.uniwill.lingjian.R;
public class MyDialog extends Dialog {
    private LinearLayout xiangce;
    private LinearLayout paizhao;
    private onPaizhao_OnclickListener onpaizhao_onclickListener;//拍照按钮被点击了的监听器
    private onXiangce_OnclickListener onxiangce_onclickListener;//相册按钮被点击了的监听器

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param
     * @param
     */
    public void set_paizhao_OnclickListener(onPaizhao_OnclickListener paizhao_onclick) {

        this.onpaizhao_onclickListener = paizhao_onclick;
    }
    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param
     * @param
     */
    public void set_xiangce_OnclickListener( onXiangce_OnclickListener xiangce_onclick) {

        this.onxiangce_onclickListener = xiangce_onclick;
    }

    public MyDialog(Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_touxiang);
        //按空白处取消动画
        setCanceledOnTouchOutside(true);

        //初始化界面控件
        initView();
        //初始化界面控件的事件
        initEvent();
    }
    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置拍照 按钮被点击后，向外界提供监听
        paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onpaizhao_onclickListener != null) {
                    onpaizhao_onclickListener.paizhao_onClick();
                }
            }
        });
        //设置相册 按钮被点击后，向外界提供监听
        xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onxiangce_onclickListener != null) {
                    onxiangce_onclickListener.xiangce_onClick();
                }
            }
        });
    }

    /**
     * 初始化界面控件
     */
    private void initView() {

        xiangce = (LinearLayout) findViewById(R.id.xiangce);
        paizhao = (LinearLayout) findViewById(R.id.paizhao);
        
    }
    /**
     * 设置确定按钮和取消被点击的接口
     * 相册 拍照
     */
    public interface onPaizhao_OnclickListener {
        public void paizhao_onClick();
    }

    public interface onXiangce_OnclickListener {
        public void xiangce_onClick();
    }
}
