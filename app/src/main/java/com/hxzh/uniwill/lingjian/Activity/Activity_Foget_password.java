package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/3/30.
 *  忘记密码
 */
public class Activity_Foget_password extends BaseToobarActivity {

    private EditText yonghuming;
    private EditText youxiang;
    private Button find_possword;
    private String username,mobile,youxiang2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("忘记密码");
        getToobarRightTitle().setText("");
        initView();
        initData();

    }

    private void initData() {

        username = yonghuming.getText().toString().trim();
        youxiang2 = youxiang.getText().toString().trim();
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
        find_possword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(username)||TextUtils.isEmpty(youxiang2)){
                    ToastUtil.showToast("用户名或邮箱不能为空");
                    return;
                }

                OkHttpUtils
                        .post(Http_Api.URL_wangjimima)
                        .params("username",username)
                        .params("mobile",mobile)
                        .params("useremail",youxiang2)
                        .execute(new StringDialogCallback(Activity_Foget_password.this) {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                    ToastUtil.showToast("重置的密码已发送至您的邮箱");
                            }

                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);
                                ToastUtil.showToast("error");
                            }
                        });
            }
        });

    }

    private void initView() {
        yonghuming = (EditText) findViewById(R.id.yonghu_name);
        youxiang = (EditText) findViewById(R.id.yonghu_box);
        find_possword = (Button) findViewById(R.id.find_possword);

    }

    //显示返回键
    @Override
    protected boolean isShowBacking() {
        return super.isShowBacking();
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_foget_password;
    }
}