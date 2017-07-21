package com.hxzh.uniwill.lingjian.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
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
import com.hxzh.uniwill.lingjian.base.MessageEvent2;
import com.hxzh.uniwill.lingjian.base.MessageEvent5;
import com.hxzh.uniwill.lingjian.bean.Data_huoquzirenwuliebiao;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/3/31.
 *  添加子任务
 */
public class Activity_zirenwu extends BaseToobarRightViewActivity {

    private String taskid,renwumiaoshu,item,item2,taskcycle,tasktype;

    private LinearLayout zerenr_layout,wancheng_layout,shangbao_layout;
    private RelativeLayout tianjiafujian_layout;
    private EditText zirenwumiaoshu;
    private Button finsh;
    private List<Data_huoquzirenwuliebiao.ListBean> list;
    private Data_huoquzirenwuliebiao zirenwu;
    private Data_huoquzirenwuliebiao.ListBean data;
    private String dateStr;
    private TextView zerenren,wanchengriqi,shangbaozhouqi;
    private ImageView zeren_arr,wancheng_arr,shangbao_arr;
    private String zerrenname = "";
    private String zerrenid = "";
    private Map<Integer,String> useridMap = new HashMap<>();
    private Map<Integer,String> usernameMap ;
    private Set<String> usernameSet = new HashSet<>();
    private Calendar calendar;
    private String userid,zerenren2,riqi2,zhouqi2,miaoshu2;
    private  int a  ;
    private String tag1,tag2,tag3,tag4;

    private RelativeLayout fujian1,fujian2,fujian3,fujian4,fujian5,fujian6,fujian7,fujian8,fujian9,
            fujian10,fujian11,fujian12,fujian13,fujian14,fujian15,fujian16,fujian17,fujian18,fujian19,fujian20;
    private TextView fujianname1,fujianname2,fujianname3,fujianname4,fujianname5,fujianname6,fujianname7,
            fujianname8,fujianname9,fujianname10,fujianname11,fujianname12,fujianname13,fujianname14
            ,fujianname15,fujianname16,fujianname17,fujianname18,fujianname19,fujianname20;

