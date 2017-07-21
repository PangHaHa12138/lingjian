package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.PercentCircle;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.bean.Data_huoqurenwuxiangqing;
import com.hxzh.uniwill.lingjian.bean.Data_xiafafujian;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/4/18.
 *  任务进度 详情 带子任务
 */
public class Activity_zirenwu_deatil2 extends BaseToobarRightViewActivity{

    private PercentCircle jindu;
    private TextView zname,biaozun;
    private String taskid,userid,zerenren,miaoshu,taskidson,taskid2,taskname;
    private int progres1;
    private String peoplename,finshdata,zhouq;
    private int zhouqi,pross;
    private Data_huoqurenwuxiangqing renwuxiangqing;
    private List<Data_huoqurenwuxiangqing.ListBean> list2;
    private List<Data_huoqurenwuxiangqing.ChildsBean> list1;
//    private List<Data_huoqurenwuxiangqing.ListAccBean> listacc;
    private Data_huoqurenwuxiangqing.ListBean data1;
    private Data_huoqurenwuxiangqing.ChildsBean data2;

    private List<Data_xiafafujian.FileBean> listacc;

//    private SwipeMenuListView listView;
    private View headerview;
    private String name1="",name2="",name3="",name4="",name5="",name6="",name7="",name8="",name9="",name10="";
    private List<String> a,b,c,d,e,f,g,h,m,k;

