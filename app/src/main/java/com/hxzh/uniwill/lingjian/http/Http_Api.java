package com.hxzh.uniwill.lingjian.http;

/**
 *  服务器地址
 */
public class Http_Api {
    //   http://123.56.97.229:6080  外网正式地址
    //  http://192.167.1.36:8080  内网测试地址
    //  http://192.167.1.6:8080  刘哲本地测试地址
    //  http://192.167.1.22:8080

    public static final String URL_SERVER = "http://123.56.97.229:6080/Server";

    //登录
    public static final String URL_denglu = URL_SERVER+"/user/login.do";//get

    public static final String URL_photo_get = URL_SERVER +"/avatar/get.do";//get

    // 注册
    public static final String URL_zhuce = URL_SERVER+"/user/add.do";// POST
    // 个人中心修改
    public static final String URL_gerenzhongxinxiugai = URL_SERVER+"/user/update.do"; // POST
    // 删除
    public static final String URL_delete = URL_SERVER+"/user/remove.do" ;// GET
    // 密码重置
    public static final String URL_mimachongzhi =URL_SERVER+ "/user/sendMaile.do" ;// POST
    // 登出
    public static final String URL_dengchu = URL_SERVER+"/user/logout.do" ;//get
    // 通讯录
    public static final String URL_tongxunlu = URL_SERVER+"/user/contact.do"; // GET
    // 用户是否登陆
    public static final String URL_islogin = URL_SERVER+"/user/islogin.do"; // GET
    // 修改密码
    public static final String URL_xiugaimima = URL_SERVER+"/user/modifypwd.do"; // get
    //忘记密码
    public static final String URL_wangjimima = URL_SERVER + "/user/sendMaile.do";//get
    // 添加联系人
    public static final String URL_tianjialianxiren = URL_SERVER+"/user/addcontact.do"; // get
    // 删除联系人
    public static final String URL_shanchulianxiren =URL_SERVER+ "/user/delcontact.do"; // GET
    // 设置管理员
    public static final String URL_setadmin = URL_SERVER+"/user/setadmin.do"; // get
    // 获取已经设置的管理员
    public static final String URL_getadmin = URL_SERVER+"/user/getadmin.do" ;// get
    // 导入通讯录联系人
    public static final String URL_daochutongxunlulianxiren = URL_SERVER+"/user/exportcontact.do" ;// GET
    // 获取登陆者所管理的公司/部门
    public static final String URL_huoqudengluzhesuoguanlibumen = URL_SERVER+"/user/manageDept.do"; // get
    // 获取登录者管辖部门
    public static final String URL_huoqudengluguanxiabumen = URL_SERVER+"/department/listforleader.do" ;// get


    // 任务下发，创建，拆分
    public static final String URL_renwuxiafa = URL_SERVER+"/task/create.do" ;// POST
    // 任务更新，获得返回状态
    public static final String URL_renwugenxin= URL_SERVER+"/task/update.do"; // POST
    // 任务状态更新 : 缓慢=1 停滞=2 正常=3 完成=4 撤销=5 暂停=6
    public static final String URL_renwuzhuangtai =URL_SERVER+ "/task/updatestatus.do" ;// POST
    // 查询列表(我接收到的任务) - 待办任务界面 // 6：暂停  4 :已办
    public static final String URL_chaxun_jiehsourenwu= URL_SERVER+"/task/recevielist.do" ;// GET
    // 查询列表(我发出的任务) 下发任务
    public static final String URL_chaxun_fachurenwu=URL_SERVER+ "/task/sendlist.do" ;// GET
    // 查询列表(部门接收到的任务)
    public static final String URL_chaxun_bumenjishourenwu= URL_SERVER+"/task/deptrecevielist.do" ;// POST
    // 查询列表(部门发出的任务)
    public static final String URL_chaxun_bumenfachurenwu= URL_SERVER+"/task/deptsendlist.do" ;// GET
    // 任务统计
    public static final String URL_renwutongji = URL_SERVER+" /task/statistic.do"; // GET
    // 获取任务详情
    public static final String URL_renwuxiangqing= URL_SERVER+"/task/detail.do" ;// GET
    // 取消置顶
    public static final String URL_quxiaozhiding= URL_SERVER+"/task/stickieDelete.do";


    // 获取子任务列表
    public static final String URL_huoquzirenwu= URL_SERVER+"/task/childtask.do" ;// GET
    // 任务检索
    public static final String URL_renwusousu= URL_SERVER+" /task/search.do" ;// GET
    // 收到的未完成任务
    public static final String URL_weiwancheng= URL_SERVER+"/task/revprocessing.do"; // GET
    // 置顶
    public static final String URL_zhiding=URL_SERVER+ "/task/stickieService.do" ;// POST

