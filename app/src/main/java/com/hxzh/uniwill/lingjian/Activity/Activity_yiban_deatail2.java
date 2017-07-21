package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.MyScrollView;
import com.hxzh.uniwill.lingjian.bean.Data_huoqurenwuxiangqing;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/***
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 * <p/>
 * Created by PangHaHa12138 on 2017/5/4.
 *
 *   已办详情改版
 */
public class Activity_yiban_deatail2 extends BaseToobarRightViewActivity{

    private TextView renwuming;//任务名
    private TextView wanchengriqi;//完成日期
    private TextView shangbaozhouqi;//上报周期
    private TextView renwubiaozhun;//任务标准
    private TextView renwumiaoshu;//任务描述
    private TextView shijifinshdata;//实际完成日期
    private MyScrollView scrollView;

    private List<Data_huoqurenwuxiangqing.ListBean> list1;
    private List<Data_huoqurenwuxiangqing.ChildsBean> list2;
    private List<Data_huoqurenwuxiangqing.ListAccBean> listacc;
    private  Data_huoqurenwuxiangqing renwuxiangqing;
    private String taskid,userid,taskname,shangbao;

    private RelativeLayout zirenwu1;
    private RelativeLayout zirenwu2;
    private RelativeLayout zirenwu3;
    private RelativeLayout zirenwu4;
    private RelativeLayout zirenwu5;
    private TextView name1;
    private TextView name2;
    private TextView name3;
    private TextView name4;
    private TextView name5;
    private int childcount;
    private String taskid23;
    private String zerenrename23,wantime23,baozhouqi23,miaoshu23;
    private int progrss23, proooo;
    private  String heName1="",heName2="",heName3="",heName4="",heName5="";
    private List<String> Zi;
    private List<String> Zi2;
    private List<String> Zi3;
    private List<String> Zi4;
    private List<String> Zi5;

    private ProgressBar progesss;
    private TextView progesssValue;
    private int x0,x1, x2, dx;
    private LinearLayout full;
    private int progressveall;

    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,fujian10,xiugai;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,fujianname8,fujianname9,fujianname10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("已办任务");
        getToobarRightView().setImageResource(R.drawable.title_but_chat_3x);

