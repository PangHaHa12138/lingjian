package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.Activity.Activity_Deatail;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.PercentCircle;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunliebiao_shoudaorenwu;
import com.hxzh.uniwill.lingjian.bean.Data_uploadBack_tag;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/4/10.
 *  listview复用适配器 待办
 */
public class TestAdapter extends BaseAdapter {

    private String userid,taskid;
    private int iszhiding;

    private List<Data_chaxunliebiao_shoudaorenwu.ListBean> list2;

    private Data_chaxunliebiao_shoudaorenwu.ListBean data;

    private Context context;

    public LayoutInflater layoutInflater;
    public int progrss;

    public TestAdapter(Context context, List<Data_chaxunliebiao_shoudaorenwu.ListBean> list2) {
        this.context = context;
        this.list2 = list2;
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

        if (list2!= null&&list2.size()>0){

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
            convertView =layoutInflater.inflate(R.layout.listview_daiban_item, null);

            holder.percentCircle = (PercentCircle) convertView.findViewById(R.id.pencentCircle);
            holder.renwu_text = (TextView) convertView.findViewById(R.id.text_title_list);
            holder.faburen_text = (TextView) convertView.findViewById(R.id.text_persion_list);
            holder.day_num_text = (TextView) convertView.findViewById(R.id.text_time_list);
            holder.zhiding_item = (TextView) convertView.findViewById(R.id.zhiding_item);
            holder.zhidingPhoto = (ImageView) convertView.findViewById(R.id.GoTop);
            holder.content = (RelativeLayout) convertView.findViewById(R.id.content);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        data = list2.get(position);
        taskid = data.getTaskid();
        userid = SharedPreferencesUtil.readUserid(context);
//        LogUtil.d("taskid--Adapter中的",taskid+"");
//        LogUtil.d("userid--Adapter中的",userid+"");
        iszhiding = data.getStick();

        if (iszhiding == 1){
            final View finalConvertView = convertView;
            holder.zhiding_item.setVisibility(View.VISIBLE);
            holder.zhidingPhoto.setImageResource(R.drawable.list_slide_but_canstick3x);
            holder.zhidingPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OkHttpUtils.post(Http_Api.URL_quxiaozhiding)
                            .params("userid",userid)
                            .params("taskid",taskid)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);

                                    if (back_tag != null){
                                        ToastUtil.showToast("取消置顶");
                                    }else {
                                        ToastUtil.showToast("取消失败");
                                    }
                                }

                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("置顶失败，头皮发麻");
                                }
                            });
                    //在ListView里，点击侧滑菜单上的选项时，如果想让擦花菜单同时关闭，调用这句话
                    ((SwipeMenuLayout) finalConvertView).quickClose();
                    notifyDataSetChanged();
                }
            });
        }else if (iszhiding == 0){
            final View finalConvertView = convertView;
            holder.zhiding_item.setVisibility(View.INVISIBLE);
            holder.zhidingPhoto.setImageResource(R.drawable.list_slide_but_stick3x);
            holder.zhidingPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OkHttpUtils.post(Http_Api.URL_zhiding)
                            .params("userid",userid)
                            .params("taskid",taskid)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {

                                    Data_uploadBack_tag back_tag = JsonUtil.parseJsonToBean(s,Data_uploadBack_tag.class);
                                    if (back_tag != null){
                                        ToastUtil.showToast("置顶");
                                    }else {
                                        ToastUtil.showToast("置顶失败");
                                    }
                                }
                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtil.showToast("置顶失败，头皮发麻");
                                }
                            });
                    //在ListView里，点击侧滑菜单上的选项时，如果想让擦花菜单同时关闭，调用这句话
                    ((SwipeMenuLayout) finalConvertView).quickClose();
                    notifyDataSetChanged();
                }
            });
        }

        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = list2.get(position);
                //点击item进入 任务详情页
                Intent intent = new Intent(context, Activity_Deatail.class);
                taskid = data.getTaskid();
                progrss = data.getProgress();
                SharedPreferencesUtil.writeProgressDaiban(progrss,context);
                intent.putExtra("taskname", data.getTaskname());
                intent.putExtra("taskid1",taskid);
                intent.putExtra("userid1",userid);
                intent.putExtra("progress",progrss);
                context.startActivity(intent);
            }
        });
        holder.percentCircle.setTargetPercent(data.getProgress());//设置百分比
        holder.renwu_text.setText(data.getTaskname());//任务名
        holder.faburen_text.setText(data.getCusername());//发布人
        holder.day_num_text.setText(data.getTimeInfo());//剩余时间

        return convertView;
    }
    static class ViewHolder {
        //listview参数
        public PercentCircle percentCircle;//百分比圆环
        public TextView renwu_text;//任务名
        public TextView faburen_text;//发布人
        public TextView day_num_text;//天数
        public TextView zhiding_item;
        public ImageView zhidingPhoto;
        public RelativeLayout content;

    }

}
