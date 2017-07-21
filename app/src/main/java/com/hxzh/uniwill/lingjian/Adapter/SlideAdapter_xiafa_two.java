package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_fuck;

import java.util.List;

/**
 * Created by pang on 2017/4/10.
 *  listview复用适配器 下发二级界面
 */
public class SlideAdapter_xiafa_two extends BaseAdapter {

    private List<Data_fuck.ListBean> list1;//列表数据

    private Data_fuck data1;//列表对象

    private Context context;
    private String url;

    public SlideAdapter_xiafa_two(Context context, Data_fuck data1,List<Data_fuck.ListBean> list1) {
        this.context = context;
        this.data1 = data1;
        this.list1 = list1;
    }
    public List<Data_fuck.ListBean> getList1() {
        return list1;
    }

    public void setList1(List<Data_fuck.ListBean> list1) {
        this.list1 = list1;
    }
    public Data_fuck getData1() {
        return data1;
    }

    public void setData1(Data_fuck data1) {
        this.data1 = data1;
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
            convertView = View.inflate(context,R.layout.xiafa_two_listview_item, null);

            holder.renwu_text = (TextView) convertView.findViewById(R.id.sontext);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        data1 = list1.get(position);

        holder.renwu_text.setText(data1.getTaskname());//子任务名
        return convertView;
    }
     static class ViewHolder {
        //listview参数
         public TextView renwu_text;//子任务名
    }

}
