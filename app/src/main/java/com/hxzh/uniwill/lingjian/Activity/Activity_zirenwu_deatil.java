package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.PercentCircle;
import com.hxzh.uniwill.lingjian.bean.Data_huoqurenwuxiangqing;
import com.hxzh.uniwill.lingjian.bean.Data_xiafafujian;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/4/18.
 *  任务进度详情
 */
public class Activity_zirenwu_deatil extends BaseToobarRightViewActivity{

    private PercentCircle jindu;
    private TextView zname,biaozun;
    private String taskid,userid,zerenren,miaoshu,taskidson;
    private int progres;
    private  Data_huoqurenwuxiangqing data_huoqurenwuxiangqing;
    private List<Data_xiafafujian.FileBean> listacc;

    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,
            fujian10;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("任务进度");
        initView();
        initData();
        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
                Intent intent = new Intent(Activity_zirenwu_deatil.this,Activity_Chat.class);
                intent.putExtra("taskidchat",taskidson);
                startActivity(intent);
            }
        });
        onclick();

    }

    private void initView() {
        jindu = (PercentCircle) findViewById(R.id.zirenwu_deatil_jindutiao);
        zname = (TextView) findViewById(R.id.zi_datail_name);
        biaozun = (TextView) findViewById(R.id.zi_datail_biaozhuntext);

        fujian1 = (RelativeLayout) findViewById(R.id.zi_datail_fujian1);
        fujian2 = (RelativeLayout) findViewById(R.id.zi_datail_fujian2);
        fujian3 = (RelativeLayout) findViewById(R.id.zi_datail_fujian3);
        fujian4 = (RelativeLayout) findViewById(R.id.zi_datail_fujian4);
        fujian5 = (RelativeLayout) findViewById(R.id.zi_datail_fujian5);
        fujian6 = (RelativeLayout) findViewById(R.id.zi_datail_fujian6);
        fujian7 = (RelativeLayout) findViewById(R.id.zi_datail_fujian7);
        fujian8 = (RelativeLayout) findViewById(R.id.zi_datail_fujian8);
        fujian9 = (RelativeLayout) findViewById(R.id.zi_datail_fujian9);
        fujian10 = (RelativeLayout) findViewById(R.id.zi_datail_fujian10);
        fujianname1 = (TextView) findViewById(R.id.zi_datail_fujiantext1);
        fujianname2 = (TextView) findViewById(R.id.zi_datail_fujiantext2);
        fujianname3 = (TextView) findViewById(R.id.zi_datail_fujiantext3);
        fujianname4 = (TextView) findViewById(R.id.zi_datail_fujiantext4);
        fujianname5 = (TextView) findViewById(R.id.zi_datail_fujiantext5);
        fujianname6 = (TextView) findViewById(R.id.zi_datail_fujiantext6);
        fujianname7 = (TextView) findViewById(R.id.zi_datail_fujiantext7);
        fujianname8 = (TextView) findViewById(R.id.zi_datail_fujiantext8);
        fujianname9 = (TextView) findViewById(R.id.zi_datail_fujiantext9);
        fujianname10 = (TextView) findViewById(R.id.zi_datail_fujiantext10);

    }


    private void initData() {
        progres = SharedPreferencesUtil.readSonProgress(Activity_zirenwu_deatil.this);
        zerenren = SharedPreferencesUtil.readSonZerenren(Activity_zirenwu_deatil.this);
        miaoshu = SharedPreferencesUtil.readSonMsg(Activity_zirenwu_deatil.this);
        jindu.setTargetPercent(progres);
        zname.setText(zerenren);
        biaozun.setText(miaoshu);

        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskidson");
        taskidson = intent.getStringExtra("taskidchatson");
        userid = intent.getStringExtra("useridson");
//        taskidson = intent.getStringExtra("taskidsonson");
        OkHttpUtils.get(Http_Api.URL_XiafaFujian)
                .params("userid",userid)
                .params("taskid",taskid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Data_xiafafujian xiafafujian = JsonUtil.parseJsonToBean(s,Data_xiafafujian.class);

                        String num = xiafafujian.getResult();

                        listacc = xiafafujian.getFile();

                            if (num.equals("0")){
                                fujian1.setVisibility(View.GONE);
                                fujian2.setVisibility(View.GONE);
                                fujian3.setVisibility(View.GONE);
                                fujian4.setVisibility(View.GONE);
                                fujian5.setVisibility(View.GONE);
                                fujian6.setVisibility(View.GONE);
                                fujian7.setVisibility(View.GONE);
                                fujian8.setVisibility(View.GONE);
                                fujian9.setVisibility(View.GONE);
                                fujian10.setVisibility(View.GONE);
                            }else {
                                if (listacc!= null&&listacc.size()==1){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                }
                                if (listacc!=null&&listacc.size()==2){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!=null&&listacc.size() == 3){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!= null&&listacc.size()==4){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!=null&&listacc.size() == 5){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc != null&&listacc.size() == 6){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc != null&&listacc.size() == 7){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian7.setVisibility(View.VISIBLE);
                                    fujianname7.setText(listacc.get(6).getFileName());
                                    final String url7 = listacc.get(6).getFileaddressdown();
                                    fujian7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url7);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!=null&&listacc.size() == 8){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian7.setVisibility(View.VISIBLE);
                                    fujianname7.setText(listacc.get(6).getFileName());
                                    final String url7 = listacc.get(6).getFileaddressdown();
                                    fujian7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url7);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian8.setVisibility(View.VISIBLE);
                                    fujianname8.setText(listacc.get(7).getFileName());
                                    final String url8 = listacc.get(7).getFileaddressdown();
                                    fujian8.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url8);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!= null&&listacc.size()==9){
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian7.setVisibility(View.VISIBLE);
                                    fujianname7.setText(listacc.get(6).getFileName());
                                    final String url7 = listacc.get(6).getFileaddressdown();
                                    fujian7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url7);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian8.setVisibility(View.VISIBLE);
                                    fujianname8.setText(listacc.get(7).getFileName());
                                    final String url8 = listacc.get(7).getFileaddressdown();
                                    fujian8.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url8);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian9.setVisibility(View.VISIBLE);
                                    fujianname9.setText(listacc.get(8).getFileName());
                                    final String url9 = listacc.get(8).getFileaddressdown();
                                    fujian9.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent= new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url9);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                if (listacc!=null&&listacc.size()==10) {
                                    fujian1.setVisibility(View.VISIBLE);
                                    fujianname1.setText(listacc.get(0).getFileName());
                                    final String url = listacc.get(0).getFileaddressdown();
                                    fujian1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian2.setVisibility(View.VISIBLE);
                                    fujianname2.setText(listacc.get(1).getFileName());
                                    final String url2 = listacc.get(1).getFileaddressdown();
                                    fujian2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url2);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian3.setVisibility(View.VISIBLE);
                                    fujianname3.setText(listacc.get(2).getFileName());
                                    final String url3 = listacc.get(2).getFileaddressdown();
                                    fujian3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url3);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian4.setVisibility(View.VISIBLE);
                                    fujianname4.setText(listacc.get(3).getFileName());
                                    final String url4 = listacc.get(3).getFileaddressdown();
                                    fujian4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url4);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian5.setVisibility(View.VISIBLE);
                                    fujianname5.setText(listacc.get(4).getFileName());
                                    final String url5 = listacc.get(4).getFileaddressdown();
                                    fujian5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url5);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian6.setVisibility(View.VISIBLE);
                                    fujianname6.setText(listacc.get(5).getFileName());
                                    final String url6 = listacc.get(5).getFileaddressdown();
                                    fujian6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url6);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian7.setVisibility(View.VISIBLE);
                                    fujianname7.setText(listacc.get(6).getFileName());
                                    final String url7 = listacc.get(6).getFileaddressdown();
                                    fujian7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url7);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian8.setVisibility(View.VISIBLE);
                                    fujianname8.setText(listacc.get(7).getFileName());
                                    final String url8 = listacc.get(7).getFileaddressdown();
                                    fujian8.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url8);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                    fujian9.setVisibility(View.VISIBLE);
                                    fujianname9.setText(listacc.get(8).getFileName());
                                    final String url9 = listacc.get(8).getFileaddressdown();
                                    fujian9.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url9);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });

                                    fujian10.setVisibility(View.VISIBLE);
                                    fujianname10.setText(listacc.get(9).getFileName());
                                    final String url10 = listacc.get(9).getFileaddressdown();
                                    fujian10.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri content_url = Uri.parse(url10);
                                            intent.setData(content_url);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            }


                    }
                });

    }




    private void onclick() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zirenwu_deatil;
    }
}
