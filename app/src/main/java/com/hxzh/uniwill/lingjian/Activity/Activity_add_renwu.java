package com.hxzh.uniwill.lingjian.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/4/9.
 * 新增任务 --上司下发
 */
public class Activity_add_renwu extends BaseToobarActivity implements View.OnTouchListener{

    private String renming,wcriqi,sbzhouqi,renwumMS,sbzhouqi2;
    private EditText renwumiaoshu;
    private LinearLayout zerenr_layout,wancheng_layout,shangbao_layout,renwuming_layout;
    private RelativeLayout tianjiafujian_layout;
    private Button finsh;
    private TextView Zerenren,wanchengriqi,shangbaozhouqi,renwuMing;

    private ImageView zeren_arr,wancheng_arr,shangbao_arr,renwuming_arr;

    private static final List<String> options1Items = new ArrayList<String>();
    private String zerrenname = "";
    private Set<String> hehe ;

    private String userid,cuserid,taskname,taskcontent,y_endtime,ptaskid,tasktype,tasklevel,taskcycle,cycletype,taskid;

    private String day,week,dayofmonth;//长期任务固定 时间 17：30  星期五  每月最后一天

    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9, fujian10;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7, fujianname8,fujianname9,fujianname10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("新增任务");
        getToobarRightTitle().setText("");
        initView();
        initData();
        onclick();
    }

    private void initView() {
        renwumiaoshu = (EditText) findViewById(R.id.zirenwu_miaoshu2);
        zerenr_layout = (LinearLayout) findViewById(R.id.zirenwu_layout_zerenren2);
        wancheng_layout = (LinearLayout) findViewById(R.id.zirenwu_layout_wanchengriqi2);
        shangbao_layout = (LinearLayout) findViewById(R.id.zirenwu_layout_shangbaozhouqi2);
        tianjiafujian_layout = (RelativeLayout) findViewById(R.id.zirenwu_layout_tianjiafujian2);
        renwuming_layout = (LinearLayout) findViewById(R.id.addrenwu_ming2);
        finsh = (Button) findViewById(R.id.zirenwu_finsh2);
        Zerenren = (TextView) findViewById(R.id.zerenren2);
        wanchengriqi = (TextView) findViewById(R.id.wancehngriqi2);
        shangbaozhouqi = (TextView) findViewById(R.id.shangbaozhouqi2);
        renwuMing = (TextView) findViewById(R.id.rewuming2);
        zeren_arr = (ImageView) findViewById(R.id.zeren_arr2);
        wancheng_arr = (ImageView) findViewById(R.id.wancehngriqi_arr2);
        shangbao_arr = (ImageView) findViewById(R.id.shangbao_arr2);
        renwuming_arr = (ImageView) findViewById(R.id.renwuming_arr2);

        fujian1 = (RelativeLayout) findViewById(R.id.fujian1);
        fujian2 = (RelativeLayout) findViewById(R.id.fujian2);
        fujian3 = (RelativeLayout) findViewById(R.id.fujian3);
        fujian4 = (RelativeLayout) findViewById(R.id.fujian4);
        fujian5 = (RelativeLayout) findViewById(R.id.fujian5);
        fujian6 = (RelativeLayout) findViewById(R.id.fujian6);
        fujian7 = (RelativeLayout) findViewById(R.id.fujian7);
        fujian8 = (RelativeLayout) findViewById(R.id.fujian8);
        fujian9 = (RelativeLayout) findViewById(R.id.fujian9);
        fujian10 = (RelativeLayout) findViewById(R.id.fujian10);

        fujianname1 = (TextView) findViewById(R.id.fujiantext1);
        fujianname2 = (TextView) findViewById(R.id.fujiantext2);
        fujianname3 = (TextView) findViewById(R.id.fujiantext3);
        fujianname4 = (TextView) findViewById(R.id.fujiantext4);
        fujianname5 = (TextView) findViewById(R.id.fujiantext5);
        fujianname6 = (TextView) findViewById(R.id.fujiantext6);
        fujianname7 = (TextView) findViewById(R.id.fujiantext7);
        fujianname8 = (TextView) findViewById(R.id.fujiantext8);
        fujianname9 = (TextView) findViewById(R.id.fujiantext9);
        fujianname10 = (TextView) findViewById(R.id.fujiantext10);


    }
    private void initData() {
        renwumiaoshu.setOnTouchListener(this);
        zerrenname = SharedPreferencesUtil.readUsername(Activity_add_renwu.this);
        Zerenren.setText(zerrenname);
        zeren_arr.setVisibility(View.INVISIBLE);

    }

    private void onclick() {
        EventBus.getDefault().register(this);
        //任务名
        renwuming_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity_add_renwu.this,Activity_addRWname.class);
