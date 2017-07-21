package com.hxzh.uniwill.lingjian.Activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdapter1;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdapter2;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdapter3;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdapter4;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdapter5;
import com.hxzh.uniwill.lingjian.Adapter.SlideAdaptertest;
import com.hxzh.uniwill.lingjian.Adapter.TestAdapter;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.BottomPopupOption;
import com.hxzh.uniwill.lingjian.View.CenterDialog;
import com.hxzh.uniwill.lingjian.View.PaixuPopupWindows;
import com.hxzh.uniwill.lingjian.View.PhotoPopupWindows;
import com.hxzh.uniwill.lingjian.View.SearchPopupWindows;
import com.hxzh.uniwill.lingjian.View.SearchTextPopupWindows;
import com.hxzh.uniwill.lingjian.View.TimePickerPopupWindows;
import com.hxzh.uniwill.lingjian.View.TimePickerPopupWindows2;
import com.hxzh.uniwill.lingjian.View.TubiaoPopupWindows;
import com.hxzh.uniwill.lingjian.View.Up_DownPopupWindows;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.base.MessageEvent2;
import com.hxzh.uniwill.lingjian.base.MessageEvent3;
import com.hxzh.uniwill.lingjian.base.MessageEvent4;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunliebiao_faburenwu;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunliebiao_shoudaorenwu;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunweidu;
import com.hxzh.uniwill.lingjian.bean.Data_huoqusuoyou_wanchengrenwu;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
import com.hxzh.uniwill.lingjian.fragment.OA_centerfragment;
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
import org.senydevpkg.utils.NetworkUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * * ━━━━ Code is far away from ━━━━━━
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
 * ━━━━ bug with the More protecting ━━━
 * <p/>
 * Created by pang on 2017/3/28.
 */

public class MainActivity extends ActionBarActivity  {
    //标题
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private LinearLayout lvLeftMenu;

    private SwipeRefreshLayout swipeRefreshLayout1;//刷新控件
    private SwipeRefreshLayout swipeRefreshLayout2;//刷新控件
    private SwipeRefreshLayout swipeRefreshLayout3;//刷新控件
    private SwipeRefreshLayout swipeRefreshLayout4;//刷新控件
    private SwipeRefreshLayout swipeRefreshLayout5;//刷新控件
    //    private SlideListView2 mListView1;
    private SwipeMenuListView mListView1;
    private SwipeMenuListView mListView2;
    private SwipeMenuListView mListView3;
    private SwipeMenuListView mListView4;
    private SwipeMenuListView mListView5;
    private ActionBarDrawerToggle toggle;
    private TextView toobar_title;

    //假数据
    private ArrayList hehe = new ArrayList();

    //侧拉栏控件
    private ImageView person_photo;
    private TextView person_name;
    private LinearLayout daiban_layout;
    private LinearLayout yiban_layout;
    private LinearLayout xiafa_layout;
    private LinearLayout chexiao_layout;
    private LinearLayout zhanting_layout;
    private ImageView daiban_red;
    private ImageView yiban_red;
    private ImageView xiafa_red;
    private ImageView chexiao_red;
    private ImageView zhanting_red;

    private ImageButton toobar_right_view;
    private ImageView no_renwuphoto;

    private LinearLayout tuichu;
    //待办
    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list1= new ArrayList<>();
    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> testData;
    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list11 = new ArrayList<>();
    private Data_chaxunliebiao_shoudaorenwu.ListBean data1;
    private Data_chaxunliebiao_shoudaorenwu shoudaorenwu;
    //已办
    private Data_huoqusuoyou_wanchengrenwu wanchengrenwu;
    private Data_huoqusuoyou_wanchengrenwu.ListBean data2;
    private List<Data_huoqusuoyou_wanchengrenwu.ListBean> list2= new ArrayList<>();
    private List<Data_huoqusuoyou_wanchengrenwu.ListBean> list22= new ArrayList<>();
    //下发
    private Data_chaxunliebiao_faburenwu faburenwu;
    private List<Data_chaxunliebiao_faburenwu.ListBean> list3= new ArrayList<>();
    private List<Data_chaxunliebiao_faburenwu.ListBean> list3n= new ArrayList<>();
    private List<Data_chaxunliebiao_faburenwu.ListBean> list3m= new ArrayList<>();
    private List<Data_chaxunliebiao_faburenwu.ListBean> list33= new ArrayList<>();
    private Data_chaxunliebiao_faburenwu.ListBean data3;

    //撤销
    private Data_chaxunliebiao_shoudaorenwu chexiaorenwu;
    private Data_chaxunliebiao_shoudaorenwu.ListBean data4;
    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list4= new ArrayList<>();
    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list44= new ArrayList<>();

    //暂停
    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list5= new ArrayList<>();
    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list55= new ArrayList<>();
    private Data_chaxunliebiao_shoudaorenwu.ListBean data5;
    private Data_chaxunliebiao_shoudaorenwu zhanting;

    private Data_chaxunweidu chaxunweidu;

    private PhotoPopupWindows popMenus;//初始化弹窗
    private TubiaoPopupWindows popMenus2;//初始化弹窗
    private PaixuPopupWindows popMenus3;
    private Up_DownPopupWindows popMenus4;
    private SearchPopupWindows popMenus5;
    private SearchTextPopupWindows popMenus6;
    private TimePickerPopupWindows popMenus7;
    private TimePickerPopupWindows2 popMenus8;

    private String userid, taskid, taskid2, taskid3, taskid4, taskid5;//需要获取的值传详情页

    private LinearLayout addrenwu_bt;//悬浮新增按钮

    private SlideAdapter1 slideAdapter1;//待办
    private SlideAdapter2 slideAdapter2;//已办
    private SlideAdapter3 slideAdapter3;//下发
    private SlideAdapter4 slideAdapter4;//撤销
    private SlideAdapter5 slideAdapter5;//暂停
    private int i = 1;//标记 默认待办
    private int iszhiding;

    private int iszhiding1;
    private int iszhiding2;
    private int iszhiding3;
    private int iszhiding4;
    private int iszhiding5;
    private int ischexiao;
    private int iszanting;

    private TextView zhiding_text;//显示置顶
    private int amin, type;//判断新增字段
    private String autherid;

    private View footview;
    private View header;
    private int footheight,headheight,haha,prooo;
    private int bootm;
    private static final int sizedown = 10; //上拉加载更多
    private static final int sizeup = 10; //下拉刷新

    private boolean isloadMore = false;
    private TestAdapter testAdapter;
    private SlideAdaptertest slideAdaptertest;

    private CenterDialog centerDialog;

    private BottomNavigationBar bottomNavigationBar;

    private OA_centerfragment centerfragment;

    private RadioGroup radioGroup;

    private LinearLayout Lj_but,OA_but;
    private TextView Lj_text,OA_text;
    private ImageView Lj_icon,OA_icon;

    private int isOA=1;
    private int daibanred,yibanred,xiafared,zantingred;

    private RelativeLayout mainlistandadd;
    private  BottomPopupOption bottomPopupOption2;

    private int faTimeUpTag =0,faTimeDownTag=0,lessTimeUp=0,lessTimeDown=0;


//    /**服务器端一共多少条数据*/
//    private static final int TOTAL_COUNTER = 64;
//
//    /**每一页展示多少条数据*/
//    private static final int REQUEST_COUNT = 10;
//
//    /**已经获取到多少条数据了*/
//    private static int mCurrentCounter = 0;
//
//    private LRecyclerView mRecyclerView = null;
//
//    private SwipeMenuAdapter mDataAdapter = null;
//
//    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;
//
//    private boolean isRefresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initData();
        setListener();
//        mListView1.addHeaderView(header);
//        mListView2.addHeaderView(header);
//        mListView3.addHeaderView(header);
//        mListView4.addHeaderView(header);
//        mListView5.addHeaderView(header);
//
//        header.measure(0,0);
//        headheight = header.getMeasuredHeight();
//        header.setPadding(0,0,0,-headheight);

        mListView1.addFooterView(footview);
        mListView2.addFooterView(footview);
        mListView3.addFooterView(footview);
        mListView4.addFooterView(footview);
        mListView5.addFooterView(footview);

        footview.measure(0, 0);
        footheight = footview.getMeasuredHeight();
//        DisplayMetrics metric = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metric);
//        int width = metric.widthPixels;     // 屏幕宽度（像素）
//        int height = metric.heightPixels;   // 屏幕高度（像素）
//        float density = metric.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
//        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
        bootm = dp2px(45);
        footview.setPadding(0, -footheight, 0, 0);
        try {
            //解决listview与SwipeRefreshLayout滑动冲突问题
            mListView1.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
                @Override
                public void onMenuOpen(int position) {
                    swipeRefreshLayout1.setEnabled(false);
                }

                @Override
                public void onMenuClose(int position) {
                    swipeRefreshLayout1.setEnabled(true);
                }
            });
            mListView2.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
                @Override
                public void onMenuOpen(int position) {
                    swipeRefreshLayout2.setEnabled(false);
                }

                @Override
                public void onMenuClose(int position) {
                    swipeRefreshLayout2.setEnabled(true);
                }
            });
            mListView3.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
                @Override
                public void onMenuOpen(int position) {
                    swipeRefreshLayout3.setEnabled(false);
                }

                @Override
                public void onMenuClose(int position) {
                    swipeRefreshLayout3.setEnabled(true);
                }
            });
            mListView4.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
                @Override
                public void onMenuOpen(int position) {
                    swipeRefreshLayout4.setEnabled(false);
                }

                @Override
                public void onMenuClose(int position) {
                    swipeRefreshLayout4.setEnabled(true);
                }
            });

            mListView5.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
                @Override
                public void onMenuOpen(int position) {
                    swipeRefreshLayout5.setEnabled(false);
                }

                @Override
                public void onMenuClose(int position) {
                    swipeRefreshLayout5.setEnabled(true);
                }
            });
            mListView1.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        int lastposition = mListView1.getLastVisiblePosition();//最后一个item的位置
                        if (lastposition == mListView1.getCount() - 1) {
                            isloadMore = true;
                            footview.setPadding(0, 0, 0, footheight);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    onLoadMore();
                                    footview.setPadding(0, -footheight, 0, 0);
                                    ToastUtil.showToast("加载完成");
                                }
                            }, 2000);
                        }
                    }
//                    if (mListView1 != null &&mListView1.getFirstVisiblePosition() == 0) {
//                        int mostposition = mListView1.getChildCount()>0 ? mListView1.getChildAt(0).getTop():0;
//                        if (mostposition >= 0){
//                            header.setPadding(0,headheight,0,0);
//                            onRefresh();
//                            header.setPadding(0,-headheight,0,0);
//                        }
//                    }

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

