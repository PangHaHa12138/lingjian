package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hxzh.uniwill.lingjian.Adapter.HuibaoAdapter;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.SimpleUserdefEmoticonsKeyBoard;
import com.hxzh.uniwill.lingjian.bean.Data_ReceiverNews;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunrenwu_xiaoxiliebiao;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
import com.hxzh.uniwill.lingjian.common.ChattingListAdapter;
import com.hxzh.uniwill.lingjian.common.Constants;
import com.hxzh.uniwill.lingjian.common.ImMsgBean;
import com.hxzh.uniwill.lingjian.common.MyChattingAdapter;
import com.hxzh.uniwill.lingjian.common.NyChattingListAdapter;
import com.hxzh.uniwill.lingjian.common.SimpleAppsGridView;
import com.hxzh.uniwill.lingjian.common.SimpleUserDefAppsGridView;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.SimpleCommonUtils;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.sj.emoji.EmojiBean;

import org.senydevpkg.utils.NetworkUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import sj.keyboard.data.EmoticonEntity;
import sj.keyboard.interfaces.EmoticonClickListener;
import sj.keyboard.widget.EmoticonsEditText;
import sj.keyboard.widget.FuncLayout;

/**
 * Created by pang on 2017/4/4.
 *  聊天 很low的留言板
 */
public class Activity_Chat extends AppCompatActivity implements FuncLayout.OnFuncKeyBoardListener{

    private ListView lvChat;
    private SimpleUserdefEmoticonsKeyBoard ekBar;
    private ChattingListAdapter chattingListAdapter;
//    private MyChattingAdapter myChattingAdapter;
    private NyChattingListAdapter myChattingAdapter;
    private Toolbar toolbar;
    private TextView title;
    private ImageView addview;
    private String userid,taskid;
    private Data_ReceiverNews.NewsBean newsBean;
    private Data_ReceiverNews data_receiverNews;
    private List<Data_ReceiverNews.NewsBean> newsBeanList = new ArrayList<Data_ReceiverNews.NewsBean>();
    private List<Data_ReceiverNews.NewsBean> newsBeanListshort= new ArrayList<Data_ReceiverNews.NewsBean>();
    private int allcount;
    private SwipeRefreshLayout uploadmore;
    private View footview;
    private int footerHeight;
    private boolean isshort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        userid = SharedPreferencesUtil.readUserid(Activity_Chat.this);
        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskidchat");
        if(userid!=null){

            LogUtil.d("userid----",userid);
        }
        if (taskid!=null){

            LogUtil.d("taskid----",taskid);
        }
        initView();

    }

    private void initView() {
        lvChat = (ListView) findViewById(R.id.lv_chat);
        ekBar = (SimpleUserdefEmoticonsKeyBoard) findViewById(R.id.ek_bar);
        toolbar = (Toolbar) findViewById(R.id.toobaraaa);
        title = (TextView) findViewById(R.id.toolbarmtit);
        addview = (ImageView) findViewById(R.id.toobaradd);
        uploadmore = (SwipeRefreshLayout) findViewById(R.id.uploadmore);
        footview = View.inflate(Activity_Chat.this,R.layout.chat_footer,null);
        setSupportActionBar(toolbar);
        title.setText("讨论区");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        footview.measure(0,0);
        footerHeight = footview.getMeasuredHeight();
        footview.setPadding(0,-footerHeight,0,0);
        lvChat.addFooterView(footview);
//        addview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showToast("你点了+号");
//            }
//        });
        showBack();

        initEmoticonsKeyBoardBar();
        initListView();
        uploadmore.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light,
                android.R.color.holo_orange_light);

        uploadmore.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OkHttpUtils.get(Http_Api.URL_NewReceiver)
                                    .params("userid",userid)
                                    .params("taskid",taskid)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(String s, Call call, Response response) {
                                            LogUtil.d("返回值",s);
                                            data_receiverNews = JsonUtil.parseJsonToBean(s,Data_ReceiverNews.class);
                                            allcount = Integer.parseInt(data_receiverNews.getResult());
                                            if (allcount != 0){

                                                if (newsBeanList!=null){
                                                    newsBeanList.clear();
                                                }
                                                newsBeanList = data_receiverNews.getNews();
                                                myChattingAdapter = new NyChattingListAdapter(Activity_Chat.this,userid,newsBeanList);
                                                lvChat.setAdapter(myChattingAdapter);
                                                myChattingAdapter.notifyDataSetChanged();
                                                uploadmore.setRefreshing(false);
                                            }else {
                                                ToastUtil.showToast("对不起，没有更多消息了");
                                                uploadmore.setRefreshing(false);
                                            }

                                        }
                                    });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },2000);


            }
        });

    }

    private void initEmoticonsKeyBoardBar() {
        SimpleCommonUtils.initEmoticonsEditText(ekBar.getEtChat());
        ekBar.setAdapter(SimpleCommonUtils.getCommonAdapter(this, emoticonClickListener));
        ekBar.addOnFuncKeyBoardListener(this);
        ekBar.addFuncView(new SimpleUserDefAppsGridView(this));
//        ekBar.addFuncView(new SimpleAppsGridView(this));

        ekBar.getEtChat().setOnSizeChangedListener(new EmoticonsEditText.OnSizeChangedListener() {
            @Override
            public void onSizeChanged(int w, int h, int oldw, int oldh) {
//                scrollToBottom();
            }
        });
        ekBar.getBtnSend().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSendBtnClick(ekBar.getEtChat().getText().toString());
                ekBar.getEtChat().setText("");
            }
        });
        ekBar.getBtnVoice().setLongClickable(true);
        ekBar.getBtnVoice().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ToastUtil.showToast("功能未完善");
                return false;
            }
        });
        ekBar.getBtnVoice().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("功能未完善");
            }
        });

