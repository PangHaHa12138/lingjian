package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_shenpi;

import java.util.List;

/**
 * Created by pang on 2017/4/10.
 *  listview复用适配器 待办任务
 */
public class OAAdapter2 extends BaseAdapter {

    private String userid,taskid;
    private String iszhiding;
    private List<Data_shenpi.ListBean> list;

    private Context context;

    public OAAdapter2(Context context,List<Data_shenpi.ListBean> mlist) {
        this.context = context;
        this.list = mlist;
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
            convertView = View.inflate(context,R.layout.oa_listviewitem2, null);

            holder.tittol = (TextView) convertView.findViewById(R.id.tittol);
            holder.tittype = (TextView) convertView.findViewById(R.id.tittype);
            holder.icon = (ImageView) convertView.findViewById(R.id.shenhetu);
            holder.zhiding = (TextView) convertView.findViewById(R.id.oazhiding_item2);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (list.size()>0 &&list!=null){
            String s = "审批类型";
            holder.tittype.setText(s+list.get(position).getWokertype());
            holder.tittol.setText(list.get(position).getTitle());
            if (list.get(position).getStatustype().equals("1")){
                holder.icon.setImageResource(R.drawable.icon_daishenpi);
            }else if (list.get(position).getStatustype().equals("2")){
                holder.icon.setImageResource(R.drawable.icon_shenpizhong);
            } else if (list.get(position).getStatustype().equals("0")){
                holder.icon.setImageResource(R.drawable.icon_shenpitongguo);
            }else if (list.get(position).getStatustype().equals("3")){
                holder.icon.setImageResource(R.drawable.icon_shenpibutongguo);
            }
        }

        iszhiding = list.get(position).getStick();
        if (iszhiding.equals("0")){
            holder.zhiding.setVisibility(View.INVISIBLE);
        }else if (iszhiding.equals("1")){
            holder.zhiding.setVisibility(View.VISIBLE);
        }


        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        int type = -1;
        iszhiding = list.get(position).getStick();//置顶字段

        if (iszhiding.equals("0")){
            type = 0;
        }else if (iszhiding.equals("1")){
            type = 1;
        }

        return type;

    }

    @Override
    public int getViewTypeCount() {

        return 2;
    }



    static class ViewHolder {
        //listview参数
        public TextView tittol;//工单名
        public TextView tittype;//类型
        public ImageView icon;//类型图标
        public TextView zhiding;//类型图标
    }

}
