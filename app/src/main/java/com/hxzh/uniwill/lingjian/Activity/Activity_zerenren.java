package com.hxzh.uniwill.lingjian.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxzh.uniwill.lingjian.Adapter.MyExpandablelistviewAdapter;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.base.MessageEvent;
import com.hxzh.uniwill.lingjian.base.MessageEvent5;
import com.hxzh.uniwill.lingjian.bean.Data_tianjiazerenren;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by pang on 2017/4/7.
 *  选择责任人 联系人
 */
public class Activity_zerenren extends BaseToobarRightViewActivity{

    private String userid,leadid,add_name,finname,add_userid;
    private String add_idlist = "";
    private String zerenreID;
    private List<Data_tianjiazerenren.ResultBean> list;
    private Data_tianjiazerenren tianjiazerenren;
    private ExpandableListView expandableListView;
    private MyExpandablelistviewAdapter myExpandablelistviewAdapter;

    private Button add_people_button;
    private EditText sousu;//搜素输入文本
    private String sou_name;
    private ImageView duihao,duihao8;
    private Map<Integer,String> namemap = new HashMap();
    private Map<Integer,String> useridmap = new HashMap();
    private Set<String> nameset = new HashSet<>();
    private TextView search_people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getToolbarTitle().setText("选择责任人");
//        getToobarRightView().setImageResource();

        initView();
        initData();


    }
    private void initView() {

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        add_people_button = (Button) findViewById(R.id.add_zerenren_button);
        sousu = (EditText) findViewById(R.id.sousu_zerenren);
        sou_name = sousu.getText().toString().trim();
        search_people = (TextView) findViewById(R.id.search_people);

    }
    private void initData() {
        userid = SharedPreferencesUtil.readUserid(Activity_zerenren.this);
        leadid = SharedPreferencesUtil.readLeaderid(Activity_zerenren.this);

        LogUtil.d("userid------",userid);
        LogUtil.d("leadid-------",leadid);
       new Thread(){
           @Override
           public void run() {
               OkHttpUtils.get(Http_Api.URL_tianjiazerenren)
                       .params("userid",userid)
                       .params("leaderid",leadid)
                       .execute(new StringCallback() {
                           @Override
                           public void onSuccess(String s, Call call, Response response) {
                               LogUtil.d("责任人-----",s+"");
                               tianjiazerenren = JsonUtil.parseJsonToBean(s,Data_tianjiazerenren.class);
                               list = tianjiazerenren.getResult();
//
                               myExpandablelistviewAdapter =
                                       new MyExpandablelistviewAdapter(Activity_zerenren.this,list);
                               expandableListView.setAdapter(myExpandablelistviewAdapter);
//                               expandableListView.expandGroup(0);//默认打开第一条

                           }

                           @Override
                           public void onError(Call call, Response response, Exception e) {
                               super.onError(call, response, e);
                               ToastUtil.showToast("联网失败，无法获取联系人");
                           }
                       });
           }
       }.start();

        search_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("功能未完善");
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                        int childPosition, long id) {
                add_name= list.get(groupPosition).getList().get(childPosition).getUsername();
                add_userid = list.get(groupPosition).getList().get(childPosition).getUserid();
                duihao = (ImageView) v.findViewById(R.id.duihao2);
                duihao8 = (ImageView) v.findViewById(R.id.duihao8);
                if (duihao.getVisibility()==View.INVISIBLE){
                    duihao.setVisibility(View.VISIBLE);
                    duihao8.setVisibility(View.INVISIBLE);
                }else if (duihao.getVisibility() == View.VISIBLE){
                    duihao.setVisibility(View.INVISIBLE);
                    duihao8.setVisibility(View.VISIBLE);
                }
                if (duihao.getVisibility() == View.VISIBLE){
                    namemap.put(childPosition,add_name);
                    nameset.add(add_name);
                    useridmap.put(childPosition,add_userid);
                }

                return true;
            }
        });

        add_people_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                expandableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        duihao.setVisibility(View.VISIBLE);
                        duihao8.setVisibility(View.INVISIBLE);
                    }
                });

                for (Integer postion : useridmap.keySet()) {
                    //map.keySet()返回的是所有key的值
                    add_idlist += useridmap.get(postion)+";";//得到每个key多对用value的值

                }
                zerenreID = removeSameString(add_idlist);
                //存id
                SharedPreferencesUtil.writeAdd_userid(zerenreID,Activity_zerenren.this);
                SharedPreferencesUtil.writeAdd_userid1(zerenreID,Activity_zerenren.this);
                SharedPreferencesUtil.writeAdd_userid2(zerenreID,Activity_zerenren.this);
                SharedPreferencesUtil.writeAdd_userid3(zerenreID,Activity_zerenren.this);
                SharedPreferencesUtil.writeAdd_userid4(zerenreID,Activity_zerenren.this);
                //点击选中的名字
//                    EventBus.getDefault().post(new MessageEvent(namemap));
                    EventBus.getDefault().post(new MessageEvent5(nameset));
                    EventBus.getDefault().post(new MessageEvent(useridmap));
                finish();

            }
        });

    }
    /**
     * 去掉重复字符串
     * @param str
     * @return String
     * */
    public  String removeSameString(String str){
        Set<String> mLinkedSet = new LinkedHashSet<String>();
        String[] strArray = str.split(";");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strArray.length; i++)
        {
            if (!mLinkedSet.contains(strArray[i]))
            {
                mLinkedSet.add(strArray[i]);
                sb.append(strArray[i] + ";");
            }else{
                System.out.println("重复字符:"+strArray[i]);
            }
        }
//        System.out.println(mLinkedSet);
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zerenren;
    }
}