//                intent.putExtra()
                startActivity(intent);

            }
        });
        //责任人
//        zerenr_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(Activity_add_renwu.this,Activity_zerenren.class);
////                intent.putExtra()
//                startActivity(intent);
//
//            }
//        });

        //完成日期
        wancheng_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerView pvTime = new TimePickerView.Builder(Activity_add_renwu.this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date2, View v) {//选中事件回调
                        wcriqi = getTime(date2);
                        wanchengriqi.setText(wcriqi);
                        wancheng_arr.setVisibility(View.INVISIBLE);

                    }
                })
                        .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(20)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .isCyclic(true)//是否循环滚动
                        .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                        .setTitleColor(Color.BLACK)//标题文字颜色
                        .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                        .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
//                        .setLabel("年","月","日","时","分","秒")
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                        .build();
                pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime.show();

            }
        });
        options1Items.clear();
        options1Items.add("单次");
        options1Items.add("日报");
        options1Items.add("周报");
        options1Items.add("月报");
        //上报周期
        shangbao_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //条件选择器
                OptionsPickerView pvOptions = new  OptionsPickerView.Builder(Activity_add_renwu.this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                        //返回的分别是三个级别的选中位置
                        sbzhouqi = options1Items.get(options1).toString();
                        shangbaozhouqi.setText(sbzhouqi);
                        if (sbzhouqi.equals("单次")){
                            sbzhouqi2 = "0";
                            tasktype = "1";
                            taskcycle = null;
                        }else if (sbzhouqi.equals("日报")){
                            sbzhouqi2 = "1";
                            tasktype = "2";
                            taskcycle = "17:30";
                        }else if (sbzhouqi.equals("周报")){
                            sbzhouqi2= "2";
                            tasktype = "2";
                            taskcycle = "星期五";
                        }else if (sbzhouqi.equals("月报")){
                            sbzhouqi2 = "3";
                            tasktype = "2";
                            taskcycle = "32";
                        }
                        shangbao_arr.setVisibility(View.INVISIBLE);;
                    }
                })
//                        .setSubmitText("确定")//确定按钮文字
//                        .setCancelText("取消")//取消按钮文字
//                        .setTitleText("城市选择")//标题
                        .setSubCalSize(20)//确定和取消文字大小
//                        .setTitleSize(20)//标题文字大小
//                        .setTitleColor(Color.BLACK)//标题文字颜色
                        .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                        .setCancelColor(Color.BLACK)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF333333)//标题背景颜色 Night mode
//                        .setBgColor(0xFF000000)//滚轮背景颜色 Night mode
//                        .setContentTextSize(18)//滚轮文字大小
//                        .setTextColorCenter(Color.BLUE)//设置选中项的颜色
                        .setTextColorCenter(Color.BLACK)//设置选中项的颜色
//                        .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
//                        .setLinkage(false)//设置是否联动，默认true
//                        .setLabels("省", "市", "区")//设置选择的三级单位
//                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .setCyclic(false, false, false)//循环与否
//                        .setSelectOptions(1, 1, 1)  //设置默认选中项
//                        .setOutSideCancelable(false)//点击外部dismiss default true
//                        .isDialog(true)//是否显示为对话框样式
                        .build();
                pvOptions.setPicker(options1Items);
                pvOptions.show();

            }
        });
        //添加附件
        tianjiafujian_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        //完成
        finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                renwumMS = renwumiaoshu.getText().toString().trim();//描述
                cuserid = SharedPreferencesUtil.readLeaderid(Activity_add_renwu.this);
                userid = SharedPreferencesUtil.readUserid(Activity_add_renwu.this);
                taskname = renming;
                taskcontent = renwumMS;
                y_endtime = wcriqi;
