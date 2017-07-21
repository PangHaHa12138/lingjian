package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.View.CirclePercentView;
import com.hxzh.uniwill.lingjian.bean.Data_chaxunliebiao_shoudaorenwu;

public class SwipeMenuAdapter extends ListBaseAdapter<Data_chaxunliebiao_shoudaorenwu.ListBean> {

    public SwipeMenuAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item_swipe;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
        View contentView = holder.getView(R.id.swipe_content);

        TextView name = holder.getView(R.id.text_title_list2);
        TextView person = holder.getView(R.id.text_persion_list2);
        TextView day = holder.getView(R.id.text_time_list2);
        CirclePercentView yuan = holder.getView(R.id.circleView);
        ImageView btnTop = holder.getView(R.id.btnTop);

        name.setText(getDataList().get(position).getTaskname());
        yuan.setPercent(getDataList().get(position).getProgress());
        person.setText(getDataList().get(position).getCusername());
        day.setText(getDataList().get(position).getTimeInfo());

        //置顶：
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=mOnSwipeListener){
                    mOnSwipeListener.onTop(position);
                }

            }
        });
    }

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);

        void onTop(int pos);
    }

    private onSwipeListener mOnSwipeListener;

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }


}

