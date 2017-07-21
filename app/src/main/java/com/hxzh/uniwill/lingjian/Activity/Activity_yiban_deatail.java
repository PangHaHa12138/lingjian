package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdapter7;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunrenwu_xiaoxiliebiao;
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
 * Created by pang on 2017/4/17.
 *  已办详情页
 */
public class Activity_yiban_deatail extends BaseToobarRightViewActivity {

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

    private Data_huoqurenwuxiangqing.ChileListBean data3;
    private List<Data_huoqurenwuxiangqing.ChileListBean> list3;

    private Data_huoqurenwuxiangqing renwuxiangqing;

    private Data_chaxunrenwu_xiaoxiliebiao xiaoxiliebiao;

    private List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> msglist;

    private String taskid,userid,cycle,taskname,content,yettime;
    private String userid_son,cusied_son,taskid_son,taskid2;

    private RelativeLayout fujian1,fujian2;
    private ImageView fujiantu1,fujiantu2;
    private TextView fujiantext1,fujiantext2;
    private ImageView fujian_arr1,fujian_arr2;
    private int header, positiom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("已办任务");

        initView();
        initData();
        onclick();

    }
    private void initView() {

        swipeMenuListView = (SwipeMenuListView) findViewById(R.id.yiban_listview);
        //头布局
//        listviewHeader = View.inflate(Activity_Xiafa_deatil.this,R.layout.activity_xiafa_deatil_header,null);
        listviewHeader =  LayoutInflater.from(Activity_yiban_deatail.this).inflate(R.layout.activity_yiban_deatil_header,swipeMenuListView,false);
        renwming_layout = (RelativeLayout)listviewHeader.findViewById(R.id.renwu_ming_layout77);
        wancriqi_layout = (RelativeLayout) listviewHeader.findViewById(R.id.wanchengriqi_layout77);
        shangbzqi_layout = (RelativeLayout) listviewHeader.findViewById(R.id.shangbaozhouqi_layout77);

        renwuming_text = (TextView) listviewHeader.findViewById(R.id.deatil_renwuming77);
        wanchqi_text = (TextView) listviewHeader.findViewById(R.id.deatil_finsh_data77);
        shangbzqi_text = (TextView) listviewHeader.findViewById(R.id.deatil_shangbaozhouqi77);
        renwmiaosu_text = (TextView) listviewHeader.findViewById(R.id.renwubiaozhun77);

        fujian1 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian71);
        fujian2 = (RelativeLayout) listviewHeader.findViewById(R.id.fujian72);
        fujiantu1 = (ImageView)listviewHeader.findViewById(R.id.fujiantu71);
        fujiantu2 = (ImageView) listviewHeader.findViewById(R.id.fujiantu72);
        fujiantext1 = (TextView) listviewHeader.findViewById(R.id.fujiantext71);
        fujiantext2 = (TextView) listviewHeader.findViewById(R.id.fujiantext72);
        fujian_arr1 = (ImageView) listviewHeader.findViewById(R.id.fujian_arr71);
        fujian_arr2 = (ImageView) listviewHeader.findViewById(R.id.fujian_arr72);
//        listviewHeader = getLayoutInflater().inflate(R.layout.,swipeMenuListView, false);
        swipeMenuListView.setDividerHeight(0);//去掉分割线
        swipeMenuListView.setCacheColorHint(0);


    }


    private void initData() {

        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid2");
        LogUtil.d("拿到的taskid----->",taskid+"");
        userid = intent.getStringExtra("userid2");
//        userid = SharedPreferencesUtil.readUserid(Activity_Xiafa_deatil.this);

        OkHttpUtils.get(Http_Api.URL_renwuxiangqing)
                .params("taskid",taskid)
                .params("userid",userid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        try {
                            renwuxiangqing = JsonUtil.parseJsonToBean(s,Data_huoqurenwuxiangqing.class);
                            LogUtil.d("任务详情---->",renwuxiangqing+"");

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
                            SlideAdapter7 slideAdapter7 = new SlideAdapter7(Activity_yiban_deatail.this,list1);
                            //addheader需要在adapter之前执行
                            swipeMenuListView.addHeaderView(listviewHeader);
                            swipeMenuListView.setAdapter(slideAdapter7);
                            slideAdapter7.notifyDataSetChanged();
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
                    SharedPreferencesUtil.writeSonProgress(jindu,Activity_yiban_deatail.this);
                    String name =  data1.getCusername();
                    SharedPreferencesUtil.writeSonZerenren(name,Activity_yiban_deatail.this);

                    userid_son = data1.getUserid();//责任人id
                    if (list2 != null&&list2.size()>0&&list2.size()>positiom){
                        LogUtil.d("位置2是----->",positiom+"");
                        data2 = list2.get(positiom);
                        cusied_son = data2.getCuserid();//子任务id
                    }
                    taskid2 = renwuxiangqing.getTaskid();//任务id
                    String msg = (String) list1.get(positiom).getReason();
                    SharedPreferencesUtil.writeSonMsg(msg,Activity_yiban_deatail.this);

                    if (userid_son.equals(cusied_son)){
                        taskid_son = data2.getTaskid();//相等有子任务，传任务id

                        Intent intent = new Intent(Activity_yiban_deatail.this,Activity_zirenwu_deatil2.class);
                        intent.putExtra("taskidsonson",taskid);
                        intent.putExtra("useridson",userid_son);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(Activity_yiban_deatail.this,Activity_zirenwu_deatil.class);
                        intent.putExtra("taskidson",taskid2);
                        intent.putExtra("useridson",userid_son);
                        startActivity(intent);
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        fujian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("功能未完善");
            }
        });
        fujian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("功能未完善");
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yiban_detail;
    }
}
