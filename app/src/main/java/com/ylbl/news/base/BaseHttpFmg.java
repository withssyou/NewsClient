package com.ylbl.news.base;

import com.ylbl.news.bean.ResultInfo;
import com.ylbl.news.utils.ToastUtils;
import com.ylbl.news.net.AppDbCtrl;
import com.ylbl.news.net.BaseCallback;
import com.zhy.http.okhttp.callback.Callback;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;

public abstract class BaseHttpFmg extends BaseFmg{
    protected boolean isShowLoad = true;


    protected BaseCallback callback = new BaseCallback() {

        @Override
        public void onBefore(Request request, int id) {
            if (isShowLoad) {
//                CommonProgressUtil.showProgcessBar(context);
            }
//            Log.i("TAG" , request.body().toString());
        }

        @Override
        public void onAfter(int id) {
            if (isShowLoad) {
//                CommonProgressUtil.closeProgcessBar();
            }
        }
        @Override
        public void onError(Call call, final Exception e, final int asyncid) {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ToastUtils.toastShort(context,e.getMessage());
                    try {
                        onPostExecuteTaskError(asyncid, e);
                    } catch (Exception e) {
                        ToastUtils.toastShort(context,e.getMessage());
                    }
                }
            });
        }

        @Override
        public void onResponse(final ResultInfo resultInfo, final int asyncid) {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (resultInfo == null) {
                        ToastUtils.toastShort(context,"请求返回为空");
                        onPostExecuteTaskError(asyncid, new Exception("请求返回为空"));
                        return;
                    }
                    try {
                        onPostExecuteTask(asyncid, resultInfo);
                    } catch (Exception e) {
                        ToastUtils.toastShort(context , e.getMessage());
                    }
                }
            });
        }

    };


    /**
     * @param asyncid 同步方法唯一ID，不可缺少
     * @param params  参数
     * @return
     */
    protected void newAsyncTaskExecute(final int asyncid, Map params) {
//        try {
        doInBackgroundTask(asyncid, params, callback);
//        } catch (Exception e) {
//            ToastUtils.toastShort(context , e.getMessage());
//        }
    }

//    /**
//     * @param asyncid 同步方法唯一ID，不可缺少
//     * @param params  参数
//     * @return
//     */
//    protected void newAsyncTaskExecute(final int asyncid, Object... params) {
//        try {
//            doInBackgroundTask(asyncid, params, callback);
//        } catch (Exception e) {
//            ToastUtils.toastShort(context , e.getMessage());
//
//        }
//    }
    /**
     * @param asyncid 同步方法唯一ID，不可缺少
     * @param params  参数
     * @return
     */
    protected void newAsyncTaskExecute(final int asyncid, Callback callback, Map params) {
        try {
            doInBackgroundTask(asyncid, params, callback);
        } catch (Exception e) {
            ToastUtils.toastShort(context , e.getMessage());
        }
    }

    protected void onPostExecuteTask(final int asyncid, ResultInfo resultInfo) {
    }

    protected void onPostExecuteTaskError(final int asyncid, Exception e) {
    }

    protected void doInBackgroundTask(final int asyncid, Map params, Callback callback) {
        AppDbCtrl.doServer(asyncid, params, callback ,getContext());
    }

}