//                    boolean enable = false;
//                    if (mListView1 != null && mListView1.getChildCount() > 0) {
//                        // check if the first item of the list is visible
//                        boolean firstItemVisible = mListView1.getFirstVisiblePosition() == 0;
//                        // check if the top of the first item is visible
//                        boolean topOfFirstItemVisible = mListView1.getChildAt(0).getTop() == 0;
//                        // enabling or disabling the refresh layout
//                        enable = firstItemVisible && topOfFirstItemVisible;
//                    }
//                    swipeRefreshLayout.setEnabled(enable);

                }
            });
            mListView2.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        int lastposition = mListView2.getLastVisiblePosition();//最后一个item的位置
                        if (lastposition == mListView2.getCount() - 1) {
                            isloadMore = true;
                            footview.setPadding(0, 0, 0, footheight);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    onLoadMore();
                                    footview.setPadding(0, -footheight, 0, 0);
                                    ToastUtil.showToast("加载完成");
                                }
                            }, 2000);
                        }
                    }
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                    boolean enable = false;
//                    if (mListView2 != null && mListView2.getChildCount() > 0) {
//                        // check if the first item of the list is visible
//                        boolean firstItemVisible = mListView2.getFirstVisiblePosition() == 0;
//                        // check if the top of the first item is visible
//                        boolean topOfFirstItemVisible = mListView2.getChildAt(0).getTop() == 0;
//                        // enabling or disabling the refresh layout
//                        enable = firstItemVisible && topOfFirstItemVisible;
//                    }
//                    swipeRefreshLayout.setEnabled(enable);

                }
            });

            mListView3.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        int lastposition = mListView3.getLastVisiblePosition();//最后一个item的位置
                        if (lastposition == mListView3.getCount() - 1) {
                            isloadMore = true;
                            footview.setPadding(0, 0, 0, footheight);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    onLoadMore();
                                    footview.setPadding(0, -footheight, 0, 0);
                                    ToastUtil.showToast("加载完成");
                                }
                            }, 2000);
                        }
                    }
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                    boolean enable = false;
//                    if (mListView3 != null && mListView3.getChildCount() > 0) {
//                        // check if the first item of the list is visible
//                        boolean firstItemVisible = mListView3.getFirstVisiblePosition() == 0;
//                        // check if the top of the first item is visible
//                        boolean topOfFirstItemVisible = mListView3.getChildAt(0).getTop() == 0;
//                        // enabling or disabling the refresh layout
//                        enable = firstItemVisible && topOfFirstItemVisible;
//                    }
//                    swipeRefreshLayout.setEnabled(enable);

                }
            });

            mListView4.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        int lastposition = mListView4.getLastVisiblePosition();//最后一个item的位置
                        if (lastposition == mListView4.getCount() - 1) {
                            isloadMore = true;
                            footview.setPadding(0, 0, 0, footheight);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    onLoadMore();
                                    footview.setPadding(0, -footheight, 0, 0);
                                    ToastUtil.showToast("加载完成");
                                }
                            }, 2000);
                        }
                    }
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                    boolean enable = false;
//                    if (mListView4 != null && mListView4.getChildCount() > 0) {
//                        // check if the first item of the list is visible
//                        boolean firstItemVisible = mListView4.getFirstVisiblePosition() == 0;
//                        // check if the top of the first item is visible
//                        boolean topOfFirstItemVisible = mListView4.getChildAt(0).getTop() == 0;
//                        // enabling or disabling the refresh layout
//                        enable = firstItemVisible && topOfFirstItemVisible;
//                    }
//                    swipeRefreshLayout.setEnabled(enable);

                }
            });
            mListView5.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        int lastposition = mListView5.getLastVisiblePosition();//最后一个item的位置
                        if (lastposition == mListView5.getCount() - 1) {
                            isloadMore = true;
                            footview.setPadding(0, 0, 0, footheight);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    onLoadMore();
                                    footview.setPadding(0, -footheight, 0, 0);
                                    ToastUtil.showToast("加载完成");
                                }
                            }, 2000);
                        }
                    }
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                    boolean enable = false;
//                    if (mListView5 != null && mListView5.getChildCount() > 0) {
//                        // check if the first item of the list is visible
//                        boolean firstItemVisible = mListView5.getFirstVisiblePosition() == 0;
//                        // check if the top of the first item is visible
//                        boolean topOfFirstItemVisible = mListView5.getChildAt(0).getTop() == 0;
//                        // enabling or disabling the refresh layout
//                        enable = firstItemVisible && topOfFirstItemVisible;
//                    }
//                    swipeRefreshLayout.setEnabled(enable);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        swipeRefreshLayout1.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipeRefreshLayout2.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipeRefreshLayout3.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipeRefreshLayout4.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipeRefreshLayout5.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);

        left_onclick();
        main_onclick();

    }


    @Override
    protected void onResume() {
        super.onResume();
        checkNetwork();
    }

    /**
     * 设置监听
     */
    private void setListener() {
        swipeRefreshLayout1.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout1.setRefreshing(true);
                uploadNew();
//                swipeRefreshLayout1.setRefreshing(false);
//                showmore_daiban();

//                ToastUtil.showToast("刷新完成");
            }
        });
        swipeRefreshLayout2.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout2.setRefreshing(true);
                uploadNew();
//                swipeRefreshLayout2.setRefreshing(false);
            }
        });
        swipeRefreshLayout3.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout3.setRefreshing(true);
                uploadNew();
//                swipeRefreshLayout3.setRefreshing(false);
            }
        });
        swipeRefreshLayout4.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout4.setRefreshing(true);
                uploadNew();
//                swipeRefreshLayout4.setRefreshing(false);
            }
        });
        swipeRefreshLayout5.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout5.setRefreshing(true);
                uploadNew();
//                swipeRefreshLayout5.setRefreshing(false);
            }
        });
    }

    private boolean checkNetwork() {
        if (!NetworkUtils.checkNetwork(this)) {
            ToastUtil.showToast("手机无可用网络");
        }
        return true;
    }

    //初始化控件
    private void initview() {

        toobar_title = (TextView) findViewById(R.id.toobar_title);
        toobar_right_view = (ImageButton) findViewById(R.id.toobar_rightView);
        toolbar = (Toolbar) findViewById(R.id.tb_comn);
        //侧栏
        mDrawerLayout = (DrawerLayout) findViewById(R.id.layout);
        lvLeftMenu = (LinearLayout) findViewById(R.id.lv_left_menu);
        person_name = (TextView) findViewById(R.id.persion_name);
        person_photo = (ImageView) findViewById(R.id.persion_photo);
        daiban_layout = (LinearLayout) findViewById(R.id.daiban);
        yiban_layout = (LinearLayout) findViewById(R.id.yiban);
        xiafa_layout = (LinearLayout) findViewById(R.id.xiafa);
        chexiao_layout = (LinearLayout) findViewById(R.id.chexiao);
        zhanting_layout = (LinearLayout) findViewById(R.id.zhanting);

        daiban_red = (ImageView) findViewById(R.id.daiban_red);
        yiban_red = (ImageView) findViewById(R.id.yiban_red);
        xiafa_red = (ImageView) findViewById(R.id.xiafa_red);
        chexiao_red = (ImageView) findViewById(R.id.chexiao_red);
        zhanting_red = (ImageView) findViewById(R.id.zhanting_red);
        tuichu = (LinearLayout) findViewById(R.id.exit);

        //swipmenulistview
//        mListView1 = (SlideListView2) findViewById(R.id.swiplistView1);
//        mRecyclerView = (LRecyclerView) findViewById(R.id.lrecycleview);
        mListView1 = (SwipeMenuListView) findViewById(R.id.swiplistView1);
        mListView2 = (SwipeMenuListView) findViewById(R.id.swiplistView2);
        mListView3 = (SwipeMenuListView) findViewById(R.id.swiplistView3);
        mListView4 = (SwipeMenuListView) findViewById(R.id.swiplistView4);
        mListView5 = (SwipeMenuListView) findViewById(R.id.swiplistView5);

        Lj_but = (LinearLayout) findViewById(R.id.lingjian_but);
        OA_but = (LinearLayout) findViewById(R.id.oa_but);
        Lj_icon = (ImageView) findViewById(R.id.Lj_icon);
        OA_icon = (ImageView) findViewById(R.id.oa_icon);
        Lj_text = (TextView) findViewById(R.id.Lj_text);
        OA_text = (TextView) findViewById(R.id.oa_text);


        addrenwu_bt = (LinearLayout) findViewById(R.id.add_renwu);
        //下拉刷新
//        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout1 = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout1);
        swipeRefreshLayout2 = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout2);
        swipeRefreshLayout3 = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout3);
        swipeRefreshLayout4 = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout4);
        swipeRefreshLayout5 = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout5);
        mainlistandadd = (RelativeLayout) findViewById(R.id.mainlistandadd);
//        header = View.inflate(MainActivity.this,R.layout.listview_header,null);

        footview = View.inflate(MainActivity.this, R.layout.listview_footer, null);
        //以前的listview
//        listView_main = (SlideListView2) findViewById(R.id.listview_main);
//        listView_main.initSlideMode(SlideListView2.MOD_RIGHT);

        //toobar
        toolbar.setNavigationIcon(R.drawable.title_but_left3x);//图标
        toobar_title.setText(R.string.renwuguanli_daiban);//标题
        setSupportActionBar(toolbar);
        //获取开关同时让开关和DrawerLayout关联在一起
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置默认的标题不显示
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //设置点击事件，点击弹出menu界面
        mDrawerLayout.setDrawerListener(toggle);


//        listView_main.setSelection(android.R.color.transparent);
        mListView1.setDividerHeight(0);//去掉分割线
        mListView1.setCacheColorHint(0);
        mListView2.setDividerHeight(0);//去掉分割线
        mListView2.setCacheColorHint(0);
        mListView3.setDividerHeight(0);//去掉分割线
        mListView3.setCacheColorHint(0);
        mListView4.setDividerHeight(0);//去掉分割线
        mListView4.setCacheColorHint(0);
        mListView5.setDividerHeight(0);//去掉分割线
        mListView5.setCacheColorHint(0);

        no_renwuphoto = (ImageView) findViewById(R.id.no_renwuphoto);
        centerDialog = new CenterDialog(MainActivity.this,R.layout.dialog_layout,new int[]{R.id.dialog_cancel, R.id.dialog_sure});

        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                checkRedShow();
                LogUtil.d("开---","了---");

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                LogUtil.d("关---","了---");
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

//        radioGroup = (RadioGroup) findViewById(R.id.bootombutton);
//
        FragmentManager fr = getSupportFragmentManager();
        FragmentTransaction ft = fr.beginTransaction();
        centerfragment = new OA_centerfragment();
        ft.add(R.id.oa_fragment,centerfragment).hide(centerfragment).commit();

        Lj_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setVisibility(View.VISIBLE);
                mainlistandadd.setVisibility(View.VISIBLE);
                isOA = 1;
//                addrenwu_bt.setClickable(true);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                FragmentManager fr = getSupportFragmentManager();
                FragmentTransaction ft = fr.beginTransaction();
                ft.hide(centerfragment).commit();

                Lj_text.setTextColor(getResources().getColor(R.color.white));
                Lj_icon.setImageResource(R.drawable.tab_renwuguanli_pre);
//                Lj_but.setBackgroundResource(R.color.tab1);

//                OA_but.setBackgroundResource(R.color.tab2);
                OA_icon.setImageResource(R.drawable.tab_oaofficework_nor);
                OA_text.setTextColor(getResources().getColor(R.color.tab1));
            }
        });

        OA_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setVisibility(View.GONE);
                mainlistandadd.setVisibility(View.GONE);
                isOA = 2;
//                addrenwu_bt.setClickable(false);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                FragmentManager fr2 = getSupportFragmentManager();
                FragmentTransaction ft2 = fr2.beginTransaction();
                ft2.show(centerfragment).commit();


//                OA_but.setBackgroundResource(R.color.tab1);
                OA_icon.setImageResource(R.drawable.tab_oaofficework_pre);
                OA_text.setTextColor(getResources().getColor(R.color.white));

                Lj_text.setTextColor(getResources().getColor(R.color.tab1));
                Lj_icon.setImageResource(R.drawable.tab_renwuguanli_nor);
//                Lj_but.setBackgroundResource(R.color.tab2);
            }
        });


//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId){
//                    case R.id.lingjian:
//                        FragmentManager fr = getSupportFragmentManager();
//                        FragmentTransaction ft = fr.beginTransaction();
//                        ft.hide(centerfragment).commit();
//                        break;
//                    case R.id.OA:
//        FragmentManager fr2 = getSupportFragmentManager();
//        FragmentTransaction ft2 = fr2.beginTransaction();
//        ft2.show(centerfragment).commit();
//                        break;
//
//                }
//            }
//        });


//        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
//
//        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING)
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//
//        bottomNavigationBar
//                .setActiveColor(R.color.button_login_color)
//                .setInActiveColor("#8e8e8e")
//                .setBarBackgroundColor("#ECECEC");
//
//
//        bottomNavigationBar
//                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp,"令箭"))
//                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,"OA"))
////                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp,"Music"))
////                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp,"TV"))
//                .initialise();
//
////        bottomNavigationBar.setAutoHideEnabled(true);
//        bottomNavigationBar
//                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
//                    @Override
//                    public void onTabSelected(int position) {
//
//                        switch (position){
//
//                            case 0:
//                                ToastUtil.showToast("竟让有这种操作！");
//
//                                break;
//                            case 1:
//                                ToastUtil.showToast("真的有这种操作！");
//                                Intent i = new Intent(MainActivity.this,HomeActivity.class);
//                                startActivity(i);
//                                break;
////                            case 2:
////                                ToastUtil.showToast("这是假的操作！");
////
////                                break;
////                            case 3:
////                                ToastUtil.showToast("红红火火恍恍惚惚！");
////
////                                break;
//
//                        }
//                    }
//
//                    @Override
//                    public void onTabUnselected(int position) {
//
//                    }
//
//                    @Override
//                    public void onTabReselected(int position) {
//
//                    }
//                });

    }