//        ekBar.getEmoticonsToolBarView().addFixedToolItemView(false, R.drawable.icon_add, null, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Activity_Chat.this, "ADD", Toast.LENGTH_SHORT).show();
//            }
//        });

//        ekBar.getEmoticonsToolBarView().addToolItemView(R.drawable.icon_setting, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Activity_Chat.this, "SETTING", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    EmoticonClickListener emoticonClickListener = new EmoticonClickListener() {
        @Override
        public void onEmoticonClick(Object o, int actionType, boolean isDelBtn) {

            if (isDelBtn) {
                SimpleCommonUtils.delClick(ekBar.getEtChat());
            } else {
                if(o == null){
                    return;
                }
                if(actionType == Constants.EMOTICON_CLICK_BIGIMAGE){
                    if(o instanceof EmoticonEntity){
                        OnSendImage(((EmoticonEntity)o).getIconUri());
                    }
                } else {
                    String content = null;
                    if(o instanceof EmojiBean){
                        content = ((EmojiBean)o).emoji;
                    } else if(o instanceof EmoticonEntity){
                        content = ((EmoticonEntity)o).getContent();
                    }

                    if(TextUtils.isEmpty(content)){
                        return;
                    }
                    int index = ekBar.getEtChat().getSelectionStart();
                    Editable editable = ekBar.getEtChat().getText();
                    editable.insert(index, content);
                }
            }
        }
    };
    private void initListView() {

        ShowNow();

        uploadmoreadd();


    }

    private void ShowNow() {
        try {
            OkHttpUtils.get(Http_Api.URL_NewReceiver)
                    .params("userid",userid)
                    .params("taskid",taskid)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("返回值",s);
                            data_receiverNews = JsonUtil.parseJsonToBean(s,Data_ReceiverNews.class);
                            allcount = Integer.parseInt(data_receiverNews.getResult());
                            if (data_receiverNews.getNews()!=null){
                                newsBeanList = data_receiverNews.getNews();
                            }

                            LogUtil.d("集合:newsBeanList--",newsBeanList+"");
                            if (allcount>28){
                                newsBeanListshort = newsBeanList.subList(newsBeanList.size()-28,newsBeanList.size());

                                myChattingAdapter = new NyChattingListAdapter(Activity_Chat.this,userid,newsBeanListshort);
                                isshort = true;
                            }else {
                                myChattingAdapter = new NyChattingListAdapter(Activity_Chat.this,userid,newsBeanList);
                                isshort = false;
                            }

                            lvChat.setAdapter(myChattingAdapter);


                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadmoreadd() {
        lvChat.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE){
                    ekBar.reset();
                    int lastposition = lvChat.getLastVisiblePosition();//最后一个item的位置
                    if (lastposition == lvChat.getCount() - 1){
                        footview.setPadding(0,0,0,footerHeight);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    OkHttpUtils.get(Http_Api.URL_NewReceiver)
                                            .params("userid",userid)
                                            .params("taskid",taskid)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    LogUtil.d("返回值",s);
                                                    data_receiverNews = JsonUtil.parseJsonToBean(s,Data_ReceiverNews.class);
                                                    allcount = Integer.parseInt(data_receiverNews.getResult());
                                                    if (newsBeanList!=null){
                                                        newsBeanList.clear();
                                                    }
                                                    newsBeanList = data_receiverNews.getNews();

                                                    if (allcount>28){
                                                        newsBeanListshort = newsBeanList.subList(newsBeanList.size()-28,newsBeanList.size());

                                                        myChattingAdapter = new NyChattingListAdapter(Activity_Chat.this,userid,newsBeanListshort);
                                                        isshort = true;
                                                    }else {
                                                        myChattingAdapter = new NyChattingListAdapter(Activity_Chat.this,userid,newsBeanList);
                                                        isshort = false;
                                                    }

                                                    lvChat.setAdapter(myChattingAdapter);
                                                    myChattingAdapter.notifyDataSetChanged();
                                                    ToastUtil.showToast("加载完成");

                                                }
                                            });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                footview.setPadding(0,-footerHeight,0,0);

                            }
                        },2000);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                boolean enable = false;
