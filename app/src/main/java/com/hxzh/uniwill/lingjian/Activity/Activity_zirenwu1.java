package com.hxzh.uniwill.lingjian.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.FileUtils2;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.io.File;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/3/31.
 */
public class Activity_zirenwu1 extends BaseToobarRightViewActivity {

    private String userid,taskid,zerenrenn,riqi,zhouqi,miaoshu,userid2;
    private TextView zerenren,wanchengriqi,shangbaozhouqi;
    private EditText renwubiaozhun;
//    private BubbleSeekBar mBbubbleSeekBar;
    private int myprogress;
    private RelativeLayout huibao;
    private RelativeLayout change1;
    private Data_huoqurenwuxiangqing renwuxiangqing;
    private List<Data_huoqurenwuxiangqing.ListBean> list;
    private List<Data_huoqurenwuxiangqing.ListAccBean> listAcc;
    private ProgressBar progesss;
    private TextView progesssValue;
    private int x0,x1, x2, dx;
    private LinearLayout full;
    private String chang_msg1;
    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,fujian10,fujian11,fujian12,fujian13,fujian14,fujian15,fujian16,fujian17,fujian18,fujian19,fujian20;
    private RelativeLayout addfujian;
    private TextView fujiantext1,fujiantext2,fujiantext3,fujiantext4,fujiantext5,fujiantext6,fujiantext7,fujiantext8,fujiantext9,fujiantext10,fujiantext11,fujiantext12,fujiantext13,fujiantext14,fujiantext15,fujiantext16,fujiantext17,fujiantext18,fujiantext19,fujiantext20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("待办任务-子任务");
        getToobarRightView().setImageResource(R.drawable.title_but_chat_3x);
        initview();
        initData();
        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
                Intent intent = new Intent(Activity_zirenwu1.this,Activity_Chat.class);
                intent.putExtra("taskidchat",taskid);
                startActivity(intent);
            }
        });

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

        addfujian = (RelativeLayout) findViewById(R.id.layout_tianjiafujian);
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
        fujian11 = (RelativeLayout) findViewById(R.id.fujian11);
        fujian12 = (RelativeLayout) findViewById(R.id.fujian12);
        fujian13 = (RelativeLayout) findViewById(R.id.fujian13);
        fujian14 = (RelativeLayout) findViewById(R.id.fujian14);
        fujian15 = (RelativeLayout) findViewById(R.id.fujian15);
        fujian16 = (RelativeLayout) findViewById(R.id.fujian16);
        fujian17 = (RelativeLayout) findViewById(R.id.fujian17);
        fujian18 = (RelativeLayout) findViewById(R.id.fujian18);
        fujian19 = (RelativeLayout) findViewById(R.id.fujian19);
        fujian20 = (RelativeLayout) findViewById(R.id.fujian20);
        fujiantext1 = (TextView) findViewById(R.id.fujiantext1);
        fujiantext2 = (TextView) findViewById(R.id.fujiantext2);
        fujiantext3 = (TextView) findViewById(R.id.fujiantext3);
        fujiantext4 = (TextView) findViewById(R.id.fujiantext4);
        fujiantext5 = (TextView) findViewById(R.id.fujiantext5);
        fujiantext6 = (TextView) findViewById(R.id.fujiantext6);
        fujiantext7 = (TextView) findViewById(R.id.fujiantext7);
        fujiantext8 = (TextView) findViewById(R.id.fujiantext8);
        fujiantext9 = (TextView) findViewById(R.id.fujiantext9);
        fujiantext10 = (TextView) findViewById(R.id.fujiantext10);
        fujiantext11 = (TextView) findViewById(R.id.fujiantext11);
        fujiantext12 = (TextView) findViewById(R.id.fujiantext12);
        fujiantext13 = (TextView) findViewById(R.id.fujiantext13);
        fujiantext14 = (TextView) findViewById(R.id.fujiantext14);
        fujiantext15 = (TextView) findViewById(R.id.fujiantext15);
        fujiantext16 = (TextView) findViewById(R.id.fujiantext16);
        fujiantext17 = (TextView) findViewById(R.id.fujiantext17);
        fujiantext18 = (TextView) findViewById(R.id.fujiantext18);
        fujiantext19 = (TextView) findViewById(R.id.fujiantext19);
        fujiantext20 = (TextView) findViewById(R.id.fujiantext20);

    }

    private void initData() {
        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid1");
        LogUtil.d("taskid汇报",taskid+"----");
        userid = intent.getStringExtra("useid1");
        userid2 = SharedPreferencesUtil.readUserid(Activity_zirenwu1.this);
        zerenrenn = intent.getStringExtra("zerenrename1");
        zhouqi = intent.getStringExtra("baozhouqi1");
        riqi = intent.getStringExtra("wantime1");
        miaoshu = intent.getStringExtra("miaoshu1");
        try {
            OkHttpUtils.get(Http_Api.URL_renwuxiangqing)
                    .params("userid",userid)
                    .params("taskid",taskid)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            renwuxiangqing = JsonUtil.parseJsonToBean(s,Data_huoqurenwuxiangqing.class);
                            if (renwuxiangqing!=null){
                                list = renwuxiangqing.getList();
                                miaoshu = renwuxiangqing.getTaskcontent();
                                if (!SharedPreferencesUtil.readSonchange1(Activity_zirenwu1.this).equals("")){
                                    renwubiaozhun.setText(SharedPreferencesUtil.readSonchange1(Activity_zirenwu1.this));
                                }else {
                                    renwubiaozhun.setText(miaoshu);
                                }
                                myprogress = list.get(0).getProgress();
                                progesss.setProgress(myprogress);
                                progesssValue.setText(new StringBuffer().append(progesss.getProgress()).append("%"));
                                setPosWay1();
                                LogUtil.d("任务标准",miaoshu+"");
                                LogUtil.d("进度3---",myprogress+"");

                                listAcc = renwuxiangqing.getListAcc();
                                if (listAcc == null){
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
                                if (listAcc!=null&&listAcc.size() == 1){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                if (listAcc!=null&&listAcc.size() == 2){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                if (listAcc!=null&&listAcc.size() == 3){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                    fujiantext3.setText(listAcc.get(2).getFileName());
                                    final String url3 = listAcc.get(2).getFileaddressdown();
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
                                if (listAcc!=null&&listAcc.size() == 4){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                    fujiantext3.setText(listAcc.get(2).getFileName());
                                    final String url3 = listAcc.get(2).getFileaddressdown();
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
                                    fujiantext4.setText(listAcc.get(3).getFileName());
                                    final String url4 = listAcc.get(3).getFileaddressdown();
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
                                if (listAcc!=null&&listAcc.size() == 5){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                    fujiantext3.setText(listAcc.get(2).getFileName());
                                    final String url3 = listAcc.get(2).getFileaddressdown();
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
                                    fujiantext4.setText(listAcc.get(3).getFileName());
                                    final String url4 = listAcc.get(3).getFileaddressdown();
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
                                    fujiantext5.setText(listAcc.get(4).getFileName());
                                    final String url5 = listAcc.get(4).getFileaddressdown();
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
                                if (listAcc!=null&&listAcc.size() == 6){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                    fujiantext3.setText(listAcc.get(2).getFileName());
                                    final String url3 = listAcc.get(2).getFileaddressdown();
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
                                    fujiantext4.setText(listAcc.get(3).getFileName());
                                    final String url4 = listAcc.get(3).getFileaddressdown();
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
                                    fujiantext5.setText(listAcc.get(4).getFileName());
                                    final String url5 = listAcc.get(4).getFileaddressdown();
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
                                    fujiantext6.setText(listAcc.get(5).getFileName());
                                    final String url6 = listAcc.get(5).getFileaddressdown();
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
                                if (listAcc!=null&&listAcc.size() == 7){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                    fujiantext3.setText(listAcc.get(2).getFileName());
                                    final String url3 = listAcc.get(2).getFileaddressdown();
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
                                    fujiantext4.setText(listAcc.get(3).getFileName());
                                    final String url4 = listAcc.get(3).getFileaddressdown();
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
                                    fujiantext5.setText(listAcc.get(4).getFileName());
                                    final String url5 = listAcc.get(4).getFileaddressdown();
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
                                    fujiantext6.setText(listAcc.get(5).getFileName());
                                    final String url6 = listAcc.get(5).getFileaddressdown();
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
                                    fujiantext7.setText(listAcc.get(6).getFileName());
                                    final String url7 = listAcc.get(6).getFileaddressdown();
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

                                if (listAcc!=null&&listAcc.size() == 8){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                    fujiantext3.setText(listAcc.get(2).getFileName());
                                    final String url3 = listAcc.get(2).getFileaddressdown();
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
                                    fujiantext4.setText(listAcc.get(3).getFileName());
                                    final String url4 = listAcc.get(3).getFileaddressdown();
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
                                    fujiantext5.setText(listAcc.get(4).getFileName());
                                    final String url5 = listAcc.get(4).getFileaddressdown();
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
                                    fujiantext6.setText(listAcc.get(5).getFileName());
                                    final String url6 = listAcc.get(5).getFileaddressdown();
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
                                    fujiantext7.setText(listAcc.get(6).getFileName());
                                    final String url7 = listAcc.get(6).getFileaddressdown();
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
                                    fujiantext8.setText(listAcc.get(7).getFileName());
                                    final String url8 = listAcc.get(7).getFileaddressdown();
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
                                if (listAcc!=null&&listAcc.size() == 9){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                    fujiantext3.setText(listAcc.get(2).getFileName());
                                    final String url3 = listAcc.get(2).getFileaddressdown();
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
                                    fujiantext4.setText(listAcc.get(3).getFileName());
                                    final String url4 = listAcc.get(3).getFileaddressdown();
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
                                    fujiantext5.setText(listAcc.get(4).getFileName());
                                    final String url5 = listAcc.get(4).getFileaddressdown();
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
                                    fujiantext6.setText(listAcc.get(5).getFileName());
                                    final String url6 = listAcc.get(5).getFileaddressdown();
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
                                    fujiantext7.setText(listAcc.get(6).getFileName());
                                    final String url7 = listAcc.get(6).getFileaddressdown();
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
                                    fujiantext8.setText(listAcc.get(7).getFileName());
                                    final String url8 = listAcc.get(7).getFileaddressdown();
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
                                    fujiantext9.setText(listAcc.get(8).getFileName());
                                    final String url9 = listAcc.get(8).getFileaddressdown();
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
                                if (listAcc!=null&&listAcc.size() == 10){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujiantext1.setText(listAcc.get(0).getFileName());
                                    final String url = listAcc.get(0).getFileaddressdown();
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
                                    fujiantext2.setText(listAcc.get(1).getFileName());
                                    final String url2 = listAcc.get(1).getFileaddressdown();
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
                                    fujiantext3.setText(listAcc.get(2).getFileName());
                                    final String url3 = listAcc.get(2).getFileaddressdown();
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
                                    fujiantext4.setText(listAcc.get(3).getFileName());
                                    final String url4 = listAcc.get(3).getFileaddressdown();
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
                                    fujiantext5.setText(listAcc.get(4).getFileName());
                                    final String url5 = listAcc.get(4).getFileaddressdown();
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
                                    fujiantext6.setText(listAcc.get(5).getFileName());
                                    final String url6 = listAcc.get(5).getFileaddressdown();
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
                                    fujiantext7.setText(listAcc.get(6).getFileName());
                                    final String url7 = listAcc.get(6).getFileaddressdown();
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
                                    fujiantext8.setText(listAcc.get(7).getFileName());
                                    final String url8 = listAcc.get(7).getFileaddressdown();
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
                                    fujiantext9.setText(listAcc.get(8).getFileName());
                                    final String url9 = listAcc.get(8).getFileaddressdown();
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

                                    fujian10.setVisibility(View.VISIBLE);
                                    fujiantext10.setText(listAcc.get(9).getFileName());
                                    final String url10 = listAcc.get(9).getFileaddressdown();
                                    fujian10.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
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

//        full.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int w = getWindowManager().getDefaultDisplay().getWidth();
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        x1 = (int) event.getRawX();
//                        progesss.setProgress(100 * x1 / w);
//                        setPos();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        x2 = (int) event.getRawX();
//                        dx = x2 - x1;
//                        if (Math.abs(dx) > w / 100) { //改变条件 调整进度改变速度
//                            x1 = x2; // 去掉已经用掉的距离， 去掉这句 运行看看会出现效果
//                            progesss.setProgress(progesss.getProgress() + dx * 100 / w);
//                            setPos();
//                        }
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        break;
//                }
//                return true;
//            }
//        });

        zerenren.setText(zerenrenn);
        wanchengriqi.setText(riqi);
        shangbaozhouqi.setText(zhouqi);
//        shangbaozhouqi.setText("当前任务");

//        getToobarRightView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showToast("聊天");
//                Intent intent = new Intent(Activity_zirenwu1.this, Activity_Chat.class);
//                startActivity(intent);
//            }
//        });
        huibao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Activity_zirenwu1.this,Activity_huibao.class);
                intent1.putExtra("taskid",taskid);
                startActivity(intent1);

            }
        });
        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chang_msg1 = renwubiaozhun.getText().toString().trim();
                myprogress = progesss.getProgress();
                LogUtil.d("修改的信息1",chang_msg1+"");
                LogUtil.d("修改的进度",myprogress+"");
                SharedPreferencesUtil.writeSonchange1(chang_msg1,Activity_zirenwu1.this);
                SharedPreferencesUtil.writeSonchangeProgress1(myprogress,Activity_zirenwu1.this);

                ToastUtil.showToast("修改完成");
                finish();
            }
        });

        addfujian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("添加附件");
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent,1);
                //startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), 1);
                //intent.setType(“image/*”);//选择图片
                //intent.setType(“audio/*”); //选择音频
                //intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
                //intent.setType(“video/*;image/*”);//同时选择视频和图片
            }
        });

    }

    //文件路径
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK){//是否选择，没选择就不会继续
            try {
                Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
                LogUtil.d("文件路径--",uri+"");
                String url = FileUtils2.getPath(Activity_zirenwu1.this,uri);
                String url2 = url.trim();
                UploadFile(url2);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            String[] proj = {MediaStore.Images.Media.DATA};
//            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
//            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            actualimagecursor.moveToFirst();
//            String img_path = actualimagecursor.getString(actual_image_column_index);
//            File file = new File(img_path);
//            Toast.makeText(Activity_Deatail.this, file.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private int fujianNum = 0;
    public void UploadFile(String url){
        File file = new File(url);
        String filename = file.getName();
        fujianNum++;
        if (fujianNum >= 10){
            fujianNum = 0;
        }
        ShowAcc(fujianNum,filename);
        LogUtil.d("文件名字",filename+"");
        if (!file.exists()){
            ToastUtil.showToast("文件不存在");
        }
        try {
            OkHttpUtils.post(Http_Api.URL_Fujian_upload)
                    .params("userid",userid2)
                    .params("taskid",taskid)
                    .params("assid","")
                    .params("file",file)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回",s+"");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ShowAcc(int o,String m){
        if (o == 0){
            fujian11.setVisibility(View.GONE);
            fujian12.setVisibility(View.GONE);
            fujian13.setVisibility(View.GONE);
            fujian14.setVisibility(View.GONE);
            fujian15.setVisibility(View.GONE);
            fujian16.setVisibility(View.GONE);
            fujian17.setVisibility(View.GONE);
            fujian18.setVisibility(View.GONE);
            fujian19.setVisibility(View.GONE);
            fujian20.setVisibility(View.GONE);
        }
        if (o == 1){
            fujian11.setVisibility(View.VISIBLE);
            fujiantext11.setText(m);
        }
        if (o == 2){
            fujian12.setVisibility(View.VISIBLE);
            fujiantext12.setText(m);
        }
        if (o == 3){
            fujian13.setVisibility(View.VISIBLE);
            fujiantext13.setText(m);
        }
        if (o == 4){
            fujian14.setVisibility(View.VISIBLE);
            fujiantext14.setText(m);
        }
        if (o ==5){
            fujian15.setVisibility(View.VISIBLE);
            fujiantext15.setText(m);
        }
        if (o ==6){
            fujian16.setVisibility(View.VISIBLE);
            fujiantext16.setText(m);
        }
        if (o ==7){
            fujian17.setVisibility(View.VISIBLE);
            fujiantext17.setText(m);
        }
        if (o ==8){
            fujian18.setVisibility(View.VISIBLE);
            fujiantext18.setText(m);
        }
        if (o == 9){
            fujian19.setVisibility(View.VISIBLE);
            fujiantext19.setText(m);
        }
        if (o == 10){
            fujian20.setVisibility(View.VISIBLE);
            fujiantext20.setText(m);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
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

    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_zirenwu1;
    }


}
