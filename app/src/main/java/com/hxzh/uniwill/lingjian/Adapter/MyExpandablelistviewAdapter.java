package com.hxzh.uniwill.lingjian.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.base.MyApplication;
import com.hxzh.uniwill.lingjian.bean.Data_tianjiazerenren;

import java.util.List;

/**
 * Created by pang on 2017/4/8.
 *  责任人adapter
 */
public class MyExpandablelistviewAdapter extends BaseExpandableListAdapter {
    private List<Data_tianjiazerenren.ResultBean> groupArray;
    private Context mContext;
    public String username,url;
    private GroupHolder holder1;
    private ChildHolder holder2;


//    // 存储所有章中的所有ImageView
//    private HashMap<String, HashMap<String, ImageView>> chapterMap = new HashMap<>();
//    // 存储一章中所有的ImageView
//    private HashMap<String, ImageView> sectionMap;
//    // 判断是否点击的标识
//   private int[][] tags;

    public MyExpandablelistviewAdapter(Context context, List<Data_tianjiazerenren.ResultBean> groupArray){
        mContext = context;
        this.groupArray = groupArray;
    }

    //  获得父项的数量
    @Override
    public int getGroupCount() {

        return groupArray.size();
    }
    //  获得某个父项的子项数目
    @Override
    public int getChildrenCount(int groupPosition) {

//        return childArray.get(groupPosition).size();
        return groupArray.get(groupPosition).getList().size();
    }
    //  获得某个父项
    @Override
    public Object getGroup(int groupPosition) {

        return groupArray.get(groupPosition);
    }
    //  获得某个父项的某个子项
    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return groupArray.get(groupPosition).getList().get(childPosition);
    }
    //  获得某个父项的id
    @Override
    public long getGroupId(int groupPosition) {

        return groupPosition;
    }
    //  获得某个父项的某个子项的id
    @Override
    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }
    //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
    @Override
    public boolean hasStableIds() {
        return false;
    }
    //  获得父项显示的view
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        View view = convertView;
         holder1 = null;

        if(view == null){
            holder1 = new GroupHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.expandablelistview, null);
            holder1.groupName = (TextView)view.findViewById(R.id.group_name);
            holder1.arrow = (ImageView)view.findViewById(R.id.duihao);//勾选
            holder1.arrow2 = (ImageView) view.findViewById(R.id.group_arr);
            view.setTag(holder1);
        }else{
            holder1 = (GroupHolder)view.getTag();
        }

        //判断是否已经打开列表
        if(isExpanded){
            holder1.arrow.setVisibility(View.VISIBLE);
            holder1.arrow2.setVisibility(View.INVISIBLE);
        }else{
            holder1.arrow.setVisibility(View.INVISIBLE);
            holder1.arrow2.setVisibility(View.VISIBLE);
        }
        String bumen_name = groupArray.get(groupPosition).getDeptname();//设置部门姓名
        holder1.groupName.setText(bumen_name);

        return view;
    }
    //  获得子项显示的view
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

        View view = convertView;
         holder2 = null;
        if(view == null){
            holder2 = new ChildHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.expandablelistview_item, null);
            holder2.username = (TextView)view.findViewById(R.id.username_text);
            holder2.touxiang = (ImageView) view.findViewById(R.id.touxiang);
            holder2.arrow3 = (ImageView) view.findViewById(R.id.duihao8);
            holder2.arrow4 = (ImageView) view.findViewById(R.id.duihao2);//勾选
            view.setTag(holder2);
        }else{
            holder2 = (ChildHolder)view.getTag();
        }
        username = groupArray.get(groupPosition).getList().get(childPosition).getUsername();
        url = groupArray.get(groupPosition).getList().get(childPosition).getAvatar();//图片链接
        holder2.username.setText(username);
        Glide.with(MyApplication.mcontext).load(url).into(holder2.touxiang);//加载图片

        return view;
    }
    //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
    @Override
    public boolean isChildSelectable(final int groupPosition, final int childPosition) {


        return true;
    }

    class GroupHolder{
        public TextView groupName;
        public ImageView arrow;
        public ImageView arrow2;
    }

    class ChildHolder{
        public TextView username;
        public ImageView touxiang;
        public ImageView arrow3;
        public ImageView arrow4;
    }
}