    // 责任人
    public static final String URL_zerenren= URL_SERVER+"/user/underling.do" ;// GET
    //待办-上报
    public static final String URL_renwushangbao = URL_SERVER+"/task/report.do";//get
    //添加责任人
    public static final String URL_tianjiazerenren = URL_SERVER+"/user/contactnew.do";//get

    //子任务上传
    public static final String URL_zirenwushangbao = URL_SERVER + "/task/create.do";//post

    //已办任务
    public static final String URL_yibanrenwu = URL_SERVER +"/task/allfinishedlist.do";//get
    //撤销任务
//    public static final String URL_chexiaorenwu = URL_SERVER + "/task/allcancellist.do";//get
    public static final String URL_chexiaorenwu = URL_SERVER + "/task/sendlist.do";//get
    //子任务详情页 查询任务消息列表
    public static final String URL_zirenwu_deatil = URL_SERVER + "/message/taskmsg.do";//get
    //头像获取地址
    public static final String URL_yonghutouxiang = URL_SERVER +"/avatar/get.do";//get
    //头像上传地址
    public static final String URL_photoUpload = URL_SERVER +"/importfile/uploadown.do";//post
    //用户详情页
    public static final String URL_yonghu_detail = URL_SERVER+ "/user/detail.do";//get
    //附件上传
    public static final String URL_Fujian_upload = URL_SERVER + "/task/upload.do";//post
    //个人待办统计
    public static final String URL_Tubiao = URL_SERVER + "/task/selectUserCount1.do";//post
    //下发统计
    public static final String URL_Tubiao2 = URL_SERVER + "/task/selectUserCount.do";//post
    //部门统计
    public static final String URL_BuMen = URL_SERVER + "/task/selectDeptCount.do";//post
    //部门下发
    public static final String URL_BumenXiafa = URL_SERVER + "/task/selectDeptSendCount.do";//post
    //人员统计
    public static final String URL_PersonTongji = URL_SERVER + "/task/selectDeptUserCount.do";//post
    //部门人员下发
    public static final String URL_PersonXiafa = URL_SERVER + "/task/selectDeptUserSendCount.do";//post

    //判断是否是领导 0 中层领导 1 大领导
    public static final String URL_IsLead = URL_SERVER +"/task/selectLeader.do";//post
    //未读
    public static final String URL_Weidu = URL_SERVER +"/message/listCount.do";//get
    //版本更新
    public static final String URL_UpdataVersion = URL_SERVER +"/user/version.do";//get
    //发送消息
    public static final String URL_NewSend = URL_SERVER + "/news/create.do";//post
    //接收消息
    public static final String URL_NewReceiver = URL_SERVER + "/news/selectNews.do";//get

    //下发附件
    public static final String URL_XiafaFujian = URL_SERVER + "/task/selectUpload.do";//post
    //共享文件
    public static final String URL_GongXiangWJ = URL_SERVER + "/file/selectFile.do";//post
    //新建工单
    public static final String URL_Gongdan_Create = URL_SERVER + "/bill/create.do";//post
    //工单类型
    public static final String URL_GOngdantype = URL_SERVER + "/bill/selectWork.do";//post
    //工单附件上传
    public static final String URL_GongdanFileUpload = URL_SERVER + "/bill/uploadFile.do";//post
    //工单查询 申请列表
    public static final String URL_GongdanSelect = URL_SERVER + "/bill/selectBill.do";//post
    //工单审批  审批列表
    public static final String URL_GongdanShenPi = URL_SERVER + "/bill/selectBillSed.do";//post
    //申请置顶
    public static final String URL_ShenQingzhiding = URL_SERVER + "/bill/insertSt.do";//post
    //申请取消置顶
    public static final String URL_ShenQingquxiaozhiding = URL_SERVER + "/bill/deleteSt.do";//post
    //删除 修改
    public static final String URL_ShenQingdelete = URL_SERVER + "/bill/update.do";//post
    //申请详情页
    public static final String URL_ShenQingdetile = URL_SERVER + "/bill/selectBillView.do";//post
    //审核进度
    public static final String URL_Shenhejindu = URL_SERVER + "/bill/selectExamine.do";//post
    //审核提交
    public static final String URL_shenhetijiao = URL_SERVER + "/bill/inserExamine.do";//post


}
