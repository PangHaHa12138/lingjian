package com.hxzh.uniwill.lingjian.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;

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
 * Created by PangHaHa12138 on 2017/6/13.
 */
public class TitleFragment extends android.support.v4.app.Fragment {

    private ImageView lefticon,righticon;
    private TextView title;

    private View mview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mview = inflater.inflate(R.layout.titlefragment,container,false);

        title = (TextView) mview.findViewById(R.id.titlefragment);
        lefticon = (ImageView) mview.findViewById(R.id.leftfragment);
        righticon = (ImageView) mview.findViewById(R.id.rightfragment);

        return mview;
    }

    public TextView gettitle(){

        return title;
    }
    public ImageView getLefticon(){

        return lefticon;
    }
    public ImageView getRighticon(){

        return righticon;
    }
}
