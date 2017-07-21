package com.hxzh.uniwill.lingjian.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.base.MessageEventOA1;
import com.hxzh.uniwill.lingjian.base.MessageEventOA2;
import com.hxzh.uniwill.lingjian.base.MessageEventOA3;
import com.hxzh.uniwill.lingjian.bean.Data_bill;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
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

/***
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
 * <p>
 * Created by PangHaHa12138 on 2017/6/26.
 */
public class Activity_oagdshenqing extends BaseToobarActivity implements View.OnTouchListener{

    private RelativeLayout shenminglayout,tianjiadanju,sptype;

    private TextView shenqingname,shenqingtype,nextren,danjutext1,danjutext2,danjutext3,danjutext4,
            danjutext5,danjutext6,danjutext7,danjutext8,danjutext9,danjutext10,danjutext11,danjutext12,
            danjutext13,danjutext14,danjutext15,danjutext16,danjutext17,danjutext18,danjutext19,danjutext20;

    private EditText shenqingsm;
    private RelativeLayout danju1,danju2,danju3,danju4,danju5,danju6,danju7,danju8,danju9,danju10,
            danju11,danju12,danju13,danju14,danju15,danju16,danju17,danju18,danju19,danju20;

    private String gongdanname,shenqingshuoming,userid,addtypeid,typename;

