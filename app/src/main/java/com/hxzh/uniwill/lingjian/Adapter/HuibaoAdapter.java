package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunrenwu_xiaoxiliebiao;

import java.util.List;

/**
 * Created by pang on 2017/4/10.
 *  listview复用适配器 汇报
 */
public class HuibaoAdapter extends BaseAdapter {


    private List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> list1;//列表数据

    private Data_chaxunrenwu_xiaoxiliebiao.ListBean data1;//列表对象

    private List<Data_chaxunrenwu_xiaoxiliebiao.ListBean.FuJianBean> fuJianList;

    private Context context;

    public HuibaoAdapter(Context context, List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> list1) {
        this.context = context;
        this.list1 = list1;
    }

    public List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> getList1() {
        return list1;
    }

    public void setList1(List<Data_chaxunrenwu_xiaoxiliebiao.ListBean> list1) {
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
            convertView = View.inflate(context,R.layout.huibao_listview_item, null);

            holder.data = (TextView) convertView.findViewById(R.id.huibao_data);
            holder.name = (TextView) convertView.findViewById(R.id.huibao_name);
            holder.nrirong = (TextView) convertView.findViewById(R.id.huibao_neirong);
            holder.fj1 = (RelativeLayout) convertView.findViewById(R.id.item_fj1);
            holder.fj2 = (RelativeLayout) convertView.findViewById(R.id.item_fj2);
            holder.fj3 = (RelativeLayout) convertView.findViewById(R.id.item_fj3);
            holder.fj4 = (RelativeLayout) convertView.findViewById(R.id.item_fj4);
            holder.fj5 = (RelativeLayout) convertView.findViewById(R.id.item_fj5);
            holder.fj6 = (RelativeLayout) convertView.findViewById(R.id.item_fj6);
            holder.fj7 = (RelativeLayout) convertView.findViewById(R.id.item_fj7);
            holder.fj8 = (RelativeLayout) convertView.findViewById(R.id.item_fj8);
            holder.fj9 = (RelativeLayout) convertView.findViewById(R.id.item_fj9);
            holder.fj10 = (RelativeLayout) convertView.findViewById(R.id.item_fj10);
            holder.fjtext1 = (TextView) convertView.findViewById(R.id.item_fjtext1);
            holder.fjtext2 = (TextView) convertView.findViewById(R.id.item_fjtext2);
            holder.fjtext3 = (TextView) convertView.findViewById(R.id.item_fjtext3);
            holder.fjtext4 = (TextView) convertView.findViewById(R.id.item_fjtext4);
            holder.fjtext5 = (TextView) convertView.findViewById(R.id.item_fjtext5);
            holder.fjtext6 = (TextView) convertView.findViewById(R.id.item_fjtext6);
            holder.fjtext7 = (TextView) convertView.findViewById(R.id.item_fjtext7);
            holder.fjtext8 = (TextView) convertView.findViewById(R.id.item_fjtext8);
            holder.fjtext9 = (TextView) convertView.findViewById(R.id.item_fjtext9);
            holder.fjtext10 = (TextView) convertView.findViewById(R.id.item_fjtext10);

            holder.xian1 = convertView.findViewById(R.id.xian1);
            holder.xian2 = convertView.findViewById(R.id.xian2);
            holder.xian3 = convertView.findViewById(R.id.xian3);
            holder.xian4 = convertView.findViewById(R.id.xian4);
            holder.xian5 = convertView.findViewById(R.id.xian5);
            holder.xian6 = convertView.findViewById(R.id.xian6);
            holder.xian7 = convertView.findViewById(R.id.xian7);
            holder.xian8 = convertView.findViewById(R.id.xian8);
            holder.xian9 = convertView.findViewById(R.id.xian9);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        data1 = list1.get(position);
        fuJianList = list1.get(position).getFuJian();
        holder.data .setText(data1.getCreatetime());
        holder.nrirong.setText(data1.getContent());
        holder.name.setText(data1.getCreator());

        if (fuJianList!=null&&fuJianList.size()>0){
            if (fuJianList.size() == 1){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.xian1.setVisibility(View.INVISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() == 2){
                holder.fj1.setVisibility(View.VISIBLE);

                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.xian2.setVisibility(View.INVISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() == 3){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj3.setVisibility(View.VISIBLE);
                holder.xian3.setVisibility(View.INVISIBLE);
                holder.fjtext3.setText(fuJianList.get(2).getFileName());
                final String url3 = fuJianList.get(2).getFileaddressdown();
                holder.fj3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url3);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() == 4){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj3.setVisibility(View.VISIBLE);
                holder.fjtext3.setText(fuJianList.get(2).getFileName());
                final String url3 = fuJianList.get(2).getFileaddressdown();
                holder.fj3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url3);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj4.setVisibility(View.VISIBLE);
                holder.xian4.setVisibility(View.INVISIBLE);
                holder.fjtext4.setText(fuJianList.get(3).getFileName());
                final String url4 = fuJianList.get(3).getFileaddressdown();
                holder.fj4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url4);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() == 5){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj3.setVisibility(View.VISIBLE);
                holder.fjtext3.setText(fuJianList.get(2).getFileName());
                final String url3 = fuJianList.get(2).getFileaddressdown();
                holder.fj3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url3);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj4.setVisibility(View.VISIBLE);
                holder.fjtext4.setText(fuJianList.get(3).getFileName());
                final String url4 = fuJianList.get(3).getFileaddressdown();
                holder.fj4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url4);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj5.setVisibility(View.VISIBLE);
                holder.xian5.setVisibility(View.INVISIBLE);
                holder.fjtext5.setText(fuJianList.get(4).getFileName());
                final String url5 = fuJianList.get(4).getFileaddressdown();
                holder.fj5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url5);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() == 6){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj3.setVisibility(View.VISIBLE);
                holder.fjtext3.setText(fuJianList.get(2).getFileName());
                final String url3 = fuJianList.get(2).getFileaddressdown();
                holder.fj3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url3);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj4.setVisibility(View.VISIBLE);
                holder.fjtext4.setText(fuJianList.get(3).getFileName());
                final String url4 = fuJianList.get(3).getFileaddressdown();
                holder.fj4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url4);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj5.setVisibility(View.VISIBLE);
                holder.fjtext5.setText(fuJianList.get(4).getFileName());
                final String url5 = fuJianList.get(4).getFileaddressdown();
                holder.fj5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url5);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj6.setVisibility(View.VISIBLE);
                holder.xian6.setVisibility(View.INVISIBLE);
                holder.fjtext6.setText(fuJianList.get(5).getFileName());
                final String url6 = fuJianList.get(5).getFileaddressdown();
                holder.fj6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url6);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() == 7){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj3.setVisibility(View.VISIBLE);
                holder.fjtext3.setText(fuJianList.get(2).getFileName());
                final String url3 = fuJianList.get(2).getFileaddressdown();
                holder.fj3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url3);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj4.setVisibility(View.VISIBLE);
                holder.fjtext4.setText(fuJianList.get(3).getFileName());
                final String url4 = fuJianList.get(3).getFileaddressdown();
                holder.fj4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url4);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj5.setVisibility(View.VISIBLE);
                holder.fjtext5.setText(fuJianList.get(4).getFileName());
                final String url5 = fuJianList.get(4).getFileaddressdown();
                holder.fj5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url5);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj6.setVisibility(View.VISIBLE);
                holder.fjtext6.setText(fuJianList.get(5).getFileName());
                final String url6 = fuJianList.get(5).getFileaddressdown();
                holder.fj6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url6);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj7.setVisibility(View.VISIBLE);
                holder.xian7.setVisibility(View.INVISIBLE);
                holder.fjtext7.setText(fuJianList.get(6).getFileName());
                final String url7 = fuJianList.get(6).getFileaddressdown();
                holder.fj7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url7);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() == 8){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj3.setVisibility(View.VISIBLE);
                holder.fjtext3.setText(fuJianList.get(2).getFileName());
                final String url3 = fuJianList.get(2).getFileaddressdown();
                holder.fj3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url3);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj4.setVisibility(View.VISIBLE);
                holder.fjtext4.setText(fuJianList.get(3).getFileName());
                final String url4 = fuJianList.get(3).getFileaddressdown();
                holder.fj4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url4);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj5.setVisibility(View.VISIBLE);
                holder.fjtext5.setText(fuJianList.get(4).getFileName());
                final String url5 = fuJianList.get(4).getFileaddressdown();
                holder.fj5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url5);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj6.setVisibility(View.VISIBLE);
                holder.fjtext6.setText(fuJianList.get(5).getFileName());
                final String url6 = fuJianList.get(5).getFileaddressdown();
                holder.fj6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url6);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj7.setVisibility(View.VISIBLE);
                holder.fjtext7.setText(fuJianList.get(6).getFileName());
                final String url7 = fuJianList.get(6).getFileaddressdown();
                holder.fj7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url7);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj8.setVisibility(View.VISIBLE);
                holder.xian8.setVisibility(View.INVISIBLE);
                holder.fjtext8.setText(fuJianList.get(7).getFileName());
                final String url8 = fuJianList.get(7).getFileaddressdown();
                holder.fj8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url8);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() == 9){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj3.setVisibility(View.VISIBLE);
                holder.fjtext3.setText(fuJianList.get(2).getFileName());
                final String url3 = fuJianList.get(2).getFileaddressdown();
                holder.fj3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url3);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj4.setVisibility(View.VISIBLE);
                holder.fjtext4.setText(fuJianList.get(3).getFileName());
                final String url4 = fuJianList.get(3).getFileaddressdown();
                holder.fj4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url4);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj5.setVisibility(View.VISIBLE);
                holder.fjtext5.setText(fuJianList.get(4).getFileName());
                final String url5 = fuJianList.get(4).getFileaddressdown();
                holder.fj5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url5);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj6.setVisibility(View.VISIBLE);
                holder.fjtext6.setText(fuJianList.get(5).getFileName());
                final String url6 = fuJianList.get(5).getFileaddressdown();
                holder.fj6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url6);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj7.setVisibility(View.VISIBLE);
                holder.fjtext7.setText(fuJianList.get(6).getFileName());
                final String url7 = fuJianList.get(6).getFileaddressdown();
                holder.fj7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url7);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj8.setVisibility(View.VISIBLE);
                holder.fjtext8.setText(fuJianList.get(7).getFileName());
                final String url8 = fuJianList.get(7).getFileaddressdown();
                holder.fj8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url8);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj9.setVisibility(View.VISIBLE);
                holder.xian9.setVisibility(View.INVISIBLE);
                holder.fjtext9.setText(fuJianList.get(8).getFileName());
                final String url9= fuJianList.get(8).getFileaddressdown();
                holder.fj9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url9);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }
            if (fuJianList.size() >=10){
                holder.fj1.setVisibility(View.VISIBLE);
                holder.fjtext1.setText(fuJianList.get(0).getFileName());
                final String url = fuJianList.get(0).getFileaddressdown();
                holder.fj1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj2.setVisibility(View.VISIBLE);
                holder.fjtext2.setText(fuJianList.get(1).getFileName());
                final String url2 = fuJianList.get(1).getFileaddressdown();
                holder.fj2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url2);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj3.setVisibility(View.VISIBLE);
                holder.fjtext3.setText(fuJianList.get(2).getFileName());
                final String url3 = fuJianList.get(2).getFileaddressdown();
                holder.fj3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url3);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj4.setVisibility(View.VISIBLE);
                holder.fjtext4.setText(fuJianList.get(3).getFileName());
                final String url4 = fuJianList.get(3).getFileaddressdown();
                holder.fj4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url4);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj5.setVisibility(View.VISIBLE);
                holder.fjtext5.setText(fuJianList.get(4).getFileName());
                final String url5 = fuJianList.get(4).getFileaddressdown();
                holder.fj5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url5);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj6.setVisibility(View.VISIBLE);
                holder.fjtext6.setText(fuJianList.get(5).getFileName());
                final String url6 = fuJianList.get(5).getFileaddressdown();
                holder.fj6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url6);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj7.setVisibility(View.VISIBLE);
                holder.fjtext7.setText(fuJianList.get(6).getFileName());
                final String url7 = fuJianList.get(6).getFileaddressdown();
                holder.fj7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url7);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj8.setVisibility(View.VISIBLE);
                holder.fjtext8.setText(fuJianList.get(7).getFileName());
                final String url8 = fuJianList.get(7).getFileaddressdown();
                holder.fj8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url8);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj9.setVisibility(View.VISIBLE);
                holder.fjtext9.setText(fuJianList.get(8).getFileName());
                final String url9= fuJianList.get(8).getFileaddressdown();
                holder.fj9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url9);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });

                holder.fj10.setVisibility(View.VISIBLE);
                holder.fjtext10.setText(fuJianList.get(9).getFileName());
                final String url10= fuJianList.get(9).getFileaddressdown();
                holder.fj10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url10);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                });
            }

        }

        return convertView;
    }
     static class ViewHolder {
        //listview参数
         public TextView data;//日期
         public TextView name;//姓名
         public TextView nrirong;//内容

         public RelativeLayout fj1;
         public RelativeLayout fj2;
         public RelativeLayout fj3;
         public RelativeLayout fj4;
         public RelativeLayout fj5;
         public RelativeLayout fj6;
         public RelativeLayout fj7;
         public RelativeLayout fj8;
         public RelativeLayout fj9;
         public RelativeLayout fj10;

         public View xian1;
         public View xian2;
         public View xian3;
         public View xian4;
         public View xian5;
         public View xian6;
         public View xian7;
         public View xian8;
         public View xian9;

         public TextView fjtext1;
         public TextView fjtext2;
         public TextView fjtext3;
         public TextView fjtext4;
         public TextView fjtext5;
         public TextView fjtext6;
         public TextView fjtext7;
         public TextView fjtext8;
         public TextView fjtext9;
         public TextView fjtext10;
    }

}
