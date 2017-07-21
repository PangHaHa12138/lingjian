package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdapter8;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunrenwu_xiaoxiliebiao;
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
 * Created by pang on 2017/4/20.
 *  撤销详情页
 */
public class Activity_Chexiao_deatil extends BaseToobarRightViewActivity {

    private RelativeLayout renwming_layout;
    private RelativeLayout wancriqi_layout;
    private RelativeLayout shangbzqi_layout;
    private TextView renwuming_text;
    private TextView wanchqi_text;
    private TextView shangbzqi_text;
    private TextView renwmiaosu_text;
    //    private LinearLayout listviewHeader;
    private View listviewHeader;

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

    private String taskid,userid,cycle,taskname,content,yettime;
    private String userid_son,cusied_son,taskid_son,taskid2;

    private int header, positiom;

    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,fujian10,xiugai;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,fujianname8,fujianname9,fujianname10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("撤销任务");
        initView();
        initData();
        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
                getToobarRedView().setVisibility(View.INVISIBLE);
                Intent intent = new Intent(Activity_Chexiao_deatil.this,Activity_Chat.class);
                intent.putExtra("taskidchat",taskid);
                startActivity(intent);
            }
        });
        onclick();

    }

    private void initView() {

        swipeMenuListView = (SwipeMenuListView) findViewById(R.id.chexiao_listview);
        //头布局
//        listviewHeader = View.inflate(Activity_Xiafa_deatil.this,R.layout.activity_xiafa_deatil_header,null);
        listviewHeader =  LayoutInflater.from(Activity_Chexiao_deatil.this).inflate(R.layout.activity_chexiao_deatil_header,swipeMenuListView,false);
        renwming_layout = (RelativeLayout)listviewHeader.findViewById(R.id.renwu_ming_layout88);
        wancriqi_layout = (RelativeLayout) listviewHeader.findViewById(R.id.wanchengriqi_layout88);
        shangbzqi_layout = (RelativeLayout) listviewHeader.findViewById(R.id.shangbaozhouqi_layout88);

        renwuming_text = (TextView) listviewHeader.findViewById(R.id.deatil_renwuming88);
        wanchqi_text = (TextView) listviewHeader.findViewById(R.id.deatil_finsh_data88);
        shangbzqi_text = (TextView) listviewHeader.findViewById(R.id.deatil_shangbaozhouqi88);
        renwmiaosu_text = (TextView) listviewHeader.findViewById(R.id.renwubiaozhun88);

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

//        listviewHeader = getLayoutInflater().inflate(R.layout.,swipeMenuListView, false);
        swipeMenuListView.setDividerHeight(0);//去掉分割线
        swipeMenuListView.setCacheColorHint(0);


    }

    private void initData() {

        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid4");
        LogUtil.d("拿到的taskid----->",taskid+"");
        userid = intent.getStringExtra("userid4");
//        userid = SharedPreferencesUtil.readUserid(Activity_Xiafa_deatil.this);

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
                                String qq = renwuxiangqing.getNewsCount();
                                if (!qq.equals("0")){
                                    getToobarRedView().setVisibility(View.VISIBLE);
                                }
                                if (renwuxiangqing.getList() != null){
                                    list1 =  renwuxiangqing.getList();
                                    LogUtil.d("条目个数----",list1.size()+"");
                                }
                                if (renwuxiangqing.getChilds() != null){
                                    list2 = renwuxiangqing.getChilds();
                                    LogUtil.d("子任务",list2.size()+"");
                                }
                                if (renwuxiangqing.getChileList() != null){

                                    data3 = renwuxiangqing.getChileList();
                                }
                                yettime = renwuxiangqing.getYendtime();
                                LogUtil.d("完成日期----",yettime);
                                content = renwuxiangqing.getTaskcontent();
                                taskname = renwuxiangqing.getTaskname();
                                LogUtil.d("任务名----",taskname);
                                cycle = renwuxiangqing.getCycle();
                                if (cycle.equals(0+"")){
                                    shangbzqi_text.setText("当前任务");
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
                                SlideAdapter8 slideAdapter8 = new SlideAdapter8(Activity_Chexiao_deatil.this,list1);
                                //addheader需要在adapter之前执行
                                swipeMenuListView.addHeaderView(listviewHeader);
                                swipeMenuListView.setAdapter(slideAdapter8);
                                slideAdapter8.notifyDataSetChanged();

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
        } catch (Exception e) {
            e.printStackTrace();
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
                    SharedPreferencesUtil.writeSonProgress(jindu,Activity_Chexiao_deatil.this);
                    String name =  data1.getCusername();
                    SharedPreferencesUtil.writeSonZerenren(name,Activity_Chexiao_deatil.this);

                    userid_son = data1.getUserid();//责任人id
                    if (list2 != null&&list2.size()>0&&list2.size()>positiom){
                        LogUtil.d("位置2是----->",positiom+"");
                        data2 = list2.get(positiom);
                        cusied_son = data2.getCuserid();//子任务id
                    }
                    taskid2 = renwuxiangqing.getTaskid();//任务id
                    String msg = (String) list1.get(positiom).getReason();
                    SharedPreferencesUtil.writeSonMsg(msg,Activity_Chexiao_deatil.this);
                    if (userid_son.equals(cusied_son)){
                        taskid_son = data2.getTaskid();//相等有子任务，传任务id

                        Intent intent = new Intent(Activity_Chexiao_deatil.this,Activity_zirenwu_deatil2.class);
                        intent.putExtra("taskidsonson",taskid);
                        intent.putExtra("useridson",userid_son);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(Activity_Chexiao_deatil.this,Activity_zirenwu_deatil.class);
                        intent.putExtra("taskidson",taskid2);
                        intent.putExtra("useridson",userid_son);
                        startActivity(intent);
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_chexiao_detail;
    }
}
