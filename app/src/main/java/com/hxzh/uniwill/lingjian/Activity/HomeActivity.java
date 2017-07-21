package com.hxzh.uniwill.lingjian.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;

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
 * Created by PangHaHa12138 on 2017/6/5.
 */
public class HomeActivity extends BaseToobarRightViewActivity {

    private BottomNavigationBar bottomNavigationBar;
    private DrawerLayout mydrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mydrawerLayout = (DrawerLayout) findViewById(R.id.drawlayout);
        getToolbarTitle().setText("OA办公");

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar
                .setActiveColor(R.color.button_login_color)
                .setInActiveColor("#8e8e8e")
                .setBarBackgroundColor("#ECECEC");


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp,"令箭"))
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,"OA"))
//                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp,"Music"))
//                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp,"TV"))
                .setFirstSelectedPosition(1)//设置默认选择的按钮
                .initialise();

//        bottomNavigationBar.setAutoHideEnabled(true);
        bottomNavigationBar
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

                switch (position){

                    case 0:
                        ToastUtil.showToast("竟让有这种操作！");

                        Intent i = new Intent(HomeActivity.this,MainActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        ToastUtil.showToast("真的有这种操作！");

                        break;
//                    case 2:
//                        ToastUtil.showToast("这是假的操作！");
//
//                        break;
//                    case 3:
//                        ToastUtil.showToast("红红火火恍恍惚惚！");

//                        break;

                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }
}