    private RelativeLayout son1;
    private RelativeLayout son2;
    private RelativeLayout son3;
    private RelativeLayout son4;
    private RelativeLayout son5,son6,son7,son8,son9,son10;
    private TextView sontext1,sontext2,sontext3,sontext4,sontext5,sontext6,sontext7,sontext8,sontext9,sontext10;
    private List<String> namelist;

    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,
            fujian10;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("任务进度");
        initView();
        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
                Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_Chat.class);
                intent.putExtra("taskidchat",taskid2);
                startActivity(intent);
            }
        });

    }
    private void initView() {

        jindu = (PercentCircle)findViewById(R.id.zirenwu_deatil_jindutiao2);
        zname = (TextView)findViewById(R.id.zi_datail_name2);
        biaozun = (TextView)findViewById(R.id.zi_datail_biaozhuntext2);

        son1 = (RelativeLayout) findViewById(R.id.son1);
        son2 = (RelativeLayout) findViewById(R.id.son2);
        son3 = (RelativeLayout) findViewById(R.id.son3);
        son4 = (RelativeLayout) findViewById(R.id.son4);
        son5 = (RelativeLayout) findViewById(R.id.son5);
        son6 = (RelativeLayout) findViewById(R.id.son6);
        son7 = (RelativeLayout) findViewById(R.id.son7);
        son8 = (RelativeLayout) findViewById(R.id.son8);
        son9 = (RelativeLayout) findViewById(R.id.son9);
        son10 = (RelativeLayout) findViewById(R.id.son10);

        sontext1 = (TextView) findViewById(R.id.sontext1);
        sontext2 = (TextView) findViewById(R.id.sontext2);
        sontext3 = (TextView) findViewById(R.id.sontext3);
        sontext4 = (TextView) findViewById(R.id.sontext4);
        sontext5 = (TextView) findViewById(R.id.sontext5);
        sontext6 = (TextView) findViewById(R.id.sontext6);
        sontext7 = (TextView) findViewById(R.id.sontext7);
        sontext8 = (TextView) findViewById(R.id.sontext8);
        sontext9 = (TextView) findViewById(R.id.sontext9);
        sontext10 = (TextView) findViewById(R.id.sontext10);

        fujian1 = (RelativeLayout) findViewById(R.id.zi_datail_fujian1);
        fujian2 = (RelativeLayout) findViewById(R.id.zi_datail_fujian2);
        fujian3 = (RelativeLayout) findViewById(R.id.zi_datail_fujian3);
        fujian4 = (RelativeLayout) findViewById(R.id.zi_datail_fujian4);
        fujian5 = (RelativeLayout) findViewById(R.id.zi_datail_fujian5);
        fujian6 = (RelativeLayout) findViewById(R.id.zi_datail_fujian6);
        fujian7 = (RelativeLayout) findViewById(R.id.zi_datail_fujian7);
        fujian8 = (RelativeLayout) findViewById(R.id.zi_datail_fujian8);
        fujian9 = (RelativeLayout) findViewById(R.id.zi_datail_fujian9);
        fujian10 = (RelativeLayout) findViewById(R.id.zi_datail_fujian10);
        fujianname1 = (TextView) findViewById(R.id.zi_datail_fujiantext1);
        fujianname2 = (TextView) findViewById(R.id.zi_datail_fujiantext2);
        fujianname3 = (TextView) findViewById(R.id.zi_datail_fujiantext3);
        fujianname4 = (TextView) findViewById(R.id.zi_datail_fujiantext4);
        fujianname5 = (TextView) findViewById(R.id.zi_datail_fujiantext5);
        fujianname6 = (TextView) findViewById(R.id.zi_datail_fujiantext6);
        fujianname7 = (TextView) findViewById(R.id.zi_datail_fujiantext7);
        fujianname8 = (TextView) findViewById(R.id.zi_datail_fujiantext8);
        fujianname9 = (TextView) findViewById(R.id.zi_datail_fujiantext9);
        fujianname10 = (TextView) findViewById(R.id.zi_datail_fujiantext10);

    initData();
    }


    private void initData() {
        EventBus.getDefault().register(Activity_zirenwu_deatil2.this);
        progres1 = SharedPreferencesUtil.readSonProgress(Activity_zirenwu_deatil2.this);
        LogUtil.d("进度--是--",progres1+"%---");
        zerenren = SharedPreferencesUtil.readSonZerenren(Activity_zirenwu_deatil2.this);
        miaoshu = SharedPreferencesUtil.readSonMsg(Activity_zirenwu_deatil2.this);
        jindu.setTargetPercent(progres1);
        zname.setText(zerenren);
        biaozun.setText(miaoshu);
        Intent intent = getIntent();
        userid = intent.getStringExtra("useridson");
        taskid2 = intent.getStringExtra("taskidsonson");
        LogUtil.d("id---------",taskid2);

        OkHttpUtils.get(Http_Api.URL_XiafaFujian)
                .params("userid",userid)
                .params("taskid",taskid2)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Data_xiafafujian xiafafujian = JsonUtil.parseJsonToBean(s,Data_xiafafujian.class);

                        String num = xiafafujian.getResult();

                        listacc = xiafafujian.getFile();

                        if (num.equals("0")){

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
                        }else {
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

        try {
            OkHttpUtils.get(Http_Api.URL_renwuxiangqing)
                    .params("userid",userid)
                    .params("taskid",taskid2)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            renwuxiangqing = JsonUtil.parseJsonToBean(s,Data_huoqurenwuxiangqing.class);
                            if (renwuxiangqing != null){
                                list2 = renwuxiangqing.getList();
                                list1 = renwuxiangqing.getChilds();
                                if (list1!=null){
                                    LogUtil.d("list1子任务列表---->",list1.size()+"<---");
                                }

//                                listacc = renwuxiangqing.getListAcc();
//                                if (listacc == null){
//                                    fujian1.setVisibility(View.GONE);
//                                    fujian2.setVisibility(View.GONE);
//                                    fujian3.setVisibility(View.GONE);
//                                    fujian4.setVisibility(View.GONE);
//                                    fujian5.setVisibility(View.GONE);
//                                    fujian6.setVisibility(View.GONE);
//                                    fujian7.setVisibility(View.GONE);
//                                    fujian8.setVisibility(View.GONE);
//                                    fujian9.setVisibility(View.GONE);
//                                    fujian10.setVisibility(View.GONE);
//                                }
//                                if (listacc!= null&&listacc.size()==1){
//
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//
//                                }
//                                if (listacc!=null&&listacc.size()==2){
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//                                    if (!listacc.get(1).getAssid().equals("-1")){
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                }
//                                if (listacc!=null&&listacc.size() == 3){
//
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//
//                                    if (!listacc.get(1).getAssid().equals("-1")){
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//
//                                    }
//
//                                    if (!listacc.get(2).getAssid().equals("-1")){
//                                        fujian3.setVisibility(View.VISIBLE);
//                                        fujianname3.setText(listacc.get(2).getFileName());
//                                        final String url3 = listacc.get(2).getFileaddressdown();
//                                        fujian3.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url3);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                }
//                                if (listacc!= null&&listacc.size()==4){
//
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//
//                                    if (!listacc.get(1).getAssid().equals("-1")){
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(2).getAssid().equals("-1")){
//                                        fujian3.setVisibility(View.VISIBLE);
//                                        fujianname3.setText(listacc.get(2).getFileName());
//                                        final String url3 = listacc.get(2).getFileaddressdown();
//                                        fujian3.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url3);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(3).getAssid().equals("-1")){
//                                        fujian4.setVisibility(View.VISIBLE);
//                                        fujianname4.setText(listacc.get(3).getFileName());
//                                        final String url4 = listacc.get(3).getFileaddressdown();
//                                        fujian4.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url4);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                }
//                                if (listacc!=null&&listacc.size() == 5){
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(1).getAssid().equals("-1")){
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(2).getAssid().equals("-1")){
//                                        fujian3.setVisibility(View.VISIBLE);
//                                        fujianname3.setText(listacc.get(2).getFileName());
//                                        final String url3 = listacc.get(2).getFileaddressdown();
//                                        fujian3.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url3);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(3).getAssid().equals("-1")){
//                                        fujian4.setVisibility(View.VISIBLE);
//                                        fujianname4.setText(listacc.get(3).getFileName());
//                                        final String url4 = listacc.get(3).getFileaddressdown();
//                                        fujian4.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url4);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(4).getAssid().equals("-1")){
//                                        fujian5.setVisibility(View.VISIBLE);
//                                        fujianname5.setText(listacc.get(4).getFileName());
//                                        final String url5 = listacc.get(4).getFileaddressdown();
//                                        fujian5.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url5);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                }
//                                if (listacc != null&&listacc.size() == 6){
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(1).getAssid().equals("-1")){
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(2).getAssid().equals("-1")){
//                                        fujian3.setVisibility(View.VISIBLE);
//                                        fujianname3.setText(listacc.get(2).getFileName());
//                                        final String url3 = listacc.get(2).getFileaddressdown();
//                                        fujian3.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url3);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(3).getAssid().equals("-1")){
//                                        fujian4.setVisibility(View.VISIBLE);
//                                        fujianname4.setText(listacc.get(3).getFileName());
//                                        final String url4 = listacc.get(3).getFileaddressdown();
//                                        fujian4.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url4);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(4).getAssid().equals("-1")){
//                                        fujian5.setVisibility(View.VISIBLE);
//                                        fujianname5.setText(listacc.get(4).getFileName());
//                                        final String url5 = listacc.get(4).getFileaddressdown();
//                                        fujian5.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url5);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(5).getAssid().equals("-1")){
//                                        fujian6.setVisibility(View.VISIBLE);
//                                        fujianname6.setText(listacc.get(5).getFileName());
//                                        final String url6 = listacc.get(5).getFileaddressdown();
//                                        fujian6.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url6);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                }
//                                if (listacc != null&&listacc.size() == 7){
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(1).getAssid().equals("-1")){
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(2).getAssid().equals("-1")){
//                                        fujian3.setVisibility(View.VISIBLE);
//                                        fujianname3.setText(listacc.get(2).getFileName());
//                                        final String url3 = listacc.get(2).getFileaddressdown();
//                                        fujian3.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url3);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(3).getAssid().equals("-1")){
//                                        fujian4.setVisibility(View.VISIBLE);
//                                        fujianname4.setText(listacc.get(3).getFileName());
//                                        final String url4 = listacc.get(3).getFileaddressdown();
//                                        fujian4.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url4);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(4).getAssid().equals("-1")){
//                                        fujian5.setVisibility(View.VISIBLE);
//                                        fujianname5.setText(listacc.get(4).getFileName());
//                                        final String url5 = listacc.get(4).getFileaddressdown();
//                                        fujian5.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url5);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(5).getAssid().equals("-1")){
//                                        fujian6.setVisibility(View.VISIBLE);
//                                        fujianname6.setText(listacc.get(5).getFileName());
//                                        final String url6 = listacc.get(5).getFileaddressdown();
//                                        fujian6.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url6);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(6).getAssid().equals("-1")){
//                                        fujian7.setVisibility(View.VISIBLE);
//                                        fujianname7.setText(listacc.get(6).getFileName());
//                                        final String url7 = listacc.get(6).getFileaddressdown();
//                                        fujian7.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url7);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                }
//                                if (listacc!=null&&listacc.size() == 8){
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(1).getAssid().equals("-1")){
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(2).getAssid().equals("-1")){
//                                        fujian3.setVisibility(View.VISIBLE);
//                                        fujianname3.setText(listacc.get(2).getFileName());
//                                        final String url3 = listacc.get(2).getFileaddressdown();
//                                        fujian3.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url3);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(3).getAssid().equals("-1")){
//                                        fujian4.setVisibility(View.VISIBLE);
//                                        fujianname4.setText(listacc.get(3).getFileName());
//                                        final String url4 = listacc.get(3).getFileaddressdown();
//                                        fujian4.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url4);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(4).getAssid().equals("-1")){
//                                        fujian5.setVisibility(View.VISIBLE);
//                                        fujianname5.setText(listacc.get(4).getFileName());
//                                        final String url5 = listacc.get(4).getFileaddressdown();
//                                        fujian5.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url5);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(5).getAssid().equals("-1")){
//                                        fujian6.setVisibility(View.VISIBLE);
//                                        fujianname6.setText(listacc.get(5).getFileName());
//                                        final String url6 = listacc.get(5).getFileaddressdown();
//                                        fujian6.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url6);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//
//                                    if (!listacc.get(6).getAssid().equals("-1")){
//                                        fujian7.setVisibility(View.VISIBLE);
//                                        fujianname7.setText(listacc.get(6).getFileName());
//                                        final String url7 = listacc.get(6).getFileaddressdown();
//                                        fujian7.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url7);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(7).getAssid().equals("-1")){
//                                        fujian8.setVisibility(View.VISIBLE);
//                                        fujianname8.setText(listacc.get(7).getFileName());
//                                        final String url8 = listacc.get(7).getFileaddressdown();
//                                        fujian8.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url8);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//
//                                }
//                                if (listacc!= null&&listacc.size()==9){
//                                    if (!listacc.get(0).getAssid().equals("-1")){
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(1).getAssid().equals("-1")){
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(2).getAssid().equals("-1")){
//                                        fujian3.setVisibility(View.VISIBLE);
//                                        fujianname3.setText(listacc.get(2).getFileName());
//                                        final String url3 = listacc.get(2).getFileaddressdown();
//                                        fujian3.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url3);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(3).getAssid().equals("-1")){
//                                        fujian4.setVisibility(View.VISIBLE);
//                                        fujianname4.setText(listacc.get(3).getFileName());
//                                        final String url4 = listacc.get(3).getFileaddressdown();
//                                        fujian4.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url4);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(4).getAssid().equals("-1")){
//                                        fujian5.setVisibility(View.VISIBLE);
//                                        fujianname5.setText(listacc.get(4).getFileName());
//                                        final String url5 = listacc.get(4).getFileaddressdown();
//                                        fujian5.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url5);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(5).getAssid().equals("-1")){
//                                        fujian6.setVisibility(View.VISIBLE);
//                                        fujianname6.setText(listacc.get(5).getFileName());
//                                        final String url6 = listacc.get(5).getFileaddressdown();
//                                        fujian6.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url6);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(6).getAssid().equals("-1")){
//                                        fujian7.setVisibility(View.VISIBLE);
//                                        fujianname7.setText(listacc.get(6).getFileName());
//                                        final String url7 = listacc.get(6).getFileaddressdown();
//                                        fujian7.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url7);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(7).getAssid().equals("-1")){
//                                        fujian8.setVisibility(View.VISIBLE);
//                                        fujianname8.setText(listacc.get(7).getFileName());
//                                        final String url8 = listacc.get(7).getFileaddressdown();
//                                        fujian8.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url8);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(8).getAssid().equals("-1")){
//                                        fujian9.setVisibility(View.VISIBLE);
//                                        fujianname9.setText(listacc.get(8).getFileName());
//                                        final String url9 = listacc.get(8).getFileaddressdown();
//                                        fujian9.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent= new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url9);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                }
//                                if (listacc!=null&&listacc.size()==10) {
//                                    if (!listacc.get(0).getAssid().equals("-1")) {
//                                        fujian1.setVisibility(View.VISIBLE);
//                                        fujianname1.setText(listacc.get(0).getFileName());
//                                        final String url = listacc.get(0).getFileaddressdown();
//                                        fujian1.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(1).getAssid().equals("-1")) {
//                                        fujian2.setVisibility(View.VISIBLE);
//                                        fujianname2.setText(listacc.get(1).getFileName());
//                                        final String url2 = listacc.get(1).getFileaddressdown();
//                                        fujian2.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url2);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(2).getAssid().equals("-1")) {
//                                        fujian3.setVisibility(View.VISIBLE);
//                                        fujianname3.setText(listacc.get(2).getFileName());
//                                        final String url3 = listacc.get(2).getFileaddressdown();
//                                        fujian3.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url3);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(3).getAssid().equals("-1")) {
//                                        fujian4.setVisibility(View.VISIBLE);
//                                        fujianname4.setText(listacc.get(3).getFileName());
//                                        final String url4 = listacc.get(3).getFileaddressdown();
//                                        fujian4.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url4);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(4).getAssid().equals("-1")) {
//                                        fujian5.setVisibility(View.VISIBLE);
//                                        fujianname5.setText(listacc.get(4).getFileName());
//                                        final String url5 = listacc.get(4).getFileaddressdown();
//                                        fujian5.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url5);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(5).getAssid().equals("-1")) {
//                                        fujian6.setVisibility(View.VISIBLE);
//                                        fujianname6.setText(listacc.get(5).getFileName());
//                                        final String url6 = listacc.get(5).getFileaddressdown();
//                                        fujian6.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url6);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(6).getAssid().equals("-1")) {
//                                        fujian7.setVisibility(View.VISIBLE);
//                                        fujianname7.setText(listacc.get(6).getFileName());
//                                        final String url7 = listacc.get(6).getFileaddressdown();
//                                        fujian7.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url7);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(7).getAssid().equals("-1")) {
//                                        fujian8.setVisibility(View.VISIBLE);
//                                        fujianname8.setText(listacc.get(7).getFileName());
//                                        final String url8 = listacc.get(7).getFileaddressdown();
//                                        fujian8.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url8);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(8).getAssid().equals("-1")) {
//                                        fujian9.setVisibility(View.VISIBLE);
//                                        fujianname9.setText(listacc.get(8).getFileName());
//                                        final String url9 = listacc.get(8).getFileaddressdown();
//                                        fujian9.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url9);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//
//                                    if (!listacc.get(9).getAssid().equals("-1")) {
//                                        fujian10.setVisibility(View.VISIBLE);
//                                        fujianname10.setText(listacc.get(9).getFileName());
//                                        final String url10 = listacc.get(9).getFileaddressdown();
//                                        fujian10.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                Intent intent = new Intent();
//                                                intent.setAction("android.intent.action.VIEW");
//                                                Uri content_url = Uri.parse(url10);
//                                                intent.setData(content_url);
//                                                startActivity(intent);
//                                            }
//                                        });
//                                    }
//                                }


                                onclick();
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent){

       namelist = messageEvent.getList();
        LogUtil.d("集合",namelist+"---");
        for (int i = 0; i < namelist.size(); i++) {
            String s = namelist.get(i);

            LogUtil.d("子任务名--fuck--",s);
        }

    }

    private void onclick() {

        if (list1!=null&&list1.size()>0&&list1.size() == 1){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.GONE);
            son3.setVisibility(View.GONE);
            son4.setVisibility(View.GONE);
            son5.setVisibility(View.GONE);
            son6.setVisibility(View.GONE);
            son7.setVisibility(View.GONE);
            son8.setVisibility(View.GONE);
            son9.setVisibility(View.GONE);
            son10.setVisibility(View.GONE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            LogUtil.d("taskname----->",name1+"--");
            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    LogUtil.d("进度传递的---",pross+"--二级页面");
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",name1);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });

        }
        if (list1!=null&&list1.size()>0&&list1.size() == 2){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.GONE);
            son4.setVisibility(View.GONE);
            son5.setVisibility(View.GONE);
            son6.setVisibility(View.GONE);
            son7.setVisibility(View.GONE);
            son8.setVisibility(View.GONE);
            son9.setVisibility(View.GONE);
            son10.setVisibility(View.GONE);
             a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            LogUtil.d("taskname----->",name1+"--");
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            LogUtil.d("taskname----->",name2+"--");
            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();

                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",name1);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",name2);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
        }
        if (list1!=null&&list1.size()>0&&list1.size() == 3){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.VISIBLE);
            son4.setVisibility(View.GONE);
            son5.setVisibility(View.GONE);
            son6.setVisibility(View.GONE);
            son7.setVisibility(View.GONE);
            son8.setVisibility(View.GONE);
            son9.setVisibility(View.GONE);
            son10.setVisibility(View.GONE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            LogUtil.d("taskname----->",name1+"--");
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            LogUtil.d("taskname----->",name2+"--");
            c = list1.get(2).getZi();
            for (int i = 0; i < c.size(); i++) {
                name3 += c.get(i)+";";
            }
            sontext3.setText(name3);
            LogUtil.d("taskname----->",name3+"--");
            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    peoplename = name1;
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    LogUtil.d("进度传递的---",pross+"--二级页面");
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    peoplename = name2;
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    LogUtil.d("进度传递的---",pross+"--二级页面");
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
            son3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(2).getTaskid();
                    peoplename = name3;
                    finshdata = list1.get(2).getYendtime();
                    pross = list1.get(2).getProgress();
                    LogUtil.d("进度传递的---",pross+"--二级页面");
                    zhouqi = list1.get(2).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
        }
        if (list1!=null&&list1.size()>0&&list1.size() == 4){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.VISIBLE);
            son4.setVisibility(View.VISIBLE);
            son5.setVisibility(View.GONE);
            son6.setVisibility(View.GONE);
            son7.setVisibility(View.GONE);
            son8.setVisibility(View.GONE);
            son9.setVisibility(View.GONE);
            son10.setVisibility(View.GONE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            c = list1.get(2).getZi();
            for (int i = 0; i < c.size(); i++) {
                name3 += c.get(i)+";";
            }
            sontext3.setText(name3);
            d = list1.get(3).getZi();
            for (int i = 0; i < d.size(); i++) {
                name4 += d.get(i)+";";
            }
            sontext4.setText(name4);

            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    peoplename = name1;
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    peoplename = name2;
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
            son3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(2).getTaskid();
                    peoplename = name3;
                    finshdata = list1.get(2).getYendtime();
                    pross = list1.get(2).getProgress();
                    zhouqi = list1.get(2).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
            son4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(3).getTaskid();
                    peoplename = name4;
                    finshdata = list1.get(4).getYendtime();
                    pross = list1.get(4).getProgress();
                    zhouqi = list1.get(4).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("taskid7",taskidson);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    startActivity(intent);
                }
            });
        }

        if (list1!=null&&list1.size()>0&&list1.size() == 5){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.VISIBLE);
            son4.setVisibility(View.VISIBLE);
            son5.setVisibility(View.VISIBLE);
            son6.setVisibility(View.GONE);
            son7.setVisibility(View.GONE);
            son8.setVisibility(View.GONE);
            son9.setVisibility(View.GONE);
            son10.setVisibility(View.GONE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            c = list1.get(2).getZi();
            for (int i = 0; i < c.size(); i++) {
                name3 += c.get(i)+";";
            }
            sontext3.setText(name3);
            d = list1.get(3).getZi();
            for (int i = 0; i < d.size(); i++) {
                name4 += d.get(i)+";";
            }
            sontext4.setText(name4);
            e = list1.get(4).getZi();
            for (int i = 0; i < e.size(); i++) {
                name5 += e.get(i)+";";
            }
            sontext5.setText(name5);

            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    peoplename = name1;
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    peoplename = name2;
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(2).getTaskid();
                    peoplename = name3;
                    finshdata = list1.get(2).getYendtime();
                    pross = list1.get(2).getProgress();
                    zhouqi = list1.get(2).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(3).getTaskid();
                    peoplename = name4;
                    finshdata = list1.get(3).getYendtime();
                    pross = list1.get(3).getProgress();
                    zhouqi = list1.get(3).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(4).getTaskid();
                    peoplename = name5;
                    finshdata = list1.get(4).getYendtime();
                    pross = list1.get(4).getProgress();
                    zhouqi = list1.get(4).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
        }
        if (list1!=null&&list1.size()>0&&list1.size() == 6){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.VISIBLE);
            son4.setVisibility(View.VISIBLE);
            son5.setVisibility(View.VISIBLE);
            son6.setVisibility(View.VISIBLE);
            son7.setVisibility(View.GONE);
            son8.setVisibility(View.GONE);
            son9.setVisibility(View.GONE);
            son10.setVisibility(View.GONE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            c = list1.get(2).getZi();
            for (int i = 0; i < c.size(); i++) {
                name3 += c.get(i)+";";
            }
            sontext3.setText(name3);
            d = list1.get(3).getZi();
            for (int i = 0; i < d.size(); i++) {
                name4 += d.get(i)+";";
            }
            sontext4.setText(name4);
            e = list1.get(4).getZi();
            for (int i = 0; i < e.size(); i++) {
                name5 += e.get(i)+";";
            }
            sontext5.setText(name5);

            f = list1.get(5).getZi();
            for (int i = 0; i < f.size(); i++) {
                name6 += f.get(i)+";";
            }
            sontext6.setText(name6);


            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    peoplename = name1;
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    peoplename = name2;
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(2).getTaskid();
                    peoplename = name3;
                    finshdata = list1.get(2).getYendtime();
                    pross = list1.get(2).getProgress();
                    zhouqi = list1.get(2).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(3).getTaskid();
                    peoplename = name4;
                    finshdata = list1.get(3).getYendtime();
                    pross = list1.get(3).getProgress();
                    zhouqi = list1.get(3).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(4).getTaskid();
                    peoplename = name5;
                    finshdata = list1.get(4).getYendtime();
                    pross = list1.get(4).getProgress();
                    zhouqi = list1.get(4).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(5).getTaskid();
                    peoplename = name6;
                    finshdata = list1.get(5).getYendtime();
                    pross = list1.get(5).getProgress();
                    zhouqi = list1.get(5).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
        }

        if (list1!=null&&list1.size()>0&&list1.size() == 7){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.VISIBLE);
            son4.setVisibility(View.VISIBLE);
            son5.setVisibility(View.VISIBLE);
            son6.setVisibility(View.VISIBLE);
            son7.setVisibility(View.VISIBLE);
            son8.setVisibility(View.GONE);
            son9.setVisibility(View.GONE);
            son10.setVisibility(View.GONE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            c = list1.get(2).getZi();
            for (int i = 0; i < c.size(); i++) {
                name3 += c.get(i)+";";
            }
            sontext3.setText(name3);
            d = list1.get(3).getZi();
            for (int i = 0; i < d.size(); i++) {
                name4 += d.get(i)+";";
            }
            sontext4.setText(name4);
            e = list1.get(4).getZi();
            for (int i = 0; i < e.size(); i++) {
                name5 += e.get(i)+";";
            }
            sontext5.setText(name5);

            f = list1.get(5).getZi();
            for (int i = 0; i < f.size(); i++) {
                name6 += f.get(i)+";";
            }
            sontext6.setText(name6);

            g = list1.get(6).getZi();
            for (int i = 0; i < g.size(); i++) {
                name7 += g.get(i)+";";
            }
            sontext7.setText(name7);


            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    peoplename = name1;
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    peoplename = name2;
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(2).getTaskid();
                    peoplename = name3;
                    finshdata = list1.get(2).getYendtime();
                    pross = list1.get(2).getProgress();
                    zhouqi = list1.get(2).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(3).getTaskid();
                    peoplename = name4;
                    finshdata = list1.get(3).getYendtime();
                    pross = list1.get(3).getProgress();
                    zhouqi = list1.get(3).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(4).getTaskid();
                    peoplename = name5;
                    finshdata = list1.get(4).getYendtime();
                    pross = list1.get(4).getProgress();
                    zhouqi = list1.get(4).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(5).getTaskid();
                    peoplename = name6;
                    finshdata = list1.get(5).getYendtime();
                    pross = list1.get(5).getProgress();
                    zhouqi = list1.get(5).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(6).getTaskid();
                    peoplename = name7;
                    finshdata = list1.get(6).getYendtime();
                    pross = list1.get(6).getProgress();
                    zhouqi = list1.get(6).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
        }
        if (list1!=null&&list1.size()>0&&list1.size() == 8){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.VISIBLE);
            son4.setVisibility(View.VISIBLE);
            son5.setVisibility(View.VISIBLE);
            son6.setVisibility(View.VISIBLE);
            son7.setVisibility(View.VISIBLE);
            son8.setVisibility(View.VISIBLE);
            son9.setVisibility(View.GONE);
            son10.setVisibility(View.GONE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            c = list1.get(2).getZi();
            for (int i = 0; i < c.size(); i++) {
                name3 += c.get(i)+";";
            }
            sontext3.setText(name3);
            d = list1.get(3).getZi();
            for (int i = 0; i < d.size(); i++) {
                name4 += d.get(i)+";";
            }
            sontext4.setText(name4);
            e = list1.get(4).getZi();
            for (int i = 0; i < e.size(); i++) {
                name5 += e.get(i)+";";
            }
            sontext5.setText(name5);

            f = list1.get(5).getZi();
            for (int i = 0; i < f.size(); i++) {
                name6 += f.get(i)+";";
            }
            sontext6.setText(name6);

            g = list1.get(6).getZi();
            for (int i = 0; i < g.size(); i++) {
                name7 += g.get(i)+";";
            }
            sontext7.setText(name7);

            h = list1.get(7).getZi();
            for (int i = 0; i < h.size(); i++) {
                name8 += h.get(i)+";";
            }
            sontext8.setText(name8);


            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    peoplename = name1;
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    peoplename = name2;
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(2).getTaskid();
                    peoplename = name3;
                    finshdata = list1.get(2).getYendtime();
                    pross = list1.get(2).getProgress();
                    zhouqi = list1.get(2).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(3).getTaskid();
                    peoplename = name4;
                    finshdata = list1.get(3).getYendtime();
                    pross = list1.get(3).getProgress();
                    zhouqi = list1.get(3).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(4).getTaskid();
                    peoplename = name5;
                    finshdata = list1.get(4).getYendtime();
                    pross = list1.get(4).getProgress();
                    zhouqi = list1.get(4).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(5).getTaskid();
                    peoplename = name6;
                    finshdata = list1.get(5).getYendtime();
                    pross = list1.get(5).getProgress();
                    zhouqi = list1.get(5).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(6).getTaskid();
                    peoplename = name7;
                    finshdata = list1.get(6).getYendtime();
                    pross = list1.get(6).getProgress();
                    zhouqi = list1.get(6).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(7).getTaskid();
                    peoplename = name8;
                    finshdata = list1.get(7).getYendtime();
                    pross = list1.get(7).getProgress();
                    zhouqi = list1.get(7).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
        }

        if (list1!=null&&list1.size()>0&&list1.size() == 9){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.VISIBLE);
            son4.setVisibility(View.VISIBLE);
            son5.setVisibility(View.VISIBLE);
            son6.setVisibility(View.VISIBLE);
            son7.setVisibility(View.VISIBLE);
            son8.setVisibility(View.VISIBLE);
            son9.setVisibility(View.VISIBLE);
            son10.setVisibility(View.GONE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            c = list1.get(2).getZi();
            for (int i = 0; i < c.size(); i++) {
                name3 += c.get(i)+";";
            }
            sontext3.setText(name3);
            d = list1.get(3).getZi();
            for (int i = 0; i < d.size(); i++) {
                name4 += d.get(i)+";";
            }
            sontext4.setText(name4);
            e = list1.get(4).getZi();
            for (int i = 0; i < e.size(); i++) {
                name5 += e.get(i)+";";
            }
            sontext5.setText(name5);

            f = list1.get(5).getZi();
            for (int i = 0; i < f.size(); i++) {
                name6 += f.get(i)+";";
            }
            sontext6.setText(name6);

            g = list1.get(6).getZi();
            for (int i = 0; i < g.size(); i++) {
                name7 += g.get(i)+";";
            }
            sontext7.setText(name7);

            h = list1.get(7).getZi();
            for (int i = 0; i < h.size(); i++) {
                name8 += h.get(i)+";";
            }
            sontext8.setText(name8);

            m = list1.get(8).getZi();
            for (int i = 0; i < m.size(); i++) {
                name9 += m.get(i)+";";
            }
            sontext9.setText(name9);


            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    peoplename = name1;
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    peoplename = name2;
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(2).getTaskid();
                    peoplename = name3;
                    finshdata = list1.get(2).getYendtime();
                    pross = list1.get(2).getProgress();
                    zhouqi = list1.get(2).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(3).getTaskid();
                    peoplename = name4;
                    finshdata = list1.get(3).getYendtime();
                    pross = list1.get(3).getProgress();
                    zhouqi = list1.get(3).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(4).getTaskid();
                    peoplename = name5;
                    finshdata = list1.get(4).getYendtime();
                    pross = list1.get(4).getProgress();
                    zhouqi = list1.get(4).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(5).getTaskid();
                    peoplename = name6;
                    finshdata = list1.get(5).getYendtime();
                    pross = list1.get(5).getProgress();
                    zhouqi = list1.get(5).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(6).getTaskid();
                    peoplename = name7;
                    finshdata = list1.get(6).getYendtime();
                    pross = list1.get(6).getProgress();
                    zhouqi = list1.get(6).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(7).getTaskid();
                    peoplename = name8;
                    finshdata = list1.get(7).getYendtime();
                    pross = list1.get(7).getProgress();
                    zhouqi = list1.get(7).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(8).getTaskid();
                    peoplename = name9;
                    finshdata = list1.get(8).getYendtime();
                    pross = list1.get(8).getProgress();
                    zhouqi = list1.get(8).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
        }

        if (list1!=null&&list1.size()>0&&list1.size() == 10){
            son1.setVisibility(View.VISIBLE);
            son2.setVisibility(View.VISIBLE);
            son3.setVisibility(View.VISIBLE);
            son4.setVisibility(View.VISIBLE);
            son5.setVisibility(View.VISIBLE);
            son6.setVisibility(View.VISIBLE);
            son7.setVisibility(View.VISIBLE);
            son8.setVisibility(View.VISIBLE);
            son9.setVisibility(View.VISIBLE);
            son10.setVisibility(View.VISIBLE);
            a = list1.get(0).getZi();
            for (int i = 0; i < a.size(); i++) {
                name1 += a.get(i)+";";
            }
            sontext1.setText(name1);
            b = list1.get(1).getZi();
            for (int i = 0; i < b.size(); i++) {
                name2 += b.get(i)+";";
            }
            sontext2.setText(name2);
            c = list1.get(2).getZi();
            for (int i = 0; i < c.size(); i++) {
                name3 += c.get(i)+";";
            }
            sontext3.setText(name3);
            d = list1.get(3).getZi();
            for (int i = 0; i < d.size(); i++) {
                name4 += d.get(i)+";";
            }
            sontext4.setText(name4);
            e = list1.get(4).getZi();
            for (int i = 0; i < e.size(); i++) {
                name5 += e.get(i)+";";
            }
            sontext5.setText(name5);

            f = list1.get(5).getZi();
            for (int i = 0; i < f.size(); i++) {
                name6 += f.get(i)+";";
            }
            sontext6.setText(name6);

            g = list1.get(6).getZi();
            for (int i = 0; i < g.size(); i++) {
                name7 += g.get(i)+";";
            }
            sontext7.setText(name7);

            h = list1.get(7).getZi();
            for (int i = 0; i < h.size(); i++) {
                name8 += h.get(i)+";";
            }
            sontext8.setText(name8);

            m = list1.get(8).getZi();
            for (int i = 0; i < m.size(); i++) {
                name9 += m.get(i)+";";
            }
            sontext9.setText(name9);

            k = list1.get(9).getZi();
            for (int i = 0; i < k.size(); i++) {
                name10 += k.get(i)+";";
            }
            sontext10.setText(name10);


            son1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(0).getTaskid();
                    peoplename = name1;
                    finshdata = list1.get(0).getYendtime();
                    pross = list1.get(0).getProgress();
                    zhouqi = list1.get(0).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(1).getTaskid();
                    peoplename = name2;
                    finshdata = list1.get(1).getYendtime();
                    pross = list1.get(1).getProgress();
                    zhouqi = list1.get(1).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(2).getTaskid();
                    peoplename = name3;
                    finshdata = list1.get(2).getYendtime();
                    pross = list1.get(2).getProgress();
                    zhouqi = list1.get(2).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(3).getTaskid();
                    peoplename = name4;
                    finshdata = list1.get(3).getYendtime();
                    pross = list1.get(3).getProgress();
                    zhouqi = list1.get(3).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
            son5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(4).getTaskid();
                    peoplename = name5;
                    finshdata = list1.get(4).getYendtime();
                    pross = list1.get(4).getProgress();
                    zhouqi = list1.get(4).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(5).getTaskid();
                    peoplename = name6;
                    finshdata = list1.get(5).getYendtime();
                    pross = list1.get(5).getProgress();
                    zhouqi = list1.get(5).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(6).getTaskid();
                    peoplename = name7;
                    finshdata = list1.get(6).getYendtime();
                    pross = list1.get(6).getProgress();
                    zhouqi = list1.get(6).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(7).getTaskid();
                    peoplename = name8;
                    finshdata = list1.get(7).getYendtime();
                    pross = list1.get(7).getProgress();
                    zhouqi = list1.get(7).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(8).getTaskid();
                    peoplename = name9;
                    finshdata = list1.get(8).getYendtime();
                    pross = list1.get(8).getProgress();
                    zhouqi = list1.get(8).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });

            son10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskidson =  list1.get(9).getTaskid();
                    peoplename = name10;
                    finshdata = list1.get(9).getYendtime();
                    pross = list1.get(9).getProgress();
                    zhouqi = list1.get(9).getCycletype();
                    if (zhouqi == 0){
                        zhouq = "当前任务";
                    }
                    if (zhouqi == 1){
                        zhouq = "日报";
                    }
                    if (zhouqi == 2){
                        zhouq = "周报";
                    }
                    if (zhouqi == 3){
                        zhouq = "月报";
                    }
                    Intent intent = new Intent(Activity_zirenwu_deatil2.this,Activity_zirenwu7.class);
                    intent.putExtra("name",peoplename);
                    intent.putExtra("data",finshdata);
                    intent.putExtra("jindu",pross);
                    intent.putExtra("zhouqi",zhouq);
                    intent.putExtra("taskid7",taskidson);
                    startActivity(intent);
                }
            });
        }



    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zirenwu_deatil2;
    }
}
