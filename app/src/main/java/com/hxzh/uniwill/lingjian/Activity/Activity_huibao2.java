package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.hxzh.uniwill.lingjian.Adapter.HuibaoAdapter;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunrenwu_xiaoxiliebiao;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/4/19.
 *  下发 汇报信息
 */
public class Activity_huibao2 extends BaseToobarActivity {

    private ListView listView;
    private String userid,taskid;
    private Data_chaxunrenwu_xiaoxiliebiao xiaoxiliebiao;
    private List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> list;
    private List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> list3;
    private List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> list2 = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private View footer;
    private int footerHeight;
    private  HuibaoAdapter adapter;

    private int a = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("汇报信息");
        getToobarRightTitle().setText("");
        initView();
        initData();
    }

    private void initView() {
        footer = View.inflate(Activity_huibao2.this,R.layout.listview_footer2,null);
        listView = (ListView) findViewById(R.id.list_huibao);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        footer.measure(0,0);
        footerHeight = footer.getMeasuredHeight();
        footer.setPadding(0,-footerHeight,0,0);
        listView.addFooterView(footer);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light,
                android.R.color.holo_orange_light);
        listView.setCacheColorHint(0);
        listView.setDividerHeight(0);


    }

    private void initData() {
        Intent intent = getIntent();
//        userid = intent.getStringExtra("userid");
        taskid = intent.getStringExtra("taskid88");
        try {
            OkHttpUtils.get(Http_Api.URL_zirenwu_deatil)
                    .params("pn",1)
                    .params("size",10)
//                    .params("userid",userid)
                    .params("taskid",taskid)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            xiaoxiliebiao = JsonUtil.parseJsonToBean(s,Data_chaxunrenwu_xiaoxiliebiao.class);
                            if (xiaoxiliebiao != null){
                                list = xiaoxiliebiao.getList();
                                LogUtil.d("集合长度---",list.size()+"---");
                                 adapter = new HuibaoAdapter(Activity_huibao2.this,list);
                                listView.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                        }
                    });
            //下拉
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                OkHttpUtils.get(Http_Api.URL_zirenwu_deatil)
                                        .params("pn",1)
                                        .params("size",10)
                                        .params("taskid",taskid)
                                        .execute(new StringCallback() {
                                            @Override
                                            public void onSuccess(String s, Call call, Response response) {

                                                xiaoxiliebiao = JsonUtil.parseJsonToBean(s,Data_chaxunrenwu_xiaoxiliebiao.class);
                                                if (xiaoxiliebiao != null){
                                                    if (list!=null){
                                                        list.clear();
                                                        list = xiaoxiliebiao.getList();
                                                         adapter = new HuibaoAdapter(Activity_huibao2.this,list);
                                                        listView.setAdapter(adapter);
                                                        adapter.notifyDataSetChanged();
                                                        ToastUtil.showToast("刷新完成");
                                                        swipeRefreshLayout.setRefreshing(false);
                                                    }else {
                                                        ToastUtil.showToast("暂无汇报信息");
                                                        swipeRefreshLayout.setRefreshing(false);
                                                    }

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
                    },2000);


                }
            });
            //上拉
            listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (scrollState == SCROLL_STATE_IDLE){
                        int lastposition = listView.getLastVisiblePosition();//最后一个item的位置
                        if (lastposition == listView.getCount() - 1){
                            footer.setPadding(0,0,0,footerHeight);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    a++;
                                    OkHttpUtils.get(Http_Api.URL_zirenwu_deatil)
                                            .params("pn",a)
                                            .params("size",10)
                                            .params("taskid",taskid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {

                                                    xiaoxiliebiao = JsonUtil.parseJsonToBean(s,Data_chaxunrenwu_xiaoxiliebiao.class);
                                                    if (xiaoxiliebiao.getList() != null){
                                                        list2.clear();
                                                    }

                                                    list2 = xiaoxiliebiao.getList();
                                                    int curmax = list.size();
                                                    int maxx =  xiaoxiliebiao.getTotal();

                                                    if (curmax<maxx){
                                                        list.addAll(list2);
                                                        adapter.notifyDataSetChanged();
                                                        ToastUtil.showToast("加载完成");

                                                    }else {
                                                        a = 1;
                                                        ToastUtil.showToast("没有更多数据了");
                                                    }

                                                }

                                                @Override
                                                public void onError(Call call, Response response, Exception e) {
                                                    super.onError(call, response, e);
                                                    ToastUtil.showToast("联网失败");
                                                }
                                            });

                                    footer.setPadding(0,-footerHeight,0,0);

                                }
                            },2000);
                        }
                    }
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                    boolean enable = false;
//                    if(listView != null && listView.getChildCount() > 0){
//                        // 检查列表的第一个项目是否可见
//                        boolean firstItemVisible = listView.getFirstVisiblePosition() == 0;
//                        // 检查第一个项目的顶部是否可见
//                        boolean topOfFirstItemVisible = listView.getChildAt(0).getTop() == 0;
//                        // 启用或禁用刷新布局
//                        enable = firstItemVisible && topOfFirstItemVisible;
//                    }
//                    swipeRefreshLayout.setRefreshing(enable);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.huibao_listview;
    }
}
