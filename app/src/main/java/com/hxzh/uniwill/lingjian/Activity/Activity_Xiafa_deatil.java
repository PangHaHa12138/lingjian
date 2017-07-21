package com.hxzh.uniwill.lingjian.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdapter6;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunrenwu_xiaoxiliebiao;
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

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/4/14.
 *  下发详情页
 */
public class Activity_Xiafa_deatil extends BaseToobarRightViewActivity {

    private RelativeLayout renwming_layout;
    private RelativeLayout wancriqi_layout;
    private RelativeLayout shangbzqi_layout;
    private RelativeLayout shijiriqi_layout;
    private TextView renwuming_text;
    private TextView wanchqi_text,realfinshdata;
    private TextView shangbzqi_text;
    private EditText renwmiaosu_text;
//    private LinearLayout listviewHeader;
    private View listviewHeader,yincang;

    private SwipeMenuListView swipeMenuListView ;

    private Data_huoqurenwuxiangqing.ListBean data1;
    private List<Data_huoqurenwuxiangqing.ListBean> list1;

    private List<Data_huoqurenwuxiangqing.ChildsBean> list2;//集合数据
    private Data_huoqurenwuxiangqing.ChildsBean data2;//集合对象

    private List<Data_huoqurenwuxiangqing.ListAccBean> listacc;
    private Data_huoqurenwuxiangqing.ChileListBean data3;
    private List<Data_huoqurenwuxiangqing.ChileListBean> list3;

    private Data_huoqurenwuxiangqing renwuxiangqing;

    private Data_chaxunrenwu_xiaoxiliebiao xiaoxiliebiao;

    private List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> msglist;

    private String taskid,userid,cycle,taskname,content,yettime,sendtime;
    private String userid_son,cusied_son,taskid_son,taskid2,userid2;
    private RelativeLayout add_fujian;
    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,fujian10,xiugai,
    fujian11,fujian12,fujian13,fujian14,fujian15,fujian16,fujian17,fujian18,fujian19,fujian20;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10,fujianname11,fujianname12,fujianname13,fujianname14,fujianname15,
            fujianname16,fujianname17,fujianname18,fujianname19,fujianname20;
    private int header, positiom;
    private List<String> zi;
    private TextView buttext;
    private TextView biaozhuntext;
    private TextView changetext;
    private ImageView changarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("下发任务");

        initView();
        initData();
        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getToobarRedView().setVisibility(View.INVISIBLE);
                Intent intent = new Intent(Activity_Xiafa_deatil.this,Activity_Chat.class);
                intent.putExtra("taskidchat",taskid);
                startActivity(intent);
            }
        });
        onclick();

    }

    private void initView() {

        swipeMenuListView = (SwipeMenuListView) findViewById(R.id.xiafa_listview);
        //头布局
//        listviewHeader = View.inflate(Activity_Xiafa_deatil.this,R.layout.activity_xiafa_deatil_header,null);
        listviewHeader =  LayoutInflater.from(Activity_Xiafa_deatil.this).inflate(R.layout.activity_xiafa_deatil_header,swipeMenuListView,false);
        renwming_layout = (RelativeLayout)listviewHeader.findViewById(R.id.renwu_ming_layout66);
        wancriqi_layout = (RelativeLayout) listviewHeader.findViewById(R.id.wanchengriqi_layout66);
        shangbzqi_layout = (RelativeLayout) listviewHeader.findViewById(R.id.shangbaozhouqi_layout66);
        shijiriqi_layout = (RelativeLayout) listviewHeader.findViewById(R.id.shijiriqi_layout66);

        renwuming_text = (TextView) listviewHeader.findViewById(R.id.deatil_renwuming66);
        wanchqi_text = (TextView) listviewHeader.findViewById(R.id.deatil_finsh_data66);
        shangbzqi_text = (TextView) listviewHeader.findViewById(R.id.deatil_shangbaozhouqi66);
        renwmiaosu_text = (EditText) listviewHeader.findViewById(R.id.renwubiaozhun66);
        realfinshdata = (TextView) listviewHeader.findViewById(R.id.shijifinsh_data66);
        yincang = listviewHeader.findViewById(R.id.yincang);

        add_fujian = (RelativeLayout) listviewHeader. findViewById(R.id.tianjiafujian);

        fujian1 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian1);
        fujian2 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian2);
        fujian3 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian3);
        fujian4 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian4);
        fujian5 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian5);
        fujian6 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian6);
        fujian7 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian7);
        fujian8 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian8);
        fujian9 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian9);
        fujian10 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian10);
        fujian11 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian11);
        fujian12 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian12);
        fujian13 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian13);
        fujian14 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian14);
        fujian15 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian15);
        fujian16 = (RelativeLayout)listviewHeader. findViewById(R.id.fujian16);
        fujian17 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian17);
        fujian18 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian18);
        fujian19 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian19);
        fujian20 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian20);

        fujianname1 = (TextView) listviewHeader.findViewById(R.id.fujiantext1);
        fujianname2 = (TextView) listviewHeader.findViewById(R.id.fujiantext2);
        fujianname3 = (TextView) listviewHeader.findViewById(R.id.fujiantext3);
        fujianname4 = (TextView) listviewHeader.findViewById(R.id.fujiantext4);
        fujianname5 = (TextView) listviewHeader.findViewById(R.id.fujiantext5);
        fujianname6 = (TextView) listviewHeader.findViewById(R.id.fujiantext6);
        fujianname7 = (TextView) listviewHeader.findViewById(R.id.fujiantext7);
        fujianname8 = (TextView) listviewHeader.findViewById(R.id.fujiantext8);
        fujianname9 = (TextView) listviewHeader.findViewById(R.id.fujiantext9);
        fujianname10 = (TextView) listviewHeader.findViewById(R.id.fujiantext10);

        fujianname11 = (TextView) listviewHeader.findViewById(R.id.fujiantext11);
        fujianname12 = (TextView) listviewHeader.findViewById(R.id.fujiantext12);
        fujianname13 = (TextView) listviewHeader.findViewById(R.id.fujiantext13);
        fujianname14 = (TextView) listviewHeader.findViewById(R.id.fujiantext14);
        fujianname15 = (TextView) listviewHeader.findViewById(R.id.fujiantext15);
        fujianname16 = (TextView) listviewHeader.findViewById(R.id.fujiantext16);
        fujianname17 = (TextView) listviewHeader.findViewById(R.id.fujiantext17);
        fujianname18 = (TextView) listviewHeader.findViewById(R.id.fujiantext18);
        fujianname19 = (TextView) listviewHeader.findViewById(R.id.fujiantext19);
        fujianname20 = (TextView) listviewHeader.findViewById(R.id.fujiantext20);