//    /**
//     * 返回当前程序版本名  build.gradle
//     */
//    public  String getAppVersionName(Context context) {
//        try {
//            // ---get the package info---
//            PackageManager pm = context.getPackageManager();
//            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
//            versionName = pi.versionName;
//            versioncode = pi.versionCode;
//            LogUtil.d("versionName:---"+versionName,"versioncode:---"+versioncode);
//            if (versionName == null || versionName.length() <= 0) {
//                return "";
//            }
//        } catch (Exception e) {
//            Log.e("VersionInfo", "Exception", e);
//        }
//        return versionName;
//    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent3 messageEvent){
       String url = messageEvent.getMessage();
        if (url!= null){
            LogUtil.d("图片url--",url+"");
            Glide.with(MainActivity.this).load(url).diskCacheStrategy(DiskCacheStrategy.RESULT).into(person_photo);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent2(MessageEvent4 messageEvent){
        String flash = messageEvent.getMessage();
        if (flash.equals("flash")){
            showmore_daiban();
        }
    }

    //初始化数据
    private void initData() {
        EventBus.getDefault().register(MainActivity.this);
        userid = SharedPreferencesUtil.readUserid(MainActivity.this);

        String s = SharedPreferencesUtil.readAvatar(MainActivity.this);
        String m = SharedPreferencesUtil.readUsername(MainActivity.this);
        if (s != null) {
            Glide.with(MainActivity.this).load(s).diskCacheStrategy(DiskCacheStrategy.RESULT).into(person_photo);
        }
        if (m != null) {

            person_name.setText(m);
        }


            //读取未读消息 小红点
        checkRedShow();
        try {
            //上来默认展示待办
            //网络请求
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", 15)
                    .params("userid", userid)
                    .params("status", 3)
                    .params("sort", 1)
                    .execute(new StringDialogCallback(MainActivity.this) {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("json-----", s);
                            ToastUtil.showToast("联网成功");
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            list1 = shoudaorenwu.getList();
                            if (list1!=null){
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有任务");
                                no_renwuphoto.setVisibility(View.VISIBLE);
                            }
                        }
                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            ToastUtil.showToast("联网失败");
                        }
                    });

            mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                    LogUtil.d("imageview--red-",""+red);
                    red.setVisibility(View.INVISIBLE);

                    data1 = list1.get(position);
                    //点击item进入 任务详情页
                    Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                    taskid = data1.getTaskid();
                    haha = data1.getProgress();
                    SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                    intent.putExtra("taskname", data1.getTaskname());
                    intent.putExtra("taskid1", taskid);
                    intent.putExtra("userid1", userid);
                    intent.putExtra("progress", haha);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        //假数据
        hehe.add("hehe");
        hehe.add("a");
        hehe.add("b");
        hehe.add("c");
        hehe.add("d");
        hehe.add("e");
        hehe.add("f");
        hehe.add("g");

    }

    private void checkRedShow() {
        try {
            OkHttpUtils.get(Http_Api.URL_Weidu)
                    .params("userid",userid)
                    .params("readed",0)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            chaxunweidu = JsonUtil.parseJsonToBean(s,Data_chaxunweidu.class);
                            daibanred = chaxunweidu.getDaiban();
                            yibanred = chaxunweidu.getYiban();
                            xiafared = chaxunweidu.getXiafa();
                            zantingred = chaxunweidu.getZanting();
                            if (daibanred>0){
                                daiban_red.setVisibility(View.VISIBLE);
                            }else {
                                daiban_red.setVisibility(View.INVISIBLE);
                            }
                            if (yibanred>0){
                                yiban_red.setVisibility(View.VISIBLE);
                            }else {
                                yiban_red.setVisibility(View.INVISIBLE);
                            }
                            if (xiafared>0){
                                xiafa_red.setVisibility(View.VISIBLE);
                            }else {
                                xiafa_red.setVisibility(View.INVISIBLE);
                            }
                            if (zantingred>0){
                                zhanting_red.setVisibility(View.VISIBLE);
                            }else {
                                zhanting_red.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    //右栏点击事件
    private void main_onclick() {

        try {
            toobar_right_view.setImageResource(R.drawable.title_but_right3x);

            //统计
            toobar_right_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                ToastUtil.showToast("查询");
                    showPopMenu();
                }
            });
            //新增
            addrenwu_bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isOA == 1){
                        final BottomPopupOption bottomPopupOption = new BottomPopupOption(MainActivity.this);
                        amin = SharedPreferencesUtil.readAdmin(MainActivity.this);
                        type = SharedPreferencesUtil.readType(MainActivity.this);
                        autherid = SharedPreferencesUtil.readAutherid(MainActivity.this);
                        //普通员工
                        if (amin == 0 && type == 0) {
                            bottomPopupOption.setItemText("上司下发", "派给自己");
                            bottomPopupOption.showPopupWindow();
                            bottomPopupOption.setWindowAlpa(true);
                            bottomPopupOption.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    switch (position) {
                                        case 0:
                                            //上司下发
                                            Intent intent = new Intent(MainActivity.this, Activity_add_renwu.class);
                                            startActivity(intent);
                                            bottomPopupOption.dismiss();
                                            break;
                                        case 1:
                                            //派给自己
                                            Intent intent2 = new Intent(MainActivity.this, Activity_addto_youself.class);
                                            startActivity(intent2);
                                            bottomPopupOption.dismiss();
                                            break;
                                    }
                                }
                            });
                            //中层领导
                        } else if (amin == 0 && type == 1 && autherid.equals("")) {
                            bottomPopupOption.setItemText("上司下发", "派给自己", "派给下属");
                            bottomPopupOption.showPopupWindow();
                            bottomPopupOption.setWindowAlpa(true);
                            bottomPopupOption.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    switch (position) {
                                        case 0:
                                            //上司下发
                                            Intent intent = new Intent(MainActivity.this, Activity_add_renwu.class);
                                            startActivity(intent);
                                            bottomPopupOption.dismiss();
                                            break;
                                        case 1:
                                            //派给自己
                                            Intent intent2 = new Intent(MainActivity.this, Activity_addto_youself.class);
                                            startActivity(intent2);
                                            bottomPopupOption.dismiss();
                                            break;
                                        //派给下属
                                        case 2:
                                            Intent intent3 = new Intent(MainActivity.this, Activity_xiafa.class);
                                            startActivity(intent3);
                                            bottomPopupOption.dismiss();

                                            break;

                                    }
                                }
                            });
                            //大领导
                        } else if (amin == 2) {
                            bottomPopupOption.setItemText("派给自己", "派给下属");
                            bottomPopupOption.showPopupWindow();
                            bottomPopupOption.setWindowAlpa(true);
                            bottomPopupOption.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    switch (position) {
                                        case 0:
                                            //派给自己
                                            Intent intent2 = new Intent(MainActivity.this, Activity_addto_youself.class);
                                            startActivity(intent2);
                                            bottomPopupOption.dismiss();
                                            break;
                                        //派给下属
                                        case 1:
                                            Intent intent3 = new Intent(MainActivity.this, Activity_xiafa.class);
                                            startActivity(intent3);
                                            bottomPopupOption.dismiss();

                                            break;
                                    }
                                }
                            });
                            //授权
                        } else if (amin == 0 && type == 1 && autherid != null && !autherid.equals("")) {
                            bottomPopupOption.setItemText("上司下发", "派给自己", "派给下属", "代上司下发");
                            bottomPopupOption.showPopupWindow();
                            bottomPopupOption.setWindowAlpa(true);
                            bottomPopupOption.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    switch (position) {
                                        case 0:
                                            //上司下发
                                            Intent intent = new Intent(MainActivity.this, Activity_add_renwu.class);
                                            startActivity(intent);
                                            bottomPopupOption.dismiss();
                                            break;
                                        case 1:
                                            //派给自己
                                            Intent intent2 = new Intent(MainActivity.this, Activity_addto_youself.class);
                                            startActivity(intent2);
                                            bottomPopupOption.dismiss();
                                            break;
                                        //派给下属
                                        case 2:
                                            Intent intent3 = new Intent(MainActivity.this, Activity_xiafa.class);
                                            startActivity(intent3);
                                            bottomPopupOption.dismiss();

                                            break;
                                        //代上司下发
                                        case 3:

                                            Intent intent4 = new Intent(MainActivity.this, Activity_daishangxiafa.class);
                                            startActivity(intent4);
                                            bottomPopupOption.dismiss();
                                            break;
                                    }
                                }
                            });
                            //授权普通员工
                        } else if (amin == 0 && type == 0 && autherid != null && !autherid.equals("")) {
                            bottomPopupOption.setItemText("上司下发", "派给自己", "代上司下发");
                            bottomPopupOption.showPopupWindow();
                            bottomPopupOption.setWindowAlpa(true);
                            bottomPopupOption.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    switch (position) {
                                        case 0:
                                            //上司下发
                                            Intent intent = new Intent(MainActivity.this, Activity_add_renwu.class);
                                            startActivity(intent);
                                            bottomPopupOption.dismiss();
                                            break;
                                        case 1:
                                            //派给自己
                                            Intent intent2 = new Intent(MainActivity.this, Activity_addto_youself.class);
                                            startActivity(intent2);
                                            bottomPopupOption.dismiss();
                                            break;

                                        //代上司下发
                                        case 2:

                                            Intent intent4 = new Intent(MainActivity.this, Activity_daishangxiafa.class);
                                            startActivity(intent4);
                                            bottomPopupOption.dismiss();
                                            break;
                                    }
                                }
                            });
                        }
                    }else if (isOA == 2){

                        bottomPopupOption2 = new BottomPopupOption(MainActivity.this);
                        bottomPopupOption2.setItemText("工单申请");
                        bottomPopupOption2.showPopupWindow();
                        bottomPopupOption2.setWindowAlpa(true);
                        bottomPopupOption2.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                if (position==0){
                                    Intent intent = new Intent(MainActivity.this, Activity_oagdshenqing.class);
                                    startActivity(intent);
                                    bottomPopupOption2.dismiss();
                                }
                            }
                        });
                    }


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //展示弹窗 popuwindow 为底部弹出的窗口进行按钮的监听。
    private void showPopMenu() {
        //弹窗与虚拟键重合
//        popMenus.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        popMenus = new PhotoPopupWindows(MainActivity.this, myMenusOnClick);
        popMenus.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private View.OnClickListener myMenusOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popMenus.dismiss();
            switch (v.getId()) {
                //图表统计
                case R.id.tubiaotongji:
                ShowChoseTime();
                    break;
                //任务搜索
                case R.id.renwusousu:
                ShowSearch();
                    break;
                //排序
                case R.id.paixu:
                ShowPaixu();
                    break;
            }

        }
    };
    //显示时间弹窗
    private void ShowChoseTime() {
         popMenus2 = new TubiaoPopupWindows(MainActivity.this, myMenusOnClick2);
        popMenus2.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }
    private String pickstarttime,pickendtime;
    private String pickstarttimet,pickendtimet;
    private View.OnClickListener myMenusOnClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                //开始时间
                case R.id.starttime:
                    popMenus2.dismiss();
                    TimePickerView pvTime = new TimePickerView.Builder(MainActivity.this, new TimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date2, View v) {//选中事件回调
                            pickstarttimet = getTime(date2);
                            pickstarttime = getTime2(date2);
                            popMenus2.getStartview().setText(pickstarttimet);
                            popMenus2.update();
                            popMenus2.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                                    Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                        }
                    })
                            .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                            .setCancelText("取消")//取消按钮文字
                            .setSubmitText("确定")//确认按钮文字
                            .setContentSize(20)//滚轮文字大小
                            .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                            .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                            .isCyclic(true)//是否循环滚动
                            .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                            .setTitleColor(Color.BLACK)//标题文字颜色
                            .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                            .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
//                        .setLabel("年","月","日","时","分","秒")
                            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                            .build();
                    pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                    pvTime.show();
                    break;
                //结束时间
                case R.id.endtime:
                    popMenus2.dismiss();
                    TimePickerView pvTime2 = new TimePickerView.Builder(MainActivity.this, new TimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date2, View v) {//选中事件回调
                            pickendtimet = getTime(date2);
                            pickendtime = getTime2(date2);
                            popMenus2.getEndview().setText(pickendtimet);
                            popMenus2.update();
                            popMenus2.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                                    Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                        }
                    })
                            .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                            .setCancelText("取消")//取消按钮文字
                            .setSubmitText("确定")//确认按钮文字
                            .setContentSize(20)//滚轮文字大小
                            .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                            .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                            .isCyclic(true)//是否循环滚动
                            .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                            .setTitleColor(Color.BLACK)//标题文字颜色
                            .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                            .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