//                tasktype = "1";
                tasklevel = "6";
                cycletype = sbzhouqi2;
                if (TextUtils.isEmpty(renming)||TextUtils.isEmpty(renwumMS)||TextUtils.isEmpty(sbzhouqi)||TextUtils.isEmpty(wcriqi)||TextUtils.isEmpty(zerrenname)){
                    ToastUtil.showToast("任务名称/完成日期/任务描述/上报周期/责任人 不能为空");
                    return;
                }

                OkHttpUtils.post(Http_Api.URL_zirenwushangbao)
                        .params("cuserid",cuserid)//创建任务人
                        .params("taskname",taskname)//任务名称
                        .params("taskcontent",taskcontent)//任务内容
                        .params("userids",userid)//任务接收人：id1;id2，ID以分号隔开
                        .params("y_endtime",y_endtime)//预计结束时间，格式：yyyy-MM-dd
                        .params("tasktype",tasktype)//任务类型 1=当期任务 2=长期任务
                        .params("tasklevel",tasklevel)//重要程度 1=重要+ 2=重要 3=重要- 4=正常+ 5=正常 6=正常-
                        .params("taskcycle",taskcycle)//长期任务循环周期
                        .params("cycletype",cycletype)//周期类型 1=日 2=周 3=月
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                Data_uploadBack_tag data_uploadBack_tag =
                                        JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                if (data_uploadBack_tag.getResult().equals("1")){

                                    String taskd = data_uploadBack_tag.getTaskid();

                                    if (fileList.size()>0){
                                        for (int i = 0; i < fileList.size(); i++) {
                                            httpfileuup(fileList.get(i),taskd);
                                        }
                                    }

                                    ToastUtil.showToast("上传成功");
                                    LogUtil.d("返回结果",data_uploadBack_tag.getResult());
                                    finish();
//                                    LogUtil.d("返回原因",data_uploadBack_tag.getFailcode());
                                }else {

                                    ToastUtil.showToast("上传失败");
                                }
                            }

                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);

                                ToastUtil.showToast("联网失败");
                            }
                        });


            }
        });


    }
//    //文件路径
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
//            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
//            String[] proj = {MediaStore.Images.Media.DATA};
//            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
//            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            actualimagecursor.moveToFirst();
//            String img_path = actualimagecursor.getString(actual_image_column_index);
//            File file = new File(img_path);
//            Toast.makeText(Activity_add_renwu.this, file.toString(), Toast.LENGTH_SHORT).show();
//        }
//    }

    //文件路径
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            try {
                Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
                LogUtil.d("文件路径--",uri+"");
                String url = FileUtils2.getPath(Activity_add_renwu.this,uri);
                String url2 = url.trim();
                UploadFile(url2);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
//            String[] proj = {MediaStore.Images.Media.DATA};
//            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
//            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            actualimagecursor.moveToFirst();
//            String img_path = actualimagecursor.getString(actual_image_column_index);
//            File file = new File(img_path);
//            Toast.makeText(Activity_zirenwu.this, file.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private int fujianNum = 0;
    private List<File> fileList = new ArrayList<>();
    public void UploadFile(String url){
        File file = new File(url);
        String filename = file.getName();
        fujianNum++;
//        SharedPreferencesUtil.writefjnum(fujianNum,Activity_add_renwu.this);

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

    public void httpfileuup(File file,String taskid){

        try {
            OkHttpUtils.post(Http_Api.URL_Fujian_upload)
                    .params("userid",userid)
                    .params("taskid",taskid)
                    .params("assid","")
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

    public void ShowAcc(int o,String m){
        if (o == 0){
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
        if (o == 1){
            fujian1.setVisibility(View.VISIBLE);
            fujianname1.setText(m);
        }
        if (o == 2){
            fujian2.setVisibility(View.VISIBLE);
            fujianname2.setText(m);
        }
        if (o == 3){
            fujian3.setVisibility(View.VISIBLE);
            fujianname3.setText(m);
        }
        if (o == 4){
            fujian4.setVisibility(View.VISIBLE);
            fujianname4.setText(m);
        }
        if (o ==5){
            fujian5.setVisibility(View.VISIBLE);
            fujianname5.setText(m);
        }
        if (o ==6){
            fujian6.setVisibility(View.VISIBLE);
            fujianname6.setText(m);
        }
        if (o ==7){
            fujian7.setVisibility(View.VISIBLE);
            fujianname7.setText(m);
        }
        if (o ==8){
            fujian8.setVisibility(View.VISIBLE);
            fujianname8.setText(m);
        }
        if (o == 9){
            fujian9.setVisibility(View.VISIBLE);
            fujianname9.setText(m);
        }
        if (o == 10){
            fujian10.setVisibility(View.VISIBLE);
            fujianname10.setText(m);
        }
    }




    public String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMoonEvent(MessageEvent5 messageEvent){
//
//        hehe =  messageEvent.getSet();
//        for (String s : hehe) {
//            zerrenname += s+";";
//        }
//        Zerenren.setText(zerrenname);
//        zeren_arr.setVisibility(View.INVISIBLE);
//
//    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent2(MessageEvent messageEvent){

        renming = messageEvent.getMessage().toString();

        renwuMing.setText(renming);
        renwuming_arr.setVisibility(View.INVISIBLE);

    }
    //获取当前月最后一天
    public String getayofmMonth(){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        System.out.println("===============last:"+last);
        return last;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_addrenwu;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        //触摸的是EditText并且当前EditText可以滚动则将事件交给EditText处理；否则将事件交由其父类处理
        if ((view.getId() == R.id.zirenwu_miaoshu2 &&canVerticalScroll(renwumiaoshu))) {
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
