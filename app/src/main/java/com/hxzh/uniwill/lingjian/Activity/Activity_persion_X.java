package com.hxzh.uniwill.lingjian.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.CircleImageView;
import com.hxzh.uniwill.lingjian.View.MyDialog;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.base.MessageEvent2;
import com.hxzh.uniwill.lingjian.base.MessageEvent3;
import com.hxzh.uniwill.lingjian.bean.Data_photoDownload;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
import com.hxzh.uniwill.lingjian.bean.Data_yonghu_detail;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.json.StringDialogCallback;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/3/31.
 *  个人信息页
 */
public class Activity_persion_X extends BaseToobarActivity implements
        View.OnClickListener{

    private RelativeLayout xiugaitouxiang;
    private EditText personphonenumber,persontellphone,personemail;
    private TextView persionname,personjob,gongsiname,bumenname,leadname;
    private Button finsh_seting;
    private ImageView red1,red2,red3,red4,red5,red6,red7,red8;
    private String url,url2,name,job,compyname,bumen,lead,tel,phone,email,userid;
    private String name2,job2,compyname2,bumen2,lead2,tel2,phone2,email2;
    private MyDialog myDialog;
    private CircleImageView Circle;
//    private ImageView my_img, img_edit;
    /* 头像文件 */
    private  String IMAGE_FILE_NAME ;
    private  String HeadPortrait_PATH;
    private Data_yonghu_detail yonghu_detail;
    private Data_photoDownload photoDownload;
    /* 请求识别码 */
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;

    // 裁剪后图片的宽(X)和高(Y),100 X 100的正方形。
    private static int output_X = 150;
    private static int output_Y = 150;
    private Bitmap photo;
    private int REQUEST_TAKE_PHOTO_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("个人设置");
        getToobarRightTitle().setText("修改密码");
        initview();
        initData();
        getToobarRightTitle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_persion_X.this,Activity_change_password.class);
                startActivity(intent);
                ToastUtil.showToast("修改密码");
            }
        });

    }

    //用当前时间给取得的图片命名
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyy-MM-dd_HH:mm:ss");
        return dateFormat.format(date) + ".jpg";
    }
    //初始化数据
    private void initData() {

        IMAGE_FILE_NAME = getPhotoFileName();
        HeadPortrait_PATH = Environment.getExternalStorageDirectory()
                + "/lingjian2/" + IMAGE_FILE_NAME ;

        userid = SharedPreferencesUtil.readUserid(Activity_persion_X.this);

        OkHttpUtils.get(Http_Api.URL_yonghu_detail)
                .params("userid",userid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                         yonghu_detail = JsonUtil.parseJsonToBean(s,Data_yonghu_detail.class);
                        url = yonghu_detail.getAvatar();
                        LogUtil.d("url---",url+"");
                        Glide.with(Activity_persion_X.this).load(url).diskCacheStrategy(DiskCacheStrategy.RESULT).into(Circle);
                        name = yonghu_detail.getUsername();
                        if (!name.isEmpty()){
                            persionname.setText(name);
                            red1.setVisibility(View.INVISIBLE);
                        }else {
                            red1.setVisibility(View.VISIBLE);
                        }
                        job = yonghu_detail.getRolename();
                        if (!job.isEmpty()){
                            personjob.setText(job);
                            red2.setVisibility(View.INVISIBLE);
                        }else {
                            red2.setVisibility(View.VISIBLE);
                        }
                        compyname = yonghu_detail.getCompanyname();
                        if (!compyname.isEmpty()){
                            gongsiname.setText(compyname);
                            red3.setVisibility(View.INVISIBLE);
                        }else {
                            red3.setVisibility(View.VISIBLE);
                        }
                        bumen = yonghu_detail.getDeptname();
                        if (!bumen.isEmpty()){
                            bumenname.setText(bumen);
                            red4.setVisibility(View.INVISIBLE);
                        }else {
                            red4.setVisibility(View.VISIBLE);
                        }
                        lead = yonghu_detail.getLeadername();
                        if (!lead.isEmpty()){
                            leadname.setText(lead);
                            red5.setVisibility(View.INVISIBLE);
                        }else {
                            red5.setVisibility(View.VISIBLE);
                        }
                        tel = yonghu_detail.getUsertel();
                        if (!tel.isEmpty()){
                            personphonenumber.setText(tel);
                            red6.setVisibility(View.INVISIBLE);
                        }else {
                            red6.setVisibility(View.VISIBLE);
                        }
                        phone = yonghu_detail.getUsermobile();
                        if (!phone.isEmpty()){
                            persontellphone.setText(phone);
                            red7.setVisibility(View.INVISIBLE);
                        }else {
                            red7.setVisibility(View.VISIBLE);
                        }
                        email = yonghu_detail.getUseremail();
                        if (!email.isEmpty()){
                            personemail.setText(email);
                            red8.setVisibility(View.INVISIBLE);
                        }else {
                            red8.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }
    //初始化控件id
    private void initview() {
        xiugaitouxiang = (RelativeLayout) findViewById(R.id.seting_touxiang_layout);
        finsh_seting = (Button) findViewById(R.id.seting_baocun);
        persionname = (TextView) findViewById(R.id.persionname);
        personjob = (TextView) findViewById(R.id.personjob);
        gongsiname = (TextView) findViewById(R.id.gongsiname);
        bumenname = (TextView) findViewById(R.id.bumenname);
        leadname = (TextView) findViewById(R.id.leadname);
        personphonenumber = (EditText) findViewById(R.id.personphonenumber);
        persontellphone = (EditText) findViewById(R.id.persontellphone);
        personemail = (EditText) findViewById(R.id.personemail);
        red1 = (ImageView) findViewById(R.id.redone);
        red2 = (ImageView) findViewById(R.id.redtwo);
        red3 = (ImageView) findViewById(R.id.redthree);
        red4 = (ImageView) findViewById(R.id.redfour);
        red5 = (ImageView) findViewById(R.id.redfive);
        red6 = (ImageView) findViewById(R.id.redsix);
        red7 = (ImageView) findViewById(R.id.redseven);
        red8 = (ImageView) findViewById(R.id.rednine);

        Circle = (CircleImageView) findViewById(R.id.Circle);
        xiugaitouxiang.setOnClickListener(this);
        finsh_seting.setOnClickListener(this);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_persion_x;
    }
    //请求成功


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //设置头像
            case R.id.seting_touxiang_layout:
                myDialog = new MyDialog(Activity_persion_X.this);
                myDialog.show();
                //拍照
                myDialog.set_paizhao_OnclickListener(new MyDialog.onPaizhao_OnclickListener() {
                    @Override
                    public void paizhao_onClick() {
                        choseHeadImageFromCameraCapture();
                        myDialog.dismiss();
                    }
                });
                //相册
                myDialog.set_xiangce_OnclickListener(new MyDialog.onXiangce_OnclickListener() {
                    @Override
                    public void xiangce_onClick() {
                        choseHeadImageFromGallery();
                        myDialog.dismiss();
                    }
                });

                break;

            //保存
            case R.id.seting_baocun:
//           "[\u4e00-\u9fa5]{2,4}"中文姓名
//          "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"邮箱
//          "^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$"手机号
//                name2 = persionname.getText().toString().trim();
//                job2 = personjob.getText().toString().trim();
//                compyname2 = gongsiname.getText().toString().trim();
//                bumen2 = bumenname.getText().toString().trim();
//                lead2 = leadname.getText().toString().trim();
                tel2 = personphonenumber.getText().toString().trim();
                phone2 = persontellphone.getText().toString().trim();
                email2 = personemail.getText().toString().trim();
//                if (name2.isEmpty()&&job2.isEmpty()&&compyname2.isEmpty()&&bumen2.isEmpty()&&lead2.isEmpty()&&tel2.isEmpty()&&phone2.isEmpty()&&email2.isEmpty()){
//                    ToastUtil.showToast("姓名/职位/公司姓名/部门/领导/电话/手机号/邮箱不能为空！");
//                    return;
//                }
                if (tel2.isEmpty()||phone2.isEmpty()||email2.isEmpty()){
                    ToastUtil.showToast("电话/手机号/邮箱不能为空！");
                    return;
                }
                if (!isMobileNO(phone2)){
                    ToastUtil.showToast("手机号格式不对！");
                    return;
                }
                if (!isEmialNO(email2)){
                    ToastUtil.showToast("邮箱格式不对！");
                    return;
                }
                if (!isTelNO(tel2)){
                    ToastUtil.showToast("电话号格式不对！");
                    return;
                }
                try {
                    OkHttpUtils.post(Http_Api.URL_gerenzhongxinxiugai)
                            .params("userid",userid)
                            .params("tel",tel2)
                            .params("mobile",phone2)
                            .params("email",email2)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (back_tag.getResult().equals("1")){
                                        ToastUtil.showToast("修改完成");
//                                        Glide.get(Activity_persion_X.this).clearDiskCache();
                                        finish();
                                    }else {
                                        LogUtil.d("失败原因",back_tag.getFailcode()+"");
                                        ToastUtil.showToast(back_tag.getFailcode()+"修改失败");
                                    }
                                }
                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                File file = new File(HeadPortrait_PATH);
//                if (!file.exists()){
//                    ToastUtil.showToast("文件不存在");
//                }
//                try {
//                    OkHttpUtils.post(Http_Api.URL_photoUpload)
//                            .params("userid",userid)
//                            .params("file",file)
//                            .execute(new StringCallback() {
//                                @Override
//                                public void onSuccess(String s, Call call, Response response) {
//                                    photoDownload = JsonUtil.parseJsonToBean(s,Data_photoDownload.class);
//                                    url2 = photoDownload.getUrl();
//    //                                Glide.with(Activity_persion_X.this).load(url2).into(Circle);
//                                    LogUtil.d("返回结果---",s+"");
//                                    EventBus.getDefault().post(new MessageEvent2(url2));
//                                }
//                            });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

                break;
        }

    }
    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
    /**
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9

     "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
    */
        String telRegex = "[1][3587]\\d{9}";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
    /**
     * 验证邮箱
     */
    public static boolean isEmialNO(String mobiles) {
    /**
     "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"邮箱
    */
        String telRegex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
    /**
     * 验证固话
     */
    public static boolean isTelNO(String mobiles) {
        /**
         "(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^0?[1][358][0-9]{9}$) 同时验证手机号和固定电话

         \\d{2,3}-\\d{4,9}|0\\d{2,3}-\\d{4,9}$

         */
        String telRegex = "\\d{2,3}-\\d{4,9}|0\\d{2,3}-\\d{4,9}$";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
    // 从本地相册选取图片作为头像
    private void choseHeadImageFromGallery() {
        Intent intentFromGallery = new Intent();
        // 设置文件类型
        intentFromGallery.setType("image/*");
        intentFromGallery.setAction(Intent.ACTION_PICK);
        startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
    }

    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        //6.0以上动态获取权限
        if (ContextCompat.checkSelfPermission(Activity_persion_X.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //申请权限，REQUEST_TAKE_PHOTO_PERMISSION是自定义的常量
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_TAKE_PHOTO_PERMISSION);

    } else {
            Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // 判断存储卡是否可用，存储照片文件
            if (hasSdcard()) {

                intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                        .fromFile(new File(Environment
                                .getExternalStorageDirectory(), IMAGE_FILE_NAME)));
            }
            startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);
    }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_TAKE_PHOTO_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //申请成功，可以拍照
               choseHeadImageFromCameraCapture();
            } else {
               ToastUtil.showToast("你拒绝了权限，该功能不可用\n可在应用设置里授权拍照哦");
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {
//            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }

        switch (requestCode) {
            case CODE_GALLERY_REQUEST:
                cropRawPhoto(intent.getData());
                break;

            case CODE_CAMERA_REQUEST:
                if (hasSdcard()) {
                    File tempFile = new File(
                            Environment.getExternalStorageDirectory(),
                            IMAGE_FILE_NAME);
                    cropRawPhoto(Uri.fromFile(tempFile));
                } else {
                    ToastUtil.showToast("没有sd卡");
                }

                break;

            case CODE_RESULT_REQUEST:
                if (intent != null) {
                    setImageToHeadView(intent);
                    File file = new File(
                            Environment.getExternalStorageDirectory(),
                            IMAGE_FILE_NAME);
                    if (file.exists()&&!file.isDirectory()){
                        file.delete();
                    }
                }

                break;
        }

        super.onActivityResult(requestCode, resultCode, intent);
    }

    /**
     * 裁剪原始的图片
     */
    public void cropRawPhoto(Uri uri) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");

        // 设置裁剪
        intent.putExtra("crop", "true");

        // aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);

        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }

    /**
     * 提取保存裁剪之后的图片数据，并设置头像部分的View
     */
    private void setImageToHeadView(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            photo = extras.getParcelable("data");
//            photo = intent.getParcelableExtra("data");
            Circle.setImageBitmap(photo);
            File nf = new File(Environment.getExternalStorageDirectory()+"/lingjian2");
            nf.mkdir();
            //在根目录下面的ASk文件夹下 创建okkk.jpg文件
            File f = new File(Environment.getExternalStorageDirectory()+"/lingjian2", IMAGE_FILE_NAME);
            FileOutputStream out = null;
            try {      //打开输出流 将图片数据填入文件中
                out = new FileOutputStream(f);
                photo.compress(Bitmap.CompressFormat.PNG, 90, out);

                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            File file = new File(HeadPortrait_PATH);
            if (!file.exists()){
                ToastUtil.showToast("文件不存在");
            }
            try {
                OkHttpUtils.post(Http_Api.URL_photoUpload)
                        .params("userid",userid)
                        .params("file",file)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                photoDownload = JsonUtil.parseJsonToBean(s,Data_photoDownload.class);
                                url2 = photoDownload.getUrl();
                                LogUtil.d("返回结果---",s+"");
                                EventBus.getDefault().post(new MessageEvent3(url2));
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //保存图片
    private void SavePhoto(Bitmap photo) {
        File f = new File(HeadPortrait_PATH);
        try {
            FileOutputStream out = new FileOutputStream(f);
            photo.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            LogUtil.d("filephoto","已经保存");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }

}
