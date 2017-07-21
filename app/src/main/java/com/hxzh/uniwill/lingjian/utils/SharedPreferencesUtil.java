package com.hxzh.uniwill.lingjian.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by pang on 17/3/30.
 *
 *  缓存工具类
 */
public class SharedPreferencesUtil {

    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;


    /**
     * 读取获取Channelid
     *
     * @param context
     * @return
     */
    public static String readChannelid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Channelid", "");
    }

    public static void writeChannelid(String userid, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Channelid", userid);
        editor.commit();
    }

    /**
     * 读取获取userid
     *
     * @param context
     * @return
     */
    public static String readUserid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("userid", "");
    }

    public static void writeUserid(String userid, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("userid", userid);
        editor.commit();
    }

    /**
     * 读取获取头像
     *
     * @param context
     * @return
     */
    public static String readAvatar(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Avatar", "");
    }

    public static void writAvatar(String history, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Avatar", history);
        editor.commit();
    }

    /**
     * 读取部门名称
     *
     * @param context
     * @return
     */
    public static String readDeptid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Deptid", "");
    }

    public static void writeDeptid(String userId, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Deptid", userId);
        editor.commit();
    }

    /**
     * 读取角色id
     *
     * @param context
     * @return
     */
    public static String readDeptname(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Deptname", "");
    }

    public static void writeDeptname(String custId, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Deptname", custId);
        editor.commit();
    }

    /**
     * 读取角色名称
     *
     * @param context
     * @return
     */
    public static String readRoleid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Roleid", "");
    }

    public static void writeRoleid(String nickname, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Roleid", nickname);
        editor.commit();
    }

