package com.hxzh.uniwill.lingjian.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.base.MessageEventOA1;
import com.hxzh.uniwill.lingjian.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by pang on 2017/4/12.
 */
public class Activity_addGDname extends BaseToobarActivity{
    private EditText editText;
    private String name ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("新增工单");
        getToobarRightTitle().setText("保存");

        editText  = (EditText) findViewById(R.id.rwname);
        getToobarRightTitle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString().trim();
                EventBus.getDefault().post(new MessageEventOA1(name));

                LogUtil.d("任务名--->>",name);
                finish();

            }
        });


    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_gdname;
    }
}
