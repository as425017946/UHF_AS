package com.speedata.uhf;

public class Api {
    public static String ossurl = "https://jiaoyuvideo.oss-cn-beijing.aliyuncs.com/";
    public static String apiurl = "http://39.107.70.80:8080/treeFront/merchant/";
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

}