//    /**
//     * 读取保存token
//     *
//     * @param context
//     * @return
//     */
//    public static String readToken(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getString("token", "");
//    }
//
//    /**
//     * 保存token
//     *
//     * @param token
//     * @param context
//     */
//    public static void writeToken(String token, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putString("token", token);
//        editor.commit();
//    }

    /**
     * 读取保存
     *
     * @param context
     * @return
     */
    public static String readRolename(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Rolename", "");
    }

    /**
     * 保存
     *
     * @param phone
     * @param context
     */
    public static void writeRolename(String phone, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Rolename", phone);
        editor.commit();
    }

    /**
     * 读取保存password
     *
     * @param context
     * @return
     */
    public static String readPassWord(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("password", "");
    }

    /**
     * 保存password
     *
     * @param password
     * @param context
     */
    public static void writePassWord(String password, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("password", password);
        editor.commit();
    }

    /**
     * 读取保存输入的
     *
     * @param context
     * @return
     */
    public static String readPossword(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Password2", "");
    }

    /**
     * 保存password
     *
     * @param password
     * @param context
     */
    public static void writePossword(String password, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Password2", password);
        editor.commit();
    }

    /**
     * 读取用户名
     *
     * @param context
     * @return
     */
    public static String readUsername(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Username", "");
    }

    public static void writeUsername(String personImg, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Username", personImg);
        editor.commit();
    }

    /**
     * 读取
     *
     * @param context
     * @return
     */
    public static String readUsertel(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Usertel", "");
    }

    public static void writeUsertel(String linShiPhone, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Usertel", linShiPhone);
        editor.commit();
    }

    /**
     * 读取邮箱
     *
     * @param context
     * @return
     */
    public static String readUseremail(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Useremail", "");
    }

    public static void writeUseremail(String linShiCard, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Useremail", linShiCard);
        editor.commit();
    }

    /**
     * 读取更新时间
     * @param context
     * @return
     */
    public static String readUpdatetime(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Updatetime", "");
    }

    public static void writeUpdatetime(String listBuy, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Updatetime", listBuy);
        editor.commit();
    }

    /**
     * 读取部门id
     * @param context
     * @return
     */
    public static String readCompanyid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Companyid", "");
    }

    public static void writeCompanyid(String listSale, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Companyid", listSale);
        editor.commit();
    }

    /**
     * 读取部门姓名
     * @param context
     * @return
     */
    public static String readCompanyname(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Companyname", "");
    }

    public static void writeCompanyname(String areaBuy, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Companyname", areaBuy);
        editor.commit();
    }

    /**
     * 读取领导id
     * @param context
     * @return
     */
    public static String readLeaderid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Leaderid", "");
    }

    public static void writeLeaderid(String areaSale, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Leaderid", areaSale);
        editor.commit();
    }

    /**
     * 读取领导姓名
     * @param context
     * @return
     */
    public static String readLeadername(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Leadername", "");
    }

    public static void writeLeadername(String indstruy, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Leadername", indstruy);
        editor.commit();
    }



    /**
     * 读取描述
     * @param context
     * @return
     */
    public static String readDesc(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Desc", "");
    }

    public static void writeDesc(String scoreShow, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Desc", scoreShow);
        editor.commit();
    }
    /**
     * 读取类型 int
     * @param context
     * @return
     */
    public static int readType(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("Type", 0);
    }

    public static void writeType(int cust_state, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("Type", cust_state);
        editor.commit();
    }

    /**
     * 读取性别 int
     * @param context
     * @return
     */
    public static int readSex(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("Sex", 0);
    }

    public static void writeSex(int cust_state, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("Sex", cust_state);
        editor.commit();
    }

    /**
     * 读取管理员 int
     * @param context
     * @return
     */
    public static int readAdmin(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("Admin", 0);
    }

    public static void writeAdmin(int card_state, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("Admin", card_state);
        editor.commit();
    }

    /**
     * 读取上级领导 int
     * @param context
     * @return
     */
    public static int readTopleader(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("Topleader", 0);
    }

    public static void writeTopleader(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("Topleader", score);
        editor.commit();
    }

    /**
     * 读取
     * @param context
     * @return
     */
    public static String readAutherid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Autherid", "");
    }

    public static void writeAutherid(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Autherid", imageList);
        editor.commit();
    }


    /**
     * 读取手机号
     * @param context
     * @return
     */
    public static String readUsermobile(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Usermobile", "");
    }

    public static void writeUsermobile(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Usermobile", imageList);
        editor.commit();
    }

    /**
     * 读取创建时间
     * @param context
     * @return
     */
    public static String readCreatetime(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Createtime", "");
    }

    public static void writeCreatetime(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Createtime", imageList);
        editor.commit();
    }

    /**
     * 读取添加责任人
     * @param context
     * @return
     */
    public static String readZrenren(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("addZerenren", "");
    }

    public static void writeZerenren(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("addZerenren", imageList);
        editor.commit();
    }

    /**
     * 读取添加周期
     * @param context
     * @return
     */
    public static String readZhouqi(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Zhouqi", "");
    }

    public static void writeZhouqi(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Zhouqi", imageList);
        editor.commit();
    }

    /**
     * 读取添加日期
     * @param context
     * @return
     */
    public static String readRiqi(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Riqi", "");
    }

    public static void writeRiqi(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Riqi", imageList);
        editor.commit();
    }

    /**
     * 读取任务标准
     * @param context
     * @return
     */
    public static String readBiaozhun(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Biaozhun", "");
    }

    public static void writeBiaozhun(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Biaozhun", imageList);
        editor.commit();
    }

    /**
     * 读取子任务个数
     * @param context
     * @return
     */
    public static int readZirenwuNum(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("ZirenwuNum", 0);
    }

    public static void writeZirenwuNum(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("ZirenwuNum", score);
        editor.commit();
    }

    /**
     * 读取子任务个数标记
     * @param context
     * @return
     */
    public static String readZirenwuNumTag1(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("ZirenwuNumTag1", "");
    }

    public static void writeZirenwuNumTag1(String score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("ZirenwuNumTag1", score);
        editor.commit();
    }

    /**
     * 读取子任务个数标记
     * @param context
     * @return
     */
    public static String readZirenwuNumTag2(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("ZirenwuNumTag2", "");
    }

    public static void writeZirenwuNumTag2(String score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("ZirenwuNumTag2", score);
        editor.commit();
    }

    /**
     * 读取子任务个数标记
     * @param context
     * @return
     */
    public static String readZirenwuNumTag3(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("ZirenwuNumTag3", "");
    }

    public static void writeZirenwuNumTag3(String score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("ZirenwuNumTag3", score);
        editor.commit();
    }

    /**
     * 读取子任务个数标记
     * @param context
     * @return
     */
    public static String readZirenwuNumTag4(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("ZirenwuNumTag4", "");
    }

    public static void writeZirenwuNumTag4(String score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("ZirenwuNumTag4", score);
        editor.commit();
    }

    /**
     * 读取添加子任务负责人的id
     * @param context
     * @return
     */
    public static String readAdd_userid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Add_userid", "");
    }

    public static void writeAdd_userid(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Add_userid", imageList);
        editor.commit();
    }

    /**
     * 读取新增任务负责人的id  上司派发
     * @param context
     * @return
     */
    public static String readAdd_userid1(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Add_userid1", "");
    }

    public static void writeAdd_userid1(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Add_userid1", imageList);
        editor.commit();
    }

    /**
     * 读取新增任务负责人的id  派给自己
     * @param context
     * @return
     */
    public static String readAdd_userid2(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Add_userid2", "");
    }

    public static void writeAdd_userid2(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Add_userid2", imageList);
        editor.commit();
    }

    /**
     * 读取新增任务负责人的id  派给下属
     * @param context
     * @return
     */
    public static String readAdd_userid3(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Add_userid3", "");
    }

    public static void writeAdd_userid3(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Add_userid3", imageList);
        editor.commit();
    }

    /**
     * 读取新增任务负责人的id  代领导下发
     * @param context
     * @return
     */
    public static String readAdd_userid4(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Add_userid4", "");
    }

    public static void writeAdd_userid4(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Add_userid4", imageList);
        editor.commit();
    }

    /**
     * 读取新增任务负责人的id  新增子任务
     * @param context
     * @return
     */
    public static String readAdd_SonUserid(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Add_SonUserid", "");
    }

    public static void writeAdd_SonUserid(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Add_SonUserid", imageList);
        editor.commit();
    }


    /**
     * 读取当期或长期任务
     * @param context
     * @return
     */
    public static String readTasktype(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Tasktype", "");
    }

    public static void writeTasktype(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Tasktype", imageList);
        editor.commit();
    }

    /**
     * 读取长期任务循环周期
     * @param context
     * @return
     */
    public static String readTaskcycle(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Taskcycle", "");
    }

    public static void writeTaskcycle(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Taskcycle", imageList);
        editor.commit();
    }

    /**
     * 读取存的责任人
     * @param context
     * @return
     */
    public static String readSonZerenren(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("SonZerenren", "");
    }

    public static void writeSonZerenren(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("SonZerenren", imageList);
        editor.commit();
    }

    /**
     * 读取存的进度
     * @param context
     * @return
     */
    public static int readSonProgress(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonProgress", 0);
    }

    public static void writeSonProgress(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonProgress", score);
        editor.commit();
    }

    /**
     * 读取任务上报信息
     * @param context
     * @return
     */
    public static String readSonMsg(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("SonMsg", "");
    }

    public static void writeSonMsg(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("SonMsg", imageList);
        editor.commit();
    }

    /**
     * 读取子任务1修改信息
     * @param context
     * @return
     */
    public static String readSonchange1(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange1", "");
    }

    public static void writeSonchange1(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange1", imageList);
        editor.commit();
    }

    /**
     * 读取子任务1修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress1(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress1", 0);
    }

    public static void writeSonchangeProgress1(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress1", score);
        editor.commit();
    }

    /**
     * 读取子任务2修改信息
     * @param context
     * @return
     */
    public static String readSonchange2(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange2", "");
    }

    public static void writeSonchange2(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange2", imageList);
        editor.commit();
    }

    /**
     * 读取子任务2修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress2(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress2", 0);
    }

    public static void writeSonchangeProgress2(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress2", score);
        editor.commit();
    }

    /**
     * 读取子任务3修改信息
     * @param context
     * @return
     */
    public static String readSonchange3(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange3", "");
    }

    public static void writeSonchange3(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange3", imageList);
        editor.commit();
    }

    /**
     * 读取子任务3修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress3(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress3", 0);
    }

    public static void writeSonchangeProgress3(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress3", score);
        editor.commit();
    }

    /**
     * 读取子任务4修改信息
     * @param context
     * @return
     */
    public static String readSonchange4(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange4", "");
    }

    public static void writeSonchange4(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange4", imageList);
        editor.commit();
    }

    /**
     * 读取子任务4修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress4(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress4", 0);
    }

    public static void writeSonchangeProgress4(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress4", score);
        editor.commit();
    }

    /**
     * 读取子任务5修改信息
     * @param context
     * @return
     */
    public static String readSonchange5(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange5", "");
    }

    public static void writeSonchange5(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange5", imageList);
        editor.commit();
    }

    /**
     * 读取子任务6修改信息
     * @param context
     * @return
     */
    public static String readSonchange66(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange66", "");
    }

    public static void writeSonchange66(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange66", imageList);
        editor.commit();
    }

    /**
     * 读取子任务7修改信息
     * @param context
     * @return
     */
    public static String readSonchange77(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange77", "");
    }

    public static void writeSonchange77(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange77", imageList);
        editor.commit();
    }

    /**
     * 读取子任务8修改信息
     * @param context
     * @return
     */
    public static String readSonchange88(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange88", "");
    }

    public static void writeSonchange88(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange88", imageList);
        editor.commit();
    }

    /**
     * 读取子任务9修改信息
     * @param context
     * @return
     */
    public static String readSonchange99(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange99", "");
    }

    public static void writeSonchange99(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange99", imageList);
        editor.commit();
    }

    /**
     * 读取子任务10修改信息
     * @param context
     * @return
     */
    public static String readSonchange110(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange110", "");
    }

    public static void writeSonchange110(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange110", imageList);
        editor.commit();
    }

    /**
     * 读取子任务5修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress5(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress5", 0);
    }

    public static void writeSonchangeProgress5(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress5", score);
        editor.commit();
    }


    /**
     * 读取子任务6修改信息
     * @param context
     * @return
     */
    public static String readSonchange6(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange6", "");
    }

    public static void writeSonchange6(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange6", imageList);
        editor.commit();
    }

    /**
     * 读取子任务6修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress6(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress6", 0);
    }

    public static void writeSonchangeProgress6(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress6", score);
        editor.commit();
    }

    /**
     * 读取子任务8修改信息
     * @param context
     * @return
     */
    public static String readSonchange8(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange8", "");
    }

    public static void writeSonchange8(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange8", imageList);
        editor.commit();
    }
    /**
     * 读取子任务8修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress8(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress8", 0);
    }

    public static void writeSonchangeProgress8(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress8", score);
        editor.commit();
    }
    /**
     * 读取子任务9修改信息
     * @param context
     * @return
     */
    public static String readSonchange9(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange9", "");
    }

    public static void writeSonchange9(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange9", imageList);
        editor.commit();
    }
    /**
     * 读取子任务9修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress9(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress9", 0);
    }

    public static void writeSonchangeProgress9(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress9", score);
        editor.commit();
    }
    /**
     * 读取子任务10修改信息
     * @param context
     * @return
     */
    public static String readSonchange10(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange10", "");
    }

    public static void writeSonchange10(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange10", imageList);
        editor.commit();
    }
    /**
     * 读取子任务10修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress10(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress10", 0);
    }

    public static void writeSonchangeProgress10(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress10", score);
        editor.commit();
    }


    /**
     * 读取子任务11修改信息
     * @param context
     * @return
     */
    public static String readSonchange11(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange11", "");
    }

    public static void writeSonchange11(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange11", imageList);
        editor.commit();
    }
    /**
     * 读取子任务12修改信息
     * @param context
     * @return
     */
    public static String readSonchange12(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange12", "");
    }

    public static void writeSonchange12(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange12", imageList);
        editor.commit();
    }

    /**
     * 读取子任务13修改信息
     * @param context
     * @return
     */
    public static String readSonchange13(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange13", "");
    }

    public static void writeSonchange13(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange13", imageList);
        editor.commit();
    }

    /**
     * 读取子任务14修改信息
     * @param context
     * @return
     */
    public static String readSonchange14(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange14", "");
    }

    public static void writeSonchange14(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange14", imageList);
        editor.commit();
    }

    /**
     * 读取子任务14修改信息
     * @param context
     * @return
     */
    public static String readSonchange15(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange15", "");
    }

    public static void writeSonchange15(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange15", imageList);
        editor.commit();
    }

    /**
     * 读取子任务16修改信息
     * @param context
     * @return
     */
    public static String readSonchange16(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Sonchange16", "");
    }

    public static void writeSonchange16(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Sonchange16", imageList);
        editor.commit();
    }

    /**
     * 读取子任务11修改的进度
     * @param context
     * @return
     */
    public static int readSonchangeProgress11(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("SonchangeProgress11", 0);
    }

    public static void writeSonchangeProgress11(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("SonchangeProgress11", score);
        editor.commit();
    }

    /**
     * 读取待办详情的进度
     * @param context
     * @return
     */
    public static int readProgressDaiban(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("ProgressDaiban", 0);
    }

    public static void writeProgressDaiban(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("ProgressDaiban", score);
        editor.commit();
    }

    /**
     * 读取待办详情的进度
     * @param context
     * @return
     */
    public static int readProgressYiban(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("ProgressYiban", 0);
    }

    public static void writeProgressYiban(int score, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("ProgressYiban", score);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件个数
     * @param context
     * @return
     */
    public static int readfjnum(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getInt("fjnum", 0);
    }

    public static void writefjnum(int imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("fjnum", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl1(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url1", "");
    }

    public static void writeUrl1(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url1", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl2(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url2", "");
    }

    public static void writeUrl2(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url2", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl3(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url3", "");
    }

    public static void writeUrl3(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url3", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl4(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url4", "");
    }

    public static void writeUrl4(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url4", imageList);
        editor.commit();
    }
    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl5(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url5", "");
    }

    public static void writeUrl5(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url5", imageList);
        editor.commit();
    }
    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl6(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url6", "");
    }

    public static void writeUrl6(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url6", imageList);
        editor.commit();
    }
    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl7(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url7", "");
    }

    public static void writeUrl7(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url7", imageList);
        editor.commit();
    }
    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl8(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url8", "");
    }

    public static void writeUrl8(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url8", imageList);
        editor.commit();
    }
    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl9(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url9", "");
    }

    public static void writeUrl9(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url9", imageList);
        editor.commit();
    }
    /**
     * 读取添加子任务的附件url
     * @param context
     * @return
     */
    public static String readUrl10(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Url10", "");
    }

    public static void writeUrl10(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Url10", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename1(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename1", "");
    }

    public static void writeFilename1(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename1", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename2(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename2", "");
    }

    public static void writeFilename2(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename2", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename3(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename3", "");
    }

    public static void writeFilename3(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename3", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename4(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename4", "");
    }

    public static void writeFilename4(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename4", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename5(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename5", "");
    }

    public static void writeFilename5(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename5", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename6(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename6", "");
    }

    public static void writeFilename6(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename6", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename7(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename7", "");
    }

    public static void writeFilename7(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename7", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename8(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename8", "");
    }

    public static void writeFilename8(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename8", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename9(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename9", "");
    }

    public static void writeFilename9(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename9", imageList);
        editor.commit();
    }

    /**
     * 读取添加子任务的附件name
     * @param context
     * @return
     */
    public static String readFilename10(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("Filename10", "");
    }

    public static void writeFilename10(String imageList, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Filename10", imageList);
        editor.commit();
    }

    /**
     *
     *
     * @param context
     * @return
     */
    public static String readfinsh(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("isfinsh", "");
    }

    public static void writefinsh(String userid, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("isfinsh", userid);
        editor.commit();
    }

    /**
     *
     *
     * @param context
     * @return
     */
    public static String readfinsh2(Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences.getString("isfinshf", "");
    }

    public static void writefinsh2(String userid, Context context) {
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("isfinshf", userid);
        editor.commit();
    }



//    /**
//     * 读取手机号
//     */
//    public static Set readUsermobile(Context context){
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getStringSet("mobile",null);
//    }
//    public static void writeUsermobile(String imageList, Context context) {//添加
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        Set<String> set = preferences.getStringSet("mobile",null);
//        if (set==null){
//            set = new HashSet<>();
//        }
//        set.add(imageList);
//        editor.putStringSet("mobile",set);
//        editor.commit();
//    }
//
//    /**
//     * 读取创建世界
//     */
//    public static Set readCreatetime(Context context){   //读取
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getStringSet("Createtime",null);
//    }
//    public static void writeCreatetime(String imageList, Context context) {//添加
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        Set<String> set = preferences.getStringSet("Createtime",null);
//        if (set==null){
//            set = new HashSet<>();
//        }
//        set.add(imageList);
//        editor.putStringSet("Createtime",set);
//        editor.commit();
//    }

    public static Boolean deleteShouchang(String str,Context context){  //
        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        Set<String> set = preferences.getStringSet("Createtime",null);
        if(set!=null&&set.size()>0){
            return set.remove(str);
        }
        return false;
    }


}
