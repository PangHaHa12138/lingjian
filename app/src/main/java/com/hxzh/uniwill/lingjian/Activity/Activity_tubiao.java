package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.LineChart01View;
import com.hxzh.uniwill.lingjian.View.LineChart02View;
import com.hxzh.uniwill.lingjian.View.LineChart04View;
import com.hxzh.uniwill.lingjian.View.MultiBarChart01View;
import com.hxzh.uniwill.lingjian.View.PaixuPopupWindows;
import com.hxzh.uniwill.lingjian.View.StackBarChart01View;
import com.hxzh.uniwill.lingjian.View.StackBarChart02View;
import com.hxzh.uniwill.lingjian.View.StackBarChart04View;
import com.hxzh.uniwill.lingjian.View.StackBarChart05View;
import com.hxzh.uniwill.lingjian.View.StackBarChart11View;
import com.hxzh.uniwill.lingjian.View.TopPopupWindows;
import com.hxzh.uniwill.lingjian.bean.Data_Tubiaotongji;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
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
 * Created by pang on 2017/4/27.
 *  图标统计
 */
public class Activity_tubiao extends BaseToobarChangeStateActivity{

    private String starttime,endtime,cuserid,date;
    private StackBarChart01View stackbarchartview1;
    private StackBarChart04View stackBarChart04View;
    private LineChart01View lineChart01View;
    private LineChart04View lineChart04View;

