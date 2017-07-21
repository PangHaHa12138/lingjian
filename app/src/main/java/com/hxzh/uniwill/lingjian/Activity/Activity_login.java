package com.hxzh.uniwill.lingjian.Activity;

import android.app.Activity;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.UpdataDialog;
import com.hxzh.uniwill.lingjian.bean.Data_updataVserion;
import com.hxzh.uniwill.lingjian.bean.Date_Denglu;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharePreferencesUtil2;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.senydevpkg.utils.NetworkUtils;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/3/28.
 *  登录
 *
 * userid : d35558c810fd4b9ea3b7482af39ad51d
 * avatar : http://123.56.97.229/upload/1468552674136.jpg
 * deptid : 93434b20c9aa49d1bfadadb9e2004a5c
 * deptname : 软件开发部
 * roleid :
 * rolename :
 * username : 战乃国
 * password : E10ADC3949BA59ABBE56E057F20F883E
 * usertel :
 * usermobile : 18601011394
 * useremail :
 * createtime : 2016-06-12
 * updatetime : 2017-02-07
 * companyid : 4231bfd9d4d140d88af453879e71eef2
 * companyname : 华通众和
 * leaderid : ac31532c3b954a0a9d57fb1e65884775
 * leadername : 薄晓军
 * type : 1
 * sex : 1
 * desc :
 * admin : 0
 * topleader : 0
 * autherid :
 */

public class Activity_login extends Activity  {

    private EditText editTextname;
    private EditText editTextpassword;
    private Button buttonloagin;
    private TextView foget_password;
    private String name,possword2;//用户输入的

                // 用户id，部门id，部门名称，角色id，角色名称，用户名称，性别，用户电话，用户手机，用户邮箱，创建时间，更新时间
    private String userid,avatar,deptid,deptname,roleid,rolename,username,password,
            // 公司id，公司名称，领导id，领导名称，类型，上级
            usertel,usermobile,useremail,createtime,updatetime,companyid,companyname,leaderid,leadername,
            desc,autherid;
    private int type,sex,admin,topleader;
    private Date_Denglu denglu;

    private UpdataDialog updataDialog;
    private Data_updataVserion updataVserion;