    private ImageView shenarr ,spiarr;
    private Button finshadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getToolbarTitle().setText("工单申请");
        getToobarRightTitle().setText("");
        initview();
        initdata();

    }

    private void initdata() {

        userid = SharedPreferencesUtil.readUserid(Activity_oagdshenqing.this);
        shenqingsm.setOnTouchListener(this);

        EventBus.getDefault().register(this);
        shenminglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_oagdshenqing.this,Activity_addGDname.class);

                startActivity(intent);
            }
        });

        sptype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity_oagdshenqing.this,ShenQingType.class);

                startActivity(intent);
            }
        });

        tianjiadanju.setOnClickListener(new View.OnClickListener() {
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
        //完成保存
        finshadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shenqingshuoming = shenqingsm.getText().toString().trim();

                if (TextUtils.isEmpty(shenqingshuoming)||TextUtils.isEmpty(gongdanname)||
                        TextUtils.isEmpty(addtypeid)){
                    ToastUtil.showToast("工单名称/工单类型/工单描述 不能为空！");
                    LogUtil.d("name",gongdanname+"");
                    LogUtil.d("id",addtypeid+"");
                    LogUtil.d("miaoshu",shenqingshuoming+"");
                    return;
                }

                try {
                    OkHttpUtils.post(Http_Api.URL_Gongdan_Create)
                            .params("userid",userid)
                            .params("workCont",shenqingshuoming)
                            .params("workname",gongdanname)
                            .params("workid",addtypeid)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {

                                    Data_bill bill =
                                            JsonUtil.parseJsonToBean(s,Data_bill.class);
                                    if (bill.getResult().equals("1")){

                                        String taskd = bill.getBillid();

                                        if (fileList.size()>0){
                                            for (int i = 0; i < fileList.size(); i++) {
                                                httpfileuup(fileList.get(i),taskd);
                                            }
                                        }

                                        ToastUtil.showToast("上传成功");
                                        LogUtil.d("返回结果===>",bill.getResult()+"");
                                        finish();
    //                                    LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                    }else {

                                        ToastUtil.showToast("上传失败");
                                    }
                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("上传失败");
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
                String url = FileUtils2.getPath(Activity_oagdshenqing.this,uri);
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

    private void initview() {

        shenminglayout = (RelativeLayout) findViewById(R.id.shenminglayout);
        tianjiadanju = (RelativeLayout) findViewById(R.id.tianjiadanju);
        sptype = (RelativeLayout) findViewById(R.id.sptype);
        shenqingname = (TextView) findViewById(R.id.shenqingname);
        shenqingsm = (EditText) findViewById(R.id.shenqingsm);
        shenqingtype = (TextView) findViewById(R.id.shenqingtype);
        shenarr = (ImageView) findViewById(R.id.shenarr);
        spiarr = (ImageView) findViewById(R.id.spiarr);
        finshadd = (Button) findViewById(R.id.shenqingbut);

        danju1 = (RelativeLayout) findViewById(R.id.danju1);
        danju2 = (RelativeLayout) findViewById(R.id.danju2);
        danju3 = (RelativeLayout) findViewById(R.id.danju3);
        danju4 = (RelativeLayout) findViewById(R.id.danju4);
        danju5 = (RelativeLayout) findViewById(R.id.danju5);
        danju6 = (RelativeLayout) findViewById(R.id.danju6);
        danju7 = (RelativeLayout) findViewById(R.id.danju7);
        danju8 = (RelativeLayout) findViewById(R.id.danju8);
        danju9 = (RelativeLayout) findViewById(R.id.danju9);
        danju10 = (RelativeLayout) findViewById(R.id.danju10);
        danju11 = (RelativeLayout) findViewById(R.id.danju11);
        danju12 = (RelativeLayout) findViewById(R.id.danju12);
        danju13 = (RelativeLayout) findViewById(R.id.danju13);
        danju14 = (RelativeLayout) findViewById(R.id.danju14);
        danju15 = (RelativeLayout) findViewById(R.id.danju15);
        danju16 = (RelativeLayout) findViewById(R.id.danju16);
        danju17 = (RelativeLayout) findViewById(R.id.danju17);
        danju18 = (RelativeLayout) findViewById(R.id.danju18);
        danju19 = (RelativeLayout) findViewById(R.id.danju19);
        danju20 = (RelativeLayout) findViewById(R.id.danju20);
        danjutext1 = (TextView) findViewById(R.id.danjutext1);
        danjutext2 = (TextView) findViewById(R.id.danjutext2);
        danjutext3 = (TextView) findViewById(R.id.danjutext3);
        danjutext4 = (TextView) findViewById(R.id.danjutext4);
        danjutext5 = (TextView) findViewById(R.id.danjutext5);
        danjutext6 = (TextView) findViewById(R.id.danjutext6);
        danjutext7 = (TextView) findViewById(R.id.danjutext7);
        danjutext8 = (TextView) findViewById(R.id.danjutext8);
        danjutext9 = (TextView) findViewById(R.id.danjutext9);
        danjutext10 = (TextView) findViewById(R.id.danjutext10);
        danjutext11 = (TextView) findViewById(R.id.danjutext11);
        danjutext12 = (TextView) findViewById(R.id.danjutext12);
        danjutext13 = (TextView) findViewById(R.id.danjutext13);
        danjutext14 = (TextView) findViewById(R.id.danjutext14);
        danjutext15 = (TextView) findViewById(R.id.danjutext15);
        danjutext16 = (TextView) findViewById(R.id.danjutext16);
        danjutext17 = (TextView) findViewById(R.id.danjutext17);
        danjutext18 = (TextView) findViewById(R.id.danjutext18);
        danjutext19 = (TextView) findViewById(R.id.danjutext19);
        danjutext20 = (TextView) findViewById(R.id.danjutext20);


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEventOA1 messageEvent){

        gongdanname = messageEvent.getMessage();
        shenqingname.setText(gongdanname);
        shenarr.setVisibility(View.INVISIBLE);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent3(MessageEventOA2 messageEvent){

        addtypeid = messageEvent.getMessage();
        LogUtil.d("传的id",addtypeid+"");

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent2(MessageEventOA3 messageEvent){

        typename = messageEvent.getMessage();
        shenqingtype.setText(typename);
        spiarr.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_oagdshenqing;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        //触摸的是EditText并且当前EditText可以滚动则将事件交给EditText处理；否则将事件交由其父类处理
        if ((view.getId() == R.id.shenqingsm &&canVerticalScroll(shenqingsm))) {
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
