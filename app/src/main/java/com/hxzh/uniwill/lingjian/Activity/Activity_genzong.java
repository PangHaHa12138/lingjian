package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.hxzh.uniwill.lingjian.Adapter.OAshenhejiluAdapter;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_genzongjilu;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
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
 * @ClassName: Activity_genzong
 * @PackageName: com.hxzh.uniwill.lingjian.Activity
 * @Create On 2017/7/19 10:05
 * @Author: PangHaHa12138
 * @CSDN: http://blog.csdn.net/panghaha12138
 * @GitHub: https://github.com/PangHaHa12138
 * @jianshu: http://www.jianshu.com/u/4e577623e3f8
 * @Copyrights 2017/7/19 PangHaHa12138 All rights reserved.
 */
public class Activity_genzong extends BaseToobarActivity {

    private ListView shenhelistview;
    private String billid;
    Data_genzongjilu genzongjilu;
    List<Data_genzongjilu.ExamineBean> list;
    OAshenhejiluAdapter oAshenhejiluAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getToolbarTitle().setText("工单进度跟踪");
        getToobarRightTitle().setText("");
        initview();
        initdata();
    }

    private void initdata() {

        Intent intent = getIntent();

        billid = intent.getStringExtra("billid");

        try {
            OkHttpUtils.post(Http_Api.URL_Shenhejindu)
                    .params("billid",billid)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {

                             genzongjilu = JsonUtil.parseJsonToBean(s,Data_genzongjilu.class);
                            if (genzongjilu.getExamine()!=null){
                                list = genzongjilu.getExamine();
                                oAshenhejiluAdapter = new OAshenhejiluAdapter(Activity_genzong.this,list);
                                shenhelistview.setAdapter(oAshenhejiluAdapter);
                            }

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void initview() {
        shenhelistview = (ListView) findViewById(R.id.shenhejilulistview);

        shenhelistview.setDividerHeight(0);//去掉分割线
        shenhelistview.setCacheColorHint(0);
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_genzong;
    }
}