    //1月，2季度，3年，4日，5柱状图，6折线图，7接收任务，8下发任务
    private int choseDate = 1,choseModel = 5,choseRenwuType = 7;
    private int personcode;//1普通员工 2中层领导 3总裁
    private String choseModeltext;
    private RelativeLayout month,day,year,jidu,date_layout;
    private TextView month_text,day_text,year_text,jidu_text;
    private View shu1,shu2,shu3;
    private Data_Tubiaotongji tubiaotongji;
    private List<Data_Tubiaotongji.ListBean> list;
    private TextView ChoseModelName;
    private LinearLayout ChoseModelBut;
    private TopPopupWindows topPopupWindows;
    private int amin,type;
    private String deptid,leadcode,userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
        onclick();

    }
    private void initView() {

        stackbarchartview1 = (StackBarChart01View) findViewById(R.id.stackbarchartview1);
        stackBarChart04View = (StackBarChart04View) findViewById(R.id.stackbarchartview04);
        lineChart01View = (LineChart01View) findViewById(R.id.linechart01);
        lineChart04View = (LineChart04View) findViewById(R.id.linechart04);
        month = (RelativeLayout) findViewById(R.id.month);
        day = (RelativeLayout) findViewById(R.id.day);
        year = (RelativeLayout) findViewById(R.id.year);
        jidu = (RelativeLayout) findViewById(R.id.jidu);
        month_text = (TextView) findViewById(R.id.month_text);
        day_text = (TextView) findViewById(R.id.day_text);
        year_text = (TextView) findViewById(R.id.year_text);
        jidu_text = (TextView) findViewById(R.id.jidu_text);
        shu1 = findViewById(R.id.shu1);
        shu2 = findViewById(R.id.shu2);
        shu3 = findViewById(R.id.shu3);

        date_layout = (RelativeLayout) findViewById(R.id.date_layout);

        ChoseModelBut = getChoseModelBut();
        ChoseModelName = getChoseModelName();

        amin = SharedPreferencesUtil.readAdmin(Activity_tubiao.this);
        type = SharedPreferencesUtil.readType(Activity_tubiao.this);
        deptid = SharedPreferencesUtil.readDeptid(Activity_tubiao.this);
        userid = SharedPreferencesUtil.readUserid(Activity_tubiao.this);
    }

    private void initData() {
        //根据角色默认显示接收任务或是下发
        cuserid = SharedPreferencesUtil.readUserid(Activity_tubiao.this);
        Intent intent = getIntent();
        starttime = intent.getStringExtra("starttime");
        endtime = intent.getStringExtra("endtime");

        if (amin == 0&&type == 0){//普通员工默认显示待办
            personcode = 1;
            if (starttime!=null&&endtime!=null){
                LogUtil.d("开始时间--",starttime);
                LogUtil.d("结束时间--",endtime);
                try {
                    OkHttpUtils.post(Http_Api.URL_Tubiao)
                            .params("cuserid",cuserid)
                            .params("starttime",starttime)
                            .params("endtime",endtime)
                            .params("date",choseDate)   //1月,2年,3季度,4日
                            .execute(new StringDialogCallback(Activity_tubiao.this) {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    LogUtil.d("返回的json",s+"");
                                    tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                    list = tubiaotongji.getList();
                                    date_layout.setVisibility(View.VISIBLE);
                                    stackbarchartview1.setVisibility(View.VISIBLE);
                                    lineChart01View.setVisibility(View.GONE);
                                    lineChart04View.setVisibility(View.GONE);
                                    stackBarChart04View.setVisibility(View.GONE);

                                    stackbarchartview1.chartDataSet(list,1);
                                    stackbarchartview1.chartLabels(list,choseDate);
                                    stackbarchartview1.refreshChart();

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else {
            OkHttpUtils.post(Http_Api.URL_IsLead)
                    .params("deptid",deptid)
                    .execute(new StringDialogCallback(Activity_tubiao.this) {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            Data_uploadBack_tag tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                            leadcode = tag.getResult();
                            LogUtil.d("返回领导验证码--",leadcode+"");
                            if (leadcode.equals("0")){//中层领导
                                personcode = 2;
                                if (starttime!=null&&endtime!=null){
                                    LogUtil.d("开始时间--",starttime);
                                    LogUtil.d("结束时间--",endtime);
                                    try {
                                        OkHttpUtils.post(Http_Api.URL_PersonTongji)
                                                .params("starttime",starttime)
                                                .params("endtime",endtime)
                                                .params("deptid",deptid)
                                                .execute(new StringDialogCallback(Activity_tubiao.this) {
                                                    @Override
                                                    public void onSuccess(String s, Call call, Response response) {
                                                        LogUtil.d("返回的json",s+"");
                                                        tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                                        list = tubiaotongji.getList();
                                                        stackBarChart04View.setVisibility(View.VISIBLE);
                                                        stackbarchartview1.setVisibility(View.GONE);
                                                        lineChart01View.setVisibility(View.GONE);
                                                        lineChart04View.setVisibility(View.GONE);
                                                        date_layout.setVisibility(View.GONE);

                                                        stackBarChart04View.chartDataSet(list,1);
                                                        stackBarChart04View.chartLabels(list,1);
                                                        stackBarChart04View.refreshChart();

                                                    }
                                                });
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }else if (leadcode.equals("1")){//总裁
                                personcode = 3;
                                if (starttime!=null&&endtime!=null){
                                    LogUtil.d("开始时间--",starttime);
                                    LogUtil.d("结束时间--",endtime);
                                    try {
                                        OkHttpUtils.post(Http_Api.URL_BuMen)
                                                .params("userid",userid)
                                                .params("starttime",starttime)
                                                .params("endtime",endtime)
                                                .execute(new StringDialogCallback(Activity_tubiao.this) {
                                                    @Override
                                                    public void onSuccess(String s, Call call, Response response) {
                                                        LogUtil.d("返回的json",s+"");
                                                        tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                                        list = tubiaotongji.getList();
                                                        date_layout.setVisibility(View.GONE);
                                                        stackbarchartview1.setVisibility(View.GONE);
                                                        lineChart01View.setVisibility(View.GONE);
                                                        lineChart04View.setVisibility(View.GONE);

                                                        stackBarChart04View.setVisibility(View.VISIBLE);
                                                        stackBarChart04View.chartDataSet(list,1);
                                                        stackBarChart04View.chartLabels(list,2);
                                                        stackBarChart04View.refreshChart();

                                                    }
                                                });
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });

        }


    }

    private void onclick() {

        getSendjob_tag().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSendjob_tag().setBackgroundResource(R.drawable.add_renwu_bg);
                getSendjob_text().setTextColor(getResources().getColor(R.color.left_menu_font));
                getAcceptjob_tag().setBackgroundResource(R.color.touming);
                getAcceptjob_text().setTextColor(getResources().getColor(R.color.white));
                choseRenwuType = 8;
                if (personcode == 1){
                    http(choseDate);
                }else if (personcode == 2){
                    http2();
                }else if (personcode == 3){
                   http3();
                }


            }
        });
        getAcceptjob_tag().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAcceptjob_tag().setBackgroundResource(R.drawable.add_renwu_bg);
                getAcceptjob_text().setTextColor(getResources().getColor(R.color.left_menu_font));
                getSendjob_tag().setBackgroundResource(R.color.touming);
                getSendjob_text().setTextColor(getResources().getColor(R.color.white));
                choseRenwuType = 7;
                if (personcode == 1){
                    http(choseDate);
                }else if (personcode == 2){
                    http2();
                }else if (personcode == 3){
                    http3();
                }

            }
        });

        ChoseModelBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTopPopwindow();
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day.setBackgroundResource(R.drawable.qian);
                day_text.setTextColor(getResources().getColor(R.color.shen));
                month.setBackgroundResource(R.color.touming);
                month_text.setTextColor(getResources().getColor(R.color.qian));
                year.setBackgroundResource(R.color.touming);
                year_text.setTextColor(getResources().getColor(R.color.qian));
                jidu.setBackgroundResource(R.color.touming);
                jidu_text.setTextColor(getResources().getColor(R.color.qian));
                shu1.setVisibility(View.GONE);
                shu2.setVisibility(View.VISIBLE);
                shu3.setVisibility(View.VISIBLE);
                choseDate = 4;
                http(choseDate);
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                month.setBackgroundResource(R.drawable.qian);
                month_text.setTextColor(getResources().getColor(R.color.shen));
                day.setBackgroundResource(R.color.touming);
                day_text.setTextColor(getResources().getColor(R.color.qian));
                year.setBackgroundResource(R.color.touming);
                year_text.setTextColor(getResources().getColor(R.color.qian));
                jidu.setBackgroundResource(R.color.touming);
                jidu_text.setTextColor(getResources().getColor(R.color.qian));
                shu1.setVisibility(View.GONE);
                shu2.setVisibility(View.GONE);
                shu3.setVisibility(View.VISIBLE);
                choseDate = 1;
                http(choseDate);
            }
        });
        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year.setBackgroundResource(R.drawable.qian);
                year_text.setTextColor(getResources().getColor(R.color.shen));
                month.setBackgroundResource(R.color.touming);
                month_text.setTextColor(getResources().getColor(R.color.qian));
                day.setBackgroundResource(R.color.touming);
                day_text.setTextColor(getResources().getColor(R.color.qian));
                jidu.setBackgroundResource(R.color.touming);
                jidu_text.setTextColor(getResources().getColor(R.color.qian));
                shu1.setVisibility(View.VISIBLE);
                shu2.setVisibility(View.GONE);
                shu3.setVisibility(View.GONE);
                choseDate = 3;
                http(choseDate);
            }
        });
        jidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jidu.setBackgroundResource(R.drawable.qian);
                jidu_text.setTextColor(getResources().getColor(R.color.shen));
                month.setBackgroundResource(R.color.touming);
                month_text.setTextColor(getResources().getColor(R.color.qian));
                year.setBackgroundResource(R.color.touming);
                year_text.setTextColor(getResources().getColor(R.color.qian));
                day.setBackgroundResource(R.color.touming);
                day_text.setTextColor(getResources().getColor(R.color.qian));
                shu1.setVisibility(View.VISIBLE);
                shu2.setVisibility(View.VISIBLE);
                shu3.setVisibility(View.GONE);
                choseDate = 2;
                http(choseDate);
            }
        });
    }

    private void ShowTopPopwindow() {
        //显示排序弹窗
       topPopupWindows = new TopPopupWindows(Activity_tubiao.this,myMenusOnClick);
        topPopupWindows.showAsDropDown(ChoseModelBut,0,0);
    }
    private View.OnClickListener myMenusOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            topPopupWindows.dismiss();
            switch (v.getId()) {
                //柱状图
                case R.id.zhu_layout:
                    choseModel = 5;
                    ChoseModelName.setText("柱状图");
                    if (personcode == 1){
                        http(choseDate);
                    }else if (personcode == 2){
                        http2();
                    }else if (personcode == 3){
                        http3();
                    }
                    break;
                //折线图
                case R.id.zhexian_layout:
                    choseModel = 6;
                    ChoseModelName.setText("折线图");
                    if (personcode == 1){
                        http(choseDate);
                    }else if (personcode == 2){
                        http2();
                    }else if (personcode == 3){
                        http3();
                    }
                    break;
            }

        }
    };

    private void http(final int choseDate){

        if (choseRenwuType == 7){//待办
            try {
                OkHttpUtils.post(Http_Api.URL_Tubiao)
                        .params("cuserid",cuserid)
                        .params("starttime",starttime)
                        .params("endtime",endtime)
                        .params("date",choseDate)   //1月,2年,3季度,4日
                        .execute(new StringDialogCallback(Activity_tubiao.this) {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                LogUtil.d("返回的json",s+"");
                                tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                list = tubiaotongji.getList();
                                date_layout.setVisibility(View.VISIBLE);
                                if (choseModel == 5){
                                    stackbarchartview1.setVisibility(View.VISIBLE);
                                    lineChart01View.setVisibility(View.GONE);
                                    lineChart04View.setVisibility(View.GONE);

                                    stackbarchartview1.chartDataSet(list,1);
                                    stackbarchartview1.chartLabels(list,choseDate);
                                    stackbarchartview1.refreshChart();
                                }else if (choseModel == 6){
                                    stackbarchartview1.setVisibility(View.GONE);
                                    lineChart04View.setVisibility(View.GONE);

                                    lineChart01View.setVisibility(View.VISIBLE);
                                    lineChart01View.chartDataSet(list,1);
                                    lineChart01View.chartLabels(list,choseDate);
                                    lineChart01View.refreshChart();
                                }
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (choseRenwuType == 8){//下发
            try {
                OkHttpUtils.post(Http_Api.URL_Tubiao2)
                        .params("cuserid",cuserid)
                        .params("starttime",starttime)
                        .params("endtime",endtime)
                        .params("date",choseDate)   //1月,2年,3季度,4日
                        .execute(new StringDialogCallback(Activity_tubiao.this) {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                LogUtil.d("返回的json",s+"");
                                tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                list = tubiaotongji.getList();
                                date_layout.setVisibility(View.VISIBLE);
                                if (choseModel == 5){
                                    stackbarchartview1.setVisibility(View.VISIBLE);
                                    lineChart01View.setVisibility(View.GONE);
                                    lineChart04View.setVisibility(View.GONE);

                                    stackbarchartview1.chartDataSet(list,2);
                                    stackbarchartview1.chartLabels(list,choseDate);
                                    stackbarchartview1.refreshChart();
                                }else if (choseModel == 6){
                                    stackbarchartview1.setVisibility(View.GONE);
                                    lineChart04View.setVisibility(View.GONE);

                                    lineChart01View.setVisibility(View.VISIBLE);
                                    lineChart01View.chartLabels(list,choseDate);
                                    lineChart01View.chartDataSet(list,2);
                                    lineChart01View.refreshChart();
                                }
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void http2(){

            if (choseRenwuType == 7){
                try {
                    OkHttpUtils.post(Http_Api.URL_PersonTongji)
                            .params("starttime",starttime)
                            .params("endtime",endtime)
                            .params("deptid",deptid)
                            .execute(new StringDialogCallback(Activity_tubiao.this) {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    LogUtil.d("返回的json",s+"");
                                    tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                    list = tubiaotongji.getList();
                                    if (choseModel == 5){
                                        date_layout.setVisibility(View.GONE);
                                        stackbarchartview1.setVisibility(View.GONE);
                                        lineChart01View.setVisibility(View.GONE);
                                        lineChart04View.setVisibility(View.GONE);

                                        stackBarChart04View.setVisibility(View.VISIBLE);
                                        stackBarChart04View.chartDataSet(list,1);
                                        stackBarChart04View.chartLabels(list,1);
                                        stackBarChart04View.refreshChart();

                                    }else if (choseModel == 6){
                                        date_layout.setVisibility(View.GONE);
                                        stackbarchartview1.setVisibility(View.GONE);
                                        lineChart01View.setVisibility(View.GONE);
                                        stackBarChart04View.setVisibility(View.GONE);

                                        lineChart04View.setVisibility(View.VISIBLE);
                                        lineChart04View.chartLabels(list,1);
                                        lineChart04View.chartDataSet(list,1);
                                        lineChart04View.refreshChart();
                                    }
                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (choseRenwuType == 8){
                try {
                    OkHttpUtils.post(Http_Api.URL_PersonXiafa)
                            .params("starttime",starttime)
                            .params("endtime",endtime)
                            .params("deptid",deptid)
                            .execute(new StringDialogCallback(Activity_tubiao.this) {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    LogUtil.d("返回的json",s+"");
                                    tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                    list = tubiaotongji.getList();
                                    if (choseModel == 5){
                                        date_layout.setVisibility(View.GONE);
                                        stackbarchartview1.setVisibility(View.GONE);
                                        lineChart01View.setVisibility(View.GONE);
                                        lineChart04View.setVisibility(View.GONE);

                                        stackBarChart04View.setVisibility(View.VISIBLE);
                                        stackBarChart04View.chartDataSet(list,2);
                                        stackBarChart04View.chartLabels(list,1);
                                        stackBarChart04View.refreshChart();
                                    }else if (choseModel == 6){
                                        stackbarchartview1.setVisibility(View.GONE);
                                        date_layout.setVisibility(View.GONE);
                                        stackBarChart04View.setVisibility(View.GONE);
                                        lineChart01View.setVisibility(View.GONE);

                                        lineChart04View.setVisibility(View.VISIBLE);
                                        lineChart04View.chartLabels(list,1);
                                        lineChart04View.chartDataSet(list,2);
                                        lineChart04View.refreshChart();
                                    }
                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }



    private void http3(){

        if (choseRenwuType == 7){//待办
            try {
                OkHttpUtils.post(Http_Api.URL_BuMen)
                        .params("userid",userid)
                        .params("starttime",starttime)
                        .params("endtime",endtime)
                        .execute(new StringDialogCallback(Activity_tubiao.this) {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                LogUtil.d("返回的json",s+"");
                                tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                list = tubiaotongji.getList();
                                if (choseModel == 5){
                                    date_layout.setVisibility(View.GONE);
                                    stackbarchartview1.setVisibility(View.GONE);
                                    lineChart01View.setVisibility(View.GONE);
                                    lineChart04View.setVisibility(View.GONE);

                                    stackBarChart04View.setVisibility(View.VISIBLE);
                                    stackBarChart04View.chartDataSet(list,1);
                                    stackBarChart04View.chartLabels(list,2);
                                    stackBarChart04View.refreshChart();
                                }else if (choseModel == 6){
                                    date_layout.setVisibility(View.GONE);
                                    stackbarchartview1.setVisibility(View.GONE);
                                    lineChart01View.setVisibility(View.GONE);
                                    stackBarChart04View.setVisibility(View.GONE);

                                    lineChart04View.setVisibility(View.VISIBLE);
                                    lineChart04View.chartLabels(list,2);
                                    lineChart04View.chartDataSet(list,1);
                                    lineChart04View.refreshChart();
                                }
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (choseRenwuType == 8){//下发
            try {
                OkHttpUtils.post(Http_Api.URL_BumenXiafa)
                        .params("userid",userid)
                        .params("starttime",starttime)
                        .params("endtime",endtime)
                        .execute(new StringDialogCallback(Activity_tubiao.this) {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                LogUtil.d("返回的json",s+"");
                                tubiaotongji = JsonUtil.parseJsonToBean(s,Data_Tubiaotongji.class);
                                list = tubiaotongji.getList();
                                if (choseModel == 5){
                                    date_layout.setVisibility(View.GONE);
                                    stackbarchartview1.setVisibility(View.GONE);
                                    lineChart01View.setVisibility(View.GONE);
                                    lineChart04View.setVisibility(View.GONE);

                                    stackBarChart04View.setVisibility(View.VISIBLE);
                                    stackBarChart04View.chartDataSet(list,2);
                                    stackBarChart04View.chartLabels(list,2);
                                    stackBarChart04View.refreshChart();
                                }else if (choseModel == 6){
                                    stackbarchartview1.setVisibility(View.GONE);
                                    date_layout.setVisibility(View.GONE);
                                    stackBarChart04View.setVisibility(View.GONE);
                                    lineChart01View.setVisibility(View.GONE);

                                    lineChart04View.setVisibility(View.VISIBLE);
                                    lineChart04View.chartLabels(list,2);
                                    lineChart04View.chartDataSet(list,2);
                                    lineChart04View.refreshChart();

                                }
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tubiaotongji;
    }
}
