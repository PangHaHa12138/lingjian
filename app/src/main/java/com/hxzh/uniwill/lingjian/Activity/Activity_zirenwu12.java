package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_huoqurenwuxiangqing;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/3/31.
 */
public class Activity_zirenwu12 extends BaseToobarRightViewActivity {

    private String userid,taskid,zerenrenn,riqi,zhouqi,miaoshu;
    private TextView zerenren,wanchengriqi,shangbaozhouqi;
    private EditText renwubiaozhun;
//    private BubbleSeekBar mBbubbleSeekBar;
    private int myprogress;
    private RelativeLayout huibao;
    private RelativeLayout change1;
    private Data_huoqurenwuxiangqing renwuxiangqing;
    private List<Data_huoqurenwuxiangqing.ListBean> list;
    private ProgressBar progesss;
    private TextView progesssValue;
    private int x0,x1, x2, dx;
    private LinearLayout full;
    private String chang_msg1,chang_msg2,chang_msg3,chang_msg4,chang_msg5;
    private int chang_progrs1,chang_progrs2,chang_progrs3,chang_progrs4,chang_progrs5;

    private String fjname1,fjname2,fjname3,fjname4,fjname5,fjname6,fjname7,fjname8,fjname9,fjname10;
    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,
            fujian10;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("待办任务-子任务");
        getToobarRightView().setImageResource(R.drawable.title_but_chat_3x);
        initview();
        initData();

    }
    private void initview() {
//        mBbubbleSeekBar = (BubbleSeekBar) findViewById(R.id.bubbleseekbar1);
        zerenren = (TextView) findViewById(R.id.name1);
        wanchengriqi = (TextView) findViewById(R.id.time1);
        shangbaozhouqi = (TextView) findViewById(R.id.week1);
        renwubiaozhun = (EditText) findViewById(R.id.renwubiaozhun1);
        huibao = (RelativeLayout) findViewById(R.id.huibao1);
        change1 = (RelativeLayout) findViewById(R.id.change1);
        progesss = (ProgressBar) findViewById(R.id.progesss1);
        progesssValue = (TextView) findViewById(R.id.progesss_value1);
        full = (LinearLayout) findViewById(R.id.full1);

        fujian1 = (RelativeLayout) findViewById(R.id.fujian1);
        fujian2 = (RelativeLayout) findViewById(R.id.fujian2);
        fujian3 = (RelativeLayout) findViewById(R.id.fujian3);
        fujian4 = (RelativeLayout) findViewById(R.id.fujian4);
        fujian5 = (RelativeLayout) findViewById(R.id.fujian5);
        fujian6 = (RelativeLayout) findViewById(R.id.fujian6);
        fujian7 = (RelativeLayout) findViewById(R.id.fujian7);
        fujian8 = (RelativeLayout) findViewById(R.id.fujian8);
        fujian9 = (RelativeLayout) findViewById(R.id.fujian9);
        fujian10 = (RelativeLayout) findViewById(R.id.fujian10);
        fujianname1 = (TextView) findViewById(R.id.fujiantext1);
        fujianname2 = (TextView) findViewById(R.id.fujiantext2);
        fujianname3 = (TextView) findViewById(R.id.fujiantext3);
        fujianname4 = (TextView) findViewById(R.id.fujiantext4);
        fujianname5 = (TextView) findViewById(R.id.fujiantext5);
        fujianname6 = (TextView) findViewById(R.id.fujiantext6);
        fujianname7 = (TextView) findViewById(R.id.fujiantext7);
        fujianname8 = (TextView) findViewById(R.id.fujiantext8);
        fujianname9 = (TextView) findViewById(R.id.fujiantext9);
        fujianname10 = (TextView) findViewById(R.id.fujiantext10);

    }

    private void initData() {
        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid6");
        LogUtil.d("taskid汇报",taskid+"----");
        zerenrenn = intent.getStringExtra("zerenrename6");
        zhouqi = intent.getStringExtra("baozhouqi6");
        riqi = intent.getStringExtra("wantime6");
        miaoshu = intent.getStringExtra("miaoshu6");
        renwubiaozhun.setText(miaoshu);
        try {

            if (!SharedPreferencesUtil.readSonchange12(Activity_zirenwu12.this).equals("")){

                renwubiaozhun.setText(SharedPreferencesUtil.readSonchange12(Activity_zirenwu12.this));
            }else {
                OkHttpUtils.get(Http_Api.URL_renwuxiangqing)
                        .params("pn",1)
                        .params("size",1)
                        .params("userid",userid)
                        .params("taskid",taskid)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                renwuxiangqing = JsonUtil.parseJsonToBean(s,Data_huoqurenwuxiangqing.class);
                                if (renwuxiangqing!=null){
                                    list = renwuxiangqing.getList();
                                    myprogress = list.get(0).getProgress();

//                                    progesss.setProgress(myprogress);
                                    LogUtil.d("任务标准",miaoshu+"");
                                    LogUtil.d("进度3---",myprogress+"");
                                }
                            }
                        });
            }

            fjname1 = SharedPreferencesUtil.readFilename1(Activity_zirenwu12.this);
            fjname2 = SharedPreferencesUtil.readFilename2(Activity_zirenwu12.this);
            fjname3 = SharedPreferencesUtil.readFilename3(Activity_zirenwu12.this);
            fjname4 = SharedPreferencesUtil.readFilename4(Activity_zirenwu12.this);
            fjname5 = SharedPreferencesUtil.readFilename5(Activity_zirenwu12.this);
            fjname6 = SharedPreferencesUtil.readFilename6(Activity_zirenwu12.this);
            fjname7 = SharedPreferencesUtil.readFilename7(Activity_zirenwu12.this);
            fjname8 = SharedPreferencesUtil.readFilename8(Activity_zirenwu12.this);
            fjname9 = SharedPreferencesUtil.readFilename9(Activity_zirenwu12.this);
            fjname10 = SharedPreferencesUtil.readFilename10(Activity_zirenwu12.this);

            if (!fjname1.equals("")){
                fujian1.setVisibility(View.VISIBLE);
                fujianname1.setText(fjname1);
            }
            if (!fjname2.equals("")){
                fujian2.setVisibility(View.VISIBLE);
                fujianname2.setText(fjname2);
            }
            if (!fjname3.equals("")){
                fujian3.setVisibility(View.VISIBLE);
                fujianname3.setText(fjname3);
            }
            if (!fjname4.equals("")){
                fujian4.setVisibility(View.VISIBLE);
                fujianname4.setText(fjname4);
            }
            if (!fjname5.equals("")){
                fujian5.setVisibility(View.VISIBLE);
                fujianname5.setText(fjname5);
            }
            if (!fjname6.equals("")){
                fujian6.setVisibility(View.VISIBLE);
                fujianname6.setText(fjname6);
            }
            if (!fjname7.equals("")){
                fujian7.setVisibility(View.VISIBLE);
                fujianname7.setText(fjname7);
            }
            if (!fjname8.equals("")){
                fujian8.setVisibility(View.VISIBLE);
                fujianname8.setText(fjname8);
            }
            if (!fjname9.equals("")){
                fujian9.setVisibility(View.VISIBLE);
                fujianname9.setText(fjname9);
            }
            if (!fjname10.equals("")){
                fujian10.setVisibility(View.VISIBLE);
                fujianname10.setText(fjname10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        full.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int w = getWindowManager().getDefaultDisplay().getWidth();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x1 = (int) event.getRawX();
                        progesss.setProgress(100 * x1 / w);
                        setPos();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x2 = (int) event.getRawX();
                        dx = x2 - x1;
                        if (Math.abs(dx) > w / 100) { //改变条件 调整进度改变速度
                            x1 = x2; // 去掉已经用掉的距离， 去掉这句 运行看看会出现效果
                            progesss.setProgress(progesss.getProgress() + dx * 100 / w);
                            setPos();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }
        });

        zerenren.setText(zerenrenn);
        wanchengriqi.setText(riqi);
        shangbaozhouqi.setText(zhouqi);
