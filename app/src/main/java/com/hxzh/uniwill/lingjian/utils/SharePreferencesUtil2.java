package com.hxzh.uniwill.lingjian.utils;

import android.content.Context;
import android.content.SharedPreferences;

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
 * <p/>
 * Created by PangHaHa12138 on 2017/5/2.
 */
public class SharePreferencesUtil2 {

    public static SharedPreferences preferences2;
    public static SharedPreferences.Editor editor2;


    /**
     * 备用读取用户名
     * @param context
     * @return
     */
    public static String readUsername2(Context context) {
        preferences2 = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences2.getString("Username2", "");
    }

    public static void writeUsername2(String imageList, Context context) {
        preferences2 = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor2 = preferences2.edit();
        editor2.putString("Username2", imageList);
        editor2.commit();
    }

    /**
     * 备用读取用户密码
     * @param context
     * @return
     */
    public static String readPassword2(Context context) {
        preferences2 = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        return preferences2.getString("Password2", "");
    }

    public static void writePassword2(String imageList, Context context) {
        preferences2 = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor2 = preferences2.edit();
        editor2.putString("Password2", imageList);
        editor2.commit();
    }


//    /**
//     * 读取子任务6修改信息
//     * @param context
//     * @return
//     */
//    public static String readSonchange6(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getString("Sonchange6", "");
//    }
//
//    public static void writeSonchange6(String imageList, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putString("Sonchange6", imageList);
//        editor.commit();
//    }
//
//    /**
//     * 读取子任务6修改的进度
//     * @param context
//     * @return
//     */
//    public static int readSonchangeProgress6(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getInt("SonchangeProgress6", 0);
//    }
//
//    public static void writeSonchangeProgress6(int score, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putInt("SonchangeProgress6", score);
//        editor.commit();
//    }
//
//    /**
//     * 读取子任务8修改信息
//     * @param context
//     * @return
//     */
//    public static String readSonchange8(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getString("Sonchange8", "");
//    }
//
//    public static void writeSonchange8(String imageList, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putString("Sonchange8", imageList);
//        editor.commit();
//    }
//    /**
//     * 读取子任务8修改的进度
//     * @param context
//     * @return
//     */
//    public static int readSonchangeProgress8(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getInt("SonchangeProgress8", 0);
//    }
//
//    public static void writeSonchangeProgress8(int score, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putInt("SonchangeProgress8", score);
//        editor.commit();
//    }
//    /**
//     * 读取子任务9修改信息
//     * @param context
//     * @return
//     */
//    public static String readSonchange9(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getString("Sonchange9", "");
//    }
//
//    public static void writeSonchange9(String imageList, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putString("Sonchange9", imageList);
//        editor.commit();
//    }
//    /**
//     * 读取子任务9修改的进度
//     * @param context
//     * @return
//     */
//    public static int readSonchangeProgress9(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getInt("SonchangeProgress9", 0);
//    }
//
//    public static void writeSonchangeProgress9(int score, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putInt("SonchangeProgress9", score);
//        editor.commit();
//    }
//    /**
//     * 读取子任务10修改信息
//     * @param context
//     * @return
//     */
//    public static String readSonchange10(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getString("Sonchange10", "");
//    }
//
//    public static void writeSonchange10(String imageList, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putString("Sonchange10", imageList);
//        editor.commit();
//    }
//    /**
//     * 读取子任务10修改的进度
//     * @param context
//     * @return
//     */
//    public static int readSonchangeProgress10(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getInt("SonchangeProgress10", 0);
//    }
//
//    public static void writeSonchangeProgress10(int score, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putInt("SonchangeProgress10", score);
//        editor.commit();
//    }
//    /**
//     * 读取子任务11修改信息
//     * @param context
//     * @return
//     */
//    public static String readSonchange11(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getString("Sonchange11", "");
//    }
//
//    public static void writeSonchange11(String imageList, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putString("Sonchange11", imageList);
//        editor.commit();
//    }
//    /**
//     * 读取子任务11修改的进度
//     * @param context
//     * @return
//     */
//    public static int readSonchangeProgress11(Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        return preferences.getInt("SonchangeProgress11", 0);
//    }
//
//    public static void writeSonchangeProgress11(int score, Context context) {
//        preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//        editor.putInt("SonchangeProgress11", score);
//        editor.commit();
//    }
}