    private static final List<String> options1Items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("待办任务-子任务");
        getToobarRightView().setImageResource(R.drawable.title_but_chat_3x);
        initview();
        initData();

    }

    private void initview() {

        zerenr_layout = (LinearLayout) findViewById(R.id.zirenwu_layout_zerenren);
        wancheng_layout = (LinearLayout) findViewById(R.id.zirenwu_layout_wanchengriqi);
        shangbao_layout = (LinearLayout) findViewById(R.id.zirenwu_layout_shangbaozhouqi);
        tianjiafujian_layout = (RelativeLayout) findViewById(R.id.zirenwu_layout_tianjiafujian);
        finsh = (Button) findViewById(R.id.zirenwu_finsh);
        zirenwumiaoshu = (EditText) findViewById(R.id.zirenwu_miaoshu);

        zerenren = (TextView) findViewById(R.id.zerenren);
        wanchengriqi = (TextView) findViewById(R.id.wancehngriqi);
        shangbaozhouqi = (TextView) findViewById(R.id.shangbaozhouqi);
        zeren_arr = (ImageView) findViewById(R.id.zeren_arr);
        wancheng_arr = (ImageView) findViewById(R.id.wancehngriqi_arr);
        shangbao_arr = (ImageView) findViewById(R.id.shangbao_arr);

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
        fujian11 = (RelativeLayout) findViewById(R.id.fujian11);
        fujian12 = (RelativeLayout) findViewById(R.id.fujian12);
        fujian13 = (RelativeLayout) findViewById(R.id.fujian13);
        fujian14 = (RelativeLayout) findViewById(R.id.fujian14);
        fujian15 = (RelativeLayout) findViewById(R.id.fujian15);
        fujian16 = (RelativeLayout) findViewById(R.id.fujian16);
        fujian17 = (RelativeLayout) findViewById(R.id.fujian17);
        fujian18 = (RelativeLayout) findViewById(R.id.fujian18);
        fujian19 = (RelativeLayout) findViewById(R.id.fujian19);
        fujian20 = (RelativeLayout) findViewById(R.id.fujian20);
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
        fujianname11 = (TextView) findViewById(R.id.fujiantext11);
        fujianname12 = (TextView) findViewById(R.id.fujiantext12);
        fujianname13 = (TextView) findViewById(R.id.fujiantext13);
        fujianname14 = (TextView) findViewById(R.id.fujiantext14);
        fujianname15 = (TextView) findViewById(R.id.fujiantext15);
        fujianname16 = (TextView) findViewById(R.id.fujiantext16);
        fujianname17 = (TextView) findViewById(R.id.fujiantext17);
        fujianname18 = (TextView) findViewById(R.id.fujiantext18);
        fujianname19 = (TextView) findViewById(R.id.fujiantext19);
        fujianname20 = (TextView) findViewById(R.id.fujiantext20);

        userid = SharedPreferencesUtil.readUserid(Activity_zirenwu.this);
        a = SharedPreferencesUtil.readZirenwuNum(Activity_zirenwu.this);
        if (a==1){
            SharedPreferencesUtil.writeZirenwuNumTag1("1",Activity_zirenwu.this);
        }else if (a==2){
            SharedPreferencesUtil.writeZirenwuNumTag2("2",Activity_zirenwu.this);
        }else if (a==3){
            SharedPreferencesUtil.writeZirenwuNumTag3("3",Activity_zirenwu.this);
        }else if (a==4){
            SharedPreferencesUtil.writeZirenwuNumTag4("4",Activity_zirenwu.this);
        }
        else if (a >= 10){
            a = 0;
            SharedPreferences.Editor editor = SharedPreferencesUtil.preferences.edit();
            editor.remove("ZirenwuNumTag1");
            editor.remove("ZirenwuNumTag2");
            editor.remove("ZirenwuNumTag3");
            editor.remove("ZirenwuNumTag4");
            editor.remove("ZirenwuNum");
            editor.commit();
        }
    }

    private void shezhi() {

        zerenren2= SharedPreferencesUtil.readBiaozhun(Activity_zirenwu.this);
        riqi2 = SharedPreferencesUtil.readRiqi(Activity_zirenwu.this);
        zhouqi2 = SharedPreferencesUtil.readZhouqi(Activity_zirenwu.this);
        miaoshu2 = SharedPreferencesUtil.readBiaozhun(Activity_zirenwu.this);

//        Intent intent = getIntent();
//        zerenren2 = intent.getStringExtra("zerenrename1");
//        riqi2 = intent.getStringExtra("wantime1");
//        zhouqi2 = intent.getStringExtra("baozhouqi1");
//        miaoshu2 = intent.getStringExtra("miaoshu1");

        if (zerenren2 != null){
           zerenren.setText(zerenren2);
        }
        if (riqi2 != null){
            wanchengriqi.setText(riqi2);
        }
        if (zhouqi2 != null){
            shangbaozhouqi.setText(zhouqi2);
        }
        if (miaoshu2 != null){
            zirenwumiaoshu.setText(miaoshu2);
        }
    }

    private void initData() {

        Intent intent = getIntent();
        taskid = intent.getStringExtra("taskid");

        getToobarRightView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("聊天");
                Intent intent = new Intent(Activity_zirenwu.this,Activity_Chat.class);
                startActivity(intent);
            }
        });
        OkHttpUtils.get(Http_Api.URL_huoquzirenwu)
                .params("taskid",taskid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                         zirenwu = JsonUtil.parseJsonToBean(s,Data_huoquzirenwuliebiao.class);
                        list = zirenwu.getList();
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });

        EventBus.getDefault().register(this);
        //选责任人
        zerenr_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zerrenname = "";
                zerrenid = "";
                Intent intent = new Intent();
                intent.setClass(Activity_zirenwu.this,Activity_zerenren.class);
//                intent.putExtra()
                startActivity(intent);
            }
        });

        //完成日期
        final Calendar calender = Calendar.getInstance();
//        final Calendar calender1 = Calendar.getInstance();
        wancheng_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //系统自带时间选择器
//                DatePickerDialog dialog = new
//                        DatePickerDialog(Activity_zirenwu.this, new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker view, int year, int monthOfYear, int
//                                    dayOfMonth) {
//
//                                if(monthOfYear<=9){
//                                    mouth1="0"+(monthOfYear+1);
//                                }else{
//                                    mouth1=String.valueOf(monthOfYear+1);
//                                }
//                                if(dayOfMonth<=9){
//                                    day1= "0"+dayOfMonth;
//                                }else{
//                                    day1=String.valueOf(dayOfMonth);
//                                }
//                                dateStr = String.valueOf(year)+"-"+mouth1+"-"+day1;
//                                wanchengriqi.setText(dateStr);
//                                wancheng_arr.setVisibility(View.INVISIBLE);
//                                LogUtil.d("日期",dateStr+"");
//
//
//                            }
//                        }, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH),
//                        calender.get(Calendar.DAY_OF_MONTH));
//                dialog.show();
                //时间选择器
                TimePickerView pvTime = new TimePickerView.Builder(Activity_zirenwu.this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date2,View v) {//选中事件回调
                        dateStr = getTime(date2);
                        wanchengriqi.setText(dateStr);
                        wancheng_arr.setVisibility(View.INVISIBLE);

                    }
                })
                        .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(20)//滚轮文字大小