//        shangbaozhouqi.setText("当前任务");

        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
                Intent intent = new Intent(Activity_zirenwu12.this, Activity_Chat.class);
                intent.putExtra("taskid",taskid);
                startActivity(intent);
            }
        });
        huibao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Activity_zirenwu12.this,Activity_huibao.class);
                intent1.putExtra("taskid",taskid);
                startActivity(intent1);

            }
        });
        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chang_msg1 = renwubiaozhun.getText().toString().trim();
                LogUtil.d("修改的信息",chang_msg1+"");
                SharedPreferencesUtil.writeSonchange12(chang_msg1,Activity_zirenwu12.this);
                ToastUtil.showToast("修改完成");
                finish();
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            setPos();
        }
    }

    /**
     * 设置进度显示在对应的位置
     */
    public void setPos() {
        int w = getWindowManager().getDefaultDisplay().getWidth();
        Log.e("w=====", "" + w);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) progesssValue.getLayoutParams();
        int pro = progesss.getProgress();
        int tW = progesssValue.getWidth();
        if (w * pro / 100 + tW * 0.3 > w) {
            params.leftMargin = (int) (w - tW * 1.1);
        } else if (w * pro / 100 < tW * 0.7) {
            params.leftMargin = 0;
        } else {
            params.leftMargin = (int) (w * pro / 100 - tW * 0.7);
        }
        progesssValue.setLayoutParams(params);
        progesssValue.setText(new StringBuffer().append(progesss.getProgress()).append("%"));
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_zirenwu1;
    }


}
