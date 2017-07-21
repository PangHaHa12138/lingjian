package com.hxzh.uniwill.lingjian.Activity;

/**
 * Created by pang on 2017/3/28.
 *
 * 重写的一个Activity 的基类，在基类中实现了一个TooBar 用TooBar来展示一个标题
 * 同时定义一个Back按钮，点击的时候退出当前的Activity
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;

import org.senydevpkg.utils.NetworkUtils;


public abstract class BaseToobarRightViewActivity extends AppCompatActivity {

    private static final String TAG = BaseToobarRightViewActivity.class.getSimpleName();
    private TextView mToolbarTitle;
    private ImageView mToolbar_right_view;
    private ImageView mToobar_redview;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mToolbar = (Toolbar) findViewById(R.id.base_toobar);
       /*
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("Title");
        toolbar.setSubtitle("Sub Title");
        */
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_main_title);
        mToolbar_right_view = (ImageView) findViewById(R.id.toobar_right_view);
        mToobar_redview = (ImageView) findViewById(R.id.xiaoxired);
        if (mToolbar != null) {
            //将Toolbar显示到界面
            setSupportActionBar(mToolbar);
        }
        if (mToolbarTitle != null) {
            //getTitle()的值是activity的android:lable属性值
            mToolbarTitle.setText(getTitle());
            //设置默认的标题不显示
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        /**
         * 判断是否有Toolbar,并默认显示返回按钮
         */
        if(null != getToolbar() && isShowBacking()){
            showBack();
        }
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

    /**
     * 获取头部标题的TextView
     * @return
     */
    public TextView getToolbarTitle(){
        return mToolbarTitle;
    }
    /**
     * 获取头部右面的view
     * @return
     */
    public ImageView getToobarRightView(){
        return mToolbar_right_view;
    }

    /**
     * 获取右面小红点
     * @return
     */
    public ImageView getToobarRedView(){
        return mToobar_redview;
    }

    /**
     * 设置头部标题
     * @param title
     */
    public void setToolBarTitle(CharSequence title) {
        if(mToolbarTitle != null){
            mToolbarTitle.setText(title);
        }else{
            getToolbar().setTitle(title);
            setSupportActionBar(getToolbar());
        }
    }

    /**
     * this Activity of tool bar.
     * 获取头部.
     * @return support.v7.widget.Toolbar.
     */
    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.base_toobar);
    }

    /**
     * 版本号小于21的后退按钮图片
     */
    private void showBack(){
        //setNavigationIcon必须在setSupportActionBar(toolbar);方法后面加入
        getToolbar().setNavigationIcon(R.drawable.title_but_back3x);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 是否显示后退按钮,默认显示,可在子类重写该方法.
     * @return
     */
    protected boolean isShowBacking(){
        return true;
    }

    /**
     * this activity layout res
     * 设置layout布局,在子类重写该方法.
     * @return res layout xml id
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy...");


    }

}
