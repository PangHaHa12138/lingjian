package com.hxzh.uniwill.lingjian.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.hxzh.uniwill.lingjian.Adapter.MyExpandablelistviewAdapter2;
import com.hxzh.uniwill.lingjian.R;
import com.hxzh.uniwill.lingjian.base.MessageEventOA2;
import com.hxzh.uniwill.lingjian.base.MessageEventOA3;
import com.hxzh.uniwill.lingjian.bean.Data_OAshenpiType;
import com.hxzh.uniwill.lingjian.http.Http_Api;
import com.hxzh.uniwill.lingjian.utils.JsonUtil;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.SharedPreferencesUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Response;

/**
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 *
 * @ClassName: ShenQingType
 * @PackageName: com.hxzh.uniwill.lingjian.Activity
 * @Create On 2017/7/14 14:21
 * @Author: PangHaHa12138
 * @CSDN: http://blog.csdn.net/panghaha12138
 * @GitHub: https://github.com/PangHaHa12138
 * @jianshu: http://www.jianshu.com/u/4e577623e3f8
 * @Copyrights 2017/7/14 PangHaHa12138 All rights reserved.
 *   申请审核类型
 */
public class ShenQingType extends BaseToobarActivity {

    private ExpandableListView expandableListView;
    private Button surebut;
    private String userid,url = "http://192.167.1.22:8080/Server/bill/selectWork.do";
    private Data_OAshenpiType oAshenpiType;
    private List<Data_OAshenpiType.ResultBean> typelist = new ArrayList<>();
    private ImageView duihao,duihao8;
    private String add_name,add_userid;
    private Map<Integer,String> namemap = new HashMap();
    private Map<Integer,String> useridmap = new HashMap();
    private Set<String> nameset = new HashSet<>();
    private MyExpandablelistviewAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText("审批类型");
       getToobarRightTitle().setText("");

        initview();
        initdata();
    }

    private void initdata() {
        userid = SharedPreferencesUtil.readUserid(ShenQingType.this);

        try {
            OkHttpUtils.get(Http_Api.URL_GOngdantype)
                    .params("userid",userid)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            LogUtil.d("json=>===>",s+"");
                            oAshenpiType = JsonUtil.parseJsonToBean(s,Data_OAshenpiType.class);
                            if (oAshenpiType.getResult()!=null){

                                typelist = oAshenpiType.getResult();
                                 adapter2 = new MyExpandablelistviewAdapter2(ShenQingType.this,typelist);
                                expandableListView.setAdapter(adapter2);
                            }else {
                                ToastUtil.showToast("没有数据");
                            }

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        expandableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                        int childPosition, long id) {


                add_name= typelist.get(groupPosition).getList().get(childPosition).getWokertype();
                add_userid = typelist.get(groupPosition).getList().get(childPosition).getWorkid();
                LogUtil.d("typeid=====>",add_userid+"");

                for (int i = 0; i < typelist.size(); i++) {
                    for (int j = 0; j < typelist.get(groupPosition).getList().size(); j++) {
                        typelist.get(groupPosition).getList().get(j).setIsSelect(1);
                    }
                }

                typelist.get(groupPosition).getList().get(childPosition).setIsSelect(2);
                adapter2.notifyDataSetChanged();
//                for (int i = 0; i < typelist.get(groupPosition).getList().size(); i++) {
//                        adapter2.setunselectchild();
//                }

//                duihao = (ImageView) v.findViewById(R.id.duihao2);
//                duihao8 = (ImageView) v.findViewById(R.id.duihao8);
//
//                duihao.setVisibility(View.VISIBLE);
//                duihao8.setVisibility(View.INVISIBLE);

//                if (duihao.getVisibility()==View.INVISIBLE){
//                    duihao.setVisibility(View.VISIBLE);
//                    duihao8.setVisibility(View.INVISIBLE);
//                }else if (duihao.getVisibility() == View.VISIBLE){
//                    duihao.setVisibility(View.INVISIBLE);
//                    duihao8.setVisibility(View.VISIBLE);
//                }
//                if (duihao.getVisibility() == View.VISIBLE){
//                    namemap.put(childPosition,add_name);
//                    nameset.add(add_name);
//                    useridmap.put(childPosition,add_userid);
//                }

                return true;
            }
        });



        surebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().post(new MessageEventOA3(add_name));
                EventBus.getDefault().post(new MessageEventOA2(add_userid));

                finish();

            }
        });
    }

    private void initview() {

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        surebut = (Button) findViewById(R.id.addtype_button);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.shenqingtype;
    }
}