//        listviewHeader = getLayoutInflater().inflate(R.layout.,swipeMenuListView, false);
        xiugai = (RelativeLayout) findViewById(R.id.xiugai);
        swipeMenuListView.setDividerHeight(0);//去掉分割线
        swipeMenuListView.setCacheColorHint(0);

        buttext = (TextView)findViewById(R.id.buttext);
        biaozhuntext = (TextView) listviewHeader.findViewById(R.id.biaozhuntext);
        changetext = (TextView) listviewHeader.findViewById(R.id.changetext);
        changarrow = (ImageView) listviewHeader.findViewById(R.id.changarrow);
    }

    private void initData() {
        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid3");
        LogUtil.d("拿到的taskid----->",taskid+"");
        userid = intent.getStringExtra("userid3");
        userid2 = SharedPreferencesUtil.readUserid(Activity_Xiafa_deatil.this);

        try {
            OkHttpUtils.get(Http_Api.URL_renwuxiangqing)
                    .params("taskid",taskid)
                    .params("userid",userid)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            try {
                                renwuxiangqing = JsonUtil.parseJsonToBean(s,Data_huoqurenwuxiangqing.class);

                                LogUtil.d("任务详情---->",renwuxiangqing+"");

                                String we = renwuxiangqing.getNewsCount();
                                if (!we.equals("0")){
                                    getToobarRedView().setVisibility(View.VISIBLE);
                                }

                                if (renwuxiangqing.getList() != null){
                                    list1 =  renwuxiangqing.getList();
                                    LogUtil.d("条目个数----",list1.size()+"");
                                   if (list1.get(0).getProgress()==100){
                                       buttext.setText("完成");
                                   }
                                }
                                if (renwuxiangqing.getChilds() != null){
                                    list2 = renwuxiangqing.getChilds();
                                    LogUtil.d("子任务",list2.size()+"");
                                }
                                if (renwuxiangqing.getChileList() != null){

                                    data3 = renwuxiangqing.getChileList();

                                }
                                yettime = renwuxiangqing.getYendtime();
                                sendtime = (String) renwuxiangqing.getSendtime();
                                if (sendtime != null){
                                    shijiriqi_layout.setVisibility(View.VISIBLE);
                                    yincang.setVisibility(View.VISIBLE);

                                    realfinshdata.setText(sendtime);
                                    LogUtil.d("实际完成日期----",sendtime);
                                }
                                LogUtil.d("完成日期----",yettime);
                                content = renwuxiangqing.getTaskcontent();
                                taskname = renwuxiangqing.getTaskname();
                                LogUtil.d("任务名----",taskname);
                                cycle = renwuxiangqing.getCycle();
                                if (cycle.equals(0+"")){
                                    shangbzqi_text.setText("单次");
                                }
                                if (cycle.equals(1+"")){
                                    shangbzqi_text.setText("日报");
                                }
                                if (cycle.equals(2+"")){
                                    shangbzqi_text.setText("周报");
                                }
                                if (cycle.equals(3+"")){
                                    shangbzqi_text.setText("月报");
                                }
                                renwuming_text.setText(taskname);
                                wanchqi_text.setText(yettime);

                                renwmiaosu_text.setText(content);
                                renwmiaosu_text.setHint(content);
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

                                    if (listacc.get(0).getAssid().equals("-1")){
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

                                }
                                if (listacc!=null&&listacc.size() == 5){
                                    if (listacc.get(0).getAssid().equals("-1")){
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

                                    if (listacc.get(4).getAssid().equals("-1")){
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

                                    if (listacc.get(4).getAssid().equals("-1")){
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

                                    if (listacc.get(4).getAssid().equals("-1")){
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

                                    if (listacc.get(4).getAssid().equals("-1")){
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

                                    if (listacc.get(4).getAssid().equals("-1")){
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
                                if (listacc!=null&&listacc.size()==10) {
                                    if (listacc.get(0).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(1).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(2).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(3).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(4).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(5).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(6).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(7).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(8).getAssid().equals("-1")){
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
                                    }

                                    if (listacc.get(9).getAssid().equals("-1")){
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
                                SlideAdapter6 slideAdapter6 = new SlideAdapter6(Activity_Xiafa_deatil.this,list1);
                                //addheader需要在adapter之前执行
                                swipeMenuListView.addHeaderView(listviewHeader);
                                swipeMenuListView.setAdapter(slideAdapter6);
                                slideAdapter6.notifyDataSetChanged();

                                if (renwuxiangqing.getTaskstatus() == 4){
                                    LogUtil.d("是否完成====>",renwuxiangqing.getTaskstatus()+"<===");
                                    xiugai.setVisibility(View.INVISIBLE);
                                    biaozhuntext.setText(content);
                                    renwmiaosu_text.setVisibility(View.INVISIBLE);
                                    add_fujian.setClickable(false);
                                    changetext.setText("附件");
                                    changarrow.setVisibility(View.INVISIBLE);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            ToastUtil.showToast("联网失败，头皮发麻");
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


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //文件路径
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK){//是否选择，没选择就不会继续
            try {
                Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
                LogUtil.d("文件路径--",uri+"");
                String url = FileUtils2.getPath(Activity_Xiafa_deatil.this,uri);
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
        if (o == 10){
            fujian20.setVisibility(View.VISIBLE);
            fujianname20.setText(m);
        }
    }


    private void onclick() {
        try {
            swipeMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    header = swipeMenuListView.getHeaderViewsCount();
                    positiom = position - header;
                    data1 = list1.get(positiom);
                    LogUtil.d("位置1是----->",positiom+"");
                    int jindu = data1.getProgress();
                    SharedPreferencesUtil.writeSonProgress(jindu,Activity_Xiafa_deatil.this);
                    String name =  data1.getCusername();
                   SharedPreferencesUtil.writeSonZerenren(name,Activity_Xiafa_deatil.this);

                    userid_son = data1.getUserid();//责任人id
                    if (list2 != null&&list2.size()>0&&list2.size()>positiom){
                        LogUtil.d("位置2是----->",positiom+"");
                        data2 = list2.get(positiom);
                        cusied_son = data2.getCuserid();//子任务id
                    }
                    taskid2 = renwuxiangqing.getTaskid();//任务id
//                    taskid2 = (String) list1.get(positiom).getTaskid();
                    String msg = (String) list1.get(positiom).getReason();
                    SharedPreferencesUtil.writeSonMsg(msg,Activity_Xiafa_deatil.this);
                    if (userid_son.equals(cusied_son)){
                        taskid_son = data2.getTaskid();//相等有子任务，传任务id 为null

                        zi = data2.getZi();
                        LogUtil.d("zi-------",zi.size()+"--");
                        EventBus.getDefault().post(new MessageEvent(zi));
                        Intent intent = new Intent(Activity_Xiafa_deatil.this,Activity_zirenwu_deatil2.class);
                        intent.putExtra("taskidsonson",taskid2);
                        intent.putExtra("taskidchatson",taskid);
                        intent.putExtra("useridson",userid_son);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(Activity_Xiafa_deatil.this,Activity_zirenwu_deatil.class);
                        intent.putExtra("taskidson",taskid2);
                        intent.putExtra("taskidchatson",taskid);
                        intent.putExtra("useridson",userid_son);
                        startActivity(intent);
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

//        fujian1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showToast("功能未完善");
//            }
//        });

        xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = renwmiaosu_text.getText().toString().trim();
                OkHttpUtils.post(Http_Api.URL_renwugenxin)
                        .params("userid",userid)
                        .params("taskid",taskid)
                        .params("taskcontent",s)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                Data_uploadBack_tag data_uploadBack_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                if (data_uploadBack_tag.getResult().equals("1")){
                                    ToastUtil.showToast("上传成功");
                                    finish();
                                }else {
                                    ToastUtil.showToast(data_uploadBack_tag.getResult()+"上传失败");
                                }

                            }

                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);
                                ToastUtil.showToast("无网络");
                            }
                        });

            }
        });

    }
    @Override
    protected int getLayoutId() {
        return R.layout.listview_xiafa;
    }
}
