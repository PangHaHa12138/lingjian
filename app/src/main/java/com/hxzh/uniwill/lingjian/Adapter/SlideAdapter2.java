package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.PercentCircle;
import com.hxzh.uniwill.lingjian.bean.Data_huoqusuoyou_wanchengrenwu;

import java.util.List;


/**
 * Created by pang on 2017/4/10.
 *  listview复用适配器 已办任务
 */
public class SlideAdapter2 extends BaseAdapter {

    private String userid,taskid;
    private int iszhiding;

    private List<Data_huoqusuoyou_wanchengrenwu.ListBean> list2;

    private Data_huoqusuoyou_wanchengrenwu.ListBean data;

    private Context context;

    public SlideAdapter2( Context context, List<Data_huoqusuoyou_wanchengrenwu.ListBean> list2) {
        this.context = context;
        this.list2 = list2;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Data_huoqusuoyou_wanchengrenwu.ListBean> getList2() {
        return list2;
    }

    public void setList2(List<Data_huoqusuoyou_wanchengrenwu.ListBean> list2) {
        this.list2 = list2;
    }

    @Override
    public int getCount() {
        if (list2!=null&&list2.size()>0){
            return list2.size();
        }
         return 0;
    }

    @Override
    public Object getItem(int position) {
        return list2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = View.inflate(context,R.layout.listview_main2_item, null);

            holder.percentCircle = (PercentCircle) convertView.findViewById(R.id.pencentCircle);
            holder.renwu_text = (TextView) convertView.findViewById(R.id.text_title_list);
            holder.faburen_text = (TextView) convertView.findViewById(R.id.text_persion_list);
            holder.day_num_text = (TextView) convertView.findViewById(R.id.text_time_list);
            holder.red = (ImageView) convertView.findViewById(R.id.renwutishi_red);
            holder.zhiding_item = (TextView) convertView.findViewById(R.id.zhiding_item);
            holder.text_day_list = (TextView) convertView.findViewById(R.id.text_day_list);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        data = list2.get(position);
        taskid = data.getTaskid();
        iszhiding = data.getStick();
        if (iszhiding == 1){
            holder.zhiding_item.setVisibility(View.VISIBLE);
        }else if (iszhiding == 0){
            holder.zhiding_item.setVisibility(View.INVISIBLE);
        }
        if (data.getReaded()>0){
            holder.red.setVisibility(View.VISIBLE);
        }
        int a = data.getProgress();
        holder.percentCircle.setTargetPercent(a);//设置百分比
        holder.renwu_text.setText(data.getTaskname());//任务名
        holder.faburen_text.setText(data.getCusername());//发布人
        if (a == 100){
            holder.day_num_text.setText("已完成");
//            holder.day_num_text.setTextSize(13);
            holder.text_day_list.setVisibility(View.GONE);
        }else {
            holder.day_num_text.setText(data.getTimeInfo());//剩余时间
        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {

        int type = -1;
        data = list2.get(position);
        iszhiding = data.getStick();//置顶字段
        switch (iszhiding) {
            case 0:
                type = 0;
                break;
            case 1:
                type = 1;
                break;
        }
        return type;
    }

    @Override
    public int getViewTypeCount() {

        return 2;
    }


    static class ViewHolder {
        //listview参数
        public PercentCircle percentCircle;//百分比圆环
        public TextView renwu_text;//任务名
        public TextView faburen_text;//发布人
        public TextView day_num_text;//天数
        public TextView zhiding_item;
        public TextView text_day_list;
        public ImageView red;

    }

}