//                        .setTitleSize(20)//标题文字大小
                        .setSubCalSize(20)//确定和取消文字大小
//                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                        .isCyclic(true)//是否循环滚动
                        .setTitleColor(Color.BLACK)//标题文字颜色
                        .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                        .setCancelColor(Color.BLUE)//取消按钮文字颜色
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

//                View outerView = LayoutInflater.from(Activity_zirenwu.this).inflate(R.layout.wheelview, null);
//                WheelView wv = (WheelView) outerView.findViewById(R.id.wheel_view_wv);
//                wv.setOffset(1);
//                wv.setItems(Arrays.asList(PLANETS));
//                wv.setSeletion(3);
//                wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
//                    @Override
//                    public void onSelected(int selectedIndex, String item) {
//
//                        shangbaozhouqi.setText(item);
//                        shangbao_arr.setVisibility(View.INVISIBLE);
//                        LogUtil.d("[Dialog]selectedIndex:-----" + selectedIndex + "", "item -----"+item);
//                    }
//                });
//
//                new AlertDialog.Builder(Activity_zirenwu.this)
//                        .setTitle("请选择上报周期（^-^）")
//                        .setView(outerView)
//                        .setPositiveButton("OK", null)
//                        .show();


//                条件选择器
                OptionsPickerView pvOptions = new  OptionsPickerView.Builder(Activity_zirenwu.this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                        //返回的分别是三个级别的选中位置
                        item = options1Items.get(options1).toString();
                        shangbaozhouqi.setText(item);//添加子任务周期写死
                        if (item.equals("单次")){
                            item2 = "0";
                            tasktype = "1";
                            taskcycle = null;
                        }else if (item.equals("日报")){
                            item2 = "1";
                            tasktype = "2";
                            taskcycle = "17:30";
                        }else if (item.equals("周报")){
                            item2= "2";
                            tasktype = "2";
                            taskcycle = "星期五";
                        }else if (item.equals("月报")){
                            item2 = "3";
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
                        .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                        .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF333333)//标题背景颜色 Night mode
//                        .setBgColor(0xFF000000)//滚轮背景颜色 Night mode
                        .setContentTextSize(20)//滚轮文字大小
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
        //完成保存
        finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                renwumiaoshu = zirenwumiaoshu.getText().toString().trim();

                if (TextUtils.isEmpty(dateStr)||TextUtils.isEmpty(name22)||TextUtils.isEmpty(renwumiaoshu)||TextUtils.isEmpty(item)){

                    ToastUtil.showToast("责任人/日期/周期/子任务标准 不能为空");
                    return;
                }
                //存值
                SharedPreferencesUtil.writeZerenren(name22,Activity_zirenwu.this);
                SharedPreferencesUtil.writeRiqi(dateStr,Activity_zirenwu.this);
                SharedPreferencesUtil.writeZhouqi(item2,Activity_zirenwu.this);
                SharedPreferencesUtil.writeBiaozhun(renwumiaoshu,Activity_zirenwu.this);
                SharedPreferencesUtil.writeTaskcycle(taskcycle,Activity_zirenwu.this);
                SharedPreferencesUtil.writeTasktype(tasktype,Activity_zirenwu.this);
                SharedPreferencesUtil.writeAdd_SonUserid(id33,Activity_zirenwu.this);
                a++;
                SharedPreferencesUtil.writeZirenwuNum(a,Activity_zirenwu.this);
                LogUtil.d("子任务个数a",a+"");
                String msg = a+"";
                EventBus.getDefault().post(new MessageEvent2(msg));
                finish();
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
    }
    public String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    //文件路径
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            try {
                Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
                LogUtil.d("文件路径--",uri+"");
                String url = FileUtils2.getPath(Activity_zirenwu.this,uri);
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
    public void UploadFile(String url){
        File file = new File(url);
        String filename = file.getName();
        fujianNum++;
        SharedPreferencesUtil.writefjnum(fujianNum,Activity_zirenwu.this);

        if (fujianNum >= 10){
            fujianNum = 0;
        }
        ShowAcc(fujianNum,filename,url);
        LogUtil.d("文件名字",filename+"");
        if (!file.exists()){
            ToastUtil.showToast("文件不存在");
        }
//        OkHttpUtils.post(Http_Api.URL_Fujian_upload)
//                .params("userid",userid)
//                .params("taskid",taskid)
//                .params("file",file)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(String s, Call call, Response response) {
//
//                        LogUtil.d("返回",s+"");
//                    }
//                });
    }

    public void ShowAcc(int o,String m,String url){
        LogUtil.d("文件路径--",url+"");
        if (o == 0){
            fujian11.setVisibility(View.GONE);
            fujian12.setVisibility(View.GONE);
            fujian13.setVisibility(View.GONE);
            fujian14.setVisibility(View.GONE);
            fujian15.setVisibility(View.GONE);
            fujian16.setVisibility(View.GONE);
            fujian17.setVisibility(View.GONE);
            fujian18.setVisibility(View.GONE);
            fujian19.setVisibility(View.GONE);
            fujian20.setVisibility(View.GONE);
        }
        if (o == 1){
            fujian11.setVisibility(View.VISIBLE);
            fujianname11.setText(m);
            SharedPreferencesUtil.writeFilename1(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl1(url,Activity_zirenwu.this);
        }
        if (o == 2){
            fujian12.setVisibility(View.VISIBLE);
            fujianname12.setText(m);
            SharedPreferencesUtil.writeFilename2(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl2(url,Activity_zirenwu.this);
        }
        if (o == 3){
            fujian13.setVisibility(View.VISIBLE);
            fujianname13.setText(m);
            SharedPreferencesUtil.writeFilename3(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl3(url,Activity_zirenwu.this);
        }
        if (o == 4){
            fujian14.setVisibility(View.VISIBLE);
            fujianname14.setText(m);
            SharedPreferencesUtil.writeFilename4(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl4(url,Activity_zirenwu.this);
        }
        if (o ==5){
            fujian15.setVisibility(View.VISIBLE);
            fujianname15.setText(m);
            SharedPreferencesUtil.writeFilename5(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl5(url,Activity_zirenwu.this);
        }
        if (o ==6){
            fujian16.setVisibility(View.VISIBLE);
            fujianname16.setText(m);
            SharedPreferencesUtil.writeFilename6(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl6(url,Activity_zirenwu.this);
        }
        if (o ==7){
            fujian17.setVisibility(View.VISIBLE);
            fujianname17.setText(m);
            SharedPreferencesUtil.writeFilename7(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl7(url,Activity_zirenwu.this);
        }
        if (o ==8){
            fujian18.setVisibility(View.VISIBLE);
            fujianname18.setText(m);
            SharedPreferencesUtil.writeFilename8(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl8(url,Activity_zirenwu.this);
        }
        if (o == 9){
            fujian19.setVisibility(View.VISIBLE);
            fujianname19.setText(m);
            SharedPreferencesUtil.writeFilename9(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl9(url,Activity_zirenwu.this);
        }
        if (o == 10){
            fujian20.setVisibility(View.VISIBLE);
            fujianname20.setText(m);
            SharedPreferencesUtil.writeFilename10(m,Activity_zirenwu.this);
            SharedPreferencesUtil.writeUrl10(url,Activity_zirenwu.this);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    private String name22;
    private String id33;
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent5 messageEvent){
        usernameSet =  messageEvent.getSet();
        for (String s : usernameSet) {
            zerrenname += s+";";
        }
        name22 = removeSameString(zerrenname);
        zerenren.setText(name22);
        LogUtil.d("添加子任务责任人----",name22);
        zeren_arr.setVisibility(View.INVISIBLE);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent2(MessageEvent messageEvent){

        useridMap = messageEvent.getMap();
        for (Integer postion : useridMap.keySet()) {
            //map.keySet()返回的是所有key的值
            zerrenid += useridMap.get(postion)+";";//得到每个key多对用value的值
        }
        id33 = removeSameString(zerrenid);
        LogUtil.d("添加子任务责任人id----",id33);
    }
    /**
     * 去掉重复字符串
     * @param str
     * @return String
     * */
    public  String removeSameString(String str){
        Set<String> mLinkedSet = new LinkedHashSet<String>();
        String[] strArray = str.split(";");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strArray.length; i++)
        {
            if (!mLinkedSet.contains(strArray[i]))
            {
                mLinkedSet.add(strArray[i]);
                sb.append(strArray[i] + ";");
            }else{
                System.out.println("重复字符:"+strArray[i]);
            }
        }
//        System.out.println(mLinkedSet);
        return sb.toString().substring(0, sb.toString().length() - 1);
    }




    @Override
    protected int getLayoutId() {

        return R.layout.activity_zirenwu;
    }
}
