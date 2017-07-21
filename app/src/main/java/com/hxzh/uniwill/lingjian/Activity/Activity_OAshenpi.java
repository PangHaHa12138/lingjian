package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.CenterDialog;
import com.hxzh.uniwill.lingjian.bean.Data_bill;
import com.hxzh.uniwill.lingjian.bean.Data_oashenqingdell;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
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
 *
 * @ClassName: Activity_OAshenqing
 * @PackageName: com.hxzh.uniwill.lingjian.Activity
 * @Create On 2017/7/18 13:55
 * @Author: PangHaHa12138
 * @CSDN: http://blog.csdn.net/panghaha12138
 * @GitHub: https://github.com/PangHaHa12138
 * @jianshu: http://www.jianshu.com/u/4e577623e3f8
 * @Copyrights 2017/7/18 PangHaHa12138 All rights reserved.
 */
public class Activity_OAshenpi extends BaseToobarRightViewActivity {

    private TextView shenpiname,shenpitype;
    private TextView shenpimsg;
    private RelativeLayout genzong,adddanju;
    private Button change;
    private String billid,billid2;
    private Data_oashenqingdell oashenqingdell;
    private List<Data_oashenqingdell.BillBean> billlist;
    private List<Data_oashenqingdell.ListAccBean> listacc;
    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,fujian10,
            danju1,danju2,danju3,danju4,danju5,danju6,danju7,danju8,danju9,danju10;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10,danjutext1,danjutext2,danjutext3,danjutext4,
            danjutext5,danjutext6,danjutext7,danjutext8,danjutext9,danjutext10;
    private CenterDialog centerDialog;
    EditText editText;
    String userid,newscontent,type,step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getToolbarTitle().setText("审批详情");
        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
            }
        });

        initview();
        initdata();
    }


    private void initview() {

        Intent intent = getIntent();
        if (intent.getStringExtra("billid")!=null){

            billid = intent.getStringExtra("billid");
        }

        userid = SharedPreferencesUtil.readUserid(Activity_OAshenpi.this);

        shenpiname = (TextView) findViewById(R.id.shenqingname);
        shenpitype = (TextView) findViewById(R.id.shenqingtype);
//        nextman = (TextView) findViewById(R.id.xiayiburen);
        shenpimsg = (TextView) findViewById(R.id.shenqingsm);
        genzong = (RelativeLayout) findViewById(R.id.genzong);
        adddanju = (RelativeLayout) findViewById(R.id.tianjiadanju);
        change = (Button) findViewById(R.id.changgebutton);

        fujian1 = (RelativeLayout)findViewById(R.id.danju1);
        fujian2 = (RelativeLayout)findViewById(R.id.danju2);
        fujian3 = (RelativeLayout)findViewById(R.id.danju3);
        fujian4 = (RelativeLayout)findViewById(R.id.danju4);
        fujian5 = (RelativeLayout)findViewById(R.id.danju5);
        fujian6 = (RelativeLayout)findViewById(R.id.danju6);
        fujian7 = (RelativeLayout)findViewById(R.id.danju7);
        fujian8 = (RelativeLayout)findViewById(R.id.danju8);
        fujian9 = (RelativeLayout) findViewById(R.id.danju9);
        fujian10 = (RelativeLayout)findViewById(R.id.danju10);
        danju1 = (RelativeLayout)findViewById(R.id.danju11);
        danju2 = (RelativeLayout)findViewById(R.id.danju12);
        danju3 = (RelativeLayout)findViewById(R.id.danju13);
        danju4 = (RelativeLayout)findViewById(R.id.danju14);
        danju5 = (RelativeLayout)findViewById(R.id.danju15);
        danju6 = (RelativeLayout)findViewById(R.id.danju16);
        danju7 = (RelativeLayout)findViewById(R.id.danju17);
        danju8 = (RelativeLayout)findViewById(R.id.danju18);
        danju9 = (RelativeLayout) findViewById(R.id.danju19);
        danju10 = (RelativeLayout)findViewById(R.id.danju20);
        fujianname1 = (TextView)findViewById(R.id.danjutext1);
        fujianname2 = (TextView)findViewById(R.id.danjutext2);
        fujianname3 = (TextView)findViewById(R.id.danjutext3);
        fujianname4 = (TextView)findViewById(R.id.danjutext4);
        fujianname5 = (TextView)findViewById(R.id.danjutext5);
        fujianname6 = (TextView)findViewById(R.id.danjutext6);
        fujianname7 = (TextView)findViewById(R.id.danjutext7);
        fujianname8 = (TextView)findViewById(R.id.danjutext8);
        fujianname9 = (TextView)findViewById(R.id.danjutext9);
        fujianname10 = (TextView)findViewById(R.id.danjutext10);
        danjutext1 = (TextView)findViewById(R.id.danjutext11);
        danjutext2 = (TextView)findViewById(R.id.danjutext12);
        danjutext3 = (TextView)findViewById(R.id.danjutext13);
        danjutext4 = (TextView)findViewById(R.id.danjutext14);
        danjutext5 = (TextView)findViewById(R.id.danjutext15);
        danjutext6 = (TextView)findViewById(R.id.danjutext16);
        danjutext7 = (TextView)findViewById(R.id.danjutext17);
        danjutext8 = (TextView)findViewById(R.id.danjutext18);
        danjutext9 = (TextView)findViewById(R.id.danjutext19);
        danjutext10 = (TextView)findViewById(R.id.danjutext20);

        centerDialog = new CenterDialog(Activity_OAshenpi.this,R.layout.dialog_layout2,
                new int[]{R.id.dialog_cancel, R.id.dialog_sure});
    }


    private void initdata() {

        try {
            OkHttpUtils.post(Http_Api.URL_ShenQingdetile)
                    .params("billid",billid)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            oashenqingdell = JsonUtil.parseJsonToBean(s,Data_oashenqingdell.class);
                            if (oashenqingdell.getBill()!=null){
                                billlist = oashenqingdell.getBill();
                            }
                            if (oashenqingdell.getListAcc()!=null){
                                listacc = oashenqingdell.getListAcc();
                            }
                            shenpiname.setText(billlist.get(0).getTitle());
                            shenpitype.setText(billlist.get(0).getUsername());
                            shenpimsg.setText(billlist.get(0).getCont());
                            billid2 = billlist.get(0).getBillid();
                            step = billlist.get(0).getStep();

                            if (listacc == null){
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
                            }
                            if (listacc!= null&&listacc.size()==1){
                                fujian1.setVisibility(View.VISIBLE);
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname3.setText(listacc.get(2).getName());
                                final String url3 = listacc.get(2).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname3.setText(listacc.get(2).getName());
                                final String url3 = listacc.get(2).getAddress();
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
                                fujianname4.setText(listacc.get(3).getName());
                                final String url4 = listacc.get(3).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname3.setText(listacc.get(2).getName());
                                final String url3 = listacc.get(2).getAddress();
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
                                fujianname4.setText(listacc.get(3).getName());
                                final String url4 = listacc.get(3).getAddress();
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
                                fujianname5.setText(listacc.get(4).getName());
                                final String url5 = listacc.get(4).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname3.setText(listacc.get(2).getName());
                                final String url3 = listacc.get(2).getAddress();
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
                                fujianname4.setText(listacc.get(3).getName());
                                final String url4 = listacc.get(3).getAddress();
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
                                fujianname5.setText(listacc.get(4).getName());
                                final String url5 = listacc.get(4).getAddress();
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
                                fujianname6.setText(listacc.get(5).getName());
                                final String url6 = listacc.get(5).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname3.setText(listacc.get(2).getName());
                                final String url3 = listacc.get(2).getAddress();
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
                                fujianname4.setText(listacc.get(3).getName());
                                final String url4 = listacc.get(3).getAddress();
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
                                fujianname5.setText(listacc.get(4).getName());
                                final String url5 = listacc.get(4).getAddress();
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
                                fujianname6.setText(listacc.get(5).getName());
                                final String url6 = listacc.get(5).getAddress();
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
                                fujianname7.setText(listacc.get(6).getName());
                                final String url7 = listacc.get(6).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname3.setText(listacc.get(2).getName());
                                final String url3 = listacc.get(2).getAddress();
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
                                fujianname4.setText(listacc.get(3).getName());
                                final String url4 = listacc.get(3).getAddress();
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
                                fujianname5.setText(listacc.get(4).getName());
                                final String url5 = listacc.get(4).getAddress();
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
                                fujianname6.setText(listacc.get(5).getName());
                                final String url6 = listacc.get(5).getAddress();
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
                                fujianname7.setText(listacc.get(6).getName());
                                final String url7 = listacc.get(6).getAddress();
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
                                fujianname8.setText(listacc.get(7).getName());
                                final String url8 = listacc.get(7).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname3.setText(listacc.get(2).getName());
                                final String url3 = listacc.get(2).getAddress();
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
                                fujianname4.setText(listacc.get(3).getName());
                                final String url4 = listacc.get(3).getAddress();
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
                                fujianname5.setText(listacc.get(4).getName());
                                final String url5 = listacc.get(4).getAddress();
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
                                fujianname6.setText(listacc.get(5).getName());
                                final String url6 = listacc.get(5).getAddress();
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
                                fujianname7.setText(listacc.get(6).getName());
                                final String url7 = listacc.get(6).getAddress();
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
                                fujianname8.setText(listacc.get(7).getName());
                                final String url8 = listacc.get(7).getAddress();
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
                                fujianname9.setText(listacc.get(8).getName());
                                final String url9 = listacc.get(8).getAddress();
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
                                fujianname1.setText(listacc.get(0).getName());
                                final String url = listacc.get(0).getAddress();
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
                                fujianname2.setText(listacc.get(1).getName());
                                final String url2 = listacc.get(1).getAddress();
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
                                fujianname3.setText(listacc.get(2).getName());
                                final String url3 = listacc.get(2).getAddress();
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
                                fujianname4.setText(listacc.get(3).getName());
                                final String url4 = listacc.get(3).getAddress();
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
                                fujianname5.setText(listacc.get(4).getName());
                                final String url5 = listacc.get(4).getAddress();
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
                                fujianname6.setText(listacc.get(5).getName());
                                final String url6 = listacc.get(5).getAddress();
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
                                fujianname7.setText(listacc.get(6).getName());
                                final String url7 = listacc.get(6).getAddress();
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
                                fujianname8.setText(listacc.get(7).getName());
                                final String url8 = listacc.get(7).getAddress();
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
                                fujianname9.setText(listacc.get(8).getName());
                                final String url9 = listacc.get(8).getAddress();
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
                                fujianname10.setText(listacc.get(9).getName());
                                final String url10 = listacc.get(9).getAddress();
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
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        genzong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_OAshenpi.this,Activity_genzong.class);
                intent.putExtra("billid",billid2);
                startActivity(intent);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                centerDialog.show();
                centerDialog.setOnCenterItemClickListener(new CenterDialog.OnCenterItemClickListener() {
                    @Override
                    public void OnCenterItemClick(CenterDialog dialog, View view) {

                        editText = (EditText) dialog.findViewById(R.id.shenpiyijian);

                        String msg = editText.getText().toString().trim();

                        switch (view.getId()){

                            case R.id.dialog_cancel:

                                LogUtil.d("msg=====>",msg+"");
                                try {
                                    OkHttpUtils.post(Http_Api.URL_shenhetijiao)
                                            .params("billid",billid2)
                                            .params("userid",userid)
                                            .params("newscontent",msg)
                                            .params("type","0")
                                            .params("step",step)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_bill bill = JsonUtil.parseJsonToBean(s,Data_bill.class);
                                                    if (bill.getResult().equals("1")){
                                                        ToastUtil.showToast("未通过审批");
                                                        finish();
                                                    }
                                                }
                                            });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                break;

                            case R.id.dialog_sure:
                                LogUtil.d("msg=====>",msg+"");
                                try {
                                    OkHttpUtils.post(Http_Api.URL_shenhetijiao)
                                            .params("billid",billid2)
                                            .params("userid",userid)
                                            .params("newscontent",msg)
                                            .params("type","1")
                                            .params("step",step)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(String s, Call call, Response response) {
                                                    Data_bill bill = JsonUtil.parseJsonToBean(s,Data_bill.class);
                                                    if (bill.getResult().equals("1")){
                                                        ToastUtil.showToast("通过审批");
                                                        finish();
                                                    }
                                                }
                                            });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                break;
                        }
                    }
                });
            }
        });
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_oashenpidell;
    }
}
