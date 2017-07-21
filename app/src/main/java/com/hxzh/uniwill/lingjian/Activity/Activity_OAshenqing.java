package com.hxzh.uniwill.lingjian.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.base.MessageEventOA1;
import com.hxzh.uniwill.lingjian.base.MessageEventOA2;
import com.hxzh.uniwill.lingjian.base.MessageEventOA3;
import com.hxzh.uniwill.lingjian.bean.Data_bill;
import com.hxzh.uniwill.lingjian.bean.Data_oashenqingdell;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.utils.FileUtils2;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
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
public class Activity_OAshenqing extends BaseToobarRightViewActivity implements View.OnTouchListener{

    private TextView shenpiname,shenpitype,nextman,shenpimessage;
    private EditText shenpimsg;
    private RelativeLayout genzong,adddanju,shenminglayout,sptype;
    private Button change;
    private String billid,billid2,worktype,gongdanname,gongdanname2="",contenmsg="",nextperson="",addtypeid="",typename="",addmsg="",userid="";
    private List<Data_oashenqingdell.BillBean> billlist;
    private List<Data_oashenqingdell.ListAccBean> listacc;
    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,fujian10,
            danju1,danju2,danju3,danju4,danju5,danju6,danju7,danju8,danju9,danju10;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10,danjutext1,danjutext2,danjutext3,danjutext4,
            danjutext5,danjutext6,danjutext7,danjutext8,danjutext9,danjutext10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getToolbarTitle().setText("申请详情");
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

