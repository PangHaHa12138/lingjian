package com.hxzh.uniwill.lingjian.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hxzh.uniwill.lingjian.Activity.Activity_OAshenpi;
import com.hxzh.uniwill.lingjian.Activity.Activity_OAshenqing;
import com.hxzh.uniwill.lingjian.Activity.Activity_login;
import com.hxzh.uniwill.lingjian.Activity.Activity_oagdshenqing;
import com.hxzh.uniwill.lingjian.Activity.Activity_persion_X;
import com.hxzh.uniwill.lingjian.Activity.MainActivity;
import com.hxzh.uniwill.lingjian.Adapter.OAAdapter1;
import com.hxzh.uniwill.lingjian.Adapter.OAAdapter2;
import com.hxzh.uniwill.lingjian.Adapter.OAAppAdapter;
import com.hxzh.uniwill.lingjian.Adapter.OAGXAllAdapter;
import com.hxzh.uniwill.lingjian.Adapter.OAPhotoAdapter;
import com.hxzh.uniwill.lingjian.Adapter.OAVidoAdapter;
import com.hxzh.uniwill.lingjian.Adapter.OAWordAdapter;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.BottomPopupOption;
import com.hxzh.uniwill.lingjian.View.CenterDialog;
import com.hxzh.uniwill.lingjian.View.LeftPopupWindows;
import com.hxzh.uniwill.lingjian.View.OAfileSearch;
import com.hxzh.uniwill.lingjian.View.OAfilepaixu;
import com.hxzh.uniwill.lingjian.View.OAfilepaixulab;
import com.hxzh.uniwill.lingjian.View.Up_DownPopupWindows;
import com.hxzh.uniwill.lingjian.bean.Data_OAgongxiangwj;
import com.hxzh.uniwill.lingjian.bean.Data_OAshenqinglist;
import com.hxzh.uniwill.lingjian.bean.Data_shenpi;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
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
 * <p>
 * Created by PangHaHa12138 on 2017/6/12.
 */
public class OA_centerfragment extends android.support.v4.app.Fragment {

    private TextView tabtitle;
    private ImageButton righticon,lefticon;
    private LeftPopupWindows leftPopupWindows;
    private OAfilepaixu oAfilepaixu;
    private OAfileSearch oAfileSearch;
    private OAfilepaixulab oAfilepaixulab;
    private Up_DownPopupWindows up_downPopupWindows;
    private LinearLayout main;
    private SwipeRefreshLayout swip1,swip2;
    private SwipeMenuListView shenqinglistview,shenpilistview;
    private RelativeLayout gxlayout,alllayout,wendang,photolayt,vidolayt,appalyot;
    private SwipeRefreshLayout swipall,swipword,swipphoto,swipvido,swipapp;
    private ListView alllistview,wordlistview,photolistview,vidolistview,appplistview;
    private TextView alltext,wordtext,phototext,vidotext,apptext;
    private View tab1,tab2,tab3,tab4,tab5;
    private ImageButton addbuton;
    private OAAdapter1 oaAdapter1;
    private OAAdapter2 oaAdapter2;
    private OAGXAllAdapter oagxAllAdapter;
    private OAWordAdapter oaWordAdapter;
    private OAPhotoAdapter oaPhotoAdapter;
    private OAVidoAdapter oaVidoAdapter;
    private OAAppAdapter oaAppAdapter;
    private View footview;
    private String userid,type,query,sort,pn,size;
    private BottomPopupOption bottomPopupOption;

    private int leftitemtag = 1;//默认工单申请
    private int chosetab = 1;//全部文件类型
    private int footheight;

    private Data_OAgongxiangwj oAgongxiangwj;
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist1;
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist11 = new ArrayList<>();
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist2;
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist22= new ArrayList<>();
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist3;
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist33= new ArrayList<>();
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist4;
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist44= new ArrayList<>();
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist5;
    private List<Data_OAgongxiangwj.ListBean> oagongxiangwjlist55= new ArrayList<>();

    private CenterDialog centerDialog;

    private List<Data_OAshenqinglist.ListBean> oAshenqinglist;
    private List<Data_OAshenqinglist.ListBean> oAshenqinglist2 = new ArrayList<>();
    private Data_OAshenqinglist.ListBean data3;
    private String billid,iszhiding3;
    private String billid2,iszhiding4;

    private List<Data_shenpi.ListBean> oashenpi;
    private List<Data_shenpi.ListBean> oashenpi2 = new ArrayList<>();
    private Data_shenpi.ListBean data4;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mview = inflater.inflate(R.layout.centerfragment,container,false);
        footview = View.inflate(getActivity(),R.layout.oalistview_footer,null);
        tabtitle = (TextView) mview.findViewById(R.id.titlehaha);
        righticon = (ImageButton) mview.findViewById(R.id.righthaha);
        lefticon = (ImageButton) mview.findViewById(R.id.lefthaha);
        main = (LinearLayout) mview.findViewById(R.id.mainoa);
        swip1 = (SwipeRefreshLayout) mview.findViewById(R.id.swip1);
        swip2 = (SwipeRefreshLayout) mview.findViewById(R.id.swip2);
        shenpilistview = (SwipeMenuListView) mview.findViewById(R.id.shenpilistview);
        shenqinglistview = (SwipeMenuListView) mview.findViewById(R.id.shenqinglistview);
        gxlayout = (RelativeLayout) mview.findViewById(R.id.gxlayout);
        alllayout = (RelativeLayout) mview.findViewById(R.id.alllayout);
        wendang = (RelativeLayout) mview.findViewById(R.id.wendang);
        photolayt = (RelativeLayout) mview.findViewById(R.id.photolayt);
        vidolayt = (RelativeLayout) mview.findViewById(R.id.vidolayt);
        appalyot = (RelativeLayout) mview.findViewById(R.id.appalyot);
        swipall = (SwipeRefreshLayout) mview.findViewById(R.id.swipall);
        swipword = (SwipeRefreshLayout) mview.findViewById(R.id.swipword);
        swipphoto = (SwipeRefreshLayout) mview.findViewById(R.id.swipphoto);
        swipvido = (SwipeRefreshLayout) mview.findViewById(R.id.swipvido);
        swipapp = (SwipeRefreshLayout) mview.findViewById(R.id.swipapp);
        alllistview = (ListView) mview.findViewById(R.id.alllistview);
        wordlistview = (ListView) mview.findViewById(R.id.wordlistview);
        photolistview = (ListView) mview.findViewById(R.id.photolistview);
        vidolistview = (ListView) mview.findViewById(R.id.vidolistview);
        appplistview = (ListView) mview.findViewById(R.id.appplistview);
        alltext = (TextView) mview.findViewById(R.id.alltext);
        wordtext = (TextView) mview.findViewById(R.id.wordtext);
        phototext = (TextView) mview.findViewById(R.id.phototext);
        vidotext = (TextView) mview.findViewById(R.id.vidotext);
        apptext = (TextView) mview.findViewById(R.id.apptext);
        tab1 = mview.findViewById(R.id.tab1);
        tab2 = mview.findViewById(R.id.tab2);
        tab3 = mview.findViewById(R.id.tab3);
        tab4 = mview.findViewById(R.id.tab4);
        tab5 = mview.findViewById(R.id.tab5);
//        addbuton = (ImageButton) mview.findViewById(R.id.addbuton);

