package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_OAgongxiangwj;
import com.hxzh.uniwill.lingjian.bean.Data_genzongjilu;

import java.util.List;

/**
 * Created by pang on 2017/4/10.
 *  listview复用适配器 待办任务
 */
public class OAshenhejiluAdapter extends BaseAdapter {

    private List<Data_genzongjilu.ExamineBean> list;

    public List<Data_genzongjilu.ExamineBean> getList() {
        return list;
    }

    public void setList(List<Data_genzongjilu.ExamineBean> list) {
        this.list = list;
    }

    private Data_genzongjilu.ExamineBean data;

    private Context context;

    public OAshenhejiluAdapter(Context context , List<Data_genzongjilu.ExamineBean> listBeen) {
        this.context = context;
        this.list = listBeen;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        if (list!=null&&list.size()>0){
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = View.inflate(context,R.layout.shenhejilu_item, null);

            holder.shenpiperson = (TextView) convertView.findViewById(R.id.shenpiren);
            holder.shnepitype = (TextView) convertView.findViewById(R.id.shenpistat);
            holder.shenpiyijian = (TextView) convertView.findViewById(R.id.shenpiyijian);
            holder.shenpitime = (TextView) convertView.findViewById(R.id.shenpitime);
            holder.shenpirennnn = (TextView) convertView.findViewById(R.id.shenpiman);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        data = list.get(position);
        String s = data.getType();

        if (s.equals("2")){
            holder.shenpirennnn.setText("申请人:");
        }
        if (data!=null){
            holder.shenpiperson.setText(data.getUsername());
            holder.shenpiyijian.setText(data.getAdvise());
            String time1 = data.getCreatime();
            String time2 = time1.substring(0,time1.length()-2);
            holder.shenpitime.setText(time2);
            String type = data.getType();
            if (type.equals("0")){
                holder.shnepitype.setText("打回");
            }else if (type.equals("1")){
                holder.shnepitype.setText("通过");
            }else if (type.equals("2")){
                holder.shnepitype.setText("申请");
            }

        }


        return convertView;
    }

    static class ViewHolder {
        //listview参数
        public TextView shenpiperson;//人
        public TextView shnepitype;//类型
        public TextView shenpiyijian;//意见
        public TextView shenpitime;//时间
        public TextView shenpirennnn;

    }

}
