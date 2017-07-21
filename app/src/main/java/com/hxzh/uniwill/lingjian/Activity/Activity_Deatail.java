package com.hxzh.uniwill.lingjian.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.MyScrollView;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.base.MessageEvent2;
import com.hxzh.uniwill.lingjian.base.MessageEvent4;
import com.hxzh.uniwill.lingjian.bean.Data_fileupback;
import com.hxzh.uniwill.lingjian.bean.Data_huoqurenwuxiangqing;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.FileUtils2;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.mylibrary.SeekBarIndicated;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/3/30.
 *  任务详情页
 */
public class Activity_Deatail extends BaseToobarRightViewActivity implements View.OnTouchListener{

    private RelativeLayout add_zirenwu;//添加子任务
    private RelativeLayout add_fujian;//添加附件
    private TextView renwuming;//任务名
    private TextView wanchengriqi;//完成日期
    private TextView shangbaozhouqi;//上报周期
    private TextView renwubiaozhun;//任务标准
    private EditText renwumiaoshu;//任务描述
//    private MyProgress myProgress;//任务进度条
//    private BubbleSeekBar mBbubbleSeekBar;
    private Button finsh_daiban;//完成

    private String taskid,userid,taskname,renwumiaoshu2,myprogress,shangbao;//任务id，用户id
    private String addname,addmiaoshu,addzhouqi,adddata;
    private int childnum;
    private Data_huoqurenwuxiangqing.ListBean listBean;
    private Data_huoqurenwuxiangqing.ChildsBean childsBean;

    private List<Data_huoqurenwuxiangqing.ListBean> list1;
    private List<Data_huoqurenwuxiangqing.ChildsBean> list2;
    private List<Data_huoqurenwuxiangqing.ListAccBean> listacc;
    private  Data_huoqurenwuxiangqing renwuxiangqing;

    private int zirenwuNum;//子任务个数
    private ScrollView scrollView;
    //传参
    private String userid2,cuserid2,taskname2,taskcontent,y_endtime,ptaskid,tasktype,tasklevel,taskcycle,cycletype;
    private Data_uploadBack_tag data_uploadBack_tag;

    private RelativeLayout wanchengriqi_layout;

    private RelativeLayout zirenwu1;
    private RelativeLayout zirenwu2;
    private RelativeLayout zirenwu3;
    private RelativeLayout zirenwu4;
    private RelativeLayout zirenwu5;
    private RelativeLayout zirenwu6;
    private RelativeLayout zirenwu7;
    private RelativeLayout zirenwu8;
    private RelativeLayout zirenwu9;
    private RelativeLayout zirenwu10;
    private RelativeLayout zirenwu11,zirenwu12,zirenwu13,zirenwu14,zirenwu15,zirenwu16,zirenwu17,zirenwu18,zirenwu19,zirenwu20;
    private TextView name1;
    private TextView name2;
    private TextView name3;
    private TextView name4;
    private TextView name5;
    private TextView name6;
    private TextView name7;
    private TextView name8;
    private TextView name9;
    private TextView name10;
    private TextView name11,name12,name13,name14,name15,name16,name17,name18,name19,name20;
    private int childcount;
    private String taskid1,taskid2,taskid3,taskid4,taskid5,taskid6,taskid7,taskid8,taskid9,taskid10;
    private String useid1;
    private String zerenrename1,wantime1,baozhouqi1,miaoshu1;
    private String zerenrenameadd1,wantimeadd1,baozhouqiadd1,miaoshuadd1;
    private String zerenrename2,wantime2,baozhouqi2,miaoshu2;
    private String zerenrenameadd2,wantimeadd2,baozhouqiadd2,miaoshuadd2;
    private String zerenrename3,wantime3,baozhouqi3,miaoshu3;
    private String zerenrenameadd3,wantimeadd3,baozhouqiadd3,miaoshuadd3;
    private String zerenrename4,wantime4,baozhouqi4,miaoshu4;
    private String zerenrenameadd4,wantimeadd4,baozhouqiadd4,miaoshuadd4;
    private String zerenrename5,wantime5,baozhouqi5,miaoshu5;
    private String zerenrenameadd5,wantimeadd5,baozhouqiadd5,miaoshuadd5;
    private String zerenrename6,wantime6,baozhouqi6,miaoshu6;
    private String zerenrenameadd6,wantimeadd6,baozhouqiadd6,miaoshuadd6;
    private String zerenrename7,wantime7,baozhouqi7,miaoshu7;
    private String zerenrenameadd7,wantimeadd7,baozhouqiadd7,miaoshuadd7;
    private String zerenrename8,wantime8,baozhouqi8,miaoshu8;
    private String zerenrenameadd8,wantimeadd8,baozhouqiadd8,miaoshuadd8;
    private String zerenrename9,wantime9,baozhouqi9,miaoshu9;
    private String zerenrenameadd9,wantimeadd9,baozhouqiadd9,miaoshuadd9;
    private String zerenrename10,wantime10,baozhouqi10,miaoshu10;
    private String zerenrenameadd10,wantimeadd10,baozhouqiadd10,miaoshuadd10;
    private String useridd1,useridd2,useridd3,useridd4,useridd5,useridd6,useridd7,useridd8,useridd9,useridd10;
    private String tasktype1,tasktype2,tasktype3,tasktype4,tasktype5,tasktype6,tasktype7,tasktype8,tasktype9,tasktype10;
    private String taskcycle1,taskcycle2,taskcycle3,taskcycle4,taskcycle5,taskcycle6,taskcycle7,taskcycle8,taskcycle9,taskcycle10;
    private String addzhouqi1,addzhouqi2,addzhouqi3,addzhouqi4,addzhouqi5,addzhouqi6,addzhouqi7,addzhouqi8,addzhouqi9,addzhouqi10;
    private String taskcontent1,taskcontent2,taskcontent3,taskcontent4,taskcontent5,taskcontent6,taskcontent7,taskcontent8,taskcontent9,taskcontent10;
    private int progrss1,progrss2,progrss3,progrss4,progrss5,progrss6,progrss7,progrss8,progrss9,progrss10,proooo;
    private  String heName1="",heName2="",heName3="",heName4="",heName5="";
    private  String heName6="",heName7="",heName8="",heName9="",heName10="";
    private List<String> Zi;
    private List<String> Zi2;
    private List<String> Zi3;
    private List<String> Zi4;
    private List<String> Zi5;
    private List<String> Zi6,Zi7,Zi8,Zi9,Zi10;

    private ProgressBar progesss;
    private TextView progesssValue;
    private int x0,x1, x2, dx;
    private LinearLayout full;
    private int progressveall;
    private String tag1,tag2,tag3,tag4;
    private SeekBarIndicated seekBarIndicated;
    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,
            fujian10,fujian11,fujian12,fujian13,fujian14,fujian15,fujian16,fujian17,fujian18,fujian19,fujian20;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10,fujianname11,fujianname12,fujianname13,fujianname14
            ,fujianname15,fujianname16,fujianname17,fujianname18,fujianname19,fujianname20;

    private RelativeLayout fj1,fj2,fj3,fj4,fj5,fj6,fj7,fj8,fj9,fj10;

    private TextView fjtext1,fjtext2,fjtext3,fjtext4,fjtext5,fjtext6,fjtext7,fjtext8,fjtext9,fjtext10,wu;

    private int fujiannum1,fujiannum2,fujiannum3,fujiannum4,fujiannum5,fujiannum6,fujiannum7,fujiannum8,fujiannum9,fujiannum10;
    private String fujianUrl1,fujianUrl2,fujianUrl3,fujianUrl4,fujianUrl5,fujianUrl6,fujianUrl7,fujianUrl8,fujianUrl9,fujianUrl10;
    private String fujianU1,fujianU2,fujianU3,fujianU4,fujianU5,fujianU6,fujianU7,fujianU8,fujianU9,fujianU10;
    private String fujianUr1,fujianUr2,fujianUr3,fujianUr4,fujianUr5,fujianUr6,fujianUr7,fujianUr8,fujianUr9,fujianUr10;
    private String fujianr1,fujianr2,fujianr3,fujianr4,fujianr5,fujianr6,fujianr7,fujianr8,fujianr9,fujianr10;
    private String fujianl1,fujianl2,fujianl3,fujianl4,fujianl5,fujianl6,fujianl7,fujianl8,fujianl9,fujianl10;

    private String fjur1,fjur2,fjur3,fjur4,fjur5,fjur6,fjur7,fjur8,fjur9,fjur10;
    private String fju1,fju2,fju3,fju4,fju5,fju6,fju7,fju8,fju9,fju10;
    private String fjru1,fjru2,fjru3,fjru4,fjru5,fjru6,fjru7,fjru8,fjru9,fjru10;
    private String fjurl1,fjurl2,fjurl3,fjurl4,fjurl5,fjurl6,fjurl7,fjurl8,fjurl9,fjurl10;
    private String fjulu1,fjulu2,fjulu3,fjulu4,fjulu5,fjulu6,fjulu7,fjulu8,fjulu9,fjulu10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("待办任务");
        getToobarRightView().setImageResource(R.drawable.title_but_chat_3x);