        shenqinglistview.addFooterView(footview);
        shenpilistview.addFooterView(footview);
        alllistview.addFooterView(footview);
        wordlistview.addFooterView(footview);
        photolistview.addFooterView(footview);
        vidolistview.addFooterView(footview);
        appplistview.addFooterView(footview);

        centerDialog = new CenterDialog(getActivity(),R.layout.dialog_layout,
                new int[]{R.id.dialog_cancel, R.id.dialog_sure});

        footview.measure(0,0);
        footheight = footview.getMeasuredHeight();
        footview.setPadding(0,-footheight,0,0);

        lefticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                leftPopupWindows = new LeftPopupWindows(getActivity(),leftonclick );
                leftPopupWindows.showAtLocation(main, Gravity.LEFT,0,0);
                leftPopupWindows.setWindowAlpa(true);

                leftPopupWindows.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        leftPopupWindows.setWindowAlpa(false);
                    }
                });
                String m = SharedPreferencesUtil.readUsername(getActivity());
                String s = SharedPreferencesUtil.readAvatar(getActivity());
                if (s != null) {
                    Glide.with(getActivity()).load(s).diskCacheStrategy(DiskCacheStrategy.RESULT).into(leftPopupWindows.getPhotoview());
                }
                if (m != null) {

                    leftPopupWindows.getName().setText(m);
                }

                leftPopupWindows.update();

            }
        });


        tabtitle.setText(R.string.gongdanshenqing);

        righticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (leftitemtag == 1){
                    ToastUtil.showToast("工单申请排序搜索");
                }else if (leftitemtag == 2){
                    ToastUtil.showToast("工单审批排序搜索");
                }else if (leftitemtag == 3){
                    oAfilepaixu = new OAfilepaixu(getActivity(),paixuonclick);
                    oAfilepaixu.showAtLocation(main,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                }


            }
        });

        shenpilistview.setDividerHeight(0);//去掉分割线
        shenpilistview.setCacheColorHint(0);

        shenqinglistview.setDividerHeight(0);//去掉分割线
        shenqinglistview.setCacheColorHint(0);

        alllistview.setDividerHeight(0);//去掉分割线
        alllistview.setCacheColorHint(0);

        wordlistview.setDividerHeight(0);//去掉分割线
        wordlistview.setCacheColorHint(0);

        photolistview.setDividerHeight(0);//去掉分割线
        photolistview.setCacheColorHint(0);

        vidolistview.setDividerHeight(0);//去掉分割线
        vidolistview.setCacheColorHint(0);

        appplistview.setDividerHeight(0);//去掉分割线
        appplistview.setCacheColorHint(0);

        initdata();

        oncliclk();

        addfootview();

        onrefsh();

        return mview;
    }

    private void addfootview() {

        shenqinglistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    int lastposition = shenqinglistview.getLastVisiblePosition();//最后一个item的位置
                    if (lastposition == shenqinglistview.getCount() - 1) {
                        footview.setPadding(0, 0, 0, footheight);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.showToast("加载完成");
                                httpLoadMore1();
                                footview.setPadding(0, -footheight, 0, 0);
                            }
                        }, 2000);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        shenpilistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    int lastposition = shenpilistview.getLastVisiblePosition();//最后一个item的位置
                    if (lastposition == shenpilistview.getCount() - 1) {
                        footview.setPadding(0, 0, 0, footheight);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.showToast("加载完成");
                                httpLoadMore2();
                                footview.setPadding(0, -footheight, 0, 0);
                            }
                        }, 2000);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        alllistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    int lastposition = alllistview.getLastVisiblePosition();//最后一个item的位置
                    if (lastposition == alllistview.getCount() - 1) {
                        footview.setPadding(0, 0, 0, footheight);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.showToast("加载完成");
                                httploadall();
                                footview.setPadding(0, -footheight, 0, 0);
                            }
                        }, 2000);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        wordlistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    int lastposition = wordlistview.getLastVisiblePosition();//最后一个item的位置
                    if (lastposition == wordlistview.getCount() - 1) {
                        footview.setPadding(0, 0, 0, footheight);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.showToast("加载完成");
                                httploadword();
                                footview.setPadding(0, -footheight, 0, 0);
                            }
                        }, 2000);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        photolistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    int lastposition = photolistview.getLastVisiblePosition();//最后一个item的位置
                    if (lastposition == photolistview.getCount() - 1) {
                        footview.setPadding(0, 0, 0, footheight);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.showToast("加载完成");
                                httploadphoto();
                                footview.setPadding(0, -footheight, 0, 0);
                            }
                        }, 2000);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        vidolistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    int lastposition = vidolistview.getLastVisiblePosition();//最后一个item的位置
                    if (lastposition == vidolistview.getCount() - 1) {
                        footview.setPadding(0, 0, 0, footheight);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.showToast("加载完成");
                                httploadvido();
                                footview.setPadding(0, -footheight, 0, 0);
                            }
                        }, 2000);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        appplistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    int lastposition = appplistview.getLastVisiblePosition();//最后一个item的位置
                    if (lastposition == appplistview.getCount() - 1) {
                        footview.setPadding(0, 0, 0, footheight);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.showToast("加载完成");
                                httploadapp();
                                footview.setPadding(0, -footheight, 0, 0);
                            }
                        }, 2000);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }
    private int a = 1;
    private void httploadall() {

        a++;
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","-1")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",a)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){
                                oagongxiangwjlist11.clear();

                            }
                            oagongxiangwjlist11 = oAgongxiangwj.getList();
                            String to = oAgongxiangwj.getTotal();//服务器返回总数
                            int totle = Integer.parseInt(to);
                            int totle2 =  oagongxiangwjlist1.size();//加载的数据
                            if (totle2<totle){
                                oagongxiangwjlist1.addAll(oagongxiangwjlist11);
                                oagxAllAdapter.notifyDataSetChanged();
                            }else {
                                   a = 1;
                                   ToastUtil.showToast("对不起,没有更多数据了");
                            }

                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private int b = 1;
    private void httploadword() {

        b++;
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","1")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",b)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){
                                oagongxiangwjlist22.clear();

                            }
                            oagongxiangwjlist22 = oAgongxiangwj.getList();
                            String to = oAgongxiangwj.getTotal();//服务器返回总数
                            int totle = Integer.parseInt(to);
                            int totle2 =  oagongxiangwjlist2.size();//加载的数据
                            if (totle2<totle){
                                oagongxiangwjlist2.addAll(oagongxiangwjlist22);
                                oaWordAdapter.notifyDataSetChanged();
                            }else {
                                b = 1;
                                ToastUtil.showToast("对不起,没有更多数据了");
                            }

                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private int c = 1;
    private void httploadphoto() {

        c++;
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","2")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",c)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){
                                oagongxiangwjlist33.clear();

                            }
                            oagongxiangwjlist33 = oAgongxiangwj.getList();
                            String to = oAgongxiangwj.getTotal();//服务器返回总数
                            int totle = Integer.parseInt(to);
                            int totle2 =  oagongxiangwjlist3.size();//加载的数据
                            if (totle2<totle){
                                oagongxiangwjlist3.addAll(oagongxiangwjlist33);
                                oaPhotoAdapter.notifyDataSetChanged();
                            }else {
                                a = 1;
                                ToastUtil.showToast("对不起,没有更多数据了");
                            }

                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private int d = 1;
    private void httploadvido() {

        d++;
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","3")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",d)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){
                                oagongxiangwjlist44.clear();

                            }
                            oagongxiangwjlist44 = oAgongxiangwj.getList();
                            String to = oAgongxiangwj.getTotal();//服务器返回总数
                            int totle = Integer.parseInt(to);
                            int totle2 =  oagongxiangwjlist4.size();//加载的数据
                            if (totle2<totle){
                                oagongxiangwjlist4.addAll(oagongxiangwjlist44);
                                oaVidoAdapter.notifyDataSetChanged();
                            }else {
                                d = 1;
                                ToastUtil.showToast("对不起,没有更多数据了");
                            }

                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private int e = 1;
    private void httploadapp() {

        e++;
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","4")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",e)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){
                                oagongxiangwjlist55.clear();

                            }
                            oagongxiangwjlist55 = oAgongxiangwj.getList();
                            String to = oAgongxiangwj.getTotal();//服务器返回总数
                            int totle = Integer.parseInt(to);
                            int totle2 =  oagongxiangwjlist5.size();//加载的数据
                            if (totle2<totle){
                                oagongxiangwjlist5.addAll(oagongxiangwjlist55);
                                oaAppAdapter.notifyDataSetChanged();
                            }else {
                                e = 1;
                                ToastUtil.showToast("对不起,没有更多数据了");
                            }

                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    private int f = 1;
    private int g = 1;
    //审批 上拉加载更多
    private void httpLoadMore2() {
        f++;
        try {
            String s = f+"";
            OkHttpUtils.post(Http_Api.URL_GongdanShenPi)
                    .params("userid",userid)
                    .params("pn",s)
                    .params("size","10")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            data_shenpi = JsonUtil.parseJsonToBean(s,Data_shenpi.class);
                            if (data_shenpi.getList()!=null){
                                oashenpi2.clear();
                            }
                            oashenpi2 = data_shenpi.getList();
                            String to = data_shenpi.getTotal();
                            int totle = Integer.parseInt(to);
                            int totle2 = oashenpi.size();
                            if (totle2<totle){
                                oashenpi.addAll(oashenpi2);
                                oaAdapter2.notifyDataSetChanged();
                            }else {
                                f = 1;
                                ToastUtil.showToast("对不起，没有更多数据了");
                            }

                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    //申请
    private void httpLoadMore1() {
        g++;
        try {
            String m = g+"";
            OkHttpUtils.post(Http_Api.URL_GongdanSelect)
                    .params("userid",userid)
                    .params("pn",m)
                    .params("size","10")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("json==s==>",s+"");
                            oAshenqinglistdata = JsonUtil.parseJsonToBean(s,Data_OAshenqinglist.class);
                            if (oAshenqinglistdata.getList()!= null){
                                oAshenqinglist2.clear();
                            }
                            oAshenqinglist2 = oAshenqinglistdata.getList();
                            String to = oAshenqinglistdata.getTotal();
                            int totle = Integer.parseInt(to);
                            int totle2 = oAshenqinglist.size();
                            if (totle2<totle){
                                oAshenqinglist.addAll(oAshenqinglist2);
                                oaAdapter1.notifyDataSetChanged();
                            }else {
                                g = 1;
                                ToastUtil.showToast("对不起，没有更多数据了");
                            }



                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    private void onrefsh() {

        swip1.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swip2.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipall.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipword.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipphoto.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipvido.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipapp.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);

        try {
            swip1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    swip1.setRefreshing(true);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            httpShenQing();
                            ToastUtil.showToast("刷新完成");
                            swip1.setRefreshing(false);
                        }
                    },2000);
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            swip2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        swip2.setRefreshing(true);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                httpShenPi();
                                ToastUtil.showToast("刷新完成");
                                swip2.setRefreshing(false);
                            }
                        },2000);


                    }


                });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            swipall.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            swipall.setRefreshing(true);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    httptupload("-1");
                                    ToastUtil.showToast("刷新完成");
                                    swipall.setRefreshing(false);
                                }
                            },2000);
                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        try {
            swipword.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            swipword.setRefreshing(true);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    httptupload("1");
                                    ToastUtil.showToast("刷新完成");
                                    swipword.setRefreshing(false);
                                }
                            },2000);
                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            swipphoto.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            swipphoto.setRefreshing(true);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    httptupload("2");
                                    ToastUtil.showToast("刷新完成");
                                    swipphoto.setRefreshing(false);
                                }
                            },2000);
                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            swipvido.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            swipvido.setRefreshing(true);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    httptupload("3");
                                    ToastUtil.showToast("刷新完成");
                                    swipvido.setRefreshing(false);
                                }
                            },2000);
                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            swipapp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            swipapp.setRefreshing(true);

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    httptupload("4");
                                    ToastUtil.showToast("刷新完成");
                                    swipapp.setRefreshing(false);
                                }
                            },2000);
                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    private Data_shenpi data_shenpi;

    private void httpShenPi() {


        try {
            OkHttpUtils.post(Http_Api.URL_GongdanShenPi)
                    .params("userid",userid)
                    .params("pn","1")
                    .params("size","10")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            data_shenpi = JsonUtil.parseJsonToBean(s,Data_shenpi.class);
                            if (data_shenpi.getList()!=null){
                                oashenpi = data_shenpi.getList();
                                LogUtil.d("json=0-0===>",s+"");
                                oaAdapter2 = new OAAdapter2(getActivity(),oashenpi);
                                shenpilistview.setAdapter(oaAdapter2);
                                oaAdapter2.notifyDataSetChanged();
                            }

                        }
                    });

            shenpilistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String billid = oashenpi.get(position).getBillid();
                    Intent intent = new Intent(getActivity(), Activity_OAshenpi.class);
                    intent.putExtra("billid",billid);
                    startActivity(intent);
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    private Data_OAshenqinglist oAshenqinglistdata;

    private void httpShenQing() {

        try {
            OkHttpUtils.post(Http_Api.URL_GongdanSelect)
                    .params("userid",userid)
                    .params("pn","1")
                    .params("size","10")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("json==s==>",s+"");
                            oAshenqinglistdata = JsonUtil.parseJsonToBean(s,Data_OAshenqinglist.class);
                            oAshenqinglist = oAshenqinglistdata.getList();
                            if (oAshenqinglist!= null){
                                oaAdapter1 = new OAAdapter1(getActivity(),oAshenqinglist);
                                shenqinglistview.setAdapter(oaAdapter1);
                                oaAdapter1.notifyDataSetChanged();
                            }


                        }
                    });

            shenqinglistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String billid = oAshenqinglist.get(position).getBillid();
                    Intent intent = new Intent(getActivity(), Activity_OAshenqing.class);
                    intent.putExtra("billid",billid);
                    startActivity(intent);
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }





    }

    private View.OnClickListener paixuonclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            oAfilepaixu.dismiss();

            switch (v.getId()){
                case R.id.renwusousu:

                    oAfileSearch = new OAfileSearch(getActivity(),searchonclick);
                    oAfileSearch.showAtLocation(main,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);

                    break;

                case R.id.paixu:

                    oAfilepaixulab = new OAfilepaixulab(getActivity(),paixulab);
                    oAfilepaixulab.showAtLocation(main,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);

                    break;
            }

        }
    };

    private View.OnClickListener paixulab = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            oAfilepaixulab.dismiss();

            switch (v.getId()){
                case R.id.timepaixu:

                    updownpaixu(1);

                    break;

                case R.id.filepaixu:

                    updownpaixu(2);

                    break;
            }
        }
    };

    private void updownpaixu(int i){

        if (i == 1){
            up_downPopupWindows = new Up_DownPopupWindows(getActivity(),timepaixu);
            up_downPopupWindows.showAtLocation(main,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
        }else if (i == 2){
            up_downPopupWindows = new Up_DownPopupWindows(getActivity(),filepaixu);
            up_downPopupWindows.showAtLocation(main,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
        }
    }

    private View.OnClickListener timepaixu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            up_downPopupWindows.dismiss();

            switch (v.getId()){
                case R.id.shengxu:
                    if (chosetab == 1){
                        httptimepaixu("2","-1");
                    }else if (chosetab == 2){
                        httptimepaixu("2","1");
                    }else if (chosetab == 3){
                        httptimepaixu("2","2");
                    }else if (chosetab == 4){
                        httptimepaixu("2","3");
                    }else if (chosetab == 5){
                        httptimepaixu("2","4");
                    }

                    break;

                case R.id.jiangxu:

                    if (chosetab == 1){
                        httptimepaixu("1","-1");
                    }else if (chosetab == 2){
                        httptimepaixu("1","1");
                    }else if (chosetab == 3){
                        httptimepaixu("1","2");
                    }else if (chosetab == 4){
                        httptimepaixu("1","3");
                    }else if (chosetab == 5){
                        httptimepaixu("1","4");
                    }
                    break;
            }
        }
    };

    private View.OnClickListener filepaixu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            up_downPopupWindows.dismiss();

            switch (v.getId()){
                case R.id.shengxu:
                    if (chosetab == 1){
                        httptimepaixu("4","-1");
                    }else if (chosetab == 2){
                        httptimepaixu("4","1");
                    }else if (chosetab == 3){
                        httptimepaixu("4","2");
                    }else if (chosetab == 4){
                        httptimepaixu("4","3");
                    }else if (chosetab == 5){
                        httptimepaixu("4","4");
                    }
                    break;

                case R.id.jiangxu:
                    if (chosetab == 1){
                        httptimepaixu("3","-1");
                    }else if (chosetab == 2){
                        httptimepaixu("3","1");
                    }else if (chosetab == 3){
                        httptimepaixu("3","2");
                    }else if (chosetab == 4){
                        httptimepaixu("3","3");
                    }else if (chosetab == 5){
                        httptimepaixu("3","4");
                    }
                    break;
            }
        }
    };


    private String searchtext;
    private View.OnClickListener searchonclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            switch (v.getId()){
                case R.id.makesure:
                     searchtext = oAfileSearch.getSearchView().getText().toString().trim();
                    if (searchtext.isEmpty()){
                        LogUtil.d("搜索关键字",searchtext+"");
                        ToastUtil.showToast("关键字不能为空!");
                        return;
                    }
                    if (chosetab == 1){
                        httppaixusearch(searchtext,"-1");

                    }else if (chosetab == 2){
                        httppaixusearch(searchtext,"1");
                    }else if (chosetab == 3){
                        httppaixusearch(searchtext,"2");
                    }else if (chosetab == 4){
                        httppaixusearch(searchtext,"3");
                    }else if (chosetab == 5){
                        httppaixusearch(searchtext,"4");
                    }

                    oAfileSearch.dismiss();
                    break;
            }
        }
    };

    private void httptupload(String m){
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type",m)//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",1)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){

                                if (chosetab == 1){
                                    if (oagongxiangwjlist1 != null){
                                        oagongxiangwjlist1.clear();
                                    }
                                    oagongxiangwjlist1 = oAgongxiangwj.getList();
                                    oagxAllAdapter = new OAGXAllAdapter(getActivity(),oagongxiangwjlist1);
                                    alllistview.setAdapter(oagxAllAdapter);
                                    oagxAllAdapter.notifyDataSetChanged();
                                }else if (chosetab == 2){
                                    if (oagongxiangwjlist2 != null){
                                        oagongxiangwjlist2.clear();
                                    }
                                    oagongxiangwjlist2 = oAgongxiangwj.getList();
                                    oaWordAdapter = new OAWordAdapter(getActivity(),oagongxiangwjlist2);
                                    wordlistview.setAdapter(oaWordAdapter);
                                    oaWordAdapter.notifyDataSetChanged();
                                }else if (chosetab == 3){
                                    if (oagongxiangwjlist3 != null){
                                        oagongxiangwjlist3.clear();
                                    }
                                    oagongxiangwjlist3 = oAgongxiangwj.getList();
                                    oaPhotoAdapter = new OAPhotoAdapter(getActivity(),oagongxiangwjlist3);
                                    photolistview.setAdapter(oaPhotoAdapter);
                                    oaPhotoAdapter.notifyDataSetChanged();
                                }else if ( chosetab == 4){
                                    if (oagongxiangwjlist4 != null){
                                        oagongxiangwjlist4.clear();
                                    }
                                    oagongxiangwjlist4 = oAgongxiangwj.getList();
                                    oaVidoAdapter = new OAVidoAdapter(getActivity(),oagongxiangwjlist4);
                                    vidolistview.setAdapter(oaVidoAdapter);
                                    oaVidoAdapter.notifyDataSetChanged();
                                }else if (chosetab == 5){
                                    if (oagongxiangwjlist5 != null){
                                        oagongxiangwjlist5.clear();
                                    }
                                    oagongxiangwjlist5 = oAgongxiangwj.getList();
                                    oaAppAdapter = new OAAppAdapter(getActivity(),oagongxiangwjlist5);
                                    appplistview.setAdapter(oaAppAdapter);
                                    oaAppAdapter.notifyDataSetChanged();
                                }


                            }else {
                                ToastUtil.showToast("对不起，没有更多数据了");
                            }


                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void httptimepaixu(String sort,String m){
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type",m)//-1所有 1文档 2图片 3视频 4app
                    .params("sort",sort)//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",1)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){

                                if (chosetab == 1){

                                    oagongxiangwjlist1 = oAgongxiangwj.getList();
                                    oagxAllAdapter = new OAGXAllAdapter(getActivity(),oagongxiangwjlist1);
                                    alllistview.setAdapter(oagxAllAdapter);
                                    oagxAllAdapter.notifyDataSetChanged();
                                }else if (chosetab == 2){
                                    oagongxiangwjlist2 = oAgongxiangwj.getList();
                                    oaWordAdapter = new OAWordAdapter(getActivity(),oagongxiangwjlist2);
                                    wordlistview.setAdapter(oaWordAdapter);
                                    oaWordAdapter.notifyDataSetChanged();
                                }else if (chosetab == 3){
                                    oagongxiangwjlist3 = oAgongxiangwj.getList();
                                    oaPhotoAdapter = new OAPhotoAdapter(getActivity(),oagongxiangwjlist3);
                                    photolistview.setAdapter(oaPhotoAdapter);
                                    oaPhotoAdapter.notifyDataSetChanged();
                                }else if ( chosetab == 4){
                                    oagongxiangwjlist4 = oAgongxiangwj.getList();
                                    oaVidoAdapter = new OAVidoAdapter(getActivity(),oagongxiangwjlist4);
                                    vidolistview.setAdapter(oaVidoAdapter);
                                    oaVidoAdapter.notifyDataSetChanged();
                                }else if (chosetab == 5){
                                    oagongxiangwjlist5 = oAgongxiangwj.getList();
                                    oaAppAdapter = new OAAppAdapter(getActivity(),oagongxiangwjlist5);
                                    appplistview.setAdapter(oaAppAdapter);
                                    oaAppAdapter.notifyDataSetChanged();
                                }


                            }


                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void httppaixusearch(String s,String m){
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type",m)//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("query",s)
                    .params("pn",1)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){

                                if (chosetab == 1){
                                    if (oagongxiangwjlist1!=null){
                                        oagongxiangwjlist1.clear();
                                    }
                                    oagongxiangwjlist1 = oAgongxiangwj.getList();
                                    oagxAllAdapter = new OAGXAllAdapter(getActivity(),oagongxiangwjlist1);
                                    alllistview.setAdapter(oagxAllAdapter);
                                    oagxAllAdapter.notifyDataSetChanged();
                                }else if (chosetab == 2){
                                    if (oagongxiangwjlist2!=null){
                                        oagongxiangwjlist2.clear();
                                    }

                                    oagongxiangwjlist2 = oAgongxiangwj.getList();
                                    oaWordAdapter = new OAWordAdapter(getActivity(),oagongxiangwjlist2);
                                    wordlistview.setAdapter(oaWordAdapter);
                                    oaWordAdapter.notifyDataSetChanged();
                                }else if (chosetab == 3){
                                    if (oagongxiangwjlist3!=null){
                                        oagongxiangwjlist3.clear();
                                    }
                                    oagongxiangwjlist3 = oAgongxiangwj.getList();
                                    oaPhotoAdapter = new OAPhotoAdapter(getActivity(),oagongxiangwjlist3);
                                    photolistview.setAdapter(oaPhotoAdapter);
                                    oaPhotoAdapter.notifyDataSetChanged();
                                }else if ( chosetab == 4){
                                    if (oagongxiangwjlist4!=null){
                                        oagongxiangwjlist4.clear();
                                    }
                                    oagongxiangwjlist4 = oAgongxiangwj.getList();
                                    oaVidoAdapter = new OAVidoAdapter(getActivity(),oagongxiangwjlist4);
                                    vidolistview.setAdapter(oaVidoAdapter);
                                    oaVidoAdapter.notifyDataSetChanged();
                                }else if (chosetab == 5){
                                    if (oagongxiangwjlist5!=null){
                                        oagongxiangwjlist5.clear();
                                    }
                                    oagongxiangwjlist5 = oAgongxiangwj.getList();
                                    oaAppAdapter = new OAAppAdapter(getActivity(),oagongxiangwjlist5);
                                    appplistview.setAdapter(oaAppAdapter);
                                    oaAppAdapter.notifyDataSetChanged();
                                }

                            }else {

                                ToastUtil.showToast("对不起没有搜到文件");
                                if (chosetab == 1){
                                    if (oagongxiangwjlist1!=null){
                                        oagongxiangwjlist1.clear();
                                        oagxAllAdapter.notifyDataSetChanged();
                                    }
                                }
                                if (chosetab == 2){
                                    if (oagongxiangwjlist2!=null){
                                        oagongxiangwjlist2.clear();
                                        oaWordAdapter.notifyDataSetChanged();
                                    }
                                }
                                if (chosetab == 3){
                                    if (oagongxiangwjlist3!=null){
                                        oagongxiangwjlist3.clear();
                                        oaPhotoAdapter.notifyDataSetChanged();
                                    }
                                }
                                if (chosetab == 4){
                                    if (oagongxiangwjlist4!=null){
                                        oagongxiangwjlist4.clear();
                                        oaVidoAdapter.notifyDataSetChanged();
                                    }
                                }
                                if (chosetab == 5){
                                    if (oagongxiangwjlist5!=null){
                                        oagongxiangwjlist5.clear();
                                        oaAppAdapter.notifyDataSetChanged();
                                    }
                                }


                            }


                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void oncliclk() {

        try {
            alllayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosetab = 1;
                    alltext.setTextColor(getResources().getColor(R.color.white));
                    tab1.setVisibility(View.VISIBLE);
                    swipall.setVisibility(View.VISIBLE);
                    alllistview.setVisibility(View.VISIBLE);

                    wordtext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab2.setVisibility(View.INVISIBLE);
                    swipword.setVisibility(View.INVISIBLE);
                    wordlistview.setVisibility(View.INVISIBLE);

                    phototext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab3.setVisibility(View.INVISIBLE);
                    swipphoto.setVisibility(View.INVISIBLE);
                    photolistview.setVisibility(View.INVISIBLE);

                    vidotext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab4.setVisibility(View.INVISIBLE);
                    swipvido.setVisibility(View.INVISIBLE);
                    vidolistview.setVisibility(View.INVISIBLE);

                    apptext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab5.setVisibility(View.INVISIBLE);
                    swipapp.setVisibility(View.INVISIBLE);
                    appplistview.setVisibility(View.INVISIBLE);


                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            wendang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosetab = 2;
                    alltext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab1.setVisibility(View.INVISIBLE);
                    swipall.setVisibility(View.INVISIBLE);
                    alllistview.setVisibility(View.INVISIBLE);

                    wordtext.setTextColor(getResources().getColor(R.color.white));
                    tab2.setVisibility(View.VISIBLE);
                    swipword.setVisibility(View.VISIBLE);
                    wordlistview.setVisibility(View.VISIBLE);

                    phototext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab3.setVisibility(View.INVISIBLE);
                    swipphoto.setVisibility(View.INVISIBLE);
                    photolistview.setVisibility(View.INVISIBLE);

                    vidotext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab4.setVisibility(View.INVISIBLE);
                    swipvido.setVisibility(View.INVISIBLE);
                    vidolistview.setVisibility(View.INVISIBLE);

                    apptext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab5.setVisibility(View.INVISIBLE);
                    swipapp.setVisibility(View.INVISIBLE);
                    appplistview.setVisibility(View.INVISIBLE);
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            photolayt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosetab = 3;
                    alltext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab1.setVisibility(View.INVISIBLE);
                    swipall.setVisibility(View.INVISIBLE);
                    alllistview.setVisibility(View.INVISIBLE);

                    wordtext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab2.setVisibility(View.INVISIBLE);
                    swipword.setVisibility(View.INVISIBLE);
                    wordlistview.setVisibility(View.INVISIBLE);

                    phototext.setTextColor(getResources().getColor(R.color.white));
                    tab3.setVisibility(View.VISIBLE);
                    swipphoto.setVisibility(View.VISIBLE);
                    photolistview.setVisibility(View.VISIBLE);

                    vidotext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab4.setVisibility(View.INVISIBLE);
                    swipvido.setVisibility(View.INVISIBLE);
                    vidolistview.setVisibility(View.INVISIBLE);

                    apptext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab5.setVisibility(View.INVISIBLE);
                    swipapp.setVisibility(View.INVISIBLE);
                    appplistview.setVisibility(View.INVISIBLE);

                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            vidolayt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosetab = 4;
                    alltext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab1.setVisibility(View.INVISIBLE);
                    swipall.setVisibility(View.INVISIBLE);
                    alllistview.setVisibility(View.INVISIBLE);

                    wordtext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab2.setVisibility(View.INVISIBLE);
                    swipword.setVisibility(View.INVISIBLE);
                    wordlistview.setVisibility(View.INVISIBLE);

                    phototext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab3.setVisibility(View.INVISIBLE);
                    swipphoto.setVisibility(View.INVISIBLE);
                    photolistview.setVisibility(View.INVISIBLE);

                    vidotext.setTextColor(getResources().getColor(R.color.white));
                    tab4.setVisibility(View.VISIBLE);
                    swipvido.setVisibility(View.VISIBLE);
                    vidolistview.setVisibility(View.VISIBLE);

                    apptext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab5.setVisibility(View.INVISIBLE);
                    swipapp.setVisibility(View.INVISIBLE);
                    appplistview.setVisibility(View.INVISIBLE);
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            appalyot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosetab = 5;
                    alltext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab1.setVisibility(View.INVISIBLE);
                    swipall.setVisibility(View.INVISIBLE);
                    alllistview.setVisibility(View.INVISIBLE);

                    wordtext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab2.setVisibility(View.INVISIBLE);
                    swipword.setVisibility(View.INVISIBLE);
                    wordlistview.setVisibility(View.INVISIBLE);

                    phototext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab3.setVisibility(View.INVISIBLE);
                    swipphoto.setVisibility(View.INVISIBLE);
                    photolistview.setVisibility(View.INVISIBLE);

                    vidotext.setTextColor(getResources().getColor(R.color.textcolordd));
                    tab4.setVisibility(View.INVISIBLE);
                    swipvido.setVisibility(View.INVISIBLE);
                    vidolistview.setVisibility(View.INVISIBLE);

                    apptext.setTextColor(getResources().getColor(R.color.white));
                    tab5.setVisibility(View.VISIBLE);
                    swipapp.setVisibility(View.VISIBLE);
                    appplistview.setVisibility(View.VISIBLE);
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

//        addbuton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                ToastUtil.showToast("点击了添加按钮");
//                bottomPopupOption = new BottomPopupOption(getActivity());
//                bottomPopupOption.setItemText("工单申请");
//                bottomPopupOption.showPopupWindow();
//                bottomPopupOption.setWindowAlpa(true);
//                bottomPopupOption.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
//                    @Override
//                    public void onItemClick(int position) {
//                        if (position==0){
//                            Intent intent = new Intent(getActivity(), Activity_oagdshenqing.class);
//                            startActivity(intent);
//                            bottomPopupOption.dismiss();
//                        }
//                    }
//                });
//
//            }
//        });
    }

    private void initdata() {

        userid = SharedPreferencesUtil.readUserid(getActivity());

        shenqinglistview.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
            @Override
            public void onMenuOpen(int position) {
                swip1.setEnabled(false);
            }

            @Override
            public void onMenuClose(int position) {
                swip1.setEnabled(true);
            }
        });

        shenpilistview.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
            @Override
            public void onMenuOpen(int position) {
                swip2.setEnabled(false);
            }

            @Override
            public void onMenuClose(int position) {
                swip2.setEnabled(true);
            }
        });

        httpShenQing();

        httpShenPi();

        leftmenucreat();

        httpall();
        httpword();
        httpphoto();
        httpvido();
        httpapp();

    }

    private void leftmenucreat() {

        SwipeMenuCreator creator1 = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                switch (menu.getViewType()) {

                    case 0:
                        createMenu1(menu);
                        break;
                    case 1:
                        createMenu2(menu);
                        break;

                }
            }

            private void createMenu2(SwipeMenu menu) {
                //创建置顶项
                SwipeMenuItem zditem2 = new SwipeMenuItem(getActivity());
                //设置item width
                zditem2.setWidth(dp2px(60));
                //设置背景
                zditem2.setBackground(R.color.listview_item_right_bg);
                //图标
                zditem2.setIcon(R.drawable.list_slide_but_canstick3x);
                // 添加到菜单
                menu.addMenuItem(zditem2);

                //创建置顶项
                SwipeMenuItem delete = new SwipeMenuItem(getActivity());
                //设置item width
                delete.setWidth(dp2px(60));
                //设置背景
                delete.setBackground(R.color.listview_item_right_bg);
                //图标
                delete.setIcon(R.drawable.list_slide_but_delete3x);

                menu.addMenuItem(delete);
            }

            private void createMenu1(SwipeMenu menu) {
                //创建置顶项
                SwipeMenuItem zditem1 = new SwipeMenuItem(getActivity());
                //设置item width
                zditem1.setWidth(dp2px(60));
                //设置背景
                zditem1.setBackground(R.color.listview_item_right_bg);
                //图标
                zditem1.setIcon(R.drawable.list_slide_but_stick3x);
                // 添加到菜单
                menu.addMenuItem(zditem1);

                //创建置顶项
                SwipeMenuItem delete = new SwipeMenuItem(getActivity());
                //设置item width
                delete.setWidth(dp2px(60));
                //设置背景
                delete.setBackground(R.color.listview_item_right_bg);
                //图标
                delete.setIcon(R.drawable.list_slide_but_delete3x);

                menu.addMenuItem(delete);
            }
        };

        shenqinglistview.setMenuCreator(creator1);
        try {
            shenqinglistview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {

                    data3 = oAshenqinglist.get(position);
                    billid = data3.getBillid();
                    iszhiding3 = data3.getStick();
                    switch (index) {
                        case 0:
                            //显示置顶
                            if (iszhiding3 .equals("0")) {
                                menu.getMenuItem(0).setIcon(R.drawable.list_slide_but_stick3x);
                                try {
                                    OkHttpUtils.post(Http_Api.URL_ShenQingzhiding)
                                            .params("userid", userid)
                                            .params("billid", billid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);
                                                    if (back_tag != null) {
                                                        ToastUtil.showToast("置顶");
                                                        httpShenQing();
                                                    } else {
                                                        ToastUtil.showToast("置顶失败");
                                                    }
                                                }

                                                @Override
                                                public void onError(Call call, Response response, Exception e) {
                                                    super.onError(call, response, e);
                                                    ToastUtil.showToast("置顶失败，头皮发麻");

                                                }
                                            });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            } else if (iszhiding3 .equals("1")) {
                                menu.getMenuItem(0).setIcon(R.drawable.list_slide_but_canstick3x);
                                try {
                                    OkHttpUtils.post(Http_Api.URL_ShenQingquxiaozhiding)
                                            .params("userid", userid)
                                            .params("billid", billid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                    if (back_tag != null) {
                                                        ToastUtil.showToast("取消置顶");
                                                        httpShenQing();
                                                    } else {
                                                        ToastUtil.showToast("取消失败");
                                                    }
                                                }

                                                @Override
                                                public void onError(Call call, Response response, Exception e) {
                                                    super.onError(call, response, e);
                                                    ToastUtil.showToast("置顶失败，头皮发麻");
                                                }
                                            });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            break;
                        case 1:
                            try {
                                OkHttpUtils.post(Http_Api.URL_ShenQingdelete)
                                        .params("billid", billid)
                                        .params("statustype", "-1")
                                        .execute(new StringCallback() {
                                            @Override
                                            public void onSuccess(String s, Call call, Response response) {
                                                Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                if (back_tag != null) {
                                                    ToastUtil.showToast("删除完成");
                                                    oAshenqinglist.remove(position);
                                                    oaAdapter1.notifyDataSetChanged();
                                                } else {
                                                    ToastUtil.showToast("删除失败");
                                                }
                                            }

                                            @Override
                                            public void onError(Call call, Response response, Exception e) {
                                                super.onError(call, response, e);
                                                ToastUtil.showToast("删除失败");
                                            }
                                        });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            break;

                        default:
                            break;

                    }
                    return false;
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        shenqinglistview.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

        SwipeMenuCreator creator2 = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                switch (menu.getViewType()) {

                    case 0:
                        createMenu1(menu);
                        break;
                    case 1:
                        createMenu2(menu);
                        break;

                }
            }

            private void createMenu2(SwipeMenu menu) {
                //创建置顶项
                SwipeMenuItem zditem2 = new SwipeMenuItem(getActivity());
                //设置item width
                zditem2.setWidth(dp2px(60));
                //设置背景
                zditem2.setBackground(R.color.listview_item_right_bg);
                //图标
                zditem2.setIcon(R.drawable.list_slide_but_canstick3x);
                // 添加到菜单
                menu.addMenuItem(zditem2);

//                //创建置顶项
//                SwipeMenuItem delete = new SwipeMenuItem(getActivity());
//                //设置item width
//                delete.setWidth(dp2px(60));
//                //设置背景
//                delete.setBackground(R.color.listview_item_right_bg);
//                //图标
//                delete.setIcon(R.drawable.list_slide_but_delete3x);
//
//                menu.addMenuItem(delete);
            }

            private void createMenu1(SwipeMenu menu) {
                //创建置顶项
                SwipeMenuItem zditem1 = new SwipeMenuItem(getActivity());
                //设置item width
                zditem1.setWidth(dp2px(60));
                //设置背景
                zditem1.setBackground(R.color.listview_item_right_bg);
                //图标
                zditem1.setIcon(R.drawable.list_slide_but_stick3x);
                // 添加到菜单
                menu.addMenuItem(zditem1);

//                //创建置顶项
//                SwipeMenuItem delete = new SwipeMenuItem(getActivity());
//                //设置item width
//                delete.setWidth(dp2px(60));
//                //设置背景
//                delete.setBackground(R.color.listview_item_right_bg);
//                //图标
//                delete.setIcon(R.drawable.list_slide_but_delete3x);
//
//                menu.addMenuItem(delete);
            }
        };

        shenpilistview.setMenuCreator(creator2);
        try {
            shenpilistview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                    data4 = oashenpi.get(position);
                    billid2 = data4.getBillid();
                    iszhiding4 = data4.getStick();
                    switch (index) {
                        case 0:
                            //显示置顶
                            if (iszhiding4 .equals("0")) {
                                menu.getMenuItem(0).setIcon(R.drawable.list_slide_but_stick3x);
                                try {
                                    OkHttpUtils.post(Http_Api.URL_ShenQingzhiding)
                                            .params("userid", userid)
                                            .params("billid", billid2)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);
                                                    if (back_tag != null) {
                                                        ToastUtil.showToast("置顶");
                                                        httpShenPi();
                                                    } else {
                                                        ToastUtil.showToast("置顶失败");
                                                    }
                                                }

                                                @Override
                                                public void onError(Call call, Response response, Exception e) {
                                                    super.onError(call, response, e);
                                                    ToastUtil.showToast("置顶失败，头皮发麻");

                                                }
                                            });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            } else if (iszhiding4 .equals("1")) {
                                menu.getMenuItem(0).setIcon(R.drawable.list_slide_but_canstick3x);
                                try {
                                    OkHttpUtils.post(Http_Api.URL_ShenQingquxiaozhiding)
                                            .params("userid", userid)
                                            .params("billid", billid2)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                    if (back_tag != null) {
                                                        ToastUtil.showToast("取消置顶");
                                                        httpShenPi();
                                                    } else {
                                                        ToastUtil.showToast("取消失败");
                                                    }
                                                }

                                                @Override
                                                public void onError(Call call, Response response, Exception e) {
                                                    super.onError(call, response, e);
                                                    ToastUtil.showToast("置顶失败，头皮发麻");
                                                }
                                            });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            break;


                        default:
                            break;

                    }

                    return false;
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        shenpilistview.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    private void httpapp(){
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","4")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",1)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){

                                oagongxiangwjlist5 = oAgongxiangwj.getList();
                                oaAppAdapter = new OAAppAdapter(getActivity(),oagongxiangwjlist5);
                                appplistview.setAdapter(oaAppAdapter);
                                oaAppAdapter.notifyDataSetChanged();

                            }


                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void httpvido(){
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","3")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",1)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){

                                oagongxiangwjlist4 = oAgongxiangwj.getList();
                                oaVidoAdapter = new OAVidoAdapter(getActivity(),oagongxiangwjlist4);
                                vidolistview.setAdapter(oaVidoAdapter);
                                oaVidoAdapter.notifyDataSetChanged();

                            }


                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void httpphoto(){
        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","2")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",1)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){

                                oagongxiangwjlist3 = oAgongxiangwj.getList();
                                oaPhotoAdapter = new OAPhotoAdapter(getActivity(),oagongxiangwjlist3);
                                photolistview.setAdapter(oaPhotoAdapter);
                                oaPhotoAdapter.notifyDataSetChanged();

                            }


                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void httpword(){

        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","1")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",1)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){

                                oagongxiangwjlist2 = oAgongxiangwj.getList();
                                oaWordAdapter = new OAWordAdapter(getActivity(),oagongxiangwjlist2);
                                wordlistview.setAdapter(oaWordAdapter);
                                oaWordAdapter.notifyDataSetChanged();
                            }


                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void httpall() {

        try {
            OkHttpUtils.post(Http_Api.URL_GongXiangWJ)
                    .params("userid",userid)
                    .params("type","-1")//-1所有 1文档 2图片 3视频 4app
                    .params("sort","1")//1：时间倒 2：时间正 3：名称倒 4：名称正
                    .params("pn",1)
                    .params("size",12)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回json===",s+"");
                            oAgongxiangwj = JsonUtil.parseJsonToBean(s,Data_OAgongxiangwj.class);
                            if (oAgongxiangwj.getList()!=null){

                                oagongxiangwjlist1 = oAgongxiangwj.getList();
                                oagxAllAdapter = new OAGXAllAdapter(getActivity(),oagongxiangwjlist1);
                                alllistview.setAdapter(oagxAllAdapter);
                                oagxAllAdapter.notifyDataSetChanged();
                            }


                        }
                    });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    private View.OnClickListener leftonclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.leftphoto:
                    leftPopupWindows.dismiss();
                    ToastUtil.showToast("头像");

                    Intent intent = new Intent(getActivity(), Activity_persion_X.class);
                    startActivity(intent);


                    break;
                case R.id.shenqing:
                    leftPopupWindows.dismiss();
                    ToastUtil.showToast("工单申请");
                    leftitemtag = 1;
                    tabtitle.setText(R.string.gongdanshenqing);
                    swip1.setVisibility(View.VISIBLE);
                    shenqinglistview.setVisibility(View.VISIBLE);

                    swip2.setVisibility(View.INVISIBLE);
                    shenpilistview.setVisibility(View.INVISIBLE);

                    gxlayout.setVisibility(View.INVISIBLE);


                    break;

                case R.id.shenpi:
                    leftPopupWindows.dismiss();
                    ToastUtil.showToast("工单审批");
                    leftitemtag = 2;
                    tabtitle.setText(R.string.gongdanshenpi);
                    swip1.setVisibility(View.INVISIBLE);
                    shenqinglistview.setVisibility(View.INVISIBLE);

                    swip2.setVisibility(View.VISIBLE);
                    shenpilistview.setVisibility(View.VISIBLE);

                    gxlayout.setVisibility(View.INVISIBLE);


                    break;
                case R.id.gongxiangwj:
                    leftPopupWindows.dismiss();
                    tabtitle.setText(R.string.gongxiangwenjian);
                    ToastUtil.showToast("共享文件");
                    leftitemtag = 3;
                    swip1.setVisibility(View.INVISIBLE);
                    shenqinglistview.setVisibility(View.INVISIBLE);

                    swip2.setVisibility(View.INVISIBLE);
                    shenpilistview.setVisibility(View.INVISIBLE);

                    gxlayout.setVisibility(View.VISIBLE);
                    httpall();
                    httpword();
                    httpphoto();
                    httpvido();
                    httpapp();


                    break;

                case R.id.exit:
                    ToastUtil.showToast("退出");
                    centerDialog.show();
                    centerDialog.setOnCenterItemClickListener(new CenterDialog.OnCenterItemClickListener() {
                        @Override
                        public void OnCenterItemClick(CenterDialog dialog, View view) {
                            switch (view.getId()){
                                case R.id.dialog_sure:
                                    SharedPreferences.Editor editor = SharedPreferencesUtil.preferences.edit();
                                    editor.remove("userid");
                                    editor.remove("Avatar");
                                    editor.remove("Deptid");
                                    editor.remove("Deptname");
                                    editor.remove("Roleid");
                                    editor.remove("Rolename");
//                    editor.remove("password");
//                    editor.remove("Username");
                                    editor.remove("Usertel");
                                    editor.remove("Useremail");
                                    editor.remove("Updatetime");
                                    editor.remove("Companyid");
                                    editor.remove("Companyname");
                                    editor.remove("Leaderid");
                                    editor.remove("Leadername");
                                    editor.remove("Desc");
                                    editor.remove("Type");
                                    editor.remove("Sex");
                                    editor.remove("Admin");
                                    editor.remove("Topleader");
                                    editor.remove("Autherid");
                                    editor.remove("Usermobile");
                                    editor.remove("Createtime");
//                                    editor.clear();
                                    editor.commit();
                                    editor.apply();
                                    Intent intent = new Intent(getActivity(), Activity_login.class);
                                    startActivity(intent);
                                    getActivity().finish();

                            }
                        }
                    });

                    break;
            }
        }
    };
}
