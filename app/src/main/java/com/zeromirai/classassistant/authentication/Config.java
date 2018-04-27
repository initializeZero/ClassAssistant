package com.zeromirai.classassistant.authentication;

/**
 * Created by initialize on 2018/4/26.
 */

public class Config {
    public static final String BASEAPI = "http://127.0.0.1";

    public static final String API_LOGIN = BASEAPI + "/userlogin";
    public static final String API_REG = BASEAPI + "/userreg";

    public static final String ERRMSG_XXX = "(EN)Isn’t there a B number in your heart that throws this kind of exception?\n(JP)この種の例外をスローするBナンバーはあなたの心にありますか？\n(CN)抛这种异常你心里没有B数吗?";

    public static final String[] ERRMSG_REG = {
            "成功",
            "请求参数有误",
            "网络请求失败",
            "数据解析失败",
            "信息构造有误",
            "数据缓存失败",
            "",
            ""
    };
    public static final String[] ERRMSG_LOGIN = {
            "成功",
            "请求参数有误",
            "网络请求失败",
            "数据解析失败",
            "信息构造有误",
            "数据缓存失败",
            "",
            ""
    };
}
