package com.hxzh.uniwill.lingjian.fragment;

/***
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
 * <p>
 * Created by PangHaHa12138 on 2017/6/12.
 */
public class FragmentFactory {

    static FragmentFactory mInstance;

    public static FragmentFactory getInstance() {
        if (mInstance == null) {
            synchronized (FragmentFactory.class) {
                if (mInstance == null) {
                    mInstance = new FragmentFactory();
                }
            }
        }
        return mInstance;
    }

    private OA_centerfragment oa_centerfragment;

    public OA_centerfragment getOAFragment() {
        if (oa_centerfragment == null) {
            synchronized (FragmentFactory.class) {
                if (oa_centerfragment == null) {
                    oa_centerfragment = new OA_centerfragment();
                }
            }
        }
        return oa_centerfragment;
    }
}