//                        .setLabel("年","月","日","时","分","秒")
                            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                            .build();
                    pvTime2.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                    pvTime2.show();
                    break;
                //查询
                case R.id.chaxun:
                    if (pickstarttime == null||pickendtime==null){
                        ToastUtil.showToast("开始时间/结束时间不能为空");
                        return;
                    }
                    popMenus2.dismiss();
                    Intent intent = new Intent(MainActivity.this,Activity_tubiao.class);
                    intent.putExtra("starttime",pickstarttime);
                    intent.putExtra("endtime",pickendtime);
                    LogUtil.d("传的时间---",pickstarttime+"---"+pickendtime);
                    startActivity(intent);
                    break;
            }

        }
    };

    public String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
    }
    public String getTime2(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    //显示排序弹窗
    private void ShowPaixu() {

        popMenus3 = new PaixuPopupWindows(MainActivity.this, myMenusOnClick3);
        popMenus3.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private View.OnClickListener myMenusOnClick3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popMenus3.dismiss();
            switch (v.getId()) {
                //发布时间排序
                case R.id.fabutime:
                ShowUp_Down();
                    break;
                //剩余时间排序
                case R.id.shengyutime:
                ShowUp_Down2();
                    break;
            }

        }
    };

    //发布时间排序  显示上下排序弹窗
    private void ShowUp_Down() {
        popMenus4 = new Up_DownPopupWindows(MainActivity.this, myMenusOnClick4);
        popMenus4.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }
    private View.OnClickListener myMenusOnClick4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popMenus4.dismiss();
            switch (v.getId()) {
                //发布时间升序
                case R.id.shengxu:
                    faTimeUpTag = 1;

                    ToastUtil.showToast("升序");
                    LogUtil.d("发布时间升序---","升序");
                    //待办
                    if (i == 1){
                        daibanUp1();
//                        showmore_daiban2(3,3,1);
                   //已办
                    }else if (i==2){
                        yibanUp1();
//                        showmore_yiban2(3,4,1);
                    //下发
                    }else if (i==3){
                        xiafaUp1();
//                        showmore_xiafa2(3,4,1);
                    //撤销
                    }else if (i==4){
                        chexiaoUp1();
//                        showmore_chexiao2(3,5,1);
                     //暂停
                    }else if (i==5){
                        zhantingUp1();
//                        showmore_zhanting2(3,6,1);
                    }

                    break;
                //发布时间降序
                case R.id.jiangxu:
                    faTimeUpTag = 1;

                    ToastUtil.showToast("降序");
                    LogUtil.d("发布时间降序---","降序序");
                    //待办
                    if (i == 1){
                        daibanDown1();
//                        showmore_daiban2(1,3,1);
                        //已办
                    }else if (i==2){
                        yibanDown1();
//                        showmore_yiban2(1,4,1);
                        //下发
                    }else if (i==3){
                        xiafaDown1();
//                        showmore_xiafa2(1,4,1);
                        //撤销
                    }else if (i==4){
                        chexiaoDown1();
//                        showmore_chexiao2(1,5,1);
                        //暂停
                    }else if (i==5){
                        zhantingDown1();
//                        showmore_zhanting2(1,6,1);
                    }
                    break;

            }

        }
    };

    //剩余时间排序  显示上下排序弹窗
    private void ShowUp_Down2() {

        popMenus4 = new Up_DownPopupWindows(MainActivity.this, myMenusOnClick8);
        popMenus4.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private View.OnClickListener myMenusOnClick8 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popMenus4.dismiss();
            switch (v.getId()) {
                //剩余时间升序
                case R.id.shengxu:
                    lessTimeUp = 1;
                    ToastUtil.showToast("升序");
                    LogUtil.d("剩余时间升序---","升序");
                    if (i==1){
                        daibanUp2();
//                        showmore_daiban2(6,3,1);
                    }else if (i==2){
                        yibanUp2();
//                        showmore_daiban2(6,4,1);
                    }else if (i==3){
                        xiafaUp2();
//                        showmore_xiafa2(6,4,1);
                    }else if (i==4){
                        chexiaoUp2();
//                        showmore_chexiao2(6,5,1);
                    }else if (i==5){
                        zhantingUp2();
//                        showmore_zhanting2(6,6,1);
                    }

                    break;
                //剩余时间降序
                case R.id.jiangxu:
                    lessTimeDown = 1;

                    ToastUtil.showToast("降序");
                    LogUtil.d("剩余时间降序---","降序");
                    if (i==1){
                        daibanUp2();
//                        showmore_daiban2(5,3,1);
                    }else if (i==2){
                        yibanUp2();
//                        showmore_daiban2(5,4,1);
                    }else if (i==3){
                        xiafaUp2();
//                        showmore_xiafa2(5,4,1);
                    }else if (i==4){
                        chexiaoUp2();
//                        showmore_chexiao2(5,5,1);
                    }else if (i==5){
                        zhantingUp2();
//                        showmore_zhanting2(5,6,1);
                    }
                    break;
            }

        }
    };

    //搜索任务
    private void ShowSearch() {

        popMenus5 = new SearchPopupWindows(MainActivity.this, myMenusOnClick5);
        popMenus5.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private View.OnClickListener myMenusOnClick5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popMenus5.dismiss();
            switch (v.getId()) {
                //发布时间搜索
                case R.id.serchstartime:
                    ShowChoseTime2();
                    break;
                //结束时间搜索
                case R.id.serchendtime:
                    ShowChoseTime3();
                    break;
                //文本搜索
                case R.id.serchtext:
                    SearchText();
                    break;
            }

        }
    };

    //显示时间弹窗
    private void ShowChoseTime2() {
        popMenus7 = new TimePickerPopupWindows(MainActivity.this, myMenusOnClick6);
        popMenus7.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }
    private String pickstarttime2;
    private String pickstarttime2t;
    private View.OnClickListener myMenusOnClick6 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                //开始时间
                case R.id.starttime1:
                    popMenus7.dismiss();
                    TimePickerView pvTime3 = new TimePickerView.Builder(MainActivity.this, new TimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date2, View v) {//选中事件回调
                            pickstarttime2t = getTime(date2);
                            pickstarttime2 = getTime2(date2);
                            LogUtil.d("选择开始时间--",pickstarttime2+"---");
                            popMenus7.getStartview().setText(pickstarttime2t);
                            popMenus7.update();
                            popMenus7.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                                    Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                        }
                    })
                            .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                            .setCancelText("取消")//取消按钮文字
                            .setSubmitText("确定")//确认按钮文字
                            .setContentSize(20)//滚轮文字大小
                            .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                            .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                            .isCyclic(true)//是否循环滚动
                            .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                            .setTitleColor(Color.BLACK)//标题文字颜色
                            .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                            .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
//                        .setLabel("年","月","日","时","分","秒")
                            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                            .build();
                    pvTime3.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                    pvTime3.show();
                    break;

                case R.id.chaxun1:

                    if (pickstarttime2==null){
                        ToastUtil.showToast("发布时间不能为空");
                        return;
                    }
                    popMenus7.dismiss();
                    if (i == 1){
                        daibanStartSearch(pickstarttime2);
                    }else if (i == 2){
                        yibanStartSearch(pickstarttime2);
                    }else if (i ==3){
                        xiafaStartSearch(pickstarttime2);
                    }else if (i ==4){
                        chexiaoStartSearch(pickstarttime2);
                    }else if (i==5){
                        zhantingStartSearch(pickstarttime2);
                    }

                    break;
            }

        }
    };

    //显示结束时间弹窗
    private void ShowChoseTime3() {
        popMenus8 = new TimePickerPopupWindows2(MainActivity.this, myMenusOnClick7);
        popMenus8.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }
    private String pickendtime3,pickendtime3t;
    private View.OnClickListener myMenusOnClick7 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //结束时间
                case R.id.endtime1:
                    popMenus8.dismiss();
                    TimePickerView pvTime6 = new TimePickerView.Builder(MainActivity.this, new TimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date2, View v) {//选中事件回调
                            pickendtime3t = getTime(date2);
                            pickendtime3 = getTime2(date2);
                            LogUtil.d("选择结束时间--",pickendtime3+"---");
                            popMenus8.getEndview().setText(pickendtime3t);
                            popMenus8.update();
                            popMenus8.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                                    Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                            LogUtil.d("选择开始时间对象----",popMenus8.getEndview()+"---");
                        }
                    })
                            .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                            .setCancelText("取消")//取消按钮文字
                            .setSubmitText("确定")//确认按钮文字
                            .setContentSize(20)//滚轮文字大小
                            .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                            .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                            .isCyclic(true)//是否循环滚动
                            .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                            .setTitleColor(Color.BLACK)//标题文字颜色
                            .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                            .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
