package com.speedata.uhf;

public class Api {
    public static String ossurl = "https://back-green.oss-cn-beijing.aliyuncs.com/";
//    public static String apiurl = "http://39.107.70.80:8080/treeFront/merchant/";
    public static String apiurl = "http://47.93.224.76:8080/treeFront/merchant/";
    //登录
    public static String login = apiurl+"userLogin";
    //消息中心
    public static String messages = apiurl+"getTreePlan";
    //查询种植人头像和植物生长状态
    public static String state_peoson = apiurl+"getTreeOwnerPhoto";
    //植物信息
    public static String zhiwu_info = apiurl+"getTree";
    //种植情况
    public static String zhongzhi_state = apiurl+"getTreeInfo";
    //养护记录
    public static String yanghujilu = apiurl+"getTreeHistory";
    //审批记录
    public static String shenpijiliu = apiurl+"getApproveRecord";
    //产地信息
    public static String chandixinxi = apiurl+"getTreeProduce";
    //上传植物照片
    public static String uptreeimg = apiurl+"updateTreeImg";
    //查询
    public static String selectwork = apiurl+"getTreeConservationPlan";
    //开始作业
    public static String starwork = apiurl+"startTreeConservationPlan";
    //结束作业
    public static String stopwork = apiurl+"stopTreeConservationPlan";
    //种植人头像旁四张图片
    public static String fourimg = apiurl+"getTreeImg";
    //根据rfid查区块编号
    public static String selectrfid = apiurl+"getBlockCode";

}
