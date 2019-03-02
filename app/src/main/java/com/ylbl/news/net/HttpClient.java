package com.ylbl.news.net;

import android.content.Context;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.Map;

import static com.ylbl.news.net.Constants.BASE_URL;


public class HttpClient {
    /**
     * 登录服务
     *
     * @param asyncid
     * @param params
     * @param callback
     */
    public static void login(int asyncid, Map params, Callback callback) {
        OkHttpUtils
                .post()
                .url(BASE_URL +params.get("url"))
                .id(asyncid)
                .params(params)
                .build()
                .execute(callback);
    }
    /**
     * 请求服务
     *
     * @param asyncid
     * @param params
     * @param callback
     */
    public static void doPost(int asyncid, Map params, Callback callback , Context context) {
        OkHttpUtils
                .post()
                .url(BASE_URL + params.get("url"))
                .id(asyncid)
                .params(params)
                .build()
                .execute(callback);

    }

    /**
     * get请求
     * @param asyncid
     * @param params
     * @param callback
     */
    public static void doGet(int asyncid, Map<String ,String> params, Callback callback , Context context) {
        OkHttpUtils
                .get()
                .url(BASE_URL)
                .id(asyncid)
                .params(params)
                .build()
                .execute(callback);
    }
//    /**
//     * get请求
//     * @param asyncid
//     * @param params
//     * @param callback
//     */
//    public static void doPageGet(int asyncid, Map<String ,String> params, Callback callback , Context context) {
//        String token = SpUtils.getToken(context);
//        if (TextUtils.isEmpty(token)){
//            ToastUtils.toastShort(context , "登录过期，请重新登录");
//            return;
//        }
//        OkHttpUtils
//                .get()
//                .url(BASE_URL + Constants.CASH_LOG)
//                .id(asyncid)
////                .addHeader("Authorization" , token)
//                .addParams("pageNum" , "1")
//                .addParams("pageSize" , "10")
//                .build()
//                .execute(callback);
//    }
}
