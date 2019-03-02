package com.ylbl.news.net;

import android.content.Context;

import com.zhy.http.okhttp.callback.Callback;

import java.util.Map;

public class AppDbCtrl {
    /**
     * 调用登录
     *
     * @param callback 回调
     */
    public static void appLogin(int asyncid, Map params, Callback callback) {
        HttpClient.login(asyncid, params, callback);
    }
    /**
     *  post请求服务
     * @param asyncid
     * @param params
     * @param callback
     */
    public static void doServer(int asyncid, Map params, Callback callback , Context context) {
        HttpClient.doPost(asyncid, params, callback ,context);
    }

    /**
     *  get请求服务
     * @param asyncid
     * @param params
     * @param callback
     */
    public static void getServer(int asyncid, Map params, Callback callback ,Context context){
        HttpClient.doGet(asyncid ,params,callback ,context);
    }

}
