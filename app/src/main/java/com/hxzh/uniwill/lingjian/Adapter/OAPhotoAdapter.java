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

import java.util.List;

/**
 * Created by pang on 2017/4/10.
 *  listview复用适配器 待办任务
 */
public class OAPhotoAdapter extends BaseAdapter {

    private List<Data_OAgongxiangwj.ListBean> list;

    public List<Data_OAgongxiangwj.ListBean> getList() {
        return list;
    }

    public void setList(List<Data_OAgongxiangwj.ListBean> list) {
        this.list = list;
    }

    private Data_OAgongxiangwj.ListBean data;

    private Context context;

    public OAPhotoAdapter(Context context ,List<Data_OAgongxiangwj.ListBean> listBeen) {
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
            convertView = View.inflate(context,R.layout.oaphoto_listviewitem, null);

            holder.filephoto = (ImageView) convertView.findViewById(R.id.filephoto);
            holder.filename = (TextView) convertView.findViewById(R.id.filename);
            holder.comefrom = (TextView) convertView.findViewById(R.id.comefrom);
            holder.filetiem = (TextView) convertView.findViewById(R.id.filetiem);
            holder.photolayout = (RelativeLayout) convertView.findViewById(R.id.photolayout);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String s = "来自";
        String w = "同事";
        data = list.get(position);
        String q = s+ data.getUsername()+w;
        holder.comefrom.setText(q);
        holder.filename.setText(data.getName());
        String time = data.getCreatime();
        String time2 = time.substring(0,time.length()-5);
        holder.filetiem.setText(time2);

        String tag = data.getPicture();

        if (tag!=null){
            if (tag.equals("icon_word")){
                holder.filephoto.setImageResource(R.drawable.icon_word);
            }else if (tag.equals("icon_excle")){
                holder.filephoto.setImageResource(R.drawable.icon_excle);
            }else if (tag.equals("icon_pdf")){
                holder.filephoto.setImageResource(R.drawable.icon_pdf);
            }else if (tag.equals("icon_ppt")){
                holder.filephoto.setImageResource(R.drawable.icon_ppt);
            }else if (tag.equals("icon_txt")){
                holder.filephoto.setImageResource(R.drawable.icon_txt);
            }else if (tag.equals("icon_rar")){
                holder.filephoto.setImageResource(R.drawable.icon_rar);
            }else if (tag.equals("icon_image")){
                holder.filephoto.setImageResource(R.drawable.icon_image);
            }else if (tag.equals("icon_video")){
                holder.filephoto.setImageResource(R.drawable.icon_video);
            }else if (tag.equals("icon_application")){
                holder.filephoto.setImageResource(R.drawable.icon_application);
            }
        }else {
            holder.filephoto.setImageResource(R.drawable.icon_tongyongwenjian);
        }

        final String url = data.getAddress();
        try {
            holder.photolayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri content_url = Uri.parse(url);
                    intent.setData(content_url);
                    context.startActivity(intent);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertView;
    }



    static class ViewHolder {
        //listview参数
        public ImageView filephoto;//文件图标
        public TextView filename;//文件名
        public TextView filetiem;//上传时间
        public TextView comefrom;//来自
        public RelativeLayout photolayout;

    }

}