//                        .setLabel("年","月","日","时","分","秒")
                            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                            .build();
                    pvTime6.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                    pvTime6.show();
                    break;
                //查询
                case R.id.chaxun2:

                    if (pickendtime3 == null){
                        ToastUtil.showToast("结束时间不能为空");
                        return;
                  }
                    popMenus8.dismiss();
                    if (i ==1){
                        daibanEndSearch(pickendtime3);
                    }else if (i ==2){
                        yibanEndSearch(pickendtime3);
                    }else if (i ==3){
                        xiafaEndSearch(pickendtime3);
                    }else if (i ==4){
                        chexiaoEndSearch(pickendtime3);
                    }else if (i ==5){
                        zhantingEndSearch(pickendtime3);
                    }

                    break;
            }

        }
    };

    //按文本搜索任务
    private void SearchText() {

        popMenus6 = new SearchTextPopupWindows(MainActivity.this, myMenusOnClick9);
        popMenus6.showAtLocation(MainActivity.this.findViewById(R.id.main_layout),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }
    private String searchtext;
    private View.OnClickListener myMenusOnClick9 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //文本搜索
                case R.id.makesure:
                    searchtext = popMenus6.getSearchView().getText().toString().trim();
                    if (searchtext.isEmpty()){
                        ToastUtil.showToast("任务名不能为空");
                        return;
                    }
                    LogUtil.d("搜索的文本是---",searchtext+"");
                    popMenus6.dismiss();
                    if (i ==1){
                        daibanSearchText(searchtext);
                    }else if (i==2){
                        yibanSearchText(searchtext);
                    }else if (i==3){
                        xiafaSearchText(searchtext);
                    }else if (i==4){
                        chexiaoSearchText(searchtext);
                    }else if (i==5){
                        zhantingSearchText(searchtext);
                    }

                    break;
            }

        }
    };

    //侧栏点击事件
    private void left_onclick() {
        //个人中心
        try {
            person_photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Activity_persion_X.class);
                    startActivity(intent);
                }
            });
            //待办
            daiban_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListView1.setVisibility(View.VISIBLE);
                    mListView2.setVisibility(View.INVISIBLE);
                    mListView3.setVisibility(View.INVISIBLE);
                    mListView4.setVisibility(View.INVISIBLE);
                    mListView5.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout1.setVisibility(View.VISIBLE);
                    swipeRefreshLayout2.setVisibility(View.GONE);
                    swipeRefreshLayout3.setVisibility(View.GONE);
                    swipeRefreshLayout4.setVisibility(View.GONE);
                    swipeRefreshLayout5.setVisibility(View.GONE);
                    i = 1;

                    toobar_title.setText(R.string.renwuguanli_daiban);
                    //网络请求
                    daiban_http();
                    mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                            red.setVisibility(View.INVISIBLE);
                            data1 = list1.get(position);
                            //点击item进入 任务详情页
                            Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                            taskid = data1.getTaskid();
                            haha = data1.getProgress();
                            SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                            LogUtil.d("初始化的进度呵呵---", haha + "--");
                            intent.putExtra("taskname", data1.getTaskname());
                            intent.putExtra("taskid1", taskid);
                            intent.putExtra("userid1", userid);
                            intent.putExtra("progress", haha);
                            startActivity(intent);
                        }
                    });
                    mDrawerLayout.closeDrawer(lvLeftMenu);

                }

                private void daiban_http() {
                    try {
                        OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                                .params("pn", 1)
                                .params("size", 10)
                                .params("status", 3)
                                .params("userid", userid)
                                .params("sort", 1)
                                .params("type",1)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        LogUtil.d("json-----", s);
                                        shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                                        list1 = shoudaorenwu.getList();
                                        if (list1 != null&&list1.size()>0) {
                                            no_renwuphoto.setVisibility(View.GONE);
                                            list1 = shoudaorenwu.getList();
                                            LogUtil.d("集合长度----",list1.size()+"==");
                                            slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                            mListView1.setAdapter(slideAdapter1);
                                            slideAdapter1.notifyDataSetChanged();

                                        } else {
                                            ToastUtil.showToast("对不起，没有任务");
                                            no_renwuphoto.setVisibility(View.VISIBLE);

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
            });
            //已办
            yiban_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListView2.setVisibility(View.VISIBLE);
                    mListView1.setVisibility(View.INVISIBLE);
                    mListView3.setVisibility(View.INVISIBLE);
                    mListView4.setVisibility(View.INVISIBLE);
                    mListView5.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout1.setVisibility(View.GONE);
                    swipeRefreshLayout2.setVisibility(View.VISIBLE);
                    swipeRefreshLayout3.setVisibility(View.GONE);
                    swipeRefreshLayout4.setVisibility(View.GONE);
                    swipeRefreshLayout5.setVisibility(View.GONE);
                    i = 2;

                    toobar_title.setText(R.string.renwuguanli_yiban);
                    yiban_http();
                    mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                            red.setVisibility(View.INVISIBLE);
                            data2 = list2.get(position);
                            //点击item进入 任务详情页
                            Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                            taskid2 = data2.getTaskid();
                            prooo = data2.getProgress();
                            SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                            intent.putExtra("taskname", data2.getTaskname());
                            intent.putExtra("taskid2", taskid2);
                            intent.putExtra("userid2", userid);
                            intent.putExtra("prooo", prooo);
                            startActivity(intent);
                        }
                    });
                    mDrawerLayout.closeDrawer(lvLeftMenu);
                }

                private void yiban_http() {
                    try {
                        OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                                .params("pn", 1)
                                .params("userid", userid)
                                .params("size", 10)
                                .params("sort", 1)
                                .params("status", 4)
                                .params("type",1)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                                        list2 = wanchengrenwu.getList();
                                        if (list2 != null&&list2.size()>0) {
                                            no_renwuphoto.setVisibility(View.GONE);
//                                            ToastUtil.showToast("已办任务");
                                            LogUtil.d("获取完成任务信息--->>", s);
                                            LogUtil.d("完成任务列表-------", wanchengrenwu + "");
                                            list2 = wanchengrenwu.getList();
                                            slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                            mListView2.setAdapter(slideAdapter2);
                                            slideAdapter2.notifyDataSetChanged();

                                        } else {
                                            ToastUtil.showToast("对不起，没有任务");
                                            no_renwuphoto.setVisibility(View.VISIBLE);
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
            });
            //下发
            xiafa_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListView3.setVisibility(View.VISIBLE);
                    mListView1.setVisibility(View.INVISIBLE);
                    mListView2.setVisibility(View.INVISIBLE);
                    mListView4.setVisibility(View.INVISIBLE);
                    mListView5.setVisibility(View.INVISIBLE);

                    swipeRefreshLayout1.setVisibility(View.GONE);
                    swipeRefreshLayout2.setVisibility(View.GONE);
                    swipeRefreshLayout3.setVisibility(View.VISIBLE);
                    swipeRefreshLayout4.setVisibility(View.GONE);
                    swipeRefreshLayout5.setVisibility(View.GONE);
                    i = 3;

                    toobar_title.setText(R.string.renwuguanli_xiafa);
                    SharedPreferencesUtil.writefinsh("未完成",MainActivity.this);

                    xiafa_http();

                    mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                            red.setVisibility(View.INVISIBLE);
                            data3 = list3.get(position);
                            LogUtil.d("下发----->", data3 + "");
                            //点击item进入 任务详情页
                            Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                            taskid3 = data3.getTaskid();
                            LogUtil.d("传递的taskid------>", taskid3);

                            intent.putExtra("taskname", data3.getTaskname());
                            intent.putExtra("taskid3", taskid3);
                            intent.putExtra("userid3", userid);
                            startActivity(intent);
                        }
                    });
                    mDrawerLayout.closeDrawer(lvLeftMenu);
                }

                private void xiafa_http() {
                    try {
                        OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                                .params("pn", 1)
                                .params("size", 10)
                                .params("status", 4)
                                .params("userid", userid)
                                .params("sort", 1)
                                .params("type",1)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                                        list3 = faburenwu.getList();
                                        if (list3 != null&&list3.size()>0) {
                                            no_renwuphoto.setVisibility(View.GONE);
//                                            ToastUtil.showToast("下发任务");
                                            LogUtil.d("获取下发任务信息--->>", s);
                                            LogUtil.d("下发任务列表-------", faburenwu + "");
                                            list3 = faburenwu.getList();
                                            slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                            mListView3.setAdapter(slideAdapter3);
                                            slideAdapter3.notifyDataSetChanged();

                                        } else {
                                            ToastUtil.showToast("对不起，没有任务");
                                            no_renwuphoto.setVisibility(View.VISIBLE);
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
            });
            chexiao_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListView4.setVisibility(View.VISIBLE);
                    mListView1.setVisibility(View.INVISIBLE);
                    mListView3.setVisibility(View.INVISIBLE);
                    mListView2.setVisibility(View.INVISIBLE);
                    mListView5.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout1.setVisibility(View.GONE);
                    swipeRefreshLayout2.setVisibility(View.GONE);
                    swipeRefreshLayout3.setVisibility(View.GONE);
                    swipeRefreshLayout4.setVisibility(View.VISIBLE);
                    swipeRefreshLayout5.setVisibility(View.GONE);
                    i = 4;

                    toobar_title.setText(R.string.renwuguanli_chexiao);
                    chexiao_http();
                    mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                            red.setVisibility(View.INVISIBLE);
                            data4 = list4.get(position);
                            //点击item进入 任务详情页
                            Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                            taskid4 = data4.getTaskid();
                            intent.putExtra("taskname", data4.getTaskname());
                            intent.putExtra("taskid4", taskid4);
                            intent.putExtra("userid4", userid);
                            startActivity(intent);
                        }
                    });
                    mDrawerLayout.closeDrawer(lvLeftMenu);
                }

                private void chexiao_http() {
                    try {
                        OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                                .params("pn", 1)
                                .params("size", 10)
                                .params("userid", userid)
                                .params("status", 5)
                                .params("sort", 1)
                                .params("type",1)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                                        list4 = chexiaorenwu.getList();
                                        if (list4 != null&&list4.size()>0) {
                                            no_renwuphoto.setVisibility(View.GONE);
//                                            ToastUtil.showToast("撤销任务");
                                            LogUtil.d("获取撤销任务信息--->>", s);
                                            LogUtil.d("撤销任务列表-------", chexiaorenwu + "");
                                            list4 = chexiaorenwu.getList();
                                            slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                            mListView4.setAdapter(slideAdapter4);
                                            slideAdapter4.notifyDataSetChanged();

                                        } else {
                                            ToastUtil.showToast("对不起，没有任务");
                                            no_renwuphoto.setVisibility(View.VISIBLE);
                                        }

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("联网失败(-_-)||");
                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            zhanting_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mListView5.setVisibility(View.VISIBLE);
                    mListView1.setVisibility(View.INVISIBLE);
                    mListView3.setVisibility(View.INVISIBLE);
                    mListView4.setVisibility(View.INVISIBLE);
                    mListView2.setVisibility(View.INVISIBLE);

                    swipeRefreshLayout1.setVisibility(View.GONE);
                    swipeRefreshLayout2.setVisibility(View.GONE);
                    swipeRefreshLayout3.setVisibility(View.GONE);
                    swipeRefreshLayout4.setVisibility(View.GONE);
                    swipeRefreshLayout5.setVisibility(View.VISIBLE);
                    i = 5;

                    toobar_title.setText(R.string.renwuguanli_zhanting);
                    zhanting_http();
                    mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                            red.setVisibility(View.INVISIBLE);
                            data5 = list5.get(position);
                            //点击item进入 任务详情页
                            Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                            taskid5 = data5.getTaskid();
                            intent.putExtra("taskname", data5.getTaskname());
                            intent.putExtra("taskid5", taskid5);
                            intent.putExtra("userid5", userid);
                            startActivity(intent);
                        }
                    });
                    mDrawerLayout.closeDrawer(lvLeftMenu);
                }

                private void zhanting_http() {
                    try {
                        OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                                .params("pn", 1)
                                .params("size", 10)
                                .params("userid", userid)
                                .params("sort", 1)
                                .params("status", 6)//暂停传6
                                .params("type",1)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                                        list5 = zhanting.getList();
                                        if (list5 != null&&list5.size()>0) {
                                            no_renwuphoto.setVisibility(View.GONE);
//                                            ToastUtil.showToast("暂停任务");
                                            LogUtil.d("获取暂停任务信息--->>", s);
                                            LogUtil.d("暂停任务列表-------", zhanting + "");
                                            list5 = zhanting.getList();
                                            slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                            mListView5.setAdapter(slideAdapter5);
                                            slideAdapter5.notifyDataSetChanged();

                                        } else {
                                            ToastUtil.showToast("对不起，没有任务");
                                            no_renwuphoto.setVisibility(View.VISIBLE);
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
            });
            LeftMoveon();
            tuichu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                centerDialog.show();
                    centerDialog.setOnCenterItemClickListener(new CenterDialog.OnCenterItemClickListener() {
                        @Override
                        public void OnCenterItemClick(CenterDialog dialog, View view) {
                            switch (view.getId()){
                                case R.id.dialog_sure:
                                    try {
                                        Glide.get(MainActivity.this).clearDiskCache();
                                        OkHttpUtils.get(Http_Api.URL_dengchu)
                                                .params("userid", userid)
                                                .execute(new StringCallback() {
                                                    @Override
                                                    public void onSuccess(String s, Call call, Response response) {
                                                        ToastUtil.showToast("退出");
                                                    }
                                                });
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
//                    mDrawerLayout.closeDrawer(lvLeftMenu);
                                    //清数据
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
                                    Intent intent = new Intent(MainActivity.this, Activity_login.class);
                                    startActivity(intent);
                                    finish();
                                    break;

                                default:
                                    break;
                            }
                        }
                    });

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void LeftMoveon() {
        try {
//                    //侧拉swipmenulistview 待办
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

                private void createMenu1(SwipeMenu menu) {
                    //创建置顶项
                    SwipeMenuItem zditem1 = new SwipeMenuItem(MainActivity.this);
                    //设置item width
                    zditem1.setWidth(dp2px(60));
                    //设置背景
                    zditem1.setBackground(R.color.listview_item_right_bg);
                    //图标
                    zditem1.setIcon(R.drawable.list_slide_but_stick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem1);
                }

                private void createMenu2(SwipeMenu menu) {
                    //创建置顶项
                    SwipeMenuItem zditem2 = new SwipeMenuItem(MainActivity.this);
                    //设置item width
                    zditem2.setWidth(dp2px(60));
                    //设置背景
                    zditem2.setBackground(R.color.listview_item_right_bg);
                    //图标
                    zditem2.setIcon(R.drawable.list_slide_but_canstick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem2);
                }
            };
            //设置创建者
            mListView1.setMenuCreator(creator1);
            //step 2. listener item click event
            mListView1.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                    data1 = list1.get(position);
                    taskid = data1.getTaskid();
                    iszhiding1 = data1.getStick();//置顶
                    //显示置顶
                    if (iszhiding1 == 0) {
                        try {
                            OkHttpUtils.post(Http_Api.URL_zhiding)
                                    .params("userid", userid)
                                    .params("taskid", taskid)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(String s, Call call, Response response) {
                                            Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);
                                            if (back_tag != null) {
                                                ToastUtil.showToast("置顶");
                                                showmore_daiban();
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

                    } else if (iszhiding1 == 1) {
                        try {
                            OkHttpUtils.post(Http_Api.URL_quxiaozhiding)
                                    .params("userid", userid)
                                    .params("taskid", taskid)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(String s, Call call, Response response) {
                                            Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                            if (back_tag != null) {
                                                ToastUtil.showToast("取消置顶");
                                                showmore_daiban();
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
                    return false;
                }
            });

            mListView1.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

            //已办
            //侧拉swipmenulistview
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
                    SwipeMenuItem zditem = new SwipeMenuItem(MainActivity.this);
                    //设置背景
                    zditem.setBackground(R.color.listview_item_right_bg);
                    //设置item width
                    zditem.setWidth(dp2px(60));
                    //设置项目标题
                    zditem.setIcon(R.drawable.list_slide_but_canstick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem);

                }

                private void createMenu1(SwipeMenu menu) {
                    //创建置顶项
                    SwipeMenuItem zditem2 = new SwipeMenuItem(MainActivity.this);
                    //设置背景
                    zditem2.setBackground(R.color.listview_item_right_bg);
                    //设置item width
                    zditem2.setWidth(dp2px(60));
                    //设置项目标题
                    zditem2.setIcon(R.drawable.list_slide_but_stick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem2);

                }
            };
            //设置创建者
            mListView2.setMenuCreator(creator2);
            // step 2. listener item click event
            mListView2.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                    data2 = list2.get(position);
                    taskid = data2.getTaskid();
                    iszhiding2 = data2.getStick();
                    //显示置顶
                    if (iszhiding2 == 0) {
                        menu.getMenuItem(0).setIcon(R.drawable.list_slide_but_stick3x);
                        try {
                            OkHttpUtils.post(Http_Api.URL_zhiding)
                                    .params("userid", userid)
                                    .params("taskid", taskid)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(String s, Call call, Response response) {
                                            Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);
                                            if (back_tag != null) {
                                                ToastUtil.showToast("置顶");
                                                showmore_yiban();
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
                    } else if (iszhiding2 == 1) {
                        menu.getMenuItem(0).setIcon(R.drawable.list_slide_but_canstick3x);
                        try {
                            OkHttpUtils.post(Http_Api.URL_quxiaozhiding)
                                    .params("userid", userid)
                                    .params("taskid", taskid)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(String s, Call call, Response response) {
                                            Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                            if (back_tag != null) {
                                                ToastUtil.showToast("取消置顶");
                                                showmore_yiban();
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
                    return false;
                }
            });
            mListView2.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

            //下发
            //侧拉swipmenulistview
            SwipeMenuCreator creator3 = new SwipeMenuCreator() {
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
                    SwipeMenuItem zditem = new SwipeMenuItem(MainActivity.this);
                    //设置背景
                    zditem.setBackground(R.color.listview_item_right_bg);
                    //设置item width
                    zditem.setWidth(dp2px(60));
                    //设置项目标题
                    zditem.setIcon(R.drawable.list_slide_but_canstick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem);

                    // create "delete" item
                    SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this);
                    // set item background
                    deleteItem.setBackground(R.color.listview_item_right_bg);
                    // set item width
                    deleteItem.setWidth(dp2px(60));
                    // 设置一个图标
                    deleteItem.setIcon(R.drawable.list_slide_but_cancel3x);
                    // add to menu
                    menu.addMenuItem(deleteItem);

                    // create "delete" item
                    SwipeMenuItem zditem2 = new SwipeMenuItem(MainActivity.this);
                    // set item background
                    zditem2.setBackground(R.color.listview_item_right_bg);
                    // set item width
                    zditem2.setWidth(dp2px(60));
                    // 设置一个图标
                    zditem2.setIcon(R.drawable.list_slide_but_pause3x);
                    // add to menu
                    menu.addMenuItem(zditem2);
                }

                private void createMenu1(SwipeMenu menu) {
                    //创建置顶项
                    SwipeMenuItem zditem = new SwipeMenuItem(MainActivity.this);
                    //设置背景
                    zditem.setBackground(R.color.listview_item_right_bg);
                    //设置item width
                    zditem.setWidth(dp2px(60));
                    //设置项目标题
                    zditem.setIcon(R.drawable.list_slide_but_stick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem);

                    // create "delete" item
                    SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this);
                    // set item background
                    deleteItem.setBackground(R.color.listview_item_right_bg);
                    // set item width
                    deleteItem.setWidth(dp2px(60));
                    // 设置一个图标
                    deleteItem.setIcon(R.drawable.list_slide_but_cancel3x);
                    // add to menu
                    menu.addMenuItem(deleteItem);

                    // create "delete" item
                    SwipeMenuItem zditem2 = new SwipeMenuItem(MainActivity.this);
                    // set item background
                    zditem2.setBackground(R.color.listview_item_right_bg);
                    // set item width
                    zditem2.setWidth(dp2px(60));
                    // 设置一个图标
                    zditem2.setIcon(R.drawable.list_slide_but_pause3x);
                    // add to menu
                    menu.addMenuItem(zditem2);
                }
            };
            //设置创建者
            mListView3.setMenuCreator(creator3);
            // step 2. listener item click event
            mListView3.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {
                    data3 = list3.get(position);
                    taskid = data3.getTaskid();
                    iszhiding3 = data3.getStick();
                    switch (index) {
                        case 0:
                            //显示置顶
                            if (iszhiding3 == 0) {
                                menu.getMenuItem(0).setIcon(R.drawable.list_slide_but_stick3x);
                                try {
                                    OkHttpUtils.post(Http_Api.URL_zhiding)
                                            .params("userid", userid)
                                            .params("taskid", taskid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);
                                                    if (back_tag != null) {
                                                        ToastUtil.showToast("置顶");
                                                        showmore_xiafa();
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

                            } else if (iszhiding3 == 1) {
                                menu.getMenuItem(0).setIcon(R.drawable.list_slide_but_canstick3x);
                                try {
                                    OkHttpUtils.post(Http_Api.URL_quxiaozhiding)
                                            .params("userid", userid)
                                            .params("taskid", taskid)
                                            .execute(new StringDialogCallback(MainActivity.this) {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                    if (back_tag != null) {
                                                        ToastUtil.showToast("取消置顶");
                                                        showmore_xiafa();
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
                                OkHttpUtils.post(Http_Api.URL_renwuzhuangtai)
                                        .params("taskid", taskid)
                                        .params("taskstatus", 5)
                                        .execute(new StringDialogCallback(MainActivity.this) {
                                            @Override
                                            public void onSuccess(String s, Call call, Response response) {
                                                Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                if (back_tag != null) {
                                                    ToastUtil.showToast("撤销完成");
                                                    list3.remove(position);
                                                    slideAdapter3.notifyDataSetChanged();
                                                } else {
                                                    ToastUtil.showToast("撤销失败");
                                                }
                                            }

                                            @Override
                                            public void onError(Call call, Response response, Exception e) {
                                                super.onError(call, response, e);
                                                ToastUtil.showToast("撤销失败");
                                            }
                                        });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            break;
                        case 2:
                            try {
                                OkHttpUtils.post(Http_Api.URL_renwuzhuangtai)
                                        .params("taskid", taskid)
                                        .params("taskstatus", 6)
                                        .execute(new StringDialogCallback(MainActivity.this) {
                                            @Override
                                            public void onSuccess(String s, Call call, Response response) {
                                                Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                if (back_tag != null) {
                                                    ToastUtil.showToast("暂停完成");
                                                    list3.remove(position);
                                                    slideAdapter3.notifyDataSetChanged();
                                                } else {
                                                    ToastUtil.showToast("暂停失败");
                                                }
                                            }

                                            @Override
                                            public void onError(Call call, Response response, Exception e) {
                                                super.onError(call, response, e);
                                                ToastUtil.showToast("暂停失败");
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
            mListView3.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);


            //撤销
            //侧拉swipmenulistview
            SwipeMenuCreator creator4 = new SwipeMenuCreator() {
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
                    SwipeMenuItem zditem = new SwipeMenuItem(MainActivity.this);
                    //设置背景
                    zditem.setBackground(R.color.listview_item_right_bg);
                    //设置item width
                    zditem.setWidth(dp2px(60));
                    //设置项目标题
                    zditem.setIcon(R.drawable.list_slide_but_canstick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem);

                    // create "delete" item
                    SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this);
                    // set item background
                    deleteItem.setBackground(R.color.listview_item_right_bg);
                    // set item width
                    deleteItem.setWidth(dp2px(60));
                    // 设置一个图标
                    deleteItem.setIcon(R.drawable.list_recover3);
                    // add to menu
                    menu.addMenuItem(deleteItem);
                }

                private void createMenu1(SwipeMenu menu) {
                    //创建置顶项
                    SwipeMenuItem zditem = new SwipeMenuItem(MainActivity.this);
                    //设置背景
                    zditem.setBackground(R.color.listview_item_right_bg);
                    //设置item width
                    zditem.setWidth(dp2px(60));
                    //设置项目标题
                    zditem.setIcon(R.drawable.list_slide_but_stick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem);

                    // create "delete" item
                    SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this);
                    // set item background
                    deleteItem.setBackground(R.color.listview_item_right_bg);
                    // set item width
                    deleteItem.setWidth(dp2px(60));
                    // 设置一个图标
                    deleteItem.setIcon(R.drawable.list_recover3);
                    // add to menu
                    menu.addMenuItem(deleteItem);

                }
            };
            //设置创建者
            mListView4.setMenuCreator(creator4);
            // step 2. listener item click event
            mListView4.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                    data4 = list4.get(position);
                    taskid = data4.getTaskid();
                    iszhiding4 = data4.getStick();
                    switch (index) {
                        case 0:
                            //显示置顶
                            if (iszhiding4 == 0) {
                                try {
                                    OkHttpUtils.post(Http_Api.URL_zhiding)
                                            .params("userid", userid)
                                            .params("taskid", taskid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                    if (back_tag != null) {
                                                        ToastUtil.showToast("置顶");
                                                        showmore_chexiao();
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

                            } else if (iszhiding4 == 1) {
                                try {
                                    OkHttpUtils.post(Http_Api.URL_quxiaozhiding)
                                            .params("userid", userid)
                                            .params("taskid", taskid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                    if (back_tag != null) {
                                                        ToastUtil.showToast("取消置顶");
                                                        showmore_chexiao();
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
                                OkHttpUtils.post(Http_Api.URL_renwuzhuangtai)
                                        .params("taskid", taskid)
                                        .params("taskstatus", 3)
                                        .execute(new StringCallback() {
                                            @Override
                                            public void onSuccess(String s, Call call, Response response) {
                                                Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s, Data_uploadBack_tag.class);

                                                if (back_tag != null) {
                                                    ToastUtil.showToast("恢复完成");
                                                    showmore_chexiao();
                                                } else {
                                                    ToastUtil.showToast("恢复失败");
                                                }
                                            }

                                            @Override
                                            public void onError(Call call, Response response, Exception e) {
                                                super.onError(call, response, e);
                                                ToastUtil.showToast("撤销失败，头皮发麻");
                                            }
                                        });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            break;

                    }
                    return false;
                }
            });
            mListView4.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
            //撤销
            //侧拉swipmenulistview
            SwipeMenuCreator creator5 = new SwipeMenuCreator() {
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
                    SwipeMenuItem zditem = new SwipeMenuItem(MainActivity.this);
                    //设置背景
                    zditem.setBackground(R.color.listview_item_right_bg);
                    //设置item width
                    zditem.setWidth(dp2px(60));
                    //设置项目标题
                    zditem.setIcon(R.drawable.list_slide_but_canstick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem);

                    // create "delete" item
                    SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this);
                    // set item background
                    deleteItem.setBackground(R.color.listview_item_right_bg);
                    // set item width
                    deleteItem.setWidth(dp2px(60));
                    // 设置一个图标
                    deleteItem.setIcon(R.drawable.list_slide_but_play3x);
                    // add to menu
                    menu.addMenuItem(deleteItem);
                }

                private void createMenu1(SwipeMenu menu) {
                    //创建置顶项
                    SwipeMenuItem zditem = new SwipeMenuItem(MainActivity.this);
                    //设置背景
                    zditem.setBackground(R.color.listview_item_right_bg);
                    //设置item width
                    zditem.setWidth(dp2px(60));
                    //设置项目标题
                    zditem.setIcon(R.drawable.list_slide_but_stick3x);
                    // 添加到菜单
                    menu.addMenuItem(zditem);

                    // create "delete" item
                    SwipeMenuItem deleteItem = new SwipeMenuItem(MainActivity.this);
                    // set item background
                    deleteItem.setBackground(R.color.listview_item_right_bg);
                    // set item width
                    deleteItem.setWidth(dp2px(60));
                    // 设置一个图标
                    deleteItem.setIcon(R.drawable.list_slide_but_play3x);
                    // add to menu
                    menu.addMenuItem(deleteItem);

                }
            };
            //设置创建者
            mListView5.setMenuCreator(creator5);
            // step 2. listener item click event
            mListView5.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                    if (list5!=null){
                        data5 = list5.get(position);
                    }
                    taskid = data5.getTaskid();
                    iszhiding5 = data5.getStick();
                    switch (index) {
                        case 0:
                            //显示置顶
                            if (iszhiding5 == 0) {
                                try {
                                    OkHttpUtils.post(Http_Api.URL_zhiding)
                                            .params("userid", userid)
                                            .params("taskid", taskid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    ToastUtil.showToast("置顶");
                                                    showmore_zhanting();
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

                            } else if (iszhiding5 == 1) {
                                try {
                                    OkHttpUtils.post(Http_Api.URL_quxiaozhiding)
                                            .params("userid", userid)
                                            .params("taskid", taskid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    ToastUtil.showToast("取消置顶");
                                                    showmore_zhanting();
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
                                OkHttpUtils.post(Http_Api.URL_renwuzhuangtai)
                                        .params("taskid", taskid)
                                        .params("taskstatus", 3)
                                        .execute(new StringCallback() {
                                            @Override
                                            public void onSuccess(String s, Call call, Response response) {
                                                ToastUtil.showToast("开启完成");
                                                showmore_zhanting();
                                            }

                                            @Override
                                            public void onError(Call call, Response response, Exception e) {
                                                super.onError(call, response, e);
                                                ToastUtil.showToast("暂停失败");
                                            }
                                        });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    return false;
                }
            });
            mListView5.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //下拉刷新

    public void uploadNew() {

        Handler handler = new Handler();

        try {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (i) {
                        case 1:
//                            swipeRefreshLayout.setRefreshing(true);
                            showmore_daiban();

                            ToastUtil.showToast("刷新完成");

                            swipeRefreshLayout1.setRefreshing(false);
                            break;
                        case 2:
//                            swipeRefreshLayout.setRefreshing(true);
                            showmore_yiban();
                            ToastUtil.showToast("刷新完成");
                            swipeRefreshLayout2.setRefreshing(false);
                            break;
                        case 3:
//                            swipeRefreshLayout.setRefreshing(true);
                            showmore_xiafa();
                            ToastUtil.showToast("刷新完成");
                            swipeRefreshLayout3.setRefreshing(false);
                            break;
                        case 4:
//                            swipeRefreshLayout.setRefreshing(true);
                            showmore_chexiao();
                            ToastUtil.showToast("刷新完成");
                            swipeRefreshLayout4.setRefreshing(false);
                            break;
                        case 5:
//                            swipeRefreshLayout.setRefreshing(true);
                            showmore_zhanting();
                            ToastUtil.showToast("刷新完成");
                            swipeRefreshLayout5.setRefreshing(false);
                            break;
                        default:
                            break;
                    }
                }
            }, 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //上拉加载更多

    public void onLoadMore() {
        switch (i) {
            case 1:
                try {
                    if (faTimeUpTag ==1){
                        showmore_daiban2(3,3,1);
                    }else if (lessTimeUp == 1){
                        showmore_daiban2(6,3,1);
                    }else if (lessTimeDown == 1){
                        showmore_daiban2(5,3,1);
                    }else {
                        showmore_daiban2(1,3,1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case 2:
                try {

                    showmore_yiban2(1,4,1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    if (faTimeUpTag == 1){
                        showmore_xiafa2(3,4,1);
                    }else if (lessTimeUp ==1 ){
                        showmore_xiafa2(6,4,1);
                    }else if (lessTimeDown == 1){
                        showmore_xiafa2(5,4,1);
                    }else {

                        showmore_xiafa2(1,4,1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    showmore_chexiao2(1,5,1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    showmore_zhanting2(1,6,1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }

    }


    //待办下拉刷新
    private void showmore_daiban() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 3)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu != null) {
                                if (list1 != null) {//还有数据
                                    list1.clear();
                                }
                                list1 = shoudaorenwu.getList();
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据");
//                                no_renwuphoto.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);

            }
        });
    }


    //已办下拉刷新
    private void showmore_yiban() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("status", 4)
                    .params("userid", userid)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu != null) {
                                if (list2 != null) {
                                    list2.clear();

                                }
                                list2 = wanchengrenwu.getList();
                                slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                mListView2.setAdapter(slideAdapter2);
                                slideAdapter2.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });
    }


    //下发下拉刷新
    private void showmore_xiafa() {

        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 4)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu != null) {
                                if (list3 != null) {
                                    list3.clear();
                                }
                                list3 = faburenwu.getList();
                                slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                mListView3.setAdapter(slideAdapter3);
                                slideAdapter3.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });
    }


    //撤销下拉刷新
    private void showmore_chexiao() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 5)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu != null) {
                                if (list4 != null) {
                                    list4.clear();
                                }
                                list4 = chexiaorenwu.getList();
                                slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                mListView4.setAdapter(slideAdapter4);
                                slideAdapter4.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });
    }


    //暂停下拉刷新
    private void showmore_zhanting() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("sort", 1)
                    .params("status", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (zhanting != null) {
                                if (list5 != null) {
                                    list5.clear();
                                }
                                list5 = zhanting.getList();
                                slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                mListView5.setAdapter(slideAdapter5);
                                slideAdapter5.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });
    }

    private int m1 = 1;

    //暂停上拉加载
    private void showmore_zhanting2(int sort,int status,int type) {
        //联网刷新listview
        m1++;
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", m1)
                    .params("size", sizedown)
                    .params("userid", userid)
                    .params("sort", sort)
                    .params("status", status)
                    .params("type",type)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu.getList()!= null){
                                list55.clear();
                            }
                            list55 = shoudaorenwu.getList();
                            int totle = shoudaorenwu.getTotal();//服务器返回总数
                            int totle2 =  list5.size();//加载的数据
                            LogUtil.d("totle===>",totle+"");
                            LogUtil.d("size===>",totle2+"");
                            if (totle2<totle) {
                                list5.addAll(list55);
                                slideAdapter5.notifyDataSetChanged();

                            } else {
                                m1 = 1;
                                ToastUtil.showToast("没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });

    }

    private int m2 = 1;

    //撤销上拉加载
    private void showmore_chexiao2(int sort,int status,int type) {

        //联网刷新listview

        m2++;
        try {

            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", m2)
                    .params("size", sizedown)
                    .params("userid", userid)
                    .params("status", status)
                    .params("sort", sort)
                    .params("type",type)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu.getList()!= null){
                                list44.clear();
                            }
                            list44 = chexiaorenwu.getList();
                            int totle = chexiaorenwu.getTotal();//服务器返回总数
                            int totle2 =  list4.size();//加载的数据
                            if (totle2 < totle) {
                                list4.addAll(list44);
                                slideAdapter4.notifyDataSetChanged();
                            } else {
                                m2 = 1;
                                ToastUtil.showToast("没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });

    }

    private int m3 = 1;

    private void showmore_xiafa2(int sort,int status,int type) {
        //联网刷新listview

        m3++;
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", m3)
                    .params("size", sizedown)
                    .params("userid", userid)
                    .params("status", status)
                    .params("sort", sort)
                    .params("type",type)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu.getList()!= null){
                                list33.clear();
                            }
                            list33 = faburenwu.getList();
                            int totle = faburenwu.getTotal();//服务器返回总数
                            int totle2 =  list3.size();//加载的数据
                            LogUtil.d("totle===>",totle+"");
                            LogUtil.d("size===>",totle2+"");
                            if (totle2 < totle) {
                                list3.addAll(list33);
                                slideAdapter3.notifyDataSetChanged();
                            } else {
                                m3 = 1;
                                ToastUtil.showToast("没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });

    }

    private int m4 = 1;

    //已办上拉加载
    private void showmore_yiban2(int sort,int status,int type) {
        //联网刷新listview
        m4++;
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", m4)
                    .params("size", sizedown)
                    .params("userid", userid)
                    .params("status", status)
                    .params("sort", sort)
                    .params("type",type)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu.getList()!=null){
                                list22.clear();
                            }
                            list22 = wanchengrenwu.getList();
                            int totle = wanchengrenwu.getTotal();//服务器返回总数
                            int totle2 = list2.size();//加载的数据
                            if (totle2 < totle) {
                                list2.addAll(list22);
                                slideAdapter2.notifyDataSetChanged();
                            } else {
                                m4 = 1;
                                ToastUtil.showToast("没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });

    }

    private int m5 = 1;

    //待办上拉加载
    private void showmore_daiban2(int sort,int status,int type) {
        //联网刷新listview
        m5++;
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", m5)
                    .params("size", sizedown)
                    .params("userid", userid)
                    .params("status", status)
                    .params("sort", sort)
                    .params("type",type)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu.getList()!= null){
                                list11.clear();
                            }
                            list11 = shoudaorenwu.getList();
                            int totle = shoudaorenwu.getTotal();//服务器返回总数
                            int totle2 =  list1.size();//加载的数据
                            if (totle2 < totle) {
                                list1.addAll(list11);
                                slideAdapter1.notifyDataSetChanged();
                            } else {
                                m5 = 1;
                                ToastUtil.showToast("没有更多数据了");
                            }

                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);
            }
        });

    }
    /**
     *
     * 排序  创建时间升序，降序，剩余时间升序，降序
     *
     **/
    //待办创建时间升序
    private void daibanUp1() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 3)
                    .params("sort", 3)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu != null) {
                                if (list1 != null) {//还有数据
                                    list1.clear();
                                }
                                list1 = shoudaorenwu.getList();
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据");
//                                no_renwuphoto.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);

            }
        });
    }

    //待办创建时间降序
    private void daibanDown1() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 3)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu != null) {
                                if (list1 != null) {//还有数据
                                    list1.clear();
                                }
                                list1 = shoudaorenwu.getList();
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据");
//                                no_renwuphoto.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);

            }
        });
    }
    //待办剩余时间升序
    private void daibanUp2() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status",3)
                    .params("sort", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu != null) {
                                if (list1 != null) {//还有数据
                                    list1.clear();
                                }
                                list1 = shoudaorenwu.getList();
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据");
//                                no_renwuphoto.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);

            }
        });
    }
    //待办剩余时间降序
    private void daibanDown2() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 3)
                    .params("type",1)
                    .params("sort", 5)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu != null) {
                                if (list1 != null) {//还有数据
                                    list1.clear();
                                }
                                list1 = shoudaorenwu.getList();
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据");
//                                no_renwuphoto.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);

            }
        });
    }

    //已办发布时间升序
    private void yibanUp1() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("status", 4)
                    .params("userid", userid)
                    .params("sort", 3)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu != null) {
                                if (list2 != null) {
                                    list2.clear();

                                }
                                list2 = wanchengrenwu.getList();
                                slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                mListView2.setAdapter(slideAdapter2);
                                slideAdapter2.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });
    }

    //已办剩余时间升序
    private void yibanUp2() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("status", 4)
                    .params("userid", userid)
                    .params("sort", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu != null) {
                                if (list2 != null) {
                                    list2.clear();

                                }
                                list2 = wanchengrenwu.getList();
                                slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                mListView2.setAdapter(slideAdapter2);
                                slideAdapter2.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });
    }

    //已办发布时间降序
    private void yibanDown1() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("status", 4)
                    .params("userid", userid)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu != null) {
                                if (list2 != null) {
                                    list2.clear();

                                }
                                list2 = wanchengrenwu.getList();
                                slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                mListView2.setAdapter(slideAdapter2);
                                slideAdapter2.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });
    }

    //已办剩余时间降序
    private void yibanDown2() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("status", 4)
                    .params("userid", userid)
                    .params("sort", 5)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu != null) {
                                if (list2 != null) {
                                    list2.clear();

                                }
                                list2 = wanchengrenwu.getList();
                                slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                mListView2.setAdapter(slideAdapter2);
                                slideAdapter2.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });
    }

    //下发创建时间升序
    private void xiafaUp1() {

        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 4)
                    .params("sort", 3)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu != null) {
                                if (list3 != null) {
                                    list3.clear();
                                }
                                list3 = faburenwu.getList();

                                slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                mListView3.setAdapter(slideAdapter3);
                                slideAdapter3.notifyDataSetChanged();

                            }else {
                                ToastUtil.showToast("对不起，没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });
    }

    //下发剩余时间升序
    private void xiafaUp2() {

        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 4)
                    .params("sort", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu != null) {
                                if (list3 != null) {
                                    list3.clear();
                                }
                                list3 = faburenwu.getList();
                                slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                mListView3.setAdapter(slideAdapter3);
                                slideAdapter3.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });
    }

    //下发创建时间降序
    private void xiafaDown1() {

        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 4)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu != null) {
                                if (list3 != null) {
                                    list3.clear();
                                }
                                list3 = faburenwu.getList();
                                slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                mListView3.setAdapter(slideAdapter3);
                                slideAdapter3.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });
    }

    //下发剩余时间降序
    private void xiafaDown2() {

        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 4)
                    .params("sort", 5)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu != null) {
                                if (list3 != null) {
                                    list3.clear();
                                }
                                list3 = faburenwu.getList();
                                slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                mListView3.setAdapter(slideAdapter3);
                                slideAdapter3.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多数据了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });
    }

    //撤销创建时间升序
    private void chexiaoUp1() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 5)
                    .params("sort", 3)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu != null) {
                                if (list4 != null) {
                                    list4.clear();
                                }
                                list4 = chexiaorenwu.getList();
                                slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                mListView4.setAdapter(slideAdapter4);
                                slideAdapter4.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);

                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });
    }

    //撤销剩余时间升序
    private void chexiaoUp2() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 5)
                    .params("sort", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu != null) {
                                if (list4 != null) {
                                    list4.clear();
                                }
                                list4 = chexiaorenwu.getList();
                                slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                mListView4.setAdapter(slideAdapter4);
                                slideAdapter4.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });
    }

    //撤销创建时间降序
    private void chexiaoDown1() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 5)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu != null) {
                                if (list4 != null) {
                                    list4.clear();
                                }
                                list4 = chexiaorenwu.getList();
                                slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                mListView4.setAdapter(slideAdapter4);
                                slideAdapter4.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });
    }

    //撤销剩余时间降序
    private void chexiaoDown2() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 5)
                    .params("sort", 5)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu != null) {
                                if (list4 != null) {
                                    list4.clear();
                                }
                                list4 = chexiaorenwu.getList();
                                slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                mListView4.setAdapter(slideAdapter4);
                                slideAdapter4.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });
    }

    //暂停剩余时间升序
    private void zhantingUp2() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("sort", 6)
                    .params("status", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (zhanting != null) {
                                if (list5 != null) {
                                    list5.clear();
                                }
                                list5 = zhanting.getList();
                                slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                mListView5.setAdapter(slideAdapter5);
                                slideAdapter5.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });
    }

    //暂停创建时间升序
    private void zhantingUp1() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("sort", 3)
                    .params("status", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (zhanting != null) {
                                if (list5 != null) {
                                    list5.clear();
                                }
                                list5 = zhanting.getList();
                                slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                mListView5.setAdapter(slideAdapter5);
                                slideAdapter5.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });
    }

    //暂停创建时间降序
    private void zhantingDown1() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("sort", 1)
                    .params("status", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (zhanting != null) {
                                if (list5 != null) {
                                    list5.clear();
                                }
                                list5 = zhanting.getList();
                                slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                mListView5.setAdapter(slideAdapter5);
                                slideAdapter5.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });
    }

    //暂停剩余时间降序
    private void zhantingDown2() {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("sort", 5)
                    .params("status", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (zhanting != null) {
                                if (list5 != null) {
                                    list5.clear();
                                }
                                list5 = zhanting.getList();
                                slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                mListView5.setAdapter(slideAdapter5);
                                slideAdapter5.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有更多任务了");
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
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });
    }

    //待办文本搜索
    private void daibanSearchText(String a) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 3)
                    .params("sort", 1)
                    .params("type",1)
                    .params("query",a)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu != null&&shoudaorenwu.getList()!=null) {
                                list1 = shoudaorenwu.getList();
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有查到任务");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);

            }
        });
    }
    //待办发布时间搜索
    private void daibanStartSearch(String a) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 3)
                    .params("starttime",a)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu != null&&shoudaorenwu.getList()!=null) {
                                list1 = shoudaorenwu.getList();
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有查到任务");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);

            }
        });
    }

    //待办发布时间搜索
    private void daibanEndSearch(String a) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 3)
                    .params("endtime",a)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (shoudaorenwu != null&&shoudaorenwu.getList()!=null) {
                                list1 = shoudaorenwu.getList();
                                slideAdapter1 = new SlideAdapter1(MainActivity.this, list1);
                                mListView1.setAdapter(slideAdapter1);
                                slideAdapter1.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，没有查到任务");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data1 = list1.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Deatail.class);
                taskid = data1.getTaskid();
                haha = data1.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(haha, MainActivity.this);
                intent.putExtra("taskname", data1.getTaskname());
                intent.putExtra("taskid1", taskid);
                intent.putExtra("userid1", userid);
                startActivity(intent);

            }
        });
    }

    //已办文本搜索
    private void yibanSearchText(String w) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("status", 4)
                    .params("userid", userid)
                    .params("sort", 1)
                    .params("type",1)
                    .params("query",w)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu != null&&wanchengrenwu.getList()!=null) {
                                list2 = wanchengrenwu.getList();
                                slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                mListView2.setAdapter(slideAdapter2);
                                slideAdapter2.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
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
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });
    }

    //已办开始时间搜索
    private void yibanStartSearch(String w) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("status", 4)
                    .params("userid", userid)
                    .params("sort", 1)
                    .params("starttime",w)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu != null&&wanchengrenwu.getList()!=null) {
                                list2 = wanchengrenwu.getList();
                                slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                mListView2.setAdapter(slideAdapter2);
                                slideAdapter2.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
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
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });
    }

    //已办结束时间搜索
    private void yibanEndSearch(String w) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("status", 4)
                    .params("userid", userid)
                    .params("sort", 1)
                    .params("endtime",w)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            wanchengrenwu = JsonUtil.parseJsonToBean(s, Data_huoqusuoyou_wanchengrenwu.class);
                            if (wanchengrenwu != null&&wanchengrenwu.getList()!=null) {
                                list2 = wanchengrenwu.getList();
                                slideAdapter2 = new SlideAdapter2(MainActivity.this, list2);
                                mListView2.setAdapter(slideAdapter2);
                                slideAdapter2.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
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
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data2 = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_yiban_deatail2.class);
                taskid2 = data2.getTaskid();
                prooo = data2.getProgress();
                SharedPreferencesUtil.writeProgressYiban(prooo,MainActivity.this);
                intent.putExtra("taskname", data2.getTaskname());
                intent.putExtra("taskid2", taskid2);
                intent.putExtra("userid2", userid);
                startActivity(intent);
            }
        });
    }

    //下发文本搜索
    private void xiafaSearchText(String r1) {

        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 4)
                    .params("sort", 1)
                    .params("type",1)
                    .params("query",r1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu != null&&faburenwu.getList()!=null) {
                                list3 = faburenwu.getList();
                                slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                mListView3.setAdapter(slideAdapter3);
                                slideAdapter3.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });
    }

    //下发开始时间搜索
    private void xiafaStartSearch(String r1) {

        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 4)
                    .params("sort", 1)
                    .params("starttime",r1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu != null&&faburenwu.getList()!=null) {
                                list3 = faburenwu.getList();
                                slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                mListView3.setAdapter(slideAdapter3);
                                slideAdapter3.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });
    }

    //下发结束时间搜索
    private void xiafaEndSearch(String r1) {

        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_fachurenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 4)
                    .params("sort", 1)
                    .params("endtime",r1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            faburenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_faburenwu.class);
                            if (faburenwu != null&&faburenwu.getList()!=null) {
                                list3 = faburenwu.getList();
                                slideAdapter3 = new SlideAdapter3(MainActivity.this, list3);
                                mListView3.setAdapter(slideAdapter3);
                                slideAdapter3.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data3 = list3.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Xiafa_deatil.class);
                taskid3 = data3.getTaskid();
                intent.putExtra("taskname", data3.getTaskname());
                intent.putExtra("taskid3", taskid3);
                intent.putExtra("userid3", userid);
                startActivity(intent);
            }
        });
    }

    //撤销文本搜索
    private void chexiaoSearchText(String r2) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("status", 5)
                    .params("sort", 1)
                    .params("type",1)
                    .params("query",r2)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu != null&&chexiaorenwu.getList()!=null) {
                                list4 = chexiaorenwu.getList();
                                slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                mListView4.setAdapter(slideAdapter4);
                                slideAdapter4.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });
    }

    //撤销开始时间搜索
    private void chexiaoStartSearch(String r2) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("starttime",r2)
                    .params("status", 5)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu != null&&chexiaorenwu.getList()!=null) {
                                list4 = chexiaorenwu.getList();
                                slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                mListView4.setAdapter(slideAdapter4);
                                slideAdapter4.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
                            }
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            // UI 线程，请求失败后回调
                            // isFromCache 表示当前回调是否来自于缓存
                            // call        本次网络的请求对象，可以根据该对象拿到 request
                            // response    本次网络访问的结果对象，包含了响应头，响应码等，如果网络异常 或者数据来自于缓存，该对象为null
                            // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 400~599之间，该异常为 null
                            ToastUtil.showToast("联网失败");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });
    }

    //撤销结束时间搜索
    private void chexiaoEndSearch(String r2) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chexiaorenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("endtime",r2)
                    .params("status", 5)
                    .params("sort", 1)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            chexiaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (chexiaorenwu != null&&chexiaorenwu.getList()!=null) {
                                list4 = chexiaorenwu.getList();
                                slideAdapter4 = new SlideAdapter4(MainActivity.this, list4);
                                mListView4.setAdapter(slideAdapter4);
                                slideAdapter4.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
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
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data4 = list4.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Chexiao_deatil.class);
                taskid4 = data4.getTaskid();
                intent.putExtra("taskname", data4.getTaskname());
                intent.putExtra("taskid4", taskid4);
                intent.putExtra("userid4", userid);
                startActivity(intent);
            }
        });
    }

    //暂停开始时间搜索
    private void zhantingSearchText(String r3) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("sort", 1)
                    .params("status", 6)
                    .params("type",1)
                    .params("query",r3)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (zhanting != null&&zhanting.getList()!=null) {
                                list5 = zhanting.getList();
                                slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                mListView5.setAdapter(slideAdapter5);
                                slideAdapter5.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
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
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });
    }

    //暂停文本搜索
    private void zhantingStartSearch(String r3) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("starttime",r3)
                    .params("sort", 1)
                    .params("status", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (zhanting != null&&zhanting.getList()!=null) {
                                list5 = zhanting.getList();
                                slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                mListView5.setAdapter(slideAdapter5);
                                slideAdapter5.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
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
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });
    }

    //暂停结束时间搜索
    private void zhantingEndSearch(String r3) {
        //联网刷新listview
        try {
            OkHttpUtils.get(Http_Api.URL_chaxun_jiehsourenwu)
                    .params("pn", 1)
                    .params("size", sizeup)
                    .params("userid", userid)
                    .params("endtime",r3)
                    .params("sort", 1)
                    .params("status", 6)
                    .params("type",1)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json-----", s);
                            zhanting = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                            if (zhanting != null&&zhanting.getList()!=null) {
                                list5 = zhanting.getList();
                                slideAdapter5 = new SlideAdapter5(MainActivity.this, list5);
                                mListView5.setAdapter(slideAdapter5);
                                slideAdapter5.notifyDataSetChanged();
                            }else {
                                ToastUtil.showToast("对不起，查不到任务");
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
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView red = (ImageView) view.findViewById(R.id.renwutishi_red);
                red.setVisibility(View.INVISIBLE);
                data5 = list5.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(MainActivity.this, Activity_Zanting_deatil.class);
                taskid5 = data5.getTaskid();

                intent.putExtra("taskname", data5.getTaskname());
                intent.putExtra("taskid5", taskid5);
                intent.putExtra("userid5", userid);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(MainActivity.this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        toggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.showToast("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
