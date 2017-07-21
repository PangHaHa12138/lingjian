package com.hxzh.uniwill.lingjian.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_huoqurenwuxiangqing;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
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
public class Activity_zirenwu23 extends BaseToobarRightViewActivity {

    private String userid,taskid,zerenrenn,riqi,zhouqi,miaoshu;
    private TextView zerenren,wanchengriqi,shangbaozhouqi,renwubiaozhun;
//    private BubbleSeekBar mBbubbleSeekBar;
    private int myprogress;
    private RelativeLayout huibao;
    private Data_huoqurenwuxiangqing data_huoqurenwuxiangqing;
    private List<Data_huoqurenwuxiangqing.ListBean> list;
    private List<Data_huoqurenwuxiangqing.ListAccBean> listacc;

    private ProgressBar progesss;
    private TextView progesssValue;

    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,
            fujian10;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("子任务");
        getToobarRightView().setImageResource(R.drawable.title_but_chat_3x);
        initview();
        initData();

    }
    private void initview() {

//        mBbubbleSeekBar = (BubbleSeekBar) findViewById(R.id.bubbleseekbar7);
        zerenren = (TextView) findViewById(R.id.name7);
        wanchengriqi = (TextView) findViewById(R.id.time7);
        shangbaozhouqi = (TextView) findViewById(R.id.week7);
        renwubiaozhun = (TextView) findViewById(R.id.renwubiaozhun7);
        huibao = (RelativeLayout) findViewById(R.id.huibao7);
        progesss = (ProgressBar) findViewById(R.id.progesss);
        progesssValue = (TextView) findViewById(R.id.progesss_value);

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
        userid = SharedPreferencesUtil.readUserid(Activity_zirenwu23.this);
        final Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid23");
        LogUtil.d("汇报taskid",taskid+"---");
        zerenrenn = intent.getStringExtra("zerenrename23");
        zhouqi = intent.getStringExtra("baozhouqi23");
        riqi = intent.getStringExtra("wantime23");
        miaoshu = intent.getStringExtra("miaoshu23");
//        myprogress = intent.getIntExtra("progress23",0);
        LogUtil.d("收到的进度1---",myprogress+"");
        try {
            OkHttpUtils.get(Http_Api.URL_renwuxiangqing)
                    .params("pn",1)
                    .params("size",1)
                    .params("userid",userid)
                    .params("taskid",taskid)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            data_huoqurenwuxiangqing = JsonUtil.parseJsonToBean(s,Data_huoqurenwuxiangqing.class);
                            if (data_huoqurenwuxiangqing!=null){
                                list = data_huoqurenwuxiangqing.getList();
                                miaoshu = data_huoqurenwuxiangqing.getTaskcontent();
                                renwubiaozhun.setText(miaoshu);
                                myprogress = list.get(0).getProgress();
                                LogUtil.d("收到的进度2---",myprogress+"");
                                LogUtil.d("描述---",miaoshu+"");
                                progesss.setProgress(myprogress);
                                progesssValue.setText(new StringBuffer().append(progesss.getProgress()).append("%"));
                                setPosWay1();

                                listacc = data_huoqurenwuxiangqing.getListAcc();
                                if (listacc == null){
                                    fujian1.setVisibility(View.GONE);
                                    fujian2.setVisibility(View.GONE);
                                    fujian3.setVisibility(View.GONE);
                                    fujian4.setVisibility(View.GONE);
                                    fujian5.setVisibility(View.GONE);
                                    fujian6.setVisibility(View.GONE);
                                    fujian7.setVisibility(View.GONE);
                                    fujian8.setVisibility(View.GONE);
                                    fujian9.setVisibility(View.GONE);
                                    fujian10.setVisibility(View.GONE);
                                }
                                if (listacc!= null&&listacc.size()==1){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                }
                                if (listacc!=null&&listacc.size()==2){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!=null&&listacc.size() == 3){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!= null&&listacc.size()==4){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!=null&&listacc.size() == 5){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc != null&&listacc.size() == 6){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc != null&&listacc.size() == 7){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian7.setVisibility(View.VISIBLE);
                                    fujianname7.setText(listacc.get(6).getFileName());
                                    final String url7 = listacc.get(6).getFileaddressdown();
                                    fujian7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url7);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!=null&&listacc.size() == 8){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian7.setVisibility(View.VISIBLE);
                                    fujianname7.setText(listacc.get(6).getFileName());
                                    final String url7 = listacc.get(6).getFileaddressdown();
                                    fujian7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url7);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian8.setVisibility(View.VISIBLE);
                                    fujianname8.setText(listacc.get(7).getFileName());
                                    final String url8 = listacc.get(7).getFileaddressdown();
                                    fujian8.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url8);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!= null&&listacc.size()==9){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian7.setVisibility(View.VISIBLE);
                                    fujianname7.setText(listacc.get(6).getFileName());
                                    final String url7 = listacc.get(6).getFileaddressdown();
                                    fujian7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url7);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian8.setVisibility(View.VISIBLE);
                                    fujianname8.setText(listacc.get(7).getFileName());
                                    final String url8 = listacc.get(7).getFileaddressdown();
                                    fujian8.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url8);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian9.setVisibility(View.VISIBLE);
                                    fujianname9.setText(listacc.get(8).getFileName());
                                    final String url9 = listacc.get(8).getFileaddressdown();
                                    fujian9.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url9);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!=null&&listacc.size()==10) {
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian7.setVisibility(View.VISIBLE);
                                    fujianname7.setText(listacc.get(6).getFileName());
                                    final String url7 = listacc.get(6).getFileaddressdown();
                                    fujian7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url7);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian8.setVisibility(View.VISIBLE);
                                    fujianname8.setText(listacc.get(7).getFileName());
                                    final String url8 = listacc.get(7).getFileaddressdown();
                                    fujian8.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url8);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian9.setVisibility(View.VISIBLE);
                                    fujianname9.setText(listacc.get(8).getFileName());
                                    final String url9 = listacc.get(8).getFileaddressdown();
                                    fujian9.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url9);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian10.setVisibility(View.VISIBLE);
                                    fujianname10.setText(listacc.get(9).getFileName());
                                    final String url10 = listacc.get(9).getFileaddressdown();
                                    fujian10.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url10);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            }
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

        zerenren.setText(zerenrenn);
        wanchengriqi.setText(riqi);
        shangbaozhouqi.setText(zhouqi);

        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
                intent.putExtra("taskidchat",taskid);
                Intent intent = new Intent(Activity_zirenwu23.this, Activity_Chat.class);
                startActivity(intent);
            }
        });
        huibao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Activity_zirenwu23.this,Activity_huibao2.class);
//                intent1.putExtra("userid",userid);
                intent1.putExtra("taskid88",taskid);
                startActivity(intent1);

            }
        });

    }
    //方法3 onWindowFocusChanged（true） 表示view已经初始化完毕了
    // 不过注意：onWindowFocusChanged 方法会在activity获得焦点和失去焦点的时候调用
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            LogUtil.d("从我这走了-----","进度条");
            setPos();
        }
    }
    private void setPosWay1() {
        progesssValue.post(new Runnable() {
            @Override
            public void run() {
                setPos();
            }
        });
    }

    /**
     * 设置进度显示在对应的位置
     */
    public void setPos() {
        int w = getWindowManager().getDefaultDisplay().getWidth();
//        Log.e("w=====", "" + w);
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
        LogUtil.d("真正的设置了进度条---","进度条");
        progesssValue.setLayoutParams(params);

    }


    @Override
    protected int getLayoutId() {

        return R.layout.activity_zirenwu7;
    }
}
