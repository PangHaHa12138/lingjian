package com.hxzh.uniwill.lingjian.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cookie.store.PersistentCookieStore;

import org.senydevpkg.net.HttpLoader;

/**
 * Created by pang on 2017/3/29.
 * 全局上下文
 */
public class MyApplication extends Application {

    public static HttpLoader HL;

    public static Context mcontext;
    public static Handler mainHandler;//主线程handle
//    public static MyApplication App;
    //App入口函数
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化context
        mcontext = this;
        //初始化主线程handle
        mainHandler = new Handler();
        HL = HttpLoader.getInstance(this);

//        EMOptions options = new EMOptions();
//    // 默认添加好友时，是不需要验证的，改成需要验证
//        options.setAcceptInvitationAlways(false);
//
//    //初始化
//        EMClient.getInstance().init(mcontext, options);
//    //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
//        EMClient.getInstance().setDebugMode(true);


//        HttpHeaders headers = new HttpHeaders();
//        headers.put("commonHeaderKey1", "commonHeaderValue1");    //所有的 header 都 不支持 中文
//        headers.put("commonHeaderKey2", "commonHeaderValue2");
//        HttpParams params = new HttpParams();
//        params.put("commonParamsKey1", "commonParamsValue1");     //所有的 params 都 支持 中文
//        params.put("commonParamsKey2", "这里支持中文参数");

        //必须调用初始化
        OkHttpUtils.init(this);
        //以下都不是必须的，根据需要自行选择
        OkHttpUtils.getInstance()//
                .debug("OkHttpUtils")                                              //是否打开调试
                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)               //全局的连接超时时间
                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                  //全局的读取超时时间
                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                //全局的写入超时时间
                //.setCookieStore(new MemoryCookieStore())                           //cookie使用内存缓存（app退出后，cookie消失）
                .setCookieStore(new PersistentCookieStore())       ;                //cookie持久化存储，如果cookie不过期，则一直有效
//                .addCommonHeaders(headers)                                         //设置全局公共头
//                .addCommonParams(params);                                          //设置全局公共参数



    }

//
//    public static Application getApplication() {
//        return mcontext;
//    }
}