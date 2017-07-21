package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.PercentCircle;
import com.hxzh.uniwill.lingjian.base.MyApplication;
import com.hxzh.uniwill.lingjian.bean.Data_huoqurenwuxiangqing;

import java.util.List;

/**
 * Created by pang on 2017/4/10.
 *  listview复用适配器 已办
 */
public class SlideAdapter7 extends BaseAdapter {


    private List<Data_huoqurenwuxiangqing.ListBean> list1;//列表数据

    private Data_huoqurenwuxiangqing.ListBean data1;//列表对象

    private Context context;

    public SlideAdapter7(Context context, List<Data_huoqurenwuxiangqing.ListBean> list1) {
        this.context = context;
        this.list1 = list1;
    }

    public List<Data_huoqurenwuxiangqing.ListBean> getList1() {
        return list1;
    }

    public void setList1(List<Data_huoqurenwuxiangqing.ListBean> list1) {
        this.list1 = list1;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        if (list1!=null&&list1.size()>0){
            return list1.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = View.inflate(context,R.layout.xiafa_listview_item, null);

            holder.percentCircle = (PercentCircle) convertView.findViewById(R.id.xiafa_jindutiao);
//            holder.renwu_text = (TextView) convertView.findViewById(R.id.xiafa_rwming);
            holder.name_text = (TextView) convertView.findViewById(R.id.xiafa_name);
            holder.touxing = (ImageView) convertView.findViewById(R.id.xiafa_touxiang);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        data1 = list1.get(position);

        holder.percentCircle.setTargetPercent(data1.getProgress());//设置百分比
//        holder.renwu_text.setText(data1.getReason());//任务名
        holder.name_text.setText(data1.getCusername());//人名
        String url = data1.getImageurl();
        Glide.with(MyApplication.mcontext).load(url).into(holder.touxing);//头像

        return convertView;
    }
     static class ViewHolder {
        //listview参数
        public PercentCircle percentCircle;//百分比圆环
        public TextView renwu_text;//任务名
        public TextView name_text;//姓名
        public ImageView touxing;

    }

}