//                if(lvChat != null && lvChat.getChildCount() > 0){
//                    // 检查列表的第一个项目是否可见
//                    boolean firstItemVisible = lvChat.getFirstVisiblePosition() == 0;
//                    // 检查第一个项目的顶部是否可见
//                    boolean topOfFirstItemVisible = lvChat.getChildAt(0).getTop() == 0;
//                    // 启用或禁用刷新布局
//                    enable = firstItemVisible && topOfFirstItemVisible;
//                }
//                uploadmore.setRefreshing(enable);
            }
        });
    }

    //用当前时间
    private String getTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");
        return dateFormat.format(date);
    }

    private void OnSendBtnClick(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            final Data_ReceiverNews.NewsBean bean = new Data_ReceiverNews.NewsBean();
            bean.setNewscontent(msg);
            bean.setCreatime(getTime());
            LogUtil.d("------Emoji:",msg);
            try {
                OkHttpUtils.post(Http_Api.URL_NewSend)
                        .params("taskid",taskid)
                        .params("userid",userid)
                        .params("newscontent",msg)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                LogUtil.d("返回值",s);
                                Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                if(back_tag.getResult().equals("0")){
                                    ToastUtil.showToast("非法的表情符号！");
                                }else if (back_tag.getResult().equals("1")){
//                                    if (isshort){
//                                        if (bean!= null){
//                                            newsBeanListshort.add(bean);
//                                        }
//
//                                    }else {
//                                        if (bean!=null){
//                                            newsBeanList.add(bean);
//                                        }
//                                    }
//                                    myChattingAdapter.setsendtype(1);
                                    ShowNow();
                                    myChattingAdapter.notifyDataSetChanged();
//                                    scrollToBottom();
                                }
                            }

                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void OnSendImage(String image) {
        if (!TextUtils.isEmpty(image)) {
            OnSendBtnClick("[img]" + image);
        }
    }

    private void scrollToBottom() {
        lvChat.requestLayout();
        lvChat.post(new Runnable() {
            @Override
            public void run() {
                lvChat.setSelection(lvChat.getBottom()+2);
            }
        });
    }
    /**
     * 版本号小于21的后退按钮图片
     */
    private void showBack(){
        //setNavigationIcon必须在setSupportActionBar(toolbar);方法后面加入
       toolbar.setNavigationIcon(R.drawable.title_but_back3x);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void OnFuncPop(int i) {
//        scrollToBottom();

    }

    @Override
    public void OnFuncClose() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        ekBar.reset();
    }
    @Override
    protected void onResume() {
        super.onResume();
        checkNetwork();
    }

    private boolean checkNetwork() {
        if (!NetworkUtils.checkNetwork(this)) {
            ToastUtil.showToast("手机无可用网络");
        }
        return true;
    }
}
