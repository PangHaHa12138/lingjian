//package com.hxzh.uniwill.lingjian.Adapter;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.hxzh.uniwill.lingjian.R;
//import com.hxzh.uniwill.lingjian.View.PercentCircle;
//import com.hxzh.uniwill.lingjian.base.MyApplication;
//import com.hxzh.uniwill.lingjian.utils.ToastUtil;
//
///**
// * Created by pang on 2017/3/28.
// */
//public class ListviewHolder extends BaseHolder {
//    private PercentCircle percentCircle;//百分比圆环
//    private TextView renwu_text;//任务名
//    private TextView faburen_text;//发布人
//    private TextView day_num_text;//天数
//
//    private ImageView zhiding;//置顶
//    private ImageView chexiao;//撤销
//    private ImageView zhanting;//暂停
//    private ImageView delete;//删除
//
//    @Override
//    protected void refreshView(Object data) {
//
//        percentCircle.setTargetPercent(70);//设置百分比
//        renwu_text.setText(R.string.renwu_name);
//        faburen_text.setText(R.string.faburen);
//        day_num_text.setText(R.string.day_num);
//
//        zhanting.setClickable(true);
//        chexiao.setClickable(true);
//        zhiding.setClickable(true);
//        delete.setClickable(true);
//
//        zhiding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showToast("置顶");
//            }
//        });
//        chexiao.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showToast("撤销");
//
//            }
//        });
//        zhanting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showToast("暂停");
//
//            }
//        });
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showToast("删除");
//
//            }
//        });
//
//    }
//
//    @Override
//    protected View initView() {
//        View view = View.inflate(MyApplication.context, R.layout.listview_daiban_item,null);
//        percentCircle = (PercentCircle) view.findViewById(R.id.Circle);
//        renwu_text = (TextView) view.findViewById(R.id.text_title_list);
//        faburen_text = (TextView) view.findViewById(R.id.text_persion_list);
//        day_num_text = (TextView) view.findViewById(R.id.text_time_list);
//        zhiding = (ImageView) view.findViewById(R.id.zhiding);
//        chexiao = (ImageView) view.findViewById(R.id.chexiao_list_item_right);
//        zhanting = (ImageView) view.findViewById(R.id.stop);
//        delete = (ImageView) view.findViewById(R.id.delete);
//
//
//        return view;
//    }
//}
