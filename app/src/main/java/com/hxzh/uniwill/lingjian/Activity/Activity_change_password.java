package com.hxzh.uniwill.lingjian.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/4/1.
 *  修改密码
 */
public class Activity_change_password extends BaseToobarActivity {

    private EditText yuanmima;
    private EditText xinmima;
    private Button finsh;
    private String oldpasswd,xinpasswd,userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("修改密码");
        getToobarRightTitle().setText("");
        initView();
        initData();

    }

    private void initView() {
        yuanmima = (EditText) findViewById(R.id.yuanmima);
        xinmima = (EditText) findViewById(R.id.xinmima);
        finsh = (Button) findViewById(R.id.finsh_changepassword);
    }

    private void initData() {

        oldpasswd = yuanmima.getText().toString().trim();
        xinpasswd = xinmima.getText().toString().trim();
        userid = SharedPreferencesUtil.readUserid(Activity_change_password.this);
        finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        OkHttpUtils.get(Http_Api.URL_xiugaimima)
                                .params("userid",userid)
                                .params("oldpwd",oldpasswd)
                                .params("newpwd",xinpasswd)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {

                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);

                                    }
                                });

                    }
                }.start();
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_password;
    }
}