        initview();
        initData();
        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getToobarRedView().setVisibility(View.INVISIBLE);
                ToastUtil.showToast("聊天");
                Intent intent = new Intent(Activity_Deatail.this,Activity_Chat.class);
                intent.putExtra("taskidchat",taskid);
                startActivity(intent);
            }
        });

    }

    private void initview() {
//        wanchengriqi_layout = (RelativeLayout) findViewById(R.id.wanchengriqi_layout);
        add_fujian = (RelativeLayout) findViewById(R.id.tianjiafujian);
        add_zirenwu = (RelativeLayout) findViewById(R.id.zirenwu);
        renwubiaozhun = (TextView) findViewById(R.id.renwubiaozhun);
        renwumiaoshu = (EditText) findViewById(R.id.renwumiaoshu);
        renwuming = (TextView) findViewById(R.id.deatil_renwuming);
        wanchengriqi = (TextView) findViewById(R.id.deatil_finsh_data);
//        myProgress = (MyProgress) findViewById(R.id.myProgress_jindu);
        finsh_daiban = (Button) findViewById(R.id.deatil_wancheng);
        shangbaozhouqi = (TextView) findViewById(R.id.deatil_shangbaozhouqi);
//        mBbubbleSeekBar = (BubbleSeekBar) findViewById(R.id.bubbleseekbar);
//        scrollView = (ScrollView) findViewById(R.id.scrollView);

        zirenwu1 = (RelativeLayout) findViewById(R.id.zirenwu1);
        zirenwu2 = (RelativeLayout) findViewById(R.id.zirenwu2);
        zirenwu3 = (RelativeLayout) findViewById(R.id.zirenwu3);
        zirenwu4 = (RelativeLayout) findViewById(R.id.zirenwu4);
        zirenwu5 = (RelativeLayout) findViewById(R.id.zirenwu5);
        zirenwu6 = (RelativeLayout) findViewById(R.id.zirenwu6);
        zirenwu7 = (RelativeLayout) findViewById(R.id.zirenwu7);
        zirenwu8 = (RelativeLayout) findViewById(R.id.zirenwu8);
        zirenwu9 = (RelativeLayout) findViewById(R.id.zirenwu9);
        zirenwu10 = (RelativeLayout) findViewById(R.id.zirenwu10);
        zirenwu11 = (RelativeLayout) findViewById(R.id.zirenwu11);
        zirenwu12 = (RelativeLayout) findViewById(R.id.zirenwu12);
        zirenwu13 = (RelativeLayout) findViewById(R.id.zirenwu13);
        zirenwu14 = (RelativeLayout) findViewById(R.id.zirenwu14);
        zirenwu15 = (RelativeLayout) findViewById(R.id.zirenwu15);
        zirenwu16 = (RelativeLayout) findViewById(R.id.zirenwu16);
        zirenwu17 = (RelativeLayout) findViewById(R.id.zirenwu17);
        zirenwu18 = (RelativeLayout) findViewById(R.id.zirenwu18);
        zirenwu19 = (RelativeLayout) findViewById(R.id.zirenwu19);
        zirenwu20 = (RelativeLayout) findViewById(R.id.zirenwu20);

        name1 = (TextView) findViewById(R.id.zirenwuname1);
        name2 = (TextView) findViewById(R.id.zirenwunanme2);
        name3 = (TextView) findViewById(R.id.zirenwunanme3);
        name4 = (TextView) findViewById(R.id.zirenwunanme4);
        name5 = (TextView) findViewById(R.id.zirenwunanme5);
        name6 = (TextView) findViewById(R.id.zirenwunanme6);
        name7 = (TextView) findViewById(R.id.zirenwunanme7);
        name8 = (TextView) findViewById(R.id.zirenwunanme8);
        name9 = (TextView) findViewById(R.id.zirenwunanme9);
        name10 = (TextView) findViewById(R.id.zirenwunanme10);
        name11 = (TextView) findViewById(R.id.zirenwunanme11);
        name12 = (TextView) findViewById(R.id.zirenwunanme12);
        name13 = (TextView) findViewById(R.id.zirenwunanme13);
        name14 = (TextView) findViewById(R.id.zirenwunanme14);
        name15 = (TextView) findViewById(R.id.zirenwunanme15);
        name16 = (TextView) findViewById(R.id.zirenwunanme16);
        name17 = (TextView) findViewById(R.id.zirenwunanme17);
        name18 = (TextView) findViewById(R.id.zirenwunanme18);
        name19 = (TextView) findViewById(R.id.zirenwunanme19);
        name20 = (TextView) findViewById(R.id.zirenwunanme20);

//        progesss = (ProgressBar) findViewById(R.id.progesss8);
//        progesssValue = (TextView) findViewById(R.id.progesss_value8);
//        full = (LinearLayout) findViewById(R.id.dell_full);

        seekBarIndicated = (SeekBarIndicated) findViewById(R.id.mSeekBarIndicated);
        wu = (TextView) findViewById(R.id.wu);

        fj1 = (RelativeLayout) findViewById(R.id.fj1);
        fj2 = (RelativeLayout) findViewById(R.id.fj2);
        fj3 = (RelativeLayout) findViewById(R.id.fj3);
        fj4 = (RelativeLayout) findViewById(R.id.fj4);
        fj5 = (RelativeLayout) findViewById(R.id.fj5);
        fj6 = (RelativeLayout) findViewById(R.id.fj6);
        fj7 = (RelativeLayout) findViewById(R.id.fj7);
        fj8 = (RelativeLayout) findViewById(R.id.fj8);
        fj9 = (RelativeLayout) findViewById(R.id.fj9);
        fj10 = (RelativeLayout) findViewById(R.id.fj10);

        fjtext1 = (TextView) findViewById(R.id.fjtext1);
        fjtext2 = (TextView) findViewById(R.id.fjtext2);
        fjtext3 = (TextView) findViewById(R.id.fjtext3);
        fjtext4 = (TextView) findViewById(R.id.fjtext4);
        fjtext5 = (TextView) findViewById(R.id.fjtext5);
        fjtext6 = (TextView) findViewById(R.id.fjtext6);
        fjtext7 = (TextView) findViewById(R.id.fjtext7);
        fjtext8 = (TextView) findViewById(R.id.fjtext8);
        fjtext9 = (TextView) findViewById(R.id.fjtext9);
        fjtext10 = (TextView) findViewById(R.id.fjtext10);

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
        fujianname11 = (TextView) findViewById(R.id.fujiantext11);
        fujianname12 = (TextView) findViewById(R.id.fujiantext12);
        fujianname13 = (TextView) findViewById(R.id.fujiantext13);
        fujianname14 = (TextView) findViewById(R.id.fujiantext14);
        fujianname15 = (TextView) findViewById(R.id.fujiantext15);
        fujianname16 = (TextView) findViewById(R.id.fujiantext16);
        fujianname17 = (TextView) findViewById(R.id.fujiantext17);
        fujianname18 = (TextView) findViewById(R.id.fujiantext18);
        fujianname19 = (TextView) findViewById(R.id.fujiantext19);
        fujianname20 = (TextView) findViewById(R.id.fujiantext20);

        renwumiaoshu.setOnTouchListener(this);

//        SharedPreferences.Editor editor = SharedPreferencesUtil.preferences.edit();
//        if (SharedPreferencesUtil.preferences.edit()!=null){
//            editor.remove("ZirenwuNum");
//            editor.remove("addZerenren");
//            editor.remove("Zhouqi");
//            editor.remove("Riqi");
//            editor.remove("Biaozhun");
//            editor.remove("Add_SonUserid");
//            editor.commit();
//        }

    }
    private int pree;
    private SeekBar.OnSeekBarChangeListener mSeekchange = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            pree = progress;
            LogUtil.d("滑动---",pree+"");
            if (progress<proooo){
               seekBar.setProgress(proooo);//通过设置旧数值来实现禁止左滑
            }
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
            Log.i("MAIN","Progress"+seekBar.getProgress());

        }
    };

    private void initData() {

        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid1");
        userid = intent.getStringExtra("userid1");
        LogUtil.d("userid",userid+"");
        taskname = intent.getStringExtra("taskname");
//        proooo = intent.getIntExtra("progress",0);
        proooo = SharedPreferencesUtil.readProgressDaiban(Activity_Deatail.this);
        LogUtil.d("初始化的进度----",proooo+"---");
        seekBarIndicated.setValue(proooo);
        seekBarIndicated.setOnSeekBarChangeListener(mSeekchange);

//        scrollView.setScrollViewListener(new MyScrollView.ScrollViewListener() {
//            @Override
//            public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
//                // 调用修正偏移方法
//                mBbubbleSeekBar.correctOffsetWhenContainerOnScrolling();
//            }
//        });

//        //进度条
//        mBbubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
//            @Override
//            public void onProgressChanged(int progress, float progressFloat) {
//                myprogress =  progress +"";
//                LogUtil.d("进度1---->>", progress+"");
//            }
//
//            @Override
//            public void getProgressOnActionUp(int progress, float progressFloat) {
//            }
//
//            @Override
//            public void getProgressOnFinally(int progress, float progressFloat) {
//                LogUtil.d("进度3---->>", progress+"");
//            }
//        });

//            mBbubbleSeekBar.setProgress(proooo);

//        if (proooo == 100){
//            setPosWay1();
//            progesss.setProgress(proooo);
//            progesssValue.setText(new StringBuffer().append(progesss.getProgress()).append("%"));
//        }else {
//            full.setOnTouchListener(new View.OnTouchListener() {
//
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    int w = getWindowManager().getDefaultDisplay().getWidth();
//                    switch (event.getAction()) {
//                        case MotionEvent.ACTION_DOWN:
//                            x1 = (int) event.getRawX();
//                            progesss.setProgress(100 * x1 / w);
//                            setPos();
//                            break;
//                        case MotionEvent.ACTION_MOVE:
//                            x2 = (int) event.getRawX();
//                            dx = x2 - x1;
//                            if (Math.abs(dx) > w / 100) { //改变条件 调整进度改变速度
//                                // x1 = x2; // 去掉已经用掉的距离， 去掉这句 运行看看会出现效果
//                                progesss.setProgress(progesss.getProgress() + dx * 100 / w);
//                                setPos();
//                            }
//                            break;
//                        case MotionEvent.ACTION_UP:
//                            break;
//                    }
//                    return true;
//                }
//            });
//            progesss.setProgress(proooo);
//        }

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

                                    renwuxiangqing =
                                            JsonUtil.parseJsonToBean(s,Data_huoqurenwuxiangqing.class);
                                    list1 = renwuxiangqing.getList();//执行人列表
                                    list2 = renwuxiangqing.getChilds();//子任务

                                    cuserid2 = renwuxiangqing.getCuserid();
                                    taskname2 = renwuxiangqing.getTaskname();
                                    ptaskid = renwuxiangqing.getTaskid();

                                    useid1 = renwuxiangqing.getCuserid();

                                    String aw = renwuxiangqing.getNewsCount();
                                    if (!aw.equals("0")){
                                        getToobarRedView().setVisibility(View.VISIBLE);
                                    }

                                    if (list1!=null){
                                        String aa = (String) list1.get(0).getReason();
                                        renwumiaoshu.setText(aa);
                                    }


                                    LogUtil.d("任务名-----",renwuxiangqing.getTaskname());

                                    shangbao = renwuxiangqing.getCycle();
                                    if (shangbao.equals(0+"")){
                                        shangbaozhouqi.setText("单次");
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
                                    renwuming.setText(renwuxiangqing.getTaskname());//设置任务名
                                    wanchengriqi.setText(renwuxiangqing.getYendtime());//设置完成日期
    //                                shangbaozhouqi.setText(renwuxiangqing.getCycle());//上报周期
                                    renwubiaozhun.setText(renwuxiangqing.getTaskcontent());//完成标准
                                    childcount = renwuxiangqing.getChildcount();
                                    if (childcount == 0){
                                        zirenwu1.setVisibility(View.GONE);
                                        zirenwu2.setVisibility(View.GONE);
                                        zirenwu3.setVisibility(View.GONE);
                                        zirenwu4.setVisibility(View.GONE);
                                        zirenwu5.setVisibility(View.GONE);
                                        zirenwu6.setVisibility(View.GONE);
                                        zirenwu7.setVisibility(View.GONE);
                                        zirenwu8.setVisibility(View.GONE);
                                        zirenwu9.setVisibility(View.GONE);
                                        zirenwu10.setVisibility(View.GONE);

                                    }
                                    if (childcount == 1&&list2.size()>0&&list2.get(0).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        taskid1 = list2.get(0).getTaskid();
//                                        useridd1 = list1.get(0).getUserid();
                                        progrss1 = list2.get(0).getProgress();
                                        Zi = list2.get(0).getZi();
                                        for (int i = 0; i < Zi.size(); i++) {
                                            heName1 += Zi.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        LogUtil.d("Zi--子任务名---",heName1+"--");
                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
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
                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                    }
                                    if (childcount == 3&&list2.size()>0&&list2.get(2).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        taskid3 = list2.get(2).getTaskid();
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
                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        progrss3 = list2.get(2).getProgress();
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);

                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                        zerenrename3 = heName3;
                                        wantime3 = list2.get(2).getYendtime();
                                        miaoshu3 = (String) list2.get(2).getTaskcontent();
                                        int c = list2.get(2).getCycletype();
                                        if (c == 0){
                                            baozhouqi3 = "单次";
                                        }
                                        if (c == 1){
                                            baozhouqi3 = "日报";
                                        }
                                        if (c ==2){
                                            baozhouqi3 = "周报";
                                        }
                                        if (c == 3){
                                            baozhouqi3 = "月报";
                                        }
                                    }
                                    if (childcount == 4&&list2.size()>0&&list2.get(3).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        taskid3 = list2.get(2).getTaskid();
                                        taskid4 = list2.get(3).getTaskid();
                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        progrss3 = list2.get(2).getProgress();
                                        progrss4 = list2.get(3).getProgress();
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

                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                        zerenrename3 = heName3;
                                        wantime3 = list2.get(2).getYendtime();
                                        miaoshu3 = (String) list2.get(2).getTaskcontent();
                                        int c = list2.get(2).getCycletype();
                                        if (c == 0){
                                            baozhouqi3 = "单次";
                                        }
                                        if (c == 1){
                                            baozhouqi3 = "日报";
                                        }
                                        if (c ==2){
                                            baozhouqi3 = "周报";
                                        }
                                        if (c == 3){
                                            baozhouqi3 = "月报";
                                        }
                                        zerenrename4 = heName4;
                                        wantime4 = list2.get(3).getYendtime();
                                        miaoshu4 = (String) list2.get(3).getTaskcontent();
                                        int d = list2.get(3).getCycletype();
                                        if (d == 0){
                                            baozhouqi4 = "单次";
                                        }
                                        if (d == 1){
                                            baozhouqi4 = "日报";
                                        }
                                        if (d ==2){
                                            baozhouqi4 = "周报";
                                        }
                                        if (d == 3){
                                            baozhouqi4 = "月报";
                                        }
                                    }
                                    if (childcount == 5&&list2.size()>0&&list2.get(4).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        zirenwu5.setVisibility(View.VISIBLE);
                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        taskid3 = list2.get(2).getTaskid();
                                        taskid4 = list2.get(3).getTaskid();
                                        taskid5 = list2.get(4).getTaskid();
                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        progrss3 = list2.get(2).getProgress();
                                        progrss4 = list2.get(3).getProgress();
                                        progrss5 = list2.get(4).getProgress();

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

                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                        zerenrename3 = heName3;
                                        wantime3 = list2.get(2).getYendtime();
                                        miaoshu3 = (String) list2.get(2).getTaskcontent();
                                        int c = list2.get(2).getCycletype();
                                        if (c == 0){
                                            baozhouqi3 = "单次";
                                        }
                                        if (c == 1){
                                            baozhouqi3 = "日报";
                                        }
                                        if (c ==2){
                                            baozhouqi3 = "周报";
                                        }
                                        if (c == 3){
                                            baozhouqi3 = "月报";
                                        }
                                        zerenrename4 = heName4;
                                        wantime4 = list2.get(3).getYendtime();
                                        miaoshu4 = (String) list2.get(3).getTaskcontent();
                                        int d = list2.get(3).getCycletype();
                                        if (d == 0){
                                            baozhouqi4 = "单次";
                                        }
                                        if (d == 1){
                                            baozhouqi4 = "日报";
                                        }
                                        if (d ==2){
                                            baozhouqi4 = "周报";
                                        }
                                        if (d == 3){
                                            baozhouqi4 = "月报";
                                        }
                                        zerenrename5 = heName5;
                                        wantime5 = list2.get(4).getYendtime();
                                        miaoshu5 = (String) list2.get(4).getTaskcontent();
                                        int e = list2.get(4).getCycletype();
                                        if (e == 0){
                                            baozhouqi5 = "单次";
                                        }
                                        if (e == 1){
                                            baozhouqi5 = "日报";
                                        }
                                        if (e ==2){
                                            baozhouqi5 = "周报";
                                        }
                                        if (e == 3){
                                            baozhouqi5 = "月报";
                                        }
                                    }
                                    if (childcount == 6&&list2.size()>0&&list2.get(5).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        zirenwu5.setVisibility(View.VISIBLE);
                                        zirenwu6.setVisibility(View.VISIBLE);
                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        taskid3 = list2.get(2).getTaskid();
                                        taskid4 = list2.get(3).getTaskid();
                                        taskid5 = list2.get(4).getTaskid();
                                        taskid6 = list2.get(5).getTaskid();
                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        progrss3 = list2.get(2).getProgress();
                                        progrss4 = list2.get(3).getProgress();
                                        progrss5 = list2.get(4).getProgress();
                                        progrss6 = list2.get(5).getProgress();
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
                                        Zi6 = list2.get(5).getZi();
                                        for (int i = 0; i < Zi6.size(); i++) {
                                            heName6 +=  Zi6.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);
                                        name4.setText(heName4);
                                        name5.setText(heName5);
                                        name6.setText(heName6);

                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                        zerenrename3 = heName3;
                                        wantime3 = list2.get(2).getYendtime();
                                        miaoshu3 = (String) list2.get(2).getTaskcontent();
                                        int c = list2.get(2).getCycletype();
                                        if (c == 0){
                                            baozhouqi3 = "单次";
                                        }
                                        if (c == 1){
                                            baozhouqi3 = "日报";
                                        }
                                        if (c ==2){
                                            baozhouqi3 = "周报";
                                        }
                                        if (c == 3){
                                            baozhouqi3 = "月报";
                                        }
                                        zerenrename4 = heName4;
                                        wantime4 = list2.get(3).getYendtime();
                                        miaoshu4 = (String) list2.get(3).getTaskcontent();
                                        int d = list2.get(3).getCycletype();
                                        if (d == 0){
                                            baozhouqi4 = "单次";
                                        }
                                        if (d == 1){
                                            baozhouqi4 = "日报";
                                        }
                                        if (d ==2){
                                            baozhouqi4 = "周报";
                                        }
                                        if (d == 3){
                                            baozhouqi4 = "月报";
                                        }
                                        zerenrename5 = heName5;
                                        wantime5 = list2.get(4).getYendtime();
                                        miaoshu5 = (String) list2.get(4).getTaskcontent();
                                        int e = list2.get(4).getCycletype();
                                        if (e == 0){
                                            baozhouqi5 = "单次";
                                        }
                                        if (e == 1){
                                            baozhouqi5 = "日报";
                                        }
                                        if (e ==2){
                                            baozhouqi5 = "周报";
                                        }
                                        if (e == 3){
                                            baozhouqi5 = "月报";
                                        }

                                        zerenrename6 = heName6;
                                        wantime6 = list2.get(5).getYendtime();
                                        miaoshu6 = (String) list2.get(5).getTaskcontent();
                                        int f = list2.get(5).getCycletype();
                                        if (f == 0){
                                            baozhouqi6 = "单次";
                                        }
                                        if (f == 1){
                                            baozhouqi6 = "日报";
                                        }
                                        if (f ==2){
                                            baozhouqi6 = "周报";
                                        }
                                        if (f == 3){
                                            baozhouqi6 = "月报";
                                        }
                                    }

                                    if (childcount == 7&&list2.size()>0&&list2.get(6).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        zirenwu5.setVisibility(View.VISIBLE);
                                        zirenwu6.setVisibility(View.VISIBLE);
                                        zirenwu7.setVisibility(View.VISIBLE);

                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        taskid3 = list2.get(2).getTaskid();
                                        taskid4 = list2.get(3).getTaskid();
                                        taskid5 = list2.get(4).getTaskid();
                                        taskid6 = list2.get(5).getTaskid();
                                        taskid7 = list2.get(6).getTaskid();

                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        progrss3 = list2.get(2).getProgress();
                                        progrss4 = list2.get(3).getProgress();
                                        progrss5 = list2.get(4).getProgress();
                                        progrss6 = list2.get(5).getProgress();
                                        progrss7 = list2.get(6).getProgress();

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
                                        Zi6 = list2.get(5).getZi();
                                        for (int i = 0; i < Zi6.size(); i++) {
                                            heName6 +=  Zi6.get(i)+";";
                                        }
                                        Zi7 = list2.get(6).getZi();
                                        for (int i = 0; i < Zi7.size(); i++) {
                                            heName7 +=  Zi7.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);
                                        name4.setText(heName4);
                                        name5.setText(heName5);
                                        name6.setText(heName6);
                                        name7.setText(heName7);

                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                        zerenrename3 = heName3;
                                        wantime3 = list2.get(2).getYendtime();
                                        miaoshu3 = (String) list2.get(2).getTaskcontent();
                                        int c = list2.get(2).getCycletype();
                                        if (c == 0){
                                            baozhouqi3 = "单次";
                                        }
                                        if (c == 1){
                                            baozhouqi3 = "日报";
                                        }
                                        if (c ==2){
                                            baozhouqi3 = "周报";
                                        }
                                        if (c == 3){
                                            baozhouqi3 = "月报";
                                        }
                                        zerenrename4 = heName4;
                                        wantime4 = list2.get(3).getYendtime();
                                        miaoshu4 = (String) list2.get(3).getTaskcontent();
                                        int d = list2.get(3).getCycletype();
                                        if (d == 0){
                                            baozhouqi4 = "单次";
                                        }
                                        if (d == 1){
                                            baozhouqi4 = "日报";
                                        }
                                        if (d ==2){
                                            baozhouqi4 = "周报";
                                        }
                                        if (d == 3){
                                            baozhouqi4 = "月报";
                                        }
                                        zerenrename5 = heName5;
                                        wantime5 = list2.get(4).getYendtime();
                                        miaoshu5 = (String) list2.get(4).getTaskcontent();
                                        int e = list2.get(4).getCycletype();
                                        if (e == 0){
                                            baozhouqi5 = "单次";
                                        }
                                        if (e == 1){
                                            baozhouqi5 = "日报";
                                        }
                                        if (e ==2){
                                            baozhouqi5 = "周报";
                                        }
                                        if (e == 3){
                                            baozhouqi5 = "月报";
                                        }

                                        zerenrename6 = heName6;
                                        wantime6 = list2.get(5).getYendtime();
                                        miaoshu6 = (String) list2.get(5).getTaskcontent();
                                        int f = list2.get(5).getCycletype();
                                        if (f == 0){
                                            baozhouqi6 = "单次";
                                        }
                                        if (f == 1){
                                            baozhouqi6 = "日报";
                                        }
                                        if (f ==2){
                                            baozhouqi6 = "周报";
                                        }
                                        if (f == 3){
                                            baozhouqi6 = "月报";
                                        }
                                        zerenrename7 = heName7;
                                        wantime7 = list2.get(6).getYendtime();
                                        miaoshu7 = (String) list2.get(6).getTaskcontent();
                                        int g = list2.get(6).getCycletype();
                                        if (g == 0){
                                            baozhouqi7 = "单次";
                                        }
                                        if (g == 1){
                                            baozhouqi7 = "日报";
                                        }
                                        if (g ==2){
                                            baozhouqi7 = "周报";
                                        }
                                        if (g == 3){
                                            baozhouqi7 = "月报";
                                        }
                                    }

                                    if (childcount == 8&&list2.size()>0&&list2.get(7).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        zirenwu5.setVisibility(View.VISIBLE);
                                        zirenwu6.setVisibility(View.VISIBLE);
                                        zirenwu7.setVisibility(View.VISIBLE);
                                        zirenwu8.setVisibility(View.VISIBLE);

                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        taskid3 = list2.get(2).getTaskid();
                                        taskid4 = list2.get(3).getTaskid();
                                        taskid5 = list2.get(4).getTaskid();
                                        taskid6 = list2.get(5).getTaskid();
                                        taskid7 = list2.get(6).getTaskid();
                                        taskid8 = list2.get(7).getTaskid();

                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        progrss3 = list2.get(2).getProgress();
                                        progrss4 = list2.get(3).getProgress();
                                        progrss5 = list2.get(4).getProgress();
                                        progrss6 = list2.get(5).getProgress();
                                        progrss7 = list2.get(6).getProgress();
                                        progrss8 = list2.get(7).getProgress();

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
                                        Zi6 = list2.get(5).getZi();
                                        for (int i = 0; i < Zi6.size(); i++) {
                                            heName6 +=  Zi6.get(i)+";";
                                        }
                                        Zi7 = list2.get(6).getZi();
                                        for (int i = 0; i < Zi7.size(); i++) {
                                            heName7 +=  Zi7.get(i)+";";
                                        }
                                        Zi8 = list2.get(7).getZi();
                                        for (int i = 0; i < Zi8.size(); i++) {
                                            heName8 +=  Zi8.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);
                                        name4.setText(heName4);
                                        name5.setText(heName5);
                                        name6.setText(heName6);
                                        name7.setText(heName7);
                                        name8.setText(heName8);

                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                        zerenrename3 = heName3;
                                        wantime3 = list2.get(2).getYendtime();
                                        miaoshu3 = (String) list2.get(2).getTaskcontent();
                                        int c = list2.get(2).getCycletype();
                                        if (c == 0){
                                            baozhouqi3 = "单次";
                                        }
                                        if (c == 1){
                                            baozhouqi3 = "日报";
                                        }
                                        if (c ==2){
                                            baozhouqi3 = "周报";
                                        }
                                        if (c == 3){
                                            baozhouqi3 = "月报";
                                        }
                                        zerenrename4 = heName4;
                                        wantime4 = list2.get(3).getYendtime();
                                        miaoshu4 = (String) list2.get(3).getTaskcontent();
                                        int d = list2.get(3).getCycletype();
                                        if (d == 0){
                                            baozhouqi4 = "单次";
                                        }
                                        if (d == 1){
                                            baozhouqi4 = "日报";
                                        }
                                        if (d ==2){
                                            baozhouqi4 = "周报";
                                        }
                                        if (d == 3){
                                            baozhouqi4 = "月报";
                                        }
                                        zerenrename5 = heName5;
                                        wantime5 = list2.get(4).getYendtime();
                                        miaoshu5 = (String) list2.get(4).getTaskcontent();
                                        int e = list2.get(4).getCycletype();
                                        if (e == 0){
                                            baozhouqi5 = "单次";
                                        }
                                        if (e == 1){
                                            baozhouqi5 = "日报";
                                        }
                                        if (e ==2){
                                            baozhouqi5 = "周报";
                                        }
                                        if (e == 3){
                                            baozhouqi5 = "月报";
                                        }

                                        zerenrename6 = heName6;
                                        wantime6 = list2.get(5).getYendtime();
                                        miaoshu6 = (String) list2.get(5).getTaskcontent();
                                        int f = list2.get(5).getCycletype();
                                        if (f == 0){
                                            baozhouqi6 = "单次";
                                        }
                                        if (f == 1){
                                            baozhouqi6 = "日报";
                                        }
                                        if (f ==2){
                                            baozhouqi6 = "周报";
                                        }
                                        if (f == 3){
                                            baozhouqi6 = "月报";
                                        }
                                        zerenrename7 = heName7;
                                        wantime7 = list2.get(6).getYendtime();
                                        miaoshu7 = (String) list2.get(6).getTaskcontent();
                                        int g = list2.get(6).getCycletype();
                                        if (g == 0){
                                            baozhouqi7 = "单次";
                                        }
                                        if (g == 1){
                                            baozhouqi7 = "日报";
                                        }
                                        if (g ==2){
                                            baozhouqi7 = "周报";
                                        }
                                        if (g == 3){
                                            baozhouqi7 = "月报";
                                        }
                                        zerenrename8 = heName8;
                                        wantime8 = list2.get(7).getYendtime();
                                        miaoshu8 = (String) list2.get(7).getTaskcontent();
                                        int h = list2.get(7).getCycletype();
                                        if (h == 0){
                                            baozhouqi8 = "单次";
                                        }
                                        if (h == 1){
                                            baozhouqi8 = "日报";
                                        }
                                        if (h ==2){
                                            baozhouqi8 = "周报";
                                        }
                                        if (h == 3){
                                            baozhouqi8 = "月报";
                                        }
                                    }

                                    if (childcount == 9&&list2.size()>0&&list2.get(8).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        zirenwu5.setVisibility(View.VISIBLE);
                                        zirenwu6.setVisibility(View.VISIBLE);
                                        zirenwu7.setVisibility(View.VISIBLE);
                                        zirenwu8.setVisibility(View.VISIBLE);
                                        zirenwu9.setVisibility(View.VISIBLE);

                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        taskid3 = list2.get(2).getTaskid();
                                        taskid4 = list2.get(3).getTaskid();
                                        taskid5 = list2.get(4).getTaskid();
                                        taskid6 = list2.get(5).getTaskid();
                                        taskid7 = list2.get(6).getTaskid();
                                        taskid8 = list2.get(7).getTaskid();
                                        taskid9 = list2.get(8).getTaskid();

                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        progrss3 = list2.get(2).getProgress();
                                        progrss4 = list2.get(3).getProgress();
                                        progrss5 = list2.get(4).getProgress();
                                        progrss6 = list2.get(5).getProgress();
                                        progrss7 = list2.get(6).getProgress();
                                        progrss8 = list2.get(7).getProgress();
                                        progrss9 = list2.get(8).getProgress();

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
                                        Zi6 = list2.get(5).getZi();
                                        for (int i = 0; i < Zi6.size(); i++) {
                                            heName6 +=  Zi6.get(i)+";";
                                        }
                                        Zi7 = list2.get(6).getZi();
                                        for (int i = 0; i < Zi7.size(); i++) {
                                            heName7 +=  Zi7.get(i)+";";
                                        }
                                        Zi8 = list2.get(7).getZi();
                                        for (int i = 0; i < Zi8.size(); i++) {
                                            heName8 +=  Zi8.get(i)+";";
                                        }
                                        Zi9 = list2.get(8).getZi();
                                        for (int i = 0; i < Zi9.size(); i++) {
                                            heName9 +=  Zi9.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);
                                        name4.setText(heName4);
                                        name5.setText(heName5);
                                        name6.setText(heName6);
                                        name7.setText(heName7);
                                        name8.setText(heName8);
                                        name9.setText(heName9);

                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                        zerenrename3 = heName3;
                                        wantime3 = list2.get(2).getYendtime();
                                        miaoshu3 = (String) list2.get(2).getTaskcontent();
                                        int c = list2.get(2).getCycletype();
                                        if (c == 0){
                                            baozhouqi3 = "单次";
                                        }
                                        if (c == 1){
                                            baozhouqi3 = "日报";
                                        }
                                        if (c ==2){
                                            baozhouqi3 = "周报";
                                        }
                                        if (c == 3){
                                            baozhouqi3 = "月报";
                                        }
                                        zerenrename4 = heName4;
                                        wantime4 = list2.get(3).getYendtime();
                                        miaoshu4 = (String) list2.get(3).getTaskcontent();
                                        int d = list2.get(3).getCycletype();
                                        if (d == 0){
                                            baozhouqi4 = "单次";
                                        }
                                        if (d == 1){
                                            baozhouqi4 = "日报";
                                        }
                                        if (d ==2){
                                            baozhouqi4 = "周报";
                                        }
                                        if (d == 3){
                                            baozhouqi4 = "月报";
                                        }
                                        zerenrename5 = heName5;
                                        wantime5 = list2.get(4).getYendtime();
                                        miaoshu5 = (String) list2.get(4).getTaskcontent();
                                        int e = list2.get(4).getCycletype();
                                        if (e == 0){
                                            baozhouqi5 = "单次";
                                        }
                                        if (e == 1){
                                            baozhouqi5 = "日报";
                                        }
                                        if (e ==2){
                                            baozhouqi5 = "周报";
                                        }
                                        if (e == 3){
                                            baozhouqi5 = "月报";
                                        }

                                        zerenrename6 = heName6;
                                        wantime6 = list2.get(5).getYendtime();
                                        miaoshu6 = (String) list2.get(5).getTaskcontent();
                                        int f = list2.get(5).getCycletype();
                                        if (f == 0){
                                            baozhouqi6 = "单次";
                                        }
                                        if (f == 1){
                                            baozhouqi6 = "日报";
                                        }
                                        if (f ==2){
                                            baozhouqi6 = "周报";
                                        }
                                        if (f == 3){
                                            baozhouqi6 = "月报";
                                        }
                                        zerenrename7 = heName7;
                                        wantime7 = list2.get(6).getYendtime();
                                        miaoshu7 = (String) list2.get(6).getTaskcontent();
                                        int g = list2.get(6).getCycletype();
                                        if (g == 0){
                                            baozhouqi7 = "单次";
                                        }
                                        if (g == 1){
                                            baozhouqi7 = "日报";
                                        }
                                        if (g ==2){
                                            baozhouqi7 = "周报";
                                        }
                                        if (g == 3){
                                            baozhouqi7 = "月报";
                                        }
                                        zerenrename8 = heName8;
                                        wantime8 = list2.get(7).getYendtime();
                                        miaoshu8 = (String) list2.get(7).getTaskcontent();
                                        int h = list2.get(7).getCycletype();
                                        if (h == 0){
                                            baozhouqi8 = "单次";
                                        }
                                        if (h == 1){
                                            baozhouqi8 = "日报";
                                        }
                                        if (h ==2){
                                            baozhouqi8 = "周报";
                                        }
                                        if (h == 3){
                                            baozhouqi8 = "月报";
                                        }
                                        zerenrename9 = heName9;
                                        wantime9 = list2.get(8).getYendtime();
                                        miaoshu9 = (String) list2.get(8).getTaskcontent();
                                        int i = list2.get(8).getCycletype();
                                        if (i == 0){
                                            baozhouqi9 = "单次";
                                        }
                                        if (i == 1){
                                            baozhouqi9 = "日报";
                                        }
                                        if (i ==2){
                                            baozhouqi9 = "周报";
                                        }
                                        if (i == 3){
                                            baozhouqi9 = "月报";
                                        }
                                    }

                                    if (childcount >= 10&&list2.size()>0&&list2.get(9).getZi()!=null){
                                        zirenwu1.setVisibility(View.VISIBLE);
                                        zirenwu2.setVisibility(View.VISIBLE);
                                        zirenwu3.setVisibility(View.VISIBLE);
                                        zirenwu4.setVisibility(View.VISIBLE);
                                        zirenwu5.setVisibility(View.VISIBLE);
                                        zirenwu6.setVisibility(View.VISIBLE);
                                        zirenwu7.setVisibility(View.VISIBLE);
                                        zirenwu8.setVisibility(View.VISIBLE);
                                        zirenwu9.setVisibility(View.VISIBLE);
                                        zirenwu10.setVisibility(View.VISIBLE);

                                        taskid1 = list2.get(0).getTaskid();
                                        taskid2 = list2.get(1).getTaskid();
                                        taskid3 = list2.get(2).getTaskid();
                                        taskid4 = list2.get(3).getTaskid();
                                        taskid5 = list2.get(4).getTaskid();
                                        taskid6 = list2.get(5).getTaskid();
                                        taskid7 = list2.get(6).getTaskid();
                                        taskid8 = list2.get(7).getTaskid();
                                        taskid9 = list2.get(8).getTaskid();
                                        taskid10 = list2.get(9).getTaskid();

                                        progrss1 = list2.get(0).getProgress();
                                        progrss2 = list2.get(1).getProgress();
                                        progrss3 = list2.get(2).getProgress();
                                        progrss4 = list2.get(3).getProgress();
                                        progrss5 = list2.get(4).getProgress();
                                        progrss6 = list2.get(5).getProgress();
                                        progrss7 = list2.get(6).getProgress();
                                        progrss8 = list2.get(7).getProgress();
                                        progrss9 = list2.get(8).getProgress();
                                        progrss10 = list2.get(9).getProgress();

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
                                        Zi6 = list2.get(5).getZi();
                                        for (int i = 0; i < Zi6.size(); i++) {
                                            heName6 +=  Zi6.get(i)+";";
                                        }
                                        Zi7 = list2.get(6).getZi();
                                        for (int i = 0; i < Zi7.size(); i++) {
                                            heName7 +=  Zi7.get(i)+";";
                                        }
                                        Zi8 = list2.get(7).getZi();
                                        for (int i = 0; i < Zi8.size(); i++) {
                                            heName8 +=  Zi8.get(i)+";";
                                        }
                                        Zi9 = list2.get(8).getZi();
                                        for (int i = 0; i < Zi9.size(); i++) {
                                            heName9 +=  Zi9.get(i)+";";
                                        }
                                        Zi10 = list2.get(9).getZi();
                                        for (int i = 0; i < Zi10.size(); i++) {
                                            heName10 +=  Zi10.get(i)+";";
                                        }
                                        name1.setText(heName1);
                                        name2.setText(heName2);
                                        name3.setText(heName3);
                                        name4.setText(heName4);
                                        name5.setText(heName5);
                                        name6.setText(heName6);
                                        name7.setText(heName7);
                                        name8.setText(heName8);
                                        name9.setText(heName9);
                                        name10.setText(heName10);

                                        zerenrename1 = heName1;
                                        wantime1 = list2.get(0).getYendtime();
                                        miaoshu1 = (String) list2.get(0).getTaskcontent();
                                        int a = list2.get(0).getCycletype();
                                        if (a == 0){
                                            baozhouqi1 = "单次";
                                        }
                                        if (a == 1){
                                            baozhouqi1 = "日报";
                                        }
                                        if (a ==2){
                                            baozhouqi1 = "周报";
                                        }
                                        if (a == 3){
                                            baozhouqi1 = "月报";
                                        }
                                        zerenrename2 = heName2;
                                        wantime2 = list2.get(1).getYendtime();
                                        miaoshu2 = (String) list2.get(1).getTaskcontent();
                                        int b = list2.get(1).getCycletype();
                                        if (b == 0){
                                            baozhouqi2 = "单次";
                                        }
                                        if (b == 1){
                                            baozhouqi2 = "日报";
                                        }
                                        if (b ==2){
                                            baozhouqi2 = "周报";
                                        }
                                        if (b == 3){
                                            baozhouqi2 = "月报";
                                        }
                                        zerenrename3 = heName3;
                                        wantime3 = list2.get(2).getYendtime();
                                        miaoshu3 = (String) list2.get(2).getTaskcontent();
                                        int c = list2.get(2).getCycletype();
                                        if (c == 0){
                                            baozhouqi3 = "单次";
                                        }
                                        if (c == 1){
                                            baozhouqi3 = "日报";
                                        }
                                        if (c ==2){
                                            baozhouqi3 = "周报";
                                        }
                                        if (c == 3){
                                            baozhouqi3 = "月报";
                                        }
                                        zerenrename4 = heName4;
                                        wantime4 = list2.get(3).getYendtime();
                                        miaoshu4 = (String) list2.get(3).getTaskcontent();
                                        int d = list2.get(3).getCycletype();
                                        if (d == 0){
                                            baozhouqi4 = "单次";
                                        }
                                        if (d == 1){
                                            baozhouqi4 = "日报";
                                        }
                                        if (d ==2){
                                            baozhouqi4 = "周报";
                                        }
                                        if (d == 3){
                                            baozhouqi4 = "月报";
                                        }
                                        zerenrename5 = heName5;
                                        wantime5 = list2.get(4).getYendtime();
                                        miaoshu5 = (String) list2.get(4).getTaskcontent();
                                        int e = list2.get(4).getCycletype();
                                        if (e == 0){
                                            baozhouqi5 = "单次";
                                        }
                                        if (e == 1){
                                            baozhouqi5 = "日报";
                                        }
                                        if (e ==2){
                                            baozhouqi5 = "周报";
                                        }
                                        if (e == 3){
                                            baozhouqi5 = "月报";
                                        }

                                        zerenrename6 = heName6;
                                        wantime6 = list2.get(5).getYendtime();
                                        miaoshu6 = (String) list2.get(5).getTaskcontent();
                                        int f = list2.get(5).getCycletype();
                                        if (f == 0){
                                            baozhouqi6 = "单次";
                                        }
                                        if (f == 1){
                                            baozhouqi6 = "日报";
                                        }
                                        if (f ==2){
                                            baozhouqi6 = "周报";
                                        }
                                        if (f == 3){
                                            baozhouqi6 = "月报";
                                        }
                                        zerenrename7 = heName7;
                                        wantime7 = list2.get(6).getYendtime();
                                        miaoshu7 = (String) list2.get(6).getTaskcontent();
                                        int g = list2.get(6).getCycletype();
                                        if (g == 0){
                                            baozhouqi7 = "单次";
                                        }
                                        if (g == 1){
                                            baozhouqi7 = "日报";
                                        }
                                        if (g ==2){
                                            baozhouqi7 = "周报";
                                        }
                                        if (g == 3){
                                            baozhouqi7 = "月报";
                                        }
                                        zerenrename8 = heName8;
                                        wantime8 = list2.get(7).getYendtime();
                                        miaoshu8 = (String) list2.get(7).getTaskcontent();
                                        int h = list2.get(7).getCycletype();
                                        if (h == 0){
                                            baozhouqi8 = "单次";
                                        }
                                        if (h == 1){
                                            baozhouqi8 = "日报";
                                        }
                                        if (h ==2){
                                            baozhouqi8 = "周报";
                                        }
                                        if (h == 3){
                                            baozhouqi8 = "月报";
                                        }
                                        zerenrename9 = heName9;
                                        wantime9 = list2.get(8).getYendtime();
                                        miaoshu9 = (String) list2.get(8).getTaskcontent();
                                        int i = list2.get(8).getCycletype();
                                        if (i == 0){
                                            baozhouqi9 = "单次";
                                        }
                                        if (i == 1){
                                            baozhouqi9 = "日报";
                                        }
                                        if (i ==2){
                                            baozhouqi9 = "周报";
                                        }
                                        if (i == 3){
                                            baozhouqi9 = "月报";
                                        }
                                        zerenrename10 = heName10;
                                        wantime10 = list2.get(9).getYendtime();
                                        miaoshu10 = (String) list2.get(9).getTaskcontent();
                                        int j = list2.get(9).getCycletype();
                                        if (j == 0){
                                            baozhouqi10 = "单次";
                                        }
                                        if (j == 1){
                                            baozhouqi10 = "日报";
                                        }
                                        if (j ==2){
                                            baozhouqi10 = "周报";
                                        }
                                        if (j == 3){
                                            baozhouqi10 = "月报";
                                        }
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

                                        fj1.setVisibility(View.GONE);
                                        fj2.setVisibility(View.GONE);
                                        fj3.setVisibility(View.GONE);
                                        fj4.setVisibility(View.GONE);
                                        fj5.setVisibility(View.GONE);
                                        fj6.setVisibility(View.GONE);
                                        fj7.setVisibility(View.GONE);
                                        fj8.setVisibility(View.GONE);
                                        fj9.setVisibility(View.GONE);
                                        fj10.setVisibility(View.GONE);

                                        wu.setVisibility(View.VISIBLE);
                                    }

                                    if (listacc!= null&&listacc.size()==1){

                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                    }
                                    if (listacc!=null&&listacc.size()==2){
                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });

                                        }else {
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
                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                    }
                                    if (listacc!=null&&listacc.size() == 3){

                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(2).getAssid().equals("-1")){
                                            fj3.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext3.setText(listacc.get(2).getFileName());
                                            final String url2 = listacc.get(2).getFileaddressdown();
                                            fj3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                    }
                                    if (listacc!= null&&listacc.size()==4){

                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(2).getAssid().equals("-1")){
                                            fj3.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext3.setText(listacc.get(2).getFileName());
                                            final String url2 = listacc.get(2).getFileaddressdown();
                                            fj3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(3).getAssid().equals("-1")){
                                            fj4.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext4.setText(listacc.get(3).getFileName());
                                            final String url2 = listacc.get(3).getFileaddressdown();
                                            fj4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
                                            fujian4.setVisibility(View.VISIBLE);
                                            fujianname4.setText(listacc.get(3).getFileName());
                                            final String url3 = listacc.get(3).getFileaddressdown();
                                            fujian4.setOnClickListener(new View.OnClickListener() {
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
                                    }
                                    if (listacc!=null&&listacc.size() == 5){
                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(2).getAssid().equals("-1")){
                                            fj3.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext3.setText(listacc.get(2).getFileName());
                                            final String url2 = listacc.get(2).getFileaddressdown();
                                            fj3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(3).getAssid().equals("-1")){
                                            wu.setVisibility(View.INVISIBLE);
                                            fj4.setVisibility(View.VISIBLE);
                                            fjtext4.setText(listacc.get(3).getFileName());
                                            final String url2 = listacc.get(3).getFileaddressdown();
                                            fj4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
                                            fujian4.setVisibility(View.VISIBLE);
                                            fujianname4.setText(listacc.get(3).getFileName());
                                            final String url3 = listacc.get(3).getFileaddressdown();
                                            fujian4.setOnClickListener(new View.OnClickListener() {
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
                                        if (listacc.get(4).getAssid().equals("-1")){
                                            wu.setVisibility(View.INVISIBLE);
                                            fj5.setVisibility(View.VISIBLE);
                                            fjtext5.setText(listacc.get(4).getFileName());
                                            final String url2 = listacc.get(4).getFileaddressdown();
                                            fj5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                    }
                                    if (listacc != null&&listacc.size() == 6){
                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(2).getAssid().equals("-1")){
                                            fj3.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext3.setText(listacc.get(2).getFileName());
                                            final String url2 = listacc.get(2).getFileaddressdown();
                                            fj3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(3).getAssid().equals("-1")){
                                            fj4.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext4.setText(listacc.get(3).getFileName());
                                            final String url2 = listacc.get(3).getFileaddressdown();
                                            fj4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
                                            fujian4.setVisibility(View.VISIBLE);
                                            fujianname4.setText(listacc.get(3).getFileName());
                                            final String url3 = listacc.get(3).getFileaddressdown();
                                            fujian4.setOnClickListener(new View.OnClickListener() {
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
                                        if (listacc.get(4).getAssid().equals("-1")){
                                            fj5.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext5.setText(listacc.get(4).getFileName());
                                            final String url2 = listacc.get(4).getFileaddressdown();
                                            fj5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(5).getAssid().equals("-1")){
                                            fj6.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext6.setText(listacc.get(5).getFileName());
                                            final String url2 = listacc.get(5).getFileaddressdown();
                                            fj6.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                    }
                                    if (listacc != null&&listacc.size() == 7){
                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(2).getAssid().equals("-1")){
                                            fj3.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext3.setText(listacc.get(2).getFileName());
                                            final String url2 = listacc.get(2).getFileaddressdown();
                                            fj3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(3).getAssid().equals("-1")){
                                            fj4.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext4.setText(listacc.get(3).getFileName());
                                            final String url2 = listacc.get(3).getFileaddressdown();
                                            fj4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
                                            fujian4.setVisibility(View.VISIBLE);
                                            fujianname4.setText(listacc.get(3).getFileName());
                                            final String url3 = listacc.get(3).getFileaddressdown();
                                            fujian4.setOnClickListener(new View.OnClickListener() {
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
                                        if (listacc.get(4).getAssid().equals("-1")){
                                            fj5.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext5.setText(listacc.get(4).getFileName());
                                            final String url2 = listacc.get(4).getFileaddressdown();
                                            fj5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(5).getAssid().equals("-1")){
                                            fj6.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext6.setText(listacc.get(5).getFileName());
                                            final String url2 = listacc.get(5).getFileaddressdown();
                                            fj6.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(6).getAssid().equals("-1")){
                                            fj7.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext7.setText(listacc.get(6).getFileName());
                                            final String url2 = listacc.get(6).getFileaddressdown();
                                            fj7.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                    }
                                    if (listacc!=null&&listacc.size() == 8){
                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(2).getAssid().equals("-1")){
                                            fj3.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext3.setText(listacc.get(2).getFileName());
                                            final String url2 = listacc.get(2).getFileaddressdown();
                                            fj3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(3).getAssid().equals("-1")){
                                            fj4.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext4.setText(listacc.get(3).getFileName());
                                            final String url2 = listacc.get(3).getFileaddressdown();
                                            fj4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
                                            fujian4.setVisibility(View.VISIBLE);
                                            fujianname4.setText(listacc.get(3).getFileName());
                                            final String url3 = listacc.get(3).getFileaddressdown();
                                            fujian4.setOnClickListener(new View.OnClickListener() {
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
                                        if (listacc.get(4).getAssid().equals("-1")){
                                            fj5.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext5.setText(listacc.get(4).getFileName());
                                            final String url2 = listacc.get(4).getFileaddressdown();
                                            fj5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(5).getAssid().equals("-1")){
                                            fj6.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext6.setText(listacc.get(5).getFileName());
                                            final String url2 = listacc.get(5).getFileaddressdown();
                                            fj6.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(6).getAssid().equals("-1")){
                                            fj7.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext7.setText(listacc.get(6).getFileName());
                                            final String url2 = listacc.get(6).getFileaddressdown();
                                            fj7.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(7).getAssid().equals("-1")){
                                            fj8.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext8.setText(listacc.get(7).getFileName());
                                            final String url2 = listacc.get(7).getFileaddressdown();
                                            fj8.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                    }
                                    if (listacc!= null&&listacc.size()==9){
                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(2).getAssid().equals("-1")){
                                            fj3.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext3.setText(listacc.get(2).getFileName());
                                            final String url2 = listacc.get(2).getFileaddressdown();
                                            fj3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(3).getAssid().equals("-1")){
                                            fj4.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext4.setText(listacc.get(3).getFileName());
                                            final String url2 = listacc.get(3).getFileaddressdown();
                                            fj4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
                                            fujian4.setVisibility(View.VISIBLE);
                                            fujianname4.setText(listacc.get(3).getFileName());
                                            final String url3 = listacc.get(3).getFileaddressdown();
                                            fujian4.setOnClickListener(new View.OnClickListener() {
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
                                        if (listacc.get(4).getAssid().equals("-1")){
                                            fj5.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext5.setText(listacc.get(4).getFileName());
                                            final String url2 = listacc.get(4).getFileaddressdown();
                                            fj5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(5).getAssid().equals("-1")){
                                            fj6.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext6.setText(listacc.get(5).getFileName());
                                            final String url2 = listacc.get(5).getFileaddressdown();
                                            fj6.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(6).getAssid().equals("-1")){
                                            fj7.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext7.setText(listacc.get(6).getFileName());
                                            final String url2 = listacc.get(6).getFileaddressdown();
                                            fj7.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(7).getAssid().equals("-1")){
                                            fj8.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext8.setText(listacc.get(7).getFileName());
                                            final String url2 = listacc.get(7).getFileaddressdown();
                                            fj8.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(8).getAssid().equals("-1")){
                                            fj9.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext9.setText(listacc.get(8).getFileName());
                                            final String url2 = listacc.get(8).getFileaddressdown();
                                            fj9.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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


                                    }
                                    if (listacc!=null&&listacc.size()>=10){
                                        if (listacc.get(0).getAssid().equals("-1")){
                                            fj1.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext1.setText(listacc.get(0).getFileName());
                                            final String url = listacc.get(0).getFileaddressdown();
                                            fj1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(1).getAssid().equals("-1")){
                                            fj2.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext2.setText(listacc.get(1).getFileName());
                                            final String url2 = listacc.get(1).getFileaddressdown();
                                            fj2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(2).getAssid().equals("-1")){
                                            fj3.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext3.setText(listacc.get(2).getFileName());
                                            final String url2 = listacc.get(2).getFileaddressdown();
                                            fj3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(3).getAssid().equals("-1")){
                                            fj4.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext4.setText(listacc.get(3).getFileName());
                                            final String url2 = listacc.get(3).getFileaddressdown();
                                            fj4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
                                            fujian4.setVisibility(View.VISIBLE);
                                            fujianname4.setText(listacc.get(3).getFileName());
                                            final String url3 = listacc.get(3).getFileaddressdown();
                                            fujian4.setOnClickListener(new View.OnClickListener() {
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
                                        if (listacc.get(4).getAssid().equals("-1")){
                                            fj5.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext5.setText(listacc.get(4).getFileName());
                                            final String url2 = listacc.get(4).getFileaddressdown();
                                            fj5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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

                                        if (listacc.get(5).getAssid().equals("-1")){
                                            fj6.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext6.setText(listacc.get(5).getFileName());
                                            final String url2 = listacc.get(5).getFileaddressdown();
                                            fj6.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(6).getAssid().equals("-1")){
                                            fj7.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext7.setText(listacc.get(6).getFileName());
                                            final String url2 = listacc.get(6).getFileaddressdown();
                                            fj7.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(7).getAssid().equals("-1")){
                                            fj8.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext8.setText(listacc.get(7).getFileName());
                                            final String url2 = listacc.get(7).getFileaddressdown();
                                            fj8.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(8).getAssid().equals("-1")){
                                            fj9.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext9.setText(listacc.get(8).getFileName());
                                            final String url2 = listacc.get(8).getFileaddressdown();
                                            fj9.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
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
                                        if (listacc.get(9).getAssid().equals("-1")){
                                            fj10.setVisibility(View.VISIBLE);
                                            wu.setVisibility(View.INVISIBLE);
                                            fjtext10.setText(listacc.get(9).getFileName());
                                            final String url2 = listacc.get(9).getFileaddressdown();
                                            fj10.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent= new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url = Uri.parse(url2);
                                                    intent.setData(content_url);
                                                    startActivity(intent);
                                                }
                                            });
                                        }else {
                                            fujian10.setVisibility(View.VISIBLE);
                                            fujianname10.setText(listacc.get(9).getFileName());
                                            final String url10 = listacc.get(9).getFileaddressdown();
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

//                                    if (fj1.isEnabled()&&fj2.isEnabled()&&fj3.isEnabled()&&fj4.isEnabled()&&fj5.isEnabled()
//                                            &&fj6.isEnabled()&&fj7.isEnabled()&&fj8.isEnabled()&&fj9.isEnabled()&&fj10.isEnabled()){
//                                        wu.setVisibility(View.INVISIBLE);
//
//                                    }else {
//                                        wu.setVisibility(View.VISIBLE);
//                                    }
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
        EventBus.getDefault().register(Activity_Deatail.this);
        add_zirenwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToastUtil.showToast("添加子任务");
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu.class);
                intent.putExtra("taskid",taskid);
                startActivity(intent);
            }
        });
        //子任务点击
        zirenwu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu1.class);
                intent.putExtra("zerenrename1",zerenrename1);
                intent.putExtra("wantime1",wantime1);
                intent.putExtra("baozhouqi1",baozhouqi1);
                intent.putExtra("miaoshu1",miaoshu1);
                intent.putExtra("taskid1",taskid1);
                intent.putExtra("useid1",useid1);
                LogUtil.d("任务描述---384--",miaoshu1+"----");
                LogUtil.d("进度---384",progrss1+"---");
                intent.putExtra("progress1",progrss1);
                startActivity(intent);
            }
        });
        zirenwu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu2.class);
                intent.putExtra("taskid2",taskid2);
                intent.putExtra("zerenrename2",zerenrename2);
                intent.putExtra("wantime2",wantime2);
                intent.putExtra("baozhouqi2",baozhouqi2);
                intent.putExtra("miaoshu2",miaoshu2);
                intent.putExtra("useid2",useid1);
                intent.putExtra("progress2",progrss2);
                startActivity(intent);
            }
        });
        zirenwu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu3.class);
                intent.putExtra("taskid3",taskid3);
                intent.putExtra("useid3",useid1);
                intent.putExtra("zerenrename3",zerenrename3);
                intent.putExtra("wantime3",wantime3);
                intent.putExtra("baozhouqi3",baozhouqi3);
                intent.putExtra("miaoshu3",miaoshu3);
                intent.putExtra("progress3",progrss3);
                startActivity(intent);
            }
        });
        zirenwu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu4.class);
                intent.putExtra("taskid4",taskid4);
                intent.putExtra("useid4",useid1);
                intent.putExtra("zerenrename4",zerenrename4);
                intent.putExtra("wantime4",wantime4);
                intent.putExtra("baozhouqi4",baozhouqi4);
                intent.putExtra("miaoshu4",miaoshu4);
                intent.putExtra("progress4",progrss4);
                startActivity(intent);
            }
        });
        zirenwu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu5.class);
                intent.putExtra("taskid5",taskid5);
                intent.putExtra("useid5",useid1);
                intent.putExtra("zerenrename5",zerenrename5);
                intent.putExtra("wantime5",wantime5);
                intent.putExtra("baozhouqi5",baozhouqi5);
                intent.putExtra("miaoshu5",miaoshu5);
                intent.putExtra("progress5",progrss5);
                startActivity(intent);
            }
        });
        zirenwu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu66.class);
                intent.putExtra("taskid6",taskid6);
                intent.putExtra("useid6",useid1);
                intent.putExtra("zerenrename6",zerenrename6);
                intent.putExtra("wantime6",wantime6);
                intent.putExtra("baozhouqi6",baozhouqi6);
                intent.putExtra("miaoshu6",miaoshu6);
                intent.putExtra("progress6",progrss6);
                startActivity(intent);
            }
        });
        zirenwu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu77.class);
                intent.putExtra("taskid7",taskid7);
                intent.putExtra("useid7",useid1);
                intent.putExtra("zerenrename7",zerenrename7);
                intent.putExtra("wantime7",wantime7);
                intent.putExtra("baozhouqi7",baozhouqi7);
                intent.putExtra("miaoshu7",miaoshu7);
                intent.putExtra("progress7",progrss7);
                startActivity(intent);
            }
        });
        zirenwu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu88.class);
                intent.putExtra("taskid8",taskid8);
                intent.putExtra("useid8",useid1);
                intent.putExtra("zerenrename8",zerenrename8);
                intent.putExtra("wantime8",wantime8);
                intent.putExtra("baozhouqi8",baozhouqi8);
                intent.putExtra("miaoshu8",miaoshu8);
                intent.putExtra("progress8",progrss8);
                startActivity(intent);
            }
        });
        zirenwu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu99.class);
                intent.putExtra("taskid9",taskid9);
                intent.putExtra("useid9",useid1);
                intent.putExtra("zerenrename9",zerenrename9);
                intent.putExtra("wantime9",wantime9);
                intent.putExtra("baozhouqi9",baozhouqi9);
                intent.putExtra("miaoshu9",miaoshu9);
                intent.putExtra("progress9",progrss9);
                startActivity(intent);
            }
        });
        zirenwu10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu110.class);
                intent.putExtra("taskid10",taskid10);
                intent.putExtra("useid10",useid1);
                intent.putExtra("zerenrename10",zerenrename10);
                intent.putExtra("wantime10",wantime10);
                intent.putExtra("baozhouqi10",baozhouqi10);
                intent.putExtra("miaoshu10",miaoshu10);
                intent.putExtra("progress10",progrss10);
                startActivity(intent);
            }
        });
        add_fujian.setOnClickListener(new View.OnClickListener() {
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

        //保存
        finsh_daiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zirenwuNum = SharedPreferencesUtil.readZirenwuNum(Activity_Deatail.this);
                tasklevel = "6";
                renwumiaoshu2 = renwumiaoshu.getText().toString().trim();//任务描述

                if (zirenwuNum == 1){
                    httpson1();
                }else if (zirenwuNum == 2){
                    httpson1();
                    httpson2();
                }else if (zirenwuNum == 3){
                    httpson1();
                    httpson2();
                    httpson3();
                }else if (zirenwuNum == 4){
                    httpson1();
                    httpson2();
                    httpson3();
                    httpson4();
                }else if (zirenwuNum == 5){
                    httpson1();
                    httpson2();
                    httpson3();
                    httpson4();
                    httpson5();
                }else if (zirenwuNum == 6){
                    httpson1();
                    httpson2();
                    httpson3();
                    httpson4();
                    httpson5();
                    httpson6();
                }else if (zirenwuNum == 7){
                    httpson1();
                    httpson2();
                    httpson3();
                    httpson4();
                    httpson5();
                    httpson6();
                    httpson7();
                }else if (zirenwuNum == 8){
                    httpson1();
                    httpson2();
                    httpson3();
                    httpson4();
                    httpson5();
                    httpson6();
                    httpson7();
                    httpson8();
                }else if (zirenwuNum == 9){
                    httpson1();
                    httpson2();
                    httpson3();
                    httpson4();
                    httpson5();
                    httpson6();
                    httpson7();
                    httpson8();
                    httpson9();
                }else if (zirenwuNum == 10){
                    httpson1();
                    httpson2();
                    httpson3();
                    httpson4();
                    httpson5();
                    httpson6();
                    httpson7();
                    httpson8();
                    httpson9();
                    httpson10();


                }else if (childcount == 1){
                    httpsonNo1();
                }else if (childcount == 2){
                    httpsonNo1();
                    httpsonNo2();
                }else if (childcount == 3){
                    httpsonNo1();
                    httpsonNo2();
                    httpsonNo3();
                }else if (childcount ==4){
                    httpsonNo1();
                    httpsonNo2();
                    httpsonNo3();
                    httpsonNo4();
                }else if (childcount == 5){
                    httpsonNo1();
                    httpsonNo2();
                    httpsonNo3();
                    httpsonNo4();
                    httpsonNo5();
                }else if (childcount == 6){
                    httpsonNo1();
                    httpsonNo2();
                    httpsonNo3();
                    httpsonNo4();
                    httpsonNo5();
                    httpsonNo6();
                }else if (childcount == 7){
                    httpsonNo1();
                    httpsonNo2();
                    httpsonNo3();
                    httpsonNo4();
                    httpsonNo5();
                    httpsonNo6();
                    httpsonNo7();
                }else if (childcount == 8){
                    httpsonNo1();
                    httpsonNo2();
                    httpsonNo3();
                    httpsonNo4();
                    httpsonNo5();
                    httpsonNo6();
                    httpsonNo7();
                    httpsonNo8();
                }else if (childcount == 9){
                    httpsonNo1();
                    httpsonNo2();
                    httpsonNo3();
                    httpsonNo4();
                    httpsonNo5();
                    httpsonNo6();
                    httpsonNo7();
                    httpsonNo8();
                    httpsonNo9();
                }else if (childcount == 10){
                    httpsonNo1();
                    httpsonNo2();
                    httpsonNo3();
                    httpsonNo4();
                    httpsonNo5();
                    httpsonNo6();
                    httpsonNo7();
                    httpsonNo8();
                    httpsonNo9();
                    httpsonNo10();
                }

                SharedPreferences.Editor editor = SharedPreferencesUtil.preferences.edit();
                editor.remove("Sonchange1");
                editor.remove("SonchangeProgress1");
                editor.remove("Sonchange2");
                editor.remove("SonchangeProgress2");
                editor.remove("Sonchange3");
                editor.remove("SonchangeProgress3");
                editor.remove("Sonchange4");
                editor.remove("SonchangeProgress4");
                editor.remove("Sonchange5");
                editor.remove("SonchangeProgress5");
                editor.remove("Sonchange66");
                editor.remove("Sonchange77");
                editor.remove("Sonchange88");
                editor.remove("Sonchange99");
                editor.remove("Sonchange110");

                editor.remove("Sonchange6");
                editor.remove("SonchangeProgress6");
                editor.remove("Sonchange8");
                editor.remove("SonchangeProgress8");
                editor.remove("Sonchange9");
                editor.remove("SonchangeProgress9");
                editor.remove("Sonchange10");
                editor.remove("SonchangeProgress10");
                editor.remove("Sonchange11");
                editor.remove("SonchangeProgress11");
                editor.remove("Sonchange12");
                editor.remove("Sonchange13");
                editor.remove("Sonchange14");
                editor.remove("Sonchange15");
                editor.remove("Sonchange16");

                editor.remove("Filename1");
                editor.remove("Filename2");
                editor.remove("Filename3");
                editor.remove("Filename4");
                editor.remove("Filename5");
                editor.remove("Filename6");
                editor.remove("Filename7");
                editor.remove("Filename8");
                editor.remove("Filename9");
                editor.remove("Filename10");

                editor.remove("Url1");
                editor.remove("Url2");
                editor.remove("Url3");
                editor.remove("Url4");
                editor.remove("Url5");
                editor.remove("Url6");
                editor.remove("Url7");
                editor.remove("Url8");
                editor.remove("Url9");
                editor.remove("Url10");
                editor.remove("fjnum");
                editor.commit();
                push_renwu();
            }
            private void httpson1() {

                if (!SharedPreferencesUtil.readSonchange6(Activity_Deatail.this).equals("")){
                    taskcontent =SharedPreferencesUtil.readSonchange6(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd1;
                }
                userid2 = useridd1;
                y_endtime = wantimeadd1;
                tasktype = tasktype1;
                taskcycle = taskcycle1;
                cycletype = addzhouqi1;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务标准
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu1.size()>0){
                                            for (int i = 0; i < fujianshu1.size(); i++) {
                                                httpfujianson(fujianshu1.get(i),fjtaskid);
                                            }
                                        }


    //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpsonNo1() {

                if (!SharedPreferencesUtil.readSonchange1(Activity_Deatail.this).equals("")){
                    taskcontent1 =SharedPreferencesUtil.readSonchange1(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent1+"---1");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("taskid",taskid1)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent1)//任务标准
                                .params("y_endtime",wantime1)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpson2() {

                if (!SharedPreferencesUtil.readSonchange8(Activity_Deatail.this).equals("")){
                    taskcontent = SharedPreferencesUtil.readSonchange8(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd2;
                }
                userid2 = useridd2;
                y_endtime = wantimeadd2;
                tasktype = tasktype2;
                taskcycle = taskcycle2;
                cycletype = addzhouqi2;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu2.size()>0){
                                            for (int i = 0; i < fujianshu2.size(); i++) {
                                                httpfujianson(fujianshu2.get(i),fjtaskid);
                                            }
                                        }

    //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpsonNo2() {

                if (!SharedPreferencesUtil.readSonchange2(Activity_Deatail.this).equals("")){
                    taskcontent2 = SharedPreferencesUtil.readSonchange2(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent2+"---2");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent2)//任务内容
                                .params("taskid",taskid2)
                                .params("y_endtime",wantime2)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            private void httpson3() {
                if (!SharedPreferencesUtil.readSonchange9(Activity_Deatail.this).equals("") ){
                    taskcontent = SharedPreferencesUtil.readSonchange9(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd3;
                }
                userid2 = useridd3;
                y_endtime = wantimeadd3;
                tasktype = tasktype3;
                taskcycle = taskcycle3;
                cycletype = addzhouqi3;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());

                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu3.size()>0){
                                            for (int i = 0; i < fujianshu3.size(); i++) {
                                                httpfujianson(fujianshu3.get(i),fjtaskid);
                                            }
                                        }

    //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpsonNo3() {
                if (!SharedPreferencesUtil.readSonchange3(Activity_Deatail.this).equals("") ){
                    taskcontent3 = SharedPreferencesUtil.readSonchange3(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent3+"---3");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent3)//任务内容
                                .params("taskid",taskid3)
                                .params("y_endtime",wantime3)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpson4() {

                if (!SharedPreferencesUtil.readSonchange10(Activity_Deatail.this).equals("")){
                    taskcontent = SharedPreferencesUtil.readSonchange10(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd4;
                }
                userid2 = useridd4;
                y_endtime = wantimeadd4;
                tasktype = tasktype4;
                taskcycle = taskcycle4;
                cycletype = addzhouqi4;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());

                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu4.size()>0){
                                            for (int i = 0; i < fujianshu4.size(); i++) {
                                                httpfujianson(fujianshu4.get(i),fjtaskid);
                                            }
                                        }

    //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpsonNo4() {

                if (!SharedPreferencesUtil.readSonchange4(Activity_Deatail.this).equals("")){
                    taskcontent4 = SharedPreferencesUtil.readSonchange4(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent4+"---4");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent4)//任务内容
                                .params("taskid",taskid4)
                                .params("y_endtime",wantime4)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpson5() {
                if (!SharedPreferencesUtil.readSonchange11(Activity_Deatail.this).equals("")){
                    taskcontent = SharedPreferencesUtil.readSonchange11(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd5;
                }
                userid2 = useridd5;
                y_endtime = wantimeadd5;
                tasktype = tasktype5;
                taskcycle = taskcycle5;
                cycletype = addzhouqi5;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu5.size()>0){
                                            for (int i = 0; i < fujianshu5.size(); i++) {
                                                httpfujianson(fujianshu5.get(i),fjtaskid);
                                            }
                                        }

    //                                LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpsonNo5() {
                if (!SharedPreferencesUtil.readSonchange5(Activity_Deatail.this).equals("")){
                    taskcontent5 = SharedPreferencesUtil.readSonchange5(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent5+"---5");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent5)//任务内容
                                .params("taskid",taskid5)
                                .params("y_endtime",wantime5)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            // LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpsonNo6() {
                if (!SharedPreferencesUtil.readSonchange66(Activity_Deatail.this).equals("")){
                    taskcontent6 = SharedPreferencesUtil.readSonchange66(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent6+"---5");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent6)//任务内容
                                .params("taskid",taskid6)
                                .params("y_endtime",wantime6)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            // LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpsonNo7() {
                if (!SharedPreferencesUtil.readSonchange77(Activity_Deatail.this).equals("")){
                    taskcontent7 = SharedPreferencesUtil.readSonchange77(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent7+"---5");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent7)//任务内容
                                .params("taskid",taskid7)
                                .params("y_endtime",wantime7)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            // LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpsonNo8() {
                if (!SharedPreferencesUtil.readSonchange88(Activity_Deatail.this).equals("")){
                    taskcontent8 = SharedPreferencesUtil.readSonchange88(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent8+"---5");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent8)//任务内容
                                .params("taskid",taskid8)
                                .params("y_endtime",wantime8)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            // LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpsonNo9() {
                if (!SharedPreferencesUtil.readSonchange99(Activity_Deatail.this).equals("")){
                    taskcontent9 = SharedPreferencesUtil.readSonchange99(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent9+"---5");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent9)//任务内容
                                .params("taskid",taskid9)
                                .params("y_endtime",wantime9)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            // LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpsonNo10() {
                if (!SharedPreferencesUtil.readSonchange110(Activity_Deatail.this).equals("")){
                    taskcontent10 = SharedPreferencesUtil.readSonchange99(Activity_Deatail.this);
                    LogUtil.d("任务标准",taskcontent10+"---5");
                    try {
                        OkHttpUtils.post(Http_Api.URL_renwugenxin)
                                .params("cuserid",cuserid2)//创建任务人
                                .params("taskcontent",taskcontent10)//任务内容
                                .params("taskid",taskid10)
                                .params("y_endtime",wantime10)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                        if (data_uploadBack_tag.getResult().equals("1") ){
                                            LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                            // LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                            ToastUtil.showToast("子任务上传成功");

                                        }else {
                                            ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败,上报失败");

                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            private void httpson6() {
                if (!SharedPreferencesUtil.readSonchange12(Activity_Deatail.this).equals("")){
                    taskcontent = SharedPreferencesUtil.readSonchange12(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd6;
                }
                userid2 = useridd6;
                y_endtime = wantimeadd6;
                tasktype = tasktype6;
                taskcycle = taskcycle6;
                cycletype = addzhouqi6;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu6.size()>0){
                                            for (int i = 0; i < fujianshu6.size(); i++) {
                                                httpfujianson(fujianshu6.get(i),fjtaskid);
                                            }
                                        }

                                        //LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpson7() {
                if (!SharedPreferencesUtil.readSonchange13(Activity_Deatail.this).equals("")){
                    taskcontent = SharedPreferencesUtil.readSonchange13(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd7;
                }
                userid2 = useridd7;
                y_endtime = wantimeadd7;
                tasktype = tasktype7;
                taskcycle = taskcycle7;
                cycletype = addzhouqi7;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu7.size()>0){
                                            for (int i = 0; i < fujianshu7.size(); i++) {
                                                httpfujianson(fujianshu7.get(i),fjtaskid);
                                            }
                                        }

                                        //LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpson8() {
                if (!SharedPreferencesUtil.readSonchange14(Activity_Deatail.this).equals("")){
                    taskcontent = SharedPreferencesUtil.readSonchange14(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd8;
                }
                userid2 = useridd8;
                y_endtime = wantimeadd8;
                tasktype = tasktype8;
                taskcycle = taskcycle8;
                cycletype = addzhouqi8;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu8.size()>0){
                                            for (int i = 0; i < fujianshu8.size(); i++) {
                                                httpfujianson(fujianshu8.get(i),fjtaskid);
                                            }
                                        }

                                        //LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpson9() {
                if (!SharedPreferencesUtil.readSonchange15(Activity_Deatail.this).equals("")){
                    taskcontent = SharedPreferencesUtil.readSonchange15(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd9;
                }
                userid2 = useridd9;
                y_endtime = wantimeadd9;
                tasktype = tasktype9;
                taskcycle = taskcycle9;
                cycletype = addzhouqi9;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());

                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu9.size()>0){
                                            for (int i = 0; i < fujianshu9.size(); i++) {
                                                httpfujianson(fujianshu9.get(i),fjtaskid);
                                            }
                                        }

                                        // LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void httpson10() {
                if (!SharedPreferencesUtil.readSonchange16(Activity_Deatail.this).equals("")){
                    taskcontent = SharedPreferencesUtil.readSonchange16(Activity_Deatail.this);
                }else {
                    taskcontent = miaoshuadd10;
                }
                userid2 = useridd10;
                y_endtime = wantimeadd10;
                tasktype = tasktype10;
                taskcycle = taskcycle10;
                cycletype = addzhouqi10;
                try {
                    OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                            .params("cuserid",cuserid2)//创建任务人
                            .params("taskname",taskname2)//任务名称
                            .params("taskcontent",taskcontent)//任务内容
                            .params("userids",userid2)//任务接收人：id1;id2，ID以分号隔开
                            .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                            .params("ptaskid",ptaskid)//拆分任务父id
                            .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                            .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                            .params("taskcycle",taskcycle)//长期任务循环周期
                            .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (data_uploadBack_tag.getResult().equals("1") ){
                                        LogUtil.d("子任务上传返回结果",data_uploadBack_tag.getResult());
                                        String fjtaskid = data_uploadBack_tag.getTaskid();
                                        if (fujianshu10.size()>0){
                                            for (int i = 0; i < fujianshu10.size(); i++) {
                                                httpfujianson(fujianshu10.get(i),fjtaskid);
                                            }
                                        }

                                        // LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                        ToastUtil.showToast("子任务上传成功");

                                    }else {
                                        ToastUtil.showToast(data_uploadBack_tag.getFailcode()+"子任务上传失败-头皮发麻");
                                    }

                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("联网失败,上报失败");

                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

    }

    private void httpfujianson(String url,String id) {
        File file = new File(url);
        if (!file.exists()){
            ToastUtil.showToast("文件不存在");
        }
        try {
            OkHttpUtils.post(Http_Api.URL_Fujian_upload)
                    .params("userid",userid)
                    .params("taskid",id)
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
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            setPos();
//        }
//    }
//
//    private void setPosWay1() {
//        progesssValue.post(new Runnable() {
//            @Override
//            public void run() {
//                setPos2();
//            }
//        });
//    }

//    /**
//     * 设置进度显示在对应的位置
//     */
//    public void setPos() {
//        int w = getWindowManager().getDefaultDisplay().getWidth();
////        Log.e("w=====", "" + w);
//        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) progesssValue.getLayoutParams();
//        int pro = progesss.getProgress();
//        int tW = progesssValue.getWidth();
//        if (w * pro / 100 + tW * 0.3 > w) {
//            params.leftMargin = (int) (w - tW * 1.1);
//        } else if (w * pro / 100 < tW * 0.7) {
//            params.leftMargin = 0;
//        } else {
//            params.leftMargin = (int) (w * pro / 100 - tW * 0.7);
//        }
//        progesssValue.setLayoutParams(params);
//        progesssValue.setText(new StringBuffer().append(progesss.getProgress()).append("%"));
//    }
//
//    /**
//     * 设置进度显示在对应的位置
//     */
//    public void setPos2() {
//        int w = getWindowManager().getDefaultDisplay().getWidth();
////        Log.e("w=====", "" + w);
//        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) progesssValue.getLayoutParams();
//        int pro = progesss.getProgress();
//        int tW = progesssValue.getWidth();
//        if (w * pro / 100 + tW * 0.3 > w) {
//            params.leftMargin = (int) (w - tW * 1.1);
//        } else if (w * pro / 100 < tW * 0.7) {
//            params.leftMargin = 0;
//        } else {
//            params.leftMargin = (int) (w * pro / 100 - tW * 0.7);
//        }
//        progesssValue.setLayoutParams(params);
//
//    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent2 messageEvent){

        String hehe = messageEvent.getMessage();
        LogUtil.d("取到子任务个数是---",hehe+"");
        AddMore();
    }
    private List<String> fujianshu1 = new ArrayList<>();
    private List<String> fujianshu2 = new ArrayList<>();
    private List<String> fujianshu3 = new ArrayList<>();
    private List<String> fujianshu4= new ArrayList<>();
    private List<String> fujianshu5= new ArrayList<>();
    private List<String> fujianshu6= new ArrayList<>();
    private List<String> fujianshu7= new ArrayList<>();
    private List<String> fujianshu8= new ArrayList<>();
    private List<String> fujianshu9= new ArrayList<>();
    private List<String> fujianshu10= new ArrayList<>();

    public void AddMore() {
        childnum = SharedPreferencesUtil.readZirenwuNum(Activity_Deatail.this);
        LogUtil.d("子任务个数---",childnum+"");
        if (childnum == 1){
            fujiannum1 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fujianUrl1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fujianUrl2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fujianUrl3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fujianUrl4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fujianUrl5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fujianUrl6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fujianUrl7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fujianUrl8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fujianUrl9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fujianUrl10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);

            if (!fujianUrl1.equals("")){
                fujianshu1.add(fujianUrl1);
            }if (!fujianUrl2.equals("")){
                fujianshu1.add(fujianUrl2);
            }if (!fujianUrl3.equals("")){
                fujianshu1.add(fujianUrl3);
            }if (!fujianUrl4.equals("")){
                fujianshu1.add(fujianUrl4);
            }if (!fujianUrl5.equals("")){
                fujianshu1.add(fujianUrl5);
            }if (!fujianUrl6.equals("")){
                fujianshu1.add(fujianUrl6);
            }if (!fujianUrl7.equals("")){
                fujianshu1.add(fujianUrl7);
            }if (!fujianUrl8.equals("")){
                fujianshu1.add(fujianUrl8);
            }if (!fujianUrl9.equals("")){
                fujianshu1.add(fujianUrl9);
            }if (!fujianUrl10.equals("")){
                fujianshu1.add(fujianUrl10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addzhouqi1 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            useridd1 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype1 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle1 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu11.setVisibility(View.VISIBLE);
            name11.setText(addname);

            zerenrenameadd1 = addname;
            wantimeadd1 = adddata;
            miaoshuadd1 = addmiaoshu;

            if (addzhouqi1.equals("0")){
                baozhouqiadd1 = "单次";
            }else if (addzhouqi1.equals("1")){
                baozhouqiadd1 = "日报";
            }else if (addzhouqi1.equals("2")){
                baozhouqiadd1 = "周报";
            }else if (addzhouqi1.equals("3")){
                baozhouqiadd1 = "月报";
            }

            zirenwu11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu6.class);
                    intent.putExtra("taskid1",taskid);
                    intent.putExtra("zerenrename1",zerenrenameadd1);
                    intent.putExtra("wantime1",wantimeadd1);
                    intent.putExtra("baozhouqi1",baozhouqiadd1);
                    intent.putExtra("miaoshu1",miaoshuadd1);
                    LogUtil.d("任务描述====",miaoshuadd1+"===");
                    startActivity(intent);
                }
            });
        }
        if (childnum == 2){
            fujiannum2 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fujianU1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fujianU2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fujianU3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fujianU4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fujianU5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fujianU6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fujianU7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fujianU8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fujianU9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fujianU10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);

            if (!fujianU1.equals("")){
                fujianshu2.add(fujianU1);
            }if (!fujianU2.equals("")){
                fujianshu2.add(fujianU2);
            }if (!fujianU3.equals("")){
                fujianshu2.add(fujianU3);
            }if (!fujianU4.equals("")){
                fujianshu2.add(fujianU4);
            }if (!fujianU5.equals("")){
                fujianshu2.add(fujianU5);
            }if (!fujianU6.equals("")){
                fujianshu2.add(fujianU6);
            }if (!fujianU7.equals("")){
                fujianshu2.add(fujianU7);
            }if (!fujianU8.equals("")){
                fujianshu2.add(fujianU8);
            }if (!fujianU9.equals("")){
                fujianshu2.add(fujianU9);
            }if (!fujianU10.equals("")){
                fujianshu2.add(fujianU10);
            }

            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            addzhouqi2 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            useridd2 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype2 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle2 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu12.setVisibility(View.VISIBLE);
            name12.setText(addname);

            zerenrenameadd2 = addname;
            wantimeadd2 = adddata;
            miaoshuadd2 = addmiaoshu;
            baozhouqiadd2 = addzhouqi;

            if (addzhouqi2.equals("0")){
                baozhouqiadd2 = "单次";
            }else if (addzhouqi2.equals("1")){
                baozhouqiadd2 = "日报";
            }else if (addzhouqi2.equals("2")){
                baozhouqiadd2 = "周报";
            }else if (addzhouqi2.equals("3")){
                baozhouqiadd2 = "月报";
            }
            zirenwu12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu8.class);
                    intent.putExtra("taskid2",taskid);
                    intent.putExtra("zerenrename2",zerenrenameadd2);
                    intent.putExtra("wantime2",wantimeadd2);
                    intent.putExtra("baozhouqi2",baozhouqiadd2);
                    intent.putExtra("miaoshu2",miaoshuadd2);
                    startActivity(intent);
                }
            });
        }
        if (childnum ==3){
            fujiannum3 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fujianUr1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fujianUr2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fujianUr3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fujianUr4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fujianUr5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fujianUr6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fujianUr7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fujianUr8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fujianUr9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fujianUr10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);

            if (!fujianUr1.equals("")){
                fujianshu3.add(fujianUr1);
            }if (!fujianUr2.equals("")){
                fujianshu3.add(fujianUr2);
            }if (!fujianUr3.equals("")){
                fujianshu3.add(fujianUr3);
            }if (!fujianUr4.equals("")){
                fujianshu3.add(fujianUr4);
            }if (!fujianUr5.equals("")){
                fujianshu3.add(fujianUr5);
            }if (!fujianUr6.equals("")){
                fujianshu3.add(fujianUr6);
            }if (!fujianUr7.equals("")){
                fujianshu3.add(fujianUr7);
            }if (!fujianUr8.equals("")){
                fujianshu3.add(fujianUr8);
            }if (!fujianUr9.equals("")){
                fujianshu3.add(fujianUr9);
            }if (!fujianUr10.equals("")){
                fujianshu3.add(fujianUr10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addzhouqi3 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            useridd3 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype3 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle3 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu13.setVisibility(View.VISIBLE);
            name13.setText(addname);

            zerenrenameadd3 = addname;
            wantimeadd3 = adddata;
            miaoshuadd3 = addmiaoshu;
            baozhouqiadd3 = addzhouqi;
            if (addzhouqi3.equals("0")){
                baozhouqiadd3 = "单次";
            }else if (addzhouqi3.equals("1")){
                baozhouqiadd3 = "日报";
            }else if (addzhouqi3.equals("2")){
                baozhouqiadd3 = "周报";
            }else if (addzhouqi3.equals("3")){
                baozhouqiadd3 = "月报";
            }
            zirenwu13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu9.class);
                    intent.putExtra("taskid3",taskid);
                    intent.putExtra("zerenrename3",zerenrenameadd3);
                    intent.putExtra("wantime3",wantimeadd3);
                    intent.putExtra("baozhouqi3",baozhouqiadd3);
                    intent.putExtra("miaoshu3",miaoshuadd3);
                    startActivity(intent);
                }
            });
        }
        if (childnum==4){
            fujiannum4 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fujianr1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fujianr2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fujianr3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fujianr4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fujianr5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fujianr6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fujianr7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fujianr8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fujianr9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fujianr10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);

            if (!fujianr1.equals("")){
                fujianshu4.add(fujianr1);
            }if (!fujianr2.equals("")){
                fujianshu4.add(fujianr2);
            }if (!fujianr3.equals("")){
                fujianshu4.add(fujianr3);
            }if (!fujianr4.equals("")){
                fujianshu4.add(fujianr4);
            }if (!fujianr5.equals("")){
                fujianshu4.add(fujianr5);
            }if (!fujianr6.equals("")){
                fujianshu4.add(fujianr6);
            }if (!fujianr7.equals("")){
                fujianshu4.add(fujianr7);
            }if (!fujianr8.equals("")){
                fujianshu4.add(fujianr8);
            }if (!fujianr9.equals("")){
                fujianshu4.add(fujianr9);
            }if (!fujianr10.equals("")){
                fujianshu4.add(fujianr10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addzhouqi4 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            useridd4 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype4 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle4 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu14.setVisibility(View.VISIBLE);
            name14.setText(addname);

            zerenrenameadd4 = addname;
            wantimeadd4 = adddata;
            miaoshuadd4 = addmiaoshu;
            baozhouqiadd4 = addzhouqi;

            if (addzhouqi4.equals("0")){
                baozhouqiadd4 = "单次";
            }else if (addzhouqi4.equals("1")){
                baozhouqiadd4 = "日报";
            }else if (addzhouqi4.equals("2")){
                baozhouqiadd4 = "周报";
            }else if (addzhouqi4.equals("3")){
                baozhouqiadd4 = "月报";
            }
            zirenwu14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu10.class);
                    intent.putExtra("taskid4",taskid);
                    intent.putExtra("zerenrename4",zerenrenameadd4);
                    intent.putExtra("wantime4",wantimeadd4);
                    intent.putExtra("baozhouqi4",baozhouqiadd4);
                    intent.putExtra("miaoshu4",miaoshuadd4);
                    startActivity(intent);
                }
            });
        }
        if (childnum==5){
            fujiannum5 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fujianl1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fujianl2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fujianl3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fujianl4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fujianl5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fujianl6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fujianl7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fujianl8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fujianl9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fujianl10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);


            if (!fujianl1.equals("")){
                fujianshu5.add(fujianl1);
            }if (!fujianl2.equals("")){
                fujianshu5.add(fujianl2);
            }if (!fujianl3.equals("")){
                fujianshu5.add(fujianl3);
            }if (!fujianl4.equals("")){
                fujianshu5.add(fujianl4);
            }if (!fujianl5.equals("")){
                fujianshu5.add(fujianl5);
            }if (!fujianl6.equals("")){
                fujianshu5.add(fujianl6);
            }if (!fujianl7.equals("")){
                fujianshu5.add(fujianl7);
            }if (!fujianl8.equals("")){
                fujianshu5.add(fujianl8);
            }if (!fujianl9.equals("")){
                fujianshu5.add(fujianl9);
            }if (!fujianl10.equals("")){
                fujianshu5.add(fujianl10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addzhouqi5 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            useridd5 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype5 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle5 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu15.setVisibility(View.VISIBLE);
            name15.setText(addname);

            zerenrenameadd5 = addname;
            wantimeadd5 = adddata;
            miaoshuadd5 = addmiaoshu;
            baozhouqiadd5 = addzhouqi;

            if (addzhouqi5.equals("0")){
                baozhouqiadd5 = "单次";
            }else if (addzhouqi5.equals("1")){
                baozhouqiadd5 = "日报";
            }else if (addzhouqi5.equals("2")){
                baozhouqiadd5 = "周报";
            }else if (addzhouqi5.equals("3")){
                baozhouqiadd5 = "月报";
            }
            zirenwu15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu11.class);
                    intent.putExtra("taskid5",taskid);
                    intent.putExtra("zerenrename5",zerenrenameadd5);
                    intent.putExtra("wantime5",wantimeadd5);
                    intent.putExtra("baozhouqi5",baozhouqiadd5);
                    intent.putExtra("miaoshu5",miaoshuadd5);
                    startActivity(intent);
                }
            });
        }
        if (childnum==6){
            fujiannum6 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fjur1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fjur2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fjur3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fjur4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fjur5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fjur6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fjur7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fjur8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fjur9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fjur10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);

            if (!fjur1.equals("")){
                fujianshu6.add(fjur1);
            }if (!fjur2.equals("")){
                fujianshu6.add(fjur2);
            }if (!fjur3.equals("")){
                fujianshu6.add(fjur3);
            }if (!fjur4.equals("")){
                fujianshu6.add(fjur4);
            }if (!fjur5.equals("")){
                fujianshu6.add(fjur5);
            }if (!fjur6.equals("")){
                fujianshu6.add(fjur6);
            }if (!fjur7.equals("")){
                fujianshu6.add(fjur7);
            }if (!fjur8.equals("")){
                fujianshu6.add(fjur8);
            }if (!fjur9.equals("")){
                fujianshu6.add(fjur9);
            }if (!fjur10.equals("")){
                fujianshu6.add(fjur10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            addzhouqi6 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            useridd6 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype6 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle6 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu16.setVisibility(View.VISIBLE);
            name16.setText(addname);

            zerenrenameadd6 = addname;
            wantimeadd6 = adddata;
            miaoshuadd6 = addmiaoshu;
            baozhouqiadd6 = addzhouqi;

            if (addzhouqi6.equals("0")){
                baozhouqiadd6 = "单次";
            }else if (addzhouqi6.equals("1")){
                baozhouqiadd6 = "日报";
            }else if (addzhouqi6.equals("2")){
                baozhouqiadd6 = "周报";
            }else if (addzhouqi6.equals("3")){
                baozhouqiadd6 = "月报";
            }
            zirenwu16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu12.class);
                    intent.putExtra("taskid5",taskid);
                    intent.putExtra("zerenrename6",zerenrenameadd6);
                    intent.putExtra("wantime6",wantimeadd6);
                    intent.putExtra("baozhouqi6",baozhouqiadd6);
                    intent.putExtra("miaoshu6",miaoshuadd6);
                    startActivity(intent);
                }
            });
        }

        if (childnum==7){
            fujiannum7 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fju1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fju2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fju3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fju4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fju5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fju6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fju7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fju8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fju9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fju10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);
            if (!fju1.equals("")){
                fujianshu7.add(fju1);
            }if (!fju2.equals("")){
                fujianshu7.add(fju2);
            }if (!fju3.equals("")){
                fujianshu7.add(fju3);
            }if (!fju4.equals("")){
                fujianshu7.add(fju4);
            }if (!fju5.equals("")){
                fujianshu7.add(fju5);
            }if (!fju6.equals("")){
                fujianshu7.add(fju6);
            }if (!fju7.equals("")){
                fujianshu7.add(fju7);
            }if (!fju8.equals("")){
                fujianshu7.add(fju8);
            }if (!fju9.equals("")){
                fujianshu7.add(fju9);
            }if (!fju10.equals("")){
                fujianshu7.add(fju10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            addzhouqi7 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            useridd7 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype7 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle7 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu17.setVisibility(View.VISIBLE);
            name17.setText(addname);

            zerenrenameadd7 = addname;
            wantimeadd7 = adddata;
            miaoshuadd7 = addmiaoshu;
            baozhouqiadd7 = addzhouqi;

            if (addzhouqi7.equals("0")){
                baozhouqiadd7 = "单次";
            }else if (addzhouqi7.equals("1")){
                baozhouqiadd7 = "日报";
            }else if (addzhouqi7.equals("2")){
                baozhouqiadd7 = "周报";
            }else if (addzhouqi7.equals("3")){
                baozhouqiadd7 = "月报";
            }
            zirenwu17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu13.class);
                    intent.putExtra("taskid7",taskid);
                    intent.putExtra("zerenrename7",zerenrenameadd7);
                    intent.putExtra("wantime7",wantimeadd7);
                    intent.putExtra("baozhouqi7",baozhouqiadd7);
                    intent.putExtra("miaoshu7",miaoshuadd7);
                    startActivity(intent);
                }
            });
        }
        if (childnum==8){
            fujiannum8 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fjru1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fjru2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fjru3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fjru4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fjru5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fjru6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fjru7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fjru8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fjru9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fjru10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);
            if (!fjru1.equals("")){
                fujianshu8.add(fjru1);
            }if (!fjru2.equals("")){
                fujianshu8.add(fjru2);
            }if (!fjru3.equals("")){
                fujianshu8.add(fjru3);
            }if (!fjru4.equals("")){
                fujianshu8.add(fjru4);
            }if (!fjru5.equals("")){
                fujianshu8.add(fjru5);
            }if (!fjru6.equals("")){
                fujianshu8.add(fjru6);
            }if (!fjru7.equals("")){
                fujianshu8.add(fjru7);
            }if (!fjru8.equals("")){
                fujianshu8.add(fjru8);
            }if (!fjru9.equals("")){
                fujianshu8.add(fjru9);
            }if (!fjru10.equals("")){
                fujianshu8.add(fjru10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            addzhouqi8 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            useridd8 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype8 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle8 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu18.setVisibility(View.VISIBLE);
            name18.setText(addname);

            zerenrenameadd8 = addname;
            wantimeadd8 = adddata;
            miaoshuadd8 = addmiaoshu;
            baozhouqiadd8 = addzhouqi;

            if (addzhouqi8.equals("0")){
                baozhouqiadd8 = "单次";
            }else if (addzhouqi8.equals("1")){
                baozhouqiadd8 = "日报";
            }else if (addzhouqi8.equals("2")){
                baozhouqiadd8 = "周报";
            }else if (addzhouqi8.equals("3")){
                baozhouqiadd8 = "月报";
            }
            zirenwu18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu14.class);
                    intent.putExtra("taskid8",taskid);
                    intent.putExtra("zerenrename8",zerenrenameadd8);
                    intent.putExtra("wantime8",wantimeadd8);
                    intent.putExtra("baozhouqi8",baozhouqiadd8);
                    intent.putExtra("miaoshu8",miaoshuadd8);
                    startActivity(intent);
                }
            });
        }
        if (childnum==9){
            fujiannum9 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fjurl1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fjurl2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fjurl3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fjurl4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fjurl5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fjurl6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fjurl7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fjurl8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fjurl9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fjurl10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);

            if (!fjurl1.equals("")){
                fujianshu9.add(fjurl1);
            }if (!fjurl2.equals("")){
                fujianshu9.add(fjurl2);
            }if (!fjurl3.equals("")){
                fujianshu9.add(fjurl3);
            }if (!fjurl4.equals("")){
                fujianshu9.add(fjurl4);
            }if (!fjurl5.equals("")){
                fujianshu9.add(fjurl5);
            }if (!fjurl6.equals("")){
                fujianshu9.add(fjurl6);
            }if (!fjurl7.equals("")){
                fujianshu9.add(fjurl7);
            }if (!fjurl8.equals("")){
                fujianshu9.add(fjurl8);
            }if (!fjurl9.equals("")){
                fujianshu9.add(fjurl9);
            }if (!fjurl10.equals("")){
                fujianshu9.add(fjurl10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            addzhouqi9 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            useridd9 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype9 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle9 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu19.setVisibility(View.VISIBLE);
            name19.setText(addname);

            zerenrenameadd9 = addname;
            wantimeadd9 = adddata;
            miaoshuadd9 = addmiaoshu;
            baozhouqiadd9 = addzhouqi;

            if (addzhouqi9.equals("0")){
                baozhouqiadd9 = "单次";
            }else if (addzhouqi9.equals("1")){
                baozhouqiadd9 = "日报";
            }else if (addzhouqi9.equals("2")){
                baozhouqiadd9 = "周报";
            }else if (addzhouqi9.equals("3")){
                baozhouqiadd9 = "月报";
            }
            zirenwu19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu15.class);
                    intent.putExtra("taskid9",taskid);
                    intent.putExtra("zerenrename9",zerenrenameadd9);
                    intent.putExtra("wantime9",wantimeadd9);
                    intent.putExtra("baozhouqi9",baozhouqiadd9);
                    intent.putExtra("miaoshu9",miaoshuadd9);
                    startActivity(intent);
                }
            });
        }

        if (childnum==10){
            fujiannum10 = SharedPreferencesUtil.readfjnum(Activity_Deatail.this);

            fjulu1 = SharedPreferencesUtil.readUrl1(Activity_Deatail.this);
            fjulu2 = SharedPreferencesUtil.readUrl2(Activity_Deatail.this);
            fjulu3 = SharedPreferencesUtil.readUrl3(Activity_Deatail.this);
            fjulu4 = SharedPreferencesUtil.readUrl4(Activity_Deatail.this);
            fjulu5 = SharedPreferencesUtil.readUrl5(Activity_Deatail.this);
            fjulu6 = SharedPreferencesUtil.readUrl6(Activity_Deatail.this);
            fjulu7 = SharedPreferencesUtil.readUrl7(Activity_Deatail.this);
            fjulu8 = SharedPreferencesUtil.readUrl8(Activity_Deatail.this);
            fjulu9 = SharedPreferencesUtil.readUrl9(Activity_Deatail.this);
            fjulu10 = SharedPreferencesUtil.readUrl10(Activity_Deatail.this);

            if (!fjulu1.equals("")){
                fujianshu10.add(fjulu1);
            }if (!fjulu2.equals("")){
                fujianshu10.add(fjulu2);
            }if (!fjulu3.equals("")){
                fujianshu10.add(fjulu3);
            }if (!fjulu4.equals("")){
                fujianshu10.add(fjulu4);
            }if (!fjulu5.equals("")){
                fujianshu10.add(fjulu5);
            }if (!fjulu6.equals("")){
                fujianshu10.add(fjulu6);
            }if (!fjulu7.equals("")){
                fujianshu10.add(fjulu7);
            }if (!fjulu8.equals("")){
                fujianshu10.add(fjulu8);
            }if (!fjulu9.equals("")){
                fujianshu10.add(fjulu9);
            }if (!fjulu10.equals("")){
                fujianshu10.add(fjulu10);
            }
            addname = SharedPreferencesUtil.readZrenren(Activity_Deatail.this);
            adddata = SharedPreferencesUtil.readRiqi(Activity_Deatail.this);
            addmiaoshu = SharedPreferencesUtil.readBiaozhun(Activity_Deatail.this);
            addzhouqi10 = SharedPreferencesUtil.readZhouqi(Activity_Deatail.this);
            useridd10 = SharedPreferencesUtil.readAdd_SonUserid(Activity_Deatail.this);
            tasktype10 = SharedPreferencesUtil.readTasktype(Activity_Deatail.this);
            taskcycle10 = SharedPreferencesUtil.readTaskcycle(Activity_Deatail.this);

            zirenwu20.setVisibility(View.VISIBLE);
            name20.setText(addname);

            zerenrenameadd10 = addname;
            wantimeadd10 = adddata;
            miaoshuadd10 = addmiaoshu;
            baozhouqiadd10 = addzhouqi;

            if (addzhouqi10.equals("0")){
                baozhouqiadd10 = "单次";
            }else if (addzhouqi10.equals("1")){
                baozhouqiadd10 = "日报";
            }else if (addzhouqi10.equals("2")){
                baozhouqiadd10 = "周报";
            }else if (addzhouqi10.equals("3")){
                baozhouqiadd10 = "月报";
            }
            zirenwu20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_Deatail.this,Activity_zirenwu16.class);
                    intent.putExtra("taskid10",taskid);
                    intent.putExtra("zerenrename10",zerenrenameadd10);
                    intent.putExtra("wantime10",wantimeadd10);
                    intent.putExtra("baozhouqi10",baozhouqiadd10);
                    intent.putExtra("miaoshu10",miaoshuadd10);
                    startActivity(intent);
                }
            });
        }
    }

    public void push_renwu(){

//        progressveall = progesss.getProgress();
//        myprogress = progressveall+"";
        if (pree>proooo){//代表滑动了
            myprogress = pree+"";
        }else {
            myprogress = proooo+"";
        }
        LogUtil.d("上报进度---",pree+"");
        LogUtil.d("任务描述",renwumiaoshu2+"");
        if (myprogress.isEmpty()&&renwumiaoshu2.isEmpty()){
            ToastUtil.showToast("进度/描述不能为空");
            return;
        }
        OkHttpUtils.get(Http_Api.URL_renwushangbao)
                .params("userid",userid)
                .params("taskid",taskid)
                .params("progress",myprogress)
                .params("content",renwumiaoshu2)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

//                            "result":"1",”failcode”:””
          Data_fileupback data_uploadBack_tag =  JsonUtil.parseJsonToBean(s,Data_fileupback.class);
                        if (data_uploadBack_tag.getResult().equals( "1")){
                            LogUtil.d("上报返回结果",data_uploadBack_tag.getResult());
                            String ass = data_uploadBack_tag.getAssid();
                            if (fileList.size()>0){
                                for (int i = 0; i < fileList.size(); i++) {
                                    httpfileuup(fileList.get(i),ass);
                                }
                            }

                            ToastUtil.showToast( "父任务上报上传成功");
                                EventBus.getDefault().post(new MessageEvent4("flash"));
                            finish();
                        }else {
                            ToastUtil.showToast(data_uploadBack_tag.getResult()+"父任务上传失败-头皮发麻");
                        }

                            SharedPreferences.Editor editor = SharedPreferencesUtil.preferences.edit();
                            editor.remove("addZerenren");
                            editor.remove("Zhouqi");
                            editor.remove("Riqi");
                            editor.remove("Biaozhun");
                            editor.remove("Add_SonUserid");
                            editor.remove("ZirenwuNum");
                            editor.commit();

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);

                        ToastUtil.showToast("联网失败");
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
            String url = FileUtils2.getPath(Activity_Deatail.this,uri);
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
    private List<File> fileList = new ArrayList<>();
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
            fileList.add(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void httpfileuup(File file,String assid){

        try {
            OkHttpUtils.post(Http_Api.URL_Fujian_upload)
                    .params("userid",userid)
                    .params("taskid",taskid)
                    .params("assid",assid)
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
            fujianname11.setText(m);
        }
        if (o == 2){
            fujian12.setVisibility(View.VISIBLE);
            fujianname12.setText(m);
        }
        if (o == 3){
            fujian13.setVisibility(View.VISIBLE);
            fujianname13.setText(m);
        }
        if (o == 4){
            fujian14.setVisibility(View.VISIBLE);
            fujianname14.setText(m);
        }
        if (o ==5){
            fujian15.setVisibility(View.VISIBLE);
            fujianname15.setText(m);
        }
        if (o ==6){
            fujian16.setVisibility(View.VISIBLE);
            fujianname16.setText(m);
        }
        if (o ==7){
            fujian17.setVisibility(View.VISIBLE);
            fujianname17.setText(m);
        }
        if (o ==8){
            fujian18.setVisibility(View.VISIBLE);
            fujianname18.setText(m);
        }
        if (o == 9){
            fujian19.setVisibility(View.VISIBLE);
            fujianname19.setText(m);
        }
        if (o >= 10){
            fujian20.setVisibility(View.VISIBLE);
            fujianname20.setText(m);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){

            SharedPreferences.Editor editor = SharedPreferencesUtil.preferences.edit();
            editor.remove("Sonchange1");
            editor.remove("SonchangeProgress1");
            editor.remove("Sonchange2");
            editor.remove("SonchangeProgress2");
            editor.remove("Sonchange3");
            editor.remove("SonchangeProgress3");
            editor.remove("Sonchange4");
            editor.remove("SonchangeProgress4");
            editor.remove("Sonchange5");
            editor.remove("SonchangeProgress5");
            editor.remove("Sonchange6");
            editor.remove("SonchangeProgress6");
            editor.remove("Sonchange8");
            editor.remove("SonchangeProgress8");
            editor.remove("Sonchange9");
            editor.remove("SonchangeProgress9");
            editor.remove("Sonchange10");
            editor.remove("SonchangeProgress10");
            editor.remove("Sonchange11");
            editor.remove("SonchangeProgress11");

            editor.remove("addZerenren");
            editor.remove("Zhouqi");
            editor.remove("Riqi");
            editor.remove("Biaozhun");
            editor.remove("Add_SonUserid");
            editor.remove("ZirenwuNum");

            editor.remove("Filename1");
            editor.remove("Filename2");
            editor.remove("Filename3");
            editor.remove("Filename4");
            editor.remove("Filename5");
            editor.remove("Filename6");
            editor.remove("Filename7");
            editor.remove("Filename8");
            editor.remove("Filename9");
            editor.remove("Filename10");

            editor.remove("Url1");
            editor.remove("Url2");
            editor.remove("Url3");
            editor.remove("Url4");
            editor.remove("Url5");
            editor.remove("Url6");
            editor.remove("Url7");
            editor.remove("Url8");
            editor.remove("Url9");
            editor.remove("Url10");
            editor.remove("fjnum");

            editor.remove("ZirenwuNum");
            editor.commit();

            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_deatil;
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {


        //触摸的是EditText并且当前EditText可以滚动则将事件交给EditText处理；否则将事件交由其父类处理
        if ((view.getId() == R.id.renwumiaoshu &&canVerticalScroll(renwumiaoshu))) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (event.getAction() == MotionEvent.ACTION_UP) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }



    /**
     * EditText竖直方向是否可以滚动
     * @param editText  需要判断的EditText
     * @return  true：可以滚动   false：不可以滚动
     */
    private boolean canVerticalScroll(EditText editText) {
        //滚动的距离
        int scrollY = editText.getScrollY();
        //控件内容的总高度
        int scrollRange = editText.getLayout().getHeight();
        //控件实际显示的高度
        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() -editText.getCompoundPaddingBottom();
        //控件内容总高度与实际显示高度的差值
        int scrollDifference = scrollRange - scrollExtent;

        if(scrollDifference == 0) {
            return false;
        }

        return (scrollY > 0) || (scrollY < scrollDifference - 1);
    }
    /**
     "stateUnspecified" 软键盘的状态(是否它是隐藏或可见)没有被指定。系统将选择一个合适的状态或依赖于主题的设置。
     这个是为了软件盘行为默认的设置。

     "stateUnchanged" 软键盘被保持无论它上次是什么状态，是否可见或隐藏，当主窗口出现在前面时。

     "stateHidden" 当用户选择该Activity时，软键盘被隐藏——也就是，当用户确定导航到该Activity时，
     而不是返回到它由于离开另一个Activity。

     "stateAlwaysHidden" 软键盘总是被隐藏的，当该Activity主窗口获取焦点时。

     "stateVisible" 软键盘是可见的，当那个是正常合适的时(当用户导航到Activity主窗口时)。

     "stateAlwaysVisible" 当用户选择这个Activity时，软键盘是可见的——也就是，也就是，当用户确定导航到该Activity时，
     而不是返回到它由于离开另一个Activity。

     "adjustUnspecified" 它不被指定是否该Activity主窗口调整大小以便留出软键盘的空间，
     或是否窗口上的内容得到屏幕上当前的焦点是可见的。系统将自动选择这些模式中一种主要依赖于是否窗口的内容有任何
     布局视图能够滚动他们的内容。如果有这样的一个视图，这个窗口将调整大小，这样的假设可以使滚动窗口的内容在
     一个较小的区域中可见的。这个是主窗口默认的行为设置。

     "adjustResize" 该Activity主窗口总是被调整屏幕的大小以便留出软键盘的空间。

     "adjustPan" 该Activity主窗口并不调整屏幕的大小以便留出软键盘的空间。
     相反，当前窗口的内容将自动移动以便当前焦点从不被键盘覆盖和用户能总是看到输入内容的部分。
     这个通常是不期望比调整大小，因为用户可能关闭软键盘以便获得与被覆盖内容的交互操作。 */
}
