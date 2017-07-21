package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.PercentCircle;
import com.hxzh.uniwill.lingjian.View.SlideListView2;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunliebiao_shoudaorenwu;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;

import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;

import java.util.List;

import okhttp3.Response;
/**
 * Created by pang on 2017/4/10.
 * listview复用适配器 待办
 */
public class SlideAdaptertest extends BaseAdapter {

    private String userid, taskid;

    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list2;
    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list1;

    private Data_chaxunliebiao_shoudaorenwu.ListBean data;

    private Context context;

    public SlideListView2 getSlideListView2() {
        return slideListView2;
    }

    public void setSlideListView2(SlideListView2 slideListView2) {
        this.slideListView2 = slideListView2;
    }

    private SlideListView2 slideListView2;

    private int a;

    private ViewHolder holder1;
    private ViewHolder holder2;

    public LayoutInflater layoutInflater;

    public SlideAdaptertest(Context context, SlideListView2 slideListView2,
                            List<Data_chaxunliebiao_shoudaorenwu.ListBean> list2) {
        this.context = context;
        this.list2 = list2;
        this.slideListView2 = slideListView2;
        layoutInflater = LayoutInflater.from(context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Data_chaxunliebiao_shoudaorenwu.ListBean> getList2() {
        return list2;
    }

    public void setList2(List<Data_chaxunliebiao_shoudaorenwu.ListBean> list2) {
        this.list2 = list2;
    }

    @Override
    public int getCount() {

        if (list2 != null && list2.size() > 0) {

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
        switch (getItemViewType(position)) {
            case 1:
                if (convertView == null) {
                    holder1 = new ViewHolder();
                    convertView = layoutInflater.inflate(R.layout.listview_test3_item, null);
                    holder1.percentCircle = (PercentCircle) convertView.findViewById(R.id.pencentCircle4);
                    holder1.renwu_text = (TextView) convertView.findViewById(R.id.text_title_list4);
                    holder1.faburen_text = (TextView) convertView.findViewById(R.id.text_persion_list4);
                    holder1.day_num_text = (TextView) convertView.findViewById(R.id.text_time_list4);
                    holder1.zhiding_item = (TextView) convertView.findViewById(R.id.zhiding_item4);
                    holder1.zhiing = (ImageView) convertView.findViewById(R.id.daiban_quxiaozhiding4);
                    convertView.setTag(holder1);
                } else {
                    holder1 = (ViewHolder) convertView.getTag();
                }
                //置顶
                data = list2.get(position);
                taskid = data.getTaskid();
                userid = SharedPreferencesUtil.readUserid(context);
                holder1.percentCircle.setTargetPercent(data.getProgress());//设置百分比
                holder1.renwu_text.setText(data.getTaskname());//任务名
                holder1.faburen_text.setText(data.getCusername());//发布人
                holder1.day_num_text.setText(data.getTimeInfo() + "");//剩余时间
                holder1.zhiding_item.setVisibility(View.VISIBLE);
                holder1.zhiing.setImageResource(R.drawable.list_slide_but_stick3x);
                holder1.zhiing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OkHttpUtils.post(Http_Api.URL_zhiding)
                                .params("userid", userid)
                                .params("taskid", taskid)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        Data_chaxunliebiao_shoudaorenwu shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                                        list1 = shoudaorenwu.getList();
                                        list2 = list1;
                                        ToastUtil.showToast("置顶成功");
//                                        notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("置顶失败");
                                    }
                                });

                        slideListView2.slideBack();
                    }
                });

                break;
            case 0:
                if (convertView == null) {
                    holder2 = new ViewHolder();
                    convertView = layoutInflater.inflate(R.layout.listview_test2_item, null);
                    holder2.percentCircle = (PercentCircle) convertView.findViewById(R.id.pencentCircle3);
                    holder2.renwu_text = (TextView) convertView.findViewById(R.id.text_title_list3);
                    holder2.faburen_text = (TextView) convertView.findViewById(R.id.text_persion_list3);
                    holder2.day_num_text = (TextView) convertView.findViewById(R.id.text_time_list3);
                    holder2.zhiding_item = (TextView) convertView.findViewById(R.id.zhiding_item3);
                    holder2.zhiing = (ImageView) convertView.findViewById(R.id.daiban_quxiaozhiding3);
                    convertView.setTag(holder2);
                } else {
                    holder2 = (ViewHolder) convertView.getTag();
                }
                //取消置顶
                data = list2.get(position);
                taskid = data.getTaskid();
                userid = SharedPreferencesUtil.readUserid(context);
                holder2.percentCircle.setTargetPercent(data.getProgress());//设置百分比
                holder2.renwu_text.setText(data.getTaskname());//任务名
                holder2.faburen_text.setText(data.getCusername());//发布人
                holder2.day_num_text.setText(data.getTimeInfo() + "");//剩余时间
                holder2.zhiding_item.setVisibility(View.INVISIBLE);
                holder2.zhiing.setImageResource(R.drawable
                        .list_slide_but_canstick3x);
                holder2.zhiing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OkHttpUtils.post(Http_Api.URL_quxiaozhiding)
                                .params("userid", userid)
                                .params("taskid", taskid)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
                                        Data_chaxunliebiao_shoudaorenwu shoudaorenwu = JsonUtil.parseJsonToBean(s, Data_chaxunliebiao_shoudaorenwu.class);
                                        list1 = shoudaorenwu.getList();
                                        list2 = list1;
                                        ToastUtil.showToast("取消成功");
//                                        notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onError(Call call, Response response, Exception e) {
                                        super.onError(call, response, e);
                                        ToastUtil.showToast("置顶失败");
                                    }
                                });
                        slideListView2.slideBack();
                    }
                });
                break;
        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        int type = -1;
        data = list2.get(position);
        a = data.getStick();//置顶字段
        switch (a) {
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
        public ImageView zhiing;

    }

}