    private  String versionName = "";
    private  int versioncode;
    private String oldVersion,NewVersion,versionmsg,url,channelid;
    private TextView tvmsg,tvcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        //百度云推送
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY,"tgFfUEwBRpQknfGGjqOYvVBtwVxvF77E");

        updataDialog = new UpdataDialog(Activity_login.this,R.layout.dialog_updataversion,
                new int[]{R.id.dialog_sure});

        oldVersion =  getAppVersionName(Activity_login.this);

        initview();
        initData();



    }

    /**
     * 返回当前程序版本名  build.gradle
     */
    public  String getAppVersionName(Context context) {
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            versioncode = pi.versionCode;
            LogUtil.d("versionName:---"+versionName,"versioncode:---"+versioncode);
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    private void initData() {
        try {
            OkHttpUtils.get(Http_Api.URL_UpdataVersion)
                    .params("ostype","1")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            updataVserion = JsonUtil.parseJsonToBean(s,Data_updataVserion.class);
                            NewVersion = updataVserion.getVersion();
                            versionmsg = updataVserion.getMess();
                            url = updataVserion.getAddress();
                            String[] n = versionmsg.split("-");
//                            for (int i = 0; i < n.length; i++) {
//                                versionmsg += n[i]+"\n";
//                            }
                            versionmsg = n[0]+"\n"+n[1]+"\n"+n[2];
                            if (!NewVersion.equals(oldVersion)){
                                updataDialog.show();
                                tvmsg = (TextView) updataDialog.findViewById(R.id.updataversion_msg);
                                tvcode = (TextView) updataDialog.findViewById(R.id.updataversioncode);
                                tvcode.setText(NewVersion);
                                tvmsg.setText(versionmsg);
                                updataDialog.setOnCenterItemClickListener(new UpdataDialog.OnCenterItemClickListener() {
                                    @Override
                                    public void OnCenterItemClick(UpdataDialog dialog, View view) {
                                        switch (view.getId()){
                                            case R.id.dialog_sure:
                                                Intent intent= new Intent();
                                                intent.setAction("android.intent.action.VIEW");
                                                Uri content_url = Uri.parse(url);
                                                intent.setData(content_url);
                                                startActivity(intent);
                                                break;
                                        }
                                    }
                                });

                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonloagin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                channelid = SharedPreferencesUtil.readChannelid(Activity_login.this);
               name = editTextname.getText().toString().trim();
               possword2 = editTextpassword.getText().toString().trim();
                LogUtil.d("登录姓名----",name);
                LogUtil.d("登录密码----",possword2);
                LogUtil.d("channelid----",channelid);
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(possword2)){
                    ToastUtil.showToast("用户名或密码不能为空！");
                    return;
                }
                   new Thread(){
                       @Override
                       public void run() {
                           try {
                               OkHttpUtils.get(Http_Api.URL_denglu)
                                       .params("username",name)
                                       .params("password",possword2)
                                       .params("channelId",channelid)
                                       .params("ostype","1")
                                       .execute(new StringCallback() {
                                                    @Override
                                                    public void onSuccess(String s, Call call, Response response) {
                                                         denglu = JsonUtil.parseJsonToBean(s, Date_Denglu.class);
                                                        if (denglu !=null){

                                                            LogUtil.d("获取用户信息----",denglu+"---");
                                                            userid = denglu.getUserid();
                                                            avatar= denglu.getAvatar();
                                                            deptid=denglu.getDeptid();
                                                            deptname=denglu.getDeptname();
                                                            roleid=denglu.getRoleid();
                                                            rolename=denglu.getRolename();
                                                            username=denglu.getUsername();
                                                            password=denglu.getPassword();
                                                            usertel = denglu.getUsertel();
                                                            usermobile = denglu.getUsermobile();
                                                            useremail = denglu.getUseremail();
                                                            createtime = denglu.getCreatetime();
                                                            updatetime = denglu.getUpdatetime();
                                                            companyid = denglu.getCompanyid();
                                                            companyname = denglu.getCompanyname();
                                                            leaderid = denglu.getLeaderid();
                                                            leadername = denglu.getLeadername();
                                                            type = denglu.getType();
                                                            sex = denglu.getSex();
                                                            desc = denglu.getDesc();
                                                            admin = denglu.getAdmin();
                                                            topleader = denglu.getTopleader();
                                                            autherid = denglu.getAutherid();

                                                            SharedPreferencesUtil.writeUserid(userid,Activity_login.this);
                                                            SharedPreferencesUtil.writAvatar(avatar,Activity_login.this);
                                                            SharedPreferencesUtil.writeDeptid(deptid,Activity_login.this);
                                                            SharedPreferencesUtil.writeDeptname(deptname,Activity_login.this);
                                                            SharedPreferencesUtil.writeRoleid(roleid,Activity_login.this);
                                                            SharedPreferencesUtil.writeRolename(rolename,Activity_login.this);
                                                            SharedPreferencesUtil.writeUsername(username,Activity_login.this);
                                                            SharedPreferencesUtil.writePassWord(password,Activity_login.this);
                                                            SharedPreferencesUtil.writeUsertel(usertel,Activity_login.this);
                                                            SharedPreferencesUtil.writeUsermobile(usermobile,Activity_login.this);
                                                            SharedPreferencesUtil.writeUseremail(useremail,Activity_login.this);
                                                            SharedPreferencesUtil.writeCreatetime(createtime,Activity_login.this);
                                                            SharedPreferencesUtil.writeUpdatetime(updatetime,Activity_login.this);
                                                            SharedPreferencesUtil.writeCompanyid(companyid,Activity_login.this);
                                                            SharedPreferencesUtil.writeCompanyname(companyname,Activity_login.this);
                                                            SharedPreferencesUtil.writeLeaderid(leaderid,Activity_login.this);
                                                            SharedPreferencesUtil.writeLeadername(leadername,Activity_login.this);
                                                            SharedPreferencesUtil.writeType(type,Activity_login.this);
                                                            SharedPreferencesUtil.writeSex(sex,Activity_login.this);
                                                            SharedPreferencesUtil.writeDesc(desc,Activity_login.this);
                                                            SharedPreferencesUtil.writeAdmin(admin,Activity_login.this);
                                                            SharedPreferencesUtil.writeTopleader(topleader,Activity_login.this);
                                                            SharedPreferencesUtil.writeAutherid(autherid,Activity_login.this);
                                                            SharedPreferencesUtil.writePossword(possword2,Activity_login.this);

                                                            SharePreferencesUtil2.writeUsername2(name,Activity_login.this);
                                                            SharePreferencesUtil2.writePassword2(possword2,Activity_login.this);


                                                            Intent intent = new Intent(Activity_login.this, MainActivity.class);
                                                            startActivity(intent);
                                                            finish();

                                                        }else {
                                                            ToastUtil.showToast("对不起，用户名或密码错误，无法登录");
                                                        }

                                                    }

                                                    @Override
                                                    public void onError(Call call, Response response, Exception e) {
                                                        super.onError(call, response, e);
                                                        ToastUtil.showToast("对不起，木有网络");
                                                    }
                                                });

                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                       }
                   }.start();
            }
        });

        foget_password.setClickable(true);
        foget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_login.this,Activity_Foget_password.class);
                intent.putExtra("mobile",usermobile);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initview() {
        editTextname = (EditText) findViewById(R.id.name);
        editTextpassword = (EditText) findViewById(R.id.password);
        buttonloagin = (Button) findViewById(R.id.loagin);
        foget_password = (TextView) findViewById(R.id.foget_password);

        if (SharedPreferencesUtil.readUsername(Activity_login.this)!=null){

            editTextname.setText(SharedPreferencesUtil.readUsername(Activity_login.this));
        }
        if (SharedPreferencesUtil.readPossword(Activity_login.this)!=null){

            editTextpassword.setText(SharedPreferencesUtil.readPossword(Activity_login.this));
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


}