        initview();
        initData();
        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
                getToobarRedView().setVisibility(View.INVISIBLE);
                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_Chat.class);
                intent.putExtra("taskidchat",taskid);
                startActivity(intent);
            }
        });

    }

    private void initview() {

        renwubiaozhun = (TextView) findViewById(R.id.renwubiaozhun23);
        renwuming = (TextView) findViewById(R.id.deatil_renwuming23);
        wanchengriqi = (TextView) findViewById(R.id.deatil_finsh_data23);
        shangbaozhouqi = (TextView) findViewById(R.id.deatil_shangbaozhouqi23);
        shijifinshdata = (TextView) findViewById(R.id.realfinshdata23);
        renwumiaoshu = (TextView) findViewById(R.id.renwumiaoshu23);
//        scrollView = (MyScrollView) findViewById(R.id.scrollView23);
        fujian1 = (RelativeLayout)findViewById(R.id.fujian1);
        fujian2 = (RelativeLayout)findViewById(R.id.fujian2);
        fujian3 = (RelativeLayout)findViewById(R.id.fujian3);
        fujian4 = (RelativeLayout)findViewById(R.id.fujian4);
        fujian5 = (RelativeLayout)findViewById(R.id.fujian5);
        fujian6 = (RelativeLayout)findViewById(R.id.fujian6);
        fujian7 = (RelativeLayout)findViewById(R.id.fujian7);
        fujian8 = (RelativeLayout)findViewById(R.id.fujian8);
        fujian9 = (RelativeLayout) findViewById(R.id.fujian9);
        fujian10 = (RelativeLayout)findViewById(R.id.fujian10);
        fujianname1 = (TextView)findViewById(R.id.fujiantext1);
        fujianname2 = (TextView)findViewById(R.id.fujiantext2);
        fujianname3 = (TextView)findViewById(R.id.fujiantext3);
        fujianname4 = (TextView)findViewById(R.id.fujiantext4);
        fujianname5 = (TextView)findViewById(R.id.fujiantext5);
        fujianname6 = (TextView)findViewById(R.id.fujiantext6);
        fujianname7 = (TextView)findViewById(R.id.fujiantext7);
        fujianname8 = (TextView)findViewById(R.id.fujiantext8);
        fujianname9 = (TextView)findViewById(R.id.fujiantext9);
        fujianname10 = (TextView)findViewById(R.id.fujiantext10);

        zirenwu1 = (RelativeLayout) findViewById(R.id.zirenwu11);
        zirenwu2 = (RelativeLayout) findViewById(R.id.zirenwu22);
        zirenwu3 = (RelativeLayout) findViewById(R.id.zirenwu33);
        zirenwu4 = (RelativeLayout) findViewById(R.id.zirenwu44);
        zirenwu5 = (RelativeLayout) findViewById(R.id.zirenwu55);
        name1 = (TextView) findViewById(R.id.zirenwuname11);
        name2 = (TextView) findViewById(R.id.zirenwunanme22);
        name3 = (TextView) findViewById(R.id.zirenwunanme33);
        name4 = (TextView) findViewById(R.id.zirenwunanme44);
        name5 = (TextView) findViewById(R.id.zirenwunanme55);

        progesss = (ProgressBar) findViewById(R.id.progesss23);
        progesssValue = (TextView) findViewById(R.id.progesss_value23);
//        full = (LinearLayout) findViewById(R.id.dell_full23);
    }

    private void initData() {

        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid2");
        userid = intent.getStringExtra("userid2");
        taskname = intent.getStringExtra("taskname");
//        proooo = intent.getIntExtra("prooo",0);
        proooo = SharedPreferencesUtil.readProgressYiban(Activity_yiban_deatail2.this);
        LogUtil.d("初始化的进度----",proooo+"---");
        progesss.setProgress(proooo);
        progesssValue.setText(new StringBuffer().append(progesss.getProgress()).append("%"));

        new Thread(){
            @Override
            public void run() {

                try {
                    OkHttpUtils.get(Http_Api.URL_renwuxiangqing)
                            .params("taskid",taskid)
                            .params("userid",userid)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    renwuxiangqing = JsonUtil.parseJsonToBean(s,Data_huoqurenwuxiangqing.class);
                                    list1 = renwuxiangqing.getList();//执行人列表
                                    list2 = renwuxiangqing.getChilds();//子任务
                                    String wa = renwuxiangqing.getNewsCount();
                                    if (!wa.equals("0")){
                                        getToobarRedView().setVisibility(View.VISIBLE);
                                    }

                                    if (list1!=null){
                                        String aa = (String) list1.get(0).getReason();
                                        LogUtil.d("任务描述---",aa+"");
                                        renwumiaoshu.setText(aa);//设置任务描述
                                    }
                                    LogUtil.d("任务名-----",renwuxiangqing.getTaskname());

                                    shangbao = renwuxiangqing.getCycle();
                                    if (shangbao.equals(0+"")){
                                        shangbaozhouqi.setText("当前任务");
                                    }
                                    if (shangbao.equals(1+"")){
                                        shangbaozhouqi.setText("天报");
                                    }
                                    if (shangbao.equals(2+"")){
                                        shangbaozhouqi.setText("周报");
                                    }
                                    if (shangbao.equals(3+"")){
                                        shangbaozhouqi.setText("月报");
                                    }
                                    String realdata = (String) renwuxiangqing.getSendtime();
                                    if (realdata!=null){
                                        shijifinshdata.setText(realdata);//实际完成日期
                                    }
                                    renwuming.setText(renwuxiangqing.getTaskname());//设置任务名
                                    wanchengriqi.setText(renwuxiangqing.getYendtime());//设置完成日期
                                    renwubiaozhun.setText(renwuxiangqing.getTaskcontent());//完成标准
                                    childcount = renwuxiangqing.getChildcount();
                                    LogUtil.d("子任务个数---",childcount+"");
                                    if (childcount == 0){
                                        zirenwu1.setVisibility(View.GONE);
                                        zirenwu2.setVisibility(View.GONE);
                                        zirenwu3.setVisibility(View.GONE);
                                        zirenwu4.setVisibility(View.GONE);
                                        zirenwu5.setVisibility(View.GONE);

                                    }
                                    if (childcount == 1&&list2.size()>0&&list2.get(0).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        Zi = list2.get(0).getZi();
                                        for (int i = 0; i < Zi.size(); i++) {
                                            heName1 += Zi.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        LogUtil.d("Zi--子任务名---",heName1+"--");
                                        zirenwu1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(0).getTaskid();
                                                progrss23 = list2.get(0).getProgress();
                                                zerenrename23 = heName1;
                                                wantime23 = list2.get(0).getYendtime();
                                                miaoshu23= (String) list2.get(0).getTaskcontent();
                                                int a = list2.get(0).getCycletype();
                                                if (a == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (a == 1){
                                                    baozhouqi23= "日报";
                                                }
                                                if (a ==2){
                                                    baozhouqi23= "周报";
                                                }
                                                if (a == 3){
                                                    baozhouqi23= "月报";
                                                }
                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",progrss23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("taskid23",taskid23);
                                                LogUtil.d("任务描述--1--",miaoshu23+"----");
                                                LogUtil.d("进度--1-",progrss23+"---");
                                                intent.putExtra("progress23",progrss23);
                                                startActivity(intent);
                                            }
                                        });

                                    }
                                    if (childcount == 2&&list2.size()>0&&list2.get(1).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        Zi = list2.get(0).getZi();
                                        for (int i = 0; i < Zi.size(); i++) {
                                            heName1 += Zi.get(i)+";";
                                        }
                                        Zi2 = list2.get(1).getZi();
                                        for (int i = 0; i < Zi2.size(); i++) {
                                            heName2 += Zi2.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        zirenwu1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(0).getTaskid();
                                                progrss23 = list2.get(0).getProgress();
                                                zerenrename23 = heName1;
                                                wantime23 = list2.get(0).getYendtime();
                                                miaoshu23= (String) list2.get(0).getTaskcontent();
                                                int a = list2.get(0).getCycletype();
                                                if (a == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (a == 1){
                                                    baozhouqi23= "日报";
                                                }
                                                if (a ==2){
                                                    baozhouqi23= "周报";
                                                }
                                                if (a == 3){
                                                    baozhouqi23= "月报";
                                                }
                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",progrss23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("taskid23",taskid23);
                                                LogUtil.d("任务描述-1--",miaoshu23+"----");
                                                LogUtil.d("进度--1-",progrss23+"---");
                                                intent.putExtra("progress1",progrss23);
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(1).getTaskid();
                                                progrss23 = list2.get(1).getProgress();
                                                zerenrename23 = heName2;
                                                wantime23 = list2.get(1).getYendtime();
                                                miaoshu23 = (String) list2.get(1).getTaskcontent();
                                                int b = list2.get(1).getCycletype();
                                                if (b == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (b == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (b ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (b == 3){
                                                    baozhouqi23 = "月报";
                                                }

                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述--2--",miaoshu23+"----");
                                                LogUtil.d("进度--2-",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                    if (childcount == 3&&list2.size()>0&&list2.get(2).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        Zi = list2.get(0).getZi();
                                        for (int i = 0; i < Zi.size(); i++) {
                                            heName1 += Zi.get(i)+";";
                                        }
                                        Zi2 = list2.get(1).getZi();
                                        for (int i = 0; i < Zi2.size(); i++) {
                                            heName2 += Zi2.get(i)+";";
                                        }
                                        Zi3 = list2.get(2).getZi();
                                        for (int i = 0; i < Zi3.size(); i++) {
                                            heName3 += Zi3.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);
                                        zirenwu1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(0).getTaskid();
                                                progrss23 = list2.get(0).getProgress();
                                                zerenrename23 = heName1;
                                                wantime23 = list2.get(0).getYendtime();
                                                miaoshu23= (String) list2.get(0).getTaskcontent();
                                                int a = list2.get(0).getCycletype();
                                                if (a == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (a == 1){
                                                    baozhouqi23= "日报";
                                                }
                                                if (a ==2){
                                                    baozhouqi23= "周报";
                                                }
                                                if (a == 3){
                                                    baozhouqi23= "月报";
                                                }
                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",progrss23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("taskid23",taskid23);
                                                LogUtil.d("任务描述--1--",miaoshu23+"----");
                                                LogUtil.d("进度--1-",progrss23+"---");
                                                intent.putExtra("progress1",progrss23);
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(1).getTaskid();
                                                progrss23 = list2.get(1).getProgress();
                                                zerenrename23 = heName2;
                                                wantime23 = list2.get(1).getYendtime();
                                                miaoshu23 = (String) list2.get(1).getTaskcontent();
                                                int b = list2.get(1).getCycletype();
                                                if (b == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (b == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (b ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (b == 3){
                                                    baozhouqi23 = "月报";
                                                }

                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述--2--",miaoshu23+"----");
                                                LogUtil.d("进度--2-",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu3.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                taskid23 = list2.get(2).getTaskid();
                                                progrss23 = list2.get(2).getProgress();
                                                zerenrename23 = heName3;
                                                wantime23 = list2.get(2).getYendtime();
                                                miaoshu23 = (String) list2.get(2).getTaskcontent();
                                                int c = list2.get(2).getCycletype();
                                                if (c == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (c == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (c ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (c == 3){
                                                    baozhouqi23 = "月报";
                                                }

                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述--3--",miaoshu23+"----");
                                                LogUtil.d("进度--3-",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                    if (childcount == 4&&list2.size()>0&&list2.get(3).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        Zi = list2.get(0).getZi();
                                        for (int i = 0; i < Zi.size(); i++) {
                                            heName1 += Zi.get(i)+";";
                                        }
                                        Zi2 = list2.get(1).getZi();
                                        for (int i = 0; i < Zi2.size(); i++) {
                                            heName2 += Zi2.get(i)+";";
                                        }
                                        Zi3 = list2.get(2).getZi();
                                        for (int i = 0; i < Zi3.size(); i++) {
                                            heName3 += Zi3.get(i)+";";
                                        }Zi4 = list2.get(3).getZi();
                                        for (int i = 0; i < Zi4.size(); i++) {
                                            heName4 += Zi4.get(i)+";";
                                        }
                                        LogUtil.d("子任务明子--个数",Zi.size()+"--");
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);
                                        name4.setText(heName4);
                                        zirenwu1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(0).getTaskid();
                                                progrss23 = list2.get(0).getProgress();
                                                zerenrename23 = heName1;
                                                wantime23 = list2.get(0).getYendtime();
                                                miaoshu23= (String) list2.get(0).getTaskcontent();
                                                int a = list2.get(0).getCycletype();
                                                if (a == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (a == 1){
                                                    baozhouqi23= "日报";
                                                }
                                                if (a ==2){
                                                    baozhouqi23= "周报";
                                                }
                                                if (a == 3){
                                                    baozhouqi23= "月报";
                                                }
                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",progrss23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("taskid23",taskid23);
                                                LogUtil.d("任务描述--1-",miaoshu23+"----");
                                                LogUtil.d("进度--1-",progrss23+"---");
                                                intent.putExtra("progress1",progrss23);
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(1).getTaskid();
                                                progrss23 = list2.get(1).getProgress();
                                                zerenrename23 = heName2;
                                                wantime23 = list2.get(1).getYendtime();
                                                miaoshu23 = (String) list2.get(1).getTaskcontent();
                                                int b = list2.get(1).getCycletype();
                                                if (b == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (b == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (b ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (b == 3){
                                                    baozhouqi23 = "月报";
                                                }

                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述--2--",miaoshu23+"----");
                                                LogUtil.d("进度--2-",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu3.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(2).getTaskid();
                                                progrss23 = list2.get(2).getProgress();
                                                zerenrename23 = heName3;
                                                wantime23 = list2.get(2).getYendtime();
                                                miaoshu23 = (String) list2.get(2).getTaskcontent();
                                                int c = list2.get(2).getCycletype();
                                                if (c == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (c == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (c ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (c == 3){
                                                    baozhouqi23 = "月报";
                                                }

                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述---3--",miaoshu23+"----");
                                                LogUtil.d("进度---3--",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(3).getTaskid();
                                                progrss23 = list2.get(3).getProgress();
                                                zerenrename23 = heName4;
                                                wantime23 = list2.get(3).getYendtime();
                                                miaoshu23 = (String) list2.get(3).getTaskcontent();
                                                int d = list2.get(3).getCycletype();
                                                if (d == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (d == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (d ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (d == 3){
                                                    baozhouqi23 = "月报";
                                                }
                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述-4--",miaoshu23+"----");
                                                LogUtil.d("进度---4-",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                    if (childcount == 5&&list2.size()>0&&list2.get(4).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        zirenwu5.setVisibility(View.VISIBLE);
                                        Zi = list2.get(0).getZi();
                                        for (int i = 0; i < Zi.size(); i++) {
                                            heName1 += Zi.get(i)+";";
                                        }
                                        Zi2 = list2.get(1).getZi();
                                        for (int i = 0; i < Zi2.size(); i++) {
                                            heName2 += Zi2.get(i)+";";
                                        }
                                        Zi3 = list2.get(2).getZi();
                                        for (int i = 0; i < Zi3.size(); i++) {
                                            heName3 += Zi3.get(i)+";";
                                        }
                                        Zi4 = list2.get(3).getZi();
                                        for (int i = 0; i < Zi4.size(); i++) {
                                            heName4 += Zi4.get(i)+";";
                                        }
                                        Zi5 = list2.get(4).getZi();
                                        for (int i = 0; i < Zi5.size(); i++) {
                                            heName5 += Zi5.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);
                                        name4.setText(heName4);
                                        name5.setText(heName5);
                                        zirenwu1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(0).getTaskid();
                                                progrss23 = list2.get(0).getProgress();
                                                zerenrename23 = heName1;
                                                wantime23 = list2.get(0).getYendtime();
                                                miaoshu23= (String) list2.get(0).getTaskcontent();
                                                int a = list2.get(0).getCycletype();
                                                if (a == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (a == 1){
                                                    baozhouqi23= "日报";
                                                }
                                                if (a ==2){
                                                    baozhouqi23= "周报";
                                                }
                                                if (a == 3){
                                                    baozhouqi23= "月报";
                                                }
                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",progrss23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("taskid23",taskid23);
                                                LogUtil.d("任务描述-1--",miaoshu23+"----");
                                                LogUtil.d("进度--1-",progrss23+"---");
                                                intent.putExtra("progress23",progrss23);
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(1).getTaskid();
                                                progrss23 = list2.get(1).getProgress();
                                                zerenrename23 = heName2;
                                                wantime23 = list2.get(1).getYendtime();
                                                miaoshu23 = (String) list2.get(1).getTaskcontent();
                                                int b = list2.get(1).getCycletype();
                                                if (b == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (b == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (b ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (b == 3){
                                                    baozhouqi23 = "月报";
                                                }

                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述--2-",miaoshu23+"----");
                                                LogUtil.d("进度--2-",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu3.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(2).getTaskid();
                                                progrss23 = list2.get(2).getProgress();
                                                zerenrename23 = heName3;
                                                wantime23 = list2.get(2).getYendtime();
                                                miaoshu23 = (String) list2.get(2).getTaskcontent();
                                                int c = list2.get(2).getCycletype();
                                                if (c == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (c == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (c ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (c == 3){
                                                    baozhouqi23 = "月报";
                                                }

                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述---3--",miaoshu23+"----");
                                                LogUtil.d("进度-3--",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(3).getTaskid();
                                                progrss23 = list2.get(3).getProgress();
                                                zerenrename23 = heName4;
                                                wantime23 = list2.get(3).getYendtime();
                                                miaoshu23 = (String) list2.get(3).getTaskcontent();
                                                int d = list2.get(3).getCycletype();
                                                if (d == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (d == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (d ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (d == 3){
                                                    baozhouqi23 = "月报";
                                                }
                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述--4-",miaoshu23+"----");
                                                LogUtil.d("进度--4-",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                        zirenwu5.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                taskid23 = list2.get(4).getTaskid();
                                                progrss23 = list2.get(4).getProgress();
                                                zerenrename23 = heName5;
                                                wantime23 = list2.get(4).getYendtime();
                                                miaoshu23 = (String) list2.get(4).getTaskcontent();
                                                int e = list2.get(4).getCycletype();
                                                if (e == 0){
                                                    baozhouqi23 = "当前任务";
                                                }
                                                if (e == 1){
                                                    baozhouqi23 = "日报";
                                                }
                                                if (e ==2){
                                                    baozhouqi23 = "周报";
                                                }
                                                if (e == 3){
                                                    baozhouqi23 = "月报";
                                                }
                                                Intent intent = new Intent(Activity_yiban_deatail2.this,Activity_zirenwu23.class);
                                                intent.putExtra("taskid23",taskid23);
                                                intent.putExtra("zerenrename23",zerenrename23);
                                                intent.putExtra("wantime23",wantime23);
                                                intent.putExtra("baozhouqi23",baozhouqi23);
                                                intent.putExtra("miaoshu23",miaoshu23);
                                                intent.putExtra("progress23",progrss23);
                                                LogUtil.d("任务描述-5--",miaoshu23+"----");
                                                LogUtil.d("进度--5-",progrss23+"---");
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                    listacc = renwuxiangqing.getListAcc();
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
                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

//        fujian1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showToast("功能未完善");
//            }
//        });

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
        progesssValue.setLayoutParams(params);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yiban2_deatil;
    }
}