        shenpiname = (TextView) findViewById(R.id.shenqingname);
        shenpitype = (TextView) findViewById(R.id.shenqingtype);
        nextman = (TextView) findViewById(R.id.xiayiburen);
        shenpimessage = (TextView) findViewById(R.id.shenmesage);
        shenpimsg = (EditText) findViewById(R.id.shenqingsm);
        genzong = (RelativeLayout) findViewById(R.id.genzong);
        adddanju = (RelativeLayout) findViewById(R.id.tianjiadanju);
        shenminglayout = (RelativeLayout) findViewById(R.id.shenminglayout);
        sptype = (RelativeLayout) findViewById(R.id.sptype);
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

    }
    private Data_oashenqingdell oashenqingdell;
    private String statustype;

    private void initdata() {

        userid = SharedPreferencesUtil.readUserid(Activity_OAshenqing.this);
        shenpimsg.setOnTouchListener(this);
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
                            worktype =billlist.get(0).getWokertype();
                            gongdanname = billlist.get(0).getTitle();
                            contenmsg = billlist.get(0).getCont();
                            nextperson = billlist.get(0).getCusername();
                            billid2 = billlist.get(0).getBillid();
                            statustype = billlist.get(0).getStatustype();

                            shenpiname.setText(gongdanname);
                            shenpitype.setText(worktype);
                            shenpimsg.setText(contenmsg);
                            nextman.setText(nextperson);

                            if (statustype.equals("0")){//已完成
                                shenminglayout.setClickable(false);
                                sptype.setClickable(false);
                                adddanju.setClickable(false);
                                change.setVisibility(View.INVISIBLE);
                                shenpimsg.setVisibility(View.GONE);
                                shenpimessage.setText(contenmsg);

                            }else if (statustype.equals("2")){//审批中
                                shenminglayout.setClickable(false);
                                sptype.setClickable(false);
                                adddanju.setClickable(false);
                                change.setVisibility(View.INVISIBLE);
                                shenpimsg.setVisibility(View.GONE);
                                shenpimessage.setText(contenmsg);
                            }else if (statustype.equals("1")){//待审批

                            }else if (statustype.equals("3")){//被打回

                            }

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

        EventBus.getDefault().register(this);
        shenminglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_OAshenqing.this,Activity_addGDname.class);
                startActivity(intent);
            }
        });

        sptype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity_OAshenqing.this,ShenQingType.class);

                startActivity(intent);

            }
        });

        genzong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_OAshenqing.this,Activity_genzong.class);
                intent.putExtra("billid",billid2);
                startActivity(intent);
            }
        });

        adddanju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("添加单据");
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent,1);
                //startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), 1);
                //intent.setType(“image/*”);//选择图片
                //intent.setType(“audio/*”); //选择音频
                //intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
                //intent.setType(“video/*;image/*”);//同时选择视频和图片

            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addmsg = shenpimsg.getText().toString().trim();
                String addmessage,addname;

                if (!addmsg.isEmpty()){
                    addmessage = addmsg;
                }else {
                    addmessage = contenmsg;
                }
                if (!gongdanname2.isEmpty()){
                    addname = gongdanname2;
                }else {
                    addname = gongdanname;
                }
                if (addtypeid.isEmpty()){
                    addtypeid = "";
                }

                if (fileList.size()>0){
                    for (int i = 0; i < fileList.size(); i++) {
                        httpfileuup(fileList.get(i),billid2);
                    }
                }

                try {
                    OkHttpUtils.post(Http_Api.URL_ShenQingdelete)
                            .params("billid",billid2)
                            .params("workCont",addmessage)
                            .params("workname",addname)
                            .params("workid",addtypeid)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {

                                    Data_bill bill = JsonUtil.parseJsonToBean(s,Data_bill.class);
                                    if (bill.getResult().equals("1")){
                                        ToastUtil.showToast("修改成功");
                                        finish();
                                    }
                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void httpfileuup(File file,String taskid){

        try {
            OkHttpUtils.post(Http_Api.URL_GongdanFileUpload)
                    .params("userid",userid)
                    .params("billid",taskid)
                    .params("file",file)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                            LogUtil.d("返回",s+"");
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //文件路径
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK){//是否选择，没选择就不会继续
            try {
                Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
                LogUtil.d("文件路径--",uri+"");
                String url = FileUtils2.getPath(Activity_OAshenqing.this,uri);
                String url2 = url.trim();
                UploadFile(url2);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            String[] proj = {MediaStore.Images.Media.DATA};
//            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
//            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            actualimagecursor.moveToFirst();
//            String img_path = actualimagecursor.getString(actual_image_column_index);
//            File file = new File(img_path);
//            Toast.makeText(Activity_Deatail.this, file.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    private int fujianNum = 0;
    private List<File> fileList = new ArrayList<>();

    public void UploadFile(String url){
        File file = new File(url);
        String filename = file.getName();
        fujianNum++;
        if (fujianNum >= 10){
            fujianNum = 0;
        }
        ShowAcc(fujianNum,filename);
        LogUtil.d("文件名字",filename+"");
        if (!file.exists()){
            ToastUtil.showToast("文件不存在");
        }
        try {
            fileList.add(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void ShowAcc(int o,String m){
        if (o == 0){
            danju1.setVisibility(View.GONE);
            danju2.setVisibility(View.GONE);
            danju3.setVisibility(View.GONE);
            danju4.setVisibility(View.GONE);
            danju5.setVisibility(View.GONE);
            danju6.setVisibility(View.GONE);
            danju7.setVisibility(View.GONE);
            danju8.setVisibility(View.GONE);
            danju9.setVisibility(View.GONE);
            danju10.setVisibility(View.GONE);
        }
        if (o == 1){
            danju1.setVisibility(View.VISIBLE);
            danjutext1.setText(m);
        }
        if (o == 2){
            danju2.setVisibility(View.VISIBLE);
            danjutext2.setText(m);
        }
        if (o == 3){
            danju3.setVisibility(View.VISIBLE);
            danjutext3.setText(m);
        }
        if (o == 4){
            danju4.setVisibility(View.VISIBLE);
            danjutext4.setText(m);
        }
        if (o ==5){
            danju5.setVisibility(View.VISIBLE);
            danjutext5.setText(m);
        }
        if (o ==6){
            danju6.setVisibility(View.VISIBLE);
            danjutext6.setText(m);
        }
        if (o ==7){
            danju7.setVisibility(View.VISIBLE);
            danjutext7.setText(m);
        }
        if (o ==8){
            danju8.setVisibility(View.VISIBLE);
            danjutext8.setText(m);
        }
        if (o == 9){
            danju9.setVisibility(View.VISIBLE);
            danjutext9.setText(m);
        }
        if (o >= 10){
            danju10.setVisibility(View.VISIBLE);
            danjutext10.setText(m);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEventOA1 messageEvent){

        gongdanname2 = messageEvent.getMessage();
        shenpiname.setText(gongdanname2);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent3(MessageEventOA2 messageEvent){

        addtypeid = messageEvent.getMessage();
        LogUtil.d("传的id",addtypeid+"");

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent2(MessageEventOA3 messageEvent){

         typename = messageEvent.getMessage();
        shenpitype.setText(typename);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_oashenqingdell;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        //触摸的是EditText并且当前EditText可以滚动则将事件交给EditText处理；否则将事件交由其父类处理
        if ((view.getId() == R.id.shenqingsm &&canVerticalScroll(shenpimsg))) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (event.getAction() == MotionEvent.ACTION_UP) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }

    /**
     * EditText竖直方向是否可以滚动
     * @param editText  需要判断的EditText
     * @return  true：可以滚动   false：不可以滚动
     */
    private boolean canVerticalScroll(EditText editText) {
        //滚动的距离
        int scrollY = editText.getScrollY();
        //控件内容的总高度
        int scrollRange = editText.getLayout().getHeight();
        //控件实际显示的高度
        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() -editText.getCompoundPaddingBottom();
        //控件内容总高度与实际显示高度的差值
        int scrollDifference = scrollRange - scrollExtent;

        if(scrollDifference == 0) {
            return false;
        }

        return (scrollY > 0) || (scrollY < scrollDifference - 1);
    }
}
